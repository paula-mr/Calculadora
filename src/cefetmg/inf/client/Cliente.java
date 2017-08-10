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
            String IPServidor = "localhost";
            int PortaServidor = 2223;

            ProxyCalculadora proxy = new ProxyCalculadora(IPServidor, PortaServidor);
            
            Scanner scan = new Scanner(System.in);
            System.out.println("Selecione dentre as operações: " +
                                "\n + para adição" +
                                "\n - para subtração" +
                                "\n x para multiplicação" +
                                "\n / para divisão" +
                                "\n b para resolução de uma equação de segundo grau (bhaskara)" +
                                "\n m para multiplicação de matriz" +
                                "\n Operação selecionada: ");
            
            char op = scan.next().charAt(0);
            double num1;
            double num2;
            double result;
            
            
            switch (op) {
                case '+':
                    System.out.println("Digite o primeiro número: ");
                    num1 = scan.nextDouble();

                    System.out.println("Digite o segundo número: ");
                    num2 = scan.nextDouble();   
                    
                    result = proxy.adicao(num1, num2);
                    
                    System.out.println("Resultado: ");
                    System.out.print(result);
                    
                    break;

                case '-':
                    System.out.println("Digite o primeiro número: ");
                    num1 = scan.nextDouble();

                    System.out.println("Digite o segundo número: ");
                    num2 = scan.nextDouble();   
                    
                    result = proxy.subtracao(num1, num2);
                    
                    System.out.println("Resultado: ");
                    System.out.print(result);

                    break;

                case '/':
                    System.out.println("Digite o primeiro número: ");
                    num1 = scan.nextDouble();

                    System.out.println("Digite o segundo número: ");
                    num2 = scan.nextDouble(); 
                    
                    result = proxy.divisao(num1, num2);
                    
                    System.out.println("Resultado: ");
                    System.out.print(result);

                    break;

                case 'x':
                    System.out.println("Digite o primeiro número: ");
                    num1 = scan.nextDouble();

                    System.out.println("Digite o segundo número: ");
                    num2 = scan.nextDouble();   
                    
                    result = proxy.multiplicacao(num1, num2);
                    
                    System.out.println("Resultado: ");
                    System.out.print(result);

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
                    
                    double[] result2 = proxy.calcBhaskara(a, b, c);
                    
                    System.out.println("Resultado: ");
                    
                    System.out.println("X1: " + result2[0]);
                    if (result2.length > 1) {
                        System.out.print(" X2: " + result2[1]);
                    }
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

                    System.out.println("Digite os números que compõem a segunda matriz: ");
                    for (int i = 0; i < i2; i++) {
                        for (int j = 0; j < j2; j++) {
                            matriz2[i][j] = scan.nextDouble(); 
                       }
                    }
                    
                    double[][] matriz = proxy.multMatriz(matriz1, matriz2);
                    
                    System.out.println("Resultado: \n");
                    
                    for (int i = 0; i < matriz.length; i++) {
                        for (int j = 0; j < matriz[0].length; j++) {
                            System.out.print(matriz[i][j] + " ");
                        }
                        System.out.println();
                    }

                    break; 
            }
            System.out.println();
        }
        catch (Exception e) {
            System.out.println("Ocorreu um erro! \n" + e.getMessage());
        }
    }
        
}
