public class Product133Exam {
    public static void main(String[] args) {
        
        Product<Tv133, String> p1 = new Product<>();
        p1.setKind(new Tv133());
        p1.setModel("smartTV");
        Tv133 tv1 = p1.getKind();
        String m1 = p1.getModel();

        Product<Tv133, Car133> p2 = new Product<>(); // 구체적 타입을 지정함으로써
        p2.setKind(new Tv133());
        p2.setModel(new Car133()); // 타입 변환 없이 저장되고
        Tv133 tv2 = p2.getKind(); // 타입 변환 없이 리턴 됨
        Car133 m2 = p2.getModel();

    }
}
