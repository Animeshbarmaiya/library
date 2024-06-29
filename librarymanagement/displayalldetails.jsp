<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Library Management</title>
<style>
    body {
        font-family: 'Arial', sans-serif;
        background-image: url('https://wallpapercave.com/wp/wp6932394.jpg');
        background-size: cover;
        background-repeat: no-repeat;
        background-position: center;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        padding: 20px; /* Added padding to center the table */
    }

    table {
        width: 100%;
        border-collapse: collapse;
        color: #333;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        font-size: 16px;
    }

    th, td {
        padding: 12px;
        border: 1px solid rgba(255, 255, 255, 0.5); /* Adjust border color for better contrast */
        text-align: left;
        font-weight: bold; /* Make text bold */
    }

    th {
        background-color: maroon; /* Maroon background for header */
        color: yellow; /* Yellow text color for header */
    }

    td {
        background-color: rgba(255, 255, 255, 0.7); /* Light background color for table cells */
        color: black; /* Black text color for table cells */
    }

    tr:nth-child(even) td {
        background-color: rgba(255, 255, 255, 0.9); /* Slightly different background for even rows */
    }

    tr:hover td {
        background-color: maroon; /* Highlight row on hover */
        color: white; /* Change text color on hover */
    }

    @media screen and (max-width: 600px) {
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            padding: 8px;
        }
    }
</style>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Author Name</th>
                <th>Genre</th>
                <th>Price</th>
            </tr>
        </thead>
        <tbody>
            <% 
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university","root","Animesh@1998");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM books");
            while(rs.next()) {
            %>
            <tr>
                <td><%=rs.getInt(1) %></td>
                <td><%=rs.getString(2) %></td>
                <td><%=rs.getString(3) %></td>
                <td><%=rs.getString(4) %></td>
                <td><%=rs.getInt(5) %></td>
            </tr>
            <% }
            %>
        </tbody>
    </table>
</body>
</html>
