/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author JohanFabiel
 */
public class DES implements CifradoCesar {
    
    private static String palabraLimpias;
    private static String[][] claves;
    private static String palabraCifrada;
    private static  String[] alfabeto;
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DES.alfabeto = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        generarClaves(16);
    }

    public DES() {
        this.alfabeto = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    }

    @Override
    public String cifrarPalabra(String palabra) {
        
        return null;
        
    }
    
    /**
     * @description this metod generate n number of sub pass
     * @autor Johan fabiel casas diaz <fabiel016_@hotmail.com>
     * @param numClaves 
     */
    public static void generarClaves(int numClaves){
        claves = new String[numClaves][DES.alfabeto.length];
        int k = 0;
        for (int i = 0; i < numClaves; i++){
            for (int j = i; j < DES.alfabeto.length; j ++){
                claves[i][j] = DES.alfabeto[k];
                k++;
            }
            for (int j = 0; j < i; j ++){
                claves[i][j] = DES.alfabeto[k];
                k ++;
            }
            k = 0;
            System.out.println(claves[i]);
        }
    }
    
}
