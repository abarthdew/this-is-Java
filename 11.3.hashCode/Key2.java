public class Key2 {
  public int number;

  public Key2(int number) {
    this.number = number;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Key2) {
      Key2 compareKey = (Key2) obj;
      if (this.number == compareKey.number) {
        return true;
      }
    }
    return false;
  }

  // hashCode 재정의
  @Override
  public int hashCode() {
    System.out.println("hashCode 호출");
    return this.number;
  }
}