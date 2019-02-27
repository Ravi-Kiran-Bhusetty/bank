package com.bank.view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import com.bank.model.User;



public class ViewUserDetails extends ViewUser {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first name and last name");
		String fname = sc.next();
		String lname = sc.next();
		System.out.println("Enter account type");
		String accountType = sc.next();
		System.out.println("Enter aadhaar card number");
		long aadhaarNo = sc.nextLong();
		System.out.println("Enter pan card number");
		String panNo = sc.next();
		System.out.println("Enter mobile number");
		long mobileNo = sc.nextLong();
		System.out.println("Enter the address");
		String address = sc.next();
		
		try {
			FileInputStream f1 = new FileInputStream("C:\\\\Users\\\\VJIT\\\\Desktop\\\\CapgPrograms\\\\BankListObjects.txt");
			ObjectInputStream in = new ObjectInputStream(f1);
			ArrayList<User> al1 = (ArrayList<User>)in.readObject();
			User u = new User();
			int n = al1.size();
			int count = 0;
			for (int i = 0; i < al1.size(); i++) {
				u = al1.get(i);
				if(u.getAadhaarNo() == aadhaarNo) {
					System.out.println("User Already Exists");
					//System.out.println(u.getAccountNo());
					break;}
				else
					count++;
			}
			System.out.println(count);
			if(count == n)
			{
				System.out.println("Customer not existing");
				u.setAccountNo(accountNo+1);
				u.setFirstName(fname);
				u.setLastName(lname);
				u.setAccountType(accountType);
				u.setAadhaarNo(aadhaarNo);
				u.setPanCardNo(panNo);
				u.setPhoneNo(mobileNo);
				u.setAddress(address);
				al1.add(u);
				FileOutputStream file = new FileOutputStream("C:\\Users\\VJIT\\Desktop\\CapgPrograms\\BankListObjects.txt");
				ObjectOutputStream out = new ObjectOutputStream(file);
				out.writeObject(al1);
				out.close();
			
			}	
			//System.out.println(u.getAccountNo());
		} catch (FileNotFoundException e) {		
			e.printStackTrace();
		} catch (IOException e) {	
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
