class Pair implements Comparable<Pair>{ 
    Double x; 
    Integer y; 
  
    // Constructor 
public Pair(double x, int y) 
    { 
        this.x = x; 
        this.y = y; 
    } 
public double getX() {
    return x;
}
public int getY() {
    return y;
}

public int compareTo(Pair comparePair) {
    
    Double compareQuantity = ((Pair) comparePair).getX(); 
    
    //ascending order
    return (int) (this.getX() - compareQuantity);
}
}


