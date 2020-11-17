public class Node {
   Pairs<Integer,String> valor;
   Node right;
   Node left;

   /**
    * Constructor de un nodo que contiene las posiciones de la columna y la condicion.
    * @param valor pareja que contiene posicion de la columna y la condicion.
    */
   public Node(Pairs<Integer,String> valor)
   {
       this.valor=valor;
   }
   /**
    * Getter que retorna el valor del nodo
    * @return pareja con posicion de la columna y la condicion.
    */
   public Pairs<Integer, String> getValor() {
       return valor;
   }
   
}
