/**
 * La clase CodingBatRecursion2 tiene como proposito mostrar los ejercicios realizados en Codingbat de 
 * Recursión-2
 * 
 * @author Jose Manuel Fonseca Palacio, Santiago Puerta Flores
 * @version 1
 */
public class CodingBatRecursion2 {

    /**
     * Se encarga de ver si los números en el arreglo se pueden sumar para dar el target, con la condición de que
     * si existe un 6 entonces este debe ser parte de la suma.
     * @param start El número en el que empieza el arreglo a analizar.
     * @param nums El arreglo de enteros a analizar.
     * @param target La suma a la que se debe llegar.
     * @return Retorna si existen números sumados que den el target, con la condición que si hay un 6, 
     * este debe ser parte de la suma.
     */
    public boolean groupSum6(int start, int[] nums, int target) {
        if (start >= nums.length)
          return (target == 0);
        if (groupSum6(start+1, nums, target - nums[start])) 
            return true;
        if (nums[start] != 6 && groupSum6(start+1, nums, target)) 
            return true;
         
        return false;
    }

    /**
     * Se encarga de ver si los números en el arreglo se pueden sumar para dar el target, con la condición de que
     * si existe un multiplo de entonces este debe ser parte de la suma y el número que sigue despues de este
     * en el arreglo no debe ser incluido en la suma.
     * @param start La posición en la que inicia el arreglo.
     * @param nums El arreglo de números a sumar.
     * @param target El resultado que se busca optener
     * @return Si se pudo o no realizar la suma bajo las condiciones
     */
    public boolean groupSum5(int start, int[] nums, int target) {
        if (start >= nums.length)
            return (target == 0);
        if(nums[start]%5==0)
        {
            if (start<= nums.length-2 && nums[start+1]==1)
                return groupSum5(start+2,nums,target-nums[start]);
            return groupSum5(start+1,nums,target-nums[start]);
        }
        if(groupSum5(start+1, nums, target)||groupSum5(start+1,nums,target-nums[start]))
            return true;
        return false;
          
    }
    /**
     * Se encarga de ver si algunos de los números en el arreglo se suman para dar como resultado al  target,
     * con la condición de que si uno de los números se usa para sumar el siguiente número no podra ser usado.
     * @param start La posicón en la que se inicia el arreglo.
     * @param nums El arreglo de enteros a sumar.
     * @param target El número al que se quiere llegar con la suma.
     * @return Si fue posible o no llegar al target con las condiciones dadas.
     */
    public boolean groupNoAdj(int start, int[] nums, int target) {
        if(start>=nums.length)
          return(target==0);
        if(groupNoAdj(start+2,nums,target-nums[start])||groupNoAdj(start+1,nums,target))
          return true;
          
        return false;
    }

    /**
     * Se encarga de ver si se puede separa el arreglo en dos partes y que resulte que uno de los grupos formados
     * de un multiplo de 10 y el otro grupo de un número impar.
     * @param nums El arreglo de números a separar.
     * @return Si fue posible dividir el grupo bajo las condiciones dadas.
     */
    public boolean splitOdd10(int[] nums) {
 
        return splitOdd10Aux(0,nums,0,0);
    }
    
    /**
     * Función auxiliar a spltOdd10
     * @param index Indica donde va el contador del arreglo
     * @param nums arreglo de numeros.
     * @param sum1 Suma de enteros.
     * @param sum2 Suma de enteros.
     * @return Si fue posible dividir el grupo bajo las condiciones dadas.
     */
      public boolean splitOdd10Aux(int index, int[] nums, int sum1, int sum2)
      {
        if(index>=nums.length)
          return(sum1%10==0&& sum2%2!=0||sum2%10==0&&sum1%2!=0);
        
        return splitOdd10Aux(index+1,nums,sum1+nums[index],sum2)||splitOdd10Aux(index+1,nums,sum1,sum2+nums[index]);
    }

    
    /**
     * Se encarga de ver si se puede partir un arreglo de números en dos, tal que la suma de ambos subconjuntos
     * sea la misma en ambos lados.
     * @param nums el conjunto de números que se va a separar.
     * @return Si fue posible o no hacer tal división.
     */
    public boolean splitArray(int[] nums) {
  
        return splitArrayAux(0,nums,0,0);
    }

     /**
      * Función auciliar para splitArray
      * @param index número que indica la posición del arreglo.
      * @param nums El conjunto de números que se van a analizar.
      * @param sum1 La suma del primer subconjunto.
      * @param sum2 La suma del segundo subconjunto.
      * @return Si si se pudo dividir el conjunto en dos partes.
      */
    public boolean splitArrayAux(int index, int[] nums, int sum1, int sum2)
    {
        if(index>=nums.length)
          return(sum1==sum2);
          
        return splitArrayAux(index+1,nums,sum1+nums[index],sum2)||splitArrayAux(index+1,nums,sum1,sum2+nums[index]);
    }
      
        
      
      

    
}