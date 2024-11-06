/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogo;

/**
 *
 * @author bigma
 */
public class Jogo {
    private Jogador jg1, jg2;
    private int status_partida = 0;
    public final int POSICIONANDO = 0, JOGANDO =1,FIM_RODADA=2, FINALIZADO = 3;   
    public Jogo(Jogador jg1, Jogador jg2){ 
        this.jg1 = jg1;
        this.jg2 = jg2;
    }
    
    public boolean posicao_valida(Barco barco, int indice_casa, String direcao){
        boolean js_valido = false;
        boolean pa_valido = false;
        boolean sb_valido = false;
        boolean nt_valido = false;
        boolean casa_vazia = true;
        
        int linha = (int)Math.floor(indice_casa/10);
        int casa_fim = linha * 10 + 9;
        
            
            if(direcao.equals("Horizontal")){
                if(indice_casa + barco.getTamanho() - 1 > casa_fim){
                    casa_vazia = false;
                }else{
                    for(int posicao_testada = indice_casa; posicao_testada < indice_casa + barco.getTamanho() && casa_vazia; posicao_testada++){
                        if(jg1.isTurno()){
                            js_valido = this.jg1.getJs().posicao_vazia(posicao_testada);
                            pa_valido = this.jg1.getPa().posicao_vazia(posicao_testada);
                            sb_valido = this.jg1.getSb().posicao_vazia(posicao_testada);
                            nt_valido = this.jg1.getNt().posicao_vazia(posicao_testada);
                        }else{
                            js_valido = this.jg2.getJs().posicao_vazia(posicao_testada);
                            pa_valido = this.jg2.getPa().posicao_vazia(posicao_testada);
                            sb_valido = this.jg2.getSb().posicao_vazia(posicao_testada);
                            nt_valido = this.jg2.getNt().posicao_vazia(posicao_testada);  
                        }
                        casa_vazia=js_valido && pa_valido && sb_valido && nt_valido;
                    }      
                }
            }else{
                if(indice_casa + (barco.getTamanho()* 10) - 10 > 99){
                    casa_vazia = false;
                }else{
                    for(int posicao_testada = indice_casa; posicao_testada < indice_casa + (barco.getTamanho() * 10) && casa_vazia; posicao_testada+=10){
                      if(jg1.isTurno()){  
                        js_valido = this.jg1.getJs().posicao_vazia(posicao_testada);
                        pa_valido = this.jg1.getPa().posicao_vazia(posicao_testada);
                        sb_valido = this.jg1.getSb().posicao_vazia(posicao_testada);
                        nt_valido = this.jg1.getNt().posicao_vazia(posicao_testada);
                      }else{
                        js_valido = this.jg2.getJs().posicao_vazia(posicao_testada);
                        pa_valido = this.jg2.getPa().posicao_vazia(posicao_testada);
                        sb_valido = this.jg2.getSb().posicao_vazia(posicao_testada);
                        nt_valido = this.jg2.getNt().posicao_vazia(posicao_testada);  
                      } 
                       casa_vazia=js_valido && pa_valido && sb_valido && nt_valido;
                    }
                }    
          
            }
           
        
        return casa_vazia;
    }
    
    public int status(){
        
        return this.status_partida;
    }
    
    public void verifica_tabuleiros(){
        if(jg1.tabuleiro_pronto() && jg2.tabuleiro_pronto()){
            this.status_partida = this.JOGANDO;
        }
    }
    

            
     
}
