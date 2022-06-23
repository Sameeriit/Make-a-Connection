package com.sameer;


import java.io.*;
import java.net.*;


public class ServerCode {

    String[] adviceList = {"Take smaller bites","Go for the tight jeans. "};
     public void go(){

         try {
             ServerSocket serverSock = new ServerSocket(4242);

             /**The server goes to permanent loop
             waiting for (and servicing ) client requests
              */
             while(true) {

                 Socket sock = serverSock.accept();

                 PrintWriter writer = new PrintWriter(sock.getOutputStream());
                 String advice = getAdvice();
                 writer.println(advice);
                 writer.close();
                 System.out.println(advice);

             }
         } catch (IOException ex) {
             ex.printStackTrace();
         }

     } //close go
     private String getAdvice() {
         int random = (int) (Math.random() * adviceList.length);
         return adviceList[random];
     }

    public static void main(String[] args) {
         ServerCode server = new ServerCode();
         server.go();



    }
}
