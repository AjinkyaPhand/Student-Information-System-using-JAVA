

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class insertStudentRecord
 */
@WebServlet("/insertStudentRecord")
public class insertStudentRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertStudentRecord() {
        super();
     // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text.html");
		PrintWriter out=response.getWriter();
		
		String fname=request.getParameter("firstname");
		String cont=request.getParameter("contact");
		String year=request.getParameter("year");
		String course=request.getParameter("course");
		String email=request.getParameter("emailid");
		String pass=request.getParameter("password");
		  
		
	
		try {
			DB db=new DB();
			boolean b=db.insertRecord(fname,cont,year,course,email,pass);
			if(b) {
				out.println("<h1>!!!REGISTERED SUCCESFULLY!!!</h1>");
				out.println("<h1><a href='login.jsp' align='center'>!!!BACK TO LOGIN!!!</a></h1>");
			}
			else {
				out.println("FAILED TO REGISTER");
			}
		} catch (Exception e) {
			out.println("Exception is "+e);
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
