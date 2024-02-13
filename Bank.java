import java.util.*;
import IA_2.*;
public class Bank {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        mOperations obj = new mOperations("", 0,"",0.0, "", 0, 0.0,0.0);
        Vector<mOperations> vec=new Vector();

        loop:
        while(true){
            System.out.println("\n Operations");
            System.out.println("1.Create an Acc");
            System.out.println("2.Login to an Acc");
            System.out.println("3.Exit");
            System.out.println("Enter the Operation number \n");
            int a=in.nextInt();
            switch(a){
                case 1:
                    obj.create(in,vec);
                    break;
                case 2:
                    loop1:
                    while(true){
                        System.out.println("\n Login through card details or personal details");
                        System.out.println("1.card details");
                        System.out.println("2.personal details");
                        System.out.println("3.Exit ");
                        System.out.println("Enter the Operation number \n");
                        int b= in.nextInt();
                        switch (b){
                            case 1:
                                obj.loginThCardDetails(in,vec);
                                break;
                            case 2:
                                obj.loginThPersonalDetails(in,vec);
                                break;
                            case 3:
                                break loop1;
                        }
                    }
                    break;
                case 3:
                    System.out.println("End of Operations");
                    break loop;
                default:
                    System.out.println("Enter the right choice");
            }
        }
    }
}