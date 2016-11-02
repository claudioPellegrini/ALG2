package alg2obligatorio;

import alg2obligatorio.Retorno.Resultado;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Sistema implements ISistema {
    public ABBEmpresa empresas;
    public int cantPuntos;
    public int contadorPuntos;
    public GrafoPuntos mapa;
    public ArrayList<Ciudad> ciudades;
    public ArrayList<DC> datacenters;
    private static enum TipoPunto {CIUDAD,DATACENTER};
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
        return new Retorno(Resultado.NO_IMPLEMENTADA);
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
            Punto unP = new Punto(coordX,coordY);
            if(mapa.existePunto(unP)){
                return new Retorno(Resultado.ERROR_2);
            }else{                
                mapa.insertarPunto(unP);                
                ciudades.add(new Ciudad(nombre,unP));
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
            Punto unP = new Punto(coordX,coordY);
            if(mapa.existePunto(unP)){
                return new Retorno(Resultado.ERROR_3);
            }else{                
                mapa.insertarPunto(unP);                   
                NodoEmpresaABB emp = empresas.Buscar(empresas.getRaiz(), empresa);
                if(emp==null){
                    return new Retorno(Resultado.ERROR_4);
                }else{
                    datacenters.add(new DC(nombre, emp, capacidadCPUenHoras, capacidadCPUenHoras, unP));
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
        Punto aux = new Punto(coordXi,coordYi);
        Punto aux2 = new Punto(coordXf,coordYf);        
        if(!mapa.existePunto(aux)||!mapa.existePunto(aux2)){
            return new Retorno(Resultado.ERROR_2);
        }
        if(mapa.getMatAdy()[mapa.obtenerNomInt(aux)][mapa.obtenerNomInt(aux2)].isExiste())
            return new Retorno(Resultado.ERROR_3);
        mapa.registrarTramo(aux, aux2, peso);
        return new Retorno(Resultado.OK);
    }

    @Override
    public Retorno eliminarTramo(Double coordXi, Double coordYi,
                    Double coordXf, Double coordYf) {
        Punto aux = new Punto(coordXi,coordYi);
        Punto aux2 = new Punto(coordXf,coordYf);        
        if(!mapa.existePunto(aux)||!mapa.existePunto(aux2)){
            return new Retorno(Resultado.ERROR_1);
        }
        if(!mapa.getMatAdy()[mapa.obtenerNomInt(aux)][mapa.obtenerNomInt(aux2)].isExiste())
            return new Retorno(Resultado.ERROR_2);
        mapa.eliminarTramo(aux, aux2);
        return new Retorno(Resultado.OK);
    }

    @Override
    public Retorno eliminarPunto(Double coordX, Double coordY) {
        // TODO Auto-generated method stub
        Punto aux =new Punto(coordX, coordY);
        if(!mapa.existePunto(aux)) 
            return new Retorno(Resultado.ERROR_1);
        else{           
            for(int i =0; i<mapa.getVertices().length;i++){
                if(mapa.getMatAdy()[mapa.obtenerNomInt(aux)][mapa.obtenerNomInt(mapa.getVertices()[i])].isExiste()){
                    mapa.eliminarTramo(aux, mapa.getVertices()[i]);
                }           
            }
            mapa.eliminarPunto(aux);
            return new Retorno(Resultado.OK);
        }
    }

    @Override
    public Retorno mapaEstado() {
        // TODO Auto-generated method stub
        return new Retorno(Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno procesarInformacion(Double coordX, Double coordY,
                    int esfuerzoCPUrequeridoEnHoras) {
            // TODO Auto-generated method stub
            return new Retorno(Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno listadoRedMinima() {
        // TODO Auto-generated method stub
        return new Retorno(Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno listadoEmpresas() {
        // TODO Auto-generated method stub
            return new Retorno(Resultado.NO_IMPLEMENTADA);
    }


}
