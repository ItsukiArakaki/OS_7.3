import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

public class MulticastReceiver {
    public static void main(String[] args) {
        MulticastSocket socket = null;
        try {
            InetAddress group = InetAddress.getByName("マルチキャストグループのIPアドレス");
            int port = 12345; // マルチキャストポート番号

            SocketAddress socketAddress = new InetSocketAddress(group, port);

            socket = new MulticastSocket(socketAddress);
            socket.joinGroup(socketAddress, null); // You can pass null for the network interface

            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("受信: " + message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}
