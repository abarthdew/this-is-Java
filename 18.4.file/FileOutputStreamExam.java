import java.io.FileOutputStream;

public class FileOutputStreamExam {
  public static void main(String[] args) throws Exception {

    // originalFileName 경로의 그림 파일 targetFileName에 복사하기
    String originalFileName = "C:/Users/auswo/Downloads/PortableGit/this-is-Java/18.4.file/dir/test.png";
    String targetFileName = "C:/Users/auswo/Downloads/PortableGit/this-is-Java/18.4.file/test-copy.png";

    // originalFileName 읽어서 파일 복사
    FileInputStream fis = new FileInputStream(originalFileName);

    // targetFileNmae에 쓸 때(저장할 때) 파일 복사
    FileOutputStream fos = new FileOutputStream(targetFileName);

    // byte 배열로 fis 파일을 읽어 fos로 출력
    int readByteNo; // 읽은 byte 수 저장
    byte[] readBytes = new byte[100]; // 읽은 byte 데이터를 저장할 byte 배열 저장
    while ((readByteNo = fis.read(readBytes)) != -1) {
      fos.write(readBytes, 0, readByteNo);
    }
    fos.flush();
    fos.close();
    fis.close();
    System.out.println("복사 종료");

  }
}
