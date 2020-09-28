package com.file.manager.util;

import org.omg.CORBA.INTERNAL;

public class FileDto {
    private String name;
    private String path;
    private boolean isDirec;
    private int id;
    private int parentid;
    private String suffix;

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

    public boolean isDirec() {
        return isDirec;
    }

    public void setDirec(boolean direc) {
        isDirec = direc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public FileDto(int id, int parentid, String name, String path, boolean isDirec,String suffix) {
        this.name = name;
        this.path = path;
        this.isDirec = isDirec;
        this.id = id;
        this.parentid = parentid;
        this.suffix=suffix;
    }
    public FileDto(){

    }
}
