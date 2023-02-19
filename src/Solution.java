import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Solution {
    public static void main(String[] args) {

        System.out.println("----- Задание 1 -----\n");
// region integerArrayList
        List<Integer> integerArrayList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            integerArrayList.add(randomNumber(-100, 100));
        }
        System.out.println(integerArrayList);
// endregion integerArrayList

        Predicate<Integer> integerPredicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 0;
            }
        };

        Predicate<Integer> integerPredicate1 = x -> x > 0;

        integerArrayList.removeIf(integerPredicate1);
        System.out.println(integerArrayList);

        System.out.println("\n----- Задание 2 -----\n");
//region Person
        class Person {
            private final String name;

            public Person(String name,int age) {
                this.name = name;
            }

            public String getName() {
                return name;
            }

        }

//endregion Person

        Person person = new Person("Иван",25);

        Consumer<Person> personConsumer = new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.printf("Приветствую %s!%n", person.getName());
            }
        };

        Consumer<Person> personConsumer1 = person1 -> System.out.printf("Приветствую %s!%n", person.getName());
        personConsumer1.accept(person);

        System.out.println("\n----- Задание 3 -----\n");

        double doubleNumber = 2.33;
        Function<Double, Long> doubleLongFunction = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return aDouble.longValue();
            }
        };
        Function<Double, Long> doubleLongFunction1 = adouble -> adouble.longValue();

        System.out.printf("Вещественное число %f возвращено в его округленный вариант %d%n", doubleNumber, doubleLongFunction1.apply(doubleNumber));

        System.out.println("\n----- Задание 4 -----\n");

        Supplier<Integer> integerSupplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return (randomNumber(0, 100));
            }
        };

        Supplier<Integer> integerSupplier1 = () -> randomNumber(0, 100);

        System.out.println("Случайное число из диапазона от 0 до 100 - " + integerSupplier1.get());

        System.out.println("\n----- Задание 5 (опциональное) -----\n");

        // функция ternaryOperator выглядит логически правильно, но я не смог придумать ей проверку.

    }

    public static int randomNumber(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return x -> {
            if (condition.test(x)) {
                return ifTrue.apply(x);
            } else {
                return ifFalse.apply(x);
            }
        };
    }

}
