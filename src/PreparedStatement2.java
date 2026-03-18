import java.sql.*;

public class PreparedStatement2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/company";
        String username = "root";
        String password = "Tejas@123";
        String query = "SELECT * FROM EMPOLYEE WHERE ID = ? AND NAME = ?";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection con = DriverManager.getConnection(url,username,password);
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1,2);
            preparedStatement.setString(2,"YASH");
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String job_name = rs.getString("job_name");

                System.out.println(id);
                System.out.println(name);
                System.out.println(job_name);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
