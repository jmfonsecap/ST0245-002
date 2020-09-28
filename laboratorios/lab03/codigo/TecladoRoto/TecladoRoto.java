import java.util.LinkedList;
public class TecladoRoto
{
    public static DLinkedList ArreglarTeclado(LinkedList<Character> teclado)
    {
        DLinkedList tecladoListo= new DLinkedList();
        while(teclado.peek()!=null)
        {
    
            if(teclado.peek()=='[')
            {
                teclado.remove();
                if(teclado.peek()!=null&&teclado.peek()!=']'&&teclado.peek()!='[')
                {
                    
                    tecladoListo.push(teclado.poll());
                    Node temp= tecladoListo.head;
                    while(teclado.peek()!=null&&teclado.peek()!=']'&&teclado.peek()!='[')
                    {
                        tecladoListo.InsertAfter( temp, teclado.poll());
                        if(teclado.peek()==null)
                        {
                            break;
                        }
                        else{
                            temp=temp.next;
                        }
                        
                    }
                }
                
            }
            else if(teclado.peek()==']')
            {
                teclado.remove();
                if(teclado.peek()!=null&&teclado.peek()!=']'&&teclado.peek()!='['&&teclado.peek()!=null)
                {
                    tecladoListo.append(teclado.poll());
                    while(teclado.peek()!=null&&teclado.peek()!=']'&&teclado.peek()!='[')
                    {
                        tecladoListo.append(teclado.poll());
                    }
                }
            }
            else
            {
                tecladoListo.append(teclado.poll());
            }
        }
        return tecladoListo;
    }
    public static void main(String[] args) {
        String prueba= "asd[gfh[[dfh]hgh]fdfhd[dfg[d]g[d]dg";
        LinkedList<Character> prueba2= new LinkedList<Character>();

        for(int i=0;i<prueba.length();i++)
        {
            prueba2.add(prueba.charAt(i));
            
        }
        DLinkedList prueba3= ArreglarTeclado(prueba2);
        LinkedList<Character> prueba4= new LinkedList<Character>();
        while(prueba3.head!=null)
        {
            prueba4.add(prueba3.head.data);
            prueba3.head=prueba3.head.next;
        }
        int size = prueba4.size();
        for(int i=0;i<size;i++)
        {
            System.out.print(prueba4.poll());
        }
    }
}