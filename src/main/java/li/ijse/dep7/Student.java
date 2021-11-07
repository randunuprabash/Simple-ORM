package li.ijse.dep7;

import li.ijse.dep7.annotations.Column;
import li.ijse.dep7.annotations.Id;
import li.ijse.dep7.annotations.Table;
@Table("student")
public class Student {
    @Id
    @Column("id")
    private String id;
    @Column("name")
    private String name;
    @Column("address")
    private String address;

    public Student() {
    }

    public Student(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
