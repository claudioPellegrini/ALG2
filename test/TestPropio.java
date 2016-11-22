

import alg2obligatorio.Retorno;
import alg2obligatorio.Sistema;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestPropio {
    Sistema s;
    
    public TestPropio() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        s = new Sistema();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    
    
   
//***************************** SISTEMA *******************************

//ERROR: Inicializo Sistema con 0 cantPuntos
    @Test
	public void testInicializarSistemaCero() {
            assertEquals(Retorno.Resultado.ERROR_1,s.inicializarSistema(0).resultado);
        }


//Inicializo sistema
    @Test
	public void testInicializarSistema() {
            assertEquals(Retorno.Resultado.OK,s.inicializarSistema(10).resultado);
        }

//Destruir sistema
    @Test
	public void testDestruirSistema() {
            assertEquals(Retorno.Resultado.OK,s.destruirSistema().resultado);
        }        
        
        
//***************************** EMPRESA *******************************        
        
//Registro empresa
    @Test
	public void testRegistroEmpresa() {
            s.inicializarSistema(10);
            assertEquals(Retorno.Resultado.OK,s.registrarEmpresa("Mateu", "18 de julio", "Uruguay", "mauge58@gmail.com", "green").resultado);
        }
        
        
//ERROR: Registro empresa mail invalido
    @Test
	public void testRegistroEmpresaMailMal() {
            s.inicializarSistema(10);
            assertEquals(Retorno.Resultado.ERROR_1,s.registrarEmpresa("Mateu", "18 de julio", "Uruguay", "mailIncorrecto.com", "green").resultado);
        }        
        
//ERROR: Registro empresa nombre duplicado
    @Test
	public void testRegistroEmpresaNombreDuplicado() {
            s.inicializarSistema(10);
            s.registrarEmpresa("Mateu", "18 de julio", "Uruguay", "mauge58@gmail.com", "green");
            assertEquals(Retorno.Resultado.ERROR_2,s.registrarEmpresa("Mateu", "18 de julio", "Uruguay", "mauge58@gmail.com", "green").resultado);
        }     
        

//***************************** CIUDAD *******************************
        
//Registro ciudad
    @Test
	public void testRegistroCiudad() {
            s.inicializarSistema(10);
            assertEquals(Retorno.Resultado.OK,s.registrarCiudad("Montevideo", -34.91, -56.17).resultado);
        }
        
        
        
//ERROR: registro ciudad con coordenadas existentes
    @Test
	public void testRegistroCiudadCoordExiste() {
            s.inicializarSistema(10);
            s.registrarCiudad("Montevideo", -34.91, -56.17);
            assertEquals(Retorno.Resultado.ERROR_2,s.registrarCiudad("Otra ciudad", -34.91, -56.17).resultado);
        }
        
//ERROR: registro ciudad, máximo puntos superados
    @Test
	public void testRegistroCiudadMaxPuntos() {
            s.inicializarSistema(1);
            s.registrarCiudad("Montevideo", -34.91, -56.17);
            assertEquals(Retorno.Resultado.ERROR_1,s.registrarCiudad("Canelones", -34.89, -56.190).resultado);
        }     
        
//***************************** DATA-CENTER *******************************        

//Registro DC
    @Test
	public void testRegistroDC() {
            s.inicializarSistema(10);
            registroEmpresas(s);
            assertEquals(Retorno.Resultado.OK,s.registrarDC("ORT", -34.900, -56.161, "Mateu", 500, 100).resultado);
        }
        

//ERROR: registro DC, máximo puntos superados
    @Test
	public void testRegistroDCMaxPuntos() {
            s.inicializarSistema(1);
            registroEmpresas(s);
            s.registrarDC("ORT", -34.900, -56.161, "Mateu", 500, 100);
            assertEquals(Retorno.Resultado.ERROR_1,s.registrarDC("DC Pellegrini", -34.902, -56.19, "Claudio", 400, 150).resultado);
        }
        
        
//ERROR: registro DC, capacidad <=0
    @Test
	public void testRegistroDCCapCero() {
            s.inicializarSistema(10);
            registroEmpresas(s);
            assertEquals(Retorno.Resultado.ERROR_2,s.registrarDC("DC Pellegrini", -34.902, -56.19, "Claudio", 0, 150).resultado);
        }
        
        
//ERROR: registro DC, coordenadas ya existen
    @Test
	public void testRegistroDCCoordExiste() {
            s.inicializarSistema(10);
            registroEmpresas(s);
            s.registrarDC("ORT", -34.900, -56.161, "Mateu", 500, 100);
            assertEquals(Retorno.Resultado.ERROR_3,s.registrarDC("DC Pellegrini", -34.900, -56.161, "Claudio", 400, 150).resultado);
        }
        
//ERROR: registro DC, empresa No existe
    @Test
	public void testRegistroDCEmpresaNoExiste() {
            s.inicializarSistema(10);
            assertEquals(Retorno.Resultado.ERROR_4,s.registrarDC("DC Pellegrini", -34.902, -56.19, "Claudio", 400, 150).resultado);
        }
        
        
//***************************** TRAMOS *******************************        

//Registro Tramo
    @Test
	public void testRegistroTramo() {
            s.inicializarSistema(10);
            registroEmpresas(s);
            registroCiudades(s);
            registroDC(s);
            assertEquals(Retorno.Resultado.OK,s.registrarTramo(-34.91,-56.17,-34.900,-56.161,90).resultado);
        }
        
        
//ERROR: Registro Tramo, peso <=0
    @Test
	public void testRegistroTramoPesoCero() {
            s.inicializarSistema(10);
            registroEmpresas(s);
            registroCiudades(s);
            registroDC(s);
            assertEquals(Retorno.Resultado.ERROR_1,s.registrarTramo(-34.91,-56.17,-34.900,-56.161,0).resultado);
        }
        
        
//ERROR: Registro Tramo, coordenadas no existen
    @Test
	public void testRegistroTramoCoordNoExiste() {
            s.inicializarSistema(10);
            registroEmpresas(s);
            registroCiudades(s);
            registroDC(s);
            assertEquals(Retorno.Resultado.ERROR_2,s.registrarTramo(-34.919,-56.179,-34.900,-56.161,90).resultado);
        }
        

//ERROR: Registro Tramo, coordenadas ya existen
    @Test
	public void testRegistroTramoYaExiste() {
            s.inicializarSistema(10);
            registroEmpresas(s);
            registroCiudades(s);
            registroDC(s);
            s.registrarTramo(-34.91,-56.17,-34.900,-56.161,90);
            assertEquals(Retorno.Resultado.ERROR_3,s.registrarTramo(-34.91,-56.17,-34.900,-56.161,90).resultado);
        }
        
        
//Elimino Tramo
    @Test
	public void testEliminarTramo() {
            s.inicializarSistema(10);
            registroEmpresas(s);
            registroCiudades(s);
            registroDC(s);
            s.registrarTramo(-34.91,-56.17,-34.900,-56.161,90);
            assertEquals(Retorno.Resultado.OK,s.eliminarTramo(-34.91,-56.17,-34.900,-56.161).resultado);
        }
        
        
//ERROR: Elimino Tramo, coordenadas no existen
    @Test
	public void testEliminarTramoCoordNoExiste() {
            s.inicializarSistema(10);
            registroEmpresas(s);
            registroCiudades(s);
            registroDC(s);
            s.registrarTramo(-34.91,-56.17,-34.900,-56.161,90);
            assertEquals(Retorno.Resultado.ERROR_1,s.eliminarTramo(-34.919,-56.179,-34.900,-56.161).resultado);
        }
        
        
//ERROR: Elimino Tramo, tramo no existe
    @Test
	public void testEliminarTramoNoExiste() {
            s.inicializarSistema(10);
            registroEmpresas(s);
            registroCiudades(s);
            registroDC(s);
            s.registrarTramo(-34.91,-56.17,-34.900,-56.161,90);
            assertEquals(Retorno.Resultado.ERROR_2,s.eliminarTramo(-34.91,-56.17,-34.902,-56.19).resultado);
        }
        
        
        
//***************************** PUNTO *******************************        
//Elimino Punto
    @Test
    public void testEliminarPunto() {
        s.inicializarSistema(10);
        registroEmpresas(s);
        registroCiudades(s);
        registroDC(s);
        assertEquals(Retorno.Resultado.OK,s.eliminarPunto(-34.91,-56.17).resultado);
    }
        
   
//ERROR: Elimino Punto, punto no existe
    @Test
    public void testEliminarPuntoNoExiste() {
        s.inicializarSistema(10);
        registroEmpresas(s);
        registroCiudades(s);
        registroDC(s);
        assertEquals(Retorno.Resultado.ERROR_1,s.eliminarPunto(-34.666,-56.666).resultado);
    }
        

    
//***************************** MAPA *******************************        
//Muestro mapa
    @Test
    public void testMostrarMapa() {
        s.inicializarSistema(10);
        registroEmpresas(s);
        registroCiudades(s);
        registroDC(s); 
        assertEquals(Retorno.Resultado.OK, s.mapaEstado().resultado);
    }

    
//***************************** PROCESAR INFORMACIÓN  *******************************        
//Proceso la información
    @Test
    public void testProcesarInfo() {
        s.inicializarSistema(10);
        registroEmpresas(s);
        registroCiudades(s);
        registroDC(s);  
        assertEquals(Retorno.Resultado.OK, s.procesarInformacion(-34.902, -56.19, 500).resultado);
    }
    
    
//ERROR: Coordenadas no existen
    @Test
    public void testProcesarInfoCoordNoExiste() {
        s.inicializarSistema(10);
        registroEmpresas(s);
        registroCiudades(s);
        registroDC(s);  
        assertEquals(Retorno.Resultado.ERROR_1, s.procesarInformacion(-34.666, -56.666, 600).resultado);
    }        
    
//ERROR: Capacidad superada, nadie puede
    @Test
    public void testProcesarInfoCapSuperadaTodos() {
        s.inicializarSistema(10);
        registroEmpresas(s);
        registroCiudades(s);
        registroDC(s);  
        assertEquals(Retorno.Resultado.ERROR_2, s.procesarInformacion(-34.902, -56.19, 600).resultado);
    }    
    
    
    
//***************************** RED MÍNIMA *******************************        
//Listado de Red Mínima
@Test
    public void testListadoRedMinima() {
        s.inicializarSistema(10);
        registroEmpresas(s);
        registroCiudades(s);
        registroDC(s);  
        assertEquals(Retorno.Resultado.OK, s.listadoRedMinima().resultado);
    }
    
    
    
//Métodos auxiliares para usar en test
        private void registroEmpresas(Sistema s){
            s.registrarEmpresa("Mateu", "18 de julio", "Uruguay", "mauge58@gmail.com", "green");
            s.registrarEmpresa("Mateu", "18 de julio", "Uruguay", "mauge58@g", "green");
            s.registrarEmpresa("Mateu", "18 de julio", "Uruguay", "mauge58@gmail.com", "green");
            s.registrarEmpresa("Claudio", "Lazaro Gadea", "Uruguay", "la@clau.com", "blue");
        }
        
        
        private void registroCiudades(Sistema s){
            s.registrarCiudad("Montevideo", -34.91, -56.17);//1
            s.registrarCiudad("Canelones", -34.89, -56.190);//2
            s.registrarCiudad("Rivera", -34.915, -56.183);//3
            s.registrarCiudad("Melo", -34.920, -56.16);//4
        }
        
        
        private void registroDC(Sistema s){
            System.out.println(s.registrarDC("ORT", -34.900, -56.161, "Mateu", 500, 100));//5
            System.out.println(s.registrarDC("DC Pellegrini", -34.902, -56.19, "Claudio", 400, 150));//6
            System.out.println(s.registrarDC("DC Bouza", -34.906, -56.15, "Mateu", 300, 100));//7
            System.out.println(s.registrarDC("DC Cremona", -34.908, -56.2, "Mateu", 200, 150));//8
        }
        
        
}//
