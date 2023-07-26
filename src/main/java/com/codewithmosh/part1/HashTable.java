package com.codewithmosh.part1;

import java.util.LinkedList;

public class HashTable {
    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] entries = new LinkedList[5];

    public void remove(int key) {
        Entry entry = getEntry(key);
        if (entry == null)
            throw new IllegalStateException();
        getBucket(key).remove(entry);
    }

    public String get(int key) {
        Entry entry = getEntry(key);
        if (entry == null)
            return null;
        return entry.value;
    }

    private LinkedList<Entry> getBucket(int key) {
        return entries[hash(key)];
    }

    private LinkedList<Entry> getOrCreateBucket(int key) {
        int index = hash(key);
        LinkedList<Entry> bucket = entries[index];
        if (bucket == null)
            bucket = entries[index] = new LinkedList<>();
        return bucket;
    }

    private Entry getEntry(int key) {
        var bucket = getBucket(key);
        if (bucket != null) {
            for (var entry : bucket) {
                if (entry.key == key)
                    return entry;
            }
        }
        return null;
    }

    public void put(int key, String value) {
        var entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
            return;
        }
        getOrCreateBucket(key).add(new Entry(key, value));
    }

    private int hash(int key) {
        return key % entries.length;
    }

    public static void main(String[] args) {
        var hashTable = new HashTable();
        hashTable.put(6, "A"); //1
        hashTable.put(8, "B"); //3
        hashTable.put(11, "C"); //1
        hashTable.put(6, "A+");
        hashTable.remove(6);
        System.out.println(hashTable.get(6));
        System.out.println(hashTable.get(8));
        System.out.println(hashTable.get(10));
    }
}
