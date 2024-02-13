package IA_2;

import java.util.Scanner;
import java.util.Vector;

public class mOperations extends User implements Operations {

    public mOperations(String name, double amount, String PhNo, double AccNo, String pass, int cvv, double CardNo, double loan) {
        super(name, amount, PhNo, AccNo, pass, cvv, CardNo, loan);
    }

    @Override
    public void operations(Scanner in, Vector<mOperations> vec, int i) {
        mOperations obj=new mOperations("", 0,"",0.0, "", 0, 0.0,0.0);

        loop:
        while(true){
            System.out.println("\nOperations");
            System.out.println("1.Transfer");
            System.out.println("2.Add amount");
            System.out.println("3.Change Acc details");
            System.out.println("4.Take Loan");
            System.out.println("5.Repay Loan");
            System.out.println("6.Show Acc details");
            System.out.println("7.Exit ");
            System.out.println("Enter the Operation number \n");
            int a=in.nextInt();
            switch(a){
                case 1:
                    obj.Transfer(in,vec,i);
                    break;
                case 2:
                    System.out.println("Enter the Amount you want to add");
                    double add=in.nextDouble();
                    System.out.println("Your balance: "+(vec.get(i).amount += add)+"\n");
                    break;
                case 3:
                    obj.ChangeDetails(in,vec,i);
                    break;
                case 4:
                    obj.TakeLoan(in,vec,i);
                    break;
                case 5:
                    obj.RepayLoan(in,vec,i);
                    break ;
                case 6:
                    obj.ShowDetails(in,vec,i);
                    break;
                case 7:
                    break loop;
                default:
                    System.out.println("Enter the right choice");
            }
        }
    }

    @Override
    public void RepayLoan(Scanner in, Vector<mOperations> vec, int i){
        if(vec.get(i).loan > 0){
            System.out.println("Enter the amount you want to repay");
            double pay=in.nextDouble();
            if (vec.get(i).loan < pay){
                System.out.println("The Loan amount is only "+ vec.get(i).loan);
            } else{
                System.out.println("Enter your password");
                String tempp=in.next();
                if (tempp.equals(vec.get(i).pass)){
                    vec.get(i).loan -= pay;
                    vec.get(i).amount -= pay;
                    if(vec.get(i).loan == 0){
                        System.out.println("You have repaid the Total Amount Loan taken");
                    } else{
                        System.out.println("The Loan amount left is "+vec.get(i).loan);
                    }
                    System.out.println("Balance left in the Acc is "+vec.get(i).amount);
                } else{
                    System.out.println("Enter correct Password");
                }
            }
        } else{
            System.out.println("You haven't taken a Loan");
        }
    }

    @Override
    public void ShowDetails(Scanner in, Vector<mOperations> vec, int i){
        System.out.println("\nName of the Account holder: "+vec.get(i).name);
        System.out.println("Account balance: "+vec.get(i).amount);
        System.out.println("The phone No linked to the Acc: "+vec.get(i).PhNo);
        System.out.printf("Account No: %.0f \n",vec.get(i).AccNo);
        System.out.println("Password for the Account: "+vec.get(i).pass);
        System.out.printf("Your card No: %.0f \n",vec.get(i).CardNo);
        System.out.println("Your Cvv: "+vec.get(i).cvv);
        System.out.println("Your Loan Amount: "+vec.get(i).loan +"\n");
    }

    @Override
    public void TakeLoan(Scanner in, Vector<mOperations> vec, int i){
        System.out.println("Enter the amount you want to loan");
        double takeLoan =in.nextDouble();
        System.out.println("Enter our Password");
        String tempp=in.next();
        if((vec.get(i).pass).equals(tempp)){
            vec.get(i).loan += takeLoan;
            vec.get(i).amount += takeLoan;
            System.out.println("Present loan: "+takeLoan);
            System.out.println("Total Loan: "+vec.get(i).loan);
            System.out.println("Your balance: "+vec.get(i).amount);
        }
        else{
            System.out.println("Enter correct Password");
        }
    }

    @Override
    public void ChangeDetails(Scanner in, Vector<mOperations> vec, int i) {
        loop1:
        while(true){
            System.out.println("Which details you want to change");
            System.out.println("1.Your Name");
            System.out.println("2.Your PhNo");
            System.out.println("3.Your Pass");
            System.out.println("4.Exit ");
            System.out.println("Enter the Operation number \n");
            int b=in.nextInt();
            switch (b){
                case 1:
                    System.out.println("Enter the name you want to keep");
                    String NewName=in.next();
                    System.out.println("Acc Name has been set to: "+(vec.get(i).name=NewName)+"\n");
                    break;
                case 2:
                    System.out.println("Enter the PhNo you want to keep");
                    String NewPhNo=in.next();
                    System.out.println("Acc Name has been set to: "+(vec.get(i).PhNo=NewPhNo)+"\n");
                    break;
                case 3:
                    System.out.println("Enter the Pass you want to keep");
                    String NewPass=in.next();
                    System.out.println("Acc Name has been set to: "+(vec.get(i).pass=NewPass)+"\n");
                    break;
                case 4:
                    break loop1;
                default:
                    System.out.println("Enter the right choice");
            }
        }
    }

