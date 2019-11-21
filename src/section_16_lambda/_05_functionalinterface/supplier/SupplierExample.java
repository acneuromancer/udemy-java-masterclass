package section_16_lambda._05_functionalinterface.supplier;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierExample {

    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 0; i < 10; ++i) {
            System.out.print(random.nextInt(1000) + " ");
        }
        System.out.println();

        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);
        for (int i = 0; i < 10; ++i) {
            System.out.print(randomSupplier.get() + " ");
        }
        System.out.println();
    }

}
