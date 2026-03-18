import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ImageInsert {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/company";
        String username = "root";
        String password = "Tejas@123";
        String img_path = "C:\\Users\\Tejas Gaikwad\\Downloads\\Profile Profestional .jpg";
        String query = "INSERT INTO image(image_data) VALUES (?);";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection con = DriverManager.getConnection(url,username,password);
            FileInputStream fileInputStream = new FileInputStream(img_path);
            byte[] img_data = new byte[fileInputStream.available()];
            fileInputStream.read(img_data);
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setBytes(1,img_data);

            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected >0){
                System.out.println("Inserted data");
            }else{
                System.out.println("failed");
            }


        }catch(SQLException e){
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
