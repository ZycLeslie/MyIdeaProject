package git.leslie.entity;

public class User {

    private Integer id;
    private String name;
    private String no;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", no='" + no + '\'' +
                '}';
    }

    public User(Integer id, String name, String no) {
        this.id = id;
        this.name = name;
        this.no = no;
    }
}
