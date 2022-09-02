public class GarbageValue {
    public static void main(String[] args) {
        byte var1 = 125;
        byte var2 = 125;

        for(int i=0; i<5; i++) {
            var1++;
            var2++;
            System.out.println("var1: " + var1 + "\t" + "var2: " + var2);
        }

        /*
            var1: 126       var2: 126
            var1: 127       var2: 127 
            var1: -128      var2: -128
            var1: -127      var2: -127
            var1: -126      var2: -126
         */
        // -128, -127, -126과 같이 순회된 결과는 개발자가 예상하기 힘드므로, 쓰레기값이라고 함
    }
}
