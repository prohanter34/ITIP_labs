package lab3;

public class Pair<T, U> {

    private T key;
    private U value;
    private Pair<T, U> child;
    private Pair<T, U> parent;

    public Pair(T key, U value) {
        this.key = key;
        this.value = value;
        child = null;
        parent = null;
    }
    public Pair(T key, U value, Pair<T, U> parent) {
        this.key = key;
        this.value = value;
        child = null;
        this.parent = parent;
    }

    public U put(T key, U value) {
        if (key != this.key) {
            if (child == null) {
                child = new Pair<T, U>(key, value, this);
                return null;
            } else {
                return child.put(key, value);
            }

        } else {
            this.value = value;
            return this.value;
        }
    }
    
    public U get(T key) {
        if (this.key == key) {
            return value;
        } else if (child == null) {
            return null;
        } else {
            return child.get(key);
        }
    }

    public U remove(T key, HashTable<T, U> map) {
        if (this.key == key) {
            if (parent != null) {
                parent.deleteChild();
                parent.setChild(child);
                child.setParent(parent);
            } else {
                if (child != null) {
                    child.deleteParent();
                    map._setData(child, Math.abs(key.hashCode()) % map.len());
                } else {
                    map._setData(null, Math.abs(key.hashCode()) % map.len());
                }
            }
            return value;
        } else if (child == null) {
            return null;
        } else {
            return child.remove(key, map);
        }
    }

    private void setChild(Pair<T, U> child) {
        this.child = child;
    }

    public void setParent(Pair<T, U> parent) {
        this.parent = parent;
    }

    private void deleteChild() {
        child = null;
    }

    private void deleteParent() {
        parent = null;
    }


}
