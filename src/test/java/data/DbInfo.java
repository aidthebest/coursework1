package data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbInfo {

    public DbInfo() {

    }

    @SneakyThrows
    private static Connection getConnection() {
        System.getProperty("datasource.url");
        var property = System.getProperty("datasource.url");
        return DriverManager.getConnection(property, "app", "pass");
    }

    @SneakyThrows
    public static void cleanDB() {
        var conn = getConnection();
        QueryRunner qr=new QueryRunner();
        qr.execute(conn,"delete from credit_request_entity");
        qr.execute(conn,"delete from order_entity");
        qr.execute(conn,"delete from payment_entity");
    }

    @SneakyThrows
    public static String getStatusCredit () {
        var conn = getConnection();
        QueryRunner qr = new QueryRunner();
        var status = "select status from credit_request_entity where created = (select max(created) from credit_request_entity);";
        return qr.query(conn, status, new ScalarHandler<>());
    }



}
