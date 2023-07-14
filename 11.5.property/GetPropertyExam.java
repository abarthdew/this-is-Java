import java.util.Properties;
import java.util.Set;

public class GetPropertyExam {
  public static void main(String[] args) {
    String osName = System.getProperty("os.name");
    String usrName = System.getProperty("user.name");

    System.out.println(osName); // Windows 10
    System.out.println(usrName); // auswo

    // Properties 컬렉션 사용하기
    Properties props = System.getProperties(); //getProperties(): 모든 시스템 속성을 담아서 Properties라는 컬렉션으로 리턴
    Set keys = props.keySet();
    for (Object objKey : keys) {
      String key = (String) objKey;
      String value = System.getProperty(key);
      System.out.println(key + " | " + value);
            /*
            java.runtime.name | Java(TM) SE Runtime Environment
            sun.boot.library.path | C:\Program Files\Java\jdk1.8.0_201\jre\bin
            java.vm.version | 25.201-b09
            java.vm.vendor | Oracle Corporation
            java.vendor.url | http://java.oracle.com/
            path.separator | ;
             */
    }
  }
}
