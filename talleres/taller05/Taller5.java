import java.util.Arrays;

/**
 * La clase Taller5 tiene como funcion dar las respuestas del taller 5
 * 
 * @author Jose Manuel Fonseca Palacio, Santiago Puerta Flores
 * @version 1
 */
public class Taller5 {
    
    public static void insertionSort(int[] array)
    {
        for(int i =0;i<array.length;i++)
            for(int j=i;j>0;j--)
            {
                if(array[j]<array[j-1])
                {
                    int aux= array[j];
                    array[j]=array[j-1];
                    array[j-1]=aux;
                }
                else{ break;}
            }    
    }

    public static int suma(int[] array)
    {
        int suma =0;
        for(int i=0;i<array.length;i++)
        {
            suma+= array[i];
        }
        return suma;
    }

    public static void main(String[] args) {
        int[] array= {20,5,3,100,12,78,1,9,0};
        int[] array2={0,1,2,3,4,5,6,7,8,9,10};

        insertionSort(array);
        int suma= suma(array2);
        System.out.println(suma);
        System.out.println(Arrays.toString(array));

    }
}