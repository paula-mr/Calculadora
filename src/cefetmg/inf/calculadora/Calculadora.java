/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cefetmg.inf.calculadora;

import cefetmg.inf.excecao.ExcecaoMath;

/**
 *
 * @author Paula Ribeiro
 */
public class Calculadora implements InterfaceCalculadora {

    @Override
    public double adicao(double num1, double num2) {
        return num1 + num2;
    }

    @Override
    public double subtracao(double num1, double num2) {
        return num1 - num2;
    }

    @Override
    public double multiplicacao(double num1, double num2) {
        return num1 * num2;
    }

    @Override
    public double divisao(double num1, double num2) {
        return num1 / num2;
    }

    @Override
    public double[][] multMatriz(double[][] matriz1, double[][] matriz2) throws ExcecaoMath {
        double[][] matrizResult = new double[matriz1.length][matriz2[0].length];
        
        if (matriz1[0].length != matriz2.length) {
            throw new ExcecaoMath("Condição de multiplicação de matrizes não respeitada!");
        }
        
        else {
            for (int i = 0; i < matriz1.length; i++) {
                for (int j = 0; j < matriz2[0].length; j++) {
                    for (int k = 0; k < matriz1[0].length; k++) {
                        matrizResult[i][j] += matriz1[i][k] * matriz2[k][j];
                    }
                }
            }
            return matrizResult;
        }
        
    }

    @Override
    public double[] calcBhaskara(double a, double b, double c) throws ExcecaoMath {
        double[] result;
        double delta = (b*b) - (4*a*c);
        if (delta < 0) {
            throw new ExcecaoMath("Raízes não existentes!");
        }
        else if (delta == 0) {
            double x1 = (-b) / (2*a);
            result = new double[1];
            result[0] = x1;
        }
        else {
            double raizDelta = Math.sqrt(delta);
            double x1 = ((-b) + raizDelta) / (2*a);
            double x2 = ((-b) - raizDelta) / (2*a);
            result = new double[2];
            result[0] = x1;
            result[1] = x2;
        }
        return result;
    }
      
    
    
}
