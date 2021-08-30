package data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;

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

    @SneakyThrows
    public static void cleanDB(String base) {
        var conn = getConnection(base);
        QueryRunner qr=new QueryRunner();
        qr.execute(conn,"delete from credit_request_entity");
        qr.execute(conn,"delete from order_entity");
        qr.execute(conn,"delete from payment_entity");
    }

    @SneakyThrows
    public static String getStatusCredit (String base) {
        var conn = getConnection(base);
        QueryRunner qr=new QueryRunner();
        String status = String.valueOf(qr.execute(conn, "select status from credit_request_entity where created = (select max(created) from credit_request_entity)"));
        return status;
    }



}
