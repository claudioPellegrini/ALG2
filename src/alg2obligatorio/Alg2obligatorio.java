
package alg2obligatorio;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Alg2obligatorio {

   
    public static void main(String[] args) throws IOException {
            Sistema s = new Sistema();
            System.out.println(s.inicializarSistema(10));
            System.out.println(s.inicializarSistema(0));
            System.out.println("Registro empresas*************");
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
            System.out.println("Registro Ciudades*************");
            System.out.println(s.registrarCiudad("Montevideo", -34.91, -56.17));//1
            //System.out.println(s.registrarCiudad("City", -34.91, -56.17));//no la pudo eingresar
            System.out.println(s.registrarCiudad("Canelones", -34.89, -56.190));//2
            System.out.println(s.registrarCiudad("Rivera", -34.915, -56.183));//3
            System.out.println(s.registrarCiudad("Melo", -34.920, -56.16));//4
            
            
            System.out.println("Registro DC*************");
            System.out.println(s.registrarDC("ORT", -34.900, -56.161, "Mateu", 500, 100));//5
            System.out.println(s.registrarDC("DC Pellegrini", -34.902, -56.19, "Claudio", 400, 150));//6
            System.out.println(s.registrarDC("DC Bouza", -34.906, -56.15, "Mateu", 300, 100));//7
            System.out.println(s.registrarDC("DC Cremona", -34.908, -56.2, "Mateu", 200, 150));//8

//            System.out.println(s.registrarTramo(-34.91, -56.17,-34.91, -56.19,100));
//            System.out.println(s.registrarTramo(-34.91, -56.19,-34.907, -56.175,200));//tramo ort canelones
//            System.out.println(s.registrarTramo(-34.91, -56.19,-34.909, -56.179,50));//tramo ort canelones
            System.out.println("Registro Tramos*************");
            System.out.println(s.registrarTramo(-34.91,-56.17,-34.900,-56.161,90));//1y5
            System.out.println(s.registrarTramo(-34.91,-56.17,-34.902,-56.19,10));//1y6
            System.out.println(s.registrarTramo(-34.91,-56.17,-34.908,-56.2,30));//1y8
            System.out.println(s.registrarTramo(-34.91,-56.17,-34.915,-56.183,10));//1y3
            System.out.println(s.registrarTramo(-34.91,-56.17,-34.920,-56.16,10));//1y4
            System.out.println(s.registrarTramo(-34.900,-56.161,-34.906,-56.15,10));//5y7
            System.out.println(s.registrarTramo(-34.900,-56.161,-34.89,-56.190,20));//5y2
            System.out.println(s.registrarTramo(-34.900,-56.161,-34.902,-56.19,40));//5y6
            System.out.println(s.registrarTramo(-34.900,-56.161,-34.920,-56.16,20));//5y4
            System.out.println(s.registrarTramo(-34.920,-56.16,-34.906,-56.15,40));//4y7
            System.out.println(s.registrarTramo(-34.920,-56.16,-34.915,-56.183,30));//4y3
            System.out.println(s.registrarTramo(-34.908,-56.2,-34.915,-56.183,10));//8y3
            System.out.println(s.registrarTramo(-34.908,-56.2,-34.902,-56.19,60));//8y6
            System.out.println(s.registrarTramo(-34.89,-56.190,-34.902,-56.19,140));//2y6
            
            
//            System.out.println(s.eliminarTramo(-34.91, -56.17,-44.51, -67.37));
////        System.out.println(s.eliminarTramo(-34.91, -56.17,-44.51, -66.37));
//            
//            System.out.println("Elimino punto "+s.eliminarPunto(-34.89, -56.190));
            //Si elimino Canelones, fijate que modifica la lista minima y el peso, o sea borra tramos
            
            
//            System.out.println(s.registrarTramo(-34.66, -56.17,-34.90, -56.18,200));
//            System.out.println(s.registrarDC("ORT", -34.66, -56.17, "Mateu", 500, 100));
//            System.out.println(s.registrarTramo(-34.66, -56.17,-44.51, -66.37,200));
            System.out.println(s.mapaEstado());
//                
//        
            System.out.println(s.listadoEmpresas());
            
            
            
            
            System.out.println(s.listadoRedMinima());
            System.out.println(s.procesarInformacion(-34.900, -56.161, 400));
    }
    
}
