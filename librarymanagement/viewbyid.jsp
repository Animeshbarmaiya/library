<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>View Book by ID</title>
<style>
    body {
        background-image: url('https://wallpaperaccess.com/full/314135.jpg');
        background-size: cover;
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 20px;
        color: #ffffff;
        display: flex;
        flex-direction: column;
        align-items: center;
    }
    table {
        width: 80%;
        border-collapse: collapse;
        margin-top: 20px;
        background-color: rgba(0, 0, 0, 0.8);
        box-shadow: 0 0 15px rgba(0, 0, 0, 0.5);
        border-radius: 10px;
        overflow: hidden;
        animation: fadeIn 1s ease-in-out;
    }
    th, td {
        padding: 12px;
        border: 1px solid #dddddd;
        text-align: left;
        color: #ffffff;
    }
    th {
        background-color: #b22222; /* Maroon */
    }
    tr:nth-child(even) {
        background-color: rgba(255, 255, 0, 0.2); /* Yellow */
    }
    tr:nth-child(odd) {
        background-color: rgba(255, 255, 255, 0.1); /* Light white */
    }
    tr:hover {
        background-color: rgba(255, 255, 255, 0.3);
        transition: background-color 0.3s ease;
    }
    h1 {
        color: #ffcc00; /* Yellow */
        text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.7);
    }
    p {
        color: #ffffff;
        text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.7);
    }
    @keyframes fadeIn {
        from {
            opacity: 0;
            transform: translateY(-20px);
        }
        to {
            opacity: 1;
            transform: translateY(0);
        }
    }
</style>
</head>
<body>
    <h1>Book Details</h1>
    <% 
    String id = request.getParameter("book-id");
    if (id != null && !id.trim().isEmpty()) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "Animesh@1998");
            PreparedStatement ps = con.prepareStatement("select * from books where id=?");
            ps.setInt(1, Integer.parseInt(id));
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
    <p>Please enter a valid book ID.</p>
    <% 
    }
    %>
</body>
</html>
