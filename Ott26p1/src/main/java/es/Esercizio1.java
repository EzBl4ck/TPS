package es;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Esercizio1")
public class Esercizio1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	private int getCount = 0;
	private int postCount = 0;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		forms(response.getWriter());
		getCount++;
		stats(response.getWriter());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		forms(response.getWriter());
		postCount++;
		stats(response.getWriter());
	}
	
	private void forms(PrintWriter out) {
		out.println("<html><body>");
		out.println("<form method='get' action='Esercizio1'><button type='submit'>Get</button></form><br>");
		out.println("<form method='post' action='Esercizio1'><button type='submit'>Get</button></form><br>");
		out.println("</body></html>");
	}
	
	private void stats(PrintWriter out) {
		out.println("<html><body>");
		out.println("Chiamate get: "+getCount);
		out.println("Chiamate post: "+postCount);
		out.println("</body></html>");
	}

}
