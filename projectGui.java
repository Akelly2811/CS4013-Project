package project;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.paint.Color; 
import javafx.stage.Stage;  
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class projectGui extends Application { 
   @Override     
   public void start(Stage primaryStage) throws Exception {            
      //creating a Group object 
      Group group = new Group(); 
      
      //drop down
      ComboBox comboBox_0 = new ComboBox();
      
      //TextFieldsText
      TextField propertyText = new TextField();
      propertyText.setText("Property:");
      propertyText.setPrefSize(100, 10);
      propertyText.setLayoutX(20);
      propertyText.setLayoutY(100);
      propertyText.setEditable(false);
      TextField propertyOwnerText = new TextField();
      propertyOwnerText.setText("PropertyOwner:");
      propertyOwnerText.setPrefSize(100, 10);
      propertyOwnerText.setLayoutX(20);
      propertyOwnerText.setLayoutY(150);
      propertyOwnerText.setEditable(false);
      TextField yearText = new TextField();
      yearText.setText("Year:");
      yearText.setPrefSize(100, 10);
      yearText.setLayoutX(20);
      yearText.setLayoutY(250);
      yearText.setEditable(false);
      TextField eircodeText = new TextField();
      eircodeText.setText("Eircode:");
      eircodeText.setPrefSize(100, 10);
      eircodeText.setLayoutX(20);
      eircodeText.setLayoutY(300);
      eircodeText.setEditable(false);
      TextField areaText = new TextField();
      areaText.setText("Area:");
      areaText.setPrefSize(100, 10);
      areaText.setLayoutX(20);
      areaText.setLayoutY(400);
      areaText.setEditable(false);
      TextField routingKeyText = new TextField();
      routingKeyText.setText("Routing Key:");
      routingKeyText.setPrefSize(100, 10);
      routingKeyText.setLayoutX(20);
      routingKeyText.setLayoutY(450);
      routingKeyText.setEditable(false);
      
      //TextFields
      TextField property = new TextField();
      property.setPromptText("Property");
      property.setEditable(true);
      property.setLayoutX(140);
      property.setLayoutY(100);
      TextField propertyOwner = new TextField();
      propertyOwner.setPromptText("PropertyOwner");
      propertyOwner.setEditable(true);
      propertyOwner.setLayoutX(140);
      propertyOwner.setLayoutY(150);
      TextField year = new TextField();
      year.setPromptText("year");
      year.setEditable(true);
      year.setLayoutX(140);
      year.setLayoutY(250);
      TextField eircode = new TextField();
      eircode.setPromptText("eircode");
      eircode.setEditable(true);
      eircode.setLayoutX(140);
      eircode.setLayoutY(300);
      TextField area = new TextField();
      area.setPromptText("area");
      area.setEditable(true);
      area.setLayoutX(140);
      area.setLayoutY(400);
      TextField routingKey = new TextField();
      routingKey.setPromptText("routingKey");
      routingKey.setEditable(true);
      routingKey.setLayoutX(140);
      routingKey.setLayoutY(450);
      /*CheckBox routingKey = new CheckBox();
      routingKey.setLayoutX(120);
      routingKey.setLayoutY(453);*/
      
      group = new Group(propertyText, propertyOwnerText, yearText, eircodeText, areaText, routingKeyText, property, propertyOwner, year, eircode, area, routingKey);  
      
      //Creating a Scene by passing the group object, height and width   
      Scene scene = new Scene(group ,1500,800);
      
      //setting colour to the scene 
      scene.setFill(Color.GREY);  
      
      //Setting the title to Stage. 
      primaryStage.setTitle("ProjectGUI"); 
   
      //Adding the scene to Stage 
      primaryStage.setScene(scene); 
      
      //Displaying the contents of the stage 
      primaryStage.show(); 
   }    
   public static void main(String args[]){          
      launch(args);     
   }         
} 