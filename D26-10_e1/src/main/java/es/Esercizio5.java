package es;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Esercizio5")
public class Esercizio5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		super.init();
		libri = new ArrayList<>();
	}
	
	private ArrayList<Libro> libri ;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		writeForm(resp, "");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String tipo = req.getParameter("tipo");
		String risposta = "";
		if(tipo.equals("insert")) {
			int nPagine = Integer.parseInt(req.getParameter("numPagine"));
			String titolo = req.getParameter("titolo");
			String autore = req.getParameter("autore");
			Libro libro = new Libro();
			libro.setAutore(autore);
			libro.setNumeroPagine(nPagine);
			libro.setTitolo(titolo);
			synchronized (this) {
				libri.add(libro);
			}
			risposta = "Libro inserito";
		} else {
			risposta = libri.toString();
		}
		writeForm(resp, risposta);
	}
	
	private void writeForm(HttpServletResponse resp, String textResponse) throws IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.println("<html><body><form action='Esercizio5' method='post'>");
		pw.println("<label for='inserisci'>Inserisci</label><input type='radio' name='tipo' id='inserisci' value='insert' checked='true'>");
		pw.println("<label for='visualizza'>Visualizza</label><input type='radio' name='tipo' id='visualizza' value='view'><br>");
		pw.println("<label>Titolo</label><input type='text' name='titolo' /><br>");
		pw.println("<label>Autore</label><input type='text' name='autore' /><br>");
		pw.println("<label>Numero pagine</label><input type='number' min='0' name='numPagine' /><br>");
		pw.println("<input type='submit' /><br>");
		pw.println("</form><div name='response'>"+textResponse+"</div></body></html>");
	}
	
	private class Libro {
		private int numeroPagine;
		private String titolo;
		private String autore;
		
		public Libro() {}
		
		public int getNumeroPagine() {
			return numeroPagine;
		}
		public void setNumeroPagine(int numeroPagine) {
			this.numeroPagine = numeroPagine;
		}
		public String getTitolo() {
			return titolo;
		}
		public void setTitolo(String titolo) {
			this.titolo = titolo;
		}
		public String getAutore() {
			return autore;
		}
		public void setAutore(String autore) {
			this.autore = autore;
		}
		
		@Override
		public String toString() {
			return "{" + titolo + ", " + autore + ", " + numeroPagine + "}";
		}
		
	}
}
