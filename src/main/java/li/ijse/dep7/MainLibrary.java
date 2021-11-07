package li.ijse.dep7;

import li.ijse.dep7.annotations.Column;
import li.ijse.dep7.annotations.Id;
import li.ijse.dep7.annotations.Table;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MainLibrary {


    public static void init(Class anyClass) throws SQLException, ClassNotFoundException {
        List<String> columns = new ArrayList<>();
        String key = null;
        String tableName;

        Table tblAnnotation = (Table) anyClass.getAnnotation(Table.class);
        tableName=tblAnnotation.value();
        Field[] declaredFields = anyClass.getDeclaredFields();

        for(Field fields:declaredFields){
            Id idAnnotation = fields.getAnnotation(Id.class);
            Column clAnnotation = fields.getAnnotation(Column.class);
            if(idAnnotation!=null){
                key=clAnnotation.value();
            } else if(clAnnotation!=null){

                columns.add(clAnnotation.value());
            }
        }

        MainLibrary.createTable(tableName,key,columns);
    }

    static void createTable(String tblName,String id,List<String> column) throws SQLException, ClassNotFoundException {
//        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dep7_simple_orm",
                "root", "Prabash@123");
      Statement statement = connection.createStatement();
      String stm="CREATE TABLE "+tblName+"(\n" +
              "    "+id+" VARCHAR(5) NOT NULL PRIMARY KEY ,\n"+"    ";
        StringBuilder sb= new StringBuilder(stm);
        for(String columnName:column) {
            if (column.indexOf(columnName)==(column.size()-1)) {
                sb.append(columnName + " VARCHAR(50) NOT NULL );");
            }else{
                sb.append(columnName+" VARCHAR(50) NOT NULL , \n"+"    ");
            }
        }
//        System.out.println(sb.toString());
        int i = statement.executeUpdate(sb.toString());
        connection.close();
    }
    }

