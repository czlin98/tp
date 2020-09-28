package seedu.PlaNUS;

import java.util.ArrayList;
import java.util.Scanner;

public class PlaNUS {

    public static final String COMMAND_HELP = "help";
    public static final String COMMAND_ADD = "add";
    public static final String COMMAND_LIST = "list";
    public static final String COMMAND_BYE = "bye";
    private static ArrayList<Task> tasks;
    private static boolean isExit;

    public static void main(String[] args) {
        showWelcomeMessage();
        initProgram();
        while(!isExit) {
            String userInput = getUserInput();
            executeCommand(userInput);
        }
    }

    private static void showWelcomeMessage() {
        System.out.println("\nWelcome to\n" +
                "    ____  __      _   ____  _______\n" +
                "   / __ \\/ /___ _/ | / / / / / ___/\n" +
                "  / /_/ / / __ `/  |/ / / / /\\__ \\ \n" +
                " / ____/ / /_/ / /|  / /_/ /___/ / \n" +
                "/_/   /_/\\__,_/_/ |_/\\____//____/  " +
                "v1.0\n");
    }

    private static void initProgram() {
        tasks = new ArrayList<>();
        isExit = false;
    }

    private static String getUserInput() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    private static void executeCommand(String userInput) {
        String[] commandTypeAndParams = splitCommandWordAndArgs(userInput);
        String commandType = commandTypeAndParams[0];

        switch (commandType) {
            case COMMAND_HELP:
                showCommands();
                break;
            case COMMAND_ADD:
                String commandArgs = commandTypeAndParams[1];
                AddTask(commandArgs);
                break;
            case COMMAND_LIST:
                showList();
                break;
            case COMMAND_BYE:
                exitProgram();
                break;
        }
    }

    private static final void showCommands() {
        System.out.println("\nList of available commands:");
        System.out.println("- help: show list of available commands");
        System.out.println("- add: add a task");
        System.out.println("- list: show list of tasks");
        System.out.println("- bye: exit the program\n");
    }

    private static String[] splitCommandWordAndArgs(String userInput) {
        return userInput.split(" ", 2);
    }

    private static void AddTask(String commandArgs) {
        String description = "";
        String date = "";
        String time = "";
        String priority = "";
        if (commandArgs.contains("d/")) {
            int descriptionEndIndex = commandArgs.indexOf("/") - 2;
            int dateBeginIndex = commandArgs.indexOf("d/") + 2;
            int dateEndIndex = (commandArgs.substring(dateBeginIndex).contains("/")) ? commandArgs.indexOf("/", dateBeginIndex) - 2 : commandArgs.length();
            description = commandArgs.substring(0, descriptionEndIndex);
            date = commandArgs.substring(dateBeginIndex,dateEndIndex);
        }
        if (commandArgs.contains("t/")) {
            int descriptionEndIndex = commandArgs.indexOf("/") - 2;
            int timeBeginIndex = commandArgs.indexOf("t/") + 2;
            int timeEndIndex = (commandArgs.substring(timeBeginIndex).contains("/")) ? commandArgs.indexOf("/", timeBeginIndex) - 2 : commandArgs.length();
            description = commandArgs.substring(0, descriptionEndIndex);
            time = commandArgs.substring(timeBeginIndex, timeEndIndex);
        }
        if (commandArgs.contains("p/")) {
            int descriptionEndIndex = commandArgs.indexOf("/") - 2;
            int priorityBeginIndex = commandArgs.indexOf("p/") + 2;
            int priorityEndIndex = (commandArgs.substring(priorityBeginIndex).contains("/")) ? commandArgs.indexOf("/", priorityBeginIndex) - 2 : commandArgs.length();
            description = commandArgs.substring(0, descriptionEndIndex);
            priority = commandArgs.substring(priorityBeginIndex, priorityEndIndex);
        }
        if (!(commandArgs.contains("d/") || commandArgs.contains("t/") || commandArgs.contains("p/"))) {
            description = commandArgs;
        }
        Task task = new Task(description, date, time, priority);
        tasks.add(task);
        System.out.println("\nTask added:");
        System.out.println(task.toString());
        System.out.println("Now you have " + tasks.size() + " task(s) in your list.\n");
    }

    private static void showList() {
        System.out.println("\nHere is your list of tasks:");
        for (Task task : tasks) {
            System.out.println((tasks.indexOf(task)+1) + ". " + task.toString());
        }
        System.out.println();
    }

    private static void exitProgram() {
        isExit = true;
        System.out.println("\nBye! See you again!");
    }
}