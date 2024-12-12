package controller.threadController;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

//线程安全的集合
public class threadTest1 {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();

//        List<String> list1 = new Vector<>();
//        List<String> list2 = Collections.synchronizedList(new ArrayList<>());
//        List<String> list3 = new CopyOnWriteArrayList<>(new ArrayList<>());
//
//        Set<String> list4 = new CopyOnWriteArraySet<>();

        Map<String,String> list = new ConcurrentHashMap<>();

        for (int i = 0; i < 20; i++) {
            String key = String.valueOf(i);
            new Thread(() -> {
                list.put(key,UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }

    }

}
