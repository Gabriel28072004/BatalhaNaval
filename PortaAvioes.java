/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogo;

import ig.TelaJogo;
import java.awt.Color;

/**
 *
 * @author bigma
 */
public class PortaAvioes extends Barco {
    
    private int avioes = 30;
    
    public PortaAvioes(String nome, int tamanho) {
        super(nome, tamanho);
        setCor_barco(Color.YELLOW);
    }
    
    public String afundado(){
        String mensagem = "O Porta-Aviões do seu oponente foi destruido com mais de " +avioes+ " aviões";
        
        return mensagem;
    }
    
    
}
