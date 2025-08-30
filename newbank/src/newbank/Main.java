package newbank;
import java.util.Scanner;
public class Main {
	
	public static void main(String[] args) {
		Scanner inp=new Scanner(System.in);
		
		bank b = new bank();
		// TODO Auto-generated method stub
		while(true) {
		System.out.println("1) new customer");
		System.out.println("2) new cashier");
		System.out.println("3) login");
		System.out.println("4) show trakonesh");
		System.out.print("enter your action: ");
		int action = inp.nextInt();
		switch(action){
		case(1):{
			b.cust();
		break;
		}
		case(2):{
			b.cash();
			break;
		}
		case(3):{
			
			b.log();
			break;
		}
		case(4):{
			bank.tara();
			break;
		}
		}
	
		
		}
	}

}
