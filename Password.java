package myatm;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Password {

    Stage stage;
    Scene scene; 
    AtmLogic authentication = new AtmLogic(); // object to acess AtmLogic 
    Menu menu ;

    public Password(Stage stage) {  // what will create will give u reference
        this.stage = stage;
    }

    public void prepareScene() {  // it just draw its part
        Label passordLabel = new Label("Enter Your Password");
        PasswordField passwordField = new PasswordField();
        Button submit = new Button("Submit");
        Label validationLabel = new Label();
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(60, 60, 60, 60));
        grid.setVgap(10);
        grid.setHgap(10);
        grid.add(passordLabel, 0, 1);
        grid.add(passwordField, 2, 1);
        grid.add(submit, 2, 2);
        grid.add(validationLabel, 3, 1);
        
        submit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                
                String password = passwordField.getText();  // get password from user
                boolean valid = authentication.validate(password); // validates password 
                if (valid) {
                    stage.setScene(menu.getScene()); // will go to the menu
                } else {

                    validationLabel.setText("Error"); 
                    validationLabel.setFont(Font.font("Verdana", 25));
                }
            }
        });
        scene = new Scene(grid, 600, 400);
    }

    public Scene getScene() { // to call it in main gui 
        return this.scene;
    }

    public void setMenu(Menu menu) {  // to call it in the main gui
        this.menu = menu;
    }
}
