package es2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Biscotto")
public class Biscotto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();
		if(cookies == null) {
			return;
		}
		String nome = "", cognome = "", eta = "";
		
		for(Cookie c : cookies) {
			switch(c.getName()) {
				case "nome" -> nome = c.getValue();
				case "cognome" -> cognome = c.getValue();
				case "eta" -> eta = c.getValue();
			}
		}
		
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		out.println("<html><body>");
		out.println("Nome: "+nome+"<br>");
		out.println("Cognome: "+cognome+"<br>");
		out.println("Età: "+eta+"<br>");
		out.println("</body></html>");
	}
}
