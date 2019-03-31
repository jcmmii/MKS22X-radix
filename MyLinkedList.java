public class MyLinkedList{
  private int length;
  private Node start,end;

  //constructor
  public MyLinkedList() { //default MyLinkedList has no nodes
    start = null;         //starting and ending nodes are null
    end = null;
    length = 0;           //default size is zero
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

  public boolean add(int value) {
    Node N = new Node(value);     //creates a new Node based off value
    length = length + 1;
    if (length == 1) {         //if there are no existing nodes
      start = N;
    }
    if (length == 2) {           //if there is a previous node
      end = N;                   //sets the end to the new Node
      start.setNext(end);        //and has both nodes referencing each other
      end.setPrev(start);
    }
    if (length >= 3) {
      end.setNext(N);         //last node references the new node being added
      N.setPrev(end);         //new node being added references previous last node
      end = N;                //now the end node is the new node
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

}
