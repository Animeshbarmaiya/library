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
@WebServlet("/insertbook")
public class AddBooks extends GenericServlet{

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

			PreparedStatement ps1=con.prepareStatement("insert into books(id,name,AuthorName,Goner,Price)values(?,?,?,?,?)");
			ps1.setInt(1, Integer.parseInt(id));
			ps1.setString(2, name);
			ps1.setString(3,Author);
			ps1.setString(4,joner);
			ps1.setInt(5,Integer.parseInt(Price));
			 int rowaffected=ps1.executeUpdate();
			 if(rowaffected>0) {
				 PrintWriter pw=res.getWriter();
					pw.print("<h4> "+name+" inserted Successfully</h4>");
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
