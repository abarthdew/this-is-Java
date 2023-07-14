public class PhoneExam3 {
  public static void main(String[] args) {
    // Phone3 phone = new Phone3(); // 컴파일 에러: 추상클래스는 생성 불가

    SmartPhone3 smartPhone = new SmartPhone3("홍길동");
    smartPhone.turnOn(); // 폰 전원을 켭니다.
    smartPhone.internetSearch(); // 인터넷 검색을 합니다.
    smartPhone.turnOff(); // 폰 전원을 끕니다.
  }
}
