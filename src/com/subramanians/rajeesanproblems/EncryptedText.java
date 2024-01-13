package com.subramanians.rajeesanproblems;

import java.util.Scanner;

public class EncryptedText {
	public static void main(String[] args) {
		EncryptedText app=new EncryptedText();
		app.start();
	}

	private void start() {
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter the text to be Encrypted: ");
		String input=scanner.nextLine();
		System.out.print("Enter the encryption key: ");
		int key=scanner.nextInt();
		encryptText(input,key);
	}

	private void encryptText(String input, int key) {
		StringBuilder output=new StringBuilder();
		for(int i=0;i<input.length();i++)
		{
			char encrypt=input.charAt(i);
			if(Character.isDigit(encrypt))
			{
				output.append((encrypt-'0')+key);
			}else if((int)encrypt+key>=123)
			{
				int diff= 122 - (int) encrypt;
				output.append(diff==1 ? (char)(97) : (char)(97+diff));
			}else if((int)encrypt + key >=97 && (int)encrypt+key <=122){
				output.append((char)((int)(encrypt)+key));	
			}else {
				output.append(encrypt);
			}
		}
		System.out.println(output.toString());
	}
}
