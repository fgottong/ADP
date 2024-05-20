package Praktikum2;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Lightweight implementation of an Doubly Linked List, using in innerclass node
 *
 * @param <E>
 */
public class DoublyLinkedList<E> extends AbstractList<E> {

    private final Node<E> head;
    private final Node<E> tail;
    private int size;

    /**
     * Simple constructor for empty list
     */
    public DoublyLinkedList(){
        head = new Node<>(null);
        tail = new Node<>(null);

        head.setNext(tail);
        tail.setPrevious(head);

        tail.setNext(null);
        head.setPrevious(null);

        size = 0;
    }

    /**
     * general copy constructor
     * @param ary
     */
    public DoublyLinkedList(Collection<E> ary){
        this();
        this.addAll(ary);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        Node<E> currentNode = head.getNext();
        for(int i=0;i<index;i++){
            currentNode = currentNode.getNext();
        }
        return currentNode.getContent();    }

    @Override
    public E set(int index, E e) {
        Node<E> currentNode = head.getNext();
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        currentNode.content = e;
        return e;
    }

    @Override
    public boolean add(E e) {
        //super.add(size,e);
        add(size,e);
        return true;
    }

    @Override
    public void add(int index, E element) {

        Node<E> currentNode = head.getNext();
        // current = tail

        Node<E> newNode = new Node<>(element);


        for(int i=0;i<index;i++){
            currentNode = currentNode.getNext();
        }


        // Von Lari
//        newNode.setNext(currentNode);
//        newNode.setPrevious(currentNode.getPrevious());
//        currentNode.setPrevious(newNode);
//        newNode.getPrevious().successor = newNode;

//        Vorher
//        H --> T
//        H <-- T
//
//        Neuer Knoten  - Welcher ist currentNode? => Tail
//        H --> N --> T
//        H <-- N <-- T


        // Von Fabi Original
        // Dem nachfolge Knoten bescheid sagen, dass es einen neuen Knoten gibt
        //currentNode.getNext().setPrevious(newNode);
        //newNode.setNext(currentNode.getNext());
        // dem Vorgängerknoten bescheid sagen, dass es einen neuen Knoten gibt.
        //currentNode.setNext(newNode);
        //newNode.setPrevious(currentNode);

            // Von Fabi Geändert
        newNode.setPrevious(currentNode.getPrevious()); // previous = head
        currentNode.getPrevious().setNext(newNode); // previous = head
        newNode.setNext(currentNode); //Current = Tail
        currentNode.setPrevious(newNode);

        size++;

    }

    @Override
    public void clear(){
        head.setNext(tail);
        tail.setPrevious(head);
        size=0;
    }

    @Override
    public E remove(int index){

        Node<E> currentNode = head.getNext();

        for(int i=0;i<index;i++){
            currentNode = currentNode.getNext();
        }

        currentNode.getNext().setPrevious(currentNode.getPrevious());
        currentNode.getPrevious().setNext(currentNode.getNext());

        size--;
        
        return currentNode.getContent();
    }

    @Override
    public String toString(){
        // Skip(1) um den Head zu Überspringen

//        return "DoublyLinkedList["+
//                this.stream().map(Objects::toString).collect(Collectors.toList())+
//                "]";

        return Arrays.toString(this.toArray());
    }

    @Override
    public Object[] toArray(){
        return this.stream().toArray();
    }

    private static class Node<E> {

        Node<E> successor;
        Node<E> predecessor;
        E content;

        public Node(){
            this.content = null;
            this.successor = null;
            this.predecessor = null;
        }

        public Node(E content){
            this.content = content;
            this.successor = null;
            this.predecessor = null;
        }

        public E getContent(){
            return content;
        }

        public boolean setContent (E e){
            this.content = e;
            return true;
        }

        public Node<E> getNext (){
            return successor;
        }

        public Node<E> getPrevious(){
            return predecessor;
        }

        public boolean setNext(Node<E> node){
            this.successor = node;
            return true;
        }

        public boolean setPrevious(Node<E> node){
            this.predecessor = node;
            return true;
        }

        @Override
        public String toString() {
            return String.format("Node[ %s ]",content);
        }
    }


}

