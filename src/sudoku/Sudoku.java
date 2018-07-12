/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.ArrayList;

/**
 * [PROJETO E ANÁLISE DE ALGOTITIMO T1 - CET084]
 * @author José Carlos Adão - Albert Paixão - Ricardo Neves
 */

public class Sudoku {

    static int id_tabuleiro = 1;
    static Tabuleiro raiz;

    public static void main(String[] args) {
        
        raiz = new Tabuleiro();
        raiz.setId(id_tabuleiro);
        raiz.setMatriz(createTabuleiro());//coloca a matriz inicial no nó Raiz
        sudoku(raiz);
    }
    
    /*Método usado para criar a matriz do tabuleiro*/
    public static int[][] createTabuleiro() {
        int tabuleiro[][] = {{5, 3, 0, 0, 7, 0, 0, 0, 0},
        {6, 0, 0, 1, 9, 5, 0, 0, 0},
        {0, 9, 8, 0, 0, 0, 0, 6, 0},
        {8, 0, 0, 0, 6, 0, 0, 0, 3},
        {4, 0, 0, 8, 0, 3, 0, 0, 1},
        {7, 0, 0, 0, 2, 0, 0, 0, 6},
        {0, 6, 0, 0, 0, 0, 2, 8, 0},
        {0, 0, 0, 4, 1, 9, 0, 0, 5},
        {0, 0, 5, 2, 8, 0, 0, 7, 9}};

        return tabuleiro;
    }

    //Método usado para verificar se uma número está sendo usado na linha ou coluna da matriz
    public static boolean verificaNumeroMatriz(int num, int linha, int coluna, int[][] tabuleiro) {
        boolean aux1 = false;

        for (int i = 0; i < tabuleiro.length; i++) {
            int[] aux = tabuleiro[i];
            for (int j = 0; j < aux.length; j++) {
                if (linha == i) {
                    if (num == tabuleiro[i][j]) {
                        aux1 = true;

                    }
                } else if (coluna == j) {
                    if (num == tabuleiro[i][j]) {
                        aux1 = true;
                    }
                }
            }
        }
        return aux1;
    }

    /*Método usado para imprimir o tabuleiro*/
    public static int printTabuleiro(int[][] tabuleiro, String msg) {
        System.out.println(msg);
        int qtd_vazio = 0;
        for (int[] l : tabuleiro) {
            System.out.println("");
            for (int i = 0; i < l.length; i++) {
                if (l[i] == 0) {
                    qtd_vazio++;
                }
                System.out.print(l[i] + "  ");
            }
        }
        System.out.println("\n\nQuantidade casas Vazia: " + qtd_vazio);
        if (qtd_vazio != 0) {
            System.out.println("Estado: Não Concluido");
        } else {
            System.out.println("Estado: Sudoku Completo!!!");
        }
        System.out.println("\n\n");
        return qtd_vazio;
    }

    /*Método usado para inserir um numero dentro do tabueliro*/
    public static int[][] insetNumInTabuleiro(int num, int linha, int coluna, int[][] tabuleiro) {
        int[][] tabAux = new int[8][8];
        int i = 0;
        for (int[] l : tabuleiro) {
            for (int j = 0; j < l.length; j++) {
                if (i == linha && coluna == j) {
                    tabAux[i][j] = num;
                } else {
                    tabAux[i][j] = tabuleiro[i][j];
                }
            }
            i++;
        }
        return tabAux;
    }

