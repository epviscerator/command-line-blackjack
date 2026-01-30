//Ethan Pham
//CS1400
//Assignment 4
//11/25/25

import java.util.ArrayList;

public class hand {
    // fields
    ArrayList<card> heldCards = new ArrayList<card>();

    // Methods

    public void addCard(card inCard)
    {
        heldCards.add(inCard);
    }

    public Card getCard(int position)
    {
        return heldCards.get(position);
    }

    public int totalValue()
    {
        int sum = 0;

        for (int i = 0; i < heldCards.size(); i++)
        {
            sum += heldCards.get(i).getValue();
        }
        return sum;
    }
}
