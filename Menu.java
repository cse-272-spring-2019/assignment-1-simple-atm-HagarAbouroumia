package myatm;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Menu extends AtmLogic {

    Stage stage;
    Scene scene;
    Password createATM; //reference to createatm
    AtmLogic authentication = new AtmLogic();
    EnterAmountWithdraw enterAmount;
    EnterAmountDeposite enterAmountDeposit;
    Transaction transaction = new Transaction(); // object from transaction
    int index = 4; // for the array
    //Transaction transaction = new Transaction();

    public Menu(Stage stage) {
        this.stage = stage;
    }

    public void prepareScene() {
        Label labe1 = new Label();
        Label labe2 = new Label();
        VBox vb = new VBox(25);
        vb.setPadding(new Insets(30, 30, 30, 30));
        StackPane stack = new StackPane();
        stack.getChildren().add(vb);
        vb.setAlignment(Pos.CENTER);
        Button withdrawButton = new Button();
        withdrawButton.setText("Withdraw");
        vb.getChildren().add(withdrawButton);
        Button depositButton = new Button();
        depositButton.setText("Deposit");
        vb.getChildren().add(depositButton);
        Button balanceButton = new Button();
        balanceButton.setText("Balance Inquiriy");
        vb.getChildren().add(balanceButton);
        Button prevButton = new Button();
        prevButton.setText("Previous");
        vb.getChildren().add(prevButton);
        Button nextButton = new Button();
        nextButton.setText("Next");
        vb.getChildren().add(nextButton);
      

        balanceButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                vb.getChildren().remove(labe1); // so it will rewrite
                vb.getChildren().remove(labe2);
                vb.getChildren().add(labe1);
                vb.getChildren().add(labe2);
                labe1.setText("Your Balance");
                labe2.setText(authentication.getCurrentBalance());
                transaction.transaction(authentication.getCurrentBalance(), " Balance Inquiry ");
            }
        }
        );

        withdrawButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                vb.getChildren().remove(labe1);
                vb.getChildren().remove(labe2);
                enterAmount.setATM(authentication); // to use it in eneteramount withdraw
                enterAmount.setTran(transaction);
                stage.setScene(enterAmount.getScene());

            }
        });
        depositButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                vb.getChildren().remove(labe1);
                vb.getChildren().remove(labe2);
                enterAmountDeposit.setAtm(authentication);
                enterAmountDeposit.setTran(transaction);
                stage.setScene(enterAmountDeposit.getScene());
            }
        });
        prevButton.setOnAction(new EventHandler<ActionEvent>() { // HERE IS THE CLASS SO IT WORKS HERE 
            public void handle(ActionEvent event) {
                vb.getChildren().remove(labe1);
                vb.getChildren().remove(labe2);
                vb.getChildren().add(labe1);
                if (index == 0) {
                    return;
                }
                index--;
                labe1.setText(transaction.getTrans(index));
            }
        });

        nextButton.setOnAction(new EventHandler<ActionEvent>() { // HERE IS THE CLASS SO IT WORKS HERE 
            public void handle(ActionEvent event) {
                vb.getChildren().remove(labe1);
                vb.getChildren().remove(labe2);
                vb.getChildren().add(labe1);
                if (index == 4) {
                    return;
                }
                index++;
                labe1.setText(transaction.getTrans(index));
            }
        });

        scene = new Scene(stack, 600, 400);
    }

    public AtmLogic getAuthentication() {
        return authentication;
    }

    public Scene getScene() {
        return scene;
    }

    public void setAuthentication(AtmLogic authentication) {
        this.authentication = authentication;
    }

    public void setEnterAmount(EnterAmountWithdraw enterAmount) {
        this.enterAmount = enterAmount;
    }

    public void setEnterAmountDeposit(EnterAmountDeposite enterAmountDeposit) {
        this.enterAmountDeposit = enterAmountDeposit;
    }

}
