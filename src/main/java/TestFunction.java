import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

public class TestFunction {


    public static final Function<Integer, String> INT_TO_STRING = new Function<Integer, String>() {
        @Override public String apply(Integer from) {
            return from.toString();
        }
    };

    // Берет поэлементно значения из коллекции from, преобразует их с помощью функции transformer
// и возвращает список результатов преобразования в том же порядке.
    public static <F, T> List<T> map(Collection<F> from, Function<? super F,? extends T> transformer) {
        ArrayList<T> result = new ArrayList<T>();
        for (F element : from)
            result.add(transformer.apply(element));
        return result;
    }

    // Берет коллекцию произвольных элементов и конкатенирует их в строку
    public static <T> String join(Collection<T> from, String separator) {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for (T element : from) {
            if (first)
                first = false;
            else
                result.append(separator);
            result.append(element);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(5);
        numbers.add(10);
        numbers.add(11);
        numbers.add(15);
        System.out.println(joinNumbers(numbers));
    }

     public static String joinNumbers(Collection<? extends Integer> numbers) {
           return join(map(numbers, INT_TO_STRING), ", "); //верни строку присоединив "," после того как отмапишь в стринг
           //map сперва из коллекции получаем стрингу у каждого элемента и кладем в новую коллекцию Путем запуска метода  apply
         //затем join - каждому элементу из коллекции добавляем , и кладем в билдер и возвращаем строку.
        }

}
