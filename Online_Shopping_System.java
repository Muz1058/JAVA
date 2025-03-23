import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;
class Product{
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void display(){
        System.out.println("Name : "+name+"\nPrice :"+price+"\nQuantity :"+quantity);
    }
}
class Electronics extends Product{
    private String brand;
    private Date purchaseDate;
    private int warrentyYear;

    public Electronics(String name, double price, int quantity, String brand,
                       Date purchaseDate, int warrentyYear) {
        super(name, price, quantity);
        this.brand = brand;
        this.purchaseDate = purchaseDate;
        this.warrentyYear = warrentyYear;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getWarrentyYear() {
        return warrentyYear;
    }

    public void setWarrentyYear(int warrentyYear) {
        this.warrentyYear = warrentyYear;
    }

    public Date getWarrentyExpiryDate(){
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(purchaseDate);
        calendar.add(Calendar.YEAR,warrentyYear);
        return calendar.getTime();
    }
    public boolean isUnderWarrenty(){
        Date currentDate=new Date();
        return currentDate.before(getWarrentyExpiryDate());
    }
    public void display(){
        super.display();
        System.out.println("\nBrand: "+brand+"\nPurchase Date "+purchaseDate+"\nWarrenty Expiry Date : "+getWarrentyExpiryDate());
    }
}


class Clothing extends Product{
    private String size;
    private String colour;
    private Date purchaseDate;

    public Clothing(String name, double price, int quantity, String size,
                    String colour, Date purchaseDate) {
        super(name, price, quantity);
        this.size = size;
        this.colour = colour;
        this.purchaseDate = purchaseDate;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public boolean canChange(){
        Date currentDate=new Date();
        Calendar calender=Calendar.getInstance();
        calender.setTime(purchaseDate);
        calender.add(Calendar.DAY_OF_YEAR,7);
        Date deadline= calender.getTime();
        return currentDate.before(deadline);
    }
    public void changeCloth(String newSize){
        if(canChange()){
            setSize(newSize);
            System.out.println("Cloth Size change to :"+ newSize);
        }
        else {
            System.out.println("Change Period has been Expired!!" +
                               "\nCannot change cloth size");
        }
    }
    public void display(){
        System.out.println("\nSize: "+size+"\nColour: "+colour+"\nPurchase Date: "+purchaseDate);
        super.display();
    }
}
class Books extends Product{
    private String bookName;
    private String author;
    private String isbn;

    public Books(String name, double price, int quantity, String bookName, String author, String isbn) {
        super(name, price, quantity);
        this.bookName = bookName;
        this.author = author;
        this.isbn = isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void display(){
        System.out.println("\nBook Name: "+bookName+"\nAuthor Name: "+author+"\nISBN: "+isbn);
        super.display();
    }
}

abstract class Customer{
    private String name;
    private String email;
    private String address;

    public Customer(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    abstract public double calculateDiscount();

    public void display(){
        System.out.println("\n--------------Customer Details--------------\n");
        System.out.println("Name: "+name+"\nEmail: "+email+"\nAddress: "+address);
        if(calculateDiscount()>0)
            System.out.println("\nDiscount "+calculateDiscount()*100+"%");
    }
}
class RegularCustomer extends Customer{

    private float loyaltyPoints;

    public RegularCustomer(String name, String email, String address,
                           float loyaltyPoints) {
        super(name, email, address);
        this.loyaltyPoints = loyaltyPoints;
    }

    public float getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(float loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }
    public double calculateDiscount(){
        if (loyaltyPoints>100)
            return 0.10;
        else if (loyaltyPoints>=50) {
            return 0.05;
        }
        else
            return 0;
    }

    public void display() {
        super.display();
        System.out.println("\nCustomer Type: Regular"+"\nLoyalty Points: "+loyaltyPoints);
        if(calculateDiscount()>0)
            System.out.println("\nDiscount "+calculateDiscount()*100+"%");
    }
}
class PremiumCustomer extends Customer{
    private float loyaltyPoints;

    public PremiumCustomer(String name, String email, String address,
                           float loyaltyPoints)
    {
        super(name, email, address);
        this.loyaltyPoints = loyaltyPoints;
    }

