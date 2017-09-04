/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cefetmg.inf.client;

import cefetmg.inf.calculadora.InterfaceCalculadora;
import cefetmg.inf.util.ExcecaoConnection;

/**
 *
 * @author Paula Ribeiro
 */
public class ProxyCalculadora implements InterfaceCalculadora {

    Connection con;
    
    public ProxyCalculadora() throws ExcecaoConnection {
        con = new Connection();
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
        
    @Override
    public double adicao(double num1, double num2) {  
        double result = 0;
        try {
            con.sendData('+', num1, num2);
            result = (Double)con.receiveData();
        } catch (ExcecaoConnection ex) {
            System.out.println("Ocorreu um erro! \n");
            ex.printStackTrace();
        }
        finally {
            return result;
        }
    }

    @Override
    public double subtracao(double num1, double num2) {
        double result = 0;
        try {
            con.sendData('-', num1, num2);
            result = (Double)con.receiveData();
        } catch (ExcecaoConnection ex) {
            System.out.println("Ocorreu um erro! \n");
            ex.printStackTrace();
        }
        finally {
            return result;
        }
    }

    @Override
    public double multiplicacao(double num1, double num2) {
        double result = 0;
        try {
            con.sendData('x', num1, num2);
            result = (Double)con.receiveData();
        } catch (ExcecaoConnection ex) {
            System.out.println("Ocorreu um erro! \n");
            ex.printStackTrace();
        }
        finally {
            return result;
        }
    }

    @Override
    public double divisao(double num1, double num2) {
        double result = 0;
        try {
            con.sendData('/', num1, num2);
            result = (Double)con.receiveData();
        } catch (ExcecaoConnection ex) {
            System.out.println("Ocorreu um erro! \n");
            ex.printStackTrace();
        }
        finally {
            return result;
        }
    }
    
}