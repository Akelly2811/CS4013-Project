import java.io.IOException;
public class projectSimulation
{ 
   public static void main(String[] args) throws IOException
   {
	   propertySystem machine = new propertySystem();
	   commandline2 menu = new commandline2(1);
	   menu.run(machine);
  }
}