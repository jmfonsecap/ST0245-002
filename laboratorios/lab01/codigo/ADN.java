import java.io.*;
public class ADN{
    
    public static int lcsDNA(String string1, String string2){
        return lcsDNAAux(string1,string2,string1.length(),string2.length());
        
    }

    private static int lcsDNAAux(String string1, String string2,int m,int n) {
        if (m<=0||n<=0)
        {
            return 0;
        }
        
        else if(string1.charAt(m-1)==string2.charAt(n-1)){
            return 1 + lcsDNAAux(string1.substring(0,m-1),string2.substring(0,n-1),string1.substring(0,m-1).length(),string2.substring(0,n-1).length());
        }
        return Math.max(lcsDNAAux(string1.substring(0,m-1),string2,string1.substring(0,m-1).length(),n), lcsDNAAux(string1,string2.substring(0,n-1),m,string2.substring(0,n-1).length()));
    }
    
    public static void main(String[] args)throws IOException {
        
        int i= lcsDNA("axyt", "ayzx");
        System.out.println(i);
    }
}
