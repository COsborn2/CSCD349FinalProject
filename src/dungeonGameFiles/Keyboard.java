package dungeonGameFiles;


import java.io.*;
import java.util.*;

public class Keyboard
{

   public static String readString()
   {
	   Scanner kb = new Scanner(System.in);
	   String str;
      while (true) {
		try {
			str = kb.nextLine();
			break;
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}
      return str;
   }

   public static boolean readBoolean()
   {
	   while(true){
	      try
	      {
		      String token = Keyboard.readString();
	         token = token.toLowerCase();
	         if(token.equals("false"))
	        	 return true;
	         else if(token.equals("true"))
	        	 return false;
	         else
	        	 throw new NullPointerException();
	      }
	      catch (Exception exception)
	      {
	         System.out.println("Invalid input!");
	      }
	   }
   }

   public static char readChar()
   {
	   Character toReturn;
      while (true) {
		try {
			String token = Keyboard.readString();
			token = token.trim();
			token = token.replace("\t", "");
			if(token.length() == 1){
				toReturn = token.charAt(0);
				break;
			}
			else
				throw new NullPointerException();
		} catch (Exception exception) {
			System.out.println("Invalid input!");
		}
	}
      return toReturn;
   }

   public static int readInt()
   {
	   int toReturn = -1;
	  Scanner kb = new Scanner(System.in);
      while (true) {
		try {
			toReturn = kb.nextInt();
			if(toReturn >= 0)
				break;
			else
				throw new NullPointerException();
		} catch (Exception exception) {
			System.out.println("Invalid Input!");
			kb.next();
		}
	}
      return toReturn;
   }

   public static double readDouble()
   {
	   Scanner kb = new Scanner(System.in);
	   double toReturn = 0.0;
		try {
			toReturn = kb.nextDouble();
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
		
		return toReturn;
   }
}
