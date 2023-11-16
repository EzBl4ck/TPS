package es;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletSomma")
public class ServletSomma extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int somma = 0;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int numero = Integer.parseInt(req.getParameter("numero"));
		somma += numero;
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.println("<html><body><h1>La somma è: "+somma+
				"</h1><br><a  href='index.html'>Inserisci un altro numero</a></body></html>");
	}

}
