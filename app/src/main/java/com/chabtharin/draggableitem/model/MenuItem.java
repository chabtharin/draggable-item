package com.chabtharin.draggableitem.model;

public class MenuItem {
    private String title;
    private int resource;

    public MenuItem(String title, int resource) {
        this.title = title;
        this.resource = resource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "title='" + title + '\'' +
                ", resource=" + resource +
                '}';
    }
}
