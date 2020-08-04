package code;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("2223");
        list.add("233");
        list.add("244");
        System.out.println(list.iterator().next());
    }
}
