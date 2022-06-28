package com.sameer;


/** i'm implementing socket programming in java
 * author : sameer ahmad
 * date   : 25-07-2021
 */




import java.io.*;
import java.net.*;  // class socket is in java.net

public class clientCode {

    public void go() {
        // a lot can go wrong here
        try {
        /**
           make a socket connection to whatever is running on port 4242,
            on the same host this code is running on(the localhost)

         */
            Socket S = new Socket("127.0.0.1" , 4242);

            InputStreamReader streamReader = new InputStreamReader(S.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);


            String advice = reader.readLine();
            System.out.println("today you should: " + advice);


            reader.close();    // this close all the streams

        }  catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args){
        clientCode client = new clientCode();
        client.go();
    }
}



