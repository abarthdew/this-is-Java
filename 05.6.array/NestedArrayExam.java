public class NestedArrayExam {
    public static void main(String[] args) {
        int[][] mathScores = new int[2][3];
        for(int i=0; i<mathScores.length; i++) {
            for(int j=0; j<mathScores[i].length; j++) {
                System.out.println("scoreScores[" + i + "][" + j + "]" + mathScores[i][j]);
                /*
                scoreScores[0][0]0
                scoreScores[0][1]0
                scoreScores[0][2]0
                scoreScores[1][0]0
                scoreScores[1][1]0
                scoreScores[1][2]0
                 */
            }
        }

        int[][] engScores = new int[2][];
        engScores[0] = new int[2];
        engScores[1] = new int[3];
        for(int i=0; i<mathScores.length; i++) {
            for(int j=0; j<engScores[i].length; j++) {
                System.out.println("engScores[" + i + "][" + j + "]" + engScores[i][j]);
                /*
                engScores[0][0]0
                engScores[0][1]0
                engScores[1][0]0
                engScores[1][1]0
                engScores[1][2]0
                 */
            }
        }

        int[][] javaScores = {{95, 80}, {92, 96, 80}};
        for(int i=0; i<javaScores.length; i++) {
            for(int j=0; j<javaScores[i].length; j++) {
                System.out.println("javaScores[" + i + "][" + j + "]" + javaScores[i][j]);
                /*
                javaScores[0][0]95
                javaScores[0][1]80
                javaScores[1][0]92
                javaScores[1][1]96
                javaScores[1][2]80
                 */
            }
        }
    }
}
