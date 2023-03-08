public class GameExam {
    public static void main(String[] args) {
        Game game = new Game();

        game.setSpeed(60);
        System.out.println(game.getSpeed()); // 60
        game.setSpeed(-60);
        System.out.println(game.getSpeed()); // 0

        game.setStop(false);
        System.out.println(game.isStop()); // false
    }
}
