/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alg2obligatorio;

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
    
}
