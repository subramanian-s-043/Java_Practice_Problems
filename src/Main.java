import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class Main {
	private static String[] listOfPackages(String directory)
	{
		File files=new File(directory);
		return files.list();
	}
	private static String initialPath() {
		try {
			return new File(".").getCanonicalPath() + "\\src\\com\\subramanians";
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		return null;
	}
	private static boolean isValidChoice(String input, int availableCount) {
		if(!input.matches("[0-9]+")) 
		{
			System.out.println("Please enter the valid input.");
			return false;
		}
		int choice = Integer.parseInt(input);
		if(choice+1>availableCount||choice<1) 
		{
			System.out.println("Please choose the valid option.");
			return false;
		}
		return true;
	}
	 public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException
	 {
		 	Scanner sc=new Scanner(System.in);
	        System.out.println("********************************************");
	        System.out.println("\t CONSOLE APPLICATION  \t");
		 	String path=initialPath();
		 	Stack<String> pathStack=new Stack<String>();
		 	pathStack.push(path);
		 	do
		 	{
		 		System.out.println("******************************************************************");
		 		System.out.println("DIR:"+" "+ path  +" ");
		        System.out.println("******************************************************************");
			 	String[] folder=listOfPackages(path);
			 	String fileName="";
			 	for(int i=0;i<folder.length;i++)
			 	{
			 		if(folder[i].contains(".java"))
			 			System.out.println(i+1+". "+folder[i]+ "  (Executable Java File)");
			 		else
			 			System.out.println(i+1+". "+folder[i]+"  (Folder)");
					if (i + 1 == folder.length) {
						if (pathStack.size() == 1) {
							System.out.println(i + 2 + ". " + "Exit");
						} else {
							System.out.println(i + 2 + ". " + "Go back");
							System.out.println(i + 3 + ". " + "Exit");
						}
					}
			 	}
			 	System.out.println("Enter Your Choice : ");
			 	String input=sc.nextLine();
			 	if (!isValidChoice(input, folder.length+3 ))
			 	{
					continue;
				}
				int choice = Integer.parseInt(input);
				if (choice == folder.length+1 || choice==folder.length + 2) {
					if (pathStack.size() == 1 || choice==folder.length + 2) {
						System.out.println("******************************************************************");
						System.out.println("Application Closed succesfully,Press Run to Start Again.");
						return;
					}
					pathStack.pop();
					path = pathStack.peek();
				} else {
					fileName = folder[choice - 1];
					if (fileName.contains(".java")) {
						try {
							System.out.println("******************************************************************");
							executeProgram(path, fileName);
							System.out.println("******************************************************************");
							System.out.println("Program Executed succesfully.");
						} catch (IllegalArgumentException e) {
							e.printStackTrace();
						}
						continue;
					} else {
						path = path + "\\" + fileName;
						pathStack.push(path);
					}
				}
		 	}while(true);
//		 	System.out.println("Java Console Application Terminated Successfully");
	}
		private static void executeProgram(String directoryPath, String className) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
			int index = directoryPath.indexOf("\\src\\");
			directoryPath = directoryPath.substring(index + 5) + "." + className.substring(0, className.lastIndexOf('.'));
			directoryPath = directoryPath.replace("\\", ".");
			try {
				Class obj = Class.forName(directoryPath);
				Object instance = obj.newInstance();
				try {
			    	Method method = obj.getMethod("mainFunction", null);
			    	Object t=method.invoke(instance, null);
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				}

			} catch (ClassNotFoundException e) {
				System.out.println("That program doesn't exist.");
			}
			return;

		}
    	
}
