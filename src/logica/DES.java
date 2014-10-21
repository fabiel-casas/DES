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
    
    private String palabraLimpias;
    private String[] claves;
    private String palabraCifrada;
    private  String[] alfabeto;
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    public DES() {
        this.alfabeto = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    }

    @Override
    public String cifrarPalabra(String palabra) {
        
        return null;
        
    }
    
    public void generarClaves(int numClaves){
        claves = new String[numClaves];
        for (int i = 0; i < numClaves; i++){
            
        }
    }
    
}
