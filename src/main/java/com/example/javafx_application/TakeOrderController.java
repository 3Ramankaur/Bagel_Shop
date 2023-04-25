package com.example.javafx_application;
/**
 * @author Gopika Kalathiya(991659883)
 * @author Ramandeep Kaur(991661772)
 * @version 1.0
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.*;
import javax.print.*;
import javax.print.attribute.*;

public class TakeOrderController {
    @FXML
    private RadioButton noneRadioButton;

    @FXML
    private RadioButton whiteRadioButton;

    @FXML
    private RadioButton wheatRadioButton;

    @FXML
    private TextField whiteTextField;

    @FXML
    private TextField wheatTextField;

    @FXML
    private CheckBox cheeseCheckBox;

    @FXML
    private CheckBox butterCheckBox;

    @FXML
    private CheckBox blueberryCheckBox;

    @FXML
    private CheckBox raspberryCheckBox;

    @FXML
    private CheckBox peachCheckBox;

    @FXML
    private RadioButton noneRadio;

    @FXML
    private RadioButton regularRadioButton;

    @FXML
    private RadioButton capRadioButton;

    @FXML
    private RadioButton laitRadioButton;

    @FXML
    private TextField regularTextField;

    @FXML
    private TextField capTextField;

    @FXML
    private TextField laitTextField;

    @FXML
    private Label subTotalLabel;

    @FXML
    private Label taxLabel;

    @FXML
    private Label totalLabel;

    @FXML
    private Button checkButton;


    static File myFile2 = new File("Order.txt");
    final static double WHITE_BAGEL = 1.25;
    final static double WHEAT_BAGEL = 1.50;
    final static double CHEESE = 0.50;
    final static double BUTTER = 0.25;
    final static double BLUEBERRY = 0.75;
    final static double RASPBERRY = 0.75;
    final static double PEACH = 0.75;
    final static double REGULAR_COFFEE = 1.25;
    final static double CAPPUCCINO = 2.00;
    final static double LAIT = 1.75;
    final static double TAX_PRICE = 0.13;

    String radio, coffee, topp = "";
    double bagelQuantity , coffeeQuantity, bagelPrice, coffeePrice, toppingPrice = 0.0, price, tax, total;
    int count=0;


    public void topping(){
        if(cheeseCheckBox.isSelected()) {
            topp += cheeseCheckBox.getText() + "\n";
            toppingPrice += CHEESE;
        }
        if(butterCheckBox.isSelected()) {
            topp += butterCheckBox.getText() + "\n";
            toppingPrice += BUTTER;
        }
        if(blueberryCheckBox.isSelected()) {
            topp += blueberryCheckBox.getText() + "\n";
            toppingPrice += BLUEBERRY;
        }
        if(raspberryCheckBox.isSelected()) {
            topp += raspberryCheckBox.getText() + "\n";
            toppingPrice += RASPBERRY;
        }
        if(peachCheckBox.isSelected()) {
            topp += peachCheckBox.getText() + "\n";
            toppingPrice += PEACH;
        }
    }
    /**
     * calculate button method to select item and calculate price.
     * @param event
     * @throws IOException
     */
    public void onCalculateButton(ActionEvent event) throws IOException {
        subTotalLabel.setText("$0.00");
        taxLabel.setText("$0.00");
        totalLabel.setText("$0.00");
        PrintWriter clearData = new PrintWriter(myFile2);
        clearData.print("");
        clearData.close();

        //bagel

        if(noneRadioButton.isSelected()) {
            radio = noneRadioButton.getText();
            //bagelPrice = 0.00;
            //outputOrder.println( "bagel: \n" + radio + "\n Price: $" + bagelPrice);
        } else if (whiteRadioButton.isSelected()) {
            radio = whiteRadioButton.getText();
            bagelQuantity = Double.parseDouble(whiteTextField.getText());
            bagelPrice = WHITE_BAGEL * bagelQuantity;
           // outputOrder.println( "bagel: \n" + radio + "\n Price: $" + bagelPrice);
        } else if (wheatRadioButton.isSelected()) {
            radio = wheatRadioButton.getText();
            bagelQuantity = Double.parseDouble(wheatTextField.getText());
            bagelPrice = WHEAT_BAGEL * bagelQuantity;
           // outputOrder.println( "bagel: \n" + radio + "\n Price: $" + bagelPrice);
        }

        //Toppings

        topping();

        //coffee

        if(noneRadio.isSelected()){
            coffee = noneRadio.getText();
            //coffeePrice = 0.00;
           // outputOrder.println( "Coffee: \n" + coffee + "\n Price: $" + coffeePrice);
        }else if(capRadioButton.isSelected()){
            coffee = capRadioButton.getText();
            coffeeQuantity = Double.parseDouble(capTextField.getText());
            coffeePrice = CAPPUCCINO * coffeeQuantity;
          //  outputOrder.println( "Coffee: \n" + coffee + "\n Price: $" + coffeePrice);
        }else if(laitRadioButton.isSelected()){
            coffee = laitRadioButton.getText();
            coffeeQuantity = Double.parseDouble(laitTextField.getText());
            coffeePrice = LAIT * coffeeQuantity;
           // outputOrder.println( "Coffee: \n" + coffee + "\n Price: $" + coffeePrice);
        }else if(regularRadioButton.isSelected()){
            coffee = regularRadioButton.getText();
            coffeeQuantity = Double.parseDouble(regularTextField.getText());
            coffeePrice = REGULAR_COFFEE * coffeeQuantity;
           // outputOrder.println( "Coffee: \n" + coffee + "\n Price: $" + coffeePrice);
        }
        count++;
        if (count>1){
            price = 0;
            toppingPrice=0;
            topping();

        }
            price = bagelPrice + coffeePrice + toppingPrice;
            subTotalLabel.setText("$" + String.valueOf(price));
            tax = price * TAX_PRICE;
            taxLabel.setText("$" + String.valueOf(tax));
            total = price + tax;
            totalLabel.setText("$" + String.valueOf(total));
            //outputOrder.println(radio + coffee);
    }

    /**
     * reset all the field.
     * @param event
     * @throws FileNotFoundException
     */

    public void onResetButton(ActionEvent event) throws FileNotFoundException {
        noneRadioButton.setSelected(true);
        whiteRadioButton.setSelected(false);
        wheatRadioButton.setSelected(false);
        whiteTextField.clear();
        wheatTextField.clear();
        cheeseCheckBox.setSelected(false);
        butterCheckBox.setSelected(false);
        blueberryCheckBox.setSelected(false);
        raspberryCheckBox.setSelected(false);
        peachCheckBox.setSelected(false);
        noneRadio.setSelected(true);
        regularRadioButton.setSelected(false);
        laitRadioButton.setSelected(false);
        capRadioButton.setSelected(false);
        regularTextField.clear();
        laitTextField.clear();
        capTextField.clear();
        subTotalLabel.setText("$0.00");
        taxLabel.setText("$0.00");
        totalLabel.setText("$0.00");
        PrintWriter clearData = new PrintWriter(myFile2);
        clearData.print("");
        clearData.close();
        count=0;
        toppingPrice = 0;
        price=0;
        tax=0;
        total =0;
    }

    /**
     * print the bill in a file
     * @param event
     * @throws IOException
     */

    public void onPrintToFilesButton(ActionEvent event) throws IOException {
        PrintWriter outputOrder = new PrintWriter(new BufferedWriter(new FileWriter(myFile2,true))); // to open file in write mode
        outputOrder.println("\tWelcome to Coffee and Cafe shop \n\tCreated By::  Gopika Kalathiya \n\t\t\t    Ramandeep Kaur \n\t\t\tYour Order::");
        outputOrder.println("Date:: " + java.time.LocalDateTime.now());
        outputOrder.println("\t\tItem\t\t\t\tQty\t\t\tPrice");
        outputOrder.println("Bagel:: \n"+radio +"\t\t"+ bagelQuantity +"\t\t\t$"+ bagelPrice + "\nToppings: \n" + topp+"\t\t\t\t\t\t\t\t\t$"+ toppingPrice + "\nCoffee:: \n" + coffee+"\t\t\t" + coffeeQuantity + "\t\t\t$"+ coffeePrice+ "\n---------------------------------------------------" + "\nSubTotal:: \t\t\t\t\t\t\t$" + price + "\nHST (13%) \t\t\t\t\t\t\t$"+ tax + "\nTotal::\t\t\t\t\t\t\t\t$" + (price+tax));
        outputOrder.println("\tThank you for shopping with Us\n");
        outputOrder.close();
        Stage stage = (Stage) checkButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent order = FXMLLoader.load(getClass().getResource("Orders.fxml"));
        primaryStage.setTitle("Your Order");
        primaryStage.setScene(new Scene(order));
        primaryStage.show();
    }

    /**
     * Exit from the system
     * @param event
     * @throws FileNotFoundException
     */
    public void onExitButton(ActionEvent event) throws FileNotFoundException {
        PrintWriter clearData = new PrintWriter(myFile2);
        clearData.print("");
        clearData.close();
        System.exit(0);
    }

    /**
     * print bill on a printer
     * @param event
     */

    public void onPrinterButton(ActionEvent event)
    {
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
        PrintService ps[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
        PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
        PrintService service = ServiceUI.printDialog(null, 200, 200, ps, defaultService, flavor, pras);
        if (service != null)
        {
            try
            {
                DocPrintJob job = service.createPrintJob();
                DocAttributeSet das = new HashDocAttributeSet();
                FileInputStream fis = new FileInputStream("Order.txt");
                Doc doc = new SimpleDoc(fis, flavor, das);
                try
                {
                    job.print(doc, pras);
                    System.out.println("Order sent to printer to print.");
                    //fis.close();
                } catch (Exception e) {
                    System.out.println("Print error!" + e.getMessage());
                }
                //fis.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found!" + e.getMessage());
            }
        }
    }

    public void onKey(KeyEvent keyEvent) {
        if(keyEvent.getText().matches("[a-z]")){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error message");
            alert.setContentText("Ypu can only allow to enter digit.");
            alert.show();
        }
    }
}
