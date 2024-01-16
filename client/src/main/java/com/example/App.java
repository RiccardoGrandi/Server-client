package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class App 
{
    public static void main( String[] args )
    {
        try {
            Socket s = new Socket("localhost", 3000);

            // DataOutputStream out = new DataOutputStream(s.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

            String mess = ""; 
            while((mess = in.readLine()) != null ){
                System.out.println(mess);
            }
            
            s.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
