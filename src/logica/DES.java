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
public class DES {
    
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
        //cifrarPalabra("Paloma", "Horas");
        //generarClaves(16);
        xor("0110","1000");
        sustitucion("10100000");
    }

    public DES() {
        this.alfabeto = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    }

    public static String cifrarPalabra(String palabra, String clave) {
        String[] p = palabra.split("");
        String[] c = clave.split("");
        System.out.println("palabra " + palabra + " clave " + clave);
        System.out.println("# palabra " + p.length + " / # clave " + c.length);
        if (p.length != 6){
            return null;
        }
        if (c.length != 5){
            return null;
        }
        String textoCifrado = "";
        for (int i = 0; i < p.length ; i++){
            if(i < c.length){
                textoCifrado += p[i] + c[i];
            } else {
                textoCifrado += p[i];
            }
        }
        System.out.println("texto cirado " + textoCifrado);
        
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
    
    private String separaPorDigito(String digitoBinario) {
        String frase = "";//almacena la frase completa

        for (int i = 0; i < digitoBinario.length(); i += 8) {//recorre la frase de 8 en 8
            /*separa la cadena cada 8 digitos con substring*/
            String cadenaSeparada = digitoBinario.substring(i, i + 8);
            /*entrega un numero decimal a partir de un numero binario de 8 bit*/
            int decimal = Integer.parseInt(cadenaSeparada, 2);
            /*concadena la drase y transfroma el decimal a Ascii*/
            frase = frase + (char) decimal;
        }
        return frase;//retorna la frase completa
    }
    
    private void textoPorCaracter(String texto) {

        String codigoBinario = "";//guarda el en binario
        for (int i = 0; i < texto.length(); i++) {//recorre el texto ingresado
            char letra = texto.charAt(i);//separa letra a letra
            /* si el binario de la letra es menor a 8 bit entonces se le agrega
             un cero a la izquierda para llenar el bit restante*/
            int aux = caracterBinario((int) (letra)).length();//almacena largo del binario d ela letra debuelta
            for (int j = 0; j < 8; j++) {//recorrido de 8 characteres
                if (aux < 8) {//si el largo del binario es menor a 7 (0-7)entonces
                    codigoBinario = codigoBinario + "0";//agregar 0 a la concadenacion
                    aux++;//aumentar el largo del binario
                }
            }
            /*se concatena el binario de cada letra separado por un espacio. al metodo binario
             se le pasa por parametro el decimal correspondiente a cada letra*/
            codigoBinario = codigoBinario + caracterBinario((int) (letra)) + " ";
        }
        //destino.setText(codigoBinario);/*imprime el codigo binario completo*/
        System.out.println(codigoBinario);
    }

    private String caracterBinario(int Decimal) {
        int R, x = 0;//variables que se implementaran
        String Binario = ""; //guarda el contenido en codigo binario
        R = Decimal % 2;//resto del parametro 
        if (R == 1) {//si el resto es 1
            while (Decimal > 1) {//si el parametro es mas grande q el resto
                Decimal /= 2;//entonces decimal se divide en 2 y se guarda en decimal
                x = Decimal % 2;//x contendra el resto del decimal
                Binario = String.valueOf(x + Binario);//binario se ira formando de forma correcta y no alreves
            }
        } else {//si resto no es 1
            while (Decimal > 0) {//y decimal es mayor a 0
                Decimal /= 2;//decimal se divide en 2
                x = Decimal % 2;//x contendra el resto del decimal resultante
                Binario = String.valueOf(x + Binario);//se forma el numero en binario de forma correcta
            }
        }
        return String.valueOf(Binario + x);//devuelve el binario resultante mas el ultimo bit
    }
    
    
    private static String xor(String texto1, String texto2){
        String[] cadena1 = texto1.split("");
        String[] cadena2 = texto2.split("");
        if(cadena1.length != cadena2.length){
            System.out.println("No son octetos "+cadena1.length +"!="+ cadena2.length);
            return null;
        }
        String textoSalida = "";
        for(int i=0; i < cadena1.length ; i++){
            if( cadena1[i].equals(cadena2[i])){
                textoSalida += "0";
            }else{
                textoSalida += "1";
            }
        }
        System.err.println("texto salida "+ textoSalida);
        return textoSalida;
        
    }
    
    private static String sustitucion(String texto){
        String textoSalida = "";
        String[] cadena1 = texto.split("");
        if(cadena1.length != 8){
            System.out.println("No son octetos "+cadena1.length);
            return null;
        }
        for(int i = cadena1.length - 1; i >= 0 ; i--){
            textoSalida += cadena1[i];
        }
        System.err.println("texto salida sustitucion " + textoSalida);
        return textoSalida;
    }
    
}
