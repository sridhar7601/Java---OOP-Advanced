public class Printer <T>{
  T ThingToPrint;

public Printer(T ThingToPrint){
this.ThingToPrint = ThingToPrint;
}


  public void print(){
     System.out.println(ThingToPrint);
  }

}