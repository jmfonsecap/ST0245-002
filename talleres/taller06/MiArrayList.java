/**
 * La clase MiArrayList tiene la intención de representar un objeto que simule el comportamiento
 * de la clase ya implementada "ArrayList"
 * es claro que no se puede utilizar dicha estructura ya utilizada dentro de este ejercicio.
 * Para más información de la clase ArrayList:
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html"> Ver documentacion ArrayList </a>
 *
 *
 * @author Jose Manuel Fonseca, Santiago Puerta
 * @version 1
 */

public class MiArrayList {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private int array[];

    /**
     * El metodo constructor se utiliza para incializar
     * variables a valores neutros como 0 o null.
     * El contructor no lleva parámetros en este caso.
     */
    public MiArrayList() {
	array = new int[DEFAULT_CAPACITY];
	size = 0;
    }


    /**
     * Tiene la intención de retornar la longitud del objeto
     * @return longitud del objeto
     *
     * El size esta influenciado por las funciones add y del
     */
    public int size() {
        return size;
    }

    /**
     * @param e el elemento a guardar
     * Agrega un elemento e a la última posición de la lista
     *
     */
    public void add(int e) {
	add( size , e);
    }


    /**
     * @param i es un íncide donde se encuentra el elemento posicionado
     * Retorna el elemento que se encuentra en la posición i de la lista.
     *
     */
    public int get(int i) {
	if (i < size && i > 0) {
	    return array[i];
	}else {
	    throw new IndexOutOfBoundsException("Index : " + i);
	}
    }


    /**
     * @param index es la posicion en la cual se va agregar el elemento
     * @param e el elemento a guardar
     * Agrega un elemento e en la posición index de la lista
     *
     */
    public void add(int index, int e) {
	if ( index < size && index >= 0) {

	    for (int i = 0; i <= size; i++) { 
		    if (i == size && size == array.length) {
		        extend();
		    }
                // ¿Esto funciona si se recorre el arreglo de izquierda a derecha?
		    if (i == index) {
                int swap = array[i];
                array[i]= e;
		        array[i + 1] = swap;
		        i++;
		        size++;
		    }
	    }
	}else if ( index==size ) {
	    array[index] = e;
	    size++;
	    if (size == array.length) {
		extend();
	    }
	}
    }

    private void extend() {
        int [] array2 =  new int[array.length + array.length ];
        for (int i = 0; i < size; i++) {
            array2[i] = array[i];
        }
        array = array2;
    }

 /**
    * @param index es la posicion en la cual se va eliminar el elemento
    *
    * ELimina el elemento  en la posición index de la lista
    *
    */
    public void del(int index){
        array[index]=0;
        for(int i = index; i<size;i++)
        {
            int swap =array[i];
            array[i] = array[i+1];
            array[i + 1] = swap;
		    
        }
    }
}