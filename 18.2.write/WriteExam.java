import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteExam {
  public static void main(String ar[]) throws Exception {

    OutputStream os = new FileOutputStream("C:/Users/auswo/Downloads/PortableGit/test.txt");
    byte[] data = "ABC".getBytes();
    for (int i = 0; i < data.length; i++) {
      os.write(data[i]); // 출력 스트림에서 write 사용 시, data는 버퍼에 쌓였다가 출력됨
    }
    os.flush(); // 버퍼가 꽉 차지 않고 빈 공간이 남아 있으면 출력이 안 되기 때문에, 강제로 출력해서 data를 버퍼에서 내보냄
    os.close(); // 출력 스트림 close

  }
}