package pl.accenture;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        myVarag();
        myVarag("");
        myVarag("","");

        Stream<String> myStringStream = Stream.of("Ala", "ma", "kota");
        myStringStream.forEach(s -> System.out.println(s));

        Stream
                .<String>builder()
                .add("Ala")
                .add("aa")
                .add("kota")
                .build()
                .filter(s -> s.startsWith("A"))
                .forEach(s -> System.out.println(s)); //CTRL + SPACJA by predykat ci pokazalo

        Predicate<Person> nameStartsWithAPredicate = p -> p.name.startsWith("A");
        Predicate<Person> ageBelow20Predicate = p -> p.age < 20;

        List<Person> people = Arrays.asList(
                new Person("Lukasz",21),
                new Person("Ala",10),
                new Person("Grzegorz",31),
                new Person("Piotr",22),
                new Person("Aleksander",22),
                new Person("Iwona",27),
                new Person("Andrzej",17)
        );

        people.stream().
                filter(nameStartsWithAPredicate.and(ageBelow20Predicate))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    static void myVarag(String ...s) {
    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
