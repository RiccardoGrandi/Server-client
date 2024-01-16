package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.Socket;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class App 
{
    public static void main( String[] args )
    {
        try {
            Socket s = new Socket("localhost", 3000);

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            XmlMapper xmlMapper = new XmlMapper();

            String mess = ""; 
            while((mess = in.readLine()) != null ){
                Classe b = xmlMapper.readValue(mess, Classe.class);
                System.out.println(b.toString());
            }
            
            s.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
