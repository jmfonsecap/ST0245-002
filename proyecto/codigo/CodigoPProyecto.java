import java.util.ArrayList;
import java.util.List;
import java.io.*;
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
        
      System.out.println(CPP.getMatrix()[3][13]);
      Gini menorGini= Gini.calcularImpurezaM(matrix);
      System.out.println("La menor impureza es: "+menorGini.getImpureza()+" en la variable "+matrix[0][menorGini.getPosVariable()]+ " con la condición "+menorGini.getCondicion());
    }
}