package project;
/**
 * runs the commandline.
 *
 * 
 */
import java.io.IOException;
public class projectSimulation
{ 
   public static void main(String[] args) throws IOException
   {
	   propertySystem machine = new propertySystem();
	   commandline menu = new commandline(1);
	   menu.run(machine);
  }
}