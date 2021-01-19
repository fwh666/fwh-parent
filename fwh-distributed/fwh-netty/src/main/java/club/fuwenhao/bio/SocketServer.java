package club.fuwenhao.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author fwh
 * @email fuwenhao594@163.com
 * @date 2021/1/19 11:00 上午
 */
public class SocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        while (true) {
            System.out.println("等待连接");
            final Socket clientAccept = serverSocket.accept();
            System.out.println("有客户端连接了……");
            handler(clientAccept);
        }
    }

    /**
     * 处理连接
     *
     * @param clientSocket
     * @return void
     * @author fwh [2021/1/19 && 11:04 上午]
     */
    private static void handler(Socket clientSocket) throws IOException {
        final byte[] bytes = new byte[1024];
        System.out.println("准备中……");
        //接收客户端的数据，阻塞方法，没有数据可读时就阻塞
        final int read = clientSocket.getInputStream().read(bytes);
        System.out.println("读取完毕……");
        if (read != -1) {
            System.out.println("接收到客户端的数据:" + new String(bytes, 0, read));
        }
        clientSocket.getOutputStream().write("HelloClient".getBytes());
        clientSocket.getOutputStream().flush();
    }
}
