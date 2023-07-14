import java.util.Arrays;

public class WildCardExam {

  public static void registerCourse1(Course136<?> course) {
    System.out.println(course.getName() + " 수강생: " + Arrays.toString(course.getStudents()));
  }

  public static void registerCourse2(Course136<? extends Student136> course) {
    System.out.println(course.getName() + " 수강생: " + Arrays.toString(course.getStudents()));
  }

  public static void registerCourse3(Course136<? super Worker136> course) {
    System.out.println(course.getName() + " 수강생: " + Arrays.toString(course.getStudents()));
  }

  public static void main(String[] args) {

    // <?>: 모든 타입 가능
    registerCourse1(new Course136<Person136>("일반인 과정", 5)); // 일반인 과정 수강생: [null, null, null, null, null]
    registerCourse1(new Course136<Student136>("학생 과정", 5)); // 학생 과정 수강생: [null, null, null, null, null]
    registerCourse1(new Course136<Worker136>("근로자 과정", 5)); // 근로자 과정 수강생: [null, null, null, null, null]
    registerCourse1(new Course136<HighStudent>("고등학생 과정", 5)); // 고등학생 과정 수강생: [null, null, null, null, null]

    // <? extends Student>: Student 하위 타입만 가능
    // registerCourse2(new Course136<Person136>("일반인 과정", 5)); // 컴파일 에러
    registerCourse2(new Course136<Student136>("학생 과정", 5)); // 학생 과정 수강생: [null, null, null, null, null]
    // registerCourse2(new Course136<Worker136>("근로자 과정", 5)); // 컴파일 에러
    registerCourse2(new Course136<HighStudent>("고등학생 과정", 5)); // 고등학생 과정 수강생: [null, null, null, null, null]


    // <? super Worker136>: Worker 상위 타입만 가능
    registerCourse3(new Course136<Person136>("일반인 과정", 5)); // 일반인 과정 수강생: [null, null, null, null, null]
    // registerCourse3(new Course136<Student136>("학생 과정", 5)); // 컴파일 에러
    registerCourse3(new Course136<Worker136>("근로자 과정", 5)); // 근로자 과정 수강생: [null, null, null, null, null]
    // registerCourse3(new Course136<HighStudent>("고등학생 과정", 5)); // 컴파일 에러


    Course136<Person136> pc = new Course136<>("일반인 과정", 5);
    pc.add(new Person136("일반인"));
    pc.add(new Person136("직장인1"));
    pc.add(new Person136("학생1"));
    pc.add(new Person136("고등학생1"));

    Course136<Worker136> wc = new Course136<>("직장인 과정", 5);
    wc.add(new Worker136("직장인2"));

    Course136<Student136> sc = new Course136<>("학생 과정", 5);
    sc.add(new Student136("학생2"));
    sc.add(new HighStudent("고등학생2"));

    Course136<HighStudent> hc = new Course136<>("고등학생 과정", 5);
    hc.add(new HighStudent("고등학생3"));

    // 1. 전부 가능
    registerCourse1(pc); // 일반인 과정 수강생: [일반인, 직장인1, 학생1, 고등학생1, null]
    registerCourse1(wc); // 직장인 과정 수강생: [직장인2, null, null, null, null]
    registerCourse1(sc); // 학생 과정 수강생: [학생2, 고등학생2, null, null, null]
    registerCourse1(hc); // 고등학생 과정 수강생: [고등학생3, null, null, null, null]

    // 2. Student 하위 타입만 가능
    // registerCourse2(pc);
    // registerCourse2(wc);
    registerCourse2(sc); // 학생 과정 수강생: [학생2, 고등학생2, null, null, null]
    registerCourse2(hc); // 고등학생 과정 수강생: [고등학생3, null, null, null, null]

    // 3. Worker 상위 타입만 가능
    registerCourse3(pc); // 일반인 과정 수강생: [일반인, 직장인1, 학생1, 고등학생1, null]
    registerCourse3(wc); // 직장인 과정 수강생: [직장인2, null, null, null, null]
    // registerCourse3(sc);
    // registerCourse3(hc);
  }

}
