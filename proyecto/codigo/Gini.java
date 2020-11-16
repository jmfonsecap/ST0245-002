import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.Queue;
public class Gini {
    int posVariable;
    String condicion;
    double impureza;
    
    public Gini()
    {

    }
    public Gini(int posVariable,String condicion, double impureza)
    {
        this.posVariable=posVariable;
        this.condicion=condicion;
        this.impureza=impureza;
        
    }
    public double getImpureza() {
        return impureza;
    }
    public String getCondicion() {
        return condicion;
    }
    public int getPosVariable() {
        return posVariable;
    }
    public static Pairs<String,Double> IzquierdaDerecha(String[][] matrix, int posicion,TreeSet<String> valores,Queue<Integer> estudiantes)
    {
        final int[] stringsNo = {14,23,63};
        Pairs<String,Double> impurezaPA = new Pairs<String,Double>("nada",(double)300);
        
        Queue<Integer> q = new LinkedList<Integer>(estudiantes);
        if(!isNumeric(matrix[1][posicion])||Double.parseDouble(matrix[1][posicion])>300||falsoInt(stringsNo,posicion))
        {
            Hashtable<String,Double> buenos = new Hashtable<String,Double>();
            Hashtable<String,Double> malos = new Hashtable<String,Double>();
            for(String valor:valores)
            {
                
                buenos.put(valor,0.0);
                malos.put(valor,0.0);
            }
            double cont0=0;
            double cont1=0;
            int i = q.poll();
            while(!q.isEmpty())
            {
                
                
                if(Integer.parseInt(matrix[i][matrix[0].length-1])==1)
                {
                    buenos.put(matrix[i][posicion],buenos.get(matrix[i][posicion])+1.0);
                    
                    cont1=cont1+1.0;
                    
                }
                else{
                    malos.put(matrix[i][posicion],malos.get(matrix[i][posicion])+1.0);
                    cont0=cont0+1.0;
                }   
                i = q.poll();
            }
            q = new LinkedList<Integer>(estudiantes);
            
            
            for(String valor: valores)
            {
                
                double totalD= malos.get(valor)+buenos.get(valor); 
                double totalI= (double)(q.size())-totalD;
                
              
                double malosI = cont0-malos.get(valor);
                double buenosI = cont1-buenos.get(valor);
                double IGD = 1-((malos.get(valor)/totalD)*(malos.get(valor)/totalD)+(buenos.get(valor)/totalD)*(buenos.get(valor)/totalD));
                double IGI =1-((malosI/totalI)*(malosI/totalI)+(buenosI/totalI)*(buenosI/totalI));
                Pairs<String,Double> impurezaP= new Pairs<String,Double>(valor, (((IGI*totalI)+(IGD*totalD))/(totalD+totalI)));
                if(impurezaP.getElement1()<= impurezaPA.getElement1())
                {
                    impurezaPA=impurezaP;
                }
            }
        

        }
        else {
            
            Pair[] unsortedArray = new Pair[q.size()];
            if(!q.isEmpty())
            {
                
            }
            int j=1;
            while(!q.isEmpty())
            {
                int i = q.poll();
                
                unsortedArray[j-1]=new Pair(Double.parseDouble(matrix[i][posicion]), Integer.parseInt(matrix[i][matrix[0].length-1]));
                j++;

            }
            if(q.isEmpty())
            {
                
            }
            Arrays.sort(unsortedArray);
            
            for(String valor: valores)
            {   
                double valorP= Double.parseDouble(valor);
                
                double malosI = 0.0;
                double buenosI=0.0;
                double malosD = 0.0;
                double buenosD=0.0;
                for(int i =0;i<unsortedArray.length;i++)
                {  
                    
                    if(unsortedArray[i].getX()==valorP)
                    {
                        
                        if(unsortedArray[i].getY()==1)
                        {
                            buenosD=buenosD+1.0;
                        }
                        else
                        {
                            malosD=malosD+1.0;
                        }
                    }
                    else if (unsortedArray[i].getX()>valorP)
                    {
                        if(unsortedArray[i].getY()==1)
                        {
                            buenosD=buenosD+1.0;
                        }
                        else
                        {
                            malosD=malosD+1.0;
                        }
                    }
                    else
                    {
                        if(unsortedArray[i].getY()==1)
                        {
                            buenosI=buenosI+1.0;
                        }
                        else
                        {
                            malosI=malosI+1.0;
                        }
                    }

                }

                double totalD= malosD+buenosD; 
                
            
                double totalI= malosI+buenosI;
                
                double IGD = 1-((malosD/totalD)*(malosD/totalD)+(buenosD/totalD)*(buenosD/totalD));
                
                double IGI =1-((malosI/totalI)*(malosI/totalI)+(buenosI/totalI)*(buenosI/totalI));
                
                Pairs<String,Double> impurezaP= new Pairs<String,Double>(valor, (((IGI*totalI)+(IGD*totalD))/(totalD+totalI)));
                
                if(impurezaP.getElement1()< impurezaPA.getElement1())
                {
                    impurezaPA=impurezaP;
                }
            }            
        }
         

        return impurezaPA; 
    }
    public static Gini calcularImpurezaM(String[][] matrix, Queue<Integer> estudiantes)
    {
        Gini impurezaMenor= new Gini(0,"",300);
        
        ArrayList<Pairs<Integer,TreeSet<String>>> valores = conjuntoDeValores(matrix,estudiantes);
        
        for (Pairs<Integer,TreeSet<String>> valores1 : valores)
        {
            
            Pairs<String,Double> impurezaActual= IzquierdaDerecha(matrix, valores1.getElement0(), valores1.getElement1(),estudiantes);
            Gini impurezaPrueba = new Gini(valores1.getElement0(), impurezaActual.getElement0(), impurezaActual.getElement1());
            
            if(impurezaMenor.getImpureza()>impurezaPrueba.getImpureza())
            {
                impurezaMenor=impurezaPrueba;
            }
            
        }
        
        return impurezaMenor;
    }
    public static ArrayList<Pairs<Integer,TreeSet<String>>> conjuntoDeValores(String[][] matrix,Queue<Integer> estudiantes)
    {
        ArrayList<Pairs<Integer,TreeSet<String>>> valores = new ArrayList<Pairs<Integer,TreeSet<String>>>();
        Queue<Integer> q = new LinkedList<Integer>(estudiantes);
        for(int j=0;j<matrix[0].length-1;j++)
        {
            
            TreeSet<String> valoresTemp= new TreeSet<String>();
            while(!q.isEmpty())
            {
                int i = q.poll();        
                valoresTemp.add(matrix[i][j]);
                
            }
            q = new LinkedList<Integer>(estudiantes);
            valores.add(new Pairs<Integer,TreeSet<String>>(j,valoresTemp));
        }
        
        return valores;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        else{
            try {
                double d = Double.parseDouble(strNum);
            } catch (NumberFormatException nfe) {
                return false;
            }
            return true;
        }
        
    }
    public static boolean falsoInt(int[] prueba, int posicion)
    {
        for(int i =0;i<prueba.length;i++){
            if(prueba[i]==posicion)
                return true;
        }
        return false;
    }
    
}