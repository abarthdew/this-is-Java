public class FileInputStreamExam {
  public static void main(String[] args) throws Exception {

    FileInputStream fis = new FileInputStream("C:/Users/auswo/Downloads/PortableGit/this-is-Java/18.4.file/dir/file1.txt");
    int data; // 파일에서 읽은 byte 저장
    while ((data = fis.read()) != -1) {
      // System.out은 OutputStream의 필드이므로 write()를 사용할 수 있음
      System.out.write(data); // 출력(=System.out.println)
            /*
            study java!
             */
    }
    System.out.flush(); // write() 사용 후 필수로 flush() 호출
    // main 메서드가 끝나면 프로그램이 종료되므로, out이 가지고 있는 버퍼는 자동으로 지워지므로 생략해도 무방

    fis.close();
  }
}
