public class MyLinkedList<E>{
  private int length;
  private Node start,end;

  public String toString(){
    String ret = "";
    Node current = start;
    while (current != null) {
      ret = ret + current.getData() + ", ";
      current = current.next();                   //swaps the current node to be the next node
    }
    if (ret.length() == 0) return "[]";
    return "[" + ret.substring(0,ret.length()-2) + "]"; //gets rid of the extra ", ", adds brackets to surround
  }

  //constructor
  public MyLinkedList() {
    clear();
  }

  public void clear() {
    start = null; //default: start and end have no nodes(null) and size is 0;
    end = null;
    length = 0;
  }

  public boolean add(E value) {
    Node N = new Node(value);     //creates a new Node based off value
    length = length + 1;
    if (length == 1) {            //if there are no existing nodes
      start = N;                  //both start and end nodes are the new Node
      end = N;
    }
    else {
      end.setNext(N);         //last node references the new node being added
      N.setPrev(end);         //new node being added references the last node
      end = N;                //now node is the last node
    }
    return true;
  }

  public void extend(MyLinkedList<E> other) {
    if (length == 0) { //if current linkedlist is 0, basically copies over other
      start = other.start;
      end = other.end;
      length = other.length;
      other.length = 0;  //other linkedlist is cleared
      other.start = null;
      other.end = null;
    } else if (other.length > 0){
      end.setNext(other.start);     //links start and end
      other.start.setPrev(end);
      length = this.length + other.length; //length is total length of the two lists
      end = other.end; //end is updated
      other.length = 0;  //other linkedlist is cleared
      other.start = null;
      other.end = null;
    }
  }

  //removes the first element of the list, returns the value
  public E removeFront() {
    if (length == 0) throw new IndexOutOfBoundsException("the linkedlist is empty!"); //there are no nodes
    E removeVal = start.getData();
    if (length == 1) { //if there is only one node
      clear();
    } else {
      start = start.next(); //set the start to the node after the original start
      length = length -1;   //length decreases
    }
    return removeVal;
  }

//NODE class
  public class Node{
    private E val;
    private Node next, prev;

    public Node(E data) {
      val = data;
    }

    public Node next() {
      return next;
    }

    public Node prev() {
      return prev;
    }

    public void setNext(Node newNext) {
      next = newNext;
    }

    public void setPrev(Node newPrev) {
      prev = newPrev;
    }

    public E getData() {
      return val;
    }

    public E setData(E data) {
      E oldValue = val;
      val = data;
      return oldValue;
    }

    public String toString() {
      return "" + val;
    }
  }

}
