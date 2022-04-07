package sait.sll.utility;


import sait.sll.problemdomain.User;

public class SLL implements LinkedListADT{
    //declare needed nodes.
    private Node head, tail;
    private int size = 0;

    //Empty LinkedList constructor
    public SLL(){
        head = null;
        tail = null;
    }

    //Getters and setters
    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    //If the head = null, the linked list must be empty, otherwise it must contain something.
    @Override
    public boolean isEmpty() {
        return (head == null);
    }

    //cut the head off the snake to clear the list, if there is no head there shouldn't be a tail either, set size to 0
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    //If this is the first Node being added to the LinkedList make both the head and tail point to it
    //Else create a new Node with data and set it to be tail.next, then make tail = it.
    @Override
    public void append(Object data) {
        Node newNode = new Node(data);
        if(isEmpty()){
            head = tail = newNode;
        }else{
            Node current = head;
            while(current.getNext()!=null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    //If this is the first Node being added to the LinkedList make both the head and tail point to it
    //Else create a new Node with data and set it's next to be the head (is now the 2nd Node), then set head = the newly created Node
    @Override
    public void prepend(Object data) {
        Node newNode = new Node(data);
        if(isEmpty()){
            head = tail = newNode;
        }else{
            newNode.setNext(head);
            head = newNode;
        }
        size++;
    }


    @Override
    public void insert(Object data, int index) throws IndexOutOfBoundsException {
        if(index == 0) {
            prepend(data);
            //be a nice guy and if they attempt to insert at an index larger than the size of the LinkedList just append()
        }else if(index >= size) {
            append(data);
        }else{
            Node current = head;
            for(int i = 1;i<index-1;i++){
                current = current.getNext();
            }
            Node afterInsert = current.getNext(); //grabbing the Node after current which will need to be bumped forward one space in the LinkedList.
            current.setNext(new Node(data)); //inserting the new Node with the data after the current Node
            current.getNext().setNext(afterInsert); //setting the Node we grabbed earlier to now be the next for the newly inserted Node.
            size++;
        }
    }

    @Override
    public void replace(Object data, int index) throws IndexOutOfBoundsException {
        if(index == 0) {
            prepend(data);
            //be a nice guy and if they attempt to insert at an index larger than the size of the LinkedList just append()
        }else if(index >= size) {
            append(data);
        }else{
            Node current = head;
            for(int i = 1;i<index-1;i++){
                current = current.getNext();
            }
            Node afterReplace = current.getNext().getNext(); //grabbing the Node that will needs to be set as the next for the newly replaced Node
            current.setNext(new Node(data)); //setting the new Node to be the next Node of the current Node
            current.getNext().setNext(afterReplace); // current.getNext() aka the new Node we replaced the old one with will not be set to the Node we grabbed earlier
        }
    }

    @Override
    public int size() {
        int listSize = 0;
        Node current = head;
        while(current.getNext() != null){
            current = current.getNext();
            listSize++;
        }
        return listSize;
    }

    @Override
    public void delete(int index) throws IndexOutOfBoundsException {

    }

    @Override
    public Object retrieve(int index) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public int indexOf(Object data) {
        return 0;
    }

    @Override
    public boolean contains(Object data) {
        return false;
    }





}