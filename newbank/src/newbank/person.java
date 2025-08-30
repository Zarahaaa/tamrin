package newbank;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class person {
	protected String ncode;
	protected String name;
	protected String username;
	protected String password;
	
	public void set_name(String name) {
		this.name=name;
		
	}
	
	public void set_ncode(String ncode) {
		this.ncode = ncode;
	}
	public void set_user(String username) {
		this.username=username;
	}
	
	public void set_pass(String password) {
		this.password = password;
	}
	
	public void login(ArrayList <account> accountlist,ArrayList <customer> customerlist,ArrayList <cashier> cashierlist,ArrayList <String> transfertlist) {
		
		 Scanner inp = new Scanner(System.in);
	        System.out.print("enter 1 if you are customer, else cashier: ");
	        int per = inp.nextInt();
	        inp.nextLine();

	        System.out.print("enter username: ");
	        String user = inp.nextLine();
	        System.out.print("enter password: ");
	        String pass = inp.nextLine();

	        if (per == 1) {
	            try (BufferedReader r = new BufferedReader(new FileReader("customers.txt"))) {
	                String line;
	                while ((line = r.readLine()) != null) {
	                    String[] parts = line.split(",");
	                    if (parts.length < 4) continue;
	                    String nc = parts[0];
	                    String name = parts[1];
	                    String username = parts[2];
	                    String password = parts[3];

	                    if (username.equals(user) && password.equals(pass)) {
	                        customer c = new customer();
	                        c.set_ncode(nc);
	                        c.set_name(name);
	                        c.set_user(username);
	                        c.set_pass(password);
	                        System.out.println("login successfully");
	                        customerlist.add(c);
	                        c.menu(accountlist, transfertlist);
	                        return;
	                    }
	                }
	                System.out.println("not found");
	            } catch (IOException e) {
	                System.out.println("ERROR");
	            }
	        } else {
	            try (BufferedReader r = new BufferedReader(new FileReader("cashiers.txt"))) {
	                String line;
	                while ((line = r.readLine()) != null) {
	                    String[] parts = line.split(",");
	                    if (parts.length < 4) continue;
	                    String nc = parts[0];
	                    String name = parts[1];
	                    String username = parts[2];
	                    String password = parts[3];

	                    if (username.equals(user) && password.equals(pass)) {
	                        cashier c = new cashier();
	                        c.set_ncode(nc);
	                        c.set_name(name);
	                        c.set_user(username);
	                        c.set_pass(password);
	                        System.out.println("login successfully");
	                        cashierlist.add(c);
	                        c.accept(transfertlist, accountlist);
	                        return;
	                    }
	                }
	                System.out.println("not found");
	            } catch (IOException e) {
	                System.out.println("ERROR");
	            }
	        }
	    }
	}

	
		
		