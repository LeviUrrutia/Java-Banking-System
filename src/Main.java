import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;



        class Person {
        private String name;
        private int userId;
        private float liquid;

        public String getName() {
            return name;
        }

        public void setName(String userName) {
            this.name = userName;
        }

        public int getUserId(){
            return userId;
        }

        public void setUserId(int id){
            this.userId = id;
        }

        public float getLiquid(){
            return liquid;
        }

        public void setLiquid(float liq){
            this.liquid = liq;
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

        public void displayDetails(String uName, int uId, float uLiquid){
            this.name = uName;
            this.userId = uId;
            this.liquid = uLiquid;

            System.out.println("---Client Details---");
            System.out.println("Name: " + uName);
            System.out.println("ID: " + uId);
            System.out.println("Funds: " + uLiquid);
        }
    }

public class Main {
    private static Map<Integer, Person> person = new HashMap<>();
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
                }
                default -> System.out.println("Invalid!");
            }
        }
    }


    private static void createAccount() {

    }


    //Get User Name
            System.out.println("Please enter your name: ");
    String userInputName = sc.nextLine();
            myObj.setName(userInputName); //Set User Name

    //Get User ID
    int userInputId = 0;
    boolean validInputId = false;

    //Numerical value checker
            while(!validInputId)

    {
        System.out.println("Enter User ID: ");
        try {
            userInputId = sc.nextInt();
            validInputId = true;
        } catch (InputMismatchException e) {
            System.out.println("Please enter numerical values only!");
            sc.nextLine(); //clear invalid input
        }
    }
            myObj.setUserId(userInputId); //Set User ID

    //Get User Funds
    float userInputFund = 0.0f;
    boolean validInputFund = false;

            while(!validInputFund)

    {
        System.out.println("Enter initial funds: ");
        try {
            userInputFund = sc.nextFloat();
            validInputFund = true;
        } catch (InputMismatchException e) {
            System.out.println("Please enter numerical values only!");
            sc.nextLine();
        }
    }
            myObj.setLiquid(userInputFund); //Set User Funds
}


