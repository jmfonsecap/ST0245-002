/**
*La clase taller dos tiene como objetivo dar solución
*a 3 problemas recursivos
*
*@autor Mauricio Toro, Camilo Paez(Plantilla), Jose Manuel Fonseca y Santiago Puerta.
*@version 1
*/

public class Taller2 {
	
	/**
	* @param p entrada 1 entero positivo, mayor que q
	* @param q entrada 2 entero positivo, menor que p
	*
	* El método gcd tiene como objetivo ecnontrar el
	* máximo común divisor de dos números, por medio del
	* algoritmo de euclides
	* @see <a href="https://www.youtube.com/watch?v=Q9HjeFD62Uk"> Explicación </a>
	* @see <a href="https://visualgo.net/en/recursion"> Funcionamiento </a>
	*
	* @return el máximo común divisor
	*/
	public static int gcd(int p, int q){
		if (q >p)
		{
			int x = q;
			q = p;
			p= x;
		}
        if (q==0)
        {
            return p;
		}
		else
		{
			return gcd(q,p%q);
		}
		
	}

	/**
	* @param nums entrada 2 arreglo de enteros positivos, sobre el cual vamos a interar 
	* @param target entrada 3 entero positivo, determina el valor de referencia 
	* El método SumaGrupo tiene como objetivo darnos a conocer si hay 
	* algun subconjunto el cual su suma = target.
	* 
	*
	* @return verdadero si hay un subconjunto el cual su suma = target
	*/
	public static boolean SumaGrupo(int[] nums, int target) {
		return SumaGrupo(0, nums, target);
	}
		

	
	/**
	* @param start entrada 1 entero positivo, determina un índice dentro del proceso
	* @param nums entrada 2 arreglo de enteros positivos, sobre el cual vamos a interar 
	* @param target entrada 3 entero positivo, determina el valor de referencia 
	* El método SumaGrupo tiene como objetivo darnos a conocer si hay 
	* algun subconjunto el cual su suma = target.
	* 
	* Este método SumaGrupo es "private" de modo que solo se puede llamar desde el interior de la clase pues
	* el método que lo representa es el SumaGrupo público.
	* Para más detalles sobre modificadores de acceso:
	* @see <a href="http://ayudasprogramacionweb.blogspot.com/2013/02/modificadores-acceso-public-protected-private-java.html"> modificadores </a>
	*
	*
	* @return verdadero si hay un subconjunto el cual su suma = target
	*/
	private static boolean SumaGrupo(int start, int[] nums, int target) {
		if (start >= nums.length) {
			if (target == 0)
			return true; // target - a - b - c = 0
			else
			{
				return false;
			}
				
		}
    	else{
        boolean universo1 = SumaGrupo(start + 1,nums,target - nums[start]);
        if (universo1)
			return true;
		else
			{
			boolean universo2 = SumaGrupo(start + 1 ,nums,target);
                if (universo2 == true)
                     return true;
                else
                    return false;
			}
    	}	
	
	}	
}