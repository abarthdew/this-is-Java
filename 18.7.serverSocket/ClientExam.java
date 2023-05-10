// ServerExam 실행을 위해 필요한 클래스

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientExam {
    public static void main(String[] args) {
        
        Socket socket = null;
        try {
            socket = new Socket(); // 소켓 생성
            System.out.println("연결 요청: ");
            socket.connect(new InetSocketAddress("localhost", 5001)); // 연결
            // connect() 메서드 실행 시, 해당 ip 주소에서 5001번에서 실행하고 있는 서버에 연결 요청을 하게 됨

            System.out.println("연결 성공: "); // 성공적으로 요청 실행이 되었을 경우
        } catch (IOException e) {
            e.printStackTrace();
        }  
        
        // 서버와 연결을 끊기 위한 코드
        if (!socket.isClosed()) {// 소켓이 닫혀있지 않다면(연결되어 있다면)
            try {
                socket.close();
            } catch(IOException e) {

            }

        }
    }
}
