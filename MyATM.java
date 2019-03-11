package myatm;

import javafx.application.Application;

import javafx.stage.Stage;

public class MyATM extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception { //stage sets the scene 
        primaryStage.setTitle("ATM Application");
        Password createatm = new Password(primaryStage); // doing a class calling it
        Menu menu = new Menu(primaryStage); //calling it 
        EnterAmountWithdraw enterAmount = new EnterAmountWithdraw(primaryStage);
        EnterAmountDeposite enterAmountDeposit = new EnterAmountDeposite(primaryStage);
        createatm.prepareScene(); // to call the preparesce to trger the drawing 
        menu.prepareScene(); //to trger it 
        enterAmount.prepareScene();
        enterAmountDeposit.prepareScene();
        menu.setEnterAmount(enterAmount);
        createatm.setMenu(menu); // when it wants to go to the homescreen
        enterAmount.setMenu(menu);
        menu.setEnterAmountDeposit(enterAmountDeposit);
        enterAmountDeposit.setMenu(menu);

        primaryStage.setScene(createatm.getScene()); // the show ill put 
        primaryStage.show(); // busy waiting 
    }

}
