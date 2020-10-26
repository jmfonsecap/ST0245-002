class Node{
  Node right, left;
  int value;
  public Node(int value){
    this.value = value;
  }

  public void insert(int newValue){
    if (newValue < value){
      if (left == null){
        left = new Node(newValue);
      } else{
        left.insert(newValue);
      }
    } else{
      if (right == null){
        right = new Node(newValue);
      } else{
        right.insert(newValue);
      }
    }
  }

  public void print (){
    if (left != null){
      left.print();
    }
    if (right != null){
      right.print();
    } 
    System.out.println(value);
  }

} //Fin de la clase

class Main{
  public static void main(String[]args){
    Node root = new Node(50);
    int[]input = {30,24,5,28,45,98,52,60};
    for (int i= 0; i<input.length; i++){
      root.insert(input[i]);
    }
    root.print();
  } 
}
