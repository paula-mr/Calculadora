/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cefetmg.inf.calculadora;

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
    
}
