package main.hashtable;

public class HashEntry<E> {
    protected E data;
    protected int hash;

    HashEntry(E data) {
        this.data = data;
        this.hash = 0;
    }
}
