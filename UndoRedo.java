
public class UndoRedo {
    private Node currentState;

    // Doubly linked list Node
    class Node {
        String state;
        Node prev;
        Node next;

        Node(String state) {
            this.state = state;
            prev = null;
            next = null;
        }
    }

    // Method to add a new state
    public void addState(String state) {
        Node newState = new Node(state);
        if (currentState != null) {
            newState.prev = currentState;
            currentState.next = newState;
        }
        currentState = newState;
    }

    // Method to undo the last state change
    public void undo() {
        if (currentState != null && currentState.prev != null) {
            currentState = currentState.prev;
        } else {
            System.out.println("No more states to undo.");
        }
    }

    // Method to redo the last undone state change
    public void redo() {
        if (currentState != null && currentState.next != null) {
            currentState = currentState.next;
        } else {
            System.out.println("No more states to redo.");
        }
    }

    // Method to get the current state
    public String getCurrentState() {
        return currentState != null ? currentState.state : "No state available";
    }

    // Main method to test the above methods
    public static void main(String[] args) {
        UndoRedo ur = new UndoRedo();
        ur.addState("State 1");
        ur.addState("State 2");
        ur.addState("State 3");

        System.out.println("Current State: " + ur.getCurrentState()); // Output: State 3

        ur.undo();
        System.out.println("After undo, Current State: " + ur.getCurrentState()); // Output: State 2

        ur.undo();
        System.out.println("After undo, Current State: " + ur.getCurrentState()); // Output: State 1

        ur.redo();
        System.out.println("After redo, Current State: " + ur.getCurrentState()); // Output: State 2

        ur.redo();
        System.out.println("After redo, Current State: " + ur.getCurrentState()); // Output: State 3

        ur.redo(); // No more states to redo
    }
}