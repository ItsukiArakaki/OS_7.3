import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class BroadcastSender {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            InetAddress broadcastAddress = InetAddress.getByName("255.255.255.255"); // ブロードキャストアドレス
            int port = 12345; // ポート番号

            socket = new DatagramSocket();
            socket.setBroadcast(true);

            String message = "これはブロードキャストメッセージです.";

            byte[] data = message.getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length, broadcastAddress, port);

            socket.send(packet);
            System.out.println("メッセージをブロードキャストしました: " + message);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}

