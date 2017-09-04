/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cefetmg.inf.server;

import cefetmg.inf.util.Operation;

/**
 *
 * @author Paula Ribeiro
 */
public class Servidor {
    public static void main(String[] args) {
        try {
            Connection con = new Connection();
            
            while (true) {
                
                System.out.println("Aguardando conexão");
                
                Operation o = con.receiveData();
                System.out.println("Conexão estabelecida");

                AdaptadorCalculadora adapter = new AdaptadorCalculadora(o.getPort(), 
                        o.getHostAddress(), o.getX(), o.getY(), o.getOp());
                adapter.setCon(con);
                
                Thread request = new Thread(adapter);
                request.start();

            }
            
        } catch (Exception e) {
            System.out.println("Ocorreu um erro! \n");            
            e.printStackTrace();
        }
        
    }
    
}
