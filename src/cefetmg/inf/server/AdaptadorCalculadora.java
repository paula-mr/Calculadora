/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cefetmg.inf.server;

import cefetmg.inf.calculadora.Calculadora;
import cefetmg.inf.calculadora.InterfaceCalculadora;
import cefetmg.inf.excecao.ExcecaoMath;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Paula Ribeiro
 */
public class AdaptadorCalculadora implements Runnable {
    
    private Socket socket;
    private InterfaceCalculadora calculadora;
    
    public AdaptadorCalculadora(Socket socket) {
        this.socket = socket;
        this.calculadora = new Calculadora();
    }
    
    @Override
    public void run() {
        
        ObjectInputStream entrada = null;
        try {
            entrada = new ObjectInputStream (socket.getInputStream());
            char op = entrada.readChar();
            double num1, num2, a, b, c;
            Object resultado = null;
            double[][] matriz1, matriz2;
            switch (op) {
                case '+':
                    num1 = entrada.readDouble();
                    num2 = entrada.readDouble();
                    resultado = calculadora.adicao(num1, num2);
                    break;
                    
                case '-':
                    num1 = entrada.readDouble();
                    num2 = entrada.readDouble();
                    resultado = calculadora.subtracao(num1, num2);
                    break;
                    
                case '/':
                    num1 = entrada.readDouble();
                    num2 = entrada.readDouble();
                    resultado = calculadora.divisao(num1, num2);
                    break;
                    
                case 'x':
                    num1 = entrada.readDouble();
                    num2 = entrada.readDouble();
                    resultado = calculadora.multiplicacao(num1, num2);
                    break;
                    
                case 'b':
                    a = entrada.readDouble();
                    b = entrada.readDouble();
                    c = entrada.readDouble();
                    resultado = calculadora.calcBhaskara(a, b, c);
                    break;
                    
                case 'm':
                    matriz1 = (double[][]) entrada.readObject();
                    matriz2 = (double[][]) entrada.readObject();
                    resultado = calculadora.multMatriz(matriz1, matriz2);
                    break; 
            }   
            
            ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
            saida.writeObject(resultado);
            saida.flush();
            
            socket.close();
            System.out.println("Conexão fechada");
            
        } catch (IOException | ExcecaoMath | ClassNotFoundException ex) {
            System.out.println("Ocorreu um erro!\n" + ex.getMessage());
        } finally {
            try {
                entrada.close();
            } catch (IOException ex) {
                System.out.println("Ocorreu um erro!\n" + ex.getMessage());
            }
        }
        
    }
    
}
