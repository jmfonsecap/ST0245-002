/**
 *
 * La clase Solicitud tiene como crear el objeto solicitud, que tenga el nombre de los compradores, 
 * numero de neveras y marcaDeseada.
 
 * @author Jose Manuel Fonseca, Santiago Puerta
 * @version 1
 */
public class Solicitud {
    private String nombreTienda;
    private int numeroNeveras;
    private String marcaDeseada;
    public int getNumeroNeveras()   {return numeroNeveras;}
    public String getNombreTienda() {return nombreTienda; }
    public String getMarcaDeseada() {return marcaDeseada; }
    public Solicitud(String x,int c, String m) {nombreTienda= x; numeroNeveras = c; marcaDeseada = m;}
}
