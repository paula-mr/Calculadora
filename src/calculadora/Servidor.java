/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

                ObjectInputStream entrada = new ObjectInputStream(p.getInputStream());
                int num1 = entrada.readInt();
                char op = entrada.readChar();
                int num2 = entrada.readInt();

                int resultado = realizaOperacao(num1, num2, op);

                ObjectOutputStream saida = new ObjectOutputStream(p.getOutputStream());
                saida.writeObject("Resultado: " + resultado);
                saida.flush(); 

                s.close();
                p.close();
            } catch (Exception e) {
                System.out.println("Ocorreu um erro! \n" + e.getMessage());
            }
        }
    }
    
    static int realizaOperacao(int num1, int num2, char op) {
        int resultado = 0;
        switch (op) {
            case '+':
                resultado = num1 + num2;
                break;
            
            case '-':
                resultado = num1 - num2;
                break;
                
            case 'x':
                resultado = num1 * num2;
                break;
                
            case '/':
                resultado = num1 / num2;
                break;
        }
        return resultado;
    }
}
