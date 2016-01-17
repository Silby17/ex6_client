/****************************************
 * Yossi Silberhaft & Nava Shemoul		*
 * Exercise 6							*
 * File: ServerInfo.java    	        *
 ****************************************/
package sample;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ServerInfo {
    //Deceleration of variables
    private String ipAddress;
    private int port;
    private Socket socket;

    //Constructor method
    public ServerInfo(){

    }

    //Sets the port number
    public void setPort(int port){
        this.port = port;
    }

    //Returns the port number
    public int getPort(){
        return this.port;
    }

    //Sets the socket
    public void setSocket(Socket sock){
        this.socket = sock;
    }

    //Returns the socket
    public Socket getSocket(){
        return this.socket;
    }

    //Sets the IP Address
    public void setIp(String ip){
        this.ipAddress = ip;
    }


    //Returns the IP address
    public String getIpAddress(){
        return this.ipAddress;
    }

    //Opens the socket
    public void openSocket() throws  IOException{
        //If the socket is different from NULL
        if(socket != null){
                //Close the socket
                this.socket.close();
        }
        //Create a new socket
        try{
            this.socket = new Socket(this.ipAddress, this.port);

        }catch (IOException e){
            e.printStackTrace();
        }
    }


    //This will send and receive information from the TCP server
    public String transactions(StringBuilder sb) throws IOException {
        //Deceleration of variables
        PrintWriter out = null;
        BufferedReader in = null;
        String received;
        String send;

        try{
            //Creates a new Buffered reader
            in = new BufferedReader(new InputStreamReader(
                    this.socket.getInputStream()));
            //Creates a new PrintWriter
            out = new PrintWriter(this.socket.getOutputStream(), true);

        }catch (IOException e){
            e.printStackTrace();
        }

        send = sb.toString();
        char[] rec = send.toCharArray();

        out.println(rec);
        char[] fromServerArr = new char[1024];
        in.read(fromServerArr);
        received = new String(fromServerArr);

        return received;
    }
}