package main.View;

import main.Controller.GameController;
import main.Model.Board;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

import main.Controller.GameController;
import main.Controller.PrimaryController;
import main.Model.Board;

public class GameInitiator implements Serializable {

   public static void main(String args[]) {  
	   
	   SaveLoadGui slg = new SaveLoadGui();
	   slg.initialWindow();
       

   }
   


}