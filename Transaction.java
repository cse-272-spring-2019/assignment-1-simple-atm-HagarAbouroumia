package myatm;

import javafx.stage.Stage;

public class Transaction {

    EnterAmountDeposite enterAmountDeposite;
    EnterAmountWithdraw enterAmountWithdraw;
    Menu menu;
    MyATM myATM;
    Stage stage;
    AtmLogic atmLogic;

    String[] arrayAmount;
    String[] arrayProcess;
    String[] arraySum;
    int count = 0;
    String n;

    public Transaction() {
        arrayAmount = new String[5];
        arrayProcess = new String[5];
        arraySum = new String[5];
        count = 0;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void transaction(String amount, String process) {
        int x =0;
        
        while(x<4)
        {
        	arrayAmount[x] = arrayAmount[x+1];
        	arrayProcess[x] = arrayProcess[x+1];
        	arraySum[x] = arraySum[x+1];
   
        	x++;
        }
        
        arrayAmount[4] = amount;
        arrayProcess[4] = process;
        arraySum[4] = arrayProcess[4] + arrayAmount[4];
        
    }
    
    public String getTrans (int index)
    {
    	return arraySum[index];	
    }

    public String prev() {
        if (count>0)
        return (arraySum[count--]);
        else
            return null;
    }

}
