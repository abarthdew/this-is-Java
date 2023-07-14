public class ButtonExam {
  public static void main(String[] args) {

    Button btn = new Button();
    btn.setOnClickListner(new CallListner());
    btn.touch(); // 전화를 겁니다
    btn.setOnClickListner(new MsgListner());
    btn.touch(); // 메세지를 보냅니다
    btn.setOnClickListner(new Button.OnClickListener() {
      @Override
      public void onClick() {
        System.out.println("사진을 찍습니다");
      }
    });
    btn.touch(); // 사진을 찍습니다
  }
}
