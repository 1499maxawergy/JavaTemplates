package ru.max.Pract_15;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/remove")
public class RemovingController {
    @GetMapping("/all")
    public String removeAll() throws SQLException {
        Connection connection = DriverManager.getConnection(
                SQLBaseConfig.DB_URL,
                SQLBaseConfig.DB_USERNAME,
                SQLBaseConfig.DB_PASSWORD);

        String sql = "DELETE FROM student;";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        System.out.println("All groups removed");
        return "All groups removed";
    }

    @GetMapping("/{group}")
    public String removeStudentByGroup(@PathVariable String group) throws SQLException {
        Connection connection = DriverManager.getConnection(
                SQLBaseConfig.DB_URL,
                SQLBaseConfig.DB_USERNAME,
                SQLBaseConfig.DB_PASSWORD);

        String sql = "DELETE FROM student WHERE groupname = '" + group + "';";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        System.out.println("Executed");
        return "Executed";
    }
}
