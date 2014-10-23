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
public interface CifradoCesar {
    
    /**
     *
     * @param palabra
     * @param clave
     * @return
     */
    public String cifrarPalabra(String palabra, String clave);
    
}
