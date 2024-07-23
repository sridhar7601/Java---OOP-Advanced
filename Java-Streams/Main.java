import java.util.*;
import java.util.stream.Collectors;

class Main{
    static class person {
        String name;
        int billion;
        public person(String name,int billion){
            this.name = name;
            this.billion = billion;
        }
    }

    public static void main (String[] args){

        List<person> people = new ArrayList<>();
        people.add(new person("sridhar",120));
        people.add(new person("sruthi",100));
        people.add(new person("vishnu",10));
        people.add(new person("shnega",17));

        // List<person>hunderedClub = new ArrayList<>();
//normal method

        // for(person p : people){
        //     if(p.billion >= 100){
        //         hunderedClub.add(p);
        //     }
        // }


// wth stream like mongo db
 List<person>hunderedClub = people.stream().filter(person -> person.billion >= 100).collect(Collectors.toList());

        hunderedClub.forEach(person -> System.out.println(person.name));
    }
}