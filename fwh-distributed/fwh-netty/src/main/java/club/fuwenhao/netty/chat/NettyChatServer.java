package club.fuwenhao.netty.chat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @author fwh
 * @email fuwenhao594@163.com
 * @date 2021/1/21 3:47 下午
 */
public class NettyChatServer {
    /**
     * 1.创建启动监听类
     * 1.1 初始化channel
     * 1.2 添加分包解码器
     * 1.3 添加编码器
     * 1.4 添加解码器
     * 1.5 添加自己的Handler
     * 2.绑定端口
     * 3.关闭通道
     * 4.finally关闭NIO事件类
     *
     * @param args
     * @return void
     * @author fwh [2021/1/21 && 3:55 下午]
     */
    public static void main(String[] args) {
        final NioEventLoopGroup boosGroup = new NioEventLoopGroup();
        final NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            final ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(boosGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            final ChannelPipeline pipeline = socketChannel.pipeline();
                            //加入特殊分隔符分包解码器
                            pipeline.addLast(new DelimiterBasedFrameDecoder(1024, Unpooled.copiedBuffer("_".getBytes())));
                            //向pipeline加入解码器
                            pipeline.addLast("decoder", new StringDecoder());
                            //向pipeline加入编码器
                            pipeline.addLast("encoder", new StringEncoder());
                            //加入自己的业务处理器Handler
                            pipeline.addLast(new NettyChatServerHandler());
                        }
                    });
            System.out.println("聊天室server启动……");
            //绑定端口
            final ChannelFuture channelFuture = serverBootstrap.bind(9000).sync();
            //关闭通道
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {

        } finally {
            boosGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
