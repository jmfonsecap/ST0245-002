public class Node {
   Pairs<Integer,String> valor;
   Node right;
   Node left;
   public Node(Pairs<Integer,String> valor)
   {
       this.valor=valor;
   }
   public Pairs<Integer, String> getValor() {
       return valor;
   }
   
}
