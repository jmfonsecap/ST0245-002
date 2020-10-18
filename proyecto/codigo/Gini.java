import java.util.TreeSet;
public class Gini {
    int posVariable;
    String condicion;
    float impureza;
    public Gini()
    {

    }
    public Gini(int posVariable,String condicion, float impureza)
    {
        this.posVariable=posVariable;
        this.condicion=condicion;
        this.impureza=impureza;
    }
    public float getImpureza() {
        return impureza;
    }
    public String getCondicion() {
        return condicion;
    }
    public int getPosVariable() {
        return posVariable;
    }
    public static Gini calcularImpurezaM(String[][] matrix)
    {
        Gini impurezaMenor= new Gini(0,"",(float)300);
        Gini impurezaActual;
        
        for (int i=0;i<matrix[0].length-1;i++)
        {
            TreeSet<String> valores = conjuntoDeValores(matrix, i);
            for(String valor: valores)
            {
                 impurezaActual= new Gini(i,valor,calcularGiniColumna(i, matrix,valor));
                 if(impurezaMenor.getImpureza()>impurezaActual.getImpureza())
                {
                    impurezaMenor=impurezaActual;
                }
            } 
        }
        return impurezaMenor;
    }
    public static TreeSet<String> conjuntoDeValores(String[][] matrix,int posVariable)
    {
        
        TreeSet<String> valores= new TreeSet<String>();
        for(int i =1;i<matrix.length;i++)
        {
            
            
            valores.add(matrix[i][posVariable]);
            
        }
        return valores;
    }
    
    public static float calcularGiniColumna(int posVariable,String[][] matrix,String valor)
    {
        float exitoFalsoI=0;
        float exitoFalsoD=0;
        float exitoVerdaderoI=0;
        float exitoVerdaderoD=0;
        float cantidadD=0;
        float cantidadI=0;
        if (isNumeric(matrix[1][posVariable]))
        {   
            for(int i=1;i<matrix.length;i++)
            {
                
            
                if(Double.parseDouble(matrix[i][posVariable])>=Double.parseDouble(valor))
                {
                    cantidadI++;
                    if(matrix[i][matrix[0].length-1].equals("0"))
                    {
                        exitoFalsoI++;
                    }
                    else{
                        exitoVerdaderoI++;
                    }
                }
                else
                {
                    cantidadD++;
                    if(matrix[i][matrix[0].length-1].equals("0"))
                    {
                        exitoFalsoD++;
                    }
                    else{
                        exitoVerdaderoD++;
                    }
                }
            }
            
        }
        else
        {
            for(int i=1;i<matrix.length;i++)
            {
                
            
                if(matrix[i][posVariable].equals(valor))
                {
                    cantidadI++;
                    if(matrix[i][matrix[0].length-1].equals("0"))
                    {
                        exitoFalsoI++;
                    }
                    else{
                        exitoVerdaderoI++;
                    }
                }
                else
                {
                    cantidadD++;
                    if(matrix[i][matrix[0].length-1].equals("0"))
                    {
                        exitoFalsoD++;
                    }
                    else{
                        exitoVerdaderoD++;
                    }
                }
            }
        }
        if(cantidadD==0)
        {
            return (float) ((float) 1-(Math.pow(exitoFalsoI/cantidadI,2)+(Math.pow(exitoVerdaderoI/cantidadI,2))));
        }
        else if (cantidadI==0)
        {
            return (float) ((float) 1-(Math.pow(exitoFalsoD/cantidadD,2)+(Math.pow(exitoVerdaderoD/cantidadD,2))));
        }
        else
        {
            
            float impurezaI= (float) ((float) 1-(Math.pow(exitoFalsoI/cantidadI,2)+(Math.pow(exitoVerdaderoI/cantidadI,2)))); 
            float impurezaD= (float) ((float) 1-(Math.pow(exitoFalsoD/cantidadD,2)+(Math.pow(exitoVerdaderoD/cantidadD,2))));
            float impurezaP= (float) (((impurezaI*cantidadI)+(impurezaD*cantidadD))/(cantidadD+cantidadI));
            return impurezaP;
        }
        
    }


    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
