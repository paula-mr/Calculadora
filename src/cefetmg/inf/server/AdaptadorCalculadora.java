/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cefetmg.inf.server;

import cefetmg.inf.calculadora.Calculadora;
import cefetmg.inf.util.ExcecaoConnection;

/**
 *
 * @author Paula Ribeiro
 */
public class AdaptadorCalculadora implements Runnable {
    
    private Connection con;
    private Calculadora calculadora;
    private char op;
    private int port;
    private String ip;
    private double x;
    private double y;
    
    public AdaptadorCalculadora(int port, String ip, double x, double y, char op) {
        calculadora = new Calculadora();
        this.x=x;
        this.y=y;
        this.op=op;
        this.ip=ip;
        this.port=port;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public Calculadora getCalculadora() {
        return calculadora;
    }

    public void setCalculadora(Calculadora calculadora) {
        this.calculadora = calculadora;
    }

    public char getOp() {
        return op;
    }

    public void setOp(char op) {
        this.op = op;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
       
    @Override
    public void run() {
        try {
            switch (op) {
                case '+':
                    con.sendData(calculadora.adicao(x, y), ip, port);
                    break;
                    
                case '-':
                    con.sendData(calculadora.subtracao(x, y), ip, port);
                    break;
                    
                case 'x':
                    con.sendData(calculadora.multiplicacao(x, y), ip, port);
                    break;
                    
                case '/':
                    con.sendData(calculadora.divisao(x, y), ip, port);
                    break;
            }
        } 
        catch (ExcecaoConnection ex) {
            System.out.println("Ocorreu um erro! \n");            
            ex.printStackTrace();
        } 
               
    }
    
}
