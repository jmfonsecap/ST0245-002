
import java.util.LinkedList;
import java.util.Queue;
public class Bosque {
    public Node[] crearBosque(String[][] matrix)
    {
        Node[] bosque = new Node[900];
        if (!(matrix.length-1<100))
        {
            
            
            double particiones = Math.round((matrix.length-1)*0.022222);
            for(int i =0;i< 900;i++)
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
            for(int i =0;i<900;i++)
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

