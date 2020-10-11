//Punto 1
class HashTable{
  private int[] table;
  
  public HashTable (){
    table = new int [10];
  }

  private int HashFunction(String k){
    return ((int) k.charAt(0))%10;
  }

  public int get(String k){
    int i = HashFunction(k);
    return table[i];
  }

  public void put(String k, int v){
    int i = HashFunction(k);
    table[i] = v;
  }
}

class Pair{
  private String name;
  private int data;

  public Pair(String name, int data){
    this.name = name;
    this.data = data;
  }

}

import java.util.HashMap;
class Taller9{
  //Punto 2
  public static void add(HashMap companies, String name, String country){
    companies.put(name, country);
  }

  //Punto 3
  public static boolean search(HashMap companies, String name){
    return companies.containsKey(name);
  }

  //Punto 4
  public static boolean isAny(HashMap companies, String country){
    return companies.containsValue(country);
  }
}

class Main{
  public static void main (String[]args){
    Taller9 t = new Taller9();
    System.out.print ("Punto 2 {");
    HashMap<String, String> companies = new HashMap <>();
    t.add(companies, "Google", "Estados Unidos");
    t.add(companies, "La locura", "Colombia");
    t.add(companies, "Nokia", "Finlandia");
    t.add(companies, "Sony", "Japon");
    System.out.print ("}");
    System.out.println();
    System.out.print ("Punto 3 {");
    System.out.println(t.search(companies, "Google"));
    System.out.println(t.search(companies, "Motorola"));
    System.out.print ("}");
    System.out.println();
    System.out.print ("Punto 4 {");
    System.out.println (t.isAny(companies, "India"));
    System.out.println (t.isAny(companies, "Estados Unidos"));
    System.out.print ("}");
  }
}
