package eg.edu.alexu.csd.datastructure.hangman;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.Random; 
import java.util.Arrays; 
public class Hangman implements IHangman{
	private String[]dictionary=new String[100]
	,words ;
	private Integer max;
	private String secretword;
	private char[]guess;

/**
	* Set the dictionary
	* Note: You should implement another function which will read a
	* file into array then call this function to set the dictionary.
	* @param words: an array of words
	*/
	public void setDictionary(String[] words) {
		 dictionary = Arrays.copyOf(words, words.length) ;
	}
	public void ReadFile() throws FileNotFoundException {
		String[] words=new String[100];
		int i=0;
		File my=new File("words.txt");
	    Scanner myReader = new Scanner(my);
	    while (myReader.hasNextLine()&&i<100) {
	         words[i] = myReader.nextLine();i++;
	        }
		myReader.close();
		this.setDictionary(words);
	}
	public String selectRandomSecretWord() {
		Random rand = new Random(); 
		int index =rand.nextInt(5);
		System.out.println(dictionary[index]);
		return dictionary[index] ;
	}
	/**
	* Receive a new user guess, and verify it against the secret word.
	* @param c
	* case insensitive user guess.
	* If c is NULL then ignore it and do no change
	* @return
	* secret word with the remaining hidden characters (use '-' instead
	* of unsolved characters), or return NULL if user reached max wrong
	* guesses.
	*/
	public String guess(Character c) throws Exception {
		 int flag = 0;
		char[]secret=secretword.toCharArray();
		for(int i=0;i<secret.length;i++) {
			if(c==secret[i]) {
				guess[i]=c;
				flag=1;
			}
		
		}
		if(flag==0) {
			this.setMaxWrongGuesses(max-1);
		}
		if(max<0) {
			throw new Exception("You Lose");
			
		}
		flag=0;
		return String.copyValueOf(guess);
	}
	/**
	* Set the maximum number of wrong guesses
	* @param max
	* maximum number of wrong guesses, If it is NULL, then assume it 1
	*/
	public void setMaxWrongGuesses(Integer max) {
		if(max==null) {
			this.max=1;
		}
		else {
			this.max=max;
		}
	
	}
	public void play() throws Exception {
		
		secretword=this.selectRandomSecretWord();
		guess=new char[secretword.length()];
		for(int i=0;i<guess.length;i++) {
			guess[i]='-';
		}
		System.out.println(guess);
		char x ;
		while(max>=0) {
			//check winning
			int count=0;
			for(int i=0;i<guess.length;i++) {
				if(guess[i]!='-') {
					count++;
				}
			}
			if(count==guess.length) {
				System.out.println("You Win !");
				return;
			}
			//scan char
	        Scanner sc = new Scanner(System.in); 
	        String str =sc.next();
	        str=str.toLowerCase();
	        x=str.charAt(0);
	        str= this.guess(x);
	       //check losing
	       if(str==null) {
	    	   System.out.println("You Lose");
	    	   return;
	       }
	       else {
	    	   System.out.println(str);
	    	   System.out.println("Tries: "+max);
	       }
		}
	}

	public static void main(String[] args) throws Exception {
 Hangman f  =new Hangman();
 f.setMaxWrongGuesses(3);
 f.play();

	}

}
