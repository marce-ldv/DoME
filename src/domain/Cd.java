/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;


public class Cd extends Elemento{
    
    private String interprete;
    private int numeroCanciones;

    public Cd() {
    }

    public Cd(String interprete,int numeroCanciones){
        super(); //primero llamo a mi padre
        //Ahora si hago lo mio
        this.interprete = interprete;
        this.numeroCanciones = numeroCanciones;
    }

    public String getInterprete() {
        return interprete;
    }

    public int getNumeroCanciones() {
        return numeroCanciones;
    }

    
    

    
    
}
