public class Date {
  private int day;
  private int m; //Month
  private int year;
  public Date(int day, int m, int year){
    this.day = day;
    this.m = m;
    this.year = year;
  }
  public int getDay(){
    return day;
  }
  public int getM(){
    return m;
  }
  public int getYear(){
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