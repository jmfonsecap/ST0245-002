public class Date {
  private byte day;
  private byte m; //Month
  private short year;
  public Date(byte day, byte m, short year){
    this.day = day;
    this.m = m;
    this.year = year;
  }
  public byte getDay(){
    return day;
  }
  public byte getM(){
    return m;
  }
  public short getYear(){
    return year;
  }
  public String getDate (Date d){
    return d.day + "/" + d.m + "/" + d.year;
  }
  public int compareTo(Date one, Date two){
    if (one.day > two.day){
      return 1; //Date one after 
    }
    else if (one.m>two.m){
      return 1; //Date one after date two
    }
    else if (one.year>two.year){
      return 1; //Date one after date two
    }
    else if (two.day > one.day){
      return 2; //Date two after date one
    }
    else if (two.m > one.m){
      return 2;
    }
    else if (two.year > one.year){
      return 2;
    }
    else {
      return 3;
    }
  }
  public String process(int i){
    String a = "";
    switch (i){
      case 1 :
        a = "Date one after date two";
        break;
      case 2 :
        a = "Date two after date one";
        break;
      default :
        a = "Equal dates";
    }
    return a;
  }
}
