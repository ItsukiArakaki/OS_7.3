import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MulticastSender {
    public static void main(String[] args) {
        try {
            InetAddress group = InetAddress.getByName("マルチキャストグループのIPアドレス");
            int port = 12345; // マルチキャストポート番号

            DatagramSocket socket = new DatagramSocket();
            String message = "これはマルチキャストメッセージです。";

            byte[] data = message.getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length, group, port);

            socket.send(packet);
            System.out.println("メッセージを送信しました: " + message);

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

