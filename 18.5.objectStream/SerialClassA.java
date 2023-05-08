// 직렬화 가능한 클래스

import java.io.Serializable;

public class SerialClassA implements Serializable {
    
    int field1; // byte로 변환됨
    SerialClassB field2 = new SerialClassB(); // byte로 변환됨
    static int field3; // byte로 변환됨
    transient int field4; // byte로 변환되지 않음

}