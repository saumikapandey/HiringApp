//CIS 
//Assign 4, HiringApp

package assign4_template;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Deque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class HiringApp {  //manage hiring by accepting applications,hiring new employees, and firing current employees. 
	//It uses a queue for applicants and a stack for current and past employees.

	private static Queue<Person> applicants = new LinkedList<>();
    private static Deque<Person> currentEmployees = new ArrayDeque<>();
    private static Deque<Person> pastEmployees = new ArrayDeque<>(); // LIFO for past employees
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        //Define the data structures for 3 different groups of people:
        //  new applicants
        //  current employees (those who were hired), 
        //  past employees (those who were fired)
        //
        //Hint: for queue: Queue<Person>,  ArrayDeque, LinkedList
        //      for stack: Deque<Person>   ArrayDeque, LinkedList
        
        //display the menu
        
        //get the menu choice
        
        //process user selected service request.
        
        //loop until the user decides to quit.
        
    
    int choice;
    do {
        displayMenu();  
        choice = getChoice();  // user choice
        switch (choice) {
            case 1:
                applicants.offer(getApplication());  // new applicant INPUT 
                break;
            case 2:
                hire();  // Hire an applicant 
                break;
            case 3:
                fire();  // Fire the most recently hired employee
                break;
            case 4:
                System.out.println("Exited");
                break;
            default:
                System.out.println("Invalid choice");
        }
    } 
    while (choice != 4);  // until the user quits
 
    }

    //other methods for code modularization
    //method for getting user choice
public static void displayMenu() { //simply print menu
        
        //display the menu
	System.out.println("Menu:");
    System.out.println("1 - Accept an application");
    System.out.println("2 - Hire");
    System.out.println("3 - Fire");
    System.out.println("4 - Quit");
}
        //get user choice
public static int getChoice() {  //// This method gets the user's choice  from  and returns it as an integer. 
	// It's basically asking what the user wants to do next.
	System.out.println("Action (1 to accept, 2 to hire, 3 to fire, 4 to quit): ");
    return scanner.nextInt();  
}
        //return user choice as an integer
        
      
    

    //method for accepting an applicant and reurn this applicant as a Person object
    public static Person getApplication() { //  method gets the details for a new applicant from the user
    	//It then creates a Person object with that info and returns it. 
        
        //display prompt for user to enter an applicant's name
        //get user input
    	 System.out.print("Enter  name: ");
         scanner.nextLine();  // Consume newline
         String name = scanner.nextLine();

        //display prompt for user to enter an applicant's degree
        //get user input
        System.out.print("Enter  degree: ");
        String degree = scanner.nextLine();

        //display prompt for user to enter an applicant's skill list
        //  (first how many skills, then enter skill one by one)
        //use a loop to get each skill
        System.out.print("Enter the number of skills: ");
        int numSkills = scanner.nextInt();
        scanner.nextLine();
        ArrayList<String> skills = new ArrayList<>();
        for (int i = 0; i < numSkills; i++) {
            System.out.print("Enter skill " + (i + 1) + ": ");
            skills.add(scanner.nextLine());
        }
        //create a Person object using the name, degree, skill list
        return new Person(name, degree, skills);
    
        //and return this Person object
      
    }

    //You can either implement hire and fire functionalities in main(...),
    //   or implement them here as separate methods:
    //hire method
    public static void hire() { //// This method  first checks if there are any past employees available to hire.
    	//If not looks at the new applicants  
    	// If there’s someone to hire it adds them to the current employees list and prints a message
        // Hire from past employees if possible, otherwise from new applicants
        if (!pastEmployees.isEmpty()) {
            Person reHired = pastEmployees.pop();
            currentEmployees.push(reHired);
            System.out.println(reHired.getName() + " re-hired.");
        } 
        else if (!applicants.isEmpty()) {
            Person hired = applicants.poll();
            currentEmployees.push(hired);
            System.out.println(hired.getName() + " hired.");
        } 
        else {
            System.out.println("Memo to Supervisor: There is nobody to hire.");
        }
    }

    //fire method
    public static void fire() { //methpd to fire people,fires latest hired person and removes them from employee list
        // Fire the most recently hired employee
        if (currentEmployees.isEmpty()) {
            System.out.println("Memo to Supervisor: There is nobody to fire.");
        } 
        else {
            Person fired = currentEmployees.pop();
            pastEmployees.push(fired);
            System.out.println(fired.getName() + " fired.");
        }
    }
    }

