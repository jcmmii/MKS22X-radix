public class MyLinkedList<E>{
  private int length;
  private Node start,end;

  public String toString() {
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
    start = null; //default: start and end have no nodes, are null, and size is 0;
    end = null;
    length = 0;
  }


  public boolean add(E value) {
    Node N = new Node(value);     //creates a new Node based off value
    length = length + 1;
    if (length == 1) {            //if there are no existing nodes
      start = N;
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
    if (length == 0) {
      start = other.start;
      end = other.end;
      length = other.length;
      other.length = 0;
      other.start = null;
      other.end = null;
    } else {
      end.setNext(other.start);
      other.start.setPrev(this.end);
      length = this.length + other.length;
      other.length = 0;
      end = other.end;
      other.start = null;
      other.end = null;
    }
  }

public boolean remove(Integer value) {
  if (contains(value)) {            //checks if value is present
    int I = indexOf(value);
    System.out.println(I);
    remove(I);
    return true;                   //finds the index, removes that index, and returns true
  }
  return false;                   //false is returned otherwise
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
      return "" + data;
    }
  }

}
