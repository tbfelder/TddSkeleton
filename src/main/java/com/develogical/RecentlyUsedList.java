package com.develogical;

public class RecentlyUsedList {
    private String item;

    public boolean isEmpty() {
        return item == null;
    }

    public void add(String item) {
        this.item = item;
    }

    public String get(int index) {
        return item;
    }
}
