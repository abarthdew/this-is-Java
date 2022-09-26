public class Driver8 {
    
    public void drive(Vehicle8 vehicle) { // 매개변수 vehicle에 bux, taxi 타입 변수가 들어올 수 있음
        vehicle.run(); // 매개변수 타입에 따라, bus 또는 taxi의 재정의된 run 메서드 실행
    }
}
