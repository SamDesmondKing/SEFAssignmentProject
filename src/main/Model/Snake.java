package main;

public class Snake extends Entity
{
   private int head;
   private int tail;
   
   public Snake(int h, int t) {
       head = h;
       tail = t;
   }
   
   //Moves HumanPiece from head to tail
   public boolean activate(Entity HumanPiece) {
	   return true;
   }
   
   //Moves snake from location to target, checks tail does not move below location 0.
   public boolean move(int target) {
	   return true;
   }
   
   public int getHead() { 
	   return head; 
   }
   
   public int getTail() { 
	   return tail; 
   } 
}
