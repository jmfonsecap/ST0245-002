
import java.util.LinkedList;
import java.util.Queue;
public class Arbol {
    static int preIndex = 0; 

    /**
     * Se encarga de decir cuales estudiantes son los estudiantes que cumplen con la condicion del nodo del arbol
     * para asi mandarlos al lado derecho de ese nodo.
     * @param matrix matriz con todos los estudiantes y sus datos.
     * @param gini contiene la posicion de la varibale y la condicion para asi determinar si el estudiante cumple o no
     * @param estudiantes2 Es una cola de posiciones para los estudiantes que ya fueron separados previamente o fueron
     * enviados por el bosque
     * @return retorna una nueva cola de estudiantes que nos dice cuales estan a cierto lado de el nodo
     */
    public Queue<Integer> separarMatrizDerecha(String[][] matrix, Gini gini, Queue<Integer> estudiantes2)
    {
        Queue<Integer> estudiantes= new LinkedList<Integer>();
        Queue<Integer> q = new LinkedList<Integer>(estudiantes2);
        int posVariable = gini.getPosVariable();
        String valor = gini.getCondicion();
        if (Gini.isNumeric(valor)&&!valor.isEmpty())
        {
            Double valor2= Double.parseDouble(valor);
            int i =q.poll();
            while (!q.isEmpty())
            {
                
                
                
                 if(!matrix[i][posVariable].isEmpty()&&Double.parseDouble(matrix[i][posVariable])>= valor2)
                {
                    estudiantes.offer(i);
                }
                i= q.poll();
            }
        }
        else{

            while (!q.isEmpty())
            {
                int i =q.poll();

                if(matrix[i][posVariable].equals(valor) )
                {
                    estudiantes.offer(i);
                }
            }
        }
        return estudiantes;
        
    }
    /**
     * Hace el mismo trabajo que separarMatrizDerecha pero este es para el caso en el que no se cumple para así
     * mandarlos a la izquierda
     * @param matrix matriz con todos los estudiantes y sus datos.
     * @param gini contiene la posicion de la varibale y la condicion para asi determinar si el estudiante cumple o no
     * @param estudiantes2 Es una cola de posiciones para los estudiantes que ya fueron separados previamente o fueron
     * enviados por el bosque
     * @return retorna una nueva cola de estudiantes que nos dice cuales estan a cierto lado de el nodo
     */
    public Queue<Integer> separarMatrizIzquieda(String[][] matrix, Gini gini, Queue<Integer> estudiantes2)
    {
        Queue<Integer> estudiantes= new LinkedList<Integer>();
        Queue<Integer>q = new LinkedList<Integer>(estudiantes2);
        int posVariable = gini.getPosVariable();
        String valor = gini.getCondicion();
        if (Gini.isNumeric(valor))
        {
            Double valor2= Double.parseDouble(valor);
            while (!q.isEmpty())
            {
                int i =q.poll();
                if(!matrix[i][posVariable].isEmpty())
                {
                    if(Double.parseDouble(matrix[i][posVariable])< valor2)
                    {
                        estudiantes.offer(i);
                    }
                }
                
            }
        }
        else{
            while (!q.isEmpty())
            {
                int i =q.poll();

                if(!(matrix[i][posVariable].equals(valor)))
                {
                    estudiantes.offer(i);
                }
            }
        }
        return estudiantes;
        
    }

