package alg2obligatorio;

public class Retorno {

    public enum Resultado {OK, ERROR_1, ERROR_2, ERROR_3,     
         ERROR_4, ERROR_5, NO_IMPLEMENTADA};
 
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

    /*Para las operaciones en las que se debe retornar un tipo complejo (varios valores, o una colección de
    valores), se define el siguiente formato de manera de serializar el valor y encapsularlo en un único String.
     Si el valor a retornar es una colección de datos, se separarán cada ítem de la colección por un
    carácter “|”.
     Si el valor a retornar es un tipo complejo y tiene más de un atributo (por ejemplo la CI y nombre), se
    separarán ambos valores por un carácter “;”*/
    @Override
    public String toString() {
        
        return valorEntero + " " + valorString + ", resultado=" + resultado ;
    }
    
}
