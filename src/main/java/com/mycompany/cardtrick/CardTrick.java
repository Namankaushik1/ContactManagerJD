/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cardtrick;

import java.util.Random;
import java.util.Scanner;

/**
 * A program to demonstrate a "magic hand" of cards.
 * 
 * Modified by: Naman Naman (Student Number: 991754563)
 * Date: 2024-11-26
 * @author joede
 */
public class CardTrick {

    public static void main(String[] args) {
        Card[] magicHand = new Card[7];
        Random random = new Random();

        // Fill magicHand with 7 random cards
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(random.nextInt(13) + 1); // Random value between 1-13
            c.setSuit(Card.SUITS[random.nextInt(4)]); // Random suit from SUITS array
            magicHand[i] = c;
        }

        // Ask user for their card
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pick a card:");
        System.out.print("Enter a value (1 for Ace, 11 for Jack, 12 for Queen, 13 for King): ");
        int userValue = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter a suit (Hearts, Diamonds, Spades, Clubs): ");
        String userSuit = scanner.nextLine();

        // Create the user's card
        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(userSuit);

        // Search magicHand for the user's card
        boolean found = false;
        for (Card c : magicHand) {
            if (c.getValue() == userCard.getValue() && c.getSuit().equalsIgnoreCase(userCard.getSuit())) {
                found = true;
                break;
            }
        }

        // Report result
        if (found) {
            System.out.println("Congratulations! Your card is in the magic hand.");
        } else {
            System.out.println("Sorry! Your card is not in the magic hand.");
        }

        // Debugging: Display all cards in magicHand
        System.out.println("\nThe magic hand contained:");
        for (Card c : magicHand) {
            System.out.println(c.getValue() + " of " + c.getSuit());
        }
    }
}
