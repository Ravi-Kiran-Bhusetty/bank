package com.bank.view;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import com.bank.model.User;

public class ViewUser {

	static int count = 1;
	static long accountNo = 101001;
	public static void main(String[] args) {
		
		ArrayList<User> al = new ArrayList<>();
		al.add(setInfo());
		al.add(setInfo());
		al.add(setInfo());
		al.add(setInfo());
		al.add(setInfo());
		try {
			FileOutputStream file = new FileOutputStream("C:\\Users\\VJIT\\Desktop\\CapgPrograms\\BankListObjects.txt");
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(al);
			out.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

	private static User setInfo() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the details of customer "+count);
		User u = new User();
		u.setAccountNo(accountNo);
		System.out.println("Enter first name and last name");
		u.setFirstName(sc.next());
		u.setLastName(sc.next());
		System.out.println("Enter account type");
		u.setAccountType(sc.next());
		System.out.println("Enter aadhaar card number");
		u.setAadhaarNo(sc.nextLong());
		System.out.println("Enter pan card number");
		u.setPanCardNo(sc.next());
		System.out.println("Enter mobile number");
		u.setPhoneNo(sc.nextLong());
		System.out.println("Enter the address");
		u.setAddress(sc.next());
		count++;
		accountNo++;
		return u;
	}

}
