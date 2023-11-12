package esercizi;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Esercizio1")
public class Esercizio1 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		//response.setContentType("text/html");
		String nome = request.getParameter("nome");
		Date data;
		SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
		try {
			data = new SimpleDateFormat("yyyy-mm-dd").parse(request.getParameter("data"));
		} catch (ParseException e) { data = null; }
		String sesso = request.getParameter("sesso");
		String[] sports = request.getParameterValues("sports");
		StringBuilder builder = new StringBuilder();
		for(String s : sports) {
			builder.append(s);
			builder.append(", ");
		}
		String sportList = builder.toString();
		
		out.print("<!DOCTYPE html>\n"
				+ "<html>\n"
				+ "<head>\n"
				+ "	<meta charset=\"UTF-8\">\n"
				+ "	<title>Insert title here</title>\n"
				+ "</head>\n"
				+ "<body>\n"
				+ "	<section>\n"
				+ "		Nome: "+nome+"<br>\n"
				+ "		Data: "+formatter.format(data)+"<br>\n"
				+ "		Sesso: "+sesso+"<br>\n"
				+ "		Sports:"+sportList+"<br>\n"
				+ "	</section><br>\n"
				+ "	<form method=\"post\" action=\"Esercizio1\">\n"
				+ "		<label>Nome: </label><input type=\"text\" name=\"nome\"><br>\n"
				+ "		<label>Data: </label><input type=\"date\" name=\"data\"><br>\n"
				+ "		Sesso: \n"
				+ "		<label for=\"uomo\">Uomo</label><input type=\"radio\" name=\"sesso\" id=\"uomo\" value=\"Uomo\">\n"
				+ "		<label for=\"donna\">Donna</label><input type=\"radio\" name=\"sesso\" id=\"donna\" value=\"Donna\">\n"
				+ "		<br>\n"
				+ "		Sport:<br>\n"
				+ "		<label for=\"na\">Nessuno Sport</label><input type=\"checkbox\" name=\"sports\" value=\"Nessuno Sport\" id=\"na\"><br>\n"
				+ "		<label for=\"calcio\">Calcio</label><input type=\"checkbox\" name=\"sports\" value=\"Calcio\" id=\"calcio\"><br>\n"
				+ "		<label for=\"pallavolo\">Pallavolo</label><input type=\"checkbox\" name=\"sports\" value=\"Pallavolo\" id=\"pallavolo\"><br>\n"
				+ "		<label for=\"basket\">Basket</label><input type=\"checkbox\" name=\"sports\" value=\"Basket\" id=\"basket\"><br>\n"
				+ "		<input type=\"submit\">"
				+ "	</form>\n"
				+ "</body>\n"
				+ "</htm");
		
		
	}

}
