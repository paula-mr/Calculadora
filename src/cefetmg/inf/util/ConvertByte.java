/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cefetmg.inf.util;

import java.nio.ByteBuffer;

/**
 *
 * @author Paula Ribeiro
 */
public class ConvertByte {
    public static byte[] toByte(double valor) {
        byte[] bytes = new byte[8];
        ByteBuffer.wrap(bytes).putDouble(valor);
        return bytes;
    }

    public static double toDouble(byte[] bytes) {
        return ByteBuffer.wrap(bytes).getDouble();
    }
    
    public static byte[] toByte(int valor) {
        byte[] bytes = new byte[8];
        ByteBuffer.wrap(bytes).putInt(valor);
        return bytes;
    }
    
    public static byte[] toByte(char valor) {
        byte[] bytes = new byte[8];
        ByteBuffer.wrap(bytes).putChar(valor);
        return bytes;
    }

    public static char toChar(byte[] bytes) {
        return ByteBuffer.wrap(bytes).getChar();
    }
}
