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
    private int dato;
	private NodoEmpresaABB izq;
	private NodoEmpresaABB der;

	public NodoEmpresaABB(int dato, NodoEmpresaABB izq, NodoEmpresaABB der) {
		this.dato = dato;
		this.izq = izq;
		this.der = der;
	}
	
	public NodoEmpresaABB(int dato) {
		this.dato = dato;
	}

	public int getDato() {
		return dato;
	}

	public void setDato(int dato) {
		this.dato = dato;
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
		return "NodoAB [dato=" + dato + ", izq=" + izq + ", der=" + der + "]";
	}

}
