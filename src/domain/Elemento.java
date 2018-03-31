/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;


public class Elemento {
    
    private int id;
    private String titulo,duracion,comentario;
    private boolean loTengo;

    public Elemento() {
    }

    public Elemento(int id, String titulo, String duracion, String comentario, boolean loTengo) {
        this.id = id;
        this.titulo = titulo;
        this.duracion = duracion;
        this.comentario = comentario;
        this.loTengo = loTengo;
    }
    
    public void imprimir(){
        
    }
    
    public int getId() {
        return id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public boolean isLoTengo() {
        return loTengo;
    }

    public void setLoTengo(boolean loTengo) {
        this.loTengo = loTengo;
    }
    
    
    
    
    
}
