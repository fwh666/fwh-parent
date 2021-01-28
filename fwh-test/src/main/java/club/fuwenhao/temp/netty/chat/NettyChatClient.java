package club.fuwenhao.temp.netty.chat;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

/**
 * 1.创建事件组
 * 2.创建启动类
 * 2.1 设置组
 * 2.2 设置channel
 * 2.3 设置Handler
 * 2.3.1 加入编码器
 * 2.3.1 加入解码器
 * 2.3.1 加入自己的业务类
 * 3. 绑定端口
 * 4. 输入测试信息
 * 5. 关闭组
 *
 * @author fwh
 * @email fuwenhao594@163.com
 * @date 2021/1/21 3:48 下午
 */
public class NettyChatClient {
    public static void main(String[] args) {
        final NioEventLoopGroup eventExecutors = new NioEventLoopGroup();
        try {
            final Bootstrap bootstrap = new Bootstrap().group(eventExecutors).channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            final ChannelPipeline pipeline = socketChannel.pipeline();
                            //加入特殊分隔符分包解码器-发送的数据必须按规则才能解析出
                            pipeline.addLast(new DelimiterBasedFrameDecoder(1024, Unpooled.copiedBuffer("_".getBytes())));
                            //向pipeline加入解码器
                            pipeline.addLast("decoder", new StringDecoder());
                            //向pipeline加入编码器
                            pipeline.addLast("encoder", new StringEncoder());
                            //加入自己的业务处理handler
                            pipeline.addLast(new NettyChatClientHandler());
                        }
                    });
            final ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 9000).sync();
            final Channel channel = channelFuture.channel();
            System.out.println("========" + channel.localAddress() + "========");
            //客户端需要输入信息， 创建一个扫描器
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                String msg = scanner.nextLine();
                //通过 channel 发送到服务器端
                channel.writeAndFlush(msg);
            }
//        for (int i = 0; i < 200; i++) {
//            channel.writeAndFlush("hello，诸葛!" + "_");
//        }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            eventExecutors.shutdownGracefully();
        }

    }
}
