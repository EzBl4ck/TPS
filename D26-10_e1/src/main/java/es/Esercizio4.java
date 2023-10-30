package es;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = { "/Esercizio4" },
		initParams = { 
				@WebInitParam(name = "filename", value = "filetesto.txt")
		})
public class Esercizio4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String filename;
    
    @Override
	public void init() throws ServletException {
		filename = getInitParameter("filename");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletContext().getRealPath("/");
		response.getWriter().println(path);
		//FileOutputStream fout = new  FileOutputStream("pippo.txt");
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
