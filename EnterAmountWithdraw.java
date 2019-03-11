package myatm;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class EnterAmountWithdraw {
    
    Stage stage;
    Scene scene;
    Menu menu;
    AtmLogic authentication;
    EnterAmountWithdraw enterAmount;
   Transaction transaction ;
     String amountEntered;
    
    public EnterAmountWithdraw(Stage stage) {
        this.stage = stage;
        
    }
    public void setTran(Transaction transaction ) {
    	this.transaction=transaction;
    }
     public String getAmountEntered() {
        return amountEntered;
    }
    
     public void setATM(AtmLogic authentication)
     {
    	this.authentication = authentication; 
    	 
     }
    public void prepareScene() {
        
        Label label = new Label("Enter the amount");
        TextField textField = new TextField();
        
        Button oneButton = new Button("1");
        oneButton.setOnAction(click -> {
            String textbutton = textField.getText() + oneButton.getText();
            textField.setText(textbutton);
        });
        Button twoButton = new Button("2");
        twoButton.setOnAction(click -> {
            String textbutton = textField.getText() + twoButton.getText();
            textField.setText(textbutton);
        });
        Button threeButton = new Button("3");
        threeButton.setOnAction(click -> {
            String textbutton = textField.getText() + threeButton.getText();
            textField.setText(textbutton);
        });
        Button fourButton = new Button("4");
        fourButton.setOnAction(click -> {
            String textbutton = textField.getText() + fourButton.getText();
            textField.setText(textbutton);
        });
        Button fiveButton = new Button("5");
        fiveButton.setOnAction(click -> {
            String textbutton = textField.getText() + fiveButton.getText();
            textField.setText(textbutton);
        });
        Button sixButton = new Button("6");
        sixButton.setOnAction(click -> {
            String textbutton = textField.getText() + sixButton.getText();
            textField.setText(textbutton);
        });
        Button sevenButton = new Button("7");
        sevenButton.setOnAction(click -> {
            String textbutton = textField.getText() + sevenButton.getText();
            textField.setText(textbutton);
        });
        Button eightButton = new Button("8");
        eightButton.setOnAction(click -> {
            String textbutton = textField.getText() + eightButton.getText();
            textField.setText(textbutton);
        });
        Button nineButton = new Button("9");
        nineButton.setOnAction(click -> {
            String textbutton = textField.getText() + nineButton.getText();
            textField.setText(textbutton);
        });
        Button zeroButton = new Button("0");
        zeroButton.setOnAction(click -> {
            String textbutton = textField.getText() + zeroButton.getText();
            textField.setText(textbutton);
        });
        Button decimalButton = new Button(".");
        decimalButton.setOnAction(click -> {
            String textbutton = textField.getText() + decimalButton.getText();
            textField.setText(textbutton);
        });
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(30, 30, 30, 30));
        
        grid.setVgap(10);
        grid.setHgap(10);
        
        Label validationLabel = new Label();
        Label validationLabe3 = new Label();
        
        Button submit = new Button("Submit");
        Button backToMeanu = new Button("Back to Menu");
        
        grid.add(textField, 0, 1);
        grid.add(label, 0, 0);
        grid.add(oneButton, 3, 0);
        grid.add(twoButton, 4, 0);
        grid.add(threeButton, 5, 0);
        grid.add(fourButton, 3, 1);
        grid.add(fiveButton, 4, 1);
        grid.add(sixButton, 5, 1);
        grid.add(sevenButton, 3, 2);
        grid.add(eightButton, 4, 2);
        grid.add(nineButton, 5, 2);
        grid.add(zeroButton, 3, 3);
        grid.add(decimalButton, 4, 3);
        grid.add(submit, 5, 3);
        grid.add(validationLabel, 0, 2);
        grid.add(validationLabe3, 1, 2);
        
        grid.add(backToMeanu, 2, 9);
        
        submit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                 amountEntered = textField.getText();
                
                boolean valid = authentication.check(amountEntered);
                if (valid) {
                    authentication.withdraw(amountEntered);
                    validationLabel.setText("Sucess");
                    transaction.transaction(amountEntered, " Withdrawl ");
                } else {
                    validationLabel.setText("You have no Enough money");
                    validationLabe3.setText("");
                }
            }
            
        });
        
        
        backToMeanu.setOnAction(new EventHandler<ActionEvent>() {
            
            public void handle(ActionEvent event) {
                validationLabel.setText("");
                textField.setText("");
                stage.setScene(menu.getScene());
            }
        });
        
        scene = new Scene(grid, 600, 800);
    }

    public Scene getScene() {
        return scene;
    }
    
    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    
}
