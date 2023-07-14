public class NestedOuterClass {

  String field = "Otter-field";

  void method() {
    System.out.println("Outer-method");
  }

  class NestedInner {
    String field = "inner-field";

    void method() {
      System.out.println("inner-method");
    }

    void print() {
      System.out.println(this.field); // inner-field
      this.method(); // inner-method
      System.out.println(NestedOuterClass.this.field); // Otter-field
      NestedOuterClass.this.method(); // Outer-method
    }
  }

  public static void main(String[] args) {
    NestedOuterClass outter = new NestedOuterClass();
    NestedOuterClass.NestedInner nested = outter.new NestedInner();
    nested.print();
  }
}
