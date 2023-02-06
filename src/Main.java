import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        // Задание 1
    List<Integer>  nums = new ArrayList<>();

    nums.add(1);
    nums.add(15);
    nums.add(35);

    Stream<Integer> stream = nums.stream();
    Comparator<Integer> comparator = (o1, o2) -> {
        if (o1>o2){
            return 1;
        }else if (o2>o1){
            return -1;
        }
        return 0;
    };

    BiConsumer<Integer, Integer> consumer = (x, y) -> System.out.println(String.format("min: " + x + " max: " + y));

    findMinMax(stream, comparator, consumer);

    // Задание 2

        int[] arr= {1,24,12};
        System.out.println(countEven(arr));


    }
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> objects = stream.sorted(order).collect(Collectors.toList());
        if (!objects.isEmpty()) {
            minMaxConsumer.accept(objects.get(0), objects.get(objects.size() - 1));

        } else {
            minMaxConsumer.accept(null, null);
        }
    }

    public static long countEven (int[] arr){
        IntStream stream = Arrays.stream(arr);
        long count = stream
                .filter(i -> i % 2 == 0)
                .count();
        return count;
    }

}

