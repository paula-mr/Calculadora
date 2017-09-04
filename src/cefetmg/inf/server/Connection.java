/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cefetmg.inf.server;

import cefetmg.inf.util.ConvertByte;
import cefetmg.inf.util.ExcecaoConnection;
import cefetmg.inf.util.Operation;
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
        try {
            d = new DatagramSocket(port);
            address = InetAddress.getByName(ip);
        }
        catch (IOException ex) {
            throw new ExcecaoConnection();
        }
    }
    
    public Connection() throws ExcecaoConnection {
        this ("localhost", 2223);
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
        
    public void sendData(double result, String ip, int port) throws ExcecaoConnection {
        try {
            DatagramPacket pack = new DatagramPacket(ConvertByte.toByte(result), 8, InetAddress.getByName(ip), port);
            d.send(pack);
        } catch (IOException ex) {
            throw new ExcecaoConnection();
        }
    }
    
    public Operation receiveData() throws ExcecaoConnection {
        byte[] array = new byte[24];
        try {
            DatagramPacket pack = new DatagramPacket(array, 24, address, port);
            d.receive(pack);
            byte[] op = new byte[8];
            System.arraycopy(array, 0, op, 0, 8);
            byte[] x = new byte[8];
            System.arraycopy(array, 8, x, 0, 8);
            byte[] y = new byte[8];
            System.arraycopy(array, 16, y, 0, 8);
            return new Operation(ConvertByte.toDouble(x), ConvertByte.toDouble(y), 
                    ConvertByte.toChar(op), pack.getPort(), pack.getAddress().getHostAddress());
        }
        catch (IOException ex) {
            throw new ExcecaoConnection();
        }
    }
}
