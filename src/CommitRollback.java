import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CommitRollback {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/company";
        String username = "root";
        String password = "Tejas@123";
        String withdrawQuery = "UPDATE account SET balance = balance - ? WHERE acc_num = ?";
        String depositQuery = "UPDATE account SET balance = balance + ? WHERE acc_num = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers loaded successfully!!!");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("connection Established Successfully !!");
            con.setAutoCommit(false);

            try {
                PreparedStatement withdrawStatement = con.prepareStatement(withdrawQuery);
                PreparedStatement depositStatement = con.prepareStatement(depositQuery);

                withdrawStatement.setDouble(1, 500.00);
                withdrawStatement.setString(2, "acc123");
                depositStatement.setDouble(1, 500.00);
                depositStatement.setString(2, "acc1234");

                int rowsaffedtedwithdraw = withdrawStatement.executeUpdate();
                int rowsaffecteddeposit = depositStatement.executeUpdate();
                if(rowsaffecteddeposit >0 && rowsaffedtedwithdraw>0){
                    con.commit();
                    System.out.println("Transaction Successful!");
                }else{
                    con.rollback();
                    System.out.println("Transaction rolled back: ");
                }


            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
        }
    }
}