    @Override
    public void Transfer(Scanner in, Vector<mOperations> vec, int i) {
        System.out.println("1.Same Bank");
        System.out.println("2.Different Bank");
        System.out.println("3.Exit");
        System.out.println("Enter the Operation number \n");
        int c = in.nextInt();

        switch (c) {
            case 1:
                System.out.println("Enter the Acc No on which you want to transfer");
                double tempA = in.nextDouble();
                System.out.println("Enter the Amount you want to transfer");
                double money1 = in.nextDouble();
                System.out.println("Enter the Password");
                String tempp = in.next();

                if (money1 > vec.get(i).amount) {
                    System.out.println("\nNot Enough Balance");
                } else {
                    if (tempp.equals(vec.get(i).pass)) {
                        boolean receiverFound = false;

                        // j is the receiver, i is the transferer
                        for (int j = 0; j < vec.size(); j++) {
                            if (tempA == vec.get(j).AccNo) {
                                vec.get(i).amount -= money1;
                                vec.get(j).amount += money1;
                                System.out.printf("%.0f has been transferred to the Acc: %.0f \n", money1, tempA);
                                System.out.println("Balance left in the Acc: " + vec.get(i).amount);
                                receiverFound = true;
                                break;
                            }
                        }

                        if (!receiverFound) {
                            System.out.println("The Acc No you Entered does not belong to our bank");
                        }
                    } else {
                        System.out.println("The Password you Entered is Wrong");
                    }
                }
                break;

            case 2:
                System.out.println("Enter the Acc No in which you want to transfer");
                double tempAc=in.nextDouble();
                System.out.println("Enter the Amount you want to transfer");
                double money2=in.nextDouble();
                System.out.println("Enter the Password");
                String temppa=in.next();
                if(money2 > vec.get(i).amount) {
                    System.out.println("Not Enough Balance");
                }
                else {
                    if (temppa.equals(vec.get(i).pass)) {
                        vec.get(i).amount -= money2;
                        System.out.printf("%.0f has been transferred to the Acc: %.0f \n" ,money2, tempAc);
                        System.out.println("Balance left in the Acc: " + vec.get(i).amount);
                    } else {
                        System.out.println("Password you Entered is wrong");
                    }
                }
                break;
            case 3:
                break;
            default:
                System.out.println("Enter the right choice");
        }
    }

    @Override
    public void create(Scanner in, Vector<mOperations> vec) {
        System.out.println("Enter your name");
        String name=in.next();
        System.out.println("Enter the amount you want to add");
        double amount=in.nextDouble();
        System.out.println("Enter your phone No");
        String PhNo=in.next();
        double AccNo= Math.floor(Math.random()*(100000-10000+1)+10000);
        System.out.println("Enter a PASSWORD for your Acc");
        String pass=in.next();
        int cvv=(int)Math.floor(Math.random()*(999-100+1)+100);
        double CardNo=Math.floor(Math.random()*(1000000-100000+1)+100000);

        System.out.println("\nName of the Account holder: "+name);
        System.out.println("Account balance: "+amount);
        System.out.println("The phone No linked to the Acc: "+PhNo);
        System.out.printf("Account No: %.0f \n",AccNo);
        System.out.println("Password for the Account: "+pass);
        System.out.printf("Your card No: %.0f \n",CardNo);
        System.out.println("Your Cvv: "+cvv+"\n");

        mOperations user=new mOperations(name,amount,PhNo,AccNo,pass,cvv,CardNo,loan);
        vec.add(user);
    }

    @Override
    public void loginThCardDetails(Scanner in, Vector<mOperations> vec) {
        mOperations obj=new mOperations("", 0,"",0.0, "", 0, 0.0,0.0);

        System.out.println("Enter your Card No");
        double tempCardNo= in.nextDouble();
        System.out.println("Enter your cvv");
        int tempcvv=in.nextInt();
        System.out.println("Enter your password");
        String temppass=in.next();

        boolean found = false;
        for (int i = 0; i < vec.size(); i++)
        {
            if ((vec.get(i).CardNo==tempCardNo && vec.get(i).cvv==tempcvv) && vec.get(i).pass.equals(temppass))
            {
                System.out.println("\n Logged in successfully \n");
                obj.operations(in, vec, i);
                found = true;
                break;
            }
        }

        if (!found)
        {
            System.out.println("Enter correct login details \n");
        }
    }

    @Override
    public void loginThPersonalDetails(Scanner in, Vector<mOperations> vec) {
        mOperations obj=new mOperations("", 0,"",0.0, "", 0, 0.0,0.0);
        System.out.println("Enter Account holder's name");
        String tempname=in.next();
        System.out.println("Enter Phone No linked to the Acc");
        String tempPhNo= in.next();
        System.out.println("Enter Acc No");
        double tempAccNo=in.nextDouble();
        System.out.println("Enter your Password");
        String temppass=in.next();

        boolean found = false;
        for (int i = 0; i < vec.size(); i++)
        {
            if ((vec.get(i).name.equals(tempname) && vec.get(i).PhNo.equals(tempPhNo)) && (vec.get(i).AccNo == tempAccNo && vec.get(i).pass.equals(temppass)))
            {
                System.out.println("Logged in successfully \n");
                obj.operations(in, vec, i);
                found = true;
                break;
            }
        }
        if (!found)
        {
            System.out.println("Enter correct login details \n");
        }
    }
}