package com.codecool;

public class SinglyLinkedList {

    private class Link {

        private final String value;
        private Link next;

        Link(String value) {
            this.value = value;
        }

        String getValue() {
            return value;
        }

        Link getNext() {
            return next;
        }

        void setNext(Link next) {
            this.next = next;
        }
    }

    private Link head;

    public SinglyLinkedList() {
    }

    // Returns the number at 'index'.
    public String access(int index) {
        Link link = getLinkAtIndex(index);
        return link.getValue();
    }

    // Returns the index of 'number' if it's in the array, otherwise -1;
    public int search(String value) {
        if (head==null) return -1;
        Link link = head;
        int index = 0;
        if (link.getValue().equals(value)) {
            return index;
        }
        while (link.getValue().equals(value)) {
            link = link.getNext();
            index++;
            if (link.getValue().equals(value)) {
                return index;
            }
        }
        return -1;
    }

    private Link getLinkAtIndex(int index){
        Link link = head;
        for (int i=index;i>0;i--){
            link = link.getNext();
        }
        return link;
    }

    private Link getLastElement(){
        Link link = head;
        while (!(link.next==null)){
            link = link.getNext();
        }
        return link;
    }

    public void insert(String value) {
        if (head == null) {
            head = new Link(value);
        } else {
            Link previousLink = getLastElement();
            Link link = new Link(value);
            link.setNext(previousLink.getNext());
            previousLink.setNext(link);
        }
    }

    // Inserts 'number' at 'index' into the array shifting elements if necessary.
    //
    // e.g. the result of inserting 42 at index 3 into [0, 1, 2, 3, 4] is [0, 1, 2, 42, 3, 4]
    public void insert(int index, String value) {
        if (head == null) {
            head = new Link(value);
        } else if (index == 0) {
            Link second = head;
            head = new Link(value);
            head.setNext(second);
        } else {
            Link previousLink = getLinkAtIndex(index - 1);
            Link link = new Link(value);
            link.setNext(previousLink.getNext());
            previousLink.setNext(link);
        }
    }

    // Deletes the element at 'index' from the array.
    //
    //  e.g. the result of deleting index 2 from [0, 1, 2, 3, 4] is [0, 1, 3, 4]
    public void delete(int index) {
        if (index == 0) {
            if (head == null) {
                throw new IndexOutOfBoundsException();
            } else {
                head = head.getNext();
            }
            return;
        }
        Link elementBeforeIndex = head;
        while (index - 1 > 0) {
            elementBeforeIndex = elementBeforeIndex.getNext();
            index--;
            if (elementBeforeIndex == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        Link elementAtIndex = elementBeforeIndex.getNext();
        if (elementAtIndex == null) {
            throw new IndexOutOfBoundsException();
        }
        elementBeforeIndex.setNext(elementAtIndex.getNext());
    }
}
