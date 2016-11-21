
package alg2obligatorio;

import alg2obligatorio.Sistema.TipoPunto;



public class GrafoPuntos {
    private ArcoPunto [][] matAdy;
    private int costoMinimo;
    private Punto [] vertices; 
    private int cantV;
    private int tope; // maxima cantidad de puntos que va a tener el grafo
    private Hash elHash;

    
// <editor-fold defaultstate="collapsed" desc="Constructor, Get y Set">
    public GrafoPuntos(int tope) {
        crearMatriz(tope);
        this.vertices = new Punto[tope];

        this.tope = tope;
        this.cantV=0;
        
        this.elHash= new Hash(tope);
    }

    public int getCostoMinimo() {
        return costoMinimo;
    }
    
    public Punto[] getVertices() {
        return vertices;
    }

    public void setVertices(Punto[] vertices) {
        this.vertices = vertices;
    }

    public int getCantV() {
        return cantV;
    }

    public void setCantV(int cantV) {
        this.cantV = cantV;
    }

    public int getTope() {
        return tope;
    }

    public void setTope(int tope) {
        this.tope = tope;
    }
    
    public ArcoPunto[][] getMatAdy() {
        return matAdy;
    }
    
    public void setMatAdy(ArcoPunto[][] matAdy) {
        this.matAdy = matAdy;
    }
    
    public Hash getElHash() {
        return elHash;
    }
// </editor-fold>
    
    
// <editor-fold defaultstate="collapsed" desc="Métodos">
    private void crearMatriz(int tope){
        this.setMatAdy(new ArcoPunto[tope][tope]);
            for (int i=0; i < tope; i++)
            {
                for (int j=0; j<tope; j++)
                {
                    getMatAdy()[i][j] = new ArcoPunto();
                }
            }
    }
    
    //PRE: Grafo conexo
    //POST: String de red minima
    public String prim(){
        costoMinimo=0;
        boolean[] visitado = new boolean[tope];
        visitado[0]=true;
        ArcoPunto[][] aux = new ArcoPunto[tope][tope];
        for (int i = 0; i < aux.length; i++) 
                for(int j=0;j<aux.length;j++)
                        aux[i][j] = new ArcoPunto();
        //Proceso
        String ret="";
        //Inicializar valor minimo (MAX_VALUE), y coordinadas de arista candidata
        for (int k = 0; k < cantV-1; k++) {//for que solo sirve de contador
            int min=Integer.MAX_VALUE; int imin = 0; int jmin=1;
            for (int i = 0; i < tope; i++) {
                if(vertices[i]!=null && visitado[i]){
                    for(int j=0;j<tope;j++){
                        if(vertices[j]!=null && !visitado[j]){
                            if(matAdy[i][j].isExiste()){
                                if(matAdy[i][j].getPeso()<min){
                                    min=matAdy[i][j].getPeso();
                                    imin=i;
                                    jmin=j;
                                }
                            }
                        }
                    }
                }
            }
            aux[imin][jmin]=aux[jmin][imin]=new ArcoPunto(min);
            //creamos un string 
            ret+=obtenerOrigen(vertices[imin])+";"+obtenerOrigen(vertices[jmin])+"|";
            if(min!=Integer.MAX_VALUE)  costoMinimo+=min;
            visitado[jmin]=true;
        }        
        return ret;
    }    
    
