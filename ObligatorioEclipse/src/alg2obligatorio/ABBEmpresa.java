
package alg2obligatorio;


public class ABBEmpresa {
    private NodoEmpresaABB raiz;
    
// <editor-fold defaultstate="collapsed" desc="Constructor, Get y Set">    
    public NodoEmpresaABB getRaiz() {
		return raiz;
	}
    public ABBEmpresa(){
        this.raiz=null;
    }
    public ABBEmpresa(NodoEmpresaABB raiz) {
            this.raiz = raiz;
    }
// </editor-fold>
	
	
	
// <editor-fold defaultstate="collapsed" desc="Métodos">
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
        String rec = mostrarRec(raiz);
        if(rec.isEmpty())
            return "";
        else    return rec.substring(0,rec.length()-1);
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
	
// </editor-fold>
    

}
