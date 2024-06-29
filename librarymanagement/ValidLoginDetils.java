package LibraryManagementSystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.httpservlet.Httpservlet;
@WebServlet("/FetchallData")
public class ValidLoginDetils extends Httpservlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getCookies()==null) {
		String email=req.getParameter("email");
		String psw=req.getParameter("psw");
		Cookie cookie1=new Cookie("email",email);
		Cookie cookie2=new Cookie("password", psw);
		resp.addCookie(cookie1);
		resp.addCookie(cookie2);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/university","root","Animesh@1998");
			PreparedStatement ps=con.prepareStatement("select * from libraryuser where email=? and Passward=?");
			ps.setString(1, email);
			ps.setString(2, psw);
			ResultSet rst= ps.executeQuery();
			if (rst.next()) 
			{
				RequestDispatcher rd=req.getRequestDispatcher("option.html");
				rd.forward(req, resp);
			}
			else 
			{
				PrintWriter pw=resp.getWriter();
				pw.print("<h3>wrong Details</h3>");
			}
		  }
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else 
		{
			RequestDispatcher rd=req.getRequestDispatcher("option.html");
			rd.forward(req, resp);
		}
		
	}

}
