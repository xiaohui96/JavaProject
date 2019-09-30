import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Muster {
    public static void main(String[] args){
        // 实例化集合类对象
        Collection<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        // 创建迭代器
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            String str = (String)it.next();
            System.out.println(str);
        }
    }
}
