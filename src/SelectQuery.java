import java.sql.*;

public class SelectQuery {
    public static void main(String[] args) throws ClassNotFoundException{
        String url = "jdbc:mysql://localhost:3306/company";
        String password= "Tejas@123";
        String username = "root";
        String query = "Select * from Empolyee";
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try{
            Connection con = DriverManager.getConnection(url,username,password);
            Statement sts = con.createStatement();
            ResultSet rs = sts.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String job_name = rs.getString("job_name");
                double salary = rs.getDouble("Salary");
                System.out.println();
                System.out.println("===========================");
                System.out.println("Id : " + id);
                System.out.println("name : " + name);
                System.out.println("jab_name : " + job_name);
                System.out.println("salary : " + salary);

            }
            // it is nice habit to close the object wht we use
            rs.close();;
            sts.close();
            con.close();

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }




    }
}