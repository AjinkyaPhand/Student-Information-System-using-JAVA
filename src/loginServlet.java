

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
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text.html");
		PrintWriter out=response.getWriter();
		
		String user=request.getParameter("user");
		//out.println(user);
		String pass=request.getParameter("password");
		
		try {
			DB db=new DB();
			ResultSet rs=db.checkUser(user,pass);
			if(rs.next()) {
				//out.println(rs.getInt(1));
				HttpSession httpSession=request.getSession(true);
				httpSession.setAttribute("u", rs.getInt(1));
				RequestDispatcher dispatcher=request.getRequestDispatcher("home.html");
				dispatcher.forward(request, response);
			}
			else {
				out.println("<h1 align='center'>INCORRECT USERNAME/PASSWORD</h1>");
				RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
				dispatcher.include(request, response);
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
