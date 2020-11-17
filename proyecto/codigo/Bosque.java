
import java.util.LinkedList;
import java.util.Queue;
public class Bosque {

    /**
     * Metodo para crear un bosque, este se compone de varios arboles a los cuales se les pasa casi el 2% de los datos
     * aleatoriamente de la matriz que se le pide que evalue.
     * @param matrix matriz a partir de la cual se pide que se cree el bosque
     * @return un conjunto de arboles.
     */
    public Node[] crearBosque(String[][] matrix)
    {
        Node[] bosque = new Node[4];
        if (!(matrix.length-1<100))
        {
            
            
            double particiones = Math.round((matrix.length-1)*0.022222);
            for(int i =0;i< 4;i++)
            {
                
                Queue<Integer> estudiantes = new LinkedList<Integer>();
                for(int j=0;j<particiones;j++)
                {
                    int aleatorio = (int) (Math.random()*matrix.length-1)+1;
                    
                    if(!estudiantes.contains(aleatorio))
                    {
                        estudiantes.offer(aleatorio);
                    }
                    
                }
                Arbol arboles = new Arbol();
                bosque[i]= arboles.crearArbol(matrix, estudiantes,0,0);
                
            }
    
        }
        else 
        {
            
            double particiones = Math.round((matrix.length-1)/3);
            for(int i =0;i<4;i++)
            {
                Queue<Integer> estudiantes = new LinkedList<Integer>();
                for(int j=0;j<particiones;j++)
                {
                    int aleatorio = (int) (Math.random()*matrix.length-1)+1;
                    
                    if(!estudiantes.contains(aleatorio))
                    {
                        estudiantes.offer(aleatorio);
                    }
                }
                Arbol arboles = new Arbol();
                Node arbol = arboles.crearArbol(matrix, estudiantes,0,0);
                if(arbol!=null)
                {
                    bosque[i]= arbol;
                    
                }
                
                
            }
            
        }
        return bosque;
    }

    /**
     * Metodo que revisa todos los arboles en un bosque y estos "votan" para decidir si el estudiante en cuestion si
     * pasa o no por encima del promedio las pruebas Saber Pro
     * @param bosque nos pasa el bosque en el que se va a mirar al estudiante.
     * @param estudiante Estudiante que quiere saber si pasa por encima el promedio o no.
     * @return un boolean que nos dice si paso o no paso por encima del promedio.
     */
    public boolean revisarBosque(Node[] bosque, String[] estudiante)
    {
        int countTrue=0;
        int countFalse=0;

        for(Node arbol: bosque)
        {
            
            Arbol votando = new Arbol();
            if(votando.revisarArbol(arbol, estudiante))
            {
                countTrue++;
            }
            else
            {
                countFalse++;
            }
        }
        
        if(countFalse<countTrue)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}

