package org.example;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rnd = new Random();
        boolean playAgain = true;

        while (playAgain) {
            int diceNumber = diceRoll(rnd);
            System.out.println("The number you rolled is " + diceNumber);

            if (diceNumber == 2 || diceNumber == 3 || diceNumber == 12) {
                System.out.println("You lose! You rolled Craps!");
            } else if (diceNumber == 7 || diceNumber == 11) {
                System.out.println("You win! You rolled Natural!");
            } else {
                int gamePoint = diceNumber;
                System.out.println("The point of the game is now set to " + gamePoint);

                while (true) {
                    diceNumber = diceRoll(rnd);
                    System.out.println("You roll is " + diceNumber);

                    if (diceNumber == gamePoint) {
                        System.out.println("You win! Your roll matches the point");
                        break;
                    } else if (diceNumber == 7) {
                        System.out.println("You lose! You rolled a 7 before rolling your point");
                        break;
                    }
                }
            }
            System.out.println("Do you want to play Craps again? Answer Yes or No (y/n): ");
            String playAgainInput = scanner.nextLine();
            playAgain = playAgainInput.equalsIgnoreCase("y");
        }
    }
    static int diceRoll(Random random) {
        return random.nextInt(6) + 1 + random.nextInt(6) + 1;
    }
}