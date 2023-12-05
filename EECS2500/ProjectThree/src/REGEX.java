import java.util.Scanner;

public class REGEX {

    static String main = "I lived at West Egg, the—well, the less fashionable of the two, though this is a most superficial tag to express the bizarre and not a little sinister contrast between them. My house was at the very tip of the egg, only fifty yards from the Sound, and squeezed between two huge places that rented for twelve or fifteen thousand a season. The one on my right was a colossal affair by any standard—it was a factual imitation of some Hôtel de Ville in Normandy, with a tower on one side, spanking new under a thin beard of raw ivy, and a marble swimming pool, and more than forty acres of lawn and garden. It was Gatsby’s mansion. Or, rather, as I didn’t know Mr. Gatsby, it was a mansion inhabited by a gentleman of that name. My own house was an eyesore, but it was a small eyesore, and it had been overlooked, so I had a view of the water, a partial view of my neighbour’s lawn, and the consoling proximity of millionaires—all for eighty dollars a month.kyle's name is short-man.";

    public static void main(String[] args) {

        String firstFormat = main.replaceAll("[^\\w’—]", " ");
        Scanner scnr1st = new Scanner(firstFormat);
        String secondFormat = firstFormat.replaceAll("(?<=\\w)—(?=\\s)", "");
        Scanner scnr2nd = new Scanner(secondFormat);

        System.out.println(secondFormat);
        while (scnr2nd.hasNext()) {
            String word = scnr1st.next();
            System.out.println(word);
        }






    }
}
