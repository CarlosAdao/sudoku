/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.ArrayList;

/**
 *
 * @author estagio-nit
 */
public class Tabuleiro {
    int id;
    int matriz[][];
    Tabuleiro pai;
    ArrayList<Tabuleiro>lista_filhos;
    boolean jaTeveFilhos;

    public boolean isJaTeveFilhos() {
        return jaTeveFilhos;
    }

    public void setJaTeveFilhos(boolean jaTeveFilhos) {
        this.jaTeveFilhos = jaTeveFilhos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Tabuleiro(int[][] matriz, Tabuleiro pai, ArrayList<Tabuleiro> lista_filhos) {
        this.matriz = matriz;
        this.pai = pai;
        this.lista_filhos = lista_filhos;
    }

    Tabuleiro() {
        lista_filhos =  new ArrayList<>();
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    public Tabuleiro getPai() {
        return pai;
    }

    public void setPai(Tabuleiro pai) {
        this.pai = pai;
    }

    public ArrayList<Tabuleiro> getLista_filhos() {
        return lista_filhos;
    }

    public void setLista_filhos(ArrayList<Tabuleiro> lista_filhos) {
        this.lista_filhos = lista_filhos;
    }

    @Override
    public String toString() {
        return "Tabuleiro{" + "matriz=" + matriz + ", pai=" + pai + ", lista_filhos=" + lista_filhos + '}';
    }
    
    
    
    
    
    
}


