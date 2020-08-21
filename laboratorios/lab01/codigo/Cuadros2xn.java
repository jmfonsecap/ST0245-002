public class Cuadros2xn {
    
    public static int formas(int n)
    {
        if(n<=2)
        {
            return n;
        }
        return formas(n-1)+formas(n-2);
    }
    
    public static void main(String[] args) {
        
        System.out.println(formas(3));
    }
}