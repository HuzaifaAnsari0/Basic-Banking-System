package IA_2;

public class User {
    String name;
    double AccNo;
    String pass;
    String PhNo;
    int cvv;
    double CardNo;
    double amount;
    double loan;
    public User(String name, double amount, String PhNo, double AccNo, String pass, int cvv, double CardNo, double loan){
        this.name=name;
        this.amount=amount;
        this.PhNo=PhNo;
        this.AccNo=AccNo;
        this.pass=pass;
        this.CardNo=CardNo;
        this.cvv=cvv;
        this.loan=loan;
    }
}
