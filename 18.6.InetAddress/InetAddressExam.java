import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExam {
  public static void main(String[] args) {

    try {
      InetAddress local = InetAddress.getLocalHost();
      System.out.println("내 컴퓨터 ip 주소: " + local.getHostAddress()); // 내 컴퓨터 ip 주소: 172.30.1.***

      InetAddress[] isArr = InetAddress.getAllByName("www.naver.com");
      for (InetAddress remote : isArr) {
        System.out.println(remote.getHostAddress());
                /*
                223.130.195.200
                223.130.200.107
                 */
      }
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }

  }
}
