import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class FileSystemExam {
    public static void main(String[] args) throws Exception {
        
        FileSystem fileSystem = FileSystems.getDefault();

        for (FileStore store : fileSystem.getFileStores()) {
            System.out.println("드라이버명: " + store.name());
            System.out.println("파일 시스템: " + store.type());
            System.out.println("전채 공간: \t\t" + store.getTotalSpace() + " 바이트");
            System.out.println("사용 중인 공간: \t" + (store.getTotalSpace() - store.getUnallocatedSpace()) + " 바이트");
            System.out.println("사용 가능한 공간: \t" + store.getUsableSpace() + " 바이트");
            /*
            드라이버명: 
            파일 시스템: NTFS
            전채 공간:              240849809408 바이트
            사용 중인 공간:         62529183744 바이트
            사용 가능한 공간:       178320625664 바이트
             */
            System.out.println();
        }

        System.out.println("파일 구분자: " + fileSystem.getSeparator()); // 파일 구분자: \
        System.out.println();

        for (Path path : fileSystem.getRootDirectories()) {
            System.out.println(path.toString()); // C:\
        }

    }
}
