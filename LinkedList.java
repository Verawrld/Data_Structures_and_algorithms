public class LinkedList {
    Node head; // Head of the list

    class Node {
        int data;
        Node next;

        Node(int d) { 
            data = d; 
            next = null; 
        }
    }

    // Deletes the first node of the list
    public void deleteAtBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
    }

    // Deletes the last node of the list
    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node secondLast = head;
        while (secondLast.next.next != null)
            secondLast = secondLast.next;
        secondLast.next = null;
    }

    // Deletes the node at a specific position
    public void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        if (position == 0) {
            head = temp.next;
            return;
        }
        for (int i = 0; temp != null && i < position - 1; i++)
            temp = temp.next;
        if (temp == null || temp.next == null)
            return;
        Node next = temp.next.next;
        temp.next = next;
    }

    // Prints the linked list
    public void printList() {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
    }

    public static void main(String[] args) {
        LinkedList llist = new LinkedList();
        llist.head = llist.new Node(1);
        Node second = llist.new Node(2);
        Node third = llist.new Node(3);
        llist.head.next = second;
        second.next = third;

        System.out.println("Created Linked list is:");
        llist.printList();

        llist.deleteAtBeginning();
        System.out.println("\nLinked list after deletion at the beginning:");
        llist.printList();

        llist.deleteAtEnd();
        System.out.println("\nLinked list after deletion at the end:");
        llist.printList();

        llist.deleteAtPosition(0);
        System.out.println("\nLinked list after deletion at position 0:");
        llist.printList();
    }
}