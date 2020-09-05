class Merge{
    public static void merge(
    int[] a, int[] l, int[] r, int left, int right) {
 
    int i = 0, j = 0, k = 0;
    while (i < left && j < right) {
        if (l[i] <= r[j]) {
            a[k++] = l[i++];
        }
        else {
            a[k++] = r[j++];
        }
    }
    while (i < left) {
        a[k++] = l[i++];
    }
    while (j < right) {
        a[k++] = r[j++];
    }
  }

  public static void mergeSort(int[] a, int n) {
    if (n < 2) {
        return;
    }
    int mid = n / 2;
    int[] l = new int[mid];
    int[] r = new int[n - mid];
 
    for (int i = 0; i < mid; i++) {
        l[i] = a[i];
    }
    for (int i = mid; i < n; i++) {
        r[i - mid] = a[i];
    }
    mergeSort(l, mid);
    mergeSort(r, n - mid);
 
    merge(a, l, r, mid, n - mid);
  }

  public static int[] o_array(int n){
    int[]arr = new int[n];
    int x = 20;
    for (int i=0; i<n; i++){
      arr[i] = x;
      x+= 1;
    }
    return arr;
  }

  public static int[] random_r (int tamanio){
    int[] random = new int[tamanio];
    for (int i=0; i<tamanio; i++){
      random[i] = (int)(Math.random()*80+1); //Los n del  1 al 80
    }
    return random;
  }

  public static void main (String[]args){
    for (int n=4500000; n<=9000000; n+=1500000){
      int[]arr = o_array(17);
      long ti = System.currentTimeMillis();
      mergeSort(arr, arr.length);
      long tf = System.currentTimeMillis();
      long tt = tf - ti;
      System.out.println("Para un array de n: "+n+", merge se tardo: "+tt);
    }
  }

}
