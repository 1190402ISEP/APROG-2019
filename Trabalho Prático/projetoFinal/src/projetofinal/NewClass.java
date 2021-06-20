/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofinal;

import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.Integer.parseInt;
import java.util.Scanner;

/**
 *
 * @author anton
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import static java.lang.Integer.parseInt;
public class NewClass {






    static final int MAX_LINHAS = 50;
    static final int MAX_COLUNAS1 = 2;
    static final int MAX_COLUNAS2 = 7;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner ler = new Scanner(System.in);
        int x = 0;
        String[][] dadosString = new String[MAX_LINHAS][MAX_COLUNAS1];
        int[][] dadosNumericos = new int[MAX_LINHAS][MAX_COLUNAS2];
        int escolha;
        boolean check = true;
        while (check == true) {

            System.out.println("INSIRA O Nº CORRESPONDENTE À AÇÃO A EXECUTAR:");
            System.out.println("1-LER A INFORMAÇÃO DISPONÍVEL NO FICHEIRO DE TEXTO E ARMAZENÁ-LA");
            System.out.println("2-INSERIR MANUALMENTE INFORMAÇÃO DE UMA SELEÇÃO (EX: B,Portugal,3,1,2,0,5,4)");
            System.out.println("3-CALCULAR E ARMAZENAR A PONTUAÇÃO DE TODAS AS EQUIPAS");
            System.out.println("4-CALCULAR E ARMAZENAR A CLASSIFICAÇÃO DE TODAS AS EQUIPAS");
            System.out.println("5-LISTAR A CLASSIFICAÇÃO DAS EQUIPAS POR GRUPO");
            System.out.println("6-LISTAR AS EQUIPAS CUJOS GOLOS MARCADOS É IGUAL AO MÁXIMO DE GOLOS MARCADOS");
            System.out.println("7-LISTAR AS EQUIPAS COM UM DETERMINADO Nº DE GOLOS MARCADOS");
            System.out.println("8-LISTAR AS EQUIPAS COM UM DETERMINADO Nº DE GOLOS SOFRIDOS");
            System.out.println("9-LISTAR O PRIMEIRO CLASSIFICADO DE CADA GRUPO");
            System.out.println("10-LISTAR INFORMAÇÃO COMPLETA DE UMA EQUIPA (DEVE ESCOLHER A EQUIPA!!)");
            System.out.println("11-CRIAR UM FICHEIRO COM ESTATÍSTICAS DOS JOGOS");
            System.out.println("12-ELIMINAR AS EQUIPAS QUE NÃO VÃO DISPUTAR A FASE SEGUINTE");
            System.out.println("13-CRIAR UM FICHEIRO COM AS EQUIPAS QUE VÃO DISPUTAR A FASE SEGUINTE DO CAMPEONATO");
            System.out.println("14-CRIAR UM FICHEIRO COM OS JOGOS DA FASE FINAL");
            System.out.println("15-SAIR");
            escolha = ler.nextInt();
            while (escolha < 1 || escolha > 15) {
                System.out.println("OPÇÃO INVÁLIDA! INSERIR UM NÚMERO VÁLIDO!!!");
                escolha = ler.nextInt();
            }
            switch (escolha) {
                case 1:
                    x = inserirDados(dadosString, dadosNumericos);
                    break;
                case 2:
                    x = inserirManualmente(dadosString, dadosNumericos, x);
                    break;
                case 3:
                    Pontos(dadosNumericos, x);
                    break;
                case 4:
                    Compare(dadosString, dadosNumericos, x);
                    break;
                case 5:
                    listar1(dadosString, dadosNumericos, x);
                    break;
                case 6:
                    check = false;
                    break;
                case 7:
                    check = false;
                    break;
                case 8:
                    check = false;
                    break;
                case 9:
                    check = false;
                    break;
                case 10:
                    check = false;
                    break;
                case 11:
                    check = false;
                    break;
                case 12:
                    check = false;
                    break;
                case 13:
                    check = false;
                    break;
                case 14:
                    check = false;
                    break;
                case 15:
                    check = false;

            }
        }

    }

    public static int inserirDados(String[][] dadosString, int[][] dadosNumericos) throws FileNotFoundException {
        File dados = new File("C:\\Users\\anton\\Downloads/PracticalWork.csv");
        Scanner ler = new Scanner(dados);

        String frase;
        ler.nextLine();
        int x = 0;

        while (ler.hasNextLine()) {

            frase = ler.nextLine();
            String[] frasec = frase.split(",");
            dadosString[x][0] = frasec[0];
            dadosString[x][1] = frasec[1];
            for (int c = 0, z = 2; z < frasec.length; z++, c++) {
                dadosNumericos[x][c] = parseInt(frasec[z]);
            }
            x++;
        }
        ler.close();
        return x;

    }

    public static int inserirManualmente(String[][] dadosString, int[][] dadosNumericos, int x) {
        Scanner sc;
        int h = 0;
        String m;
        sc = new Scanner(System.in);
        while (h != x) {
            h++;
        }
        System.out.println("NOME");
        dadosString[h][1] = sc.nextLine();

        for (int c = 0; c < x; c++) {

            if (dadosString[h][1].equals(dadosString[c][1]) == true) {
                System.out.println("Try again? Y or N");
                m = sc.nextLine();
                switch (m) {
                    case "Y":
                        inserirManualmente(dadosString, dadosNumericos, x);
                    case "N":
                        return x;
                    default:
                        return x;
                }
            }
        }
        System.out.println("Grupo");
        dadosString[h][0] = sc.nextLine();
        for (int g = 0; g < 6; g++) {
            dadosNumericos[h][g] = sc.nextInt();
        }
        x++;
        return x;
    }

    public static void Pontos(int[][] dadosNumericos, int x) {
        int pontos, c;
        for (c = 0; c < x; c++) {
            pontos = dadosNumericos[c][1] * 3 + dadosNumericos[c][2] * 1;
            dadosNumericos[c][6] = pontos;
        }

    }

    public static void Compare(String[][] dadosString, int[][] dadosNumericos, int x) {
        int c, f;
        for (c = 0; c < x; c++) {
            for (f = c + 1; f < x; f++) {
                if (dadosString[c][0].equals(dadosString[f][0]) == true) {
                    String aux0 = dadosString[c + 1][0];
                    String aux1 = dadosString[c + 1][1];
                    dadosString[c + 1][0] = dadosString[f][0];
                    dadosString[c + 1][1] = dadosString[f][1];
                    dadosString[f][0] = aux0;
                    dadosString[f][1] = aux1;
                    for (int u = 0; u < 7; u++) {
                        int aux = dadosNumericos[c + 1][u];
                        dadosNumericos[c + 1][u] = dadosNumericos[f][u];
                        dadosNumericos[f][u] = aux;
                    }
                }

            }

        }

        for (int s = 0; s < x; s++) {
            if (dadosString[s][0].equals(dadosString[s + 1][0]) == true) {

                int n = 1;
                int e = s;

                while (dadosString[s][0].equals(dadosString[e + 1][0])) {
                    n++;
                    e++;
                }
                for (int con = 1; con < n; con++) {
                    //pontos

                    if (dadosNumericos[s][6] < dadosNumericos[con + s][6]) {
                        String aux0 = dadosString[s][0];
                        String aux1 = dadosString[s][1];
                        dadosString[s][0] = dadosString[con + s][0];
                        dadosString[s][1] = dadosString[con + s][1];
                        dadosString[con + s][0] = aux0;
                        dadosString[con + s][1] = aux1;

                        for (int u = 0; u < 7; u++) {
                            int aux = dadosNumericos[s][u];
                            dadosNumericos[s][u] = dadosNumericos[con + s][u];
                            dadosNumericos[con + s][u] = aux;
                        }
                    }
                    //golos marcados

                    if (dadosNumericos[s][6] == dadosNumericos[con + s][6]) {
                        if (dadosNumericos[s][4] < dadosNumericos[con + s][4]) {
                            String aux0 = dadosString[s][0];
                            String aux1 = dadosString[s][1];
                            dadosString[s][0] = dadosString[con + s][0];
                            dadosString[s][1] = dadosString[con + s][1];
                            dadosString[con + s][0] = aux0;
                            dadosString[con + s][1] = aux1;

                            for (int u = 0; u < 7; u++) {
                                int aux = dadosNumericos[s][u];
                                dadosNumericos[s][u] = dadosNumericos[con + s][u];
                                dadosNumericos[con + s][u] = aux;
                            }
                        }
                    }

                    //golos s
                    if (dadosNumericos[s][6] == dadosNumericos[con + s][6]) {
                        if (dadosNumericos[s][4] == dadosNumericos[con + s][4]) {
                            if (dadosNumericos[s][5] > dadosNumericos[con + s][5]) {
                                String aux0 = dadosString[s][0];
                                String aux1 = dadosString[s][1];
                                dadosString[s][0] = dadosString[con + s][0];
                                dadosString[s][1] = dadosString[con + s][1];
                                dadosString[con + s][0] = aux0;
                                dadosString[con + s][1] = aux1;

                                for (int u = 0; u < 7; u++) {
                                    int aux = dadosNumericos[s][u];
                                    dadosNumericos[s][u] = dadosNumericos[con + s][u];
                                    dadosNumericos[con + s][u] = aux;
                                }
                            }
                        }
                    }
                    //alfabetico
                    if (dadosNumericos[s][6] == dadosNumericos[con + s][6]) {
                        if (dadosNumericos[s][4] == dadosNumericos[con + s][4]) {
                            if (dadosNumericos[s][5] == dadosNumericos[con + s][5]) {
                                if (dadosString[s][1].compareTo(dadosString[con + s][1]) > dadosString[con + s][1].compareTo(dadosString[s][1])) {
                                    String aux0 = dadosString[s][0];
                                    String aux1 = dadosString[s][1];
                                    dadosString[s][0] = dadosString[con + s][0];
                                    dadosString[s][1] = dadosString[con + s][1];
                                    dadosString[con + s][0] = aux0;
                                    dadosString[con + s][1] = aux1;

                                    for (int u = 0; u < 7; u++) {
                                        int aux = dadosNumericos[s][u];
                                        dadosNumericos[s][u] = dadosNumericos[con + s][u];
                                        dadosNumericos[con + s][u] = aux;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     public static void listar1(String[][] dadosString, int[][] dadosNumericos, int x) {
        int i;
        int u = 0;
        for (int indice = 0; indice < dadosString.length; indice++) {
            u++;
            System.out.println(dadosString[indice][u]);
            u = 0;
            System.out.println(dadosString[indice][u]);

        }

    }
   
    }

/*int u = 0;
        for (int indice = 0; indice < dadosString.length; indice++) {
            u++;
            System.out.println(dadosString[indice][u]);
            u = 0;
            System.out.println(dadosString[indice][u]);

        }

*/

}
