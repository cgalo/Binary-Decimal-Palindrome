public interface StackInterface <E> {
    public void push (E item);

    public E pop();

    public E peek();

    public boolean empty();

    public int search(E item);
}
