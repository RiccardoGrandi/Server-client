package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class App 
{
    public static void main( String[] args )
    {
        try{
            ServerSocket server = new ServerSocket(3000);

            Studente s1 = new Studente("Mattia", "Pascal", 15);
            Studente s2 = new Studente("Riccardo","Grandi", 19);
            Studente s3 = new Studente("Anatolie", "Pavlov", 20);
            Studente s4 = new Studente("Alessio", "Didilescu", 18);
            Studente s5 = new Studente("Gigi", "Topo", 6);

            Classe c = new Classe("5^DIA", "Francesco Capezio");
            c.addStudente(s1);
            c.addStudente(s2);
            c.addStudente(s3);
            c.addStudente(s4);
            c.addStudente(s5);

            System.out.println("il server è in ascolto");
            Socket s = server.accept();

            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            out.writeBytes(c.toString() + "\n");

            s.close();
            server.close();

        server.accept();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
