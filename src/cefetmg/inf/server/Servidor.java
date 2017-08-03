/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cefetmg.inf.server;

import cefetmg.inf.calculadora.AdaptadorCalculadora;
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
        while (true) {
            try {
                ServerSocket s = new ServerSocket(2223);

                Socket p = s.accept();
                
                AdaptadorCalculadora adapter = new AdaptadorCalculadora(p);
                adapter.realizaOperacao();
                
                s.close();
                p.close();
            } catch (Exception e) {
                System.out.println("Ocorreu um erro! \n" + e.getMessage());
            }
        }
    }
    
}
