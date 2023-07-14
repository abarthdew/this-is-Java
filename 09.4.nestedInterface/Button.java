public class Button {

  // 중첩 인터페이스 선언
  interface OnClickListener {
    void onClick();
  }
  // 외부에서는 사용하지 않고, Button 안에서만 사용하는 인터페이스

  // 필드 선언
  OnClickListener listener;

  // setter 선언
  void setOnClickListner(OnClickListener listener) {
    this.listener = listener;
  }

  void touch() {
    listener.onClick();
    // OnClickListener 인터페이스 타입 필드에 구현 객체가 대입되어야 listner를 사용 가능
    // setter로 외부에서 OnClickListener 객체를 받아 listener 필드에 저장했기 때문에 setter가 받은 매개변수의 onClick() 메서드 사용 가능
  }
}