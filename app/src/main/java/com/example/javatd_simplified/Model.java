package com.example.javatd_simplified;

public class Model {

    @Override
    public String toString() {
        return "Model{" +
                "td_item='" + td_item + '\'' +
                ", id=" + id +
                '}';
    }

    public Model () {

    }

    public Model(String td_item, int id) {
        this.td_item = td_item;
        this.id = id;
    }

    public String getTd_item() {
        return td_item;
    }

    public void setTd_item(String td_item) {
        this.td_item = td_item;
    }

    private String td_item;

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
