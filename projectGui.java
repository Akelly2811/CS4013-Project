

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.paint.Color; 
import javafx.stage.Stage;  
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
* Project GUI.
*/

public class projectGui extends Application { 
   String helpStr = "Please Login \n admin user requires name to be admin and password is 1234";
   boolean admin = false;
   LocalDate myObj = LocalDate.now();
   static ArrayList<Property> propertyList = new ArrayList<Property>();
   ArrayList<propertyTax> propertyTax = new ArrayList<propertyTax>();
   ArrayList<Property> temp = new ArrayList<Property>();
   String outputStr = "";
   Property property;
   /**
   * imports the properies
   */
   public void LoadProperties() throws IOException
   {
   	File Input = new File("Properties.txt");
   	Scanner in = new Scanner(Input);
   	while(in.hasNextLine())
   	{
   		String x = in.nextLine();
   		String[] split = x.split(",");
   		double y = Double.parseDouble(split[3]);
   		int i = Integer.parseInt(split[6]);
   		propertyList.add(new Property(split[1], split[2], y, split[4], split[5], split[0]));
   		propertyTax.add(new propertyTax());
   	}
   		in.close();
   }
   /**
   * holds the gui data
   */
   public void start(Stage primaryStage) throws Exception {            
      //creating a Group object 
      Pane group = new Pane(); 
      
      //drop down
      ComboBox comboBox_0 = new ComboBox();
      comboBox_0.setLayoutX(100);
      comboBox_0.setLayoutY(150);
      
      comboBox_0.getItems().add("get property tax");
      comboBox_0.getItems().add("overdue payments");
      comboBox_0.getItems().add("Area pay statistics");
      comboBox_0.getItems().add("enter a different rate");
      
      ComboBox comboBox_1 = new ComboBox();
      comboBox_1.setLayoutX(100);
      comboBox_1.setLayoutY(150);
      
      comboBox_1.getItems().add("make payment");
      comboBox_1.getItems().add("add property");
      comboBox_1.getItems().add("my payments");
      comboBox_1.getItems().add("property payments");
      
      //TextFields for login
      TextField nameTxt = new TextField();
      nameTxt.setText("Name:");
      nameTxt.setPrefSize(100, 10);
      nameTxt.setLayoutX(5);
      nameTxt.setLayoutY(50);
      nameTxt.setEditable(false);
      TextField passwordTxt = new TextField();
      passwordTxt.setText("Password:");
      passwordTxt.setPrefSize(100, 10);
      passwordTxt.setLayoutX(300);
      passwordTxt.setLayoutY(50);
      passwordTxt.setEditable(false);
      TextField name = new TextField();
      name.setPromptText("name");
      name.setPrefSize(100, 10);
      name.setLayoutX(150);
      name.setLayoutY(50);
      name.setEditable(true);
      TextField password = new TextField();
      password.setPromptText("password");
      password.setPrefSize(100, 10);
      password.setLayoutX(450);
      password.setLayoutY(50);
      password.setEditable(true);
      
      //checkbox for private residence
      CheckBox check = new CheckBox();
      check.setLayoutX(220);
      check.setLayoutY(400);
      
      //TextFields for input names
      TextField Txt1 = new TextField();
      Txt1.setPrefSize(100, 10);
      Txt1.setLayoutX(100);
      Txt1.setLayoutY(200);
      Txt1.setEditable(false);
      TextField Txt2 = new TextField();
      Txt2.setPrefSize(100, 10);
      Txt2.setLayoutX(100);
      Txt2.setLayoutY(250);
      Txt2.setEditable(false);
      TextField Txt3 = new TextField();
      Txt3.setPrefSize(100, 10);
      Txt3.setLayoutX(100);
      Txt3.setLayoutY(300);
      Txt3.setEditable(false);
      TextField Txt4 = new TextField();
      Txt4.setPrefSize(100, 10);
      Txt4.setLayoutX(100);
      Txt4.setLayoutY(350);
      Txt4.setEditable(false);
      TextField Txt5 = new TextField();
      Txt5.setPrefSize(100, 10);
      Txt5.setLayoutX(100);
      Txt5.setLayoutY(400);
      Txt5.setEditable(false);
      TextField Txt6 = new TextField();
      Txt6.setPrefSize(100, 10);
      Txt6.setLayoutX(100);
      Txt6.setLayoutY(450);
      Txt6.setEditable(false);
      
      //TextFields for input
      TextField Txt1In = new TextField();
      Txt1In.setPrefSize(100, 10);
      Txt1In.setLayoutX(220);
      Txt1In.setLayoutY(200);
      Txt1In.setEditable(true);
      TextField Txt2In = new TextField();
      Txt2In.setPrefSize(100, 10);
      Txt2In.setLayoutX(220);
      Txt2In.setLayoutY(250);
      Txt2In.setEditable(true);
      TextField Txt3In = new TextField();
      Txt3In.setPrefSize(100, 10);
      Txt3In.setLayoutX(220);
      Txt3In.setLayoutY(300);
      Txt3In.setEditable(true);
      TextField Txt4In = new TextField();
      Txt4In.setPrefSize(100, 10);
      Txt4In.setLayoutX(220);
      Txt4In.setLayoutY(350);
      Txt4In.setEditable(true);
      TextField Txt5In = new TextField();
      Txt5In.setPrefSize(100, 10);
      Txt5In.setLayoutX(220);
      Txt5In.setLayoutY(450);
      Txt5In.setEditable(true);
      
      //output TextArea
      TextArea output = new TextArea();
      output.setText(outputStr);
      output.setEditable(false);
      output.setPrefSize(500, 400);
      output.setLayoutX(700);
      output.setLayoutY(100);
      
      //help TextArea
      TextArea help = new TextArea();
      help.setText(helpStr);
      help.setEditable(false);
      help.setPrefSize(400, 20);
      help.setLayoutX(700);
      help.setLayoutY(50);
      
      Button buttonDone = new Button("Done");
      buttonDone.setLayoutX(400);
      buttonDone.setLayoutY(250);
      buttonDone.setPrefSize(100, 50);
      
      Button buttonLogin = new Button("Login");
      buttonLogin.setLayoutX(560);
      buttonLogin.setLayoutY(50);
      buttonLogin.setPrefSize(100, 20);
      
      Button buttonClear = new Button("Clear");
      buttonClear.setLayoutX(550);
      buttonClear.setLayoutY(250);
      buttonClear.setPrefSize(100, 50);
      
      Button buttonSelect = new Button("Select");
      buttonSelect.setLayoutX(300);
      buttonSelect.setLayoutY(150);
      buttonSelect.setPrefSize(100, 20);
      
      	/**
      	* Login Button
      	*/
      	buttonLogin.setOnAction( new EventHandler<ActionEvent>() {
    	    public void handle(ActionEvent event2) {
    	    	String nameOut = "";
    	    	nameOut = name.getText();
    	    	String passwordOut = "";
    	    	passwordOut = password.getText();
    	    	login loggedIn = new login(nameOut, passwordOut);
    	    	if(nameOut.equals("") || passwordOut.equals("")) {
    	    		help.setText("YOU NEED TO LOGIN");
    	    	}else {
    	    		if(loggedIn.getName().toUpperCase().equals("ADMIN") && loggedIn.getPassword().equals("1234")) {
    	    			help.setText("logged in as admin");
    	    			admin = true;
    	    			group.getChildren().removeAll(comboBox_1, buttonDone, buttonClear, buttonSelect);
    	    			group.getChildren().addAll(comboBox_0, buttonDone, buttonClear, buttonSelect);
    	    		}else {
    	    			help.setText("logged in as user");
    	    			group.getChildren().removeAll(comboBox_0, buttonDone, buttonClear, buttonSelect);
    	    			group.getChildren().addAll(comboBox_1, buttonDone, buttonClear, buttonSelect);
    	    		}
    	    	}
    	    	System.out.println(helpStr);
    	    }
      	});
      
      	/**
  		* Select Button
      	*/
      	buttonSelect.setOnAction( new EventHandler<ActionEvent>() {
      	    public void handle(ActionEvent event) {
      	        output.setText(outputStr);
      	        String back = "";
      	        System.out.println(outputStr);
      	        if(admin == true) {
      	        	String comboBox = (String) comboBox_0.getValue();
      	        	if(comboBox.toLowerCase().equals("get property tax")) {
      	        		Txt1.setText("Property/Owner:");
      	        		Txt1In.setPromptText("property/owner");
      	        		group.getChildren().addAll(Txt1,Txt1In);
      	        	}else if(comboBox.toLowerCase().equals("overdue payments")) {
      	        		Txt1.setText("Eircode:");
      	        		Txt1In.setPromptText("Eircode");
      	        		group.getChildren().addAll(Txt1,Txt1In);
      	        	}else if(comboBox.toLowerCase().equals("area pay statistics")) {
      	        		Txt1.setText("Routing Key:");
      	        		Txt1In.setPromptText("routing key");
      	        		group.getChildren().addAll(Txt1,Txt1In);
      	        	}else if(comboBox.toLowerCase().equals("enter a different rate")) { //double tax, double rate,double locationTax,double notPrinciple,double penalty
      	        		Txt1.setText("Rate:");
      	        		Txt1In.setPromptText("rate");
      	        		group.getChildren().addAll(Txt1,Txt1In);
      	        	}
      	        }else {
      	        	String comboBox = (String) comboBox_1.getValue();
      	        	if(comboBox.toLowerCase().equals("make payment")) {
      	        		Txt1.setText("Address:");
      	        		Txt2.setText("Amount:");
      	        		Txt1In.setPromptText("address");
      	        		Txt2In.setPromptText("amount");
      	        		group.getChildren().addAll(Txt1, Txt2, Txt1In, Txt2In);
      	        	}else if(comboBox.toLowerCase().equals("add property")) {
      	        		Txt1.setText("Address:");
      	        		Txt2.setText("Postcode:");
      	        		Txt3.setText("Est. Market Val:");
      	        		Txt4.setText("Location:");
      	        		Txt5.setText("Private Residence?");
      	        		Txt6.setText("owner(s):");
      	        		Txt1In.setPromptText("address");
      	        		Txt2In.setPromptText("postcode");
      	        		Txt3In.setPromptText("est. market val");
      	        		Txt4In.setPromptText("location");
      	        		Txt5In.setPromptText("owner(s)");
      	        		group.getChildren().addAll(Txt1, Txt2, Txt3, Txt4, Txt5, Txt6, Txt1In, Txt2In, Txt3In, Txt4In, Txt5In, check);
      	        	}else if(comboBox.toLowerCase().equals("my payments")) {
      	        		group.getChildren().removeAll(Txt1, Txt2, Txt3, Txt4, Txt5, Txt6, Txt1In, Txt2In, Txt3In, Txt4In, Txt5In, check);
      	        	}else if(comboBox.toLowerCase().equals("property payments")) {
      	        		String payments = "";
      	        		Txt1.setText("Address:");
      	        		Txt2.setText("Postcode:");
      	        		Txt1In.setPromptText("address");
      	        		Txt2In.setPromptText("postcode");
      	        		group.getChildren().addAll(Txt1, Txt2, Txt1In, Txt2In);
      	        	}
      	        }
      	    } 
      	});
      	
      	/**
  		* Processes values
      	*/
      	buttonDone.setOnAction( new EventHandler<ActionEvent>() {
      	    public void handle(ActionEvent event4) {
      	    	if(admin == true) {
      	        	String comboBox = (String) comboBox_0.getValue();
      	        	if(comboBox.toLowerCase().equals("get property tax")) {
      	        		ArrayList<Property> array = propertyList;
      	        		ArrayList<String> owners = new ArrayList<>();
      	        		String payments = "";
      	        		for(int i = 0; i < array.size(); i++) {
      	        			String add = array.get(i).getAddress();
      	        			owners = array.get(i).getOwnerArray();
      	        			if(add.equals(Txt1In.getText()) || owners.contains(Txt1In.getText())) {
      	        				payments = propertyTax.get(i).toString();
      	        			}
      	        		}
      	        		output.setText(payments);
      	        	}else if(comboBox.toLowerCase().equals("overdue payments")) {
      	        		ArrayList<String> overduePay = new ArrayList<>();
      	        		ArrayList<String> propertyListOverdue = new ArrayList<>();
      	        		for(int i = 0; i < temp.size(); i++) {
      	        			if(temp.get(i).getPayments().get(i).isDue() == true && Txt1In.getText().equals(propertyList.get(i).getPostcode())) {
      	        				overduePay.add("Due");
      	        				propertyListOverdue.add(propertyList.get(i).getPostcode());
      	        			}
      	        		}
      	        		String overdue = "";
      	        		for (int i = 0; i < overduePay.size(); i++) {
      	        			overdue = overdue + propertyListOverdue.get(i) + "|" + overduePay.get(i);
      	        		}
      	        		output.setText(overdue);
      	        	}else if(comboBox.toLowerCase().equals("area pay statistics")) {
      	        		String back = areaPayStatistics(Txt1In.getText());
      	        		output.setText(back);
      	        	}else if(comboBox.toLowerCase().equals("enter a different rate")) {
      	        		//compare old tax with new tax
      	        	}
      	        }else {
      	        	String comboBox = (String) comboBox_1.getValue();
      	        	if(comboBox.toLowerCase().equals("make payment")) {
      	        		String address = Txt1In.getText();
      	        		String amount = Txt2In.getText();
      	        		double amountDob = Double.parseDouble(amount);
      	        		property.pay(amountDob, address);
      	        		help.setText("made payment");
      	        	}else if(comboBox.toLowerCase().equals("add property")) {
      	        		String check1 = "";
      	        		if(check.isSelected()) {
      	        			check1 = "yes";
      	        		}else {
      	        			check1 = "no";
      	        		}
      	        		double ammount = Double.parseDouble(Txt3In.getText());
      	        		property = new Property(Txt1In.getText(), Txt2In.getText(), ammount, Txt4In.getText(), check1, Txt5In.getText());
      	        		propertyTax tax = new propertyTax();
      	        		propertyList.add(property);
      	        		propertyTax.add(tax);
      	        		help.setText("added a property and added tax");
      	        	}else if(comboBox.toLowerCase().equals("my payments")) {
      	        		ArrayList<Property> array = propertyList;
      	        		String payments = "";
      	        		for(int i = 0; i < array.size(); i++) {
      	        			ArrayList<String> prop = array.get(i).getOwnerArray();
      	        			if(prop.contains(name.getText())) {
      	        				payments = "Payments: \n" + array.get(i).paymentsToString();
      	        			}
      	        		}
      	        		output.setText(payments);
      	        	}else if(comboBox.toLowerCase().equals("property payments")) {
      	        		ArrayList<Property> array = propertyList;
      	        		String payments = "";
      	        		for(int i = 0; i < array.size(); i++) {
      	        			String add = array.get(i).getAddress();
      	        			String post = array.get(i).getPostcode();
      	        			if(add.equals(Txt1In.getText()) || post.equals(Txt2In.getText())) {
      	        				payments = "Payments: \n" + array.get(i).paymentsToString();
      	        			}
      	        		}
      	        		output.setText(payments);
      	        	}
      	        }
      	    }
      	});
      	
      	/**
  		* Clears the TextFields
      	*/
      	buttonClear.setOnAction( new EventHandler<ActionEvent>() {
      	    public void handle(ActionEvent event3) {
      	    	group.getChildren().removeAll(Txt1, Txt2, Txt3, Txt4, Txt5, Txt6, Txt1In, Txt2In, Txt3In, Txt4In, Txt5In, check);
      	    }
      	});
      	
      	group.getChildren().addAll(name, password , passwordTxt, nameTxt, buttonLogin, output, help);
      
      	//Creating a Scene by passing the group object, height and width   
      	Scene scene = new Scene(group ,1500,800);
      
      	//setting colour to the scene 
      	scene.setFill(Color.YELLOW);  
      
      	//Setting the title to Stage. 
      	primaryStage.setTitle("ProjectGUI"); 
   
      	//Adding the scene to Stage 
      	primaryStage.setScene(scene); 
      
      	//Displaying the contents of the stage 
      	primaryStage.show(); 
   }
   /**
	* returns payments for properties
 	*/
   public String getPropertyPayments(String property){
   		ArrayList<Payment> pay = new ArrayList<>();
   		String back = "";
   		for (Property p : propertyList){
   			if ((p.address.equals(property)) || (p.postcode.equals(property))){
   				pay = p.payments;
   				back = back + "|" + pay.toString();
   			}
   		}
   		return back;
   }
   /**
    * returns payments for owners
 	*/
   public String getOwnerPayments(String owner){
	   	ArrayList<Payment> pay = new ArrayList<>();
   		String back = "";
   		for (Property p : propertyList){
   			if (p.owners.contains(owner)){
   				pay = p.payments;
   				back = back + "|" + pay.toString();
   			}
   		}
   		return back;
   }
   /**
   * returns payments based of postcode
	*/
   public String areaPayStatistics(String code){
	   ArrayList<Property> stats = new ArrayList<>();
	   String statsStr = "";
	    for (Property p : propertyList){
	    	if(code.equals((p.postcode).substring(0,3))){
	    		stats.add(p);
	    		for(int i = 0; i < stats.size(); i++) {
	    			statsStr = statsStr + stats.get(i).paymentsToString();
	    		}
	    	}
	    }
	    return statsStr;
   }
   /**
   * tests a different rate of tax
	*/
   public void testTaxChange(double tax, double rate,double locationTax,double notPrinciple,double penalty){ 
   		propertyTax temp = new propertyTax(tax,rate,locationTax,notPrinciple,penalty);
   }
   /**
   * launches the GUI.
	*/
   public static void main(String args[]){          
	   launch(args);     
   }         
} 