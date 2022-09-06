public class EqualsExam {
    public static void main(String[] args) {
        String strVar1 = "java";
        String strVar2 = "java";
        String strVar3 = new String("java");

        System.out.println(strVar1 == strVar2); // true
        System.out.println(strVar1 == strVar3); // false
        System.out.println(strVar1.equals(strVar3)); // true
    }
}
