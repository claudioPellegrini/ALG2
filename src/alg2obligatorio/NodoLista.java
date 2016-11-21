package alg2obligatorio;

public class NodoLista {

	private Punto nombreExterno;
	private int nombreInterno;
	private NodoLista sig;

	public NodoLista(Punto nombreExterno, int nombreInterno, NodoLista sig) {
		this.nombreExterno = nombreExterno;
		this.nombreInterno = nombreInterno;
		this.sig = sig;
	}
	
	public NodoLista(Punto nombreExterno, int nombreInterno) {
		this.nombreExterno = nombreExterno;
		this.nombreInterno = nombreInterno;
	}

	public Punto getNombreExterno() {
		return nombreExterno;
	}

	public void setNombreExterno(Punto nombreExterno) {
		this.nombreExterno = nombreExterno;
	}

	public int getNombreInterno() {
		return nombreInterno;
	}

	public void setNombreInterno(int nombreInterno) {
		this.nombreInterno = nombreInterno;
	}

	public NodoLista getSig() {
		return sig;
	}

	public void setSig(NodoLista sig) {
		this.sig = sig;
	}

	@Override
	public String toString() {
		return "NodoLista [nombreExterno=" + nombreExterno + ", nombreInterno="
				+ nombreInterno + ", sig=" + sig + "]";
	}

}
