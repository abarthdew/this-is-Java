public class GcExam {
  public static void main(String[] args) {
    Employee emp;
    emp = new Employee(1);
    emp = null; // Employee(1)는 쓰레기 객체가 됨
    emp = new Employee(2);
    emp = new Employee(3); // Employee(2)는 쓰레기 객체가 됨

    System.out.println("emp가 최종적으로 참조하는 사원번호: " + emp.eno);
    System.gc(); // 만약 지시를 호출하지 않으면 메모리에서 제거되지 않을 수도 있음
        /*
        employee 1 이 메모리에서 생성됨
        employee 2 이 메모리에서 생성됨
        employee 3 이 메모리에서 생성됨
        emp가 최종적으로 참조하는 사원번호: 3
        employee 1 이 메모리에서 제거됨
        employee 2 이 메모리에서 제거됨
         */
  } // 하지만 이 시점에서 main이 종료되면 jvm도 종료되기 때문에, System.gc()가 생략됐을 경우 결과는 다음과 같음
    /*
    employee 1 이 메모리에서 생성됨
    employee 2 이 메모리에서 생성됨
    employee 3 이 메모리에서 생성됨
    emp가 최종적으로 참조하는 사원번호: 3
     */
  // jvm이 종료되었으므로 System.gc()를 호출하지 못함
  // -> jvm이 종료되면 메모리가 해지되기 때문에 보통 따로 System.gc()를 호출할 필요 없음
}
