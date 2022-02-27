package ru.max.Pract_15;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;

@RestController
@RequestMapping("/show")
public class ShowingController {
    @GetMapping("/all")
    public String showAll() throws SQLException {

        Connection connection = DriverManager.getConnection(
                SQLBaseConfig.DB_URL,
                SQLBaseConfig.DB_USERNAME,
                SQLBaseConfig.DB_PASSWORD);

        String sql = "SELECT * FROM student;";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        String answer = "";
        while (resultSet.next()){
            String firstname = resultSet.getString(1);
            String lastname = resultSet.getString(2);
            String middlename = resultSet.getString(3);
            String groupname = resultSet.getString(4);
            answer += firstname + " : " + lastname + " : " + middlename + " : " + groupname + "\n";
        }
        System.out.println(answer);
        return answer;
    }

    @GetMapping("/{nameG}")
    public String showGroup(@PathVariable String nameG) throws SQLException {
        Connection connection = DriverManager.getConnection(
                SQLBaseConfig.DB_URL,
                SQLBaseConfig.DB_USERNAME,
                SQLBaseConfig.DB_PASSWORD);

        String sql = "SELECT * FROM student WHERE groupname = '" + nameG + "';";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        String answer = "";
        while (resultSet.next()){
            String firstname = resultSet.getString(1);
            String lastname = resultSet.getString(2);
            String middlename = resultSet.getString(3);
            String groupname = resultSet.getString(4);
            answer += firstname + " : " + lastname + " : " + middlename + " : " + groupname + "\n";
        }
        System.out.println(answer);
        return answer;
    }
}
