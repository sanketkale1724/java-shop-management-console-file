package productmanage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class productmanagement {
	static ArrayList<product> pr=new ArrayList<>();
public static void productproject() throws IOException {
	loaddatafile();
	Scanner sc=new Scanner(System.in);
	boolean programrun=true;
	while(programrun) {
		System.out.println("*******Welcome to Product Management*******");
		System.out.println("1.Add Product");
		System.out.println("2.Edit Product");
		System.out.println("3.Search Product");
		System.out.println("4.Delete Product");
		System.out.println("5.Quit \n");
		System.out.println("Enter your choise");
		int choise=sc.nextInt();
		productchoise prochoise=new productchoise();
		if(choise==prochoise.Quit) {
			File file=new File("/Store_Management4/src/productmanage/product.csv");
			FileWriter fwriter=new FileWriter(file,false);
			BufferedWriter bwriter=new BufferedWriter(fwriter);
			for(product p1:pr) {
				bwriter.write(p1.proname+","+p1.proID+","+p1.price+","+p1.quantity+","+p1.category+"\n");
				bwriter.close();
			fwriter.close();
			file=null;
			System.out.println("program closed");
			programrun=false;
			}
		}
		else if(choise==prochoise.AddProduct) {
			addproduct();
		}
		else if(choise==prochoise.EDITProduct) {
			System.out.println("Enter Produt Name");
			sc.nextLine();
			String edit=sc.nextLine();
			Editproduct(edit);	
		}
		else if(choise==prochoise.SearchProduct)
		{
			System.out.println("Enter Product Name");
			sc.nextLine();
			String search=sc.nextLine();
			Searchproduct(search);
		}
		else if(choise==prochoise.DeleteProduct) {
			System.out.println("Enter Product Name");
			sc.nextLine();
			String delete=sc.nextLine();
			Deleteproduct(delete);
		}
	}
	for(product p1:pr) {
		System.out.println("Product Name:"+p1.proname);
		System.out.println("Product ID:"+p1.proID);
		System.out.println("Price:"+p1.price);
		System.out.println("Quantity:"+p1.quantity);
		System.out.println("Catagory:"+p1.category);
	}
	
}
public static void addproduct()
{
	Scanner sc=new Scanner(System.in);
	product p1=new product();
	System.out.println("Enter Product Name");
	p1.proname=sc.nextLine();
	System.out.println("Enter Product ID");
	p1.proID=sc.nextLine();
	System.out.println("Enter Product price");
	p1.price=sc.nextLine();
	System.out.println("Enter Product Quantity");
	p1.quantity=sc.nextLine();
	System.out.println("Enter Product Category ");
	p1.category=sc.nextLine();
	System.out.println("\n");
	System.out.println("Product Name:"+p1.proname);
	System.out.println("Product ID:"+p1.proID);
	System.out.println("Price:"+p1.price);
	System.out.println("Quantity:"+p1.quantity);
	System.out.println("Catagory:"+p1.category+"\n");
	pr.add(p1);
	
}
public static void Searchproduct(String proname) {
	Scanner sc=new Scanner(System.in);
	for(product p1:pr) {
		if(p1.proname.equalsIgnoreCase(proname)) {
			System.out.println("Product Name:"+p1.proname);
			System.out.println("Product ID:"+p1.proID);
			System.out.println("Price:"+p1.price);
			System.out.println("Quantity:"+p1.quantity);
			System.out.println("Catagory:"+p1.category);
			return;
		}
	}
	System.out.println("Product not found");
}
public static void Deleteproduct(String proname) {
	Scanner sc=new Scanner(System.in);
	Iterator<product> p1=pr.iterator();
	while(p1.hasNext()) {
		product p2=p1.next();
		if(p2.proname.equalsIgnoreCase(proname)) {
			p1.remove();
			System.out.println("Product"+p2.proname+" has been removed"+"\n");
			break;
		}
	}
	
}
public static void Editproduct(String proname) {
	Scanner sc=new Scanner(System.in);
	for(product p1:pr) {
		if(p1.proname.equalsIgnoreCase(proname)) {
			System.out.println("Enter new Product Name");
			p1.proname=sc.nextLine();
			System.out.println("Enter new Product ID");
			p1.proID=sc.nextLine();
			System.out.println("Enter new Product price");
			p1.price=sc.nextLine();
			System.out.println("Enter Product Quantity");
			p1.quantity=sc.nextLine();
			System.out.println("Enter Product Category \n");
			p1.category=sc.nextLine();
			System.out.println("Product has been updated"+"\n");
			return;
		}
	}
}
public static void loaddatafile()throws IOException{
	File file=new File("/Store_Management4/src/productmanage/product.csv");
	FileReader fr=new FileReader(file);
	BufferedReader br=new BufferedReader(fr);
	String List="";
	while((List=br.readLine())!=null)
	{
		product p1=new product();
		String[] productdataArray=List.split(",");
		if(productdataArray.length>5)
		{
		p1.proname=productdataArray[0];
		p1.proID=productdataArray[1];
			p1.price=productdataArray[2];
			p1.quantity=productdataArray[3];
			p1.category=productdataArray[4];
			pr.add(p1);
		}
	}
	
	
}
}

