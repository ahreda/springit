package Lambad;


import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterface {
    @java.lang.FunctionalInterface
    interface  Arithmatics {
        int operations(int a , int b);
    }

    @java.lang.FunctionalInterface
    interface Printable{
        void printmsg(String msg);
    }


    public static void main(String[] args) {

        Arithmatics addition = (a,b)-> a+b;
        System.out.println(addition.operations(5,5));

        Printable printable = (msg)-> System.out.println(msg);
        printable.printmsg("Hello World");

        // Predicate

        Predicate<Person> personPredicate = (person)-> person.getAge()>25;
        Boolean result = personPredicate.test(new Person("Ahmad",21));
        System.out.println(result);

        Person per1 = new Person("Ahmad", 28);


        //Supplier

        Supplier<Person> personSupplier = ()-> per1;
        Person p1 = personSupplier.get();
        System.out.println(p1);


        // Consumer
        Consumer<Person> personConsumer = (person)-> System.out.println(person.getName());
        personConsumer.accept(new Person("Sami",33) );



    }
}
