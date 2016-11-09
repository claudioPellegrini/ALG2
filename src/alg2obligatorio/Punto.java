
package alg2obligatorio;

import alg2obligatorio.Sistema.TipoPunto;
import java.util.Objects;


public class Punto {    
    private Double coordX;
    private Double coordY;
    private TipoPunto tipo;
    
    
// <editor-fold defaultstate="collapsed" desc="Constructor, Get y Set">
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

    public TipoPunto getTipo() {
        return tipo;
    }

    public void setTipo(TipoPunto tipo) {
        this.tipo = tipo;
    }
// </editor-fold>
    
    
// <editor-fold defaultstate="collapsed" desc="Métodos">
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        final Punto other = (Punto) obj;
        if (!Objects.equals(this.coordX, other.coordX)||!Objects.equals(this.coordY, other.coordY)) {
            return false;
        }
       
        return true;
    }
// </editor-fold>
    

    


    
}
