package com.buiminhduc.model.respond;

public class RoleRepond {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RoleRepond{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
