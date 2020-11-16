import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class CodigoPProyecto{
    
   static String [][] matrix;
   public CodigoPProyecto(String[][] matrix)
   {
      CodigoPProyecto.matrix = matrix;
   }
   /**
     * Lee los datos en un archivo de datos Parametro String datos el cual se leera
     * 
     * @throws IOException
     */
    public static String[][] leerDatos() throws IOException 
    {
       System.out.println("Ingrese el archivo a leer");
       Scanner scan = new Scanner(System.in);
       String x = scan.nextLine();
         List<String[]> rowList = new ArrayList<String[]>();
      try (BufferedReader br = new BufferedReader(new FileReader(x))) 
      {
         String line;
         while ((line = br.readLine()) != null) {
            String[] lineItems = line.split(";");
            rowList.add(lineItems);
         }
         br.close();
      }
      catch(Exception e){
      // Handle any I/O problems
      }
      matrix = new String[rowList.size()][];
      for (int i = 0; i < rowList.size(); i++) {
      String[] row = rowList.get(i);
      matrix[i] = row;
      
      }
      return matrix;
   
   }

   public String[][] getMatrix() {
      return matrix;
   }
   

    public static void main(final String[] args) throws IOException
    {
      CodigoPProyecto CPP = new CodigoPProyecto(CodigoPProyecto.leerDatos());   
      Queue<Integer> estudiantes= new LinkedList<Integer>();
      Bosque pepe = new Bosque();
      Arbol pepe2 = new Arbol();
      
      Node[] a = pepe.crearBosque(matrix);
      CodigoPProyecto.leerDatos();
      int acertado=0;
      for(int i = 1;i<matrix.length;i++)
      {
         if(pepe.revisarBosque(a, matrix[i]))
         {
            if(matrix[i][matrix[0].length-1].equals("1"))
            {
               acertado++;
            }
            
         }
         else
         {
            if(matrix[i][matrix[0].length-1].equals("0"))
            {
               acertado++;
            }
            
         }
      }
      System.out.println(acertado);    
    }
}