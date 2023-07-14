import java.nio.Buffer;
import java.nio.ByteBuffer;

public class BufferExam {
  public static void main(String[] args) {

    // 1. 저장하기

    System.out.println("7 바이트 크기로 버퍼 생성");
    ByteBuffer buffer = ByteBuffer.allocateDirect(7);

    printState(buffer);
        /*
         7 바이트 크기로 버퍼 생성
            position: 0
            limit: 7
            capacity: 7
         */

    buffer.put((byte) 10);
    buffer.put((byte) 11);
    System.out.println("2 바이트 저장 후");
    printState(buffer);
         /*
         2 바이트 저장 후
            position: 2
            limit: 7
            capacity: 7
          */

    buffer.put((byte) 12);
    buffer.put((byte) 13);
    buffer.put((byte) 14);
    System.out.println("3 바이트 저장 후");
    printState(buffer);
        /*
         3 바이트 저장 후
            position: 5
            limit: 7
            capacity: 7
         */

    // 2. 읽기
    buffer.flip();
    System.out.println("flip() 실행 후");
    printState(buffer);
        /*
         flip() 실행 후
            position: 0 // 맨 앞으로 돌아감
            limit: 5
            capacity: 7
         */

    buffer.get(new byte[3]); // byte 배열의 길이만큼 읽음
    System.out.println("3 바이트 읽은 후");
    printState(buffer);
        /*
         3 바이트 읽은 후
            position: 3
            limit: 5
            capacity: 7
         */

    buffer.mark();
    System.out.println("---현재 위치를 마크---");

    buffer.get(new byte[2]);
    System.out.println("2 바이트 읽은 후");
    printState(buffer);
        /*
         2 바이트 읽은 후
            position: 5 // position = limit (더 이상 읽을 게 없음)
            limit: 5
            capacity: 7
         */

    // 더 이상 읽을 게 없으니 mark 표시한 3으로 position을 옮김
    buffer.reset();
    System.out.println("position을 마크 위치로 옮김");
    printState(buffer);
        /*
         position을 마크 위치로 옮김
            position: 3
            limit: 5
            capacity: 7
         */

    buffer.rewind(); // position을 제일 앞으로 보냄
    System.out.println("rewind() 실행 후");
    printState(buffer);
        /*
         rewind() 실행 후
            position: 0
            limit: 5
            capacity: 7
         */

    buffer.clear(); // buffer 초기화
    // buffer에 있는 데이터가 지워지는 건 아님
    // 위치 속성값만 처음 buffer를 만들었을 때로 돌아감
    System.out.println("clear() 실행 후");
    printState(buffer);
        /*
        clear() 실행 후
            position: 0
            limit: 7
            capacity: 7
         */


  }

  public static void printState(Buffer buffer) {
    System.out.println("\t position: " + buffer.position());
    System.out.println("\t limit: " + buffer.limit());
    System.out.println("\t capacity: " + buffer.capacity());
  }
}
