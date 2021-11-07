package li.ijse.dep7.annotations;

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
