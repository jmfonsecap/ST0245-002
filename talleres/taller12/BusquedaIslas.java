import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class BusquedaIslas {
    public static boolean BFS(int nodoInicial, int nodoObjetivo, GrafosMatriz mapa, boolean[] visitados)
    {
        visitados[nodoInicial]= true; 

        if(nodoInicial==nodoObjetivo)
        {
            return true;
        }
        int i = nodoInicial;
        Queue<Integer> q = new LinkedList<Integer>();
        while( q.size() != 0)
        
        {   
            for (int child :mapa.getSuccessors(i) )
            {
                if (visitados[child]==false)
                {
                    q.add(child);
                }
            }       
            i=q.poll();
            visitados[i]=true;
            if(nodoInicial==i)
            {
                return true;
            }
        }
        return false;        
    }
    public static boolean DFS(int nodoInicial, int nodoObjetivo, GrafosMatriz mapa, boolean[] visitados)
    {
        visitados[nodoInicial]= true; 

        if(nodoInicial==nodoObjetivo)
        {
            return true;
        }
        int i = nodoInicial;
        Stack<Integer> q = new Stack<Integer>();
        while( q.size() != 0)
        
        {   
            for (int child :mapa.getSuccessors(i) )
            {
                if (visitados[child]==false)
                {
                    q.push(child);
                }
            }       
            i=q.pop();
            visitados[i]=true;
            if(nodoInicial==i)
            {
                return true;
            }
        }
        return false;   
    }
}
