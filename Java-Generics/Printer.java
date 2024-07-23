public class Printer <T extends Number>{
  T ThingToPrint;

public Printer(T ThingToPrint){
this.ThingToPrint = ThingToPrint;
}


  public void print(){
     System.out.println(ThingToPrint);
  }

}