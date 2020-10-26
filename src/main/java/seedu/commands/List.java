package seedu.commands;

import seedu.data.TaskMap;
import seedu.exceptions.InvalidCommandException;
import seedu.ui.DisplayMode;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static seedu.messages.Messages.LIST_MESSAGE;
import static seedu.messages.Messages.LS;

public class List extends ReadOnlyCommand {
    public static final String COMMAND_WORD = "list";

    public static final Pattern COMMAND_PATTERN = Pattern.compile(
        "^list(?<dateFlag> -d)?"
                + "(?<priorityFlag> -p)?"
                + "(?<displayByWeek> -w)?"
                + "(?<displayByMonth> -m)?"
                + "( d/(?<date>\\d{2}-\\d{2}-\\d{4}))?$");

    private final boolean dateFlag;
    private final boolean priorityFlag;
    private final boolean displayByWeek;
    private final boolean displayByMonth;
    private final String date;


    public List(boolean dateFlag, boolean priorityFlag, boolean displayByWeek, boolean displayByMonth, String date) {
            this.dateFlag = dateFlag;
            this.priorityFlag = priorityFlag;
            this.displayByWeek = displayByWeek;
            this.displayByMonth = displayByMonth;
            this.date = date;
    }

    public CommandResult execute(TaskMap tasks) {
        assert !(dateFlag && priorityFlag);

        // TODO Check flag condition
        if (dateFlag) {
            return new CommandResult(LIST_MESSAGE, tasks.sortListByDate());
        } else if (priorityFlag) {
            return new CommandResult(LIST_MESSAGE, tasks.sortListByPriority());
        }
        if (displayByWeek || displayByMonth) {
            DisplayMode displayMode;
            if (displayByWeek) {
                displayMode = DisplayMode.WEEK;
            } else {
                displayMode = DisplayMode.MONTH;
            }
            return new CommandResult(LIST_MESSAGE, tasks, displayMode);
        }
        if (date != null) {
            LocalDate tempDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            String dateString = LS + tempDate.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"))
                + " " + tempDate.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.ENGLISH) + ":" + LS;
            return new CommandResult(LIST_MESSAGE + dateString, tasks.searchByDate(tempDate));
        }
        return new CommandResult(LIST_MESSAGE, tasks);
    }
}
