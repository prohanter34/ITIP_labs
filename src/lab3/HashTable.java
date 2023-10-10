package lab3;

public class HashTable<T, U> {

    private Pair<T, U>[] data;
    private int length;
    private int size;


    public HashTable() {
        length = 11;
        data = new Pair[length];
        size = 0;
    }

    public HashTable(int length) {
        this.length = length;
        data = new Pair[length];
        size = 0;
    }
    public U put (T key, U value) {
        if (key != null || value != null) {
            int hash = hash(key);
            if (data[hash] == null) {
                data[hash] = new Pair<T, U>(key, value);
                size += 1;
                return null;
            } else {
                U output = data[hash].put(key, value);
                if (output == null) {
                    size += 1;
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    public U get(T key) {
        int hash = hash(key);
        if (data[hash] == null) {
            return null;
        } else {

            U value = data[hash].get(key);
            return value;
        }
    }

    public U remove(T key) {
        int hash = hash(key);
        if (data[hash] == null) {
            return null;
        } else {
            U value = data[hash].remove(key, this);
            if (value == null) {
                return null;
            } else {
                size -= 1;
                return value;
            }
        }
    }

    public int size() {
        return size;
    }

    public int len() {
        return length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hash(T key) {
        return Math.abs(key.hashCode()) % length;
    }

    public void _setData(Pair<T, U> pair, int hash) {
        data[hash] = pair;
    }

}
