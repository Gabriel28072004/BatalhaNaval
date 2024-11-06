/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogo;

import java.awt.Color;
import java.util.ArrayList;


public abstract class Barco {
    
    private int tamanho;
    private String nome;
    private int partes_atingidas = 0;
    private ArrayList<Integer> posicoes;
    private Color cor_barco;
    private boolean posicionado = false;
    private boolean alerta = false;

  
    
    public boolean isPosicionado() {
        return posicionado;
    }

    public void setPosicionado(boolean posicionado) {
        this.posicionado = posicionado;
    }

    

    public Color getCor_barco() {
        return cor_barco;
    }

    public void setCor_barco(Color cor_barco) {
        this.cor_barco = cor_barco;
    }
    
    public Barco(String nome, int tamanho){
        this.nome = nome;
        this.tamanho = tamanho;
        this.posicoes = new ArrayList();
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
   

    public boolean posicao_vazia(int indice_casa){
        boolean sem_barco = true;
         
        for(int posicao_atual:this.posicoes){
            if(posicao_atual == indice_casa && sem_barco){
                System.out.println("achou barco");                
                sem_barco = false;
            }
        }
        
        return sem_barco;
    }
    
   
    public void addPosicao(int posicao){
        this.posicoes.add(posicao);
       
    }
    
    public boolean atingido(int indice_casa){
        boolean retorno;
        retorno = false;
        for(int posicao_atual:this.posicoes){
            if(posicao_atual == indice_casa){
                this.partes_atingidas++;
                retorno = true;
                this.alerta = true;
            }
        }
        return retorno;
    }
    
    public boolean destruido(){
        
       boolean retorno = false;
       if(this.tamanho == this.partes_atingidas){
           retorno = true;
       
       }
       
       return retorno;
        
    
    }

    public boolean isAlerta() {
        return alerta;
    }

    public void setAlerta(boolean alerta) {
        this.alerta = alerta;
    }

}
