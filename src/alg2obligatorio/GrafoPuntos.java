
package alg2obligatorio;

import alg2obligatorio.Sistema.TipoPunto;



public class GrafoPuntos {
    private ArcoPunto [][] matAdy;
    private String tramosMinimos="";
    private int costoMinimo;
    private Punto [] vertices; 
    private int cantV;
    private int tope; // maxima cantidad de puntos que va a tener el grafo

// <editor-fold defaultstate="collapsed" desc="Constructor, Get y Set">
    public GrafoPuntos(int tope) {
        crearMatriz(tope);
        this.vertices = new Punto[tope];

        this.tope = tope;
        this.cantV=0;
    }

    public String getTramosMinimos() {
        return tramosMinimos.substring(0, tramosMinimos.length()-1);
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
    
    public void prim(){
            costoMinimo=0;
            boolean[] visitado = new boolean[tope];
            visitado[0]=true;
            //o lo hacemos con el visitado[(int)(Math.random()*7)] = true;
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
                            //si es candidato une visitado con no visitado
                            // si es mejor que mi anterior candidato lo sustituyo por mi mejor candidato
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
                    ret=ret+obtenerOrigen(vertices[imin])+";"+obtenerOrigen(vertices[jmin])+"|";
                    if(min!=Integer.MAX_VALUE)  costoMinimo=costoMinimo+min;
                    visitado[jmin]=true;
                    //agrego arista bidireccional a partir del valor minimo y las coordenadas
                    //aux[imin][jmin]=aux[jmin][imin] = new Arco(min);
                    //luego pongo como visitado a j
                    //reseteo al valor minimo (MAX_VALUE)
            }
            //para obligatorio comento linea siguiente
            //matAdy = aux;
            tramosMinimos=ret;
	}    
    
    public int dijkstra (Punto origen, Punto destino){
        //defino los vectores
        int[] distancia = new int[tope];
        boolean[] visitados = new boolean[tope];//queda por defecto en false
        int[] anteriores = new int[tope];		
        //Inicializo vectores
        //seteo al vector de anterior con -1 
        //seteo a visitados con false a todos
        //seteo a Distancia con infinito
        for(int i=0;i<anteriores.length;i++){
            anteriores[i]=-1;
        }
        //otra forma de asignar el -1 directamente en el for es asi:
//		for(int i =0;i<anteriores.length;anteriores[i++]=-1);
        for(int i=0;i<distancia.length;distancia[i++]=Integer.MAX_VALUE);
        //inicializaci�n -paso inicial
        int posOrigen = obtenerNomInt(origen);
        distancia[posOrigen]=0;
        visitados[posOrigen]=true;
        for (int i =0;i<tope;i++){
            if(matAdy[posOrigen][i].isExiste()){
                distancia[i]= matAdy[posOrigen][i].getPeso();
                anteriores[i]=posOrigen;
            }
        }
        //Encontrar no visitado con la menor distancia posible :candidato que es a quien voy a evaluar
        //como proximo paso
        //los vuelvo a recorrer a todos pero ahora hay q tener en cuenta la distancia anterior
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
            visitados[candidato]=true;
            for (int i =0;i<tope;i++){
                if(matAdy[candidato][i].isExiste()&&visitados[i]==false){
                    //(candidato,adyacente)+(origen,candidato)<(origen,adyacente)
                    if(matAdy[candidato][i].getPeso()+distancia[candidato]<distancia[i])
                        //actualizo distancia>anterior
                        distancia[i]=matAdy[candidato][i].getPeso()+distancia[candidato];
                        anteriores[i]=candidato;
                }
            }
        }       
        return distancia[obtenerNomInt(destino)];
    }
   
    
    public int obtenerNomInt(Punto origen) {
        // se cambia por HASH
        for(int i=0;i<tope;i++){
            if(vertices[i].equals(origen)){
                return i;
            }

        }
        return -1;
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


    //Pre: unP existe
    public void insertarPunto(Punto unP,TipoPunto t) {
        if(cantV<=tope){
            vertices[cantV]=unP;
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
