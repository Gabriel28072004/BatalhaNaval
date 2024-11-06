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
public class Submarino extends Barco {
    
    private int profundidade = 8100;
    
    public Submarino(String nome, int tamanho) {
        super(nome, tamanho);
        setCor_barco(Color.BLACK);
    }
    
    
    public String afundado(){
        String mensagem = "O submarino do seu oponente foi destruido a "+profundidade+ " metros de profundidade";
        
        return mensagem;
    }
    
    
    
}
