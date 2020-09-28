package com.file.manager.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetFile {

    public static void getFiles(String path){
        File file=new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (int i = 0; i < files.length; i++) {
                    if (file.isDirectory()) {
                        System.out.println("目录：" + files[i].getPath());
                        getFiles(files[i].getPath());
                    } else {
                        System.out.println("文件" + files[i].getPath());
                    }

                }
            } else {

                System.out.println("文件：" + file.getPath());

            }
        }else {
            System.out.println("文件不在");
        }

    }
    public static List<String> getList(String path){//       File file=new File(path);
        File file=new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (int i = 0; i < files.length; i++) {
                    if (file.isDirectory()) {
                        System.out.println("目录：" + files[i].getPath());
                        getFiles(files[i].getPath());
                    } else {
                        System.out.println("文件" + files[i].getPath());
                    }

                }
            } else {

                System.out.println("文件：" + file.getPath());

            }
        }else {
            System.out.println("文件不在");
        }
        return null;
    }
    public static void getMap(String path,Map<String,List<Map<String,Object>>> mp){
        File file=new File(path);
        List<Map<String ,Object>> list=new ArrayList<>();
        Map<String,Object> m=new HashMap<>();
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (int i = 0; i < files.length; i++) {
                    if (file.isDirectory()) {
                        System.out.println("目录：" + files[i].getPath());
                        getFiles(files[i].getPath());
                    } else {
                        m.put(files[i].getPath(),null);
                        list.add(m);
                        System.out.println("文件" + files[i].getPath());
                    }

                }

            } else {
                mp.put(file.getPath(),null);
                System.out.println("文件：" + file.getPath());

            }
        }else {
            System.out.println("文件不在");
        }

    }

    public static void main(String[] args){
        String path="/home";
        getFiles(path);

    }
}
