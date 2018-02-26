package noIfFizzBuzz;

import static java.util.stream.Collectors.*;

import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.IntStream;

/**
 * ifと3項演算子を使わずにfizzBuzzするだけのネタ
 */
public class NoIfFizzBuzz {
    public static void main(String[] args) {

        Random random = new Random();
        int max = random.nextInt(1001);

        Map<Integer, String> fizzBuzz = fizzBuzz(max);
        fizzBuzz.values().forEach(System.out::println);

    }

    @SuppressWarnings("boxing")
    static Map<Integer, String> fizzBuzz(int max) {
        Map<Integer, String> all = IntStream.rangeClosed(0, max)
                .boxed()
                .collect(toMap(Function.identity(), i -> i.toString()));

        Map<Integer, String> fizz = IntStream.rangeClosed(0, max)
                .filter(i -> i % 3 == 0)
                .boxed()
                .collect(toMap(Function.identity(), i -> "Fizz"));

        Map<Integer, String> buzz = IntStream.rangeClosed(0, max)
                .filter(i -> i % 5 == 0)
                .boxed()
                .collect(toMap(Function.identity(), i -> "Buzz"));

        Map<Integer, String> fizzBuzz = IntStream.rangeClosed(0, max)
                .filter(i -> i % 15 == 0)
                .boxed()
                .collect(toMap(Function.identity(), i -> "FizzBuzz"));

        all.putAll(fizz);
        all.putAll(buzz);
        all.putAll(fizzBuzz);
        all.put(0, "0");
        return all;
    }

}
