import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.*;

public class StartGame
{
    public static ArrayList<String> playerHand = new ArrayList<>();
    public static ArrayList<String> dealerHand = new ArrayList<>();
    public static Deck d1 = new Deck();
    public static int playerHandTotal = 0;
    public static int dealerHandTotal = 0;

    public static void main(String[] args)
    {
        initializeDealer();
        Scanner scan = new Scanner(System.in);
        int play = 0;
        boolean continuePlaying = true;

        System.out.println("welcome! The dealers revealed card is "+dealerHand.get(0));

        while(playerHandTotal <= 21 && continuePlaying != false)
        {
            System.out.print("Your current hand is ");
            for(int i = 0; i <playerHand.size(); i++)
            {
                System.out.print(playerHand.get(i)+", ");
            }


            System.out.println("\nYour current hand Total is "+handTotal(playerHand));

            System.out.print("Press 1 to Draw a card. Press 2 to stand ");
            play = scan.nextInt();
            if(play == 1)
            {
                playerHand.add(d1.takeCard());
                if(handTotal(playerHand) >21)
                {
                    continuePlaying = false;
                }
            }
            else
            {
                System.out.print("Dealers current hand is ");
                for(int i = 0; i <dealerHand.size(); i++)
                {
                    System.out.print(dealerHand.get(i)+", ");
                }
                dealerDraw();
                continuePlaying = false;
            }
        }
        playerHandTotal = handTotal(playerHand);

        if(playerHandTotal > 21)
        {
            System.out.println("\n"+handTotal(playerHand)+" is a bust, you lose");
        }
        else if(dealerHandTotal > 21)
        {
            System.out.println("\nThe dealer busts. You win");
        }

        else if(playerHandTotal > dealerHandTotal)
        {
            System.out.println("\nYour hand totals "+playerHandTotal+" is greater than the dealers hand of "+dealerHandTotal+
            " So you win");
        }
        else if(playerHandTotal < dealerHandTotal)
        {
            System.out.println("\nYour hand totals "+playerHandTotal+" is less than the dealers hand of "+dealerHandTotal+
                    " So you lose");
        }
        else
        {
            System.out.println("Tie Game");
        }
    }

    public static void initializeDealer()
    {

        for(int i = 0; i <2; i++)
        {
            playerHand.add(d1.takeCard());
            dealerHand.add(d1.takeCard());
        }
    }

    public static void dealerDraw()
    {

        dealerHandTotal = handTotal(dealerHand);
        while(dealerHandTotal <=16)
        {
            dealerHand.add(d1.takeCard());
            dealerHandTotal = handTotal(dealerHand);
            System.out.print("Dealers current hand is ");
            for(int i = 0; i <dealerHand.size(); i++)
            {
                System.out.print(dealerHand.get(i)+", ");
            }
        }
    }
    public static int handTotal(ArrayList<String> hand)
    {
        int [] arr = new int[hand.size()];

        for(int i = 0; i <hand.size(); i++)
        {
            if(hand.get(i).equals("J") ||hand.get(i).equals("Q")||hand.get(i).equals("K") )
            {
                arr[i] = 10;
            }
            else if(hand.get(i).equals("A"))
            {
                arr[i] = 11;
                int sum = IntStream.of(arr).sum();
                if(sum >21)
                {
                    arr[i] = 1;
                }
            }
            else
            {
                arr[i] = Integer.parseInt(hand.get(i));
            }
        }
        return IntStream.of(arr).sum();
    }
}
