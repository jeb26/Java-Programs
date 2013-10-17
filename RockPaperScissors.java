import java.util.*;

public class RockPaperScissors {
	public static void main(String[] args) {
		int randInt, userInt;
		Scanner input = new Scanner(System.in);
		
		randInt = (int)(Math.random()*3);
		
		//Rock:			(0)
		//Paper:		(1)
		//Scissors:		(2)
		
		switch(randInt) {
		case 0: System.out.println("Computer is Rock");
			break;
		case 1: System.out.println("Computer is Paper.");
			break;
		case 2: System.out.println("Computer is Scissors.");
			break;
		}
		
		//Get user input.
		System.out.println("Choose a move: " +
				" Rock(0) Paper(1) Scissors(2)");
		System.out.print("Please enter your move: ");
		userInt = input.nextInt();
		
		//Force correct user input.
		while (userInt > 2) {
			System.out.println("Invalid input. Please " +
					" choose one of the following choices");
			System.out.print("Rock(0) Paper(1) Scissors(2) : ");
			userInt = input.nextInt();
		}
		
		//Determine if there is a win or lose between user and computer.
		switch(userInt) {
		case 0: if (randInt == 2) {
				System.out.println("You are rock." +
						" Computer is Scissors. You win.");
			}
		else if (randInt == 1) {
			System.out.println("You are rock." +
					" Computer is paper. Computer wins.");
		}
		else {
			System.out.println("You are rock." + 
			" Computer is rock. Game is a draw.");
		}
			break;
		case 1: if (randInt == 0) {
			System.out.println("You are paper. " +
					" Computer is rock. You win.");
		}
		else if (randInt == 2) {
			System.out.println("You are paper." +
					" Computer is scissors. Computer wins.");
		}
		else {
			System.out.println("You are papaer." +
			" Computer is paper. Game is a draw.");
		}
			break ;
		case 2: if (randInt == 1) {
			System.out.println("You are scissors. " +
					" Computer is paper. You win.");
		}
		else if (randInt == 0) {
			System.out.println("You are scissors." +
					" Computer is rock. Computer wins.");
		}
		else {
			System.out.println("Youare scissors."+
			" Computer is scissors. Game is a draw.");
		}
			break;
			
		}
		
	}
	
	}