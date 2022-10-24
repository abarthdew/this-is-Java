public class SortMember implements Comparable<SortMember> {
    String name;

    SortMember(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(SortMember o) {
        int rs = name.compareTo(o.name);
        return rs; // 현재 멤버가 매개값보다 더 적을 경우 음수, 동일하면 0, 현재 멤버가 매개값보다 더 크면 양수 
    }
}
