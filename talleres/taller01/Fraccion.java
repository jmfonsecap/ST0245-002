
 /**
 * La clase Fraccion tiene la intención de representar una fraccion y sacarle su mcd, además de simplificarla.
 * 
 * @author Jose Manuel Fonseca Palacio
 * @version 1
 */
public class Fraccion {
    private int num;
    private int den;

    /**
     * Se inicializan los atributos de clase
     */
    public Fraccion(int num, int den)
    {
        this.num = num;
        this.den = den;
    }

    /**
     * Método para obtener la variable global num.
     *
     * @return el numerador.
     */
    public int num()
    {
        return num;
    }

    /**
     * Método para obtener la variable global den.
     *
     * @return el denominador.
     */
    public int den()
    {
        return den;
    }

    /**
     * Método para obtener la variable global mcd.
     *
     * @return el maximo común denominador.
     */
    public int mcd(){
        int u=Math.abs(num);
        int v=Math.abs(den);
        if(v==0)
             return u;
        
        int r;
        while(v!=0){
             r=u%v;
             u=v;
             v=r;
        }
        return u;
     }

     /**
     * Método para obtener la variable global mcd.
     *
     * @return el maximo común denominador.
     */
    public Fraccion simplificar(){
        int dividir=this.mcd();
        num/=dividir;
        den/=dividir;

        return this;
     }
}