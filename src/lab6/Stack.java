package lab6;

public class Stack<T> {
    private T[] data;
    private int length;
    private int size;


    public Stack(int length) {
        this.length = length;
        size = 0;
        data = (T[]) new Object[length];
    }

    public T push(T element) {
        data[size] = element;
        size += 1;
        return element;
    }

    public T pop() {
        T element = data[size-1];
        size -= 1;
        return element;
    }

    public T peek() {
        return data[size - 1];
    }


}
