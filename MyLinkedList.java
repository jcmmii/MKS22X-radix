public class MyLinkedList<E>{
  private int length;
  private Node start,end;

  //constructor
  public MyLinkedList() {
    clear();
  }

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

  public void extend(MyLinkedList other) {
    //in all cases: if other MLL has length of 0, nothing can/is done and this MLL stays the same
    if (this.length == 0) {
      if (other.length == 1) {
        this.length = 1;
        this.start = other.start; //MLLs with length of 1 only have start nodes
        other.length = 0;
      }
      if (other.length > 1) {
        this.length = other.length;
        this.start = other.start; //MLLs with length > 1 have end nodes, accounts for that
        this.end = other.end;
        other.length = 0;
      }
    }
  if (this.length == 1) {
      if (other.length == 1) {
        this.end = other.start;
        this.start.setNext(this.end); //has the two nodes (start, end) reference each other
        this.end.setPrev(this.start); //similar to the add method with length 2
        other.length = 0;
        this.length = 2;
      }
      if (other.length > 1) {
        this.end = other.end;
        this.start.setNext(other.start);          //has two beginning nodes reference each other
        other.start.setPrev(this.start);
        this.length = this.length + other.length;
        other.length = 0;
      }
    }
  if (this.length > 1) {
    if (other.length == 1) {
      this.end.setNext(other.start);
      other.start.setPrev(this.end);
      this.end = other.start;             //other MLL has only start node, this MLL references to that as end
      this.length = this.length + 1;
      other.length = 0;
      }
    if (other.length > 1) {
      this.end.setNext(other.start);
      other.start.setPrev(this.end);
      this.end = other.end;             //if other MLL has length >1, its end is now this MLL's end
      this.length = this.length + other.length;
      other.length = 0;
    }
  }
  //this method does not clear out the other MyLinkedList
  //as long as the other MyLinkedList has length of 0, whenever a method is done on it,
  //it will revert back to as if it was empty and as if it was cleared out
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
