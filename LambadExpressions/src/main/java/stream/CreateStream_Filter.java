package stream;

import Lambad.Person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreateStream_Filter {

    public static void main(String[] args) {

        // Stream of Objects.

        Stream<String> stream1 = Stream.of("a","b","C");
        Stream<Person> personStream = Stream.of(new Person("Mark",25), new Person("Lana",21));

        stream1.forEach(System.out::println);
        personStream.forEach(System.out::println);



        // Stream from  array
        String[] things = {"Apple", "Lemon", "Orange"};
        Stream<String>thingsStream = Arrays.stream(things);
        thingsStream.forEach(System.out::println);



        // Stream from List
        List<String> stringList = Arrays.asList("Ahmad","School", "University");
        stringList.stream()
                .forEach(System.out::println);

        System.out.println("----------------------------");

        List<String> personList2 = new ArrayList<>();
        personList2.add("another Ahmad");
        personList2.add("another school");
        personList2.add("another University");

        System.out.println("----------------------------");
        personList2.stream()
                .forEach(System.out::println);

        System.out.println("----------------------------");

        // Stream from Collection
        Collection<Person> personCollection = Arrays.asList(new Person("Mani", 45), new Person("Mani", 45));
        personCollection.stream()
                .forEach(System.out::println);
        ////////////////////
        ///////////////////

        List<Person> plist = new ArrayList<>();
        plist.add(new Person("Malak", 22));
        plist.add(new Person("Nader", 30));
        plist.add(new Person("Karim", 32));
        plist.add(new Person("Fadi", 25));

        System.out.println("/////////" +
                "//////////////////// Older persons");

        plist.stream().filter(person -> person.getAge()>25)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }


}
