/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cefetmg.inf.util;

/**
 *
 * @author Paula Ribeiro
 */
public class ExcecaoConnection extends Exception {
    public ExcecaoConnection() {
        super("Houve um erro na conexão!");
    }

    public ExcecaoConnection(String message) {
        super(message);
    }
}
