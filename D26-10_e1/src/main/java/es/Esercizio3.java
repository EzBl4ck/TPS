package es;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
		urlPatterns = { "/Esercizio3" }, 
		initParams = { 
				@WebInitParam(name = "numero", value = "13")
		})
public class Esercizio3 extends HttpServlet {
	
	private int number;
	
	@Override
	public void init() throws ServletException {
		number = Integer.parseInt(getInitParameter("numero"));
	}
	
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		for(int i = 1; i <= 10; i++) {
			out.println(i*number);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
