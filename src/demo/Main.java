package demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args)
    {
	// write your code here
        RunGame();
    }
    // denne funtion skaber en list af int,
    // som skal forstille vores deck med korte
    private static List<Integer> CreateDeck()
    {
        // skab en list af tilladt korte 1-13
        List<Integer> fullDeck = new ArrayList<Integer>();
        for(int i = 1; i <= 13; i++){
            // vi fylder listen med kortene 1-13
            fullDeck.add(i);
        }
        // her er listen fyldt op!
        return fullDeck;
    }

    // den function blander kortene
    private static List<Integer> ShuffleDeck(List<Integer> list)
    {
        //Collections.shuffle() is used for shuffling.
        Collections.shuffle(list);
        return list;
    }

    // this method is used to get a random card from the deck
    private static int GetCardFromDeck(List<Integer> list)
    {
        Random rand = new Random();
        // we look in the list and choose a random card/number
        int cardOfChoice = list.get(rand.nextInt(list.size()));
        return  cardOfChoice;
    }
    
    private static void PrintCardDeck(List<Integer> list)
    {
        for (Integer card: list)
        {
            System.out.print(card + " | ");
        }
        System.out.println();
    }

    // this method stimulate the whole game
    private static void RunGame()
    {
        // game win condition
        int winCondition = 21;

        // vi skaber to spiller, spilleren = p1 og computer = p2
        List<Integer> p1 = new ArrayList<>();
        List<Integer> p2 = new ArrayList<>();

        // vi bruger ovenfor function createDeck til at
        // lave et fyldt deck
        List<Integer> freshDeck = CreateDeck();
        // her blander ci Deck'et så alle korte står tilfædigt
        List<Integer> shuffledDeck = ShuffleDeck(freshDeck);

        // Choosing A card on turn and adding to ones card Deck
        boolean isGameOver = false;
        int round = 1;
        while ( !isGameOver)
        {
            if ((!(p1.stream().mapToInt(Integer::intValue).sum() > winCondition))
                || (!(p2.stream().mapToInt(Integer::intValue).sum() > winCondition)))
            {
                System.out.println("Round: " + round);
                // player 1 chooses a card from shuffled deck
                int p1_choice = GetCardFromDeck(shuffledDeck);
                p1.add(p1_choice);
                System.out.println("Player 1, Picks card: " + p1_choice);
                System.out.print("Player 1 hand: ");
                PrintCardDeck(p1);
                int p1_Sum = p1.stream().mapToInt(Integer::intValue).sum();
                System.out.println("Total points: " + p1_Sum);
                System.out.println();

                // player 2 chooses a card from shuffled deck
                int p2_choice = GetCardFromDeck(shuffledDeck);
                p2.add(p2_choice);
                System.out.println("Player 2, Picks card: " + p2_choice);
                System.out.print("Player 2 hand: ");
                PrintCardDeck(p2);
                int p2_Sum = p2.stream().mapToInt(Integer::intValue).sum();
                System.out.println("Total points: " + p2_Sum);
                System.out.println();

                if ((p1.stream().mapToInt(Integer::intValue).sum() == winCondition))
                {
                    System.out.println("P1 is The WINNER...!");
                    isGameOver = true;
                    System.out.println("Game OVER");
                    break;
                }else if (p2.stream().mapToInt(Integer::intValue).sum() == winCondition)
                {
                    System.out.println("P2 is The WINNER...!");
                    isGameOver = true;
                    System.out.println("Game OVER");
                    break;
                }
                round++;
            }
            else
            {
                if (p1.stream().mapToInt(Integer::intValue).sum() > winCondition)
                {
                    System.out.println("P1 has More than " + winCondition + " points");
                    isGameOver = true;
                    System.out.println("P2 Wins by default..!");
                    break;
                }else if(p2.stream().mapToInt(Integer::intValue).sum() > winCondition)
                {
                    System.out.println("P2 has More than " + winCondition + " points");
                    isGameOver = true;
                    System.out.println("P1 Wins by default..!");
                    break;
                }
                isGameOver = true;
            }
        }

        // BUGS:
        //      

    }
}

