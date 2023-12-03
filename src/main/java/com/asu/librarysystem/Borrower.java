package com.asu.librarysystem;

import java.util.ArrayList;

public class Borrower extends Account
{
    private double borrowerFines = 0;
    private ArrayList<Transaction> borrowerTransactions;
    
    public Borrower( String borrowerName, String password, String PhoneNumber)
    {
        super( borrowerName, password, PhoneNumber);
        borrowerTransactions = new ArrayList<>();
    }

     public void addTransaction (Book book ,int borrowDate ,int returnDate)
    {
        borrowerTransactions.add(new Transaction(book.getId() ,getId() ,borrowDate ,returnDate));
    }
     
    public void deleteTransaction (int transactionId)
    {
        //try {
            borrowerTransactions.remove(transactionId);
       // }
       // catch (IndexOutOfBoundsException e)
       // {
       //    System.out.println("cant delete because the index is out of bound");
       // }
    }
    
    public int searchTransactions (int transactionId)
    {
        for (int i = 0; i < borrowerTransactions.size(); i++) {
            if (borrowerTransactions.get(i).getTransactionId() == transactionId)
            {
                return borrowerTransactions.get(i).getBorrowerId();
            }
        }
        return -1;
    }

    public double finesIfLate ()
    {
        for (Transaction borrowerTransaction : borrowerTransactions) {
            if (borrowerTransaction.getBorrowerId() == this.getId() && borrowerTransaction.getFines() >= 0) {
                borrowerFines += borrowerTransaction.getFines();
            }
        }
        return borrowerFines;
    }
}
