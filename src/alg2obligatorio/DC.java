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
public class DC {
    private String nombre;
    private NodoEmpresaABB empresa;
    private Punto misCoord;
    private int capacidadCPUenHoras;
    private int costoCPUporHora;
    private boolean ocupado;

    public DC(String nombre, NodoEmpresaABB empresa, int capacidadCPUenHoras, int costoCPUporHora, Punto p) {
        misCoord=p;
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

    public Punto getMisCoord() {
        return misCoord;
    }

    public void setMisCoord(Punto misCoord) {
        this.misCoord = misCoord;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    
    
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
}
