package project;

import java.io.IOException;

import Week7.VendingMachine;
import Week7.VendingMachineMenu;

/**
   This program simulates a vending machine.
*/
public class projectSimulation
{ 
   public static void main(String[] args)
         throws IOException
   { 
      Property machine = new Property("address", "postcode", 100.00, "location", "private residence", "owners");
      commandline menu = new commandline(1);
      menu.run(machine);
  }
}