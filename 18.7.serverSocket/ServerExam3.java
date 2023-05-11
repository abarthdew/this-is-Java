import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

// 서버 소켓을 생성하고, 클라이언트에서 소켓으로 연결 요청을 하는 코드

public class ServerExam3 {
    public static void main(String[] args) {
        
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress("localhost", 5001));

            while (true) {
                System.out.println("연결 기다림: ");
                Socket socket // 클라이언트의 연결 요청이 들어오면, accept()는 Socket이라는 통신용 객체를 만들고, 리턴함
                    = serverSocket.accept(); // ↑ accept()는 클라이언트의 연결 요청을 수락하는 역할을 함 - 클라이언트가 연결 요청을 하기 전까지는 대기 상태(블로킹 됨)
            
                // socket을 가지고 클라이언트 정보를 알 수 있음
                InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
                System.out.println("연결 수락: " + isa.getHostName()); 
                
                // 서버 -> 클라이언트로 데이터 보내기
                OutputStream os = socket.getOutputStream();
                String message = "Hello Client";
                byte[] bytes = message.getBytes("UTF-8");
                os.write(bytes);
                os.flush();
                System.out.println("데이터 보내기 성공");

                os.close();
                socket.close(); // 연결 끊음
            }
        } catch(Exception e) {

        }
        

        // 더 이상 서버를 실행시킬 필요가 없을 때, serverSocket을 close 해 줌
        // 여기선 의미없지만, UI에서 버튼을 눌렀을 시 종료하는 데 필요
        if (!serverSocket.isClosed()) {
            try {
                serverSocket.close();
            } catch(IOException e) {

            }
        }

    }
}