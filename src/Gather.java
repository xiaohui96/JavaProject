import java.util.ArrayList;
import java.util.List;

public class Gather {
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("v");
        list.remove((int)Math.random()*list.size());
        for (int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
