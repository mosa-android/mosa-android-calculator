package org.mosa.calculator;

public class ListItem {
    private final String title;
    private final String subtitle;

    public ListItem(String title, String subtitle) {
        this.title = title;
        this.subtitle = subtitle;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }
}

