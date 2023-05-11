// ServerExam 실행을 위해 필요한 클래스

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientExam3 {
    public static void main(String[] args) {
        
        Socket socket = null;
        try {
            socket = new Socket(); // 소켓 생성
            System.out.println("연결 요청: ");
            socket.connect(new InetSocketAddress("localhost", 5001)); // 연결
            // connect() 메서드 실행 시, 해당 ip 주소에서 5001번에서 실행하고 있는 서버에 연결 요청을 하게 됨

            System.out.println("연결 성공: "); // 성공적으로 요청 실행이 되었을 경우

            // 서버로 데이터를 보내고 나서, 서버 쪽에서 보낸 데이터를 다시 받음
            InputStream is = socket.getInputStream();
            byte[] bytes = new byte[100];
            int readByteCount = is.read(bytes);
            String message = new String(bytes, 0, readByteCount, "UTF-8");
            System.out.println("데이터 받기 성공: " + message);

            is.close();
            // socket.close(); // 연결 끊기: 아래 socket을 닫는 if 코드가 있으므로 필요없음
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
