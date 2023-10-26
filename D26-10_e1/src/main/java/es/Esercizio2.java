package es;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Esercizio2")
public class Esercizio2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	private int getCount = 0;
	private int postCount = 0;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);
		if(req.getMethod().equalsIgnoreCase("get")) {
			getCount++;
		} else if(req.getMethod().equalsIgnoreCase("post")) {
			postCount++;
			resp.getWriter().println("CIao");
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<form method='get' action='Esercizio1'><button type='submit'>Get</button></form><br>");
		out.println("<form method='post' action='Esercizio1'><button type='submit'>Get</button></form><br>");
		out.println("Chiamate get: "+getCount);
		out.println("Chiamate post: "+postCount);
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
