//Ethan Pham
//CS1400
//Assignment 4
//11/25/25

//balls

import java.util.ArrayList;
import java.util.Collections;

public class deck {

    // holds cards
    ArrayList<card> cardList = new ArrayList<card>(52);



    
    // shuffle method
    public void shuffle()
    {
        Collections.shuffle(cardList);         //cardList is an ArrayList of 52 card objects, i.e. the deck's data structure that holds 52 Card objects
    }

    // draw method
    // hey, it never said draw a **RANDOM** card 
    public card draw()
    {
        return cardList.get(0);
    }

    // removeFirst method, used to remove the card that has just been drawn
    public void removeFirst()
    {
        cardList.remove(0);
    }

    // generate method, generates cards
    public void generate()
    {
        //int cardNumber = 0;
        String newFace = "";
        String newSuit = "";
        int newValue = -1;

        for (int i = 0; i < 4; i++)
        {

            for (int j = 0; j < 13; j++)
            {
                // Suits
                if (i == 0)
                {
                    newSuit = "Spades";
                }

                if (i == 1)
                {
                    newSuit = "Clubs";
                }

                if (i == 2)
                {
                    newSuit = "Hearts";
                }

                if (i == 3)
                {
                    newSuit = "Diamonds";
                }

                // Faces + Values

                if (j == 0)
                {
                    newFace = "Ace";
                    newValue = 11;
                }

                if (j == 1)
                {
                    newFace = "Two";
                    newValue = 2;
                }

                if (j == 2)
                {
                    newFace = "Three";
                    newValue = 3;
                }

                if (j == 3)
                {
                    newFace = "Four";
                    newValue = 4;
                }

                if (j == 4)
                {
                    newFace = "Five";
                    newValue = 5;
                }

                if (j == 5)
                {
                    newFace = "Six";
                    newValue = 6;
                }

                if (j == 6)
                {
                    newFace = "Seven";
                    newValue = 7;
                }

                if (j == 7)
                {
                    newFace = "Eight";
                    newValue = 8;
                }

                if (j == 8)
                {
                    newFace = "Nine";
                    newValue = 9;
                }

                if (j == 9)
                {
                    newFace = "Ten";
                    newValue = 10;
                }

                if (j == 10)
                {
                    newFace = "Jack";
                    newValue = 10;
                }

                if (j == 11)
                {
                    newFace = "Queen";
                    newValue = 10;
                }

                if (j == 12)
                {
                    newFace = "King";
                    newValue = 10;
                }

                // Adds cards to cardList
                cardList.add(new card(newFace, newSuit, newValue));
                

            }
            
        }
        
    }
}
