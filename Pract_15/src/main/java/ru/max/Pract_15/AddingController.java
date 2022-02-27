package ru.max.Pract_15;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@RestController
@RequestMapping("/add")
public class AddingController {
    @GetMapping("/{full}")
    public String addStudent(@PathVariable String full){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    SQLBaseConfig.DB_URL,
                    SQLBaseConfig.DB_USERNAME,
                    SQLBaseConfig.DB_PASSWORD);
        } catch (SQLException e) {
            System.err.println("No connection to database");
            return "No connection to database";
        }

        String sql = "insert into student (firstname, secondname, middlename, groupname) values (?, ?, ?, ?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            System.err.println("Column not found");
            return "Column not found";
        }

        String[] names = full.split("\\.");

        try {
            preparedStatement.setString(1, names[0]);
            preparedStatement.setString(2, names[1]);
            preparedStatement.setString(3, names[2]);
            preparedStatement.setString(4, names[3]);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("This student is already exists");
            return "This student is already exists";
        }



        System.out.println("Student" + names[0] + "enters group" + names[3]);
        return "Student" + names[0] + "enters group" + names[3];
    }
}
