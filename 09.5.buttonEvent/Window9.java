// 두 개의 버튼을 가지고 있다고 가정

public class Window9 {

  // 필드 선언
  Button9 button1 = new Button9();
  Button9 button2 = new Button9();

  // 사용자에 의해 window에서 버튼이 터치되었을 경우 이벤트 처리를 위해 객체 생성
  // 1. 필드로 선언
  Button9.OnClickListener listener = new Button9.OnClickListener() {

    @Override
    public void onClick() {
      System.out.println("전화를 겁니다");
    }

  };

  // 생성자 선언: 각 버튼에 이벤트 처리 지정해 줌
  Window9() {
    button1.setOnClickListener(listener);
    // 2. 매개변수에 익명 구현 객체 대입
    button2.setOnClickListener(new Button9.OnClickListener() {

      @Override
      public void onClick() {
        System.out.println("메세지를 보냅니다");
      }

    });
  }
}
