/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alg2obligatorio;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Euge
 */
public class Alg2obligatorio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
            // TODO code application logic here
            Sistema s = new Sistema();
            System.out.println(s.inicializarSistema(10));
            System.out.println(s.inicializarSistema(0));
            System.out.println(s.registrarEmpresa("Mateu", "18 de julio", "Uruguay", "mauge58@gmail.com", "green"));
            System.out.println(s.registrarEmpresa("Mateu", "18 de julio", "Uruguay", "mauge58@g", "green"));
            System.out.println(s.registrarEmpresa("Mateu", "18 de julio", "Uruguay", "mauge58@gmail.com", "green"));
            System.out.println(s.registrarEmpresa("Claudio", "Lazaro Gadea", "Uruguay", "la@clau.com", "blue"));
//            
//            ABBEmpresa empresa = new ABBEmpresa();
//            empresa.insertar("Claudio", "la@clau.com", "Lazaro Gadea", "Uruguay", "Rojo");
//            empresa.insertar("Eugenia", "la@clau.com", "Lazaro Gadea", "Uruguay", "Rojo");
//            empresa.insertar("Alicia", "la@clau.com", "Lazaro Gadea", "Uruguay", "Rojo");
//            empresa.insertar("Benicio", "la@clau.com", "Lazaro Gadea", "Uruguay", "Rojo");
//            System.out.println("Ya existe Alicia "+empresa.existe("Alicia"));
//            System.out.println("No existe Gabriel "+empresa.existe("Gabriel"));
//            
//            empresa.mostrar();
//            
//            
            System.out.println(s.registrarCiudad("Montevideo", -34.91, -56.17));
            System.out.println(s.registrarCiudad("City", -34.91, -56.17));//no la pudo eingresar
            System.out.println(s.registrarCiudad("Canelones", -34.91, -56.19));
            System.out.println(s.registrarCiudad("Minas", -34.909, -56.179));
            
            
            System.out.println(s.registrarDC("ORT", -34.907, -56.175, "Mateu", 500, 100));
            System.out.println(s.registrarDC("ORT/Centro", -34.902, -56.2, "Claudio", 500, 100));

            System.out.println(s.registrarTramo(-34.91, -56.17,-34.91, -56.19,100));
            System.out.println(s.registrarTramo(-34.91, -56.19,-34.907, -56.175,200));//tramo ort canelones
            System.out.println(s.registrarTramo(-34.91, -56.19,-34.909, -56.179,50));//tramo ort canelones

//            System.out.println(s.eliminarTramo(-34.91, -56.17,-44.51, -67.37));
////        System.out.println(s.eliminarTramo(-34.91, -56.17,-44.51, -66.37));
//            
//            System.out.println(s.eliminarPunto(-34.66, -56.17));
            System.out.println(s.registrarTramo(-34.66, -56.17,-44.51, -66.37,200));
//            System.out.println(s.registrarDC("ORT", -34.66, -56.17, "Mateu", 500, 100));
//            System.out.println(s.registrarTramo(-34.66, -56.17,-44.51, -66.37,200));
            System.out.println(s.mapaEstado());
//            
////            String url = new String();
////            url = "//maps.googleapis.com/maps/api/staticmap?center=Montevideo,Uruguay&zoom=13&size=1200x600&maptype=roadmap&markers=color:blue%7Clabel:1%7C-34.90,-56.16&markers=color:red%7Clabel:2%7C-34.91,-56.17&markers=color:green%7Clabel:3%7C-34.905,-56.19&sensor=false";
////            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " +"http://"+url);            
//       
//        
            System.out.println(s.listadoEmpresas());
    }
    
}
