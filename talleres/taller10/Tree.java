class Tree{
  Tree right,left;
  String name; 
  int number;
  public Tree(String name, int number){
    this.name = name;
    this.number = number;
  }


  /* Punto #1
  La complejidad para insertar es de O(n)*/
  public void insert(String name, int value){
    if (value <= number){
      if (left == null){
        left = new Tree(name, value);
      } else {
        left.insert(name, value);
      }
    }
    else if (value >= number){
      if (right == null){
        right = new Tree(name, value);
      } else{
        right.insert(name, value);
      }
    } 
  }
  /*Punto #1
  La complejiadad para buscar es de O(n)*/
  public boolean containsNumber(int value){
    if (value == number){
      return true;
    } else if (value < number){
      if (left == null){
        return false;
      } else{
        return left.containsNumber(value);
      }
    } else {
      if (right == null){
        return false;
      } else {
        return right.containsNumber(value);
      }
    }
  }
  /*Punto #1
  La complejidad para buscar es de O(n)*/
  public boolean containsName(String search){
    if (search == name){
      return true;
    } else if (left!= null){
      return left.containsName(search);
    } else if (right != null){
      return right.containsName(search);
    }
    return false;
  }
  // Punto #2
  public void codeLeft(){
    System.out.print ("\""+name+"\"");
    if (left != null){
      System.out.print(" -> ");
      left.codeLeft();
    }
    System.out.println();
  } //Complejidad O(n)

  public void codeRight(){
    System.out.print ("\""+name+"\"");
    if (right != null){
      System.out.print(" -> ");
      right.codeRight();
    } //Complejidad O(n)
  }

  //Punto #5
  public void inOrder(){
    if (left != null){
      left.inOrder();
    }
    System.out.println("El nombre es: "+name +", y su telefono es: "+number); 
    if (right != null){
      right.inOrder();
    }
  }
} //End of tree class

class Main{
  public static void main (String[]args){
    //Punto #1
    Tree root = new Tree("Rodrigo", 7435217); //#2
    root.insert("Juan", 9040138); //#3
    root.insert ("Pedro", 7335185); //#1
    System.out.println (root.containsName("Rodrigo Moreno"));
    System.out.println (root.containsNumber(7435218));
    //Punto #2
    root.codeLeft();
    root.codeRight();
    //Punto #5
    root.inOrder();


  }
}
