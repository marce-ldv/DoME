/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;


public class Dvd extends Elemento{
    
    private String director;
    
    public Dvd(){
        
    }
    
    public Dvd(String director){
        super();
        this.director = director;   
    }

    public String getDirector() {
        return director;
    }
    
}
