package com.develogical;

public class RecentlyUsedList {
    private boolean isEmpty = true;

    public boolean isEmpty() {
        return isEmpty;
    }

    public void add(String item) {
        isEmpty = false;
    }

    public String get(int index) {
        return "item";
    }
}
