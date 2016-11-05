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
public class Punto {
    
    //Ver si lo que tendriamos que tener es un grafo de Puntos y que las ciudades y los dc se asocien a ese grafo... ver
    
    private Double coordX;
    private Double coordY;

    public Punto(Double coordX, Double coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public Double getCoordX() {
        return coordX;
    }

    public void setCoordX(Double coordX) {
        this.coordX = coordX;
    }

    public Double getCoordY() {
        return coordY;
    }

    public void setCoordY(Double coordY) {
        this.coordY = coordY;
    }

    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Punto other = (Punto) obj;
        if (!Objects.equals(this.coordX, other.coordX)||!Objects.equals(this.coordY, other.coordY)) {
            return false;
        }
       
        return true;
    }

    @Override
    public String toString() {
        return coordX + "," + coordY;
    }
    
    
}
