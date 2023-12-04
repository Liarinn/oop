package laboratory3.stack;

import java.util.Stack;

public class StacksRFun {
    public static void main(String[] args){
        Stack<String> games = new Stack<String>();

        games.add("Call of Duty");
        games.add("Guitar Hero");
        games.add("Super Monkey Ball");

        System.out.println(games.peek());
        System.out.println(games.contains("Call of Duty"));
        System.out.println(games.get(1));
        System.out.println(games.set(0, "Call of Mama"));
        System.out.println(games);
        System.out.println(games.size());
    }

}
