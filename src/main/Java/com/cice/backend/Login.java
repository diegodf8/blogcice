package com.cice.backend;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/Login")

public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        String pass = req.getParameter("pass");

        System.out.println("Salida login: " + user + "   " + pass);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/diego", "root", "root");
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM usuarios WHERE user='"+user+"' and pass='"+pass+"'";
            ResultSet resultado = statement.executeQuery(sql);

            if (resultado.first()){
                //TODO: Responder con login correcto
            }
            else{
                //TODO: Responder con login incorrecto
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }
}
