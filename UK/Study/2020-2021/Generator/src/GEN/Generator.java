package GEN;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public  class Generator {


    //private static final String DIGITS = "0123456789";
    private static String DIGITS="";
    private static boolean useDigits;



    private Generator() {
        throw new UnsupportedOperationException("Empty constructor is not supported.");
    }

    private Generator(GeneratorBuilder builder) {
        this.useDigits = builder.useDigits;
    }



    public static class GeneratorBuilder {

        private boolean useDigits;


        public GeneratorBuilder useDigits(boolean useDigits) {
            this.useDigits = useDigits;
            return this;
        }

        public Generator build() {
            return new Generator(this);
        }
    }



   
    public static String generate(int length, int min, int max) {
        if (length <= 0) {
            return "";
        }
        
        for(int i = min; i<max+1;i++)
        {
            DIGITS += i;
            
        }
        System.out.println(DIGITS);

        StringBuilder password = new StringBuilder(length);
        Random random = new Random(System.nanoTime());


        // Collect the categories to use.
        List<String> charCategories = new ArrayList<>(4);
        
        if (useDigits) {
            charCategories.add(DIGITS);
        }


        for (int i = 0; i < length; i++) {
            String charCategory = charCategories.get(random.nextInt(charCategories.size()));
            int position = random.nextInt(charCategory.length());
            password.append(charCategory.charAt(position)+" ");
        }
        return new String(password);
    }
}