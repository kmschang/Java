public class coder {
    public static void main(String[] args) {

        long counter = 0;

        while (true) {
            char randomDigit = (char)(Math.random() * 10 + 48);
            System.out.print(randomDigit);
            ++counter;
            if (counter == 1000000000) {
                break;
            } else if (counter % 100 == 0) {
                System.out.println();
            }
        }

    }
}
