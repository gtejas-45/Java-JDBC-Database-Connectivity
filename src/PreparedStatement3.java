import java.sql.*;
import java.util.Scanner;

public class PreparedStatement3 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/company";
        String username = "root";
        String password = "Tejas@123";
        String query = "INSERT INTO Empolyee(id,name,job_name,salary) VALUES (?,?,?,?);";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection con = DriverManager.getConnection(url,username,password);
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            String job_name = sc.nextLine();
            double salary = sc.nextDouble();
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,job_name);
            preparedStatement.setDouble(4,salary);
          int rowsAffected = preparedStatement.executeUpdate();
          if(rowsAffected >0){
              System.out.println("Inserted data");
          }else{
              System.out.println("failed");
          }


        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
