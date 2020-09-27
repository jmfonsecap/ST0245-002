/**
 *
 * La clase Nevera tiene como crear el objeto Nevera, que tenga el nombre de la marca y el codigo.
 
 * @author Jose Manuel Fonseca, Santiago Puerta
 * @version 1
 */
public class Nevera {
        private int codigo;
        private String marca;
        public int getCodigo()   {return codigo;}
        public String getMarca() {return marca; }
        public Nevera(int c, String m) {codigo = c; marca = m;}
}
