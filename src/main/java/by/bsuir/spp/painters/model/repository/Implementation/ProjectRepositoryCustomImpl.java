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

import static by.bsuir.spp.painters.model.repository.Implementation.ConnectionClass.createPropsGeneral;
import static by.bsuir.spp.painters.model.repository.Implementation.ConnectionClass.getConnection;


public class ProjectRepositoryCustomImpl implements ProjectRepositoryCustom {

    public void updateById(Project project) throws SQLException
    {
        Connection connMysql = getConnection();

        String query = "UPDATE project SET Name = ?, State = ?, Description = ? WHERE Id = ?";
        PreparedStatement ps = connMysql.prepareStatement(query);
        ps.setString(1,project.getName());
        ps.setString(2, project.getState());
        ps.setString(3, project.getDescription());
        ps.setInt(4, project.getId());
        ps.execute();
    }

}
