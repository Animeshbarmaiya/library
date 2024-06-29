<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Books By Genre</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-image: url('https://images2.alphacoders.com/130/thumb-1920-1301375.jpg'); /* Add your background image URL here */
        background-size: cover;
        background-repeat: no-repeat;
        background-position: center;
        display: flex;
        flex-direction: column;
        align-items: center;
        height: 100vh;
        margin: 0;
        color: #fff; /* Text color */
    }

    h1 {
        margin-top: 50px;
        color: #fff;
        background-color: rgba(128, 0, 0, 0.8); /* Maroon tone */
        padding: 10px 20px;
        border-radius: 5px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    }

    table {
        margin-top: 20px;
        background-color: rgba(255, 255, 255, 0.9);
        border-collapse: collapse;
        width: 80%;
        max-width: 800px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        border-radius: 10px;
        overflow: hidden;
    }

    th, td {
        padding: 12px 15px;
        text-align: left;
        border-bottom: 1px solid #ddd;
        color: #333; /* Table text color */
    }

    th {
        background-color: #800000; /* Maroon */
        color: #fff; /* Header text color */
    }

    tr:hover {
        background-color: #f1f1f1;
    }

    p {
        margin-top: 20px;
        background-color: rgba(128, 0, 0, 0.8); /* Maroon tone */
        color: #fff;
        padding: 10px 20px;
        border-radius: 5px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    }
</style>
</head>
<body>
    <h1>Books By Genre</h1>
    <% 
    String goner = request.getParameter("goner");
    if (goner != null) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "Animesh@1998");
            PreparedStatement ps = con.prepareStatement("select * from books where Goner=?");
            ps.setString(1, goner);
            ResultSet rs = ps.executeQuery();
    %>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Author Name</th>
                <th>Genre</th>
                <th>Price</th>
            </tr>
        </thead>
        <tbody>
        <% 
        while (rs.next()) {
        %>
            <tr>
                <td><%= rs.getInt(1) %></td>
                <td><%= rs.getString(2) %></td>
                <td><%= rs.getString(3) %></td>
                <td><%= rs.getString(4) %></td>
                <td><%= rs.getInt(5) %></td>
            </tr>
        <% 
        }
        %>
        </tbody>
    </table>
    <% 
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else {
    %>
    <p>Please enter a valid genre.</p>
    <%
    }
    %>
</body>
</html>
