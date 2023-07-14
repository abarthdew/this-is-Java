import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

// 서버 소켓을 생성하고, 클라이언트에서 소켓으로 연결 요청을 하는 코드

public class ServerExam2 {
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

        // 데이터를 받고 보내기
        byte[] bytes = null; // 받은 데이터 저장
        String message = null;

        InputStream is = socket.getInputStream();
        bytes = new byte[100];
        int readByteCount = is.read(bytes); // read(): 클라이언트가 데이터를 보내기 전까지는 대기 상태
        message = new String(bytes, 0, readByteCount, "UTF-8");
        System.out.println("데이터 받기 성공: " + message);

        is.close();
        socket.close(); // 연결 끊음
      }
    } catch (Exception e) {

    }


    // 더 이상 서버를 실행시킬 필요가 없을 때, serverSocket을 close 해 줌
    // 여기선 의미없지만, UI에서 버튼을 눌렀을 시 종료하는 데 필요
    if (!serverSocket.isClosed()) {
      try {
        serverSocket.close();
      } catch (IOException e) {

      }
    }

  }
}