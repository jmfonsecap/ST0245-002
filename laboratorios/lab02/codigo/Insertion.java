class Insertion {
    public static void insertionSort(int[] array)
    {
        for(int i =0;i<array.length;i++)
            for(int j=i;j>0;j--) 
            {
                if(array[j]<array[j-1])
                {
                    int aux= array[j];
                    array[j]=array[j-1];
                    array[j-1]=aux;
                }
                else{ break;}
            }    
        //O(n^2)
    }


  public static int[] r_array(int tamanio){
    int[] random = new int [tamanio];
    for (int i=0; i<tamanio; i++){
      random[i]= (int)(Math.random()*80+1); //Los numeros del 1 al 80
    }
    return random;
  }

  public static int[] o_array(int n){
    int[] ordenado = new int[n];
    int x = 20;
    for (int i=0; i<n; i++){
      ordenado[i]= x;
      x+=1;
    }
    return ordenado;
  }  
  public static void main (String[]args){
    for (int n=4500000; n<=9000000; n+=1500000){
      int[] arr = o_array(n);
      long ti = System.currentTimeMillis();
      insertionSort(arr);
      long tf = System.currentTimeMillis();
      long tt = tf - ti;
      System.out.println ("Para un array de: "+n+" elementos insertionSort tardo: "+tt);
    }
    }
}
