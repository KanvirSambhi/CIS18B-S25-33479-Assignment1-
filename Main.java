// Kanvir Sambhi

// CIS-18B Online

// 03/03/2025

// Assignment 1

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    private static ArrayList<BankAccount> accounts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        while (true) {
            System.out.println("\nWelcome to Simple Bank System");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try
            {
                choice = Integer.parseInt(scanner.nextLine());
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid input! Please enter a number between 1 and 5.");
                continue;
            }

            switch (choice)
            {
                case 1:
                    createAccount();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    System.out.println("Thank you for using Simple Bank System!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please select a valid option.");
            }
        }
    }

    private static void createAccount()
    {
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();
        double initialDeposit;

        while (true)
        {
            System.out.print("Enter initial deposit: ");
            try
            {
                initialDeposit = Double.parseDouble(scanner.nextLine());
                if (initialDeposit < 0)
                {
                    System.out.println("Initial deposit cannot be negative.");
                }
                else
                {
                    break;
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid amount! Please enter a valid number.");
            }
        }

        BankAccount newAccount = new BankAccount(name, initialDeposit);
        accounts.add(newAccount);
        System.out.println("Account created successfully! Account Number: " + newAccount.getAccountNumber());
    }

    private static BankAccount findAccount()
    {
        System.out.print("Enter account number: ");
        int accountNumber;
        try
        {
            accountNumber = Integer.parseInt(scanner.nextLine());
        }
        catch (NumberFormatException e)
        {
            System.out.println("Invalid input! Account number must be a number.");
            return null;
        }

        for (BankAccount account : accounts)
        {
            if (account.getAccountNumber() == accountNumber)
            {
                return account;
            }
        }
        System.out.println("Account not found!");
        return null;
    }

    private static void depositMoney()
    {
        BankAccount account = findAccount();
        if (account == null) return;

        double amount;
        while (true)
        {
            System.out.print("Enter amount to deposit: ");
            try
            {
                amount = Double.parseDouble(scanner.nextLine());
                if (amount <= 0)
                {
                    System.out.println("Deposit amount must be greater than zero.");
                }
                else
                {
                    account.deposit(amount);
                    break;
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid amount! Please enter a valid number.");
            }
        }
    }

    private static void withdrawMoney()
    {
        BankAccount account = findAccount();
        if (account == null) return;

        double amount;
        while (true)
        {
            System.out.print("Enter amount to withdraw: ");
            try
            {
                amount = Double.parseDouble(scanner.nextLine());
                if (amount <= 0)
                {
                    System.out.println("Withdrawal amount must be greater than zero.");
                }
                else
                {
                    account.withdraw(amount);
                    break;
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid amount! Please enter a valid number.");
            }
        }
    }

    private static void checkBalance()
    {
        BankAccount account = findAccount();
        if (account != null)
        {
            System.out.println("Current balance: $" + account.getFormattedBalance());
        }
    }
}