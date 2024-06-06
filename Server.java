import java.io.*;
import java.net.*;
class Server {
     
    ServerSocket server;
    Socket socket;

    // how to read and write data 
    BufferedReader br;
    PrintWriter msgOut;

    public Server(){
        try {
            server = new ServerSocket(7777);
            System.out.println("Server is ready to accept connection ...");
            System.out.println("Waiting...");
            socket = server.accept();
            
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            msgOut = new PrintWriter(socket.getOutputStream());

            startReading();
            startWriting();

        } catch (Exception e) {
            System.out.println("port error on the server socket");
            e.printStackTrace();
        }

    }

    public void startReading(){

        System.out.println("Reading data from Client .. ");
         
        Runnable r1 = ()->{
            System.out.println("Reader started ...");
            // Lets run a loop to accept all incoming messages from the client until the client inputs 'EXIT'
            while(true){
              try {
                String msg=br.readLine();
                if(msg.equals("EXIT")||msg.equals("exit")||msg.equals("Exit")){
                    System.out.println("Client has now terminated the chat ... ");
                    break;
                }
                //Printing message from client on server end 
                System.out.println("Client: "+msg);

              } catch (Exception e) {
                System.out.println("error while reading .. ");
                e.printStackTrace();
              }  
            
            }
        };
        new Thread(r1).start();
    }

    public void startWriting(){
        System.out.println("Taking data from user on server end and writing to client ...");
        Runnable r2 = ()->{
            System.out.println("Writing data to client from server ");

            while(true){
                try {
                    
                    BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
                    String content = br2.readLine();
                    msgOut.println(content);
                    msgOut.flush();

                } catch (Exception e) {
                    System.out.println("error while writing data on server end to cleint end");
                    e.printStackTrace();
                }
            }
        };
        new Thread(r2).start();
    }

    
    public static void main(String[] args) {
        System.out.println("This is server ... starting server now ...");
        new Server();

    }
}