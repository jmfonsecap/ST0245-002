class Pair implements Comparable<Pair>{ 
    Double x; 
    Integer y; 
  
    /**
     * Constructor de parejas con variables x y y fijas como double e int respectivamente.
     * @param x Primera parte de la pareja con un double 
     * @param y Segunda parte de la pareja con un int.
     */
    public Pair(double x, int y) 
    { 
        this.x = x; 
        this.y = y; 
    } 
    /**
     * Retorna la primera componente de la pareja
     * @return primera componente de la pareja
     */
    public double getX() {
        return x;
    }
    /**
     * Retorna segunda componente de la pareja
     * @return segunda componente de la pareja
     */
    public int getY() {
        return y;
    }

    /**
     * Metodo que permite ordenar un arreglo de parejas segun la primera componente de la pareja en orden ascendente.
     */
    public int compareTo(Pair comparePair) {
    
        Double compareQuantity = ((Pair) comparePair).getX(); 
    
        
        return (int) (this.getX() - compareQuantity);
    }
}


