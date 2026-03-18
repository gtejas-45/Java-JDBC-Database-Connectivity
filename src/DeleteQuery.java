import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteQuery {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/company";
        String password= "Tejas@123";
        String username = "root";
        String query = "DELETE FROM EMPOLYEE WHERE ID = 3;;";
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try{
            Connection con = DriverManager.getConnection(url,username,password);
            Statement sts = con.createStatement();
            //if we want to update/insert/delete  data we use execute Update
            int rowsaffected = sts.executeUpdate(query);
            if(rowsaffected > 0){
                System.out.println("DELETED check in ur table !! " + "row(" + rowsaffected + ") affected");
            }else{
                System.out.println("failed");
            }
            //check the company database the table empolyee one row deleted who's id is 3
            // it is nice habit to close the object wht we use

            sts.close();
            con.close();

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
