package LibraryManagementSystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.httpservlet.Httpservlet;
@WebServlet("/isssue")
public class issuebookservlet extends Httpservlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("issuebook"));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/university","root","Animesh@1998");
			PreparedStatement ps=con.prepareStatement("delete from books where id=?");
			ps.setInt(1, id);
			int n=ps.executeUpdate();
			if(n==0) {
				PrintWriter pw=resp.getWriter();
				pw.print("<h1>Wrong Input</h1>");
			}else {
			PrintWriter pw=resp.getWriter();
			pw.print("<h1>Book issued</h1>");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
