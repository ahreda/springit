package FunctionalPro;

import com.sun.jdi.PathSearchingVirtualMachine;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainClass {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Ahmad", Person.GENDER.MALE),
                new Person("Roza", Person.GENDER.FEMALE),
                new Person("Sam", Person.GENDER.MALE),
                new Person("Amal", Person.GENDER.FEMALE),
                new Person("Mark", Person.GENDER.MALE)

        );


        List<Person>females= new ArrayList<>();

        for (Person person:people){
            if (Person.GENDER.FEMALE.equals(person.getGender())){
                females.add(person);
            }
        }

        for (Person female : females){
            System.out.println(female);
        }

        System.out.println("This is finctional programming");

        people.stream()
                .filter(person -> Person.GENDER.FEMALE.equals(person.getGender()))
                .forEach(System.out::println);

        System.out.println("////////////////////////////////" +
                "//////////////////////////////////////////");
        List<Person>males = people.stream()
                .filter(person -> Person.GENDER.MALE.equals(person.getGender()))
                .collect(Collectors.toList());
        males.forEach(System.out::println);

    }

    static boolean isPhoneNum(String phoneNum){

        return phoneNum.
    }






}

