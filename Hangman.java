import java.util.Scanner;

public class Hangman {
	static int game_id = 0;
	public int gameID;
	public int iter = 0;
	public int livesRemaining = 10;
	public StringBuilder wordDate = new StringBuilder();
	public String remained = "ABCDEFGHIJKLMNOPQSRTUVWXYZ";
	public String userInput;
	public String hiddenWord;
	public StringBuilder temp;
	public String ans;
	
	public int arr[] = new int[30];
	public int arr2[] = new int[30];
	
	Hangman() {
		//System.out.println("Working");
		game_id = game_id + 1;
		this.gameID = game_id;
		for(int idx = 0; idx < 30; idx++) {
			arr[idx] = 0;
			arr2[idx] = 0;
		}
	}
	
	public void initializeGame_collectWord(Scanner keyIn) {
		//this.gameID = game_id;
		System.out.println("------------------------------------");
		System.out.println("Welcome to Hangman " + this.gameID);
		
		System.out.println("------------------------------------");
		System.out.println("OK Guessing Player ... turn around, while your friend enters the word to guess!");
		System.out.println("Other Player - Enter your word (up to 10 lettters only): ");
		this.hiddenWord = keyIn.nextLine();
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		
		this.hiddenWord = this.hiddenWord.toUpperCase();
		this.ans = this.hiddenWord;
		for(int idx = 0; idx < hiddenWord.length(); idx++) {
			this.arr[hiddenWord.charAt(idx) - 'A'] = this.arr[hiddenWord.charAt(idx) - 'A'] + 1;
			this.arr2[hiddenWord.charAt(idx) - 'A'] = this.arr2[hiddenWord.charAt(idx) - 'A'] + 1;
		}
		
		
		for(int ind = 0; ind < hiddenWord.length(); ind++) {
	    	this.wordDate.append("*");
	    }
		
		this.hiddenWord = this.hiddenWord.toUpperCase();
	    this.temp = new StringBuilder(this.hiddenWord);
		  
	}
	
	
	
	
	public void play_a_guess(Scanner keyIn) {
		
		
		
		System.out.println("GameID "+this.gameID+": Word to date: "+this.wordDate + " ("+livesRemaining + " guesses left)");
	    System.out.println("GameID "+this.gameID+": Want to solve the puzzle? enter Y to solve the puzzle or N to guess a character: ");
	    String players = keyIn.nextLine();
	    
	    
	    if(players.toLowerCase().equals("y")) {
	    	System.out.println("Enter the complete word: ");
	    	this.userInput = keyIn.nextLine();
	    	if(ans.equals(userInput)) {
	    		System.out.println("----------------------------------------------------");
		        System.out.println("Congratulations!!! \nYou guessed the mystery word "+this.ans+" in " +(10 - livesRemaining) + " guesses!");
		        
		        System.out.println("Goodbye ...");
		        System.out.println("----------------------------------------------------");
		        
		        return;
	    	}
	    }else {
	    	System.out.println("Game ID "+this.gameID+": Letters to try: "+this.remained);
	        System.out.print("GameID "+ this.gameID+": which letter should I check for? ");
	        System.out.println();
	        
	    }
	    
	    this.userInput = keyIn.nextLine();
	    
	    
	    this.livesRemaining--;
	      StringBuilder tt = temp;
	      String tc = tt.toString();
	      
	      if((arr2[userInput.charAt(0) - 'A'] != 0 && arr[userInput.charAt(0) - 'A']== 0) || arr[userInput.charAt(0) - 'A'] == -1) {
	    	  System.out.println("GameID "+this.gameID+":--> Not a valid request - either not a letter or already guessed.");
	    	  System.out.print("GameID "+ this.gameID+": which letter should I check for? ");
	    	  System.out.println();
	    	  this.userInput = keyIn.nextLine();
	      }
	      
	      if(arr[userInput.charAt(0) - 'A'] != -1 && tc.contains(userInput)) { 
	    	  System.out.println();
	          System.out.println("GameID "+this.gameID+": --> great guess!");
	          for(int idx = 0; idx < temp.length(); idx++) {
	        	  if(temp.charAt(idx) == userInput.charAt(0)) {
	        		  this.wordDate.setCharAt(idx, userInput.charAt(0));
	        		  this.temp.setCharAt(idx, '+');
	        		  arr[userInput.charAt(0) - 'A']--;
	        		  break;
	        	  }
	          }
	          //System.out.println(arr[userInput.charAt(0) - 'A']);
	          if(arr[userInput.charAt(0) - 'A'] == 0) {this.remained = this.remained.replace(userInput.charAt(0), '*');
	          arr[userInput.charAt(0) - 'A'] = -1;}
	          hiddenWord = hiddenWord.replace(userInput,"");
	      } else if(arr[userInput.charAt(0) - 'A'] != -1){
	    	  System.out.println();
	        System.out.println("--> Sorry, wrong guess!");
	        if(arr[userInput.charAt(0) - 'A'] == 0)this.remained = this.remained.replace(userInput.charAt(0), '*');
	        //wrongLetters += userInput;
	        
	      }
	      if (hiddenWord.length()==0) {
	    	  System.out.println("----------------------------------------------------");
		        System.out.println("Congratulations!!! \nYou guessed the mystery word "+this.ans+" in " +(10 - this.livesRemaining) + " guesses!");
		        
		        System.out.println("Goodbye ...");
		        System.out.println("----------------------------------------------------");
		        
		        return;
		  }
	      
	}
	
	
	
