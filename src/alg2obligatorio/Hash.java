package alg2obligatorio;

public class Hash {

	private int cont;
	private int tope;
	private int tamanio;
	private NodoLista[] vectorHash;
        
        
// <editor-fold defaultstate="collapsed" desc="Constructor, Get y Set"> 

	public Hash(int tope) {
		this.tope = tope;
		this.cont = 0;
		this.tamanio = proxPrimo(tope);
		this.vectorHash = new NodoLista[tamanio];
	}
        
        
        public NodoLista[] getVectorHash() {
		return vectorHash;
	}


// </editor-fold>
        
// <editor-fold defaultstate="collapsed" desc="Métodos">
	public void agregar(Punto p, int nomInt) {
		int pos = Double.valueOf(darNombreInterno(p)).intValue();
		NodoLista nuevo = new NodoLista(p, nomInt, vectorHash[pos]);
		vectorHash[pos] = nuevo;
		cont++;
	}

	public int nombreInterno(Punto p) {
		int pos = Double.valueOf(darNombreInterno(p)).intValue();
		NodoLista coli = vectorHash[pos];
		int nombreInterno = -1;
		while (coli != null) {
			if (coli.getNombreExterno().equals(p)) {
				nombreInterno = coli.getNombreInterno();
				break;
			}else{
                            if(coli.getSig()!=null)
                                coli= coli.getSig();                            
                        }
		}
		return nombreInterno;
	}

	// Pre: Existe p
	public void borrar(Punto p) {
		int pos = Double.valueOf(darNombreInterno(p)).intValue();

		if (vectorHash[pos].getNombreExterno().equals(p))
			vectorHash[pos] = vectorHash[pos].getSig();
		else {
			NodoLista coli = vectorHash[pos];
			while (coli.getSig() != null) {
				if (coli.getSig().getNombreExterno().equals(p)) {
					coli.setSig(coli.getSig().getSig());
					break;
				}
			}
		}
	}

	private boolean esPrimo(int num) {
		if (num <= 1)
			return false;
		else {
			for (int i = 2; i < num; i++)
				if (num % i == 0)
					return false;
			return true;
		}
	}

	private int proxPrimo(int num) {
		while (!esPrimo(++num));
		return num;
	}

	private double darNombreInterno(Punto p) {
            double tam=tamanio*1.0;
            double suma = p.getCoordX() + p.getCoordY();
            suma = (suma<0)?(suma*-1):suma*1;
            return suma % tam;
	}
        
    // </editor-fold>

	
}
