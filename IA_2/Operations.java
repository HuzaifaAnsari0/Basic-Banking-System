package IA_2;

import java.util.Scanner;
import java.util.Vector;

public interface Operations {
    void operations(Scanner in, Vector<mOperations> vec, int i);
    void ChangeDetails(Scanner in, Vector<mOperations> vec, int i);
    void Transfer(Scanner in,Vector<mOperations> vec,int i);
    void create(Scanner in, Vector<mOperations> vec);
    void loginThCardDetails(Scanner in, Vector<mOperations> vec);
    void loginThPersonalDetails(Scanner in,Vector<mOperations> vec);
    void TakeLoan(Scanner in, Vector<mOperations> vec, int i);
    void RepayLoan(Scanner in, Vector<mOperations> vec, int i);
    void ShowDetails(Scanner in, Vector<mOperations> vec, int i);
}
