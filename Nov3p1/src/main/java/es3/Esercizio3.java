package es3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Esercizio3")
public class Esercizio3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.print("<html><body><form method='POST' action='Esercizio3'><table>");
		out.print("<th colspan='2'>Login</th>");
		out.print("<tr><td><label for='username'>Username: </label></td><td><input type='text' name='username'></td></tr>");
		out.print("<tr><td><label for='password'>Password: </label></td><td><input type='text' name='password'></td></tr>");
		out.print("<tr><td colspan='2'><input type='submit'></td></tr>");
		out.print("</table></form></body></html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
	
	
	
}
