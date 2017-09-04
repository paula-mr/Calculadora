/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cefetmg.inf.client;

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

            ProxyCalculadora proxy = new ProxyCalculadora();
            
            Scanner scan = new Scanner(System.in);
            System.out.println("Selecione dentre as operações: " +
                                "\n + para adição" +
                                "\n - para subtração" +
                                "\n x para multiplicação" +
                                "\n / para divisão" +
                                "\n Operação selecionada: ");
            
            char op = scan.next().charAt(0);
            double num1;
            double num2;
            double result;
            
            System.out.println("Digite o primeiro número: ");
            num1 = scan.nextDouble();

            System.out.println("Digite o segundo número: ");
            num2 = scan.nextDouble();
            
            switch (op) {
                case '+':
                    result = proxy.adicao(num1, num2);
                    
                    System.out.println("Resultado: ");
                    System.out.print(result);
                    
                    break;

                case '-':
                    result = proxy.subtracao(num1, num2);
                    
                    System.out.println("Resultado: ");
                    System.out.print(result);

                    break;

                case '/':
                    result = proxy.divisao(num1, num2);
                    
                    System.out.println("Resultado: ");
                    System.out.print(result);

                    break;

                case 'x':
                    result = proxy.multiplicacao(num1, num2);
                    
                    System.out.println("Resultado: ");
                    System.out.print(result);

                    break;
            }
            System.out.println();
        }
        catch (Exception e) {
            System.out.println("Ocorreu um erro! \n");
            e.printStackTrace();
        }
    }
        
}
