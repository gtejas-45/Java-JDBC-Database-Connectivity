import java.sql.*;

public class InsertQuery {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/company";
        String password= "Tejas@123";
        String username = "root";
        String query = "INSERT INTO EMPOLYEE(ID,NAME,JOB_NAME,SALARY) VALUES (3,'raj','berojgar',40);";
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try{
            Connection con = DriverManager.getConnection(url,username,password);
            Statement sts = con.createStatement();
            //if we want to update/insert/delete data we use execute Update
            int rowsaffected = sts.executeUpdate(query);
            if(rowsaffected > 0){
                System.out.println("inserted check in ur table");
            }else{
                System.out.println("failed");
            }
            //check the company database the table empolyee new table row added
            // it is nice habit to close the object wht we use

            sts.close();
            con.close();

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }


    }
}
