
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Arbol {
    static int preIndex = 0; 
    public Queue<Integer> separarMatrizDerecha(String[][] matrix, Gini gini, Queue<Integer> estudiantes2)
    {
        Queue<Integer> estudiantes= new LinkedList<Integer>();
        Queue<Integer> q = new LinkedList<Integer>(estudiantes2);
        int posVariable = gini.getPosVariable();
        String valor = gini.getCondicion();
        if (Gini.isNumeric(valor)&&!valor.isEmpty())
        {
            Double valor2= Double.parseDouble(valor);
            int i =q.poll();
            while (!q.isEmpty())
            {
                
                
                
                 if(!matrix[i][posVariable].isEmpty()&&Double.parseDouble(matrix[i][posVariable])>= valor2)
                {
                    estudiantes.offer(i);
                }
                i= q.poll();
            }
        }
        else{

            while (!q.isEmpty())
            {
                int i =q.poll();

                if(matrix[i][posVariable].equals(valor) )
                {
                    estudiantes.offer(i);
                }
            }
        }
        return estudiantes;
        
    }
    public Queue<Integer> separarMatrizIzquieda(String[][] matrix, Gini gini, Queue<Integer> estudiantes2)
    {
        Queue<Integer> estudiantes= new LinkedList<Integer>();
        Queue<Integer>q = new LinkedList<Integer>(estudiantes2);
        int posVariable = gini.getPosVariable();
        String valor = gini.getCondicion();
        if (Gini.isNumeric(valor))
        {
            Double valor2= Double.parseDouble(valor);
            while (!q.isEmpty())
            {
                int i =q.poll();
                if(!matrix[i][posVariable].isEmpty())
                {
                    if(Double.parseDouble(matrix[i][posVariable])< valor2)
                    {
                        estudiantes.offer(i);
                    }
                }
                
            }
        }
        else{
            while (!q.isEmpty())
            {
                int i =q.poll();

                if(!(matrix[i][posVariable].equals(valor)))
                {
                    estudiantes.offer(i);
                }
            }
        }
        return estudiantes;
        
    }
    public Node crearArbol(String[][] matrix,Queue<Integer> estudiantes,int alturaI, int alturaD)
    {   
        if(estudiantes.isEmpty())
        {
            return null;
        }
        Gini determinante= Gini.calcularImpurezaM(matrix,estudiantes);
        if(matrix[0][determinante.getPosVariable()].equals("estu_consecutivo.1"))
        {
            return null;
        }
        if(determinante.getImpureza()==0.0||alturaD+alturaI>=5)
        {
            
            Node pepe = new Node( new Pairs<Integer,String>(determinante.getPosVariable(),determinante.getCondicion()));
            pepe.right= null;
            pepe.left = null;
            return pepe;
        } 
        
        Node nodo= new Node( new Pairs<Integer,String>(determinante.getPosVariable(),determinante.getCondicion()));
        
        Queue<Integer> estudiantesD= separarMatrizDerecha(matrix,determinante,estudiantes);

        nodo.right = crearArbol(matrix, estudiantesD,alturaI,alturaD+1);

        Queue<Integer> estudiantesI = separarMatrizIzquieda(matrix, determinante,estudiantes);
        nodo.left = crearArbol(matrix, estudiantesI,alturaI+1,alturaD);
        return nodo;
    }
    public boolean revisarArbol(Node arbol,String[] estudiante)
    {
        final int[] stringsNo = {14,23,63};
        if(arbol==null)
        {
            return false;
        }
        
        else if(!isNumeric(estudiante[arbol.getValor().getElement0()])||Double.parseDouble(estudiante[arbol.getValor().getElement0()])>300||falsoInt(stringsNo,arbol.getValor().getElement0())||arbol.getValor().getElement1().isEmpty())
        {
            if(arbol.getValor().getElement1().equals(estudiante[arbol.getValor().getElement0()]))
            {
                if(arbol.right!=null)
                {
                    if(arbol.right.right==null&&arbol.right.left==null)
                    {
                        return true;
                    }
                    else{
                        return revisarArbol(arbol.right, estudiante);
                    }
                    
                }
                else
                {
                    return true;
                }
               

            }
            else
            {
                if(arbol.left!=null)
                {
                    if(arbol.left.right==null&&arbol.left.left==null)
                    {
                        return false;
                    }
                    else{
                        return revisarArbol(arbol.left, estudiante);
                    }
                    
                }
                else 
                {
                    return false;
                }
            }
        }
        else
        {   
            
            if(Double.parseDouble(arbol.getValor().getElement1())<=Double.parseDouble(estudiante[arbol.getValor().getElement0()]))
            {
                
                if(arbol.right!=null)
                {
                    if(arbol.right.right==null&&arbol.right.left==null)
                    {
                        return true;
                    }
                    else{
                        return revisarArbol(arbol.right, estudiante);
                    }
                    
                }
                else
                {
                    return true;
                }
               

            }
            else
            {
                if(arbol.left!=null)
                {
                    if(arbol.left.right==null&&arbol.left.left==null)
                    {
                        return false;
                    }
                    else{
                        return revisarArbol(arbol.left, estudiante);
                    }
                    
                }
                else 
                {
                    return false;
                }
            }
        }
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
            if(i==posicion)
                return true;
        }
        return false;
    }
    public static void guardarArbol(String nombre, Node arbol) throws IOException
    {   
        File archivo = new File(nombre);
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
        guardarArbolPreOrder(bw,arbol);
        bw.newLine();
        guardarArbolInOrder(bw,arbol);
        bw.flush();
        bw.close();
    }
    public static void guardarArbolPreOrder(BufferedWriter bw, Node arbol) throws IOException 
    {
        if(arbol!=null){
            
            if(arbol.right==null&&arbol.left==null)
            {
                bw.write(arbol.getValor().getElement0()+"|"+arbol.getValor().getElement1()+";");
            }
            else{
                bw.write(arbol.getValor().getElement0()+"|"+arbol.getValor().getElement1()+";");
            }
            guardarArbolPreOrder(bw,arbol.left);
            guardarArbolPreOrder(bw,arbol.right);
        }
    }
    public static void guardarArbolInOrder(BufferedWriter bw, Node arbol) throws IOException
    {
        if(arbol!=null){
            guardarArbolInOrder(bw,arbol.left);
            if(arbol.right==null&&arbol.left==null)
            {
                bw.write(arbol.getValor().getElement0()+"|"+arbol.getValor().getElement1()+";");
            }
            else{
                bw.write(arbol.getValor().getElement0()+"|"+arbol.getValor().getElement1()+";");
            }
            
            guardarArbolInOrder(bw,arbol.right);
        }
    }
    
    int search(String arr[], int strt, int end, String value) 
    { 
        int i; 
        for (i = strt; i <= end; i++) { 
            if (arr[i].equals(value)) 
                return i; 
        } 
        return i; 
    } 
    
    Node buildTree(String pre[], String in[], int inStrt, int inEnd) 
    { 
        
        int element0= 0;
        String element1= "nada";
        if (inStrt > inEnd) 
            return null; 

        /* Pick current node from Preorder traversal using preIndex 
           and increment preIndex */
        String a= pre[preIndex++];
        
        for(int i =0;i<a.length();i++)
        {
            if(a.charAt(i)=='|')
            {
                element0= Integer.parseInt(a.substring(0,i));
                element1= a.substring(i+1);
                break;
                }
            }
        Node tNode = new Node(new Pairs<Integer,String>(element0,element1)); 
  
        /* If this node has no children then return */
        if (inStrt == inEnd) 
            return tNode; 
            

        /* Else find the index of this node in Inorder traversal */
        int inIndex = search(in, inStrt, inEnd, a); 
            
        /* Using index in Inorder traversal, construct left and 
           right subtress */
        tNode.left = buildTree(in, pre, inStrt, inIndex - 1); 
        tNode.right = buildTree(in, pre, inIndex + 1, inEnd);
            
  
        return tNode;
           
    } 
    static Set<Node> set = new HashSet<>(); 
    static Stack<Node> stack = new Stack<>(); 
  
    // Function to build tree using given traversal 
    public Node buildTree(String[] preorder, String[] inorder) 
    { 
  
        Node root = null; 
        int element0 =0;
        String element1="";
        for (int pre = 0, in = 0; pre < preorder.length;) { 
  
            Node node = null; 
            do { 
                for(int i =0;i<preorder[pre].length();i++)
                {
                    if(preorder[pre].charAt(i)=='|')
                    {
                        element0= Integer.parseInt(preorder[pre].substring(0,i));
                        element1= preorder[pre].substring(i+1);
                        break;
                    }
                }
                node = new Node(new Pairs<Integer,String>(element0,element1)); 
                if (root == null) { 
                    root = node; 
                } 
                if (!stack.isEmpty()) { 
                    if (set.contains(stack.peek())) { 
                        set.remove(stack.peek()); 
                        stack.pop().right = node; 
                    } 
                    else { 
                        stack.peek().left = node; 
                    } 
                } 
                stack.push(node); 
            } while (preorder[pre++] != inorder[in] && pre < preorder.length); 
  
            node = null; 

            while (!stack.isEmpty() && in < inorder.length &&  
                    stack.peek().getValor().getElement0().toString()+"|"+stack.peek().getValor().getElement1() == inorder[in]) { 
                node = stack.pop(); 
                in++; 
            } 
  
            if (node != null) { 
                set.add(node); 
                stack.push(node); 
            } 
        } 
  
        return root; 
    } 
  
}
