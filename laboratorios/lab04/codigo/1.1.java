
class RoboticBees{
  private String name; 
  private int x; 
  private int y; 
  private int z;
  RoboticBees (String name, int x, int y, int z){
    this.name = name;
    this.x = x; 
    this.y = y; 
    this.z = z;
  }
  public int getX(){
    return this.x;
  }

  public int getY(){
    return this.y;
  }

  public int getZ(){
    return this.z;
  }

  public String getName(){
    return this.name;
  }

}//Fin de la clase

class Main{
  static String msg(RoboticBees a, RoboticBees b, int m){
    String msg = "La abeja "+a.getName()+ " esta a "+ m +" metros de la abeja "+b.getName();
    return msg;
  }
  static String samePos(RoboticBees a, RoboticBees b){
    String msg = "La abeja "+a.getName()+ " se encuentra en la misma posicion que la abeja "+b.getName();
    return msg;
  }

  public static String Space(RoboticBees a, RoboticBees b){
    if (a.getX() == b.getX()){
      return samePos(a,b);
    }
    else if (a.getY()==b.getY()){
      return samePos(a,b);
    }
    else if (a.getZ()==b.getZ()){
      return samePos(a,b);
    }
    else{
      int greaterX, greaterY, greaterZ, lowerX, lowerY, lowerZ;
      if (Math.max(a.getX(),b.getX())==a.getX()){
        greaterX = a.getX();
        lowerX = b.getX();
      } else{
        greaterX = b.getX(); 
        lowerX = a.getX();
      }
      if (Math.max(a.getY(),b.getY())==a.getY()){
        greaterY = a.getY();
        lowerY = b.getY();
      } else{
        greaterY = b.getY(); 
        lowerY = a.getY();
      }
      if (Math.max(a.getZ(),b.getZ())==a.getZ()){
        greaterZ = a.getZ();
        lowerZ = b.getZ();
      } else{
        greaterZ = b.getZ(); 
        lowerZ = a.getZ();
      }
      if ((greaterX-lowerX)<= 100){
        return msg(a, b, greaterX - lowerX);
      }
      else if ((greaterY - lowerY)<=100){
        return msg(a, b, greaterY - lowerY); 
      }
      else if ((greaterZ - lowerZ)<=100){
        return msg(a, b, greaterZ - lowerZ);
      }
      else {
        return "Las abejas se encuentran a mas de 100 metros de distancia.";
      }
    }
  }

}//Fin de la clase Main
