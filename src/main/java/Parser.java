import java.util.Scanner;


public class Parser {
    public Parser() {
    
        Scanner in = new Scanner(System.in);
        String input;

        Task task = new Task();
        try {
            Storage.readFile("data/duke.txt");
        }
        catch(Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
        
        while((input = in.nextLine()) != "") {
            try {

                if (input.equalsIgnoreCase("bye")) {
                    System.out.println("Bye. Hope to see you again soon!");
                    in.close();
                    return;
                }
                else if (input.equals("list")) {
                    task.getItems();
                }
                else if (input.startsWith("mark ")) {
                    task.setDone(input);
                }
                else if (input.startsWith("unmark ")) {
                    task.setNotDone(input);
                }
                else if (input.startsWith("todo ")) {
                    
                    new Todo(input);
                }
                else if (input.startsWith("deadline ")) {
                    
                    new Deadline(input);
                }
                else if (input.startsWith("event ")) {
                    
                    new Event(input);
                }
                else if (input.startsWith("delete ")) {
                    
                    task.delete(input);
                }
                else if (input.equalsIgnoreCase("save")) {
                    
                    Storage.save();
                }
                else {
                    throw new InvalidInputException();
                }
            }
            catch (InvalidInputException e) {
                System.out.println("Invalid input");
            }
    }
}
}
