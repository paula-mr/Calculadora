/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cefetmg.inf.client;

import cefetmg.inf.calculadora.InterfaceCalculadora;
import cefetmg.inf.excecao.ExcecaoMath;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Paula Ribeiro
 */
public class ProxyCalculadora implements InterfaceCalculadora {

    Socket socket;
    ObjectOutputStream saida;
    
    
    public ProxyCalculadora(String IPServidor, int PortaServidor) throws IOException {
        this.socket = new Socket (IPServidor, PortaServidor);
        this.saida = new ObjectOutputStream(socket.getOutputStream());
    }
        
    private Object recebeResultado() throws IOException, ClassNotFoundException {
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

    @Override
    public double adicao(double num1, double num2) {
        
        double result = 0;
        try {
            saida.writeChar('+');
            saida.writeDouble(num1);
            saida.writeDouble(num2);
            saida.flush();
            result = (double) this.recebeResultado();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Ocorreu um erro! \n" + ex.getMessage());
        }
        finally {
            return result;
        }
    }

    @Override
    public double subtracao(double num1, double num2) {
        double result = 0;
        try {
            saida.writeChar('-');
            saida.writeDouble(num1);
            saida.writeDouble(num2);
            saida.flush();
            result = (double) this.recebeResultado();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Ocorreu um erro! \n" + ex.getMessage());
        }
        finally {
            return result;
        }
    }

    @Override
    public double multiplicacao(double num1, double num2) {
        double result = 0;
        try {
            saida.writeChar('x');
            saida.writeDouble(num1);
            saida.writeDouble(num2);
            saida.flush();
            result = (double) this.recebeResultado();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Ocorreu um erro! \n" + ex.getMessage());
        }
        finally {
            return result;
        }
    }

    @Override
    public double divisao(double num1, double num2) {
        double result = 0;
        try {
            saida.writeChar('/');
            saida.writeDouble(num1);
            saida.writeDouble(num2);
            saida.flush();
            result = (double) this.recebeResultado();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Ocorreu um erro! \n" + ex.getMessage());
        }
        finally {
            return result;
        }
    }

    @Override
    public double[][] multMatriz(double[][] matriz1, double[][] matriz2) throws ExcecaoMath {
        double[][] result = new double[matriz1.length][matriz2[0].length];
        try {
            saida.writeChar('m');
            saida.writeObject(matriz1);
            saida.writeObject(matriz2);
            saida.flush();
            result = (double[][]) this.recebeResultado();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Ocorreu um erro! \n" + ex.getMessage());
        }
        finally {
            return result;
        }
    }

    @Override
    public double[] calcBhaskara(double a, double b, double c) throws ExcecaoMath {
        double[] result = new double[2];
        try {
            saida.writeChar('b');
            saida.writeDouble(a);
            saida.writeDouble(b);
            saida.writeDouble(c);
            saida.flush();
            result = (double[]) this.recebeResultado();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Ocorreu um erro! \n" + ex.getMessage());
        }
        finally {
            return result;
        }
    }
    
}