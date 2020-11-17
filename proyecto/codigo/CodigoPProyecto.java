import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodigoPProyecto{
    
   static String [][] matrix;
   public CodigoPProyecto(String[][] matrix)
   {
      CodigoPProyecto.matrix = matrix;
   }
   /**
     * Lee los datos en un archivo de datos csv y los convierto en una matriz de strings.
     * 
     * @throws IOException
     * @return matrix, matriz que tiene los datos de csv en string
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
      scan.close();
      return matrix;
      
   
   }
   
   /**
    * Metodo main que se encarga de llamar la lectura de datos, crear el bosque y hacer el testeo.
    * @param args
    * @throws IOException
    */
    public static void main(final String[] args) throws IOException
    {
      CodigoPProyecto.leerDatos();  
      System.out.println("termine de leer"); 
      Bosque pepe = new Bosque();
      Node[] a = pepe.crearBosque(matrix);
      System.out.println("termine de leer");
      CodigoPProyecto.leerDatos();
      int acertado=0;
      int acertadoVerdadero=0;
      int acertadoFalso=0;
      int falsoPerdido=0;
      int realPerdido=0;
      for(int i = 1;i<matrix.length;i++)
      {
         if(pepe.revisarBosque(a, matrix[i]))
         {
            if(matrix[i][matrix[0].length-1].equals("1"))
            {
               acertadoVerdadero++;
               acertado++;
            }
            else{
               acertadoFalso++;
            }
            
         }
         else
         {
            if(matrix[i][matrix[0].length-1].equals("0"))
            {  
               realPerdido++;
               acertado++;
            }
            else{
               falsoPerdido++;
            }
            
         }
      }
      System.out.println(acertado);    
      System.out.println(acertadoVerdadero);
      System.out.println(acertadoFalso);
      System.out.println(realPerdido);
      System.out.println(falsoPerdido);
    }
}