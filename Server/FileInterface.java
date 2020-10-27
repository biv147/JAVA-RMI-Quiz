//package Server;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FileInterface extends Remote {
    public String getQuestion(int i) throws RemoteException;
    public String checkAnswer(String answer, int i) throws RemoteException;
    public int showScore() throws RemoteException;
    public String getAnswers(int i) throws RemoteException;
    public String addQuestions(String question, String answersList, String answer) throws RemoteException;
    public String getQuestionList() throws RemoteException;
    public void removeQuestion() throws RemoteException;
    public int getQuestionAmount() throws RemoteException;
}