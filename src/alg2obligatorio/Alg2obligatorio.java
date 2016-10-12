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
        ABBEmpresa empresa = new ABBEmpresa();
        empresa.insertar("Claudio", "la@clau.com", "Lazaro Gadea", "Uruguay", "Rojo");
        empresa.insertar("Eugenia", "la@clau.com", "Lazaro Gadea", "Uruguay", "Rojo");
        empresa.insertar("Alicia", "la@clau.com", "Lazaro Gadea", "Uruguay", "Rojo");
        empresa.insertar("Benicio", "la@clau.com", "Lazaro Gadea", "Uruguay", "Rojo");

        empresa.mostrar();
    }
    
}
