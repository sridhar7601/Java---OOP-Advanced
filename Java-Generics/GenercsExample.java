public class GenercsExample{
    public static void main(String[] args){
 //normal method 
        // IntegerPrinter printer = new IntegerPrinter(2.0);
        //  printer.print();

// with T as type passing via class <...>
            Printer<Integer> printer = new Printer<>(3);
            printer.print();

             Printer<Double> printerD = new Printer<>(3.4);
             printerD.print();

//why not obj and generics specific

//obj example
            //  ArrayList<Oblect> cats = new ArrayList<>();
            //  cats.add(....);

            


    } 
}