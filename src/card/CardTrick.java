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
        
        
        String card_suit;
        String[] card_array;
        int card_value;
        int same_card_count = 0;
            
            //scanner to check the players card
            Scanner sc = new Scanner(System.in);
            System.out.println("What is the value and the suit of your card?");
            //the user needs to put a space between both values: 13 diamonds or clubs 2
            String userCard = sc.nextLine();

            //split the card in the number and the string so i can assign it to two different variables
            card_array = userCard.split(" ");


            //cant do an if statement so i did a try / catch to see which of the two unknown Strings were infact an int
            //and then i put them in their corresponding int and string variables to become a new card's value and suite
            try{
                card_value = Integer.parseInt(card_array[0]);
                card_suit = card_array[1];
            }catch(NumberFormatException e){
                card_value = Integer.parseInt(card_array[1]);
                card_suit = card_array[0];
            }
        
        //setting the new suit and value as the new card
        Card c = new Card();
        c.setSuit(card_suit);
        c.setValue(card_value);
        
        //checking if the card is the same as any of the other cards in the array
        for( Card magic_hand_card : magicHand){
            if ((magic_hand_card.getSuit().toLowerCase().equals(c.getSuit().toLowerCase())) && (magic_hand_card.getValue() == c.getValue()))
                same_card_count++;            
        }
        
        //checking if theres more than 1 of the same card as the card that was mentionned in the magic hand, or is it one or zero of them
        if (same_card_count > 1){
            System.out.println("There are " + same_card_count +  ",  " + card_value + " of " + card_suit + " in the magic hand.");
        }
        else{
            System.out.println("There is " + same_card_count +  ", " + card_value + " of " + card_suit + " in the magic hand.");
        }
        
        //insert code to ask the user for Card value and suit, create their card
        // and search magicHand here
        //Then report the result here
        // add one luckcard hard code 2,clubs
    }
    
}
