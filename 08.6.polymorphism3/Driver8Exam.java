public class Driver8Exam {
    public static void main(String[] args) {
        
        Driver8 driver = new Driver8();

        Bus8 bus = new Bus8();
        Taxi8 taxi = new Taxi8();

        driver.drive(bus); // 버스가 달립니다
        driver.drive(taxi); // 택시가 달립니다

    }
}
