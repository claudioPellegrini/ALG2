package alg2obligatorio;
public class ArcoPunto {
	private boolean existe;
	private int peso;
	
	public boolean isExiste() {
		return existe;
	}
	public void setExiste(boolean existe) {
		this.existe = existe;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public ArcoPunto( int peso) {
		this.existe = true;
		this.peso = peso;
	}
	public ArcoPunto() {
//		this.existe = false;
//		this.peso = 0;
	}
}
