package main.hashtable;

public class HashTable<E> {

    private int capacity = 10;
    // Use LinkedList for chaining within each bucket
    private final HashEntry<E>[] buckets;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public HashTable() {
        this.buckets = new HashEntry[capacity];
    }

    @SuppressWarnings("unchecked")
    public HashTable(final int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity harus angka positif.");
        }
        this.capacity = capacity;
        this.buckets = new HashEntry[capacity];
    }

    public int capacity() {
        return capacity;
    }

    public int size() {
        return size;
    }

    public boolean isFull() {
        return size >= capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int hashCode(final E data) {
        if (data == null) {
            throw new IllegalArgumentException("data tidak boleh null");
        }
        int hash = data.hashCode();

        if (hash < 0)
            hash *= -1;

        return hash % capacity;
    }

    public void put(final E data) {
        if (data == null) {
            throw new IllegalArgumentException("data tidak boleh null");
        }
        if (isFull()) {
            throw new IllegalStateException("HashTable sudah penuh");
        }

        int bucketIndex = hashCode(data);
        // Remember start to detect full loop
        int startIndex = bucketIndex;

        int counter = 0;
        do {
            HashEntry<E> entry = buckets[bucketIndex];

            if (entry != null) {
                if (entry.data.equals(data)) {
                    return;
                }
                bucketIndex = (bucketIndex + 1) % capacity;
                counter++;
                continue;
            }

            if (counter > 0) {
                System.out.printf("Linear probing (idx %d -> %d) untuk data: %s\n", startIndex, bucketIndex, data);
            }

            buckets[bucketIndex] = new HashEntry<>(data);
            size++;
            return;

        } while (bucketIndex != startIndex);

        throw new IllegalStateException("Tidak ada tempat kosong untuk data: " + data);
    }

    public E get(final E data) {
        if (data == null) {
            throw new IllegalArgumentException("data tidak boleh null");
        }
        if (isEmpty()) {
            throw new IllegalStateException("Kosong: tidak ada data");
        }

        int bucketIndex = hashCode(data);

        while (buckets[bucketIndex] != null) {
            final HashEntry<E> bucket = buckets[bucketIndex];

            if (bucket.data.equals(data)) {
                return data;
            }
            bucketIndex++;
        }

        return null;
    }

    public E remove(final E data) {
        if (data == null) {
            throw new IllegalArgumentException("data tidak boleh null");
        }

        int bucketIndex = hashCode(data);

        while (buckets[bucketIndex] != null) {
            final HashEntry<E> bucket = buckets[bucketIndex];

            if (bucket.data.equals(data)) {
                buckets[bucketIndex] = null;
                return data;
            }
            bucketIndex++;
        }

        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < capacity; i++) {
            HashEntry<E> bucket = buckets[i];

            if (bucket == null) {
                sb.append(" ");
            } else {
                sb.append(bucket.data);
            }

            if (i < capacity - 1) {
                sb.append(", ");
            }
        }

        return sb.append("]").toString();
    }
}
