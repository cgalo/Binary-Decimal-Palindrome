import java.util.NoSuchElementException;

public class Stack <Item> implements StackInterface <Item>{

    // Node class that holds an Item as item/value and the reference to the next node in the stack
    private class Node {
        /**
         * Private node class that will store the given item and the next node in the stack
         * */
         private Item item;
         private Node next;
         Node(Item item)
         {
             this.item = item;
             this.next = null;
         }
    }

    // Global variables for the Stack class
    private Node top;                   // Node that will remain at the top of the stack
    private int size;                   // Keep track of the size of the stack

    // Constructor, given no arguments
    Stack(){
        this.top = null;                // We start with an empty stack
        this.size = 0;                  // Start with stack size 0
    }

    // Constructor, given one item argument
    Stack(Item item){
        this.top = new Node(item);      // Set the new node, with given item, as the top of the stack
        size = 1;                       // Set the size of the stack to 1
    }

    @Override
    public void push(Item item) {
        /**
         * Functions inserts a new node, with the given item, into the top of the stack
         * */

        Node oldTop = top;              // Save the current top node of the stack as oldTop
        top = new Node(item);           // Create a new node, with the given item, and set it as top of the stack
        top.next = oldTop;              // Set the oldTop as the top's next node
        size++;                         // Update the size of the stack
    }

    @Override
    public Item pop() {
        /**
         * Function removes the top node of the stack and returns the item inside the popped node
         * If stack is empty, before performing pop, we throw underflow error
         * */

        if (empty())                    // If the stack is empty, throw an underflow error
            throw new NoSuchElementException("Stack underflow");
        else {
            Item item = top.item;       // Get the item from the top node
            top = top.next;             // Make the next node the new top of the stack
            size--;                     // Adjust the size of the stack
            return item;                // Return the value from the removed node
        }
    }

    @Override
    public Item peek() {
        /**
         * Function returns the top's item without popping it off the stack
         * If the stack is empty, before
         * */
        if (empty())                    // If the stack is empty throw underflow error
            throw new NoSuchElementException("Stack underflow");
        return top.item;                // Else we return the item of the top node
    }

    @Override
    public boolean empty() {
        return size == 0;               // If the size of stack is 0 then return true, else return false
    }

    @Override
    public int search(Item item) {
        /**
         * Function will return the length of the node with the item to the top of the stack
         * If no node is found with the item we are looking for or stack is empty, we'll return -1
         * */

        int count = 1;                  // Count starting at 1
        Node node = top;                // Changing for name convention
        while (node != null)
        {
            if (node.item == item)      // If the current node has the item we are looking for
                return count;           // Return the count
            count++;                    // Update count before moving to the next node
            node = node.next;

        }
        return -1;                      // We return -1 if we never found the item in the stack
    }

    @Override
    public int getSize() {
        return size;                    // Return the current size of the stack
    }


}
