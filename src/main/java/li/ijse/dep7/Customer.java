package li.ijse.dep7;

import li.ijse.dep7.annotations.Column;
import li.ijse.dep7.annotations.Id;
import li.ijse.dep7.annotations.Table;

@Table("customer")
public class Customer {
    @Id
    @Column("id")
    private String id;
    @Column("name")
    private String name;
    @Column("order_id")
    private String order_id;

}
