public class CopyArrayExam {
    public static void main(String[] args) {

        // 배열 복사
        int[] oldIntArray = {1, 2, 3};
        int[] newIntArray = new int[5];
        for(int i=0; i<oldIntArray.length; i++) {
            newIntArray[i] = oldIntArray[i];
        }
        for(int i=0; i<newIntArray.length; i++) {
            System.out.println(newIntArray[i]);
            /*
             1
            2
            3
            0
            0
             */
        }

        // System.arrayCopy 메서드 사용해서 배열 복사
        String[] oldStrArray = {"java", "array", "copy"};
        String[] newStrArray = new String[5];
        System.arraycopy(oldStrArray, 0, newStrArray, 0, oldIntArray.length);
        for(int i=0; i<newStrArray.length; i++) {
            System.out.println(newStrArray[i]);
            /*
            java
            array
            copy
            null
            null
             */
        }

        // 향상된 for문
        for(String array : newStrArray) {
            System.out.println(array);
            /*
             java
            array
            copy
            null
            null
             */
        }
    }   
}
