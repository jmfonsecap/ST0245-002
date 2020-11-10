import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Arrays;

/**
 * Implementacion de un algoritmo para asignar vehiculos compartidos
 * Estructura de datos utilizada: Grafo con Matrices de Adyacencia
 * Complejidad: Peor Caso y Mejor Caso O(n*n)
 *
 * @author Mauricio Toro
 * @version 1
 */
public class Carpool
{
    /**
    * Metodo para leer un archivo con los duenos de vehiculos y la empresa
    * Complejidad: Mejor y peor caso es O(n*n), donde n es son los duenos de vehiculos y la empresa
    *
    * @param  numeroDePuntos  El numero de puntos es 1 de la empresa y n-1 de los duenos de vehiculos
    * @return un grafo completo con la distancia mas corta entre todos los vertices
    */
    public static GrafosMatriz leerArchivo(int numeroDePuntos, float p){
          final String nombreDelArchivo = "dataset-ejemplo-U="+numeroDePuntos+"-p=1.3.txt";
          GrafosMatriz grafo = new GrafosMatriz(numeroDePuntos);
          try {            
            BufferedReader br = new BufferedReader(new FileReader(nombreDelArchivo));
            String lineaActual = br.readLine();
            for (int i = 1; i <= 3; i++) // Descarta las primeras 3 lineas
                lineaActual = br.readLine();
            lineaActual = br.readLine(); 
            for (int i = 1; i <= numeroDePuntos; i++){ //Descarta los nombres y coordenadas de los vertices
                lineaActual = br.readLine();
            }          
            for (int i = 1; i <= 3; i++) // Descarta las siguientes 3 lineas
                lineaActual = br.readLine();             
            while (lineaActual != null){ // Mientras no llegue al fin del archivo. Lee la informacion de las aristas
                String [] cadenaParticionada = lineaActual.split(" ");
                grafo.addArc(Integer.parseInt(cadenaParticionada[0]), Integer.parseInt(cadenaParticionada[1]), Integer.parseInt(cadenaParticionada[2]));
                lineaActual = br.readLine();
            }
          }
          catch(IOException ioe) {
              System.out.println("Error leyendo el archivo de entrada: " + ioe.getMessage());
          }
          return grafo;
    }
    