    /*Método usado para verificar se um numero está no quadrante*/
    public static boolean quadrante(int num, int lin, int col, int[][] matriz) {
        boolean aux = false;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i < 3 && j < 3) { // Verifica o quadrante
                    /*primeiro quadrante*/
                    if ((lin >= 0 && lin < 3) && (col >= 0 && col < 3)) { // Verifica se a linha e a coluna que desejamos inserir o elemento esta no quadrante
                        if (num == matriz[i][j]) { // Verifica se o elemento esta no quadrante da matriz
                            aux = true;
                        }
                    }
                } else if (i < 3 && j < 6) {
                    /*segundo quadrante*/
                    if ((lin >= 0 && lin < 3) && (col >= 3 && col < 6)) { // Verifica se a linha e a coluna que desejamos inserir o elemento esta no quadrante
                        if (num == matriz[i][j]) { // Verifica se o elemento esta no quadrante da matriz
                            aux = true;
                        }
                    }
                } else if (i < 3 && j < 10) {
                    /*terciro quadrante*/
                    if ((lin >= 0 && lin < 3) && (col >= 6 && col < 10)) { // Verifica se a linha e a coluna que desejamos inserir o elemento esta no quadrante
                        if (num == matriz[i][j]) { // Verifica se o elemento esta no quadrante da matriz
                            aux = true;
                        }
                    }
                } else if (i < 6 && j < 3) {
                    /*quarto quadrante*/
                    if ((lin >= 3 && lin < 6) && (col >= 0 && col < 3)) { // Verifica se a linha e a coluna que desejamos inserir o elemento esta no quadrante
                        if (num == matriz[i][j]) { // Verifica se o elemento esta no quadrante da matriz
                            aux = true;
                        }
                    }
                } else if (i < 6 && j < 6) {
                    /*quinto quadrante*/
                    if ((lin >= 3 && lin < 6) && (col >= 3 && col < 6)) { // Verifica se a linha e a coluna que desejamos inserir o elemento esta no quadrante
                        if (num == matriz[i][j]) { // Verifica se o elemento esta no quadrante da matriz
                            aux = true;
                        }
                    }
                } else if (i < 6 && j < 10) {
                    /*sexto quadrante*/
                    if ((lin >= 3 && lin < 6) && (col >= 6 && col < 10)) { // Verifica se a linha e a coluna que desejamos inserir o elemento esta no quadrante
                        if (num == matriz[i][j]) { // Verifica se o elemento esta no quadrante da matriz
                            aux = true;
                        }
                    }
                } else if (i < 10 && j < 3) {
                    /*setimo quadrante*/
                    if ((lin >= 6 && lin < 10) && (col >= 0 && col < 3)) { // Verifica se a linha e a coluna que desejamos inserir o elemento esta no quadrante
                        if (num == matriz[i][j]) { // Verifica se o elemento esta no quadrante da matriz
                            aux = true;
                        }
                    }
                } else if (i < 10 && j < 6) {
                    /*oitavo quadrante*/
                    if ((lin >= 6 && lin < 10) && (col >= 3 && col < 6)) { // Verifica se a linha e a coluna que desejamos inserir o elemento esta no quadrante
                        if (num == matriz[i][j]) { // Verifica se o elemento esta no quadrante da matriz
                            aux = true;
                        }
                    }
                } else if (i < 10 && j < 10) {
                    /*nono quadrante*/
                    if ((lin >= 6 && lin < 10) && (col >= 6 && col < 10)) { // Verifica se a linha e a coluna que desejamos inserir o elemento esta no quadrante
                        if (num == matriz[i][j]) { // Verifica se o elemento esta no quadrante da matriz
                            aux = true;
                        }
                    }
                }
            }
        }
        return aux;
    }

    /*Métod principal de execução, implementa recursividade e backtracking*/
    public static int sudoku(Tabuleiro no) {
        ArrayList<Tabuleiro> lista_filhos;
        
        int[][] matriz = no.getMatriz();
        boolean sucesso = false;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (matriz[i][j] == 0) {//verifica se o local está vazio para colocar um filho

                    if (!(no.getLista_filhos().isEmpty()) || no.jaTeveFilhos) {
                        lista_filhos = no.getLista_filhos();
                    } else {
                        lista_filhos = encontraFilhos(no, i, j);//encontra todos os filhos do nó
                    }

                    if (!lista_filhos.isEmpty()) {
                        no.setJaTeveFilhos(true);
                        no.setLista_filhos(lista_filhos);
                        for (Tabuleiro tab : lista_filhos) {

                            int vazio = printTabuleiro(tab.getMatriz(), "Sudoko processando...");//chama o método para imprimir o tabuleiro
                            if (vazio == 0) {//verifica se o tabuleiro já está completo
                                break;
                            } else {
                                sudoku(tab);
                            }
                        }
                    } else {
                        /*Realiza a poda dos nós sem solução*/
                        removeFilho(no.getPai().getLista_filhos(), no);
                        sudoku(no.getPai());//backtracking para retornar para o nó pai
                        break;
                    }
                }
            }
        }
        return 0;
    }
    /*Método usado para encontrar todos os nós filhos*/
    public static ArrayList<Tabuleiro> encontraFilhos(Tabuleiro no, int i, int j) {
        int[][] matriz = no.getMatriz();
        ArrayList<Tabuleiro> lista_filhos = new ArrayList<>();
        Tabuleiro tabuleiro;
        boolean TemFilhos = false;

        for (int num = 1; num < 10; num++) {
            if (!(verificaNumeroMatriz(num, i, j, matriz))) {
                if (!(quadrante(num, i, j, matriz))) {
                    TemFilhos = true;
                    tabuleiro = new Tabuleiro();
                    int[][] mat_aux = cloneMatriz(matriz);
                    mat_aux[i][j] = num;
                    id_tabuleiro++;//indice usado para acessar os filhos
                    tabuleiro.setId(id_tabuleiro);
                    tabuleiro.setPai(no);
                    tabuleiro.setMatriz(mat_aux);//Salva filho
                    lista_filhos.add(tabuleiro);

                }
            }
        }
        return lista_filhos;
    }

    /*Métod usado para remover um ramo da arvore sem saida - poda*/
    public static void removeFilho(ArrayList<Tabuleiro> lista_filhos, Tabuleiro filho_remover) {
        for (int i = 0; i < lista_filhos.size(); i++) {
            if (filho_remover.getId() == lista_filhos.get(i).getId()) {
                lista_filhos.remove(lista_filhos.get(i));
            }
        }
    }

    /*Método usdado para salvar uma intância da matriz por valor*/
    public static int[][] cloneMatriz(int[][] matriz) {
        int[][] mat_aux = new int[9][9];
        for (int i = 0; i < 9; i++) {
            System.arraycopy(matriz[i], 0, mat_aux[i], 0, 9);
        }
        return mat_aux;
    }
}
