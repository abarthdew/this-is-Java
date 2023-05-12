import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReceiveExam {
    public static void main(String[] args) throws Exception {
        
        DatagramSocket datagramSocket = new DatagramSocket(5001);

        // 스레드를 생성해 받음: 데이터를 받기 위해서 가능하면 스레드를 생성해 받는 게 좋음
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("수신 시작: ");
                try {
                    while(true) {
                        DatagramPacket packet = new DatagramPacket(new byte[100], 100);
                        datagramSocket.receive(packet); // receive()는 데이터를 받고 나서 packet 안에 있는 배열에 데이터를 저장
                        
                        // 받은 데이터를 문자열로 변환
                        String data = new String(packet.getData(), 0, packet.getLength(), "UTF-8");
                        // packet.getData(): packet 안에 있는 데이터
                        // 0, packet.getLength(): 0 인덱스 부터 받은 byte 수 만큼만
                        // packet.getLength(): packet으로 실제로 받은 byte 수
                        // UTF-8 문자열로 변환

                        System.out.println("받은 내용: " + packet.getSocketAddress() + data);
                    }
                } catch(Exception e) {
                    System.out.println("수신 종료");
                }
            };
        };

        thread.start(); // 스레드 시작 -> 수신 준비 끝

        // 무한정 수신을 할 수 없기 떄문에, 10초 뒤 수신 종료
        Thread.sleep(10000); // 10초 동안 스레드 대기
        datagramSocket.close();
        // 10 초 후 닫히면, 위 receive() 메서드에서 예외가 발생 -> while 문 빠져나감
    }
}
