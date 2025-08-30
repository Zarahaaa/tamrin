package newbank;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class cashier extends person {
    Scanner inp = new Scanner(System.in);

    public void new_cashier() {
        System.out.print("enter your name: ");
        set_name(inp.nextLine());
        System.out.print("enter your national code: ");
        set_ncode(inp.nextLine());
        System.out.print("enter your username: ");
        set_user(inp.nextLine());
        System.out.print("enter your password: ");
        set_pass(inp.nextLine());
    }
    
    public void accept(ArrayList<String> transfertlist, ArrayList<account> accountlist) {
        
        ArrayList<String> transactions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("transfer.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                transactions.add(line);
            }
        } catch (IOException e) {
            System.out.println("ERROR reading transfer.txt");
            e.printStackTrace();
            return;
        }

        
        ArrayList<String> remainingTransactions = new ArrayList<>();

        for (String transaction : transactions) {
            System.out.println(transaction);
            System.out.print("enter your answer, yes or no: ");
            String answer = inp.nextLine().trim().toLowerCase();

            if (answer.equals("yes")) {
            
                String[] parts = transaction.split(",");
                if (parts.length < 3) {
                    System.out.println("Invalid transaction format");
                    continue;
                }
                String mabda = parts[0].trim();
                String maqhsad = parts[1].trim();
                int money;

                try {
                    money = Integer.parseInt(parts[2].trim());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid money amount");
                    continue;
                }

                
                boolean mabdaFound = false;
                boolean maqhsadFound = false;

                for (account acc : accountlist) {
                    if (acc.get_id().equals(mabda)) {
                        acc.withdrawmoney(money);
                        mabdaFound = true;
                        writeTransactionLog(acc);
                    }
                    if (acc.get_id().equals(maqhsad)) {
                        acc.depositmoney(money);
                        maqhsadFound = true;
                        writeTransactionLog(acc);
                    }
                }

                if (!mabdaFound || !maqhsadFound) {
                    System.out.println("Account id not found for transfer");
                }

            } else if (answer.equals("no")) {
                
                remainingTransactions.add(transaction);
            } else {
                System.out.println("Invalid answer, transaction skipped.");
                remainingTransactions.add(transaction);
            }
        }

        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("transfer.txt", false))) {
            for (String tr : remainingTransactions) {
                writer.write(tr);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("ERROR writing transfer.txt");
        }
    }

    private void writeTransactionLog(account acc) {
        try (BufferedWriter w = new BufferedWriter(new FileWriter("tara.txt", true))) {
            w.write("id =" + acc.get_id() + ",  balance = " + acc.get_balance() + ",   done\n");
        } catch (IOException e) {
            System.out.println("ERROR writing tara.txt");
        }
    }
}


	
		
	
		
		

