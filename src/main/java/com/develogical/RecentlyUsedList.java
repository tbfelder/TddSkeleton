package com.develogical;

public class RecentlyUsedList {
    private boolean isEmpty = true;

    public boolean isEmpty() {
        return isEmpty;
    }

    public void add(String item) {
        isEmpty = false;
    }
}
