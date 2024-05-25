import java.util.Scanner;
// Roghly planning on how to approach a chat bot for now 
// will Add more functionality to this eventually 
// Open to contribution, ideas and collaborations 
public class ChatBot {
  public void main ( String [] args){
    Scanner scanner = new Scanner(System.in);

        System.out.println("Hello! I'm your friendly chatbot. How can I help you today?");

        while (true) {
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("hello")) {
                System.out.println("Hi again! What would you like to talk about?");
            } else if (userInput.equalsIgnoreCase("goodbye")) {
                System.out.println("It was nice chatting with you. Have a good day!");
                break;
            } else {
                System.out.println("Sorry, I'm still under development. What else can I help you with?");
            }
        }

        scanner.close();
  }
}
