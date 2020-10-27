//package Server;

import java.io.*;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.rmi.registry.*;
import java.rmi.server.RemoteServer;

public class FileImpl implements FileInterface {

    ArrayList<String> Questions = new ArrayList<>(Arrays.asList("What is the capital of Canada?", 
                            "What lake is under Toronto?", 
                            "What is the largest continent on Earth?",                     
                            "Which African nation has the most pyramids?", 
                            "What is the name of this university?",
                            "What is the 4th planet from the sun?",
                            "What is Canada's national animal?"));
    
    ArrayList<String> AnswersList = new ArrayList<>(Arrays.asList("(a) Toronto\n(b) Ottowa\n(c) Vancover\n(d) Edmonton\n", 
    		"(a) Lake Ontario\n(b) Lake Erie\n(c) Lake Huron\n(d) Lake Michigen\n", 
    		"(a) North America\n(b) Austrailia\n(c) Europe\n(d) Asia\n",                     
    		"(a) Egypt\n(b) Nigeria\n(c) Ethiopia\n(d) DR Congo\n", 
    		"(a) Ryerson\n(b) MacMaster\n(c) OntarioTech\n(d) Waterloo\n",
    		"(a) Earth\n(b) Mars\n(c) Murcury\n(d) Venus\n",
    		"(a) Eagle\n(b) Bear\n(c) Deer\n(d) Beaver\n"));
    
    ArrayList<String> Answer = new ArrayList<>(Arrays.asList("b","a","d","a","c","b","d"));
    
    
    int index;
    int score = 0;
    
    //String q = "What is the capital of Canada?";
    
    //questions q1 = new questions("What is the capital of Canada?");
    private String name;


    public FileImpl(String s) throws RemoteException{
        super();
        name = s;
    }
    
   //getting questions
    public String getQuestion(int i){
    	String question = Questions.get(i);
        return question;
    }
    
    //get answers
    public String getAnswers(int i) {
    	return AnswersList.get(i);
    }
    
    //check answer
    public String checkAnswer(String answer, int i) {

    	String actualAns = Answer.get(i);
    	if (answer.equals(actualAns)) {
    		this.score += 1;
    		return "Correct!";
    	} else {
    		return "Wrong!";
    	}
    }
    
    //show score
    public int showScore() {
    	int sendScore = this.score;
    	this.score = 0;
    	return sendScore;
    }
    
    public String addQuestions(String question, String answersList, String answer) {
    	Questions.add(question);
    	AnswersList.add(answersList);
    	Answer.add(answer);
    	return "Question added correctly";
    }
    
    public String getQuestionList() {
    	String a = String.join(", ", Questions);
    	return a;
    }
    
    public void removeQuestion() {
    	int tempIndex = Questions.size() - 1;
    	Questions.remove(tempIndex);
    	AnswersList.remove(tempIndex);
    	Answer.remove(tempIndex);
    }
    
    public int getQuestionAmount() {
    	return Questions.size();
    }

}