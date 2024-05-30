package Praktikum2;

import edu.princeton.cs.algs4.In;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Lightweight implementation of an Doubly Linked List, using in innerclass node
 * TODO : Iterationszeit messen
 * TODO : Iterator verbessern, merkt sich den letzte besuchten knoten und holt den nächsten knoten
 *  => Get//foreach
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
    public DoublyLinkedList() {
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
     *
     * @param ary
     */
    public DoublyLinkedList(Collection<E> ary) {
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
//        for (int i = 0; i < index; i++) {
//            currentNode = currentNode.getNext();
//        }

        currentNode = getNode(index);

        return currentNode.getContent();
    }

    @Override
    public E set(int index, E e) {
        Node<E> currentNode = head.getNext();
//        for (int i = 0; i < index; i++) {
//            currentNode = currentNode.getNext();
//        }
        currentNode = getNode(index);
        currentNode.content = e;
        return e;
    }

//    @Override
//    public boolean add(E e) {
//        //super.add(size,e);
//        add(size,e);
//        return true;
//    }

    @Override
    public void add(int index, E element) {

        Node<E> currentNode = head.getNext();
        // current = tail

        Node<E> newNode = new Node<>(element);


//        for (int i = 0; i < index; i++) {
//            currentNode = currentNode.getNext();
//        }
        currentNode = getNode(index);

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
    public void clear() {
        head.setNext(tail);
        tail.setPrevious(head);
        size = 0;
    }

    @Override
    public E remove(int index) {
        // checkIndex(index) => execptions


        Node<E> currentNode = head.getNext();


        // TODO: Optimierung durch GetNode(index)

//        for (int i = 0; i < index; i++) {
//            currentNode = currentNode.getNext();
//        }

        currentNode = getNode(index);

        currentNode.getNext().setPrevious(currentNode.getPrevious());
        currentNode.getPrevious().setNext(currentNode.getNext());

        size--;

        return currentNode.getContent();
    }

    @Override
    public String toString() {
        // Skip(1) um den Head zu Überspringen

//        return "DoublyLinkedList["+
//                this.stream().map(Objects::toString).collect(Collectors.toList())+
//                "]";

        return Arrays.toString(this.toArray());
    }

    private boolean checkIndex(int index) throws IndexOutOfBoundsException {

        // = vlt. off-by--one error ???
        if ((index > size || (index < 0))) throw new IndexOutOfBoundsException();
        return true;
    }

    /**
     * Für indizierten Zugriff auf eine Bestimmtes Element der Linked List
     * Für CRUD (Create, Read, Update und Delete) Operationen.
     *
     * Unterschied zum Iterator:
     * - Iterator verarbeitet alle Elemente (for-each)
     * - getNode liefert nur einen Knoten
     *
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    private Node<E> getNode(int index) throws IndexOutOfBoundsException {
        try {
            checkIndex(index);
        } catch (IndexOutOfBoundsException iobe) {
            throw iobe;
        }

        Node pointer = this.head.successor;
        Node node = new Node();

        for (int i = 0; i <= index; i++) {
            node = pointer;
            pointer = pointer.successor;
        }

        return node;

    }

    @Override
    public Object[] toArray() {
        return this.stream().toArray();
    }

    /**
     * Behälter für den Content eines Itemas der Liste,
     * welcher sich mit anderen Behältern verknüpfen lässt.
     * @param <E>
     */
    private static class Node<E> {

        Node<E> successor;
        Node<E> predecessor;
        E content;

        public Node() {
            this(null);
        }

        public Node(E content) {
            this.content = content;
            this.successor = null;
            this.predecessor = null;
        }

        public E getContent() {
            return content;
        }

        public boolean setContent(E e) {
            this.content = e;
            return true;
        }

        public Node<E> getNext() {
            return successor;
        }

        public Node<E> getPrevious() {
            return predecessor;
        }

        public boolean setNext(Node<E> node) {
            this.successor = node;
            return true;
        }

        public boolean setPrevious(Node<E> node) {
            this.predecessor = node;
            return true;
        }

        @Override
        public String toString() {
            return String.format("Node[ %s ]", content);
        }


    }

    /**
     * Iterator implementierung.
     * Gedacht um alle elemente in der LinkedList zu verarbeiten.
     * Gedacht für streams und for-each operationen.
     *
     * Einfache implementierung: cursor läuft vorne los und bewegt sich schrittweise zum Ende.
     * Verzicht auf schleifen, coursor merkt sich immer nur den Aktuellen knoten.
     * Bei Next wir er genau auf den successor des aktuellen knoten verschoben.
     * Dadurch: effiziente Laufzeit, kein wiederholtes iterieren über die Liste. wie mit einer schleife.
     *
     * Iterator liefert nur den Inhalt des Nodes, nicht den Node selber.
     *
     */
    private class Iter implements Iterator<E> {
        Node<E> cursor = head.successor;

        @Override
        public boolean hasNext() {
            return (cursor != tail);
        }

        @Override
        public E next() throws NoSuchElementException {
            if (hasNext()) {
                cursor = cursor.successor;
            }
            if (cursor == tail) {
                throw new NoSuchElementException();
            }

//            // Aus PM2 - A2 ,
//            if (!hasNext()) {
//                throw new NoSuchElementException();
//            }

            return cursor.content;

        }
    }


}

