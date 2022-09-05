import java.util.NoSuchElementException;

/**
 * Your implementation of a Singly-Linked List.
 */
public class SinglyLinkedList<T> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private SinglyLinkedListNode<T> head;
    private SinglyLinkedListNode<T> tail;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the element to the front of the list.
     *
     * Method should run in O(1) time.
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        if(data == null){
            throw new IllegalArgumentException();
        }
        SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<>(data);
        if(size == 0) {
            tail = newNode;
        } else {
            newNode.setNext(head);
        }
        head = newNode;
        size++;
    }

    /**
     * Adds the element to the back of the list.
     *
     * Method should run in O(1) time.
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        if(data == null){
            throw new IllegalArgumentException();
        }
        SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<>(data);
        if(size == 0) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
    }

    /**
     * Removes and returns the first data of the list.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        if(size == 0){
            throw new NoSuchElementException();
        }
        SinglyLinkedListNode<T> removedNode = head;
        if(head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
            removedNode.setNext(null);
        }
        size--;
        return removedNode.getData();
    }

    /**
     * Removes and returns the last data of the list.
     *
     * Method should run in O(n) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        if(size == 0){
            throw new NoSuchElementException();
        }
        SinglyLinkedListNode<T> removedNode = head;
        if(head == tail) {
            head = null;
            tail = null;
        } else {
            SinglyLinkedListNode<T> cursor = head;
            while(cursor.getNext() != null) {
                if(cursor.getNext().getNext() == null) {
                    tail = cursor;
                    removedNode = cursor.getNext();
                    cursor.setNext(null);
                    break;
                }
                cursor = cursor.getNext();
            }
        }
        size--;
        return removedNode.getData();
    }

    /**
     * Returns the head node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the head of the list
     */
    public SinglyLinkedListNode<T> getHead() {
        // DO NOT MODIFY THIS METHOD!
        return head;
    }

    /**
     * Adds the element to the specified index.
     *
     * Must be O(1) for indices 0 and size and O(n) for all other cases.
     *
     * ASSUMPTIONS:
     * - You may assume that the index will always be valid [0, size]
     * - You may assume that the data will not be null
     *
     * @param index the index to add the new element
     * @param data  the data to add
     */
    public void addAtIndex(int index, T data) {
        SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<>(data);
        if(index == 0){
            newNode.setNext(head);
            head = newNode;
            size++;
            return;
        }
        SinglyLinkedListNode<T> cursor = head;
        if(index == size){
            tail.setNext(newNode);
            tail = newNode;
            size++;
            return;
        }
        int counter = 0;
        while(cursor.getNext() != null) {
            if(counter == (index-1)){
                newNode.setNext(cursor.getNext());
                cursor.setNext(newNode);
            }
            counter++;
            cursor = cursor.getNext();
        }
        size++;
    }


    /**
     * Returns the tail node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the tail of the list
     */
    public SinglyLinkedListNode<T> getTail() {
        // DO NOT MODIFY THIS METHOD!
        return tail;
    }

    /**
     * Returns the size of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}