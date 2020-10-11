package seedu.messages;

import static seedu.font.Colors.*;

public class Messages {
//    public static final String DEFAULT_STRING_COLOR = ANSI_YELLOW;
    public static final String LS = System.lineSeparator();

    public static final String INVALID_PRIORITY = "Invalid priority!";
    public static final String INVALID_COMMAND = "Invalid command!";
    public static final String UNKNOWN_COMMAND = "Unknown command!";
    public static final String INVALID_TASK_NUMBER = "Invalid task number!";

    public static final String WELCOME_MESSAGE = ANSI_YELLOW + "Welcome to" + ANSI_RESET + LS + ANSI_CYAN
            + "    ____  __      _   ____  _______" + LS
            + "   / __ \\/ /___ _/ | / / / / / ___/" + LS
            + "  / /_/ / / __ `/  |/ / / / /\\__ \\ " + LS
            + " / ____/ / /_/ / /|  / /_/ /___/ / " + LS
            + "/_/   /_/\\__,_/_/ |_/\\____//____/  "
            + "v1.0" + ANSI_RESET;
    public static final String HELP_MESSAGE = "List of available commands:" + LS
            + "- help: show list of available commands" + LS
            + "- add: add a task" + LS
            + "- list: show list of tasks" + LS
            + "- bye: exit the program";
    public static final String BYE_MESSAGE = "Bye! See you again!";
    public static final String LIST_MESSAGE = "Here is your list of tasks:";
    public static final String ADD_MESSAGE = "Task added.";
    public static final String EDIT_MESSAGE = "Task edited.";

}
