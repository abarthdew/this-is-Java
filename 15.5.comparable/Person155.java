public class Person155 implements Comparable<Person155> {

    public String name;
    public int age;

    public Person155(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person155 o) {
        if (age < o.age) {
            return -1;
        } else if (age == o.age) {
            return 0;
        } else {
            return 1;
        }
    }
}
