
 /**
 * La clase Linea2D tiene la intención de representar una fecha y encontrar sus puntos medios.
 * 
 * @author Jose Manuel Fonseca Palacio
 * @version 1
 */
public class Linea2D {
    private Punto punto1;
    private Punto punto2;

    /**
     * Se inicializan los atributos de clase
     */
    public Linea2D(Punto punto1, Punto punto2)
    {
        this.punto1=punto1;
        this.punto2=punto2;
    }

    /**
     * Método para obtener la variable global punto1.
     *
     * @return punto de inicio de la linea.
     */
    public Punto punto1()
    {
        return punto1;
    }

    /**
     * Método para obtener la variable global punto2.
     *
     * @return punto de fin de la linea.
     */
    public Punto punto2()
    {
        return punto2;
    }
    
    /**
     * Metodo para imprimir los puntos medios de la linea formada.
     */
    public void PuntosMedios()
    {
        int mY = (int)punto2.y()-(int)punto1.y();
        int mX = (int)punto2.x()-(int)punto1.x();
        Fraccion m = new Fraccion(mY,mX);
        m.simplificar();
        mY = m.num();
        mX = m.den();

        Punto puntoMovil = new Punto(punto1.x(),punto1.y());
        System.out.println("("+puntoMovil.x()+","+puntoMovil.y()+")");
        while(punto2.x()!= puntoMovil.x()&&punto2.y()!= puntoMovil.y())
        {
            for(int i =0;i<mY;i++) 
            {
                puntoMovil.setY(puntoMovil.y()+1);
                System.out.println("("+puntoMovil.x()+","+puntoMovil.y()+")");
            }
            for(int i =0;i<mX;i++) 
            {
                puntoMovil.setX(puntoMovil.x()+1);
                System.out.println("("+puntoMovil.x()+","+puntoMovil.y()+")");
            }
        }
        
    }
    
}