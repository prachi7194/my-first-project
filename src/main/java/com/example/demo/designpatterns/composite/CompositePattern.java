package com.example.demo.designpatterns.composite;

import java.util.ArrayList;
import java.util.List;

interface FileSystemItem{
    void ls();
    int size();
    void openAll();
    FileSystemItem cd(String name);
    String getName();
    boolean isFolder();
}

class File implements FileSystemItem{
    private String name;
    private int size;
    public File(String name, int size){
        this.name = name;
        this.size = size;
    }

    @Override
    public void ls() {
        System.out.println(name);

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void openAll() {
        System.out.println(name);

    }

    @Override
    public FileSystemItem cd(String name) {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isFolder() {
        return false;
    }
}

class Folder implements FileSystemItem{
    private String name;
    private List<FileSystemItem> children;
    public Folder(String name){
        this.name = name;
        this.children = new ArrayList<>();
    }
    public void add(FileSystemItem item){
        children.add(item);
    }

    @Override
    public void ls() {
        for(FileSystemItem fileSystemItem : children){
            System.out.println(fileSystemItem.getName());
        }

    }

    @Override
    public int size() {
        int total = 0;
        for(FileSystemItem fileSystemItem : children){
            total = total + fileSystemItem.size();
        }
        return total;
    }

    @Override
    public void openAll() {
        System.out.println(name);
        for(FileSystemItem fileSystemItem : children){
            fileSystemItem.openAll();
        }

    }

    @Override
    public FileSystemItem cd(String name) {
       for(FileSystemItem fileSystemItem : children){
           if(fileSystemItem.isFolder() && fileSystemItem.getName().equals(name)){
               return fileSystemItem;
           }
       }
       return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isFolder() {
        return true;
    }
}
public class CompositePattern {
    public static void main(String[] args) {
        Folder folder = new Folder("root");
        folder.add(new File("file1.txt",1));
        folder.add(new File("file2.txt",1));

        Folder docs = new Folder("docs");
        docs.add(new File("doc1.txt",1));
        docs.add(new File("doc2.txt",1));
        folder.add(docs);

        Folder images = new Folder("images");
        images.add(new File("photo.jpg", 1));
        folder.add(images);

        folder.cd("images");




    }
}
