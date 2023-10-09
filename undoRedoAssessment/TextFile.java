package undoRedoAssessment;

import java.util.*;

public class TextFile {
    public static void main(String[] args) {
        String inputText = CommandFile.readFile("input.txt");
        String commandText = CommandFile.readFile("commands.txt");

        String finalText = commandOp(inputText, commandText);
        System.out.println(finalText);
    }

    public static String commandOp(String inputText, String commandText) {
        StringBuilder sb = new StringBuilder(inputText);
        Stack<String> obj = new Stack<>();

        for (int i = 0; i < commandText.length(); i++) {
            char command = commandText.charAt(i);

            if (command != '<') {
                sb.append(command);
                obj.push("APPEND");
            } 
            
            else if (commandText.startsWith("<bksp>", i)) {
                i+= 6;
                
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                    obj.push("BACKSPACE");
                }
            } 
            
            else if (commandText.startsWith("<undo>", i)) {
                i += 6; 
                if (!obj.isEmpty()) {
                	
                    String str = obj.pop();
                    if (str.equals("APPEND")) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                } 
                
                else {
                    throw new IllegalStateException();
                }
            }
        }

        return sb.toString();
    }
}
