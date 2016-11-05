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
    private int capacidadCPUporHora;

    public DC(String nombre, NodoEmpresaABB empresa, int capacidadCPUenHoras, int capacidadCPUporHora, Punto p) {
        misCoord=p;
        this.nombre = nombre;
        this.empresa = empresa;
        this.capacidadCPUenHoras = capacidadCPUenHoras;
        this.capacidadCPUporHora = capacidadCPUporHora;
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

    public int getCapacidadCPUporHora() {
        return capacidadCPUporHora;
    }

    public void setCapacidadCPUporHora(int capacidadCPUporHora) {
        this.capacidadCPUporHora = capacidadCPUporHora;
    }

    public Punto getMisCoord() {
        return misCoord;
    }

    public void setMisCoord(Punto misCoord) {
        this.misCoord = misCoord;
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
}
