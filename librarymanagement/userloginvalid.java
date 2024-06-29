package LibraryManagementSystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/useroption")
public class userloginvalid extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("psw"); // Correct parameter name

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "Animesh@1998");
            PreparedStatement ps = con.prepareStatement("select * from user where email=? and passward=?");
            ps.setString(1, email);
			ps.setString(2, password);
            ResultSet rset=ps.executeQuery();
            if(rset.next()) {
            RequestDispatcher rs=req.getRequestDispatcher("useroption.html");
            rs.forward(req, resp);
            }else {
				PrintWriter pw=resp.getWriter();
				pw.print("<h1>wrong input</h1>");
			}
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println("Wrong Input: " + e.getMessage());
        }
    }
}
