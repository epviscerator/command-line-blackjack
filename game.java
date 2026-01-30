//Ethan Pham
//CS1400
//Assignment 4
//11/25/25

import java.util.Scanner;

public class game {
    public static void main(String args[])
    {
        // Initializing helper variables
        boolean playAgain = false;
        //boolean wonLastGame = false;
        boolean postGameContinue = false;
        boolean hitOrStand = true;
        boolean dealerContinue = true;
        String epicDecider = "";
        String awesomeDecider = "";
        //int wins = 0;

        // Initialize Deck
        deck epicDeck = new deck();
        

        


        // Create hand and dealer hand
        hand awesomeHand = new hand();

        hand dealerHand = new hand();

    do
        {
            // getting stuff ready, matters in loops
            epicDeck.cardList.clear();
            awesomeHand.heldCards.clear();
            dealerHand.heldCards.clear();
            
            // generate and shuffle deck on game start
            epicDeck.generate();
            epicDeck.shuffle();

            // "intro"
            System.out.println("***********************************");
            System.out.println("* Welcome to the Black Jack Table *");
            System.out.println("***********************************");
            System.out.println("*L E T ' S  G O  G A M B L I N G !*");
            System.out.println("***********************************");

            // initial hand (draws 2 cards)
            awesomeHand.addCard(epicDeck.draw());
            epicDeck.removeFirst();
            awesomeHand.addCard(epicDeck.draw());
            epicDeck.removeFirst();


            // main gameplay loop
        
            do
                {

                // Your turn
                if (awesomeHand.totalValue() < 21)
                {
                    System.out.println("Your hand is...");
                    for (int i = 0; i < awesomeHand.heldCards.size(); i++)
                    {
                        System.out.println(awesomeHand.heldCards.get(i).getFace() + " of " + awesomeHand.heldCards.get(i).getSuit());
                    }

                    System.out.println("<" + awesomeHand.totalValue() + " points>" );
                }

                // Win by Blackjack (21)
                if (awesomeHand.totalValue() == 21)
                {
                    System.out.println("Your hand is...");
                    for (int i = 0; i < awesomeHand.heldCards.size(); i++)
                    {
                        System.out.println(awesomeHand.heldCards.get(i).getFace() + " of " + awesomeHand.heldCards.get(i).getSuit());
                    }
                    System.out.println("<" + awesomeHand.totalValue() + " points>" );
                    System.out.println("You won with a Blackjack!");
                    hitOrStand = false;
                }
                // Lose by Bust (Over 21)
                if (awesomeHand.totalValue() > 21)
                {
                    System.out.println("Your hand is...");
                    for (int i = 0; i < awesomeHand.heldCards.size(); i++)
                    {
                        System.out.println(awesomeHand.heldCards.get(i).getFace() + " of " + awesomeHand.heldCards.get(i).getSuit());
                    }
                    System.out.println("<" + awesomeHand.totalValue() + " points>" );
                    System.out.println("Bust!");

                    System.out.println("I win >:))");
                    hitOrStand = false;
                }
                
                try
                {
                    // Hit or stand? (only if you haven't busted)
                    if (hitOrStand == true)
                    {
                        System.out.println("hit or stand? ");
                        Scanner s = new Scanner(System.in);
                        epicDecider = s.nextLine(); 
                        //s.close();
                        }
                        
                    

                    // Hit and continue the cycle
                    if (epicDecider.equals("hit"))
                    {
                        hitOrStand = true;
                        awesomeHand.addCard(epicDeck.draw());
                        epicDeck.removeFirst();
                        
                    }

                    else if (epicDecider.equals("stand"))
                    // Dealer's turn
                    
                    {
                        // Dealer intro
                        hitOrStand = false;
                        dealerHand.addCard(epicDeck.draw());
                        epicDeck.removeFirst();
                        dealerHand.addCard(epicDeck.draw());
                        epicDeck.removeFirst();

                        System.out.println("My starting hand is...");
                        for (int i = 0; i < dealerHand.heldCards.size(); i++)
                        {
                            System.out.println(dealerHand.heldCards.get(i).getFace() + " of " + dealerHand.heldCards.get(i).getSuit());
                        }

                        System.out.println("<" + dealerHand.totalValue() + " points>" );
                            
                        // Dealer main loop
                        do 
                        {
                            if (dealerHand.totalValue() < awesomeHand.totalValue())
                            {
                                dealerHand.addCard(epicDeck.draw());
                                epicDeck.removeFirst();

                                System.out.println("My hand is...");
                                for (int i = 0; i < dealerHand.heldCards.size(); i++)
                                {
                                    System.out.println(dealerHand.heldCards.get(i).getFace() + " of " + dealerHand.heldCards.get(i).getSuit());
                                }

                                System.out.println("<" + dealerHand.totalValue() + " points>" );
                                dealerContinue = true;
                            }

                            // Dealer wins by Blackjack (21)
                            if (dealerHand.totalValue() == 21)
                            {
                                /* 
                                System.out.println("My hand is...");
                                for (int i = 0; i < dealerHand.heldCards.size(); i++)
                                {
                                    System.out.println(dealerHand.heldCards.get(i).getFace() + " of " + dealerHand.heldCards.get(i).getSuit());
                                }
                                System.out.println("<" + dealerHand.totalValue() + " points>" );
                                */
                                System.out.println("I win with a Blackjack! >>:)))");
                                
                                dealerContinue = false;
                            }
                            // Dealer loss by Bust (Over 21)
                            if (dealerHand.totalValue() > 21)
                            {
                                /* 
                                System.out.println("My hand is...");
                                for (int i = 0; i < dealerHand.heldCards.size(); i++)
                                {
                                    System.out.println(dealerHand.heldCards.get(i).getFace() + " of " + dealerHand.heldCards.get(i).getSuit());
                                }
                                System.out.println("<" + dealerHand.totalValue() + " points>" );
                                
                                */
                                System.out.println("Bust!");

                                System.out.println("You win!");
                                dealerContinue = false;
                            }

                            // Normal dealer win condition (Dealer points > Your points and dealer points < 21)
                            if (dealerHand.totalValue() >= awesomeHand.totalValue() && dealerHand.totalValue() < 21)
                            {
                                /* 
                                System.out.println("My hand is...");
                                for (int i = 0; i < dealerHand.heldCards.size(); i++)
                                {
                                    System.out.println(dealerHand.heldCards.get(i).getFace() + " of " + dealerHand.heldCards.get(i).getSuit());
                                }
                                System.out.println("<" + dealerHand.totalValue() + " points>" );
                                */

                                System.out.println("I win >:)");
                                dealerContinue = false;
                            }

                            // Normal dealer lose condition (Dealer points < your points)
                            
                        } while (dealerContinue == true);
                    }
                    if (!epicDecider.equals("hit") && !epicDecider.equals("stand") && hitOrStand == true)
                    {
                        throw new Exception("hit or stand, all lowercase for your typing pleasure.");
                    }
                } 
                
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                    //s.open();
                }

                

                epicDecider = "";

            } while(hitOrStand == true);

            postGameContinue = false;

           
                do
                {
                    
                    System.out.println("Play again? I'm feeling an ace... (yes/no)");
                    Scanner s2 = new Scanner(System.in);
                    awesomeDecider = s2.nextLine(); 
                    
                    try
                    {
                        if (!awesomeDecider.equals("yes") && !awesomeDecider.equals("no"))
                        {
                            throw new Exception("yes or no, all lowercase for your typing pleasure.");
                        }
                    } catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                    if (awesomeDecider.equals("yes"))
                    {
                        playAgain = true;
                        hitOrStand = true;
                        postGameContinue = true;
                        System.out.println("99% of gamblers quit before they win it big!");

                    }

                    else if (awesomeDecider.equals("no"))
                    {
                        playAgain = false;
                        postGameContinue = true;
                        System.out.println("You can check out any time you like, but you can never leave...");
                    }

                    
                } while (postGameContinue == false);      
                
            
                
            
        } while (playAgain == true);
    }    
}
