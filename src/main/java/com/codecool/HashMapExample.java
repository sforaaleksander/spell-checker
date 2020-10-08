//package com.codecool;
//
//
//import java.util.LinkedList;
//import java.util.List;
//
//class HashMapExample<K, V> {
//    class Node<K, V> {
//        public K key;
//        public V value;
//        public Node next;
//
//        public Node(K key, V value) {
//            this.key = key;
//            this.value = value;
//        }
//    }
//    private int bucketSize = 16;
//    private List<Node<K, V>>[] elements = new LinkedList[bucketSize];
//
//    public void put(K key, V value) {
//        int position = getPositionByHash(key);
//        if (elements[position] == null) {
//            elements[position] = new LinkedList<>();
//        }
//        Node<K, V>  node = findNodeWithKey(elements[position], key);
//        if (node != null){
//            node.value = value;
//        } else {
//            node = new Node<K, V>(key, value);
//            elements[position].add(node);
//        }
//    }
//
//    private int getPositionByHash(K key) {
//        int hashcode = key.hashCode();
//        int position = Math.abs(hashcode % bucketSize);
//        return position;
//    }
//
//
//    private Node<K, V> findNodeWithKey(List<Node<K, V>> list, K key) {
//        for (Node<K, V> node : list) {
//            if (node.key.equals(key)) {
//                return node;
//            }
//        }
//        return null;
//    }
//
//    public V get(K key) throws Exception {
//        int position = getPositionByHash(key);
//        List<Node<K, V>> list =  elements[position];
//        for (Node<K, V> node : list) {
//            if (node.key == key) {
//                return node.value;
//            }
//        }
//        throw new InvalidKeyException("The key does not exist");
//    }
//
//    public void clear() {
//        for (int i=0;i<bucketSize;i++){
//            elements[i] = null;
//        }
//    }
//
//    public V remove(K key) throws Exception {
//        int position = getPositionByHash(key);
//        List<Node<K, V>> list =  elements[position];
//        for (Node<K, V> node : list) {
//            if (node.key.equals(key)) {
//                V value = node.value;
//                list.remove(node);
//                return value;
//            }
//        }
//        throw new InvalidKeyException("The key does not exist");
//    }
//}