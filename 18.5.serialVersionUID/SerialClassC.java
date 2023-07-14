import java.io.Serializable;

public class SerialClassC implements Serializable {

  // SerialVersionUID 명시적 추가 - jdk가 제공하는 명령어로 작성(직접 입력해도 되긴 함)
  private static final long serialVersionUID = 8292606589775300057L; // 이 값은 절대 중복되지 않음
  // 필드를 추가하더라도, serialVersionUID이 새로 생성되지 않고 이 값이 계속 사용됨

  int field1;

  // 추가
  int field2;

}
