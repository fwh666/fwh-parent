package club.fuwenhao.netty.chat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;

/**
 * @author fwh
 * @email fuwenhao594@163.com
 * @date 2021/1/21 3:47 下午
 */
public class NettyChatServerHandler extends SimpleChannelInboundHandler<String> {
    //GlobalEventExecutor.INSTANCE 是全局的事件执行器，是一个单例
    //channelGroup存放所有的channel信息
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 读取数据内容
     *
     * @param channelHandlerContext
     * @param msg
     * @return void
     * @author fwh [2021/1/28 && 10:37 上午]
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String msg) throws Exception {
        //得到channel
        final Channel channel = channelHandlerContext.channel();
        //这时我们遍历 channelGroup, 根据不同的情况， 回送不同的消息
        channelGroup.forEach(ch -> {
            if (channel != ch) { //不是当前的 channel,转发消息
                ch.writeAndFlush("[ 客户端 ]" + channel.remoteAddress() + " 发送了消息：" + msg + "\n" + "_");
            } else {//回显自己发送的消息给自己
                ch.writeAndFlush("[ 自己 ]发送了消息：" + msg + "\n");
            }
        });
    }

    /**
     * 表示channel处于就绪状态 提示上线
     *
     * @param ctx
     * @return void
     * @author fwh [2021/1/28 && 10:30 上午]
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        final Channel channel = ctx.channel();
        //将该客户加入聊天的信息推送给其他在线的客户端
        //该方法会将channelGroup中的所有channel遍历，并发送消息
        channelGroup.writeAndFlush("[ 客户端 ]" + channel.remoteAddress() + " 上线了 " + sdf.format(new java.util.Date()) + "\n");
        //将当前的channel加入到channelGroup
        channelGroup.add(channel);
        System.out.println(ctx.channel().remoteAddress() + " 上线了" + "\n");
    }

    /**
     * 表示channel处于不活动状态，离线了
     *
     * @param ctx
     * @return void
     * @author fwh [2021/1/28 && 10:33 上午]
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        final Channel channel = ctx.channel();
        //将客户离开信息推送给当前在线的客户
        channelGroup.writeAndFlush("[ 客户端 ]" + channel.remoteAddress() + " 下线了" + "\n");
        System.out.println(ctx.channel().remoteAddress() + " 下线了" + "\n");
        System.out.println("channelGroup size=" + channelGroup.size());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //异常-关闭通道
        ctx.close();
    }
}