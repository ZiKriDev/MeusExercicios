import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class App {
    public static void main(String[] args) throws Exception {
        Map<String, Integer> map = new LinkedHashMap<>();

        map.put("José", 1);
        map.put("Paulo", 2);
        map.put("Maria", 3);
        map.put("Antônia", 4);

        map.computeIfAbsent("Antônia", k -> k.length());
        map.computeIfAbsent("Joao", k -> k.length() + 1);

        map.forEach( (k, v) -> {
            if (v % 2 > 0) {
                facaAlgo(v, 2, (x, y) -> System.out.println(x + y));
            } else {
                facaAlgo(k, (z) -> System.out.println(z));
            }
        });
    }

    static <T> void facaAlgo(T a1, T a2, BiConsumer<T, T> c) {
        c.accept(a1, a2);
    }

    static <T> void facaAlgo(T a1, Consumer<T> b) {
        b.accept(a1);
    }
}
