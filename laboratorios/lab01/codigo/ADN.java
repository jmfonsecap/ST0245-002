public class ADN{
    
    /**
     * Metodo que se encarga de calcular la cadena comun más larga entre dos strings.
     * @param string1 Primer string
     * @param string2 Segundo string
     * @return tamaño de la cadena comun más larga.
     */
    public static int lcsDNA(String string1, String string2){
        return lcsDNAAux(string1,string2,string1.length(),string2.length());
        
    }
    /**
     * Metodo auxiliar para lcsDNA
     * @param string1 Primer string
     * @param string2 Segundo string
     * @param m tamaño de string 1
     * @param n tamaño de string 2
     * @return tamaño de la cadena comun más larga.
     */
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
}
