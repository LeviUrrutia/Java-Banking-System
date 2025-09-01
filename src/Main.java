import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

        class Person {
        private String name;
        private int userId;
        private float liquid;

        public Person(String name, int userId, float initialLiquid){
            this.name = name;
            this.userId = userId;
            this.liquid = initialLiquid;
        }

        public String getName() {
                return name;
            }

        public int getUserId(){
            return userId;
        }

        public float getLiquid(){
            return liquid;
        }

        public void deposit(float depositAmount){
            if(depositAmount > 0){
                liquid += depositAmount;
                System.out.println("Deposited: " + depositAmount);
            }else{
                System.out.println("Invalid input.");
            }
        }

        public void withdraw(float withdrawAmount){
            if(withdrawAmount > 0 && withdrawAmount <= liquid){
                liquid -= withdrawAmount;
                System.out.println("Withdraw: " + withdrawAmount);
            }else if (withdrawAmount > liquid){
                System.out.println("Insufficient balance");
            }else{
                System.out.println("Invalid Input");
            }
        }

        public void displayDetails(){
            System.out.println("---Client Details---");
            System.out.println("Name: " + name);
            System.out.println("ID: " + userId);
            System.out.println("Funds: " + liquid);
        }
    }

public class Main {
    private static Map<Integer, Person> persons = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);
    //private static int accountCounter = 1000;

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n=== BANK MANAGEMENT SYSTEM ===");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Display All Accounts");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> depositFund();
                case 3 -> withdrawFund();
                case 4 -> checkBalance();
                case 5 -> displayAllAccounts();
                case 6 -> {
                    System.out.println("Thank you!");
                    return;
                }
                default -> System.out.println("Invalid!");
            }
        }
    }


    private static void createAccount() {
        System.out.println("Enter name: ");
        sc.nextLine();
        String userInputName = sc.nextLine();

        System.out.println("How much is your initial balance? ");
        float userInputFund = 0.0f;
        boolean validInputFund = false;

        while(!validInputFund){
            try{
                userInputFund = sc.nextFloat();
                validInputFund = true;
            }catch(InputMismatchException e){
                System.out.println("Invalid input.");
                sc.nextLine();
            }
        }
        System.out.println("Enter ID: ");
        int userInputId = 0;
        boolean validInputId = false;

        while(!validInputId){
            try{
                userInputId = sc.nextInt();
                validInputId = true;
            }catch(InputMismatchException e){
                System.out.println("Invalid input.");
                sc.nextLine();
            }
        }
        Person person = new Person(userInputName, userInputId, userInputFund);
        persons.put(userInputId, person);
        System.out.println("Created Account: " + userInputId);
    }

    public static void depositFund(){
        System.out.println("Enter Account Number: ");
        int accNum = sc.nextInt();
        if(persons.containsKey(accNum)){
            System.out.println("Enter Amount to Deposit: ");
            float amount = sc.nextFloat();
            persons.get(accNum).deposit(amount);
        }else{
            System.out.println("Account is Invalid!");
        }
    }

    public static void withdrawFund(){
        System.out.println("Enter Account Number: ");
        int accNum = sc.nextInt();
        if(persons.containsKey(accNum)){
            System.out.println("Enter Amount to Withdraw: ");
            float amount = sc.nextFloat();
            persons.get(accNum).withdraw(amount);
        }else{
            System.out.println("Account is Invalid!");
        }
    }

    public static void checkBalance(){
        System.out.println("Enter Account Number: ");
        int accNum = sc.nextInt();
        if(persons.containsKey(accNum)){
            Person per = persons.get(accNum);
            System.out.println("Hi " + per.getName() + ", your remaining balance is " + per.getLiquid());
        }else{
            System.out.println("Invalid Account Number!");
        }
    }

    public static void displayAllAccounts(){
        if(persons.isEmpty()){
            System.out.println("No Account Found!");
        }else{
            for(Person per : persons.values()){
                per.displayDetails();
            }
        }
    }
}


