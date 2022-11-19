public class Member145 {
    
    private String name;
    private String id;
    private Address145 address;

    public Member145(String name, String id, Address145 address) {
        this.name = name;
        this.id = id;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address145 getAddress() {
        return address;
    }

    public String getId() {
        return id;
    }

}
