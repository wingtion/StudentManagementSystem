public class Student {
    private String name;
    private int id;
    private String domain;
    private String address;

    public Student(String name, int id, String domain, String address) {
        this.name = name;
        this.id = id;
        this.domain = domain;
        this.address = address;
    }

    public void showInfo(){
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Domain:" + domain);
        System.out.println("Address:" + address);
        System.out.println("--------------------");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
