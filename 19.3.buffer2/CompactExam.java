import java.nio.ByteBuffer;

public class CompactExam {
  public static void main(String[] args) {

    System.out.println("7 바이트 크기로 버퍼 생성");
    ByteBuffer buffer = ByteBuffer.allocateDirect(7);

    // 5개 바이트 저장
    buffer.put((byte) 10);
    buffer.put((byte) 11);
    buffer.put((byte) 12);
    buffer.put((byte) 13);
    buffer.put((byte) 14);

    // 읽기로 바꿈
    buffer.flip();

    printState(buffer);
    // 10, 11, 12, 13, 14,
    // position: 0limit: 5capacity: 7

    buffer.get(new byte[3]);
    System.out.println("3 바이트 읽음");

    buffer.compact();
    System.out.println("compact() 실행 후");
    printState(buffer);
    // 13, 14, 12, 13, 14,
    // position: 2limit: 7capacity: 7

  }

  public static void printState(ByteBuffer buffer) {
    System.out.print(buffer.get(0) + ", ");
    System.out.print(buffer.get(1) + ", ");
    System.out.print(buffer.get(2) + ", ");
    System.out.print(buffer.get(3) + ", ");
    System.out.println(buffer.get(4) + ", ");
    System.out.print("position: " + buffer.position());
    System.out.print("limit: " + buffer.limit());
    System.out.println("capacity: " + buffer.capacity());
  }
}
