package noIfFizzBuzz;

import static java.util.stream.Collectors.*;

import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.IntStream;

/**
 * ifと3項演算子を使わずにfizzBuzzするだけのネタ
 */
public class FizzBuzz {
    public static void main(String[] args) {

        Random random = new Random();
        int max = random.nextInt(1001);

        fizzBuzz(max);

    }

    @SuppressWarnings("boxing")
    static void fizzBuzz(int max) {

        Map<Integer, String> num = IntStream.rangeClosed(1, max)
                .filter(i -> i % 3 != 0 && i % 5 != 0)
                .boxed()
                .collect(toMap(Function.identity(), i -> i.toString()));

        Map<Integer, String> fizz = IntStream.rangeClosed(1, max)
                .filter(i -> i % 3 == 0 && i % 15 != 0)
                .boxed()
                .collect(toMap(i -> Integer.valueOf(i), i -> "Fizz"));

        Map<Integer, String> buzz = IntStream.rangeClosed(1, max)
                .filter(i -> i % 5 == 0 && i % 15 != 0)
                .boxed()
                .collect(toMap(i -> Integer.valueOf(i), i -> "Buzz"));

        Map<Integer, String> fizzBuzz = IntStream.rangeClosed(1, max)
                .filter(i -> i % 15 == 0)
                .boxed()
                .collect(toMap(i -> Integer.valueOf(i), i -> "FizzBuzz"));

        fizzBuzz.putAll(num);
        fizzBuzz.putAll(fizz);
        fizzBuzz.putAll(buzz);
        fizzBuzz.values().forEach(System.out::println);
    }

}
