/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//Written by: Sebastien-Paul Martineau
//Student#: 991330329
package card;

import java.util.Scanner;
import java.util.Set;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author srinivsi
 */
public class CardTrick {
    
    public static void main(String[] args)
    {
        Card[] magicHand = new Card[7]; //setting up the magic hand array
        Card lucky_card = new Card();   //setting up lucky card
        int same_card_count = 0;

        lucky_card.setSuit(lucky_card.SUITS[3]);    //lucky card is 2 of clubs
        lucky_card.setValue(2);
        
        magicHand[0] = lucky_card;  //lucky card is the first card of the hand
        
        for (int i=1; i<magicHand.length; i++)  //loop to instantiate the rest of the cards in the lucky hand
        {
            Card c = new Card();
            c.setSuit(Card.SUITS[(int) (Math.random() * 3)]);
            c.setValue((int)(Math.random() * 13));

            magicHand[i] = c;
            //c.setValue(insert call to random number generator here)
            //c.setSuit(Card.SUITS[insert call to random number between 0-3 here])
        }
        //for loop for printing every card in the magic hand
        for (Card c : magicHand){
            System.out.println(c.getSuit() + " " + c.getValue());
        }
            
        //scanner to check the players card
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a card value(1-13): ");
        int userCardValue = sc.nextInt();
        System.out.print("Enter a suit(0-3 where 0=Hearts, 1=Diamonds, 2=Spades, 3=Clubs: ");
        int userCardSuit = sc.nextInt();

        //setting the new suit and value as the new card
        Card userCard = new Card();
        userCard.setSuit(Card.SUITS[userCardSuit]);
        userCard.setValue(userCardValue);
        
        //checking if the card is the same as any of the other cards in the array
        for( Card magic_hand_card : magicHand){
            if ((magic_hand_card.getSuit().toLowerCase().equals(userCard.getSuit().toLowerCase())) && (magic_hand_card.getValue() == userCard.getValue()))
                same_card_count++;            
        }
        
        //checking if theres one or more of the same card that was selected.  if there is, then YOU WIN , if there is 0 then YOU LOSE
        if (same_card_count >= 1){
            System.out.println("Congratulations! Your card is in the magic hand!");
        }
        else{
            System.out.println("Sorry, your card is not in the magic hand.");
        }
        
        //insert code to ask the user for Card value and suit, create their card
        // and search magicHand here
        //Then report the result here
        // add one luckcard hard code 2,clubs
    }
    
}