    /**
    * Algoritmo para asignar vehiculos compartidos (No tiene en cuenta la restriccion que hay en el problema)
    * Lo que hace es agrupar los duenos de vehiculos en permutaciones de maximo 5 elementos
    * Complejidad: Mejor y Peor Caso O(n), donde n son los duenos de vehiculos y la empresa
    *
    * @param  grafo  Un grafo que puede estar implementado con matrices o con listas de adyacencia
    * @return una lista de listas con la permutacion para cada subconjunto de la particion de duenos de vehiculo
    */
    public static LinkedList<LinkedList<Integer>> asignarVehiculos(Grafo grafo, float p, Pair[] sortedArray){
        LinkedList<LinkedList<Integer>> permutacionParaCadaSubconjunto = new LinkedList<LinkedList<Integer>>();
        int dueno = 2; // Empieza en 2 porque 1 es la empresa
        int contador = 1;
        LinkedList<Integer> permutacion = new LinkedList<Integer>();
        for(int i=sortedArray.length-1;i>=0;i--)
        {
            if(sortedArray[i].getX()!=1)
            {   
                
                if(!contains2(permutacionParaCadaSubconjunto, sortedArray[i].getX()))
                {
                    permutacion = new LinkedList<Integer>();
                permutacion.add(sortedArray[i].getX());
                double p2 = p*sortedArray[i].getY();
                
                while(contador != 5 && dueno != grafo.size())
                {
                    
                    int weightMenor=200;
                for(int j =2;j<=sortedArray.length;j++)
                {
                    int actual= sortedArray[i].getX();
                    int weightActual=grafo.getWeight(actual, j);
                    if(actual!=j)
                    {
                        if(weightActual<=p2)
                        {
                            if(!permutacion.contains(j))
                            {
                                if(!contains2(permutacionParaCadaSubconjunto, j))
                                {
                                    if(weightActual<=weightMenor)
                                    {
                                        weightMenor=weightActual;
                                        
                                    }
                                }
                            }
                        }
                    }
                    
                }
                
                for(int j=2;j<=sortedArray.length;j++)
                {
                    
                    int weightActual=grafo.getWeight(sortedArray[i].getX(), j);
                    if(weightActual==weightMenor&&!permutacion.contains(j)&&!contains2(permutacionParaCadaSubconjunto, j))
                    {
                        
                        permutacion.add(j);
                        
                        p2= (grafo.getWeight(j, 1)*p)-weightMenor;
                        contador++;
                        break;
                    }
                }
                dueno++;
                
            }
            permutacionParaCadaSubconjunto.add(permutacion);
            contador=1; 
            dueno = 2; 
                }
                
              
            }
        }
        
          return permutacionParaCadaSubconjunto;
    }
    public static Pair[] distanciasAUno(Grafo grafo, int numeroDePuntos)
    {
        Pair[] unsortedArray = new Pair[numeroDePuntos-1];
        for(int i =2;i<=numeroDePuntos;i++)
        {
            unsortedArray[i-2]=new Pair(i, grafo.getWeight(1, i));
        }
        Arrays.sort(unsortedArray);
        
        return unsortedArray;
        
    } 
    /**
    * Metodo para escribir un archivo con la respuesta
    * Complejidad: Mejor y peor caso es O(n), donde n son los duenos de vehiculo y la empresa
    *
    * @param  permutacionParaCadaSubconjunto es una lista de listas con la permutacion para cada subconjunto de la particion de duenos de vehiculo
    */
    public static void guardarArchivo(LinkedList<LinkedList<Integer>> permutacionParaCadaSubconjunto,int numeroDePuntos, float p){
          final String nombreDelArchivo = "respuesta-ejemplo-U="+numeroDePuntos+"-p="+p+".txt";
          try {
             PrintWriter escritor = new PrintWriter(nombreDelArchivo, "UTF-8");
             for (LinkedList<Integer> lista: permutacionParaCadaSubconjunto){
                  for (Integer duenoDeVehiculo: lista)
                       escritor.print(duenoDeVehiculo + " ");
                  escritor.println();
             }             
             escritor.close();
          }
          catch(IOException ioe) {
              System.out.println("Error escribiendo el archivo de salida " + ioe.getMessage() );
          }  
    }
    public static boolean contains2(LinkedList<LinkedList<Integer>> elPepe, int n)
    {
        for( LinkedList<Integer> pepe : elPepe)
        {
            if(pepe.contains(n))
            {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
          //Recibir el numero de duenos de vehiculo y la empresa, y el valor de p por el main
          final int numeroDePuntos = args.length == 0 ? 205 : Integer.parseInt(args[0]);
          final float p = args.length < 2 ? 10f : Float.parseFloat(args[1]);
          // Leer el archivo con las distancias entre los duenos de los vehiculos y la empresa
          GrafosMatriz grafo = leerArchivo(numeroDePuntos, p);
          // Asignar los vehiculos compartidos
          long startTime = System.currentTimeMillis();
          Pair[] noSe= distanciasAUno(grafo, numeroDePuntos);
          LinkedList<LinkedList<Integer>> permutacionParaCadaSubconjunto = asignarVehiculos(grafo,p,noSe);
          long estimatedTime = System.currentTimeMillis() - startTime;
          System.out.println("El algoritmo tomo un tiempo de: "+estimatedTime+" ms");
          // Guardar en un archivo las abejas con riesgo de colision            
          guardarArchivo(permutacionParaCadaSubconjunto, numeroDePuntos, p);
        
   }
    }