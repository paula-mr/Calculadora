/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cefetmg.inf.excecao;

/**
 *
 * @author Paula Ribeiro
 */
public class ExcecaoMath extends Exception {

    public ExcecaoMath() {
        super("Exceção de matemática lançada!");
    }

    public ExcecaoMath(String message) {
        super(message);
    }
    
}
