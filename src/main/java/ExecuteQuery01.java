import java.sql.*;

public class ExecuteQuery01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1. Adim: Driver'a kaydol
        Class.forName("org.postgresql.Driver");

        //2.Adim: Database'e baglan
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Arcane", "postgres","Ilnibah29.");

        //3.Adim: Statement olustur
        Statement st = con.createStatement();

        //1. Orn: region id'si 1 olan "country name" degerlerini cagirin

        String sql1 = "SELECT country_name from  countries where region_id=1";
        boolean sonuc = st.execute(sql1);
        System.out.println("sonuc = " + sonuc);


        //Record/satirlari gormek icn ExecuteQuery() methodunu kullanmaliyiz
       ResultSet rS1 = st.executeQuery(sql1);
        System.out.println("rS1 = " + rS1);

        while (rS1.next()){
            rS1.getString(1); // veya rS1.getString("country_name");
            System.out.println(rS1.getString(1));
        }
//2. orn: "region_id'nin 2'den buyuk oldugu "country_id" ve "country_name" degerlerini cagirin
    String sql2 = "select country_id,country_name from countries where region_id>2";
        boolean sonuc2 = st.execute(sql2);
        System.out.println("sql2 = " + sql2);

        ResultSet rs2 = st.executeQuery(sql2);
        System.out.println("rs2 = " + rs2);

        while (rs2.next()){
            String a = rs2.getString(1); // veya  String a = rs2.getString("country_id");
            String b = rs2.getString(2); // veya  String a = rs2.getString("country_name");

            String c = rs2.getString("country_name");
            System.out.println(a+ " -> "+ b+ " : "+ c);
        }
        con.close();
        st.close();

    }
}
