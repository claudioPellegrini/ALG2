/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alg2obligatorio;

/**
 *
 * @author Claudio Pellegrini
 */
public class GrafoPuntos {
     private ArcoPunto [][] matAdy;
    //version para obli 
    private Punto [] vertices; 
    
    
    private int cantV;
    private int tope; // maxima cantidad de puntos que va a tener el grafo

    //version para obli
    public GrafoPuntos(int tope) {
        this.matAdy = new ArcoPunto[tope][tope];
        this.vertices = new Punto[tope];

        this.tope = tope;
        this.cantV=0;
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

    public ArcoPunto[][] getMatAdy() {
        return matAdy;
    }

    public void setMatAdy(ArcoPunto[][] matAdy) {
        this.matAdy = matAdy;
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

    boolean existePunto(Punto punto) {
        for(Punto p:vertices){
            if(p!=null && p.equals(punto)){
                return true;
            }
        }
        
        return false;
    }

    public void insertarPunto(Punto unP) {
        if(cantV<=tope){
            vertices[cantV]=unP;
            cantV++;
        }
    }
    
    
    
}
