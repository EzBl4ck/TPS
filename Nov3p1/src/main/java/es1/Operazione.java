package es1;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Operazione")
public class Operazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ContoCorrente contoCorrente;
	private DecimalFormat decimalFormat;
	
	@Override
	public void init() throws ServletException {
		super.init();
		contoCorrente = new ContoCorrente();
		decimalFormat = new DecimalFormat("#0.00");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body><h1>Saldo corrente: "+decimalFormat.format(contoCorrente.getSaldo())+"</h1><form method='post' action='Operazione'>");
		out.println("<label for='preleva'>Preleva</label><input type='radio' name='type' value='preleva' id='preleva'><br>");
		out.println("<label for='deposita'>Deposita</label><input type='radio' name='type' value='deposita' id='deposita' checked='true'><br>");
		out.println("<label for='importo'>Importo: </label><input type='number' name='importo' min='0' step='0.01'><br>");
		out.println("<input type='submit'>");
		out.println("</form></body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		float value = Float.parseFloat(request.getParameter("importo"));
		String type = request.getParameter("type");
		if(type.equals("preleva")) {
			contoCorrente.preleva(value);
		} else {
			contoCorrente.deposita(value);
		}
		doGet(request, response);
	}

}
