package esercizi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Esercizio6")
public class Esercizio6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		float n1 = Float.parseFloat(request.getParameter("num1"));
		float n2 = Float.parseFloat(request.getParameter("num2"));
		char op = request.getParameter("op").charAt(0);
		
		switch(op) {
			case '+' -> out.println(n1 + n2);
			case '-' -> out.println(n1 - n2);
			case '/' -> {
				if(n2 != 0)
					out.println(n1 / n2);
				else 
					out.println("Divisione per 0");
			}
			case '*' -> out.println(n1 * n2);
			default -> out.println("Operazione invalida");
		}
	}

}
