package es;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletLibri")
public class ServletLibri extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String INSERISCI = "inserisci";
	private static final String CANCELLA = "cancella";
	private static final String RICERCA = "ricerca";
	private static final String VISUALIZZA = "visualizza";
	private ArrayList<Libro> libri = new ArrayList<>();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		pw.println("<html><body>");
		String operazione = req.getParameter("submit");
		
		switch(operazione) {
		case INSERISCI -> {
			String titolo = req.getParameter("titolo");
			String casaEditrice = req.getParameter("casa-editrice");
			String codice = req.getParameter("codice");
			
			if(titolo.equals("") || casaEditrice.equals("") || codice.equals("")) {
				pw.println("<h1>I campi non devono essere vuoti</h1>");
			} else {
				boolean codiceUnivoco = true;
				for(Libro libro : libri) {
					if(libro.getCodice().equals(codice)) {
						codiceUnivoco = false;
						break;
					}
				}
				if(codiceUnivoco) {
					Libro l = new Libro(codice, titolo, casaEditrice);
					libri.add(l);
					pw.println("<h1>Libro inserito correttamente</h1>");
				} else { pw.println("<h1>Codice libro non univoco</h1>"); }
			}
		}
		case CANCELLA -> {
			String codice = req.getParameter("codice-2");
			boolean trovato = false;
			for (Libro libro : libri) {
				if(libro.getCodice().equals(codice)) {
					if(libri.remove(libro)) {
						pw.println("<h1>Libro cancellato correttamente</h1>");
					} else {
						pw.println("<h1>Errore durante cancellazione</h1>");
					}
					trovato = true;
					break;
				}
			}
			if(!trovato) {
				pw.println("<h1>Libro non trovato</h1>");
			}
		}
		case RICERCA -> {
			String codice = req.getParameter("codice-2");
			boolean trovato = false;
			for (Libro libro : libri) {
				if(libro.getCodice().equals(codice)) {
					pw.println("<h1>"+libro.toString()+"</h1>");
					trovato = true;
					break;
				}
			}
			if(!trovato) {
				pw.println("<h1>Libro non trovato</h1>");
			}
			
		}
		
		case VISUALIZZA -> { //per controllare
			for(Libro libro : libri) {
				pw.println(libro+"<br>");
			}
		}
		}
		
		
		pw.println("<br><a href='index.html'>Torna alla pagina principale</a></body></html>");
	}

}
