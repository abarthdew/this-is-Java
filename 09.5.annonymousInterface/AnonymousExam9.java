public class AnonymousExam9 {
  public static void main(String[] args) {

    Anonymous9 a = new Anonymous9();
    a.field.turnOn(); // tv 켭니다
    a.field.turnOff(); // tv 끕니다

    a.method1();
        /*
         audio 켭니다
        audio 끕니다
         */

    a.method2(new RemoteControl9() {

      @Override
      public void turnOn() {
        System.out.println("phone 켭니다");
      }

      @Override
      public void turnOff() {
        System.out.println("phone 끕니다");
      }

    });
        /*
         phone 켭니다
        phone 끕니다
         */
  }
}