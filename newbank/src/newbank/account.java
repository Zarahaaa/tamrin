package newbank;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

	public class account {
	private int balance;
	private String id;
	private String ncode;
	private Scanner input = new Scanner(System.in);

	static int count = 0;
		public void Newaccount() {
			System.out.println("enter your national code: ");
			this.ncode = input.nextLine();
			System.out.println("enter how much money you have: ");
			this.balance = input.nextInt();
			this.id = ncode + "" + count+ "";
			System.out.println(id);
			count++;
			
		}
		
		public void withdrawmoney(int withdraw) {
			if(this.balance>=withdraw ) {
			this.balance = this.balance - withdraw;
			try {
				FileWriter f = new FileWriter("tara.txt", true);
				BufferedWriter w = new BufferedWriter(f);
				w.write("id "+ this.id + "  balance  " + this.balance + "   done        " + "\n");
				w.close();
				
				}
				catch(IOException e) {
					System.out.print("ERROR");
				}}
			else {
				System.out.print("ERROR");
				try {
					FileWriter f = new FileWriter("tara.txt", true);
					BufferedWriter w = new BufferedWriter(f);
					w.write("id "+ this.id + "  balance  " + this.balance + " not  done         " + "\n");
					w.close();
					
					}
					catch(IOException e) {
						System.out.print("ERROR");
					}
			}
		}
		public void depositmoney(int deposit) {
			
			this.balance = this.balance + deposit;
			try {
				FileWriter f = new FileWriter("tara.txt", true);
				BufferedWriter w = new BufferedWriter(f);
				w.write("id "+ this.id + "  balance  " + this.balance + "   done" + "\n");
				w.close();
				
				}
				catch(IOException e) {
					System.out.print("ERROR");
				}
			
		}

					
			
		
		
		public String get_id() {
			return this.id;
		}
		public String get_ncode() {
			return this.ncode;
		}
		public int get_balance() {
			return this.balance;
		}
		
		public void set_balance(int balance) {
			this.balance = balance;
		}
		
		public void set_id(String id) {
			this.id = id;
		}
		
		
			

		
		}

