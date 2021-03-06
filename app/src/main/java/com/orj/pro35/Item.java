package com.orj.pro35;

public class Item {

    private String name;
    private boolean bo;

    public Item(String name, boolean bo){
        this.name = name;
        this.bo = bo;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public boolean isBo() {
        return bo;
    }
    public void setBo(boolean bo) {
        this.bo = bo;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ",bo=" + bo +
                '}';
    }
}
