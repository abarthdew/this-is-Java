public class Student166 implements Comparable<Student166> {

  private String name;
  private int score;

  public Student166(String name, int score) {
    this.name = name;
    this.score = score;
  }

  public String getName() {
    return name;
  }

  public int getScore() {
    return score;
  }

  @Override
  public int compareTo(Student166 o) {
    return Integer.compare(score, o.score);
  }

}
