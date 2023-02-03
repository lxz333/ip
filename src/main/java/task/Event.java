package task;

import java.time.LocalDate;

public class Event extends Task {
    protected String start;
    protected String end;
    protected String name;

    public Event(String name) {
        super(name);
        this.start = name.substring(name.indexOf("/from") + "/from ".length(), name.indexOf("/to") - 1);
        this.end = name.substring(name.indexOf("/to") + "/to ".length());
        this.name = name.substring("event".length() + 1, name.indexOf("/from") - 1);
    }

    @Override
    public String toString() {
        return "[E]" + super.toString().substring(0, "[ ] ".length()) + this.name +
                " (from: " + this.start + " to: " + this.end + ")";
    }
}
