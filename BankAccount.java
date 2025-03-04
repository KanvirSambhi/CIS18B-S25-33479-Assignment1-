public class BankAccount
{
    private static int accountNumberCounter = 1000; // Starting account number
    private String accountHolderName;
    private int accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String accountHolderName, double initialBalance)
    {
        this.accountHolderName = accountHolderName;
        this.accountNumber = generateAccountNumber(); // Generate a unique account number
        this.balance = initialBalance;
    }

    // Method to generate a unique account number
    private static int generateAccountNumber()
    {
        return ++accountNumberCounter; // Increment the counter and return the new number
    }

    // Deposit method
    public void deposit(double amount)
    {
        if (amount > 0)
        {
            balance += amount;
            System.out.println("Deposit successful! New balance: $" + balance);
        }
        else
        {
            System.out.println("Invalid amount. Deposit must be greater than zero.");
        }
    }

    // Withdraw method
    public void withdraw(double amount)
    {
        if (amount > 0)
        {
            if (amount <= balance)
            {
                balance -= amount;
                System.out.println("Withdrawal successful! New balance: $" + balance);
            }
            else
            {
                System.out.println("Insufficient funds!");
            }
        }

        else
        {
            System.out.println("Invalid amount. Withdrawal must be greater than zero.");
        }
    }



    // Get balance
    public String getFormattedBalance()
    {
        return String.format("%.2f", balance);
    }

    // Get account number
    public int getAccountNumber()
    {
        return accountNumber;
    }

    // Get account holder name
    public String getAccountHolderName()
    {
        return accountHolderName;
    }


}
