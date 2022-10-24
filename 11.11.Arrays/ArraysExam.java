import java.util.Arrays;

public  class ArraysExam {
    public static void main(String[] args) {
        
        char[] arr1 = {'J', 'A', 'V', 'A'};
        System.out.println(arr1); // JAVA
        System.out.println(Arrays.toString(arr1)); // [J, A, V, A]

        char[] arr2 = Arrays.copyOf(arr1, arr1.length);
        System.out.println(arr2); // JAVA
        System.out.println(Arrays.toString(arr2)); // [J, A, V, A]

        char[] arr3 = Arrays.copyOfRange(arr1, 1, 3);
        System.out.println(arr3); // AV
        System.out.println(Arrays.toString(arr3)); // [A, V]

        char[] arr4 = new char[arr1.length];
        System.arraycopy(arr1, 0, arr4, 0, arr1.length);
        for(int i=0; i<arr4.length; i++) {
            System.out.println(arr4[i]);
            /*
            J
            A
            V
            A
             */
        }

    }
}