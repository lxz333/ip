import java.util.ArrayList;

public class TaskList extends ArrayList<Task> {
    public String print_curr_tasks() {
        String res = "";
        if (this.size() == 0) {
            res = "Sorry this list is empty T^T";
            return res;
        }
        res += "Here are the tasks in your list:\n";
        for (int i = 0; i < this.size(); i++) {
            if (i == this.size() - 1) {
                res += (i+1) + ". " + this.get(i);
            } else {
                res += (i+1) + ". " + this.get(i) + "\n";
            }
        }
        return res;
    }
}
