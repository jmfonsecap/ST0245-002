/**
 * La clase CodingBatRecursion1 tiene como proposito mostrar los ejercicios realizados en Codingbat de 
 * Recursión-1
 * 
 * @author Jose Manuel Fonseca Palacio, Santiago Puerta Flores
 * @version 1
 */
public class CodingBatRecursion1 {

    /**
     * Realiza la suma de la serie fibonacci hasta el valor que se le indique.
     * @param n Valor indicado para la serie vibonacci
     * @return el valor de la serie fibonacci hasta el que se le indica.
     */
    public int fibonacci(int n) {
        if(n==0)
        {
          return 0;
        }
        if(n==1)
        {
          return 1;
        }
        return fibonacci(n-1)+fibonacci(n-2);
        
    }

    /**
     * Cuenta el número de veces que aparece el 11 en el arreglo.
     * @param nums Arreglo donde se busca el 11.
     * @param index Posición que se mira en el arreglo.
     * @return número de veces que aparece el 11
     */
    public int array11(int[] nums, int index) {
        if (index>=nums.length)
        {
          return 0;
        }
        if(nums[index]==11)
        {
          return 1+ array11(nums,index+1);
        }
        return 0+ array11(nums,index+1);
        
    }

    /**
     * Cuenta cuantas veces aparece un substring
     * @param str String grande del cual se va a contar cuantas veces contiene cierto substring.
     * @param sub Substring que se va a ver cuantas veces esta contenido.
     * @return número de veces que esta el substring en el string.
     */
    public int strCount(String str, String sub) {
        if(str.length()<sub.length())
        {
            return 0;
        }
        if(str.substring(0,sub.length()).equals(sub))
        {
            return 1+strCount(str.substring(sub.length()),sub);
        }
        return 0+strCount(str.substring(1),sub);
    }  

    /**
     * Mira si en el arreglo existe el número 6.
     * @param nums Arreglo en el que se buscara el 6.
     * @param index Posición del arreglo en la cual se encuentra.
     * @return Si se encontro o no el número 6 en el arreglo.
     */
    public boolean array6(int[] nums, int index) {
        if(index>=nums.length)
          return false;
        if(nums[index]==6)
        {
          return true;
        }
        return array6(nums,index+1);
    }

    /**
     * Se encarga de poner todas las x en un string al final, y el resto al inicio de forma ordenada.
     * @param str String que se va a reorganizar.
     * @return String reorganizado con las x al final.
     */
    public String endX(String str) {
        if(str.length()==0)
        {
          return "";
        }
        if(str.substring(0,1).equals("x"))
        {
          return endX(str.substring(1))+"x";
        }
        return str.substring(0,1)+endX(str.substring(1));
    }
    public int powerN(int base, int n) {
        if (n == 0){
         return 1;
        } else {
        return base*powerN(base,n-1);
        }
    }
    public int factorial(int n) {
        if (n==1){
            return 1;
        } else{
            return n* factorial (n-1);
        }
    }
    public int bunnyEars(int n) {
        if (n==0){
            return 0;
        } else {
            return 2 + bunnyEars(n-1);
         }   
    }

}
    
