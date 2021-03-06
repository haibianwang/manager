package com.file.manager.util;

public class Tree {

    private Integer id; //
    private String name;
    private String path;
    private Integer parentId;

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
    public Tree() {
    }

    public Tree(Integer id, String name, String path,Integer parentId) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.parentId = parentId;
    }
    @Override
    public String toString() {
        return "Tree{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", parentId=" + parentId +
                '}';
    }
}