    public String dijkstra (Punto origen,int esfuerzo){
        int[] distancia = new int[tope];
        boolean[] visitados = new boolean[tope];//queda por defecto en false
        int[] anteriores = new int[tope];
        DC ptoOrigen=null;
        if(origen instanceof DC)
            ptoOrigen=(DC)origen;
        for(int i=0;i<anteriores.length;i++){
            anteriores[i]=-1;
        }
        for(int i=0;i<distancia.length;distancia[i++]=Integer.MAX_VALUE);
        int posOrigen = obtenerNomInt(origen);
        distancia[posOrigen]=0;
        visitados[posOrigen]=true;
        for (int i =0;i<tope;i++){
            if(matAdy[posOrigen][i].isExiste()){
                distancia[i]= matAdy[posOrigen][i].getPeso();
                anteriores[i]=posOrigen;                
            }
        }
        for (int k =0;k<tope-2;k++){
            int candidato = -1, distCand = Integer.MAX_VALUE;
            for (int i =0;i<tope;i++){
                if(visitados[i]==false){
                    if(distancia[i]<distCand){
                        distCand=distancia[i];
                        candidato=i;
                    }
                }
            }
            if(candidato!=-1){
                visitados[candidato]=true;
                for (int i =0;i<tope;i++){
                    if(matAdy[candidato][i].isExiste()&&visitados[i]==false){
                        if(matAdy[candidato][i].getPeso()+distancia[candidato]<distancia[i])
                            distancia[i]=matAdy[candidato][i].getPeso()+distancia[candidato];
                            anteriores[i]=candidato;
                    }
                }
            }
        }
        int menor=Integer.MAX_VALUE;
        DC ret=null;
        String retorno="";
        int ctoPr=1;
        for(int i=0;i<distancia.length;i++){
            if(vertices[i] instanceof DC){
                DC aux =(DC) vertices[i];
                if(!aux.getMisCoord().equals(ptoOrigen.getMisCoord())&&aux.getCapacidadCPUenHoras()>=esfuerzo&&distancia[i]+esfuerzo*aux.getCostoCPUporHora()<menor){
                    if(!aux.getEmpresa().equals(ptoOrigen.getEmpresa())){
                        ctoPr=aux.getCostoCPUporHora();                    
                    }
                    menor=distancia[i]+esfuerzo*ctoPr;
                    ret=aux;
                }
            }
        }
        if(ret!=null){
            ret.setCapacidadCPUenHoras(ret.getCapacidadCPUenHoras()-esfuerzo);
            retorno=ret.getNombre()+","+menor;
        }
        return retorno;
    }
   
    
    public int obtenerNomInt(Punto origen) {
        return elHash.nombreInterno(origen);
        
    }

    
    public void registrarTramo(Punto origen, Punto destino, int peso){
        int i=obtenerNomInt(origen);
        int f=obtenerNomInt(destino);
        this.getMatAdy()[i][f]=new ArcoPunto(peso);
        this.getMatAdy()[f][i]=new ArcoPunto(peso);
    }
    
    public void eliminarTramo(Punto origen, Punto destino){
        //ver si no hay que controlar algo antes de eliminar el tramo....
        int i=obtenerNomInt(origen);
        int f=obtenerNomInt(destino);
        this.getMatAdy()[i][f]=new ArcoPunto();
        this.getMatAdy()[f][i]=new ArcoPunto();
    }

    public boolean existePunto(Punto punto) {
        for(Punto p:vertices){
            if(p!=null && p.equals(punto)){
                return true;
            }
        }
        
        return false;
    }

    public Punto buscarPunto(Double coordX,Double coordY){
        for(Punto p:vertices){
            if(p!=null && p.getCoordX().equals(coordX)&&p.getCoordY().equals(coordY)){
                return p;
            }
        }
        
        return null;
    }
    //Pre: unP existe
    public void insertarPunto(Punto unP,TipoPunto t) {
        if(cantV<=tope){
            vertices[cantV]=unP;
            elHash.agregar(unP, cantV);
            unP.setTipo(t);
            cantV++;
        }
    }
    
    public void eliminarPunto(Punto unP) {
        int pos = obtenerNomInt(unP);
        if(pos!=-1){
            vertices[pos]=null;
            cantV--;   
        }
    }
    
    public boolean existeTramo(Punto i, Punto f){
        if(f!=null)
            return matAdy[obtenerNomInt(i)][obtenerNomInt(f)].isExiste();
        else return false;
    }

    private String obtenerOrigen(Punto p) {
        if(p!=null){
            if(p instanceof Ciudad){
                Ciudad c=(Ciudad)p;
                return c.getNombre();
            }else{
                DC dc=(DC)p;
                return dc.getNombre();
            }
        }
        return null;
    }
// </editor-fold>
     
    
    

}
