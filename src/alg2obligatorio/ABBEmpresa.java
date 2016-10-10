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
public class ABBEmpresa {
    private NodoEmpresaABB raiz;
	
	public NodoEmpresaABB getRaiz() {
		return raiz;
	}
        public ABBEmpresa(){
            this.raiz=null;
        }
	public ABBEmpresa(NodoEmpresaABB raiz) {
		this.raiz = raiz;
	}
	
	public void insertar(int dato){
		if(raiz == null)
			raiz = new NodoEmpresaABB(dato);
		else
			insertarRec(raiz, dato);
	}

	private void insertarRec(NodoEmpresaABB nodo, int dato) {
		if(nodo.getDato() != dato)
		{
			if(dato < nodo.getDato()){
				if(nodo.getIzq()!=null)
					insertarRec(nodo.getIzq(), dato);
				else
					nodo.setIzq(new NodoEmpresaABB(dato));
			} else {
				if(nodo.getDer()!=null)
					insertarRec(nodo.getDer(), dato);
				else
					nodo.setDer(new NodoEmpresaABB(dato));
			}
		}
	}
	
	public void mostrar(){
		mostrarRec(raiz);
	}

	private void mostrarRec(NodoEmpresaABB nodo) {
		if(nodo != null)
		{
			mostrarRec(nodo.getIzq());
			System.out.println(nodo.getDato() + " ");
			mostrarRec(nodo.getDer());
		}
	}
	public boolean pertenece(int x){
            return perteneceRec(x,raiz);
        }	

    private boolean perteneceRec(int x, NodoEmpresaABB nodo) {
        if(nodo==null)
            return false;
        else{
            if(nodo.getDato()==x)
                return true;
            else{
                if(x<nodo.getDato())
                    return perteneceRec(x,nodo.getIzq());
                else
                    return perteneceRec(x,nodo.getDer());
            }
        }
    }
    
    public void borrarMin(){
        if(raiz!=null){
            if(raiz.getIzq()==null)
                raiz=raiz.getDer();
            else
                borrarMinRec(raiz);
        }
    }

    private void borrarMinRec(NodoEmpresaABB nodo) {
        if(nodo.getIzq().getIzq()==null)
            nodo.setIzq(nodo.getIzq().getDer());
        else
            borrarMinRec(nodo.getIzq());
    }
    
    public void listarDescendente(){
	listarDescendenteRec(raiz);
    }

    private void listarDescendenteRec(NodoEmpresaABB nodo) {
            if(nodo != null)
            {
                    listarDescendenteRec(nodo.getDer());
                    System.out.println(nodo.getDato() + " ");
                    listarDescendenteRec(nodo.getIzq());
            }
    }
    
     public void listarAscendente(){
	listarAscendenteRec(raiz);
    }

    private void listarAscendenteRec(NodoEmpresaABB nodo) {
            if(nodo != null)
            {
                    listarAscendenteRec(nodo.getIzq());
                    System.out.println(nodo.getDato() + " ");
                    listarAscendenteRec(nodo.getDer());
            }
    }
    public void borrarElemento(int x){
        if(raiz!=null)
            if(raiz.getDato()==x){
                if(raiz.getIzq()==null&&raiz.getDer()==null)//es opcional ya lo chequea en el else nuevamente
                    raiz=null;
                else{
                    if(raiz.getIzq()==null)
                        raiz=raiz.getDer();
                    else if(raiz.getDer()==null)
                        raiz=raiz.getIzq();
                    else{
                        if(raiz.getDer().getIzq()==null){
                            raiz.setDato(raiz.getDer().getDato());
                            raiz.setDer(raiz.getDer().getDer());
                        }
                        else
                            raiz.setDato(borrarYRetMinRec(raiz.getDer()));
                    }
                        
                }
            }
            else
                borrarElementoRec(x,raiz);
    }

    private void borrarElementoRec(int x,NodoEmpresaABB nodo) {
        if(nodo.getDato()>x){
            if(nodo.getIzq()!=null){
                if(nodo.getIzq().getDato()==x){   
                    if(nodo.getIzq().getIzq()==null)
                        nodo.setIzq(nodo.getIzq().getDer());
                    else if(nodo.getIzq().getDer()==null)
                        nodo.setIzq(nodo.getIzq().getIzq());
                    else{
                        if(nodo.getIzq().getDer().getIzq()==null){
                            nodo.getIzq().setDato(nodo.getIzq().getDer().getDato());
                            nodo.getIzq().setDer(nodo.getIzq().getDer().getDer());
                        }
                        else
                            nodo.getIzq().setDato(borrarYRetMinRec(nodo.getIzq().getDer()));
                    }                  
                }
                else{
                    if(nodo.getIzq().getDato()>x)
                        borrarElementoRec(x,nodo.getIzq().getIzq());
                    else
                        borrarElementoRec(x,nodo.getIzq().getDer());
                }
            }
        }
        else{
            if(nodo.getDer()!=null){
                if(nodo.getDer().getDato()==x){
                    if(nodo.getDer().getIzq()==null)
                        nodo.setDer(nodo.getDer().getDer());
                    else if(nodo.getDer().getDer()==null)
                        nodo.setDer(nodo.getDer().getIzq());
                    else{
                        if(nodo.getDer().getDer().getIzq()==null){
                            nodo.getDer().setDato(nodo.getDer().getDer().getDato());
                            nodo.getDer().setDer(nodo.getDer().getDer().getDer());
                        }
                        else
                            nodo.getDer().setDato(borrarYRetMinRec(nodo.getDer().getDer()));
                    }        
                }
                else{
                    if(nodo.getDer().getDato()>x)
                        borrarElementoRec(x,nodo.getDer().getIzq());
                    else
                        borrarElementoRec(x,nodo.getDer().getDer());
                }
            }
        }
    }
    
    public int borrarYRetMin(){
        if(raiz.getIzq()!=null){
            int ret= raiz.getDato();
            raiz = raiz.getDer();
            return ret;
        }
        else{
            return borrarYRetMinRec(raiz);
        }
    }

    private int borrarYRetMinRec(NodoEmpresaABB nodo) {
        if(nodo.getIzq().getIzq()==null){
            int ret = nodo.getIzq().getDato();
            nodo.setIzq(nodo.getIzq().getDer());
            return ret;
        }
        else{
            return borrarYRetMinRec(nodo.getIzq());
        }
    }
}
