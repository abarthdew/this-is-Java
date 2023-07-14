public class Game {
  private int speed;
  private boolean stop;

  public int getSpeed() {
    return this.speed;
  }

  public boolean isStop() {
    return this.stop;
  }

  public void setSpeed(int speed) {
    if (speed < 0) {
      this.speed = 0;
    } else {
      this.speed = speed;
    }
  }

  public void setStop(boolean stop) {
    this.stop = stop;
  }
}
