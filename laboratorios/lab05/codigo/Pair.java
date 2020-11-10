
class Pair implements Comparable<Pair>{ 
    Integer x; 
    Integer y; 
  
    // Constructor 
public Pair(int x, int y) 
    { 
        this.x = x; 
        this.y = y; 
    } 
public int getX() {
    return x;
}
public int getY() {
    return y;
}

public int compareTo(Pair comparePair) {
    
    Double compareQuantity = (double)(((Pair) comparePair).getY()); 
    
    //ascending order
    return (int) (this.getY() - compareQuantity);
}
}


