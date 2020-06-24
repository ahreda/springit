package FunctionalPro;

public class Person {

    private final String name;
    private final GENDER gender;

    public Person(String name, GENDER gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public GENDER getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }

    enum GENDER {
        MALE,FEMALE;
    }


}
