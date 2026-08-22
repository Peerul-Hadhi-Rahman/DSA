class Node {
  int data;
  Node next;

  Node(int data) {
    this.data=data;
    this.next=null;
  }
}

public class Main {
  //convert LL
  public static Node ConvertArrayToLL(int[] arr) {
    Node head=new Node(arr[0]);
    Node mover=head;

    for(int i=1;i<arr.length;i++) {
      Node temp=new Node(arr[i]);
      mover.next=temp;
      mover=temp;
    }
    return head;
  }

  //Print LL
  public static void printLL(Node head) {
    
    Node temp=head;
    while(temp!=null) {
      System.out.print(temp.data + " -> ");
      temp=temp.next;
    }
    if(temp==null) System.out.print("null\n");
  }

  //Find length of LL
  public static int findLength(Node head) {
    Node temp=head;
    int count=0;

    while(temp!=null) {
      temp=temp.next;
      count++;
    }
    return count;
  }

  public static boolean findValue(Node head, int val) {
    Node temp=head;
    while(temp!=null) {
      if(temp.data==val) return true;
      else {
        temp=temp.next;
      }
    }
    return false;
  }
  
  public static void main(String[] args) {
      int[] array={99, 1, 98, 2, 97, 3};
      Node head = ConvertArrayToLL(array);
      printLL(head);
      int n = findLength(head);
      System.out.println(n);
      boolean f=findValue(head, 97);
      System.out.println(f);


    }
}
