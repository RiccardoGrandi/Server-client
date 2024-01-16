package com.example;

import java.io.DataOutputStream;
import java.io.File;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class App 
{
    public static void main( String[] args )
    {
        Alunno a1 = new Alunno("Mattia", "Pascal", new Date(1904 - 1900, 0, 1));
        Alunno a2 = new Alunno("Riccardo","Grandi", new Date(2005 - 1900, 0, 20));
        Alunno a3 = new Alunno("Anatolie", "Pavlov", new Date(2003 - 1900, 11, 10));
        Alunno a4 = new Alunno("Alessio", "Didi", new Date(2005 - 1900, 4, 03));
        Alunno a5 = new Alunno("Gigi", "Topo", new Date(2004 - 1900, 1, 28));

        ArrayList<Alunno> alunni = new ArrayList<>();
        alunni.add(a1);
        alunni.add(a2);
        alunni.add(a3);
        alunni.add(a4);
        alunni.add(a5);

        Classe classe = new Classe(5, "^DIA", "08-2W", alunni);
        
        try{
            ServerSocket server = new ServerSocket(3000);

            System.out.println("il server è in ascolto");
            Socket s = server.accept();

            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            XmlMapper xmlMapper = new XmlMapper();
            String cls = xmlMapper.writeValueAsString(classe);
            System.out.println(cls);

            out.writeBytes(cls + "\n");

            s.close();
            server.close();

        server.accept();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
