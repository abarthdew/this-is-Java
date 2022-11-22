import java.io.FileReader;
import java.net.URLDecoder;
import java.util.Properties;

public class PropertiesExam {
    public static void main(String[] args) throws Exception {
        
        Properties properties = new Properties(); // Properties 컬렉션: 키, 값이 모두 String 타입
        // 파일 시스템에 있는 properties 파일을 로딩해 키, 값을 갖는 Map 컬렉션으로 만듦

        // properties 객체로 .properties 파일을 읽어 키-값으로 구성된 map 컬렉션 만들기
        String path = PropertiesExam.class.getResource("database.properties").getPath(); 
        path = URLDecoder.decode(path, "utf-8");
        properties.load(new FileReader(path));

        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        System.out.println(driver); // orable.jdbc.OraclDriver
        System.out.println(url); // jdbc:oracle:thin:@localhost:1521:orcl
        
    }
}
