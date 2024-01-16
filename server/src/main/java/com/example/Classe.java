package com.example;

import java.util.ArrayList;

public class Classe {
    private String sezione;
    private String coordinatore;
    private ArrayList<Studente> studenti;

    public Classe(String sezione, String coordinaore) {
        this.sezione = sezione;
        this.coordinatore = coordinaore;
        studenti = new ArrayList();
    }

    public void addStudente(Studente s) {
        studenti.add(s);
    }

    /*public ArrayList<Studente> getStudenti() {
        return this.studenti;
    }*/

    public String inviaClasse() {
        String c = "";

        c += "classe: " + sezione + " - Coordinatore: " + coordinatore + " --- ";
        
        for (Studente studente : studenti) {
            c += "Studente: " + studente.toString() + " ---- ";
        }
        
        return c;
    }
}
