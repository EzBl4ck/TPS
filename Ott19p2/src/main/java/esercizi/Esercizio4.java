package esercizi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Esercizio4")
public class Esercizio4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	record User (String username, String password) {}
	
	private ArrayList<User> array = new ArrayList<>();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String username = request.getParameter("usename");
		String password = request.getParameter("password");
		User user = new User(username, password);
		if(array.contains(user)) {
			out.println("<html><body>");
			out.println("Sei loggato");
			out.println("</body></html>");
		} else {
			array.add(user);
			out.println("<html><body>");
			out.println("Sei registrato");
			out.println("</body></html>");
		}
	}

}
