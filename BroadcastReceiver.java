import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class BroadcastReceiver {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            int port = 12345; // ポート番号

            socket = new DatagramSocket(port);

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
