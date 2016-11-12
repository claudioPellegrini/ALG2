package alg2obligatorio;

import alg2obligatorio.Retorno.Resultado;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Sistema implements ISistema {
    private ABBEmpresa empresas;
    private int cantPuntos;
    private int contadorPuntos;
    private GrafoPuntos mapa;
    private ArrayList<Ciudad> ciudades;
    private ArrayList<DC> datacenters;
    public enum TipoPunto {CIUDAD,DATACENTER};
    private Pattern pat = Pattern.compile("^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,4})$");

    @Override
    public Retorno inicializarSistema(int cantPuntos) {
        if(cantPuntos<=0)
            return new Retorno(Resultado.ERROR_1);
        else{ 
            this.cantPuntos=cantPuntos;
            contadorPuntos=0;
            empresas= new ABBEmpresa();
            mapa = new GrafoPuntos(cantPuntos);
            ciudades=new ArrayList<>();
            datacenters= new ArrayList<>();
            return new Retorno(Resultado.OK);}
    }

    @Override
    public Retorno destruirSistema() {
        // TODO Auto-generated method stub
        this.cantPuntos=0;
        contadorPuntos=0;
        empresas=null;
        mapa=null;
        ciudades=null;
        datacenters=null;
        return new Retorno(Resultado.OK);
    }

    @Override
    public Retorno registrarEmpresa(String nombre, String direccion,
                    String pais, String email_contacto, String color) {
        Matcher mat = pat.matcher(email_contacto);
        if(!mat.matches()){
            return new Retorno(Resultado.ERROR_1);
        }
        if(empresas.existe(nombre)) return new Retorno(Resultado.ERROR_2);
        else{
            empresas.insertar(nombre, email_contacto, direccion, pais, color);
            return new Retorno(Resultado.OK);
        }    
    }

    @Override
    public Retorno registrarCiudad(String nombre, Double coordX, Double coordY) {
        if(contadorPuntos<cantPuntos){            
            Ciudad unaC = new Ciudad(coordX,coordY,nombre);
            if(mapa.existePunto(unaC)){
                return new Retorno(Resultado.ERROR_2);
            }else{                
                mapa.insertarPunto(unaC,TipoPunto.CIUDAD);                
                ciudades.add(unaC);
                contadorPuntos++;
                return new Retorno(Resultado.OK);
            }            
        }else{
            return new Retorno(Resultado.ERROR_1);
        }        
    }

    @Override
    public Retorno registrarDC(String nombre, Double coordX, Double coordY,
                    String empresa, int capacidadCPUenHoras, int costoCPUporHora) {
        if(contadorPuntos<cantPuntos){     
            if(capacidadCPUenHoras<=0) return new Retorno(Resultado.ERROR_2);
            NodoEmpresaABB emp = empresas.Buscar(empresas.getRaiz(), empresa);
            DC unDC = new DC(coordX,coordY,nombre, emp, capacidadCPUenHoras, capacidadCPUenHoras);
            if(mapa.existePunto(unDC)) return new Retorno(Resultado.ERROR_3);
            else{                
                mapa.insertarPunto(unDC,TipoPunto.DATACENTER);                                  
                if(emp==null){
                    return new Retorno(Resultado.ERROR_4);
                }else{
                    datacenters.add(unDC);
                    contadorPuntos++;
                    return new Retorno(Resultado.OK);
                }                
            }            
        }else{
            return new Retorno(Resultado.ERROR_1);
        }        
    }

    @Override
    public Retorno registrarTramo(Double coordXi, Double coordYi,
                    Double coordXf, Double coordYf, int peso) {
        if(peso<=0) return new Retorno(Resultado.ERROR_1);
        Punto aux = mapa.buscarPunto(coordXi,coordYi);
        Punto aux2 = mapa.buscarPunto(coordXf,coordYf);        
        if(aux==null||aux2==null)
            return new Retorno(Resultado.ERROR_2);
        if(mapa.existeTramo(aux, aux2))
            return new Retorno(Resultado.ERROR_3);
        mapa.registrarTramo(aux, aux2, peso);
        return new Retorno(Resultado.OK);
    }

    @Override
    public Retorno eliminarTramo(Double coordXi, Double coordYi,
                    Double coordXf, Double coordYf) {
        Punto aux = mapa.buscarPunto(coordXi,coordYi);
        Punto aux2 = mapa.buscarPunto(coordXf,coordYf);        
        if(aux==null||aux2==null)
            return new Retorno(Resultado.ERROR_1);
        if(!mapa.existeTramo(aux, aux2))
            return new Retorno(Resultado.ERROR_2);
        mapa.eliminarTramo(aux, aux2);
        return new Retorno(Resultado.OK);
    }

    @Override
    public Retorno eliminarPunto(Double coordX, Double coordY) {
        // TODO Auto-generated method stub
        //A LA CIUDAD O AL DATACENTER HAY QUE ELIMINARLA TAMBIEN
        Punto aux =mapa.buscarPunto(coordX, coordY);
        boolean encontre=true;
        if(aux==null) 
            return new Retorno(Resultado.ERROR_1);
        else{          
            String coordPto=coordX+","+coordY;
            int hasta=mapa.getVertices().length;
            for(int i =0; i<hasta;i++){
                if(mapa.existeTramo(aux, mapa.getVertices()[i]))
                    mapa.eliminarTramo(aux, mapa.getVertices()[i]);
            }
            int hastaC=ciudades.size();
            for(int j=0;j<hastaC&&encontre;j++){
                String c=ciudades.get(j).getMisCoord();                
                if(c.equals(coordPto)){
                    ciudades.remove(ciudades.get(j));
                    encontre=false;
                }
            }
            int hastaDc=datacenters.size();
            boolean encontre2=true;
            for(int h=0;h<hastaDc&&encontre2;h++){
                String dc=datacenters.get(h).getMisCoord();
                if(dc.equals(coordPto)){
                    datacenters.remove(datacenters.get(h));
                    encontre2=false;
                }
            }
            mapa.eliminarPunto(aux);
            return new Retorno(Resultado.OK);
        }
    }

    @Override
    public Retorno mapaEstado() {
        // TODO Auto-generated method stub
        String url = "//maps.googleapis.com/maps/api/staticmap?center=Montevideo,Uruguay&zoom=13&size=1200x600&maptype=roadmap";
        int j=1;
        for(int i=0;i<ciudades.size();i++){
            j=i+1;
            url+="&markers=color:yellow%7Clabel:"+j+"%7C"+ciudades.get(i).getMisCoord();   
        }
        for (DC datacenter : datacenters) {
            j++;
            url += "&markers=color:" + datacenter.getEmpresa().getColor() + "%7Clabel:" + j + "%7C" + datacenter.getMisCoord();
        }      
        url+="&sensor=false";        
        try {            
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " +"http://"+url);
        } catch (IOException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return new Retorno(Resultado.OK);
    }

    public GrafoPuntos getMapa() {
        return mapa;
    }

    //PRE: recibe un datacenter
    @Override
    public Retorno procesarInformacion(Double coordX, Double coordY,
                    int esfuerzoCPUrequeridoEnHoras) {
            // TODO Auto-generated method stub
        if(mapa.buscarPunto(coordX,coordY)==null)return new Retorno(Resultado.ERROR_1);        
        
        DC miDC = (DC)mapa.buscarPunto(coordX,coordY);
        String ret="";
        if(!miDC.isOcupado()&&miDC.getCapacidadCPUenHoras()<esfuerzoCPUrequeridoEnHoras)
            ret +=mapa.dijkstra(miDC,esfuerzoCPUrequeridoEnHoras);
        if(!miDC.isOcupado()&&miDC.getCapacidadCPUenHoras()>esfuerzoCPUrequeridoEnHoras)
            ret+=miDC.getNombre().toString()+","+miDC.costoProceso();
        if(ret.equals("")) return new Retorno(Resultado.ERROR_2);
        String[] retorno =ret.split(",");
        String nombre = retorno[0];
        int cto = Integer.parseInt(retorno[1]);
        return new Retorno(Resultado.OK, nombre, cto);
        
    }

    @Override
    public Retorno listadoRedMinima() {
        // TODO Auto-generated method stub
        String ret = mapa.prim();
        if(!ret.isEmpty())
            ret= ret.substring(0,ret.length()-1);
        return new Retorno(Resultado.OK,ret, mapa.getCostoMinimo());
    }

    @Override
    public Retorno listadoEmpresas() {
        // TODO Auto-generated method stub
        String ret=empresas.mostrar();
        return new Retorno(Resultado.OK, ret,0);
    }


}
