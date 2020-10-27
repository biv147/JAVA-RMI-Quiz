

import java.io.*; 
import java.rmi.*;
import java.util.*;

public class FileClient{
   public static void main(String argv[]) {

      if(argv.length != 1) {
        System.out.println("Usage: java FileClient machineName");
        System.exit(0);
      }

      try {
        String name = "//" + argv[0] + "/FileServer";
        FileInterface fi = (FileInterface) Naming.lookup(name);
        Scanner in = new Scanner(System.in);
        
        while(true) {
        
	        System.out.println("Welcome to the Quiz\npress 1 to play\npress 2 to add a question\npress 3 to remove a question");
	        int choice = in.nextInt();
	        if (choice == 1) {
	        	
	        	//returns the number of questions
	        	int amount = fi.getQuestionAmount();
	        	//runs through each question
		        for(int i=0;i<amount;i++) {
		        	System.out.println(fi.getQuestion(i));
		        	System.out.println(fi.getAnswers(i));
		        	String ans = in.next();
		        	System.out.println(fi.checkAnswer(ans, i));
		        }
		        
		        //returns the score
		        System.out.println("Your score is "+fi.showScore()+"/"+amount);
	        }
	        else if (choice == 2) {
	        	in.nextLine();
	        	System.out.println("Enter your question");             //asks the user to enter their question
	        	String question = in.nextLine();
	        	
	        	
	        	System.out.println("Enter your answers");  				//asks them to enter each option
	        	System.out.println("(a) ");
	        	String a = in.nextLine();
	
	        	System.out.println("(b) ");
	        	String b = in.nextLine();
	
	        	System.out.println("(c) ");
	        	String c = in.nextLine();
	        	
	        	System.out.println("(d) ");
	        	String d = in.nextLine();
	        	
	        	//combines each of the answers for the array list
	        	String answer = "(a) "+a+"\n(b) "+b+"\n(c) "+c+"\n(d) "+d;
	        	
	        	//asks the user which option is the correct one
	        	System.out.println("Which one is the correct answer (just write the letter)");
	        	String correct = in.next();
	        	
	        	//sends all the info to the server to add it to the array list
	        	System.out.println(fi.addQuestions(question, answer, correct));
	        	
	        	System.out.println(fi.getQuestionList());
	        
	        }
	        else if(choice == 3) {
	        	//removes the last question in the arraylist
	        	fi.removeQuestion();
	        	//returns all the questions 
	        	System.out.println(fi.getQuestionList());
	        }
        
        }
        
      } catch (Exception e) {
          System.out.println("did not work!");
      }

      
   }
}