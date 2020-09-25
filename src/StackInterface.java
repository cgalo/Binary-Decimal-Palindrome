public interface StackInterface <Item> {

    public void push (Item item);       // Inserts item at the top of the stack

    public Item pop();                  // Returns and removes the top item of the stack

    public Item peek();                 // Return the top item of the stack without removing it from the stack

    public boolean empty();             // Returns true if stack is empty, false if there are items in the stack

    public int search(Item item);       // Returns the distance of the requested item to the top of the stack

    public int getSize();               // Return the current total items in the stack
}
