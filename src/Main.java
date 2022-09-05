import java.util.List;

public class Main {

    public static void main(String[] args) {
//        ArrayList<Integer> newArray = new ArrayList<Integer>();
//        newArray.addToBack(1);

//        SinglyLinkedList<Integer> newList = new SinglyLinkedList<>();
//
//        newList.addToBack(1);
//        newList.addToBack(2);
//        System.out.println(newList.removeFromBack());

        ArrayQueue<Integer> newQueue = new ArrayQueue<>();

        newQueue.enqueue(0);
        newQueue.enqueue(1);
        newQueue.enqueue(2);
        newQueue.enqueue(3);
        newQueue.enqueue(4);
        newQueue.enqueue(5);
        newQueue.enqueue(6);
        newQueue.enqueue(7);
        newQueue.enqueue(8);
        newQueue.enqueue(9);
        System.out.println(newQueue.getBackingArray());




    }
}