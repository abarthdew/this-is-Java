public class UsingThisExam {
  public static void main(String[] args) {

    UsingThis ut = new UsingThis();
    UsingThis.Inner inner = ut.new Inner();
    inner.method();
        /* (출력결과)
        outterField: 10
        innerField: 20
         */

    UsingThis2 ut2 = new UsingThis2();
    UsingThis2.Inner inner2 = ut2.new Inner();
    inner2.method();
        /* (출력결과)
        outterField: 10
        innerField: 20
        구분을 안 한다면: 20 (구분을 안 하면 innerField가 나옴)
         */

  }
}
