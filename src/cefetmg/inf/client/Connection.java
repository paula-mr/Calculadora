/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cefetmg.inf.client;

import cefetmg.inf.util.ConvertByte;
import cefetmg.inf.util.ExcecaoConnection;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Paula Ribeiro
 */
public class Connection {
    private String ip;
    private int port;
    private InetAddress address;
    private DatagramSocket d;

    public Connection(String ip, int port) throws ExcecaoConnection {
        this.ip = ip;
        this.port = port;
        try {
            d = new DatagramSocket();
            address = InetAddress.getByName(ip);
        }
        catch (IOException ex) {
            throw new ExcecaoConnection();
        }
    }
    
    public Connection() throws ExcecaoConnection {
        this ("localhost", 2223);
    }
    
    public void sendData(char op, double x, double y) throws ExcecaoConnection {
        byte[] array = new byte[24];
        byte[] a;
        try {
            a = ConvertByte.toByte(op);
            System.arraycopy(a, 0, array, 0, 8);
            a = ConvertByte.toByte(x);
            System.arraycopy(a, 0, array, 8, 8);
            a = ConvertByte.toByte(y);
            System.arraycopy(a, 0, array, 16, 8);
            DatagramPacket pack = new DatagramPacket(array, 24, address, port);
            d.send(pack);
        }
        catch (IOException ex) {
            throw new ExcecaoConnection();
        }
    }
    
    public double receiveData() throws ExcecaoConnection {
        byte[] b = new byte[8];
        try {
            DatagramPacket packet = new DatagramPacket(b, 8);
            d.receive(packet);
            return ConvertByte.toDouble(b);
        } catch (IOException ex) {
            throw new ExcecaoConnection();
        }
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public InetAddress getAddress() {
        return address;
    }

    public void setAddress(InetAddress address) {
        this.address = address;
    }

    public DatagramSocket getD() {
        return d;
    }

    public void setD(DatagramSocket d) {
        this.d = d;
    }
    
}