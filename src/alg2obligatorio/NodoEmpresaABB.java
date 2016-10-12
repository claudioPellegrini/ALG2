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
public class NodoEmpresaABB {
    
    private String nombre;
    private String email;
    private String direccion;
    private String pais;
    private String color;
    private NodoEmpresaABB izq;
    private NodoEmpresaABB der;

    public NodoEmpresaABB(String nombre, String email, String direccion, String pais, String color) {
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
        this.pais = pais;
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public NodoEmpresaABB getIzq() {
        return izq;
    }

    public void setIzq(NodoEmpresaABB izq) {
        this.izq = izq;
    }

    public NodoEmpresaABB getDer() {
        return der;
    }

    public void setDer(NodoEmpresaABB der) {
        this.der = der;
    }

    @Override
    public String toString() {
        return "NodoEmpresaABB{" + "nombre=" + nombre + ", email=" + email + ", direccion=" + direccion + ", pais=" + pais + ", color=" + color + '}';
    }

}
