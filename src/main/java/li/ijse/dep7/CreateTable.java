package li.ijse.dep7;

import li.ijse.dep7.annotations.Customer;

import java.sql.SQLException;

public class CreateTable {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        MainLibrary.init(Student.class);
        MainLibrary.init(Customer.class);
    }
}
