import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateQuery {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/company";
        String password= "Tejas@123";
        String username = "root";
        String query = "UPDATE EMPOLYEE SET JOB_NAME = 'DRONE HANDLER', SALARY = 50000 WHERE ID = 2;";
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try{
            Connection con = DriverManager.getConnection(url,username,password);
            Statement sts = con.createStatement();
            //if we want to update data we use execute Update
            int rowsaffected = sts.executeUpdate(query);
            if(rowsaffected > 0){
                System.out.println("Updated check in ur table");
            }else{
                System.out.println("failed");
            }
            //check the company database the table empolyee is updated one row which we seleted
            // it is nice habit to close the object wht we use

            sts.close();
            con.close();

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }


    }
}
