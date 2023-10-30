package esercizi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Esercizio2")
public class Esercizio2 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	int nTentativi = 0;
	ArrayList<Integer> numeri;
	final int MAX_TENTATIVI = 10;
	int num;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Random random = new Random();
		num = random.nextInt(0, 1001);
		numeri = new ArrayList<>(10);
		writeForm(response);
	}
	
	private void writeForm(HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		response.getWriter().print("<!DOCTYPE html>\n"
				+ "<html>\n"
				+ "<head>\n"
				+ "	<meta charset=\"UTF-8\">\n"
				+ "	<title>Insert title here</title>\n"
				+ "</head>\n"
				+ "<body>\n"
				+ "	<form method=\"post\" action=\"Esercizio2\">\n"
				+ "		<input type=\"number\" name=\"numero\" placeholder=\"Inserisci numero\"><br>\n"
				+ "		<input type=\"submit\">"
				+ "	</form>\n"
				+ "	" + num +"\n" //questa linea è solo per testing 
				+ "</body>\n"
				+ "</htm");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		if(nTentativi == MAX_TENTATIVI) {
			response.getWriter().println("Hai perso! Hai esaurito i tentativi a tua disposizione. Le tue scelte sono state: "+numeri);
			return;
		}
		int guess = Integer.parseInt(request.getParameter("numero"));
		synchronized (this) {
			nTentativi++;
		}
		
		if(guess == num) {
			response.getWriter().println("Bravo! Hai indovinato utilizzando "+ nTentativi +" tentativi");
		} else if(guess < num) {
			response.getWriter().println("Peccato, il valore scelto è troppo basso, ti rimangono "+ (MAX_TENTATIVI - nTentativi) +" tentativi");
			writeForm(response);
		} else {
			response.getWriter().println("Peccato, il valore scelto è troppo alto, ti rimangono "+ (MAX_TENTATIVI - nTentativi) +" tentativi");
			writeForm(response);
		}
	}

}
