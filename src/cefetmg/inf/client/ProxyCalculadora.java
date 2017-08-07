/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cefetmg.inf.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Paula Ribeiro
 */
public class ProxyCalculadora {

    Socket socket;
    
    public ProxyCalculadora(String IPServidor, int PortaServidor) throws IOException {
        this.socket = new Socket (IPServidor, PortaServidor);
    }
    
    public void selecionaOperacao(char op) throws IOException {
        
        Scanner scan = new Scanner(System.in);
        
        ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
        saida.writeChar(op);
        
        switch (op) {
            case '+':               
            case '-':
            case '/':
            case 'x':
                double num1;
                double num2;
        
                System.out.println("Digite o primeiro número: ");
                num1 = scan.nextDouble();
            
                System.out.println("Digite o primeiro número: ");
                num2 = scan.nextDouble();   
                
                saida.writeDouble(num1);
                saida.writeDouble(num2);
                
                break;
            
            case 'b':
                double a;
                double b;
                double c;        
        
                System.out.println("Digite A: ");
                a = scan.nextDouble();
            
                System.out.println("Digite B: ");
                b = scan.nextDouble(); 
                
                System.out.println("Digite C: ");
                c = scan.nextDouble(); 
                
                saida.writeDouble(a);
                saida.writeDouble(b);
                saida.writeDouble(c);
                
                break;
                
            case 'm':
                int i1 = 0, i2 =0 , j1 = 0, j2 = 0;
                
                System.out.println("Digite a quantidade de linhas da primeira matriz: ");
                i1 = scan.nextInt();
            
                System.out.println("Digite a quantidade de colunas da primeira matriz: ");
                j1 = scan.nextInt(); 
                
                System.out.println("Digite a quantidade de linhas da segunda matriz: ");
                i2 = scan.nextInt();
            
                System.out.println("Digite a quantidade de colunas da segunda matriz: ");
                j2 = scan.nextInt(); 
                
                double[][] matriz1 = new double[i1][j1];
                double[][] matriz2 = new double[i2][j2];
                
                System.out.println("Digite os números que compõem a primeira matriz: ");
                for (int i = 0; i < i1; i++) {
                    for (int j = 0; j < j1; j++) {
                        matriz1[i][j] = scan.nextDouble(); 
                    }
                }
                saida.writeObject(matriz1);
                
                System.out.println("Digite os números que compõem a segunda matriz: ");
                for (int i = 0; i < i2; i++) {
                    for (int j = 0; j < j2; j++) {
                        matriz2[i][j] = scan.nextDouble(); 
                   }
                }
                saida.writeObject(matriz2);
                
                break; 
        }
        
        saida.flush();
                
    }
    
    public Object recebeResultado() throws IOException, ClassNotFoundException {
        ObjectInputStream entrada = new ObjectInputStream (socket.getInputStream());
        Object resultado = entrada.readObject();
        return resultado;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }   
    
}