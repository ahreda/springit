package stream;

import Lambad.Employees;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stream_Sort {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("Roland");
        names.add("Moni");
        names.add("Akos");
        names.add("Tarek");

        List<String> listedNames = names.stream().
                sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        System.out.println(listedNames);

        List<String> listedNames2 = names.stream().
                sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(listedNames2);

        System.out.println("///////////////////////");

        names.stream()
                .sorted().collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("///////////////////////");

        names.stream().sorted(((o1, o2) -> o1.compareTo(o2))).collect(Collectors.toList())
                .forEach(System.out::println);

        Employees emp1 = new Employees(1,"Ahmad", 2000);
        List<Employees>employeesList = new ArrayList<>();
        employeesList.add(emp1);
        employeesList.add(new Employees(2, "zami",25000));
        employeesList.add(new Employees(3, "Yarim",12000));
        System.out.println("*************************************");
        employeesList.stream()
                .sorted(((o1, o2) -> (int) (o1.getSalary() - o2.getSalary()))).collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println("Empployees sorted by names");


    employeesList.stream()
            .sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).collect(Collectors.toList())
            .forEach(System.out::println);

    employeesList.stream().sorted(Comparator.comparing(Employees::getName).reversed())
            .collect(Collectors.toList())
            .forEach(System.out::println);



        employeesList.stream()
                .sorted(Comparator.comparingLong(Employees::getSalary)).collect(Collectors.toList())
                .forEach(System.out::println);

        List<Employees> newEmpList = new ArrayList<>();
        employeesList.stream()
                .sorted(Comparator.comparingLong(Employees::getSalary).reversed()).collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println(" \\\\\\\\\\\n");

        employeesList.stream()
                .sorted(Comparator.comparingLong(Employees::getId).reversed()).collect(Collectors.toList())
                .forEach(System.out::println);


        System.out.println(" \\\\\\\\\\\n");
        employeesList.forEach(System.out::println);


    }


}
