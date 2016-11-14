
package alg2obligatorio;

import java.util.Objects;


public class Ciudad extends Punto{
    private String nombre;
    
    
// <editor-fold defaultstate="collapsed" desc="Constructor, Get y Set">
    public Ciudad(Double coordX, Double coordY,String nombre) {
        super(coordX,coordY);
        //misCoord=p;        
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMisCoord() {
        return super.getCoordX()+","+super.getCoordY();//misCoord;
    }

//    public void setMisCoord(Punto misCoord) {
//        this.misCoord = misCoord;
//    }

// </editor-fold>
    

// <editor-fold defaultstate="collapsed" desc="Métodos">
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
// </editor-fold>
   
    

    
    
}
