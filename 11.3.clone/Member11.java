public class Member11 implements Cloneable{
    public String id;
    public String name;
    public String password;
    public int age;
    public boolean adult;
    public Car12 car;

    public Member11(String id, String name, String password, int age, boolean adult, Car12 car) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.adult = adult;
        this.car = car;
    }

    public Member11 getMember() {
        Member11 cloned = null;
        try {
            cloned = (Member11) clone(); // 얕은 복사가 되어 Member11 변수에 대입됨
        } catch (CloneNotSupportedException e) {}
        return cloned;
    }
}