public class StorageExam {
    public static void main(String[] args) {
        
        ChildProduct137<Tv137, String, String> p = new ChildProduct137<>();
        p.setKind(new Tv137());
        p.setModel("String");
        p.setCompany("Samsung");

        Storage137<Tv137> s = new StorageImpl<>(100);
        s.add(new Tv137(), 0); // 0 index에 Tv 객체 저장
        Tv137 tv = s.get(0);

    }
}
