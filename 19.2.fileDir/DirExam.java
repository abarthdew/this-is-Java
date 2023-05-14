import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirExam {
    public static void main(String[] args) throws Exception {
        
        Path path1 = Paths.get("C:/Users/auswo/Downloads/PortableGit/this-is-Java/19.2.fileDir/dir/subdir");
        Path path2 = Paths.get("C:/Users/auswo/Downloads/PortableGit/this-is-Java/19.2.fileDir/DirExam.java");

        if (Files.notExists(path1)) { // 디렉토리 존재여부
            Files.createDirectories(path1); // 디렉토리가 존재하지 않을 시, 제시된 모든 디렉토리 생성(dir, subdir)
        }

        if (Files.notExists(path2)) {
            Files.createFile(path2);
        }

        Path path3 = Paths.get("C:/Users/auswo/Downloads/PortableGit/this-is-Java/19.2.fileDir");
        DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path3);
        for (Path path : directoryStream) {
            if (Files.isDirectory(path)) { // 디렉토리일 경우
                System.out.println("디렉토리: " + path.getFileName());
            } else { // 파일일 경우
                System.out.println("파일: " + path.getFileName() + " / 크기: " + Files.size(path));
            }
            /*
            디렉토리: dir
            파일: DirExam.java / 크기: 1315
            파일: FileExam192.java / 크기: 1235
             */
        }

    }
}
