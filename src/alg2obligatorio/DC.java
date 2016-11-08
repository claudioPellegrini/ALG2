
package alg2obligatorio;


public class DC extends Punto{
    private String nombre;
    private NodoEmpresaABB empresa;
    private int capacidadCPUenHoras;
    private int costoCPUporHora;
    private boolean ocupado;
    
// <editor-fold defaultstate="collapsed" desc="Constructor, Get y Set">
    public DC(Double coordX, Double coordY,String nombre, NodoEmpresaABB empresa, int capacidadCPUenHoras, int costoCPUporHora) {
        super(coordX,coordY);
        //misCoord=p;
        this.nombre = nombre;
        this.empresa = empresa;
        this.capacidadCPUenHoras = capacidadCPUenHoras;
        this.costoCPUporHora = costoCPUporHora;
        this.ocupado=false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public NodoEmpresaABB getEmpresa() {
        return empresa;
    }

    public void setEmpresa(NodoEmpresaABB empresa) {
        this.empresa = empresa;
    }

    public int getCapacidadCPUenHoras() {
        return capacidadCPUenHoras;
    }

    public void setCapacidadCPUenHoras(int capacidadCPUenHoras) {
        this.capacidadCPUenHoras = capacidadCPUenHoras;
    }

    public int getCostoCPUporHora() {
        return costoCPUporHora;
    }

    public void setCostoCPUporHora(int costoCPUporHora) {
        this.costoCPUporHora = costoCPUporHora;
    }

    public String getMisCoord() {
        return super.getCoordX()+","+super.getCoordY();//misCoord;
    }
//
//    public void setMisCoord(Punto misCoord) {
//        this.misCoord = misCoord;
//    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
// </editor-fold>

    
// <editor-fold defaultstate="collapsed" desc="Métodos">
    public boolean equals(DC dc) {
        if (dc == null) {
            return false;
        }
        if (getClass() != dc.getClass()) {
            return false;
        }
        return dc.getMisCoord().equals(dc.getMisCoord());
    }
    public int costoProceso(){
        return this.capacidadCPUenHoras*this.costoCPUporHora;
    }	
// </editor-fold>
    
    
}
