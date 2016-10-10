package alg2obligatorio;

import alg2obligatorio.Retorno.Resultado;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Sistema implements ISistema {
    public ABBEmpresa empresas;
    public int cantPuntos;
    private Pattern pat = Pattern.compile("^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,4})$");

    @Override
    public Retorno inicializarSistema(int cantPuntos) {
        if(cantPuntos<=0)
            return new Retorno(Resultado.ERROR_1);
        else{ 
            this.cantPuntos=cantPuntos;
            empresas= new ABBEmpresa();
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
        // TODO Auto-generated method stub
        Matcher mat = pat.matcher(email_contacto);
        if(mat.matches())
            return new Retorno(Resultado.OK);
        else
            return new Retorno(Resultado.ERROR_1);
    }

    @Override
    public Retorno registrarCiudad(String nombre, Double coordX, Double coordY) {
        // TODO Auto-generated method stub
        return new Retorno(Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno registrarDC(String nombre, Double coordX, Double coordY,
                    String empresa, int capacidadCPUenHoras, int costoCPUporHora) {
        // TODO Auto-generated method stub
        return new Retorno(Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno registrarTramo(Double coordXi, Double coordYi,
                    Double coordXf, Double coordYf, int peso) {
        // TODO Auto-generated method stub
        return new Retorno(Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno eliminarTramo(Double coordXi, Double coordYi,
                    Double coordXf, Double coordYf) {
        // TODO Auto-generated method stub
        return new Retorno(Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno eliminarPunto(Double coordX, Double coordY) {
        // TODO Auto-generated method stub
        return new Retorno(Resultado.NO_IMPLEMENTADA);
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
