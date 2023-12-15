package org.tps.dec14;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Vector;

@WebServlet("/Login")
public class Login extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Vector<Utente> utenti = (Vector<Utente>) getServletContext().getAttribute("utenti");
    String op = req.getParameter("op");
    String username = req.getParameter("username");
    String password = req.getParameter("password");

    switch (op) {
      case "accedi" -> {
        if (accedi(req, utenti, username, password)) {
          resp.sendRedirect("main.html");
        }
        resp.sendRedirect("index.html");
      }
      case "registrati" -> {
      }
    }
  }

  private boolean accedi(
      HttpServletRequest req,
      Vector<Utente> utenti,
      String username,
      String password
  ) {
    for (Utente utente : utenti) {
      if (utente.isValid(username, password)) {
        HttpSession session = req.getSession();
        if (session.isNew()) {
          session.invalidate();
          session = req.getSession();
        }
        session.setAttribute("utente", utente);
        return true;
      }
    }
    return false;
  }
}
