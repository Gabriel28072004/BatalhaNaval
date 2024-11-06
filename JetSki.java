/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogo;

import ig.TelaJogo;
import java.awt.Color;

public class JetSki extends Barco {
    
    public JetSki(String nome, int tamanho) {
        super(nome, tamanho);
        setCor_barco(Color.GREEN);
    }
    
    public String afundado(){
        String mensagem = "O JetSki do seu oponente foi afundado";
        
        return mensagem;
    }
    
    
}    
