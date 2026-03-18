import java.sql.*;


public class PreparedStatementQuery {
    public static void main(String[] args) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/company";
        String username = "root";
        String password = "Tejas@123";
        String query = "SELECT * FROM EMPOLYEE WHERE ID = ?";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection con = DriverManager.getConnection(url,username,password);
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1,2);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");

                System.out.println(id);
                System.out.println(name);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
