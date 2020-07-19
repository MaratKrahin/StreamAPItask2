package StreamAPItask2;

import java.util.Arrays;
import java.util.Collection;

public class Main {

    // https://habr.com/ru/company/luxoft/blog/270383/
    // III. Примеры работы с методами стримов...... d(-_ˆ)b

    public static void main(String[] args) {
        Collection<People> peoples = Arrays.asList(
                new People("Вася", 16, Sex.MAN),
                new People("Петя", 23, Sex.MAN),
                new People("Елена", 42, Sex.WOMEN),
                new People("Иван Иванович", 69, Sex.MAN)
        );

        peoples.stream()
                .filter(it -> it.getSex().equals(Sex.MAN))
                .filter(it -> it.getAge() > 18 && it.getAge() < 27)
                .forEach(System.out::println);

        peoples.stream()
                .filter(it -> it.getSex().equals(Sex.MAN))
                .mapToInt(People::getAge)
                .average()
                .ifPresent(System.out::println); // я решил не использовать getAsDouble а сразу ifPresent

       long count =  peoples.stream()
                .filter(it -> it.getAge() >= 18)
               .filter(it -> it.getAge() < 60 && it.getSex().equals(Sex.WOMEN) || it.getAge() < 65 && it.getSex().equals(Sex.MAN))
                .count();

        System.out.println("кол-во потенциально работоспособных людей " + count);

    }


}
