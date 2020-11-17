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
    
    /**
     * Constructor Gini
     * @param posVariable Posicion en donde se encuentra la variable con la que se evalua dicho gini.
     * @param condicion La condicion con la que se evalua dicho gini.
     * @param impureza Impureza de el gini calculado
     */
    public Gini(int posVariable,String condicion, double impureza)
    {
        this.posVariable=posVariable;
        this.condicion=condicion;
        this.impureza=impureza;
        
    }
    /**
     * Getter de Impureza
     * @return impureza del gini
     */
    public double getImpureza() {
        return impureza;
    }
    /**
     * Getter de la condicion
     * @return condicion con la que se cumple dicho gini.
     */
    public String getCondicion() {
        return condicion;
    }
    /**
     * Getter de la poscion de la variable
     * @return columna que se evaluo para ese gini.
     */
    public int getPosVariable() {
        return posVariable;
    }
    /**
     * Metodo que se encarga de decir que estudiantes irian a la izquierda y a la derecha y basandose en eso saca
     * una impureza de gini para todas las posibles condiciones en la columna especificada. Busca retornar el menor gini
     * entre todas las impurezas posibles.
     * @param matrix Matriz que se ha evaluado durante todo el programa, en donde se encuentran los datos de los multiples
     * estudiantes.
     * @param posicion Posicion de la columna que se evaluara para izquierda y derecha.
     * @param valores  Un TreeSet que contiene todas las posibles condiciones que puede tener una columna.
     * @param estudiantes Una cola de estudiantes a evaluar, ya que como es arboles no se evaluan todos.
     * @return el menor gini posible.
     */
    public static Pairs<String,Double> IzquierdaDerecha(String[][] matrix, int posicion,TreeSet<String> valores,Queue<Integer> estudiantes)
    {
        //Conjunto de posiciones donde las condicones son númericas pero no cuantitativas.
        final int[] stringsNo = {14,23,63};
        Pairs<String,Double> impurezaPA = new Pairs<String,Double>("nada",(double)300);
        
        Queue<Integer> q = new LinkedList<Integer>(estudiantes);
        //Evalua == si son condiciones cualitativas
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
        //Evalua <= si son condiciones cuantitativas.
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
    /**
     * Busca la menor impureza entre todas las posibles columnas y condiciones.
     * @param matrix matriz con todos los estudiantes y sus datos
     * @param estudiantes datos que se le pasa por parte de el bosque o por la division de nodos para solo evaluar
     * los que son pertinentes y no todos.
     * @return el menor gini  entre todas las columnas y condiciones.
     */
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
    /**
     * Encuentra el conjunto de condiciones para cada columna y los agrupa.
     * @param matrix matriz con todos los estudiantes y sus datos.
     * @param estudiantes datos que se le pasa por parte de el bosque o por la division de nodos para solo evaluar
     * los que son pertinentes y no todos.
     * @return un ArrayList que contiene parejas de la posicion de columna en donde estan las condiciones.
     */
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
            if(prueba[i]==posicion)
                return true;
        }
        return false;
    }
    
}