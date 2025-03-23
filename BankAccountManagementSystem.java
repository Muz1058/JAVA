import java.util.Arrays;
import java.util.Scanner;

class BankAccount{
    private int accountId;
    private String accountHolderName;
    private double balance;
    private String accountType;
    private double[] transaction;
     public BankAccount(){
         accountId=0;
         accountHolderName="------";
         balance=0.0;
         accountType="------";
     }

     public BankAccount(int accountId,String accountHolderName,double balance,String accountType,double[] transactionPr){
         this.accountId=accountId;
         this.accountHolderName=accountHolderName;
         this.balance=balance;
         this.accountType=accountType;
         transaction=new double[5];
         if(transactionPr.length>5)
         {
             System.out.println(" Only Last five Transactions are saved ");
             int size= transactionPr.length;
             size=size-5;
             for(int i = 0; i < 5; i++) {
                 transaction[i]=transactionPr[size++];
             }
         }
         else {
             for (int i = 0; i < transactionPr.length; i++) {
                 transaction[i]=transactionPr[i];
             }

         }
     }
     public BankAccount(BankAccount obj){
         accountId=obj.accountId;
         accountHolderName= obj.accountHolderName;;
         balance= obj.balance;
         accountType= obj.accountType;
         transaction= obj.transaction;
     }
     void setAccountId(int accountId){
         this.accountId=accountId;
     }
    void setAccountHolderName(String accountHolderName){
         this.accountHolderName=accountHolderName;
     }
     void setBalance(double balance){
         if(balance>0.0)
         {
             this.balance=balance;
         }
     }
     void setAccountType(String accountType){
         if(accountType.equals("Savings")||accountType.equals("Checking"))
         {
             this.accountType=accountType;
         }
     }
    public void setTransaction(double[] transaction) {
        if(transaction.length>5)
        {
            System.out.println(" Only Last five Transactions are saved ");
            int size= transaction.length;
            size=size-5;
            for(int i = 0; i < 5; i++) {
                this.transaction[i]=transaction[size++];
            }
        }
        else {
            for (int i = 0; i < transaction.length; i++) {
                this.transaction[i]=transaction[i];
            }

        }
    }

    void addTransaction(double newSingleTransaction){
         if(newSingleTransaction>0.0){
             for (int i = 1; i <transaction.length ; i++) {
                 transaction[i-1]=transaction[i];
             }
             transaction[transaction.length-1]=newSingleTransaction;
         }
    }

    public int getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountType() {
        return accountType;
    }

    public double[] getTransaction() {
        return transaction;
    }

    public BankAccount copy() {
        return new BankAccount(this);
    }

    public void deposit(double amount){
         if(amount>0.0){
             int size=transaction.length;
             for (int i = 1; i < size; i++) {
                 transaction[i-1]=transaction[i];
             }
             transaction[size-1]=amount;
             balance+=amount;
         }
         else{
             System.out.println("Invalid Deposit Amount");
         }

    }
    void withdraw(double amount){
        if(amount>0.0&&amount<=balance){
            int size=transaction.length;
            for (int i = 1; i < size; i++) {
                transaction[i-1]=transaction[i];
            }
            transaction[size-1]=amount*-1;
            balance-=amount;
        }
        else if(amount>balance){
            System.out.println("Low Balance");
        }
        else{
            System.out.println("Invalid Withdrawal Amount");
        }
    }

    static BankAccount findHighestBalance(BankAccount[] object){
         BankAccount highest=object[0];
        for (BankAccount i : object) {
            if (i.balance > highest.balance) {
                highest = i;
            }
        }
        return highest;
    }
    public boolean equals(BankAccount obj){
        return this.accountId == obj.accountId && this.accountHolderName.equals(obj.accountHolderName) && this.accountType.equals(obj.accountType) && this.balance == obj.balance && this.transaction == obj.transaction;
    }

    public String toString() {
        return "\nBank Account Details\n{\t" +
                "Account ID= " + accountId +
                ", Account Holder Name= '" + accountHolderName + '\'' +
                ", Balance= " + balance +
                ", Account Type= '" + accountType + '\'' +
                ", Transaction= " + Arrays.toString(transaction) +
                "\t}";
    }
}
public class BankAccountManagementSystem {
    public static void main(String[] args) {
        Scanner getInput = new Scanner(System.in);


        BankAccount defaultAccount = new BankAccount();
        System.out.println("\t\t\t\t-----Default Account Values-----" + defaultAccount);

        System.out.print("\nEnter Account ID: ");
        int id = getInput.nextInt();
        getInput.nextLine();
        System.out.print("Enter the Account Holder Name: ");
        String name = getInput.nextLine();

        double balance;
        do {
            System.out.print("Enter Balance: ");
            balance = getInput.nextDouble();
            if(balance < 0.0){
                System.out.println("Invalid Balance!!\nTry Again");
            }
        } while (balance < 0.0);

        int accountChoice;
        String accountType = "Null";
        do {
            System.out.print("Enter 1 for Saving Account \n Enter 2 for Checking Account:\nEnter (1/2) :");
            accountChoice = getInput.nextInt();
            if (accountChoice == 1) {
                accountType = "Savings";
            } else if (accountChoice == 2) {
                accountType = "Checking";
            } else {
                System.out.println("Invalid Account Type!!\nTry again");
            }
        } while (accountChoice != 1 && accountChoice != 2);


        System.out.print("Enter 5 Transactions (separate with space): ");
        double[] transactions = new double[5];
        for (int i = 0; i < 5; i++) {
            transactions[i] = getInput.nextDouble();
        }

        BankAccount IstAccount = new BankAccount(id, name, balance, accountType, transactions);
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t-----Passing Values in Account Through Parameterized Constructor-----");

        System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t-----Original Account Data-----" + IstAccount);

        BankAccount copyAccount = IstAccount.copy();
        System.out.println("\nCopied Account Data:" + copyAccount);

        IstAccount.deposit(60000);
        IstAccount.withdraw(20000);
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t-----After transactions on First account-----" + IstAccount);

        System.out.println("\nCopied Account Data :" + copyAccount);
        BankAccount[] accounts = {defaultAccount, IstAccount, copyAccount};

        System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t-----Account with the Highest balance-----" + BankAccount.findHighestBalance(accounts));

    }
}
