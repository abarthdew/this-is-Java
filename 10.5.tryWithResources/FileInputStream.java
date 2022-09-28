 // FileInputStream: 자바에서 제공해 주는 출력 스트림 클래스
public class FileInputStream implements AutoCloseable { // AutoCloseable을 구현하는 클래스만이 try-with-resources 기능 이용 가능
    
    private String file;

    public FileInputStream(String file) {
        this.file = file;
    }

    public void read() {
        System.out.println(file + "을 읽습니다");
    }

    // 구현 후 close() 메서드 재정의 -> 이 close() 메서드를 자동으로 호출시켜 줌
    @Override
    public void close() throws Exception {
        System.out.println(file + "을 닫습니다");
    }

}
