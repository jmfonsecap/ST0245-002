import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
public class prueba {

    static String [][] matrix;
   public prueba(String[][] matrix)
   {
      prueba.matrix = matrix;
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
   public static void main(String[] args) throws IOException {
    prueba CPP = new prueba(prueba.leerDatos());  
    Arbol pepe = new Arbol();
    Node ayayay= pepe.buildTree(matrix[0], matrix[1],0,matrix[1].length-1);
    Arbol.guardarArbol("funciono.csv", ayayay);
   } 
}
