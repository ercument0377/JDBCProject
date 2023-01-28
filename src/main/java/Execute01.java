import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.adım: driver e kaydol
        Class.forName("org.postgresql.Driver");


        //2.adım: Database ye baglan
     Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Arcane", "postgres", "Ilnibah29.");

    //3.adım: Statement olustur
        Statement st = con.createStatement();

        System.out.println("Baglanti basarili");


        //4.adım: Query (sorgu) olustur
       boolean sql1 = st.execute("Create Table workers(worker_id VARCHAR(20),worker_name VARCHAR(20), worker_salary INT)");
        System.out.println("sql1 = " + sql1); //false dondurur cunku data cağırmıyoruz sadece olusturduk

        /*
        execute() methodu DDL -data definition language- (create, drop, alter, table) ve DQL -data query language- sellect için kullanılabilir
        1. eger  execute() methodu DDL icin kullanılırsa "false" döndurur(return eder)
        2. execute() methodu DQL icin kullanılırsa ResultSet (sonuc/data/veri) alındığında "true" aksı halde false dondurur

         */

        //2. Ornek: Table'a worker_address sutunu ekleyerek alter yapin

        String sql2 = "Alter Table workers Add worker_address VARCHAR(80)";
       boolean sql2a = st.execute(sql2);
        System.out.println("sql2a = " + sql2a);

        //3.Ornek: workers table'ini silin

        String sql3 = "Drop Table workers";
        boolean sql3a = st.execute(sql3);
        System.out.println("sql3a = " + sql3a);

        //5.adım : Bağlantı ve Statement i kapat

        con.close();
        st.close();





    }
}
