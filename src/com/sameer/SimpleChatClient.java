package com.sameer;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleChatClient {
    JTextField outgoing;
    PrintWriter writer;
    Socket sock;
    public void go(){  // make GUI and register a listener with the send button
                       // call the setUpNetworking() method
        JFrame frame = new JFrame("Simple chat client");
        JPanel mainPanel= new JPanel();
        outgoing = new JTextField(20);
        JButton sendButton = new JButton("send");
        sendButton.addActionListener(new SendButtonListener());
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);
        frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
        setUpNetworking();
        frame.setSize(400,500);
        frame.setVisible(true);

    }
    private void setUpNetworking(){ // make a socket, then make a printWriter
                                    // assign the printWriter to writer instance variable
        try{
            sock= new Socket("127.0.0.1",4242);
            writer = new PrintWriter(sock.getOutputStream());

        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public class SendButtonListener implements ActionListener{  // get the Text from the text field and send it
                                                                 //to the server using the writer(PrintWriter)
        public void actionPerformed(ActionEvent ev){
            try{
                writer.println(outgoing.getText());
                writer.flush();
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
            outgoing.setText("");
            outgoing.requestFocus();
        }  // close sendButtonListener inner class
    }
    public static void main (String[]args){
        new SimpleChatClient().go();
    }
} // close outer class
