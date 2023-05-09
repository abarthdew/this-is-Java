// 직렬화 함

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Child185 extends Parent185 implements Serializable {
    public String field2;

    // 사실 Parnet185, Serializable에 정의된 메서드가 아니기 때문에, 재정의가 아님
    // 자동적으로 실행되는 콜백 메서드라고 할 수 있음
    private void writeObject(ObjectOutputStream out) throws IOException {

        out.writeUTF(field1); // Parent에서 상속받은 필드 출력
        out.defaultWriteObject();

    } // Serializable 인터페이스가 구현되면 객체가 출력되기 전에 실행됨
    
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {

        // 객체 읽기
        field1 = in.readUTF(); // Parent 필드 읽기
        in.defaultReadObject();

    } // Serializable 인터페이스가 구현되면 객체를 읽기 전에 실행됨

}
