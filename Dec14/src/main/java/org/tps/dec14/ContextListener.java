package org.tps.dec14;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

import java.util.Vector;

public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();

        Vector<Utente> utenti = new Vector<>();
        Vector<Libro> libri = new Vector<>();

        utenti.add(new Utente("admin", "adminpwd", Role.Admin));
        utenti.add(new Utente("user", "userpwd", Role.Guest));

        context.setAttribute("utenti", utenti);
        context.setAttribute("libri", libri);
    }
}
