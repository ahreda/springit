package Lambad;

import java.util.*;
import java.util.stream.Collector;

public class CollectionsClass {

    public static void main(String[] args ){

        List<Integer> integerList = new ArrayList<Integer>();
        integerList.add(10);
        integerList.add(20);
        integerList.add(8);
        integerList.add(30);
        integerList.add(12);
        Collections.sort(integerList);
        Collections.reverse(integerList);
        System.out.println(integerList);


        List<Employees> employeesList = new ArrayList<>();
        employeesList.add(new Employees(1, "Ahmad", 1000));
        employeesList.add(new Employees(1, "Batrik", 2000));
        employeesList.add(new Employees(1, "Carol", 3000));

      /**  Collections.sort(employeesList, new Comparator<Employees>() {
            @Override
            public int compare(Employees o1, Employees o2) {
                return (int) o1.getSalary() - (int)o2.getSalary();
            }
        });*/



        Collections.sort(employeesList, (o1,o2)-> (int) (o2.getSalary() - o1.getSalary()));
        System.out.println(employeesList);

        Collections.sort(employeesList, (emp1, emp2 )-> emp2.getName().compareTo(emp1.getName()));
        System.out.println(employeesList);




    }
    



}