    /**
     * Metodo para crear un arbol de decision a partir de unos estudiantes que nos manden y una matriz de datos sobre 
     * estos estudiantes
     * @param matrix matriz con todos los estudiantes y sus datos.
     * @param estudiantes Es una cola de posiciones para los estudiantes que ya fueron separados previamente o fueron
     * enviados por el bosque
     * @param alturaI altura de el nodo de la izquierda
     * @param alturaD altura de el nodo de la derecha. La suma de los dos nos da la altura total del arbol
     * @return retorna el arbol de decision ya armado.
     */
    public Node crearArbol(String[][] matrix,Queue<Integer> estudiantes,int alturaI, int alturaD)
    {   
        //Condicon si ya no hay estudiantes en la cola
        if(estudiantes.isEmpty())
        {
            return null;
        }
        //crea un gini para determinar cual es la mejor condicon para dicho nodo.
        Gini determinante= Gini.calcularImpurezaM(matrix,estudiantes);
        System.out.println("posicion "+matrix[0][determinante.getPosVariable()]+" con condicion "+determinante.getCondicion());
        System.out.println(alturaD);
        System.out.println(alturaI);
        //Evita que una de las condiciones sea la ID de los estudiantes, esto evita que para un bosque, se manden
        //varios estudiantes malos y uno bueno y ese sea la condicion que define eso.
        if(matrix[0][determinante.getPosVariable()].equals("estu_consecutivo.1"))
        {
            return null;
        }
        //Retorna el  nodo actual si la impureza de ese nodo ya limpio todo o si la altura de ese arbol es 4
        if(determinante.getImpureza()==0.0||alturaD+alturaI>=4)
        {
            
            Node pepe = new Node( new Pairs<Integer,String>(determinante.getPosVariable(),determinante.getCondicion()));
            pepe.right= null;
            pepe.left = null;
            return pepe;
        } 
        
        Node nodo= new Node( new Pairs<Integer,String>(determinante.getPosVariable(),determinante.getCondicion()));
        
        Queue<Integer> estudiantesD= separarMatrizDerecha(matrix,determinante,estudiantes);

        nodo.right = crearArbol(matrix, estudiantesD,alturaI,alturaD+1);

        Queue<Integer> estudiantesI = separarMatrizIzquieda(matrix, determinante,estudiantes);
        nodo.left = crearArbol(matrix, estudiantesI,alturaI+1,alturaD);
        return nodo;
    }

    /**
     * Revisa el arbol para un estudiante y determinar si dicho estudiante pasa o no segun el arbol.
     * @param arbol el arbol de decision en el que se va a predecir si pasara las pruebas saber Pro por encima del
     * promedio o no.
     * @param estudiante estudiante que se le predecira si pasara por encima del promedio o no las pruebas Saber Pro
     * @return
     */
    public boolean revisarArbol(Node arbol,String[] estudiante)
    {
        final int[] stringsNo = {14,23,63};
        if(arbol==null)
        {
            return false;
        }
        
        else if(!isNumeric(estudiante[arbol.getValor().getElement0()])||Double.parseDouble(estudiante[arbol.getValor().getElement0()])>300||falsoInt(stringsNo,arbol.getValor().getElement0())||arbol.getValor().getElement1().isEmpty())
        {
            if(arbol.getValor().getElement1().equals(estudiante[arbol.getValor().getElement0()]))
            {
                if(arbol.right!=null)
                {
                    if(arbol.right.right==null&&arbol.right.left==null)
                    {
                        return true;
                    }
                    else{
                        return revisarArbol(arbol.right, estudiante);
                    }
                    
                }
                else
                {
                    return true;
                }
               

            }
            else
            {
                if(arbol.left!=null)
                {
                    if(arbol.left.right==null&&arbol.left.left==null)
                    {
                        return false;
                    }
                    else{
                        return revisarArbol(arbol.left, estudiante);
                    }
                    
                }
                else 
                {
                    return false;
                }
            }
        }
        else
        {   
            
            if(Double.parseDouble(arbol.getValor().getElement1())<=Double.parseDouble(estudiante[arbol.getValor().getElement0()]))
            {
                
                if(arbol.right!=null)
                {
                    if(arbol.right.right==null&&arbol.right.left==null)
                    {
                        return true;
                    }
                    else{
                        return revisarArbol(arbol.right, estudiante);
                    }
                    
                }
                else
                {
                    return true;
                }
               

            }
            else
            {
                if(arbol.left!=null)
                {
                    if(arbol.left.right==null&&arbol.left.left==null)
                    {
                        return false;
                    }
                    else{
                        return revisarArbol(arbol.left, estudiante);
                    }
                    
                }
                else 
                {
                    return false;
                }
            }
        }
    }
    /**
     * Revisa si un string es númerico o no
     * @param strNum string que se evaluara para saber si es un número o no.
     * @return un boolean mostrando si la condicion se cumple o no.
     */
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        else{
            try {
                Double.parseDouble(strNum);
            } catch (NumberFormatException nfe) {
                return false;
            }
            return true;
        }
        
    }

    /**
     * Determina si en un conjunto que se pasa de posiciones, la posicion enviada es un conjunto númerico mas no
     * cuantitativo
     * @param prueba conjunto de posiciones que se sabe que son númericas mas no cuantitativas
     * @param posicion posición que se quiere ver si cumple con las condiciones o si es númerica cuantitativa.
     * @return
     */
    public static boolean falsoInt(int[] prueba, int posicion)
    {
        for(int i =0;i<prueba.length;i++){
            if(i==posicion)
                return true;
        }
        return false;
    } 
}
