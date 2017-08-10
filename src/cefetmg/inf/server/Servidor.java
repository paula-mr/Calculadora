/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cefetmg.inf.server;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Paula Ribeiro
 */
public class Servidor {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            ServerSocket s;

            while (true) {
                
                s = new ServerSocket(2223);
                
                System.out.println("Aguardando conexão");

                Socket p = s.accept();
                System.out.println("Conexão estabelecida");

                AdaptadorCalculadora adapter = new AdaptadorCalculadora(p);
                new Thread(adapter).start();

                s.close();
            }
            
        } catch (Exception e) {
            System.out.println("Ocorreu um erro! \n" + e.getMessage());
        }
        
    }
    
}
