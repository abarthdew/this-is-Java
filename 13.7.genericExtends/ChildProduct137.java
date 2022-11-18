public class ChildProduct137<K, V, C> extends Product137<K, V> { // 부모가 제네릭 파라미터를 가지고 있으면 자식 클래스에도 동일한 파라미터 선언해야 함
                            // 자식 클래스는 추가적인 타입 파라미터를 더 가질 수 있음
    private C company;

    public C getCompany() {
        return company;
    }

    public void setCompany(C company) {
        this.company = company;
    }

}
