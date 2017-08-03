/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

            Socket c = new Socket (IPServidor, PortaServidor);

            Scanner scan = new Scanner(System.in);
            System.out.println("Digite o primeiro número: ");
            int num1 = scan.nextInt();
            System.out.println("Digite a operação: ");
            char op = scan.next().charAt(0);
            System.out.println("Digite o primeiro número: ");
            int num2 = scan.nextInt();
            
            ObjectOutputStream saida = new ObjectOutputStream(c.getOutputStream());
            saida.writeInt(num1);
            saida.writeChar(op);
            saida.writeInt(num2);
            saida.flush();

            ObjectInputStream entrada = new ObjectInputStream (c.getInputStream());
            String t = entrada.readObject().toString(); 

            System.out.println(t);

            c.close();
        }
        catch (Exception e) {
                System.out.println("Ocorreu um erro! \n" + e.getMessage());
        }
    }
    
}
