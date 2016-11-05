
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
	
	public void insertar(String nombre, String email, String pais, String direccion, String color){
            if(raiz == null)
                raiz = new NodoEmpresaABB(nombre, email, direccion, pais, color);
            else
                insertarRec(raiz, nombre, email, direccion, pais, color);
	}

	private void insertarRec(NodoEmpresaABB nodo, String nombre, String email, String direccion,String pais,String color) {
            if(!nodo.getNombre().equals(nombre))
            {
                if(nodo.getNombre().compareTo(nombre)>0){
                    if(nodo.getIzq()!=null)
                        insertarRec(nodo.getIzq(), nombre,email,direccion,pais,color);
                    else
                        nodo.setIzq(new NodoEmpresaABB(nombre, email, direccion, pais, color));
                } else {
                    if(nodo.getDer()!=null)
                        insertarRec(nodo.getDer(), nombre,email,direccion,pais,color);
                    else
                        nodo.setDer(new NodoEmpresaABB(nombre, email, direccion, pais, color));
                }
            }
	}
	
	public String mostrar(){
            return mostrarRec(raiz);
	}

	private String mostrarRec(NodoEmpresaABB nodo) {
            
            String ret=new String();
            if(nodo != null)
            {
                ret+=mostrarRec(nodo.getIzq());
                ret+=nodo.toString()+"|";
                ret+=mostrarRec(nodo.getDer());
            }
            return ret;
	}
	public boolean pertenece(String x){
            return perteneceRec(x,raiz);
        }	

    private boolean perteneceRec(String x, NodoEmpresaABB nodo) {
        if(nodo==null)
            return false;
        else{
            if(nodo.getNombre().equals(x))
                return true;
            else{
                if(x.compareTo(nodo.getNombre())<0)
                    return perteneceRec(x,nodo.getIzq());
                else
                    return perteneceRec(x,nodo.getDer());
            }
        }
    }
    public boolean existe(String nom){
            return existeRec(nom,raiz);
        }	
    private boolean existeRec(String x, NodoEmpresaABB nodo) {
        if(nodo==null)
            return false;
        else{
            if(nodo.getNombre().equals(x))
                return true;
            else{
                if(x.compareTo(nodo.getNombre())<0)
                    return perteneceRec(x,nodo.getIzq());
                else
                    return perteneceRec(x,nodo.getDer());
            }
        }
    }
    
    public NodoEmpresaABB Buscar(NodoEmpresaABB nodo, String nom){
        if(nodo!=null){
            if(nodo.getNombre().compareTo(nom)==0)
                return nodo;
            else if(nodo.getNombre().compareTo(nom)<0)
                return Buscar(nodo.getDer(), nom);
            else if(nodo.getNombre().compareTo(nom)>0)
                return Buscar(nodo.getIzq(), nom);
        }
        return null;
    }
