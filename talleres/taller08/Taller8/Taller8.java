import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
/**
 *
 * La clase Taller8 tiene como objtivo dar solución a los puntos del taller 8
 *
 * @author Jose Manuel Fonseca, Santiago Puerta
 * @version 1
 */
class Taller8
{
    /**
	*
    * El método notacionPolacaInversa se encarga de resolver los calculos basicos como se hacia antes en otras 
	* calculadoras pasadas.
    * @param s operación
    * @return el resultado de la operación.
	*/
    public static int notacionPolacaInversa(final String s){
        final String simbolos = "+-*/";
        final Stack<Integer> unaPila = new Stack<Integer>();
        if (s.length() > 2)
          for (final String subcadena : s.split(" ")){
          if (simbolos.contains(subcadena))
             if (subcadena.equals("+")){
                unaPila.push(unaPila.pop()+unaPila.pop()); 
             }
             if (subcadena.equals("-")){
                unaPila.push(-1*unaPila.pop()+unaPila.pop()); 
             }
             if (subcadena.equals("*")){
                unaPila.push(unaPila.pop()*unaPila.pop()); 
             }
             if (subcadena.equals("/")){
                final int numeroDeArriba = unaPila.pop();
                final int numeroDeAbajo =  unaPila.pop();
                unaPila.push(numeroDeAbajo/numeroDeArriba); 
             }
          else
             unaPila.push(Integer.parseInt(subcadena)); //Cannot convert String into Integer
          }
        return unaPila.pop();
    }

    /**
     * El metodo asignarNeveras, lee una fila de solicitudes y luego se encarga de decidir si si hay disponibilidad
     * y las reparte a los que solicitaron, bajo la condición que las neveras estan en una pila y se tienen que guardar
     * como estaban previamente.
     * @param neveras Es una pila de neveras, como especificado por la condición.
     * @param solicitudes Es una fila de solicitudes, ya que es First come first serve.
     */
    public static void asignarNeveras(final Stack<Nevera> neveras, final Queue<Solicitud> solicitudes){
        while (solicitudes.peek()!=null) {
                final Solicitud solicitudActual = solicitudes.poll();
                final int cantidad= solicitudActual.getNumeroNeveras();
                final String marca= solicitudActual.getMarcaDeseada();
                final String tienda= solicitudActual.getNombreTienda();
                System.out.println("Se esta atendiendo a "+tienda);
                System.out.println(tienda+" solicita "+cantidad+" neveras de marca "+marca);
                final Stack<Nevera> neveras2 = new Stack<Nevera>();
                int counter=0;
                boolean vender=false;
                for(int i = 0;i<neveras.size();i++)
                {
                    if(neveras.get(i).getMarca().equals(marca))
                    {
                        counter++;
                    }
                    if(counter==cantidad)
                    {
                        vender=true;
                        break;
                    }
                }
                if(vender==true)
                {
                    System.out.println("Si hay disponibilidad,procediendo a sacar");
                    while(counter!=0)
                    {
                        if(neveras.peek().getMarca()==marca)
                        {
                            neveras.pop();
                            counter--;
                        }
                        else
                        {
                            neveras2.push(neveras.pop());
                        }
                    }
                    while(!neveras2.empty())
                    {
                        neveras.push(neveras2.pop());
                    }
                    System.out.println("Se le han entregado sus neveras, esperemos disfrute de su compra");

                    
                }
                else
                {
                    System.out.println("No se ha podido realizar su compra ya que no contamos con las neverasque busca");
                }
                
        }
        System.out.println("Hemos acabado por hoy");
    }

public static void main(final String[] args) {
    final Stack<Nevera> neveras= new Stack<Nevera>();
    final Queue<Solicitud> solicitudes= new LinkedList<Solicitud>();
    neveras.push(new Nevera(1,"haceb"));
    neveras.push(new Nevera(2,"haceb"));
    neveras.push(new Nevera(3,"haceb"));
    neveras.push(new Nevera(4,"haceb"));
    neveras.push(new Nevera(5,"haceb"));
    neveras.push(new Nevera(1,"exito"));
    neveras.push(new Nevera(6,"haceb"));
    neveras.push(new Nevera(7,"haceb"));
    neveras.push(new Nevera(8,"haceb"));
    neveras.push(new Nevera(9,"haceb"));
    neveras.push(new Nevera(2,"exito"));
    neveras.push(new Nevera(1,"apple"));
    neveras.push(new Nevera(2,"apple"));
    neveras.push(new Nevera(3,"apple"));
    neveras.push(new Nevera(4,"apple"));
    neveras.push(new Nevera(5,"apple"));
    neveras.push(new Nevera(6,"apple"));
    neveras.push(new Nevera(7,"apple"));
    neveras.push(new Nevera(8,"apple"));

    solicitudes.offer(new Solicitud("JuanLuisPollo",2,"exito"));
    solicitudes.offer(new Solicitud("PedroPollo",1,"exito"));
    solicitudes.offer(new Solicitud("RamonPollo",2,"haceb"));
    solicitudes.offer(new Solicitud("JuanLuisPollo",2,"apple"));
    solicitudes.offer(new Solicitud("AlbertoPollo",2,"exito"));
    solicitudes.offer(new Solicitud("RicardoPollo",4,"haceb"));
    asignarNeveras(neveras, solicitudes);
    for(int i=0;i<neveras.size();i++)
    {
        final Nevera actual= neveras.get(i);
        System.out.print("["+actual.getCodigo()+","+actual.getMarca()+"]");

    }

}
}

