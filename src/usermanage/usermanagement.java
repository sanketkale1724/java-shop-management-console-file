package usermanage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class usermanagement {
static ArrayList<Admin> ad=new ArrayList<>();
 static {
	 try {
		 loaddatafile();
	 }
	 catch (IOException e){
		 e.printStackTrace();
		   
	 }
 }
public static void mainusermanagement()throws IOException
{
	
	 Scanner sc=new Scanner(System.in);
	 
	boolean canrunprogram=true;
	while(canrunprogram) {
		System.out.println("*****Welcome to User MAnagement*****");
		System.out.println("1.Add user");
		System.out.println("2.Edit user");
		System.out.println("3.Search user");
		System.out.println("4.Delete User");
		System.out.println("5.exit \n");
		System.out.println("enter your choise");
		int num=sc.nextInt();
		userchoise ch=new userchoise();
		if(num==ch.EXIT)
		{
			File file=new File("/Store_Management4/src/usermanage/user.csv");
			FileWriter fwriter=new FileWriter(file,false);
			BufferedWriter bwriter=new BufferedWriter(fwriter);
			for(Admin admin:ad) {
				bwriter.write(admin.name+","+admin.id+","+admin.pass+","+admin.role+"\n");
			}bwriter.close();
			fwriter.close();
			file=null;
			
			System.out.println("close the program");
			canrunprogram=false;
		}
		else if(num==ch.ADD_USER)
		{
			adduser();
		}
		else if(num==ch.EDIT_USER)
		{
			System.out.println("Enter user name:");
			sc.nextLine();
			String edit=sc.nextLine();
			edituser(edit);
		}
		else if(num==ch.SEARCH_USER) {
			System.out.println("Enter user name:");
			sc.nextLine();
			String serc=sc.nextLine();
			searchuser(serc);
		}
		else if(num==ch.DELETE_USER) {
			System.out.println("Enter user name:");
			sc.nextLine();
			String del=sc.nextLine();
			deleteuser(del);
		}
	}
	for(Admin ad2:ad) {
		System.out.println("Name:"+ad2.name);
	    System.out.println("ID:"+ad2.id);
	    System.out.println("Pass:"+ad2.pass);
	    System.out.println("Role:"+ad2.role);
		
	}
	
}
public static void adduser()
{
	 Scanner sc=new Scanner(System.in);
	Admin adr=new Admin();
	System.out.println("Enter name:");
	adr.name=sc.nextLine();
	System.out.println("Enter ID:");
	adr.id=sc.nextLine();
	System.out.println("Enter Password:");
	adr.pass=sc.nextLine();
	System.out.println("confirm password:");
	adr.compass=sc.nextLine();
	System.out.println("User Role:");
    adr.role=sc.nextLine();
    
    System.out.println("Name:"+adr.name);
    System.out.println("ID:"+adr.id);
    System.out.println("Pass:"+adr.pass);
    System.out.println("Role:"+adr.role);
     
    ad.add(adr);
    
}
public static void edituser(String name) {
	 Scanner sc=new Scanner(System.in);
	for(Admin adr:ad) {
		if(adr.name.equalsIgnoreCase(name)) {
			System.out.println("New name enter:");
			adr.name=sc.nextLine();
			System.out.println("New id:");
			adr.id=sc.nextLine();
			System.out.println("new Password:");
			adr.pass=sc.nextLine();
			System.out.println("confirm Password:");
			adr.compass=sc.nextLine();
			System.out.println("Role of User:");
			adr.role=sc.nextLine();
			System.out.println("User has been updated..");
			return;
		}
	}
	System.out.println("user not found");
}
public static void searchuser(String name)
{
	 Scanner sc=new Scanner(System.in);
	for(Admin adr:ad) {
		if(adr.name.equalsIgnoreCase(name)) {
			System.out.println("Name:"+adr.name);
			System.out.println("ID:"+adr.id);
			System.out.println("password:"+adr.pass);
			System.out.println("Role:"+adr.role);
			return;
		}
	}
	System.out.println("User not found..");
}
public static void deleteuser(String name)
{
	 Scanner sc=new Scanner(System.in);
	Iterator<Admin> ad1=ad.iterator();
	while(ad1.hasNext())
{
		Admin adr=ad1.next();
		if(adr.name.equalsIgnoreCase(name)) {
			ad1.remove();
			System.out.println("Name "+adr.name+" has been removed..");
			break;
		}
				}
}
public static void loaddatafile()throws IOException{
	File file=new File("/Store_Management4/src/usermanage/user.csv");
	FileReader fr=new FileReader(file);
	BufferedReader br=new BufferedReader(fr);
	String List="";
	while((List=br.readLine())!=null)
	{
		Admin admin=new Admin();
		String[] userdata=List.split(",");
		if(userdata.length>3)
		{
			admin.name=userdata[0];
			admin.id=userdata[1];
			admin.pass=userdata[2];
			admin.role=userdata[3];
			ad.add(admin);
		}
	}
}
public static boolean validdatauserandpassword(String name,String pass) {
	
	Iterator<Admin> userIterator=ad.iterator();
	
	while(userIterator.hasNext()) {
		
		Admin admin=userIterator.next();
		
		if(admin.name.equalsIgnoreCase(name) && admin.pass.equalsIgnoreCase(pass)) {
			return true;
		}
		
	}
	return false;
	
}
}

