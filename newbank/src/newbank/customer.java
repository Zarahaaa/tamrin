package newbank;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class customer extends person {
	Scanner input=new Scanner(System.in);
	
	int count = 0;
	public void new_customer() {
		  System.out.print("enter yor name: ");
		  set_name(input.nextLine());
		  System.out.print("enter your national code: ");
		  set_ncode(input.nextLine());
		  System.out.print("enter yor username: ");
		  set_user(input.nextLine());
		  System.out.print("enter your password: ");
		  set_pass(input.nextLine());
		  
	}
	public  void tran(ArrayList <account> accountlist,ArrayList <String> transfertlist) {
		System.out.println("enter your id: ");
		input.nextLine();
		String target = input.nextLine();
		input.nextLine();
		System.out.println("enter the id you wanna transfer to: ");
		String tid = input.nextLine();
		account mabda = null;
		account maqhsad = null;
		for (account c : accountlist) {
			if (c.get_id().equals(target)) {
				 mabda = c;
			}
			if(c.get_id().equals(tid)) {
				 maqhsad = c;
			}}
		if(mabda == null || maqhsad == null) {
			System.out.println("error ");
			return;
		}
				System.out.println("enter how much money you wanna tranfer: ");
				int transfer = input.nextInt();
				input.nextLine();
			if(mabda.get_balance() < transfer) {
				System.out.println("error ");
				return;
			}
			if (mabda.get_ncode().equals(maqhsad.get_ncode())) {
				mabda.withdrawmoney(transfer);
				maqhsad.depositmoney(transfer);
				try {
					FileWriter f = new FileWriter("tara.txt", true);
					BufferedWriter w = new BufferedWriter(f);
					w.write("id "+ mabda.get_id() + "  balance  " + mabda.get_balance() + "   done" + "\n");
					w.close();
					
					}
					catch(IOException e) {
						System.out.print("ERROR");
					}
				try {
					FileWriter f = new FileWriter("tara.txt", true);
					BufferedWriter w = new BufferedWriter(f);
					w.write("id "+ maqhsad.get_id()  + "  balance  " + maqhsad.get_balance() + "   done" + "\n");
					w.close();
					
					}
					catch(IOException e) {
						System.out.print("ERROR");
					}		
				
			}
			if (!mabda.get_ncode().equals(maqhsad.get_ncode())) {
				
				try {
					FileWriter f = new FileWriter("transfer.txt", true);
					BufferedWriter w = new BufferedWriter(f);
					w.write( mabda.get_id() +","+ maqhsad.get_id()+","+ transfer + "\n");
					w.close();
					
					}
					catch(IOException e) {
						System.out.print("ERROR");
					}
			}
			
					
						
		      
					}
	
	
	public void menu(ArrayList <account> accountlist,ArrayList <String> transfertlist) {
		 while(true) {
			System.out.println("1) creat account");
			System.out.println("2) deposit");
			System.out.println("3) withdraw");
			System.out.println("4) transfer");
			System.out.println("5) exit");
			int action = input.nextInt();
			if (action ==1) {
				if (count< 3) {
				account account = new account();
				account.Newaccount();
				accountlist.add(account);}
				else {System.out.println("can't add");}
				count ++;
			}
			if(action ==3) {
				System.out.println("enter you id: ");
				input.nextLine();
				String target = input.nextLine();
				
				for (int i=0; i<accountlist.size ();i++) {
					if (accountlist.get(i).get_id().equals(target)) {
						System.out.println("enter how much money you wanna withdraw: ");
						int withdraw = input.nextInt();
				accountlist.get(i).withdrawmoney(withdraw);
				
					}
					
				}
				
			}
			if(action ==2) {
				System.out.println("enter you id: ");
				input.nextLine();
				String target = input.nextLine();
				for (int i=0; i<accountlist.size ();i++) {
					if (accountlist.get(i).get_id().equals(target)) {
						System.out.println("enter how much money you wanna deposit: ");
						int deposit = input.nextInt();
				accountlist.get(i).depositmoney( deposit);}}
				}
			
			
				if(action ==4) {
					tran(accountlist,transfertlist);
				}
					
				if (action == 5) {
					break;
				}
				
				}
	}}
		
	