	public void playGame(Scanner scanner) {
	     // taking mystery word by player
	    
	    
	    
	    String userInput, wrongLetters="";
	    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	    int maxLives = 10;

	    System.out.println("GameID "+this.gameID+": Word to date: "+this.wordDate + " ("+livesRemaining + " guesses left)");
	    System.out.println("GameID "+this.gameID+": Want to solve the puzzle? enter Y to solve the puzzle or N to guess a character: ");
	    String players = scanner.nextLine();
	    
	    
	    
	    if(players.toLowerCase().equals("y")) {
	    	System.out.println("Enter the complete word: ");
	    	userInput = scanner.nextLine();
	    	if(this.ans.equals(userInput)) {
	    		System.out.println("----------------------------------------------------");
		        System.out.println("Congratulations!!! \nYou guessed the mystery word "+this.ans+" in " +(10 - livesRemaining) + " guesses!");
		        
		        System.out.println("Goodbye ...");
		        System.out.println("----------------------------------------------------");
		        
		        return;
	    	}
	    	else {
	    		System.out.println("GameID "+this.gameID+": "+"Incorrect guess, Continue guessing next character");
	    		System.out.println("Game ID "+this.gameID+": Letters to try: "+this.remained);
		        System.out.print("GameID "+ this.gameID+": which letter should I check for? ");
		        System.out.println();
	    	}
	    }else {
	    	System.out.println("Game ID "+this.gameID+": Letters to try: "+this.remained);
	        System.out.print("GameID "+ this.gameID+": which letter should I check for? ");
	        System.out.println();
	        
	    }
	    userInput = scanner.nextLine();   // taking each letter by other player
	    while (this.livesRemaining>0) {
	      this.livesRemaining--;
	      StringBuilder tt = temp;
	      String tc = tt.toString();
	      
	      
	      if((arr2[userInput.charAt(0) - 'A'] != 0 && arr[userInput.charAt(0) - 'A']== 0) || arr[userInput.charAt(0) - 'A'] == -1) {
	    	  System.out.println("GameID "+this.gameID+":--> Not a valid request - either not a letter or already guessed.");
	    	  System.out.print("GameID "+ this.gameID+": which letter should I check for? ");
	    	  System.out.println();
	    	  this.userInput = scanner.nextLine();
	      }
	      
	      else if(arr[userInput.charAt(0) - 'A'] != -1 && tc.contains(userInput)) { 
	    	  System.out.println();
	          System.out.println("GameID "+this.gameID+": --> great guess!");
	          for(int idx = 0; idx < temp.length(); idx++) {
	        	  if(temp.charAt(idx) == userInput.charAt(0)) {
	        		  this.wordDate.setCharAt(idx, userInput.charAt(0));
	        		  this.temp.setCharAt(idx, '+');
	        		  arr[userInput.charAt(0) - 'A']--;
	        		  break;
	        	  }
	          }
	          //System.out.println(arr[userInput.charAt(0) - 'A']);
	          if(arr[userInput.charAt(0) - 'A'] == 0)this.remained = this.remained.replace(userInput.charAt(0), '*');
	          hiddenWord = hiddenWord.replace(userInput,"");
	      } else if(arr[userInput.charAt(0) - 'A'] != -1){
	    	  System.out.println();
	        System.out.println("--> Sorry, wrong guess!");
	        if(arr[userInput.charAt(0) - 'A'] == 0) {
	        	this.remained = this.remained.replace(userInput.charAt(0), '*');
	        	arr[userInput.charAt(0) - 'A'] = -1;
	        }
	        wrongLetters += userInput;
	        
	      }
	      
	      if (hiddenWord.length()==0) {
	    	  System.out.println("----------------------------------------------------");
		        System.out.println("Congratulations!!! \nYou guessed the mystery word "+this.ans+" in " +(10 - this.livesRemaining) + " guesses!");
		        
		        System.out.println("Goodbye ...");
		        System.out.println("----------------------------------------------------");
		        
		        break;
		  }
	      System.out.println("GameID "+this.gameID+": Word to date: "+this.wordDate+" ("+ this.livesRemaining + " guesses left)");
	      
	      System.out.println("GameID "+this.gameID+": Want to solve the puzzle? enter Y to solve the puzzle or N to guess a character: ");
	      players = scanner.nextLine();
	      if(players.toLowerCase().equals("y")) {
	    	  System.out.println("Enter the complete word: ");
		    	userInput = scanner.nextLine();
		    	if(this.ans.equals(userInput)) {
		    		System.out.println("----------------------------------------------------");
			        System.out.println("Congratulations!!! \nYou guessed the mystery word "+this.ans+" in " +(10 - livesRemaining) + " guesses!");
			        
			        System.out.println("Goodbye ...");
			        System.out.println("----------------------------------------------------");
			        
			        break;
		    	}
		    	else {
		    		//System.out.println("Here   "  + this.ans + "    " + userInput);
		    		System.out.println("GameID "+this.gameID+": "+"Incorrect guess, Continue guessing next character");
		    		System.out.println("Game ID "+this.gameID+": Letters to try: "+this.remained);
			        System.out.print("GameID "+ this.gameID+": which letter should I check for? ");
			        System.out.println();
		    	}
		    }else {
		    	System.out.println("Game ID "+this.gameID+": Letters to try: "+this.remained);
		        System.out.print("Game ID "+this.gameID+": which letter should I check for? ");
		        
		        System.out.println();
		        userInput = scanner.nextLine();
		        
		    }
	      
	      
	    }
	    
	    
	    
	    
	    if (livesRemaining==0) { // game is over
	    	System.out.println("\n-----------------------------------------------------");
	      System.out.println("Sorry you did not find the mystery word!");
	      System.out.println(hiddenWord);
	      System.out.println("\nGoodbye....");
	      System.out.println("--------------------------------------------------------");
	    }
	}
	
	
	
	
	
  private String String(char charAt) {
		// TODO Auto-generated method stub
		return null;
	}
  
}
