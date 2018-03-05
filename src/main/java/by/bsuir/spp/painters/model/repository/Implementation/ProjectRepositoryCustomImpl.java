package by.bsuir.spp.painters.model.repository.Implementation;

import by.bsuir.spp.painters.model.Project;
import by.bsuir.spp.painters.model.repository.ProjectRepositoryCustom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Properties;


public class ProjectRepositoryCustomImpl implements ProjectRepositoryCustom {
    /*@Query("UPDATE project SET Name = ?2, State = ?3, Description = ?4 WHERE Id = ?1")
    void updateById(Project project);*/
    public void updateById(Project project) throws SQLException
    {
        Connection connMysql = DriverManager.getConnection("jdbc:mysql:", createPropsGeneral("localhost", "3306", "art_stage", "sasha", "sasha"));

        String query = "UPDATE project SET Name = ?2, State = ?3, Description = ?4 WHERE Id = ?1";

    }
    public static Properties createPropsGeneral(String host, String port, String database, String user, String password) {
        Properties props = new Properties();
        props.put("host", host);
        props.put("port", port);
        props.put("database", database);
        props.put("user", user);
        props.put("password", password);
        return props;
    }
}
