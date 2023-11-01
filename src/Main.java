import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.*;
import java.lang.reflect.Method;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class Main {
	 public static void main(String[] args) throws IOException, InterruptedException{
		 	Scanner sc=new Scanner(System.in);
		 	boolean run = true;
		 	do
		 	{
		 		Set<String> files=new HashSet<>();
		        System.out.println("*************");
		        listOfPackage("C:\\Users\\subra\\eclipse-workspace\\ZSGS\\Test\\src",files);
		        String[] packs=files.toArray(new String[files.size()]);
		        for(int i=0;i<packs.length;i++)
		        {
		        	System.out.println((i+1)+". "+packs[i]);
		        }
		        System.out.println("Enter the Package Number or Press 0 to Exit:");
		        int packNumb=sc.nextInt();
		        if(packNumb==0)
		        {
		        	run=false;
		        	break;
		        }
		        System.out.println("********");
		        List<String> classes = listClassesInPackage(packs[packNumb-1]);
		        for(int i=0;i<classes.size();i++)
		        {
		        	System.out.println((i+1)+". "+classes.get(i));
		        }
		        System.out.println("Enter your Choice To Run The Program or 0 to Exit:");
		        int program=sc.nextInt();
		        if(program==0)
		        {
		        	run=false;
		        	break;
		        }
		        String clas=classes.get(program-1);
		        runjavaProgram(clas,packs[packNumb-1]);	
		 	}while(run);
		 	System.out.println("Java Console Application Terminated Successfully");
	}
    public static List<String> listClassesInPackage(String packageName) {
        List<String> classNames = new ArrayList<>();
        String packagePath = packageName.replace('.', '/');
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        File packageDirectory = new File(classLoader.getResource(packagePath).getFile());
        if(packageDirectory.isDirectory()) 
        {
            File[] files = packageDirectory.listFiles();
            if(files != null)
            {
                for(File file : files) 
                {
                    if(file.isFile() && file.getName().endsWith(".class"))
                    {
                        String className = packageName+"."+file.getName().substring(0, file.getName().lastIndexOf('.'));
                        classNames.add(className);
                    }
                }
            }
        }
        return classNames;
    }
    public static void listOfPackage(String directoryName, Set<String> pack) {
        File directory = new File(directoryName);
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                String path=file.getPath();
                int srt=(path.indexOf("src"))+4;
                int end=path.lastIndexOf("\\");
                if(end>srt)
                {
                    String packName=path.substring(srt, end);
                    pack.add(packName.replace('\\', '.'));	
                }
            } else if (file.isDirectory()) {
                listOfPackage(file.getAbsolutePath(), pack);
            }
        }
    }
    public static void runjavaProgram(String className,String packPath) throws IOException, InterruptedException {
    	String updatePackPath=className;
    	String path="src/"+className.replace('.','/');
    	System.out.println(updatePackPath);
    	final String JAVA_FILE_LOCATION = "C:\\Users\\subra\\eclipse-workspace\\ZSGS\\Test\\src"+" com.subramanians.Problem1.java";
    	String command[] = {"javac",JAVA_FILE_LOCATION};
    	ProcessBuilder processBuilder = new ProcessBuilder(command);
    	Process process = processBuilder.start();
    	if( process.getErrorStream().read() != -1 ){
    	print("Compilation Errors",process.getErrorStream());
    	}else {
    		System.out.println("Sucess!!");
    	}
    	if( process.exitValue() == 0 ){
    		process = new ProcessBuilder(new String[]{"java","C:\\Users\\subra\\eclipse-workspace\\ZSGS\\Test\\src\\com\\subramanians","Problem1"}).start();
    		if( process.getErrorStream().read() != -1 ){
    		print("Errors ",process.getErrorStream());
    		}
    		else{
    		print("Output ",process.getInputStream());
    		}

    		}
    }
    	private static void print(String status,InputStream input) throws IOException{
    		BufferedReader in = new BufferedReader(new InputStreamReader(input));
    		System.out.println("************* "+status+"***********************");
    		String line = null;
    		while((line = in.readLine()) != null ){
    		System.out.println(line);
    		}
    }
    	
}



//JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//int compilationResult = compiler.run(null, null, null, path+".java");
//if (compilationResult == 0) {
//  System.out.println("Compilation is successful.");
//  Process process = Runtime.getRuntime().exec("java " + path);
//  BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
//  String line;
//  while ((line = stdInput.readLine()) != null) {
//      System.out.println(line);
//  }
//} else {
//  System.out.println("Compilation failed.");
//}
