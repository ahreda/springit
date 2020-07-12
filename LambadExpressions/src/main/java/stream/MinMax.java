package stream;

import java.util.*;
import java.util.stream.Collectors;

public class MinMax {

    public static void main(String[] args) {


        List<Integer> integerslist = new ArrayList<>();
        integerslist.add(1);
        integerslist.add(2);
        integerslist.add(3);
        integerslist.add(6);

        List<Integer>newIntList=  integerslist.stream().sorted(Comparator.comparingLong(Integer::intValue).reversed()).collect(Collectors.toList());
        System.out.println(newIntList);

        System.out.println(integerslist.stream().count());

        System.out.println(integerslist.stream().min(Comparator.comparing(Integer::intValue)).get());
        OptionalInt optint = integerslist.stream().max(Comparator.comparing(Integer::intValue)).get();







    }


}
