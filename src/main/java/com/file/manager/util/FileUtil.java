package com.file.manager.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    private static List<Tree> list=new ArrayList<>();
    private static Integer id=0;
    public static void main(String[] args){
        String filepath="/home/junj7n";
        //File file=new File(filepath);
        int parentid=0;
        file(filepath,parentid);
        for (int i = 0; i < list.size(); i++) {
            Tree tree = list.get(i);
            System.out.println("id:"+tree.getId()+"  parentId:"+tree.getParentId()+"  path:"+tree.getPath());
        }
    }
    public static List<Tree> getList(){
        return list;
    }
    public static void file(String filepath,int parentid){
        File file=new File(filepath);
        if (!file.exists()){
            Tree tree=new Tree(id++,"not found",filepath,parentid);
            list.add(tree);
        }
        if (file.isFile()){
            String name=file.getName();
            String path=file.getAbsolutePath();
            Tree tree=new Tree(id++,name,path,parentid);
            list.add(tree);
        }
        if (file.isDirectory()){
            String name = file.getName();
            String path = file.getAbsolutePath();
            Tree tree = new Tree(id++,name,path,parentid);
            list.add(tree);
            File[] list=file.listFiles();
            String parent=file.getParent();
            for (int i=0;i< list.length;i++){
                File s=list[i];
                //String newFilePath=path+"\\"+s;
                file(s.getAbsolutePath(),tree.getId());
            }
        }
    }
    public static List<Tree> get(String path,int parentid){
        File file=new File(path);
        List<Tree> l=new ArrayList<>();
        if (file.exists()){
            //System.out.println("found");
            if(file.isFile()){
                //System.out.println("it is file");
            }
            if(file.isDirectory()) {
                Tree tree = new Tree(0, file.getName(), path, parentid);
                l.add(tree);
            }
        }else {
            //System.out.println("not found");
        }
        return l;
    }
    public static  List<FileDto> list(String path,int parentid){
        List<FileDto> l = new ArrayList<>();
        if (path!=null) {
            File file = new File(path);
            int j = 0;

            if (file.exists()) {
                //System.out.println("found");
                if (file.isFile()) {
                    //System.out.println("it is file");
                }
                if (file.isDirectory()) {
                    File[] a = file.listFiles();
                    for (int i = 0; i < a.length; i++) {
                        File f = a[i];
                        j++;
                        String filename = f.getName();
                        FileDto dto = new FileDto(j, parentid, filename, f.getAbsolutePath(), f.isDirectory(), filename.substring(filename.lastIndexOf(".") + 1));
                        l.add(dto);
                    }


                }
            } else {
                //System.out.println("not found");
            }
        }
        return l;
    }

    public static FileDto get(String path){
        File file=new File(path);
        FileDto l=new FileDto();
        if (file.exists()){
            //System.out.println("found");
            if(file.isFile()){
                System.out.println("it is file");
                l.setDirec(false);
            }
            if(file.isDirectory()) {
               l.setDirec(true);
               l.setId(0);
               l.setName(path);
               l.setPath(path);
            }
        }else {
            //System.out.println("not found");
        }
        return l;
    }
}
