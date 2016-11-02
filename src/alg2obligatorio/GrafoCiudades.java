package alg2obligatorio;

public class GrafoCiudades {
    private ArcoCiudad [][] matAdy;
    //version para obli 
    private Ciudad [] vertices; //despues lo vamos a cambiar por Punto (para el obli)
    
    private int cantV;
    private int tope; // maxima cantidad de puntos que va a tener el grafo

    //version para obli
    public GrafoCiudades(int tope) {
        this.matAdy = new ArcoCiudad[tope][tope];
        this.vertices = new Ciudad[tope];

        this.tope = tope;
        this.cantV=0;
    }
        
	//version prueba para ejercicio
//	public Grafo(int tope) {
//		this.matAdy = new Arco[][]{
//			{new Arco(),new Arco(),new Arco(),new Arco(),new Arco(3),new Arco(2)},
//			{new Arco(),new Arco(),new Arco(1),new Arco(),new Arco(),new Arco(3)},
//			{new Arco(),new Arco(1),new Arco(),new Arco(8),new Arco(4),new Arco()},
//			{new Arco(),new Arco(),new Arco(8),new Arco(),new Arco(),new Arco()},
//			{new Arco(3),new Arco(),new Arco(4),new Arco(),new Arco(),new Arco()},
//			{new Arco(2),new Arco(3),new Arco(),new Arco(),new Arco(),new Arco()}
//		};
//		this.vertices = new String[]{"a","b","c","d","e","f"};
//			
//		this.tope = tope;
//		this.cantV=tope;
//	}
//	public void prim(){
//		boolean[] visitado = new boolean[tope];
//		visitado[0]=true;
//		//o lo hacemos con el visitado[(int)(Math.random()*7)] = true;
//		Arco[][] aux = new Arco[tope][tope];
//		for (int i = 0; i < aux.length; i++) 
//			for(int j=0;j<aux.length;j++)
//				aux[i][j] = new Arco();
//			
//		//Proceso
//		
//		//Inicializar valor minimo (MAX_VALUE), y coordinadas de arista candidata
//		//int min=Integer.Max_value; int imin = 0; int jmin=1;
//		for (int k = 0; k < cantV-1; k++) {
//			for (int i = 0; i < tope; i++) {
//				if(vertices[i]!=null && visitado[i]){
//					for(int j=i+1;j<tope;j++){
//						//si es candidato une visitado con no visitado
//						// si es mejor que mi anterior candidato lo sustituyo por mi mejor candidato
//						
//					}
//				}
//				
//			}
//			
//			//agrego arista bidireccional a partir del valor minimo y las coordenadas
//			//aux[imin][jmin]=aux[jmin][imin] = new Arco(min);
//			//luego pongo como visitado a j
//			//reseteo al valor minimo (MAX_VALUE)
//		}
//		matAdy = aux;
//	}
    public int dijkstra (Ciudad origen, Ciudad destino){
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
    private int obtenerNomInt(Ciudad origen) {
            // TODO Auto-generated method stub
            for(int i=0;i<tope;i++){
                    if(vertices[i].equals(origen)){
                            return i;
                    }

            }
            return -1;
    }

    public ArcoCiudad[][] getMatAdy() {
        return matAdy;
    }

    public void setMatAdy(ArcoCiudad[][] matAdy) {
        this.matAdy = matAdy;
    }

    public Punto[] getVertices() {
        return vertices;
    }

    public void setVertices(Ciudad[] vertices) {
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
    public void registrarTramo(Ciudad origen, Ciudad destino, int peso){
        int i=obtenerNomInt(origen);
        int f=obtenerNomInt(destino);
        this.getMatAdy()[i][f]=new ArcoCiudad(peso);
        this.getMatAdy()[f][i]=new ArcoCiudad(peso);
    }
    public void eliminarTramo(Ciudad origen, Ciudad destino){
        //ver si no hay que controlar algo antes de eliminar el tramo....
        int i=obtenerNomInt(origen);
        int f=obtenerNomInt(destino);
        this.getMatAdy()[i][f]=new ArcoCiudad();
        this.getMatAdy()[f][i]=new ArcoCiudad();
    }
	
}
