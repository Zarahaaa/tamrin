package newbank;
import java.util.ArrayList;
import java.io.*;

public class bank extends person {
	ArrayList <account> accountlist = new ArrayList<account>();
	ArrayList <customer> customerlist = new ArrayList<customer>();
	ArrayList <cashier> cashierlist = new ArrayList<cashier>();
	ArrayList <String> transfertlist = new ArrayList<String>();
	public static void tara() {
		try {
			FileReader f = new FileReader("tara.txt");
			BufferedReader r = new BufferedReader(f);
			String line;
			while((line = r.readLine()) != null){
				System.out.print(line);
			}
			r.close();
			
			}
			catch(IOException e) {
				System.out.print("ERROR");
			}
		
	}
	
	
	public void cust() {
		customer customer = new customer();
		customer.new_customer();
		customerlist.add(customer);
		try {
			FileWriter f = new FileWriter("customers.txt", true);
			BufferedWriter w = new BufferedWriter(f);
			w.write(customer.ncode +","+ customer.name +","+  customer.username+","+ customer.password+ "\n");
			w.close();
			
			}
			catch(IOException e) {
				System.out.print("ERROR");
			}
		customer.menu(accountlist,transfertlist);
	}
	
	public void cash() {
		cashier cashier = new cashier();
		cashier.new_cashier();
		cashierlist.add(cashier);
		try {
			FileWriter f = new FileWriter("cashiers.txt", true);
			BufferedWriter w = new BufferedWriter(f);
			w.write(cashier.ncode +","+ cashier.name +","+ cashier.username+","+cashier.password+ "\n");
			w.close();
			
			}
			catch(IOException e) {
				System.out.println("ERROR");
			}
		cashier.accept(transfertlist, accountlist);
		
	}
	
	public void log() {
		login(accountlist,customerlist,cashierlist,transfertlist);
		
	}
	
}
