package LibraryManagementSystem;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/option")
public class Options extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int id=Integer.parseInt((req.getParameter("chooseoption")));
		switch (id) {
		case 1:{
			RequestDispatcher rd=req.getRequestDispatcher("Addbookform.html");
			rd.forward(req, res);
		}
			break;
		case 2:{
			RequestDispatcher rd=req.getRequestDispatcher("Update.html");
			rd.forward(req, res);
			break;
		}
		case 3:{
			RequestDispatcher rd=req.getRequestDispatcher("displayalldetails.jsp");
			rd.forward(req, res);
			break;
		}
		case 4:{
			RequestDispatcher rd=req.getRequestDispatcher("veiwbookbyid.html");
			rd.forward(req, res);
			break;
		}
		case 8:{
			RequestDispatcher rd=req.getRequestDispatcher("issuebyid.html");
			rd.forward(req, res);
			break;
		}
		case 9:{
			RequestDispatcher rd=req.getRequestDispatcher("Returnbookform.html");
			rd.forward(req, res);
			break;
		}
		case 5:{
			RequestDispatcher rd=req.getRequestDispatcher("Goner.html");
			rd.forward(req, res);
			break;
		}
		case 6:{
			RequestDispatcher rd=req.getRequestDispatcher("deletebook.html");
			rd.forward(req, res);
			break;
		}
		default:
			break;
		}
		
	}
	
}
