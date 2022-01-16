import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Deck
{
    public static String[] deck = {"2","2","2","2","3","3","3","3","4","4","4","4"
            ,"5","5","5","5","6","6","6","6","7","7","7","7","8","8","8","8","9","9","9","9","10"
            ,"10","10","10","J","J","J","J","Q","Q","Q","Q","K","K","K","K","A","A","A","A"};

    public static ArrayList<String> deckOfCards = new ArrayList<>(Arrays.asList(deck));
    public static int deckSize = 52;

    public Deck()
    {
        Collections.shuffle(deckOfCards);
    }
    public void printDeck()
    {
        for(int i = 0; i < deckSize; i++)
        {
                System.out.print(deckOfCards.get(i)+", ");
        }
    }
    public String takeCard()
    {
        String temp = deckOfCards.get(0);
        System.out.println("\nTook card from top of the deck");
        deckOfCards.remove(0);
        deckSize--;
        System.out.println("Remaining cards in the deck: "+deckSize);
        return temp;
    }

}
