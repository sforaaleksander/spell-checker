package com.codecool;

import java.util.LinkedList;
import java.util.List;

/**
 * ICS 23 Summer 2004
 * Project #5: Lost for Words
 * Implement your hash table here.  You are required to use the separate
 * chaining strategy that we discussed in lecture, meaning that collisions
 * are resolved by having each cell in the table be a linked list of all of
 * the strings that hashed to that cell.
 */

public class HashTable {
    class Node<K, V> {
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    private int tableSize;
    private SinglyLinkedList<Node<String, String>>[] elements;
    /**
     * The constructor is given a table size (i.e. how big to make the array)
     * and a StringHasher, which is used to hash the strings.
     *
     * @param tableSize number of elements in the hash array
     *                  hasher    Object that creates the hash code for a string
     * @see StringHasher
     */
    public HashTable(int tableSize, StringHasher hasher) {
        this.tableSize = tableSize;
        private List<HashMapExample.Node<K, V>>[] elements = new LinkedList[bucketSize];
    }


    /**
     * Takes a string and adds it to the hash table, if it's not already
     * in the hash table.  If it is, this method has no effect.
     *
     * @param s String to add
     */
    public void add(String s) {
        int position = getPositionByHash(key);
        if (elements[position] == null) {
            elements[position] = new LinkedList<>();
        }
        Node<K, V>  node = findNodeWithKey(elements[position], key);
        if (node != null){
            node.value = value;
        } else {
            node = new Node<K, V>(key, value);
            elements[position].add(node);
        }
    }


    /**
     * Takes a string and returns true if that string appears in the
     * hash table, false otherwise.
     *
     * @param s String to look up
     */
    public boolean lookup(String s) {
        return false;
    }


    /**
     * Takes a string and removes it from the hash table, if it
     * appears in the hash table.  If it doesn't, this method has no effect.
     *
     * @param s String to remove
     */
    public void remove(String s) {

    }
}
