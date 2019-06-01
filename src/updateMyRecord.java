

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class updateMyRecord
 */
@WebServlet("/updateMyRecord")
public class updateMyRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateMyRecord() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text.html");
		PrintWriter out=response.getWriter();
		RequestDispatcher dispatcher=request.getRequestDispatcher("home.html");
		dispatcher.include(request, response);
		HttpSession httpSession=request.getSession();
		int id=(Integer)httpSession.getAttribute("u");
		out.println("<br><br>");
		try {
			DB db=new DB();
			ResultSet rs=db.getMyOwnRecord(id);
			if(rs.next()) {
			out.println("<table border='5' align='center' width='80%' height='80%'>");
			out.println("<form name='frm' method='POST' action=''>");
			out.println("<tr><td>ENTER NEW NAME</td><td><input type='text' name='name' value='"+rs.getString(2)+"'  style='width:100%;height:15%'/></td></tr>");
			out.println("<tr><td>ENTER NEW CONTACT</td><td><input type='text' name='cont' value='"+rs.getString(3)+"' style='width:100%;height:15%'/></td></tr>");
			out.println("<tr>");
			out.println("<td>SELECT YEAR</td>");
			out.println("<td><select name=year>");
			out.println("<option value="+rs.getString(4)+">"+rs.getString(4)+"</option>");
			out.println("<option value=FE>FE</option>");
			out.println("<option value=SE>SE</option>");
			out.println("<option value=TE>TE</option>");
			out.println("<option value=BE>BE</option>");
			out.println("</select></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>SELECT COURSE</td>");
			out.println("<td><select name=course>");
			out.println("<option value="+rs.getString(5)+">"+rs.getString(5)+"</option>");
			out.println("<option value=MECH>MECH</option>");
			out.println("<option value=COMP>COMP</option>");
			out.println("<option value=IT>IT</option>");
			out.println("<option value=CIVIL>CIVIL</option>");
			out.println("</select></td>");
			out.println("</tr>");
			out.println("<tr><td>ENTER NEW EMAIL</td><td><input type='text' name='email' value='"+rs.getString(6)+"' "
					+ " style='width:100%;height:15%'/></td></tr>");
			out.println("<tr><td>ENTER NEW PASSWORD</td><td><input type='password' name='pass' value='"+rs.getString(7)+"'  "
					+ "style='width:100%;height:15%'/></td></tr>");
			 out.println("<tr><td colspan='2' align='center'><input type='submit' name='s' value='Update Record'  style='width:50%;height:15%'/></td></tr>");
			 out.println("</table>");
			 out.println("</form>");
			}
			
			String btn=request.getParameter("s");
			if(btn!=null) {
				String fname=request.getParameter("name");
				String cont=request.getParameter("cont");
				String year=request.getParameter("year");
				String course=request.getParameter("course");
				String email=request.getParameter("email");
				String pass1=request.getParameter("pass");
				DB db1=new DB();
				boolean b=db1.updateMyOwnRecord(id,fname,cont,year,course,email,pass1);
				if(b) {
					RequestDispatcher dispatcher1=request.getRequestDispatcher("view");
					dispatcher1.forward(request, response);
					out.println("<h1 align='center'>UPDATED SUCCESSFULLY</h1>");
					
				}
				else {
					out.println("<h1 align='center'>FAILED TO UPDATE</h1>");
				}
			}
			
			
			
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
