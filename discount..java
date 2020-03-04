package testing.pkg6;
import javax.swing.JOptionPane;

public class Testing6 {

    public static void main(String[] args) 
    {
        //Add item
        int AddItem = 0 ;
        double ItemTotal = 0;
        int NumOfItem= 0;
        double ItemTemp;
        
        String InDis;
        double  dis=0;   
        double finalPrice = 0;

        int ItemChoice = JOptionPane.showConfirmDialog(null, 
                "Start Shopping?", "Start Program",JOptionPane.YES_NO_OPTION);
   
        if(ItemChoice== 0)
        {
            while(AddItem == 0)
            {
                String InItemTemp;
                InItemTemp =  JOptionPane.showInputDialog("Enter Item Price (MYR)  TOTAL PRICE= " + ItemTotal +" ItemNum= " + NumOfItem );
                ItemTemp = Double.parseDouble(InItemTemp);  
            
                //clearance
                InDis = JOptionPane.showInputDialog("Enter discount (%)");
                dis = Double.parseDouble(InDis);			
                 // "InDis" is used to hold the data from the input dialog temporary before convert it to double type data   	
            
                ItemTemp = ItemTemp - (ItemTemp * (dis / 100));
                ItemTotal = ItemTotal + ItemTemp ;
                NumOfItem++;
            
                AddItem = JOptionPane.showConfirmDialog(null, 
                "Add more item?", "Addition of item",JOptionPane.YES_NO_OPTION);
            }
        
        int DisChoice = JOptionPane.showConfirmDialog(null, 
            "Apply Discount to total price? Total Price " + ItemTotal, "Start Discount",JOptionPane.YES_NO_OPTION);
            
            if(DisChoice == 0)
            {
                //Discount
                 double discount;
        
                String InDiscount;
                InDiscount = JOptionPane.showInputDialog("Enter discount (%)");
                discount = Double.parseDouble(InDiscount);
                // "InDiscount" is used to hold the data from the input dialog temporary before convert it to double type data   
        
                finalPrice = (ItemTotal * discount) / 100;
        
                //Output
                JOptionPane.showMessageDialog(null,"Total price after discount is " + finalPrice);
            }
        
            //membership
            double total;
            total = finalPrice;
            //To enter the total price of the customer's order
        
            int input = JOptionPane.showConfirmDialog(null, 
                "Did the customer registered for membership? Total Price = " + total, "Membership Confirmation",JOptionPane.YES_NO_OPTION);
                if (input == 0)
            {
                JOptionPane.showMessageDialog(null,"Membership bonus(70%) received");
                total = total* 0.3;
            }
  
            //Output
            JOptionPane.showMessageDialog(null,"Total price with membership bonus is RM" + total);
            
            int paymentType = JOptionPane.showConfirmDialog(null, 
                "Does the customer want to pay by Instalment? Total Price = " + total, "Membership Confirmation",JOptionPane.YES_NO_OPTION);
            
                if(paymentType == 0)
                {
                    double principal = total;
                    // "InPrincipal" is used to hold the data from the input dialog temporary before convert it to double type data   
        
                    String InRate;
                    InRate =  JOptionPane.showInputDialog("Enter Rate(%)");
                    double rate = Double.parseDouble(InRate);
                    // "InRate" is used to hold the data from the input dialog temporary before convert it to double type data   
        
                    String InTime;
                    InTime =  JOptionPane.showInputDialog("Enter Time(Month)");
                    double time = Double.parseDouble(InTime);
                    // "InTime" is used to hold the data from the input dialog temporary before convert it to double type data   
        
                    //Output
                    double emi;
                    rate=rate/(12*100);
                    time=time*12;
                    emi= (principal*rate*Math.pow(1+rate,time))/(Math.pow(1+rate,time)-1);
                    JOptionPane.showMessageDialog(null,"Monthly EMI is= "+emi+"\n");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"GRAND TOTAL = RM " + total);
                }
        
        }
        JOptionPane.showMessageDialog(null,"Thank You For Shopping With Us" );
        System.exit(0);
        
    }
    
}
