package alg2obligatorio;

public class Retorno {

    public enum Resultado {OK, ERROR_1, ERROR_2, ERROR_3, ERROR_4, ERROR_5, NO_IMPLEMENTADA};
 
    public int valorEntero;

    public String valorString;
    
    public Resultado resultado;
    
    public Retorno() {
        this.resultado = Resultado.NO_IMPLEMENTADA;
    }
	
    public Retorno(Resultado resultado) {
        this.resultado = resultado;
    }
	
    public Retorno(Resultado resultado, String valorstr, int valorEnt) {
            this.resultado = resultado;
            this.valorEntero = valorEnt;
            this.valorString = valorstr;
    }

    /*Para las operaciones en las que se debe retornar un tipo complejo (varios valores, o una colecciÃ³n de
    valores), se define el siguiente formato de manera de serializar el valor y encapsularlo en un Ãºnico String.
    ï‚· Si el valor a retornar es una colecciÃ³n de datos, se separarÃ¡n cada Ã­tem de la colecciÃ³n por un
    carÃ¡cter â€œ|â€�.
    ï‚· Si el valor a retornar es un tipo complejo y tiene mÃ¡s de un atributo (por ejemplo la CI y nombre), se
    separarÃ¡n ambos valores por un carÃ¡cter â€œ;â€�*/
    @Override
    public String toString() {
        
        return valorEntero + " " + valorString + ", resultado=" + resultado ;
    }
    
}
