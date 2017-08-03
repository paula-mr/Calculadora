/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cefetmg.inf.server;

import cefetmg.inf.proxy.ProxyCalculadora;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Paula Ribeiro
 */
public class Cliente {
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String IPServidor = "localhost";
            int PortaServidor = 2223;

            ProxyCalculadora proxy = new ProxyCalculadora(IPServidor, PortaServidor);
            Socket c = proxy.getSocket();
            
            Scanner scan = new Scanner(System.in);
            System.out.println("Digite a operação: ");
            char op = scan.next().charAt(0);
            
            proxy.selecionaOperacao(op);
            Object resultado = proxy.recebeResultado();
            System.out.println("Resultado: ");
            
            switch (op) {
                case '+':
                case '-':
                case '/':
                case 'x':
                    System.out.print(resultado);
                    break;

                case 'b':
                    double[] result = (double[]) resultado;
                    System.out.print("X1: " + result[0]);
                    if (result.length > 1) {
                        System.out.print(" X2: " + result[1]);
                    }
                    break;

                case 'm':
                    System.out.println();
                    double[][] matriz = (double[][]) resultado;
                    for (int i = 0; i < matriz.length; i++) {
                        for (int j = 0; j < matriz[1].length; j++) {
                            System.out.println(matriz[i][j]);
                        }
                        System.out.println();
                    }
                    break;
            }

            c.close();
        }
        catch (Exception e) {
            System.out.println("Ocorreu um erro! \n" + e.getMessage());
        }
    }
        
}
