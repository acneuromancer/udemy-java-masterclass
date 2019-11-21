package section_16_lambda.challanges;

import java.util.function.Supplier;

public class Challenge06 {

    public static void main(String[] args) {
        Supplier<String> iLoveJava = () -> "I Love Java";

        iLoveJava = () -> {
            return "I Love Java";
        };

        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);
    }

}
