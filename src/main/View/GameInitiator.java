package main.View;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

import main.Controller.GameController;
import main.Controller.PrimaryController;
import main.Model.Board;

public class GameInitiator implements Serializable {

   
   // The very first method to be called
   // This method constructs a GameController object and calls its control method 
   public static void main(String args[])
   {
	   
	   
	   SaveLoadGui slg = new SaveLoadGui();
	   slg.initialWindow();
       

   }
   
   
   


}