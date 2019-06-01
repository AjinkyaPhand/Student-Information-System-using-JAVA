

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class viewAllRecord
 */
@WebServlet("/viewAllRecord")
public class viewAllRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewAllRecord() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher dispatcher=request.getRequestDispatcher("adminhome.html");
		dispatcher.include(request, response);
		out.println("<br><br>");
		try {
			DB db=new DB();
			ResultSet rs=db.getAllRecords();
			out.println("<table border='5px' align='center' height='80%' width='80%'");
			out.println("<tr><th>NAME</th><th>CONTACT</th><th>YEAR</th><th>COURSE</th><th>EMAIL</th><th>PASSWORD</th>");
			out.println("</tr>");
	
			while(rs.next()) {
				int id=rs.getInt(1);
				out.println("<tr><td>"+rs.getString(2)+"</td>");
				out.println("<td>"+rs.getString(3)+"</td>");
				out.println("<td>"+rs.getString(4)+"</td>");
				out.println("<td>"+rs.getString(5)+"</td>");
				out.println("<td>"+rs.getString(6)+"</td>");
				out.println("<td>"+rs.getString(7)+"</td>");
				out.println("<td><a href='del?d="+id+"'>DELETE</a></td>");
				
				out.println("</tr>");
				
			}
			out.println("</table>");

			
		} catch (Exception e) {
			// TODO: handle exception
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
