package com.example.javafx_application;

/**
 * @author Gopika Kalathiya(991659883)
 * @author Ramandeep Kaur(991661772)
 * @version 1.0
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import javax.print.*;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import java.io.*;
import java.util.Scanner;

public class OrdersController {
    @FXML
    private TextArea orderTextArea;


    //File file = new File("Orders.txt");
    Scanner bill;

    /**
     * display the receipt
     * @throws IOException
     */

    public void onReceiptButton() throws IOException {
        try{
            bill = new Scanner(TakeOrderController.myFile2);
            while (bill.hasNextLine()){
                String s = bill.nextLine();
                Scanner sc = new Scanner(s);
                String order = sc.nextLine();
                orderTextArea.appendText(order + "\n");
            }
            bill.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     * print receipt on a printer
     * @param event
     */
    public void onPrintReceiptButton(ActionEvent event){
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
                    System.out.println("Job sent to printer.");
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

    /**
     * exit from the system
     * @param event
     * @throws FileNotFoundException
     */
    public void onExButton(ActionEvent event) throws FileNotFoundException {
        System.exit(0);
    }
}

