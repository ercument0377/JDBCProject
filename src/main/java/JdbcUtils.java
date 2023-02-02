import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcUtils {
    public static void main(String[] args) {
        connectToDataBase();
        createStatement();
    }

    private static Connection connection;
    private static Statement statement;
    //1. Adim: Driver'a kaydol
    //2.Adim: Database'e baglan
    public static Connection connectToDataBase(){

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Arcane", "postgres","Ilnibah29.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (connection!=null){
            System.out.println("Connection Basarili");
        }else{
            System.out.println("Connection Basarisiz");
        }


        return connection;
    }
    //3.Adim: Statement olustur
    public static Statement createStatement(){

        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }


}