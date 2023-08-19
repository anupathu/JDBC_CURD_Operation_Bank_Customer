package com.nalla.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.nalla.model.Customer;
import com.nalla.service.DatabaseService;

public class MainClass {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		boolean isRunning = true;
		try (Scanner scanner = new Scanner(System.in);) {
			while (isRunning) {
				System.out.println("WELCOME TO HDFC BANK!!!!!!!");
				System.out.println("Enter your choice");
				System.out.println("1. Insert Customer Deatils");
				System.out.println("2. View Customer Details");
				System.out.println("3.  get Customer ID");
				System.out.println("4. Delete Customer");
				System.out.println("5. Update Customer Details");
				System.out.println("6. Transfer Amount");
				System.out.println("7. Exit");
				int choice = Integer.parseInt(scanner.nextLine());
				switch (choice) {
				case 1:
					System.out.println("Enter customer ID");
					int a = Integer.parseInt(scanner.nextLine());
					System.out.println("Enter customer Name");
					String b = scanner.nextLine();
					System.out.println("Enter customer AccNo");
					int c = Integer.parseInt(scanner.nextLine());
					System.out.println("Enter customer AccType");
					String d = scanner.nextLine();
					System.out.println("Enter customer Balance");
					int e = Integer.parseInt(scanner.nextLine());
					Customer cs1 = new Customer(a, b, c, d, e);

					DatabaseService.insert_Customer_Details(cs1);
					break;
				case 2:

					DatabaseService.view_CustomerList();
					break;
				case 3:

					System.out.println("Enter customer ID");
					int f = Integer.parseInt(scanner.nextLine());

					DatabaseService.getCustomerByID(f);

					break;
				case 4:
					System.out.println("Enter customer ID");
					int g = Integer.parseInt(scanner.nextLine());

					DatabaseService.deleteCustomerByID(g);

					break;
				case 5:
					System.out.println("Enter customer ID");
					int i = Integer.parseInt(scanner.nextLine());
					boolean byID = DatabaseService.getCustomerByID(i);
					if (byID) {
						
						System.out.println("update customer Name");
						String j = scanner.nextLine();
						System.out.println("update customer AccType");
						String k = scanner.nextLine();
						
						Customer cs2 = new Customer(i,j,k);

						DatabaseService.updateCustomerDeatils(cs2);
					}else {
						System.out.println("No update");
					}

					break;
				case 6:
					DatabaseService.view_CustomerList();
					System.out.println("Enter From Account Number");
					int faccno = Integer.parseInt(scanner.nextLine());
					System.out.println("Enter To Account Number");
					int taccno = Integer.parseInt(scanner.nextLine());
					System.out.println("Enter Balance to be tansfered");
					
					int amt = Integer.parseInt(scanner.nextLine());
										DatabaseService.transferAmount(faccno, taccno,amt);
					break;
				case 7:
					System.out.println("Thank you ... Visit again :)");
					System.exit(0);
					//isRunning = false;
					break;
				default:
					System.out.println("Incorrect choice");
					break;

				}

			}
		} catch (Exception e) {
			new RuntimeException("Something went wrong" + e);
		}

	}

}
