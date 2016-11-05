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
public class Alg2obligatorio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Sistema s = new Sistema();
        System.out.println(s.inicializarSistema(10));
        System.out.println(s.inicializarSistema(0));
        System.out.println(s.registrarEmpresa("Mateu", "18 de julio", "Uruguay", "mauge58@gmail.com", "verde"));
        System.out.println(s.registrarEmpresa("Mateu", "18 de julio", "Uruguay", "mauge58@g", "verde"));
        System.out.println(s.registrarEmpresa("Mateu", "18 de julio", "Uruguay", "mauge58@gmail.com", "verde"));

        ABBEmpresa empresa = new ABBEmpresa();
        empresa.insertar("Claudio", "la@clau.com", "Lazaro Gadea", "Uruguay", "Rojo");
        empresa.insertar("Eugenia", "la@clau.com", "Lazaro Gadea", "Uruguay", "Rojo");
        empresa.insertar("Alicia", "la@clau.com", "Lazaro Gadea", "Uruguay", "Rojo");
        empresa.insertar("Benicio", "la@clau.com", "Lazaro Gadea", "Uruguay", "Rojo");
        System.out.println("Ya existe Alicia "+empresa.existe("Alicia"));
        System.out.println("No existe Gabriel "+empresa.existe("Gabriel"));

        empresa.mostrar();
        
        
        System.out.println(s.registrarCiudad("Montevideo", -34.91, -56.17));
        System.out.println(s.registrarCiudad("City", -34.91, -56.17));
        System.out.println(s.registrarCiudad("Canelones", -44.51, -66.37));
        System.out.println(s.registrarCiudad("Canelones", -44.51, -67.37));

        
        System.out.println(s.registrarDC("ORT", -34.66, -56.17, "Mateu", 500, 100));
        System.out.println(s.registrarTramo(-34.91, -56.17,-44.51, -66.37,100));
        System.out.println(s.registrarTramo(-34.66, -56.17,-44.51, -66.37,200));//tramo ort canelones
        System.out.println(s.eliminarTramo(-34.91, -56.17,-44.51, -67.37));
//        System.out.println(s.eliminarTramo(-34.91, -56.17,-44.51, -66.37));
        
        System.out.println(s.eliminarPunto(-34.66, -56.17));
        System.out.println(s.registrarTramo(-34.66, -56.17,-44.51, -66.37,200));
        System.out.println(s.registrarDC("ORT", -34.66, -56.17, "Mateu", 500, 100));
        System.out.println(s.registrarTramo(-34.66, -56.17,-44.51, -66.37,200));

        

    }
    
}