    public float getLoyaltyPoints()
    {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(float loyaltyPoints)
    {
        this.loyaltyPoints = loyaltyPoints;
    }
    public double calculateDiscount()
    {
        if (loyaltyPoints>100)
            return 0.20;
        else if (loyaltyPoints>=50)
        {
            return 0.10;
        }
        else
            return 0.5;
    }

    @Override
    public void display()
    {
        super.display();
        System.out.println("\nCustomer Type: Premium Customer\nLoyalty Points: "+loyaltyPoints+"\nDiscount "+calculateDiscount()*100+"%");
    }
}
class ShoppingCart{
    private ArrayList<Product> productList;
    public ShoppingCart(){
        productList=new ArrayList<>();
    }
    public void addProduct(Product myProduct){
        productList.add(myProduct);
    }
    public void removeProduct(Product myProduct){
        productList.remove(myProduct);
    }
    public boolean removeProduct(int index) {
        if (index >= 0 && index < productList.size())
        {
            productList.remove(index);
            return true;
        }
        return false;
    }
    public boolean removeProductByName(String productName)
    {
        for (Product product : productList)
        {
            if (product.getName().equalsIgnoreCase(productName))
            {
                productList.remove(product);
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty()
    {
        return productList.isEmpty();
    }

    public double totalPrice(Customer customer)
    {
        double total=0.0;
        for (Product product : productList)
        {
            double productPrice = product.getPrice() * product.getQuantity();
            total += productPrice-(productPrice*customer.calculateDiscount())  ;
        }
        return total;
    }
    public void displayCart()
    {
        if (productList.isEmpty())
        {
            System.out.println("Your shopping cart is empty.");
        }
        else
        {
            System.out.println("\n--------------Shopping Cart Details--------------\n");
            for (Product product : productList) {
                product.display();
                System.out.println("\t\t------------------------------------");
            }
        }
    }
}



public class Online_Shopping_System {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ShoppingCart cart = new ShoppingCart();//ShoppingCart obj

        int customerType;
        do
        {
            System.out.println("\nWelcome to the Online Shopping System!");
            System.out.println("Select Customer Type:\n1. Regular Customer\n2. Premium Customer\nEnter: ");
            customerType = scanner.nextInt();
            if(customerType<1 && customerType>2)
            {
                System.out.println("Invalid Coice!!\nTry Again\n");
            }
        }while (customerType<1 && customerType>2);
        System.out.println("You selected: " + (customerType == 1 ? "Regular Customer" : "Premium Customer"));

        Customer customer;//customer obj
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Enter your address: ");
        String address = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Enter your loyalty points: ");
        float loyaltyPoints = scanner.nextFloat();

        if (customerType == 1)
        {
            customer = new RegularCustomer(name, email, address, loyaltyPoints);
        }
        else
        {
            customer = new PremiumCustomer(name, email, address, loyaltyPoints);
        }

        // Menu
        boolean shopping = true;
        while (shopping)
        {
            System.out.println("\n--- Shopping Menu ---");
            System.out.println("1. Add Product to Cart");
            System.out.println("2. Remove Product from Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout and Calculate Total");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1)
            {
                System.out.println("\nSelect Product Type:\n1. Electronics\n2. Clothing\n3. Books\nEnter: ");
                int productType = scanner.nextInt();

                System.out.print("Enter product name: ");
                String productName = scanner.nextLine();
                System.out.print("Enter product price: ");
                double price = scanner.nextDouble();
                System.out.print("Enter product quantity: ");
                int quantity = scanner.nextInt();

                if (productType == 1)
                {
                    System.out.print("Enter brand: ");
                    String brand = scanner.nextLine();
                    System.out.print("Enter warranty period in years: ");
                    int warrantyYears = scanner.nextInt();
                    Date purchaseDate = new Date();
                    Electronics electronics = new Electronics(productName, price, quantity, brand, purchaseDate, warrantyYears);
                    cart.addProduct(electronics);
                }
                else if (productType == 2)
                {
                    System.out.print("Enter size: ");
                    String size = scanner.nextLine();

                    System.out.print("Enter color: ");
                    String color = scanner.nextLine();
                    Date clothPurchaseDate = new Date();
                    Clothing clothing = new Clothing(productName, price, quantity, size, color, clothPurchaseDate);
                    cart.addProduct(clothing);
                }
                else if (productType == 3)
                {
                    System.out.print("Enter book name: ");
                    String bookName = scanner.nextLine();
                    scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    Books books = new Books(productName, price, quantity, bookName, author, isbn);
                    cart.addProduct(books);
                }
                else
                {
                    System.out.println("Invalid product type!!\nPlease try again.");
                }

            }
            else if (choice == 2)
            {
                if (cart.isEmpty())
                {
                    System.out.println("Your shopping cart is empty. Nothing to remove.");
                }
                else
                {
                    System.out.println("Select Removal Option:");
                    System.out.println("1. Remove by Product Number");
                    System.out.println("2. Remove by Product Name");
                    int removeOption = scanner.nextInt();
                    scanner.nextLine();

                    if (removeOption == 1)
                    {
                        cart.displayCart();
                        System.out.print("Enter the number corresponding to the product you want to remove: ");
                        int removeChoice = scanner.nextInt();

                        if (cart.removeProduct(removeChoice - 1))
                        {
                            System.out.println("Product removed successfully.");
                        }
                        else
                        {
                            System.out.println("Invalid choice. No product removed.");
                        }
                    }
                    else if (removeOption == 2)
                    {
                        System.out.print("Enter the name of the product you want to remove: ");
                        String productName = scanner.nextLine();
                        if (cart.removeProductByName(productName))
                        {
                            System.out.println("Product removed successfully.");
                        }
                        else
                        {
                            System.out.println("Product not found. No product removed.");
                        }
                    }
                    else
                    {
                        System.out.println("Invalid option. No product removed.");
                    }
                }
            }
            else if (choice == 3)
            {
                cart.displayCart();
            }
            else if (choice == 4)
            {
                double total = cart.totalPrice(customer);
                customer.display();
                System.out.println("Final Total (including discounts): " + total);
                shopping = false;
            }
            else if (choice == 5)
            {
                System.out.println("------------Thank you for shopping with us!------------");
                shopping = false;
            }
            else
            {
                System.out.println("Invalid choice!!\n Please try again.");
            }
        }
        scanner.close();
    }
}
