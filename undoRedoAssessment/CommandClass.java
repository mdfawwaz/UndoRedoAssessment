package undoRedoAssessment;

public class CommandClass {
    public Commands cmd;
    public char ch;

    public CommandClass(Commands cmd, char ch) {
        this.cmd = cmd;
        this.ch = ch;
    }

    public Commands getCmd() {
        return cmd;
    }

    public char getCh() {
        return ch;
    }
}