//    
//    public void borrarMin(){
//        if(raiz!=null){
//            if(raiz.getIzq()==null)
//                raiz=raiz.getDer();
//            else
//                borrarMinRec(raiz);
//        }
//    }
//
//    private void borrarMinRec(NodoEmpresaABB nodo) {
//        if(nodo.getIzq().getIzq()==null)
//            nodo.setIzq(nodo.getIzq().getDer());
//        else
//            borrarMinRec(nodo.getIzq());
//    }
//    
//    public void listarDescendente(){
//	listarDescendenteRec(raiz);
//    }
//
//    private void listarDescendenteRec(NodoEmpresaABB nodo) {
//            if(nodo != null)
//            {
//                    listarDescendenteRec(nodo.getDer());
//                    System.out.println(nodo.getDato() + " ");
//                    listarDescendenteRec(nodo.getIzq());
//            }
//    }
//    
//     public void listarAscendente(){
//	listarAscendenteRec(raiz);
//    }
//
//    private void listarAscendenteRec(NodoEmpresaABB nodo) {
//            if(nodo != null)
//            {
//                    listarAscendenteRec(nodo.getIzq());
//                    System.out.println(nodo.getDato() + " ");
//                    listarAscendenteRec(nodo.getDer());
//            }
//    }
//    public void borrarElemento(int x){
//        if(raiz!=null)
//            if(raiz.getDato()==x){
//                if(raiz.getIzq()==null&&raiz.getDer()==null)//es opcional ya lo chequea en el else nuevamente
//                    raiz=null;
//                else{
//                    if(raiz.getIzq()==null)
//                        raiz=raiz.getDer();
//                    else if(raiz.getDer()==null)
//                        raiz=raiz.getIzq();
//                    else{
//                        if(raiz.getDer().getIzq()==null){
//                            raiz.setDato(raiz.getDer().getDato());
//                            raiz.setDer(raiz.getDer().getDer());
//                        }
//                        else
//                            raiz.setDato(borrarYRetMinRec(raiz.getDer()));
//                    }
//                        
//                }
//            }
//            else
//                borrarElementoRec(x,raiz);
//    }
//
//    private void borrarElementoRec(int x,NodoEmpresaABB nodo) {
//        if(nodo.getDato()>x){
//            if(nodo.getIzq()!=null){
//                if(nodo.getIzq().getDato()==x){   
//                    if(nodo.getIzq().getIzq()==null)
//                        nodo.setIzq(nodo.getIzq().getDer());
//                    else if(nodo.getIzq().getDer()==null)
//                        nodo.setIzq(nodo.getIzq().getIzq());
//                    else{
//                        if(nodo.getIzq().getDer().getIzq()==null){
//                            nodo.getIzq().setDato(nodo.getIzq().getDer().getDato());
//                            nodo.getIzq().setDer(nodo.getIzq().getDer().getDer());
//                        }
//                        else
//                            nodo.getIzq().setDato(borrarYRetMinRec(nodo.getIzq().getDer()));
//                    }                  
//                }
//                else{
//                    if(nodo.getIzq().getDato()>x)
//                        borrarElementoRec(x,nodo.getIzq().getIzq());
//                    else
//                        borrarElementoRec(x,nodo.getIzq().getDer());
//                }
//            }
//        }
//        else{
//            if(nodo.getDer()!=null){
//                if(nodo.getDer().getDato()==x){
//                    if(nodo.getDer().getIzq()==null)
//                        nodo.setDer(nodo.getDer().getDer());
//                    else if(nodo.getDer().getDer()==null)
//                        nodo.setDer(nodo.getDer().getIzq());
//                    else{
//                        if(nodo.getDer().getDer().getIzq()==null){
//                            nodo.getDer().setDato(nodo.getDer().getDer().getDato());
//                            nodo.getDer().setDer(nodo.getDer().getDer().getDer());
//                        }
//                        else
//                            nodo.getDer().setDato(borrarYRetMinRec(nodo.getDer().getDer()));
//                    }        
//                }
//                else{
//                    if(nodo.getDer().getDato()>x)
//                        borrarElementoRec(x,nodo.getDer().getIzq());
//                    else
//                        borrarElementoRec(x,nodo.getDer().getDer());
//                }
//            }
//        }
//    }
//    
//    public int borrarYRetMin(){
//        if(raiz.getIzq()!=null){
//            int ret= raiz.getDato();
//            raiz = raiz.getDer();
//            return ret;
//        }
//        else{
//            return borrarYRetMinRec(raiz);
//        }
//    }
//
//    private int borrarYRetMinRec(NodoEmpresaABB nodo) {
//        if(nodo.getIzq().getIzq()==null){
//            int ret = nodo.getIzq().getDato();
//            nodo.setIzq(nodo.getIzq().getDer());
//            return ret;
//        }
//        else{
//            return borrarYRetMinRec(nodo.getIzq());
//        }
//    }
}
