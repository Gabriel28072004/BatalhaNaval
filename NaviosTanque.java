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
public class NaviosTanque extends Barco {
    
    private int combustivel = 5500;
    
    public NaviosTanque(String nome, int tamanho) {
        super(nome, tamanho);
        setCor_barco(Color.orange);
    }
    
     public String afundado(){
        String mensagem = "O Navio-Tanque do seu oponente foi afundado com mais de " +combustivel+ " litros de combustível.";
        
        return mensagem;
    }
    
    
}
