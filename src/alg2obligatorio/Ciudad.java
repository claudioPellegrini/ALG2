/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alg2obligatorio;

import java.util.Objects;

/**
 *
 * @author Euge
 */
public class Ciudad {
    private Punto misCoord;
    private String nombre;
    

    public Ciudad(String nombre, Punto p) {
        misCoord=p;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Punto getMisCoord() {
        return misCoord;
    }

    public void setMisCoord(Punto misCoord) {
        this.misCoord = misCoord;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

   
    public boolean equals(Ciudad c) {
        if (c == null) {
            return false;
        }
        if (getClass() != c.getClass()) {
            return false;
        }
        return c.getMisCoord().equals(c.getMisCoord());
    }

    
    
}
