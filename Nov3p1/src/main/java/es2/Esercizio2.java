package es2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Esercizio2")
public class Esercizio2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html><body><form action='Esercizio2' method='post'>");
		out.println("<label>Nome: </label><input type='text' name='nome'><br>");
		out.println("<label>Cognome: </label><input type='text' name='cognome'><br>");
		out.println("<label>Età: </label><input type='number' name='eta' min='1'><br>");
		out.println("<input type='submit'>");
		out.println("</form></body></html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String cognome = req.getParameter("cognome");
		String eta = req.getParameter("eta");
		Cookie c1 = new Cookie("nome", nome);
		Cookie c2 = new Cookie("cognome", cognome);
		Cookie c3 = new Cookie("eta", eta);
		resp.addCookie(c1);
		resp.addCookie(c2);
		resp.addCookie(c3);
		resp.setContentType("text/html");
		resp.getWriter().println("<html><body><a href='Biscotto'>Vai al biscotto</a></body></html>");
		
	}
	
	
}
