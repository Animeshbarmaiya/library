package LibraryManagementSystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/updatebook")
public class updatebook extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String Author=req.getParameter("Author");
		String Price=req.getParameter("Price");
		String joner=req.getParameter("joner");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/university","root","Animesh@1998");
			
			PreparedStatement ps3=con.prepareStatement("update  Books set name=?,authorName=?,Goner=?,Price=? where id=?");
			ps3.setString(1, name);
			ps3.setString(2, Author);
			ps3.setString(3, joner);
			ps3.setInt(4, Integer.parseInt(Price));
			ps3.setInt(5,Integer.parseInt(id));
			int rowaffected=ps3.executeUpdate();
			 if(rowaffected>0) {
				 PrintWriter pw=res.getWriter();
					pw.print("<h4>"+id+" Updated Successfully</h4>");
			 }else {
				 PrintWriter pw=res.getWriter();
					pw.print("<h4>something is wrong</h4>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	


