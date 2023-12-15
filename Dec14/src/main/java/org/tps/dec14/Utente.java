package org.tps.dec14;

public class Utente {
    private String username;
    private String password;
    private Role ruolo;

    public Utente(String username, String password, Role ruolo) {
        this.username = username;
        this.password = password;
        this.ruolo = ruolo;
    }

    public boolean isValid(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public Role getRuolo() {
        return ruolo;
    }
}
