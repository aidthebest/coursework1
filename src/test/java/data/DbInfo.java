package data;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbInfo {

    public DbInfo() {

    }

    @SneakyThrows
    private static Connection getConnection(String base) {
        if (base.equalsIgnoreCase("postgresql")) {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/stage", "postgres", "secret");
        } else {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
        }
    }

//    @SneakyThrows
//    public static void cleanDB() {
//        var conn = getConnection(String base);
//        QueryRunner qr=new QueryRunner();
////        qr.execute(conn,"delete from auth_codes");
////        qr.execute(conn,"delete from card_transactions");
////        qr.execute(conn,"delete from cards");
////        qr.execute(conn,"delete from users");
//    }
}
