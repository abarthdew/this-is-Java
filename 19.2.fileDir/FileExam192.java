import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileExam192 {
    public static void main(String[] args) throws Exception {
        
        Path path = Paths.get("C:/Users/auswo/Downloads/PortableGit/this-is-Java/19.2.fileDir/FileExam192.java"); // 디렉토리 여부: false
        System.out.println("디렉토리 여부: " + Files.isDirectory(path)); // 디렉토리 여부: false
        System.out.println("파일 여부: " + Files.isRegularFile(path)); // 파일 여부: true
        System.out.println("마지막 수정 시간: " + Files.getLastModifiedTime(path)); // 마지막 수정 시간: 2023-05-14T07:17:48.3129508Z
        System.out.println("파일 크기: " + Files.size(path)); // 파일 크기: 946
        System.out.println("소유자: " + Files.getOwner(path).getName()); // 소유자: DESKTOP-54PLDV3\auswo
        System.out.println("숨김 파일 여부: " + Files.isHidden(path)); // 숨김 파일 여부: false
        System.out.println("읽기 가능 여부: " + Files.isReadable(path)); // 읽기 가능 여부: true
        System.out.println("쓰기 가능 여부: " + Files.isWritable(path)); // 쓰기 가능 여부: true

    }
}
