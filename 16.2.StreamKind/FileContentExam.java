import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;


public class FileContentExam {
    public static void main(String[] args) throws IOException {
        
        Path path = Paths.get("C:/Users/auswo/Downloads/PortableGit/this-is-Java/16.2.StreamKind/linedata.txt"); // 현재 프로젝트 기준 파일 경로 리턴
        Stream<String> stream;
        
        // Files.line() 메서드 이용
        stream = Files.lines(path);
        // stream = Files.lines(path, Charset.defaultCharset()); // error
        stream.forEach(System.out::println);
        /*
        java8에서 추가된 새로운 기능
        1. 람다식
        2. 메서드 참조
        3. 디폴트 메서드와 정적 메서드
        4. 새로운 API 패키지
         */

        // BufferedReader의 lines() 메서드 이용
        File file = path.toFile();
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader); // 성능 향상을 위해 만듬
        stream = br.lines();
        stream.forEach(System.out::println);
        /*
        java8?뿉?꽌 異붽??맂 ?깉濡쒖슫 湲곕뒫
        1. ?엺?떎?떇
        2. 硫붿꽌?뱶 李몄“
        3. ?뵒?뤃?듃 硫붿꽌?뱶?? ?젙?쟻 硫붿꽌?뱶
        4. ?깉濡쒖슫 API ?뙣?궎吏?
         */
        stream.close();

    }
}
