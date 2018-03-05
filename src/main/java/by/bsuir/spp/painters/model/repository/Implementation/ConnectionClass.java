package by.bsuir.spp.painters.model.repository.Implementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionClass {
    public static Properties createPropsGeneral(String host, String port, String database, String user, String password) {
        Properties props = new Properties();
        props.put("host", host);
        props.put("port", port);
        props.put("database", database);
        props.put("user", user);
        props.put("password", password);
        return props;
    }
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql:", createPropsGeneral("localhost", "3306", "art_stage", "root", "1111"));
    }

}
