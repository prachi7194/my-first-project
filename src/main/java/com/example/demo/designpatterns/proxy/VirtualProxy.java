package com.example.demo.designpatterns.proxy;

interface IImage{
    void display();
}

class RealImage implements IImage{
    private String filename;
    public RealImage(String filename){
        this.filename = filename;
        System.out.println("[RealImage] Loading image from disk: " + filename);

    }


    @Override
    public void display() {
        System.out.println("[RealImage] Displaying " + filename);

    }
}

class ImageProxy implements IImage{
    private RealImage realImage;
    private String filePath;
    ImageProxy(String filePath){
        this.filePath = filePath;
        this.realImage = null;
    }

    @Override
    public void display() {
        if(realImage == null){
            realImage = new RealImage(filePath);

        }
        realImage.display();

    }
}
public class VirtualProxy {
    public static void main(String[] args) {
        ImageProxy imageProxy = new ImageProxy("Sample.png");
        imageProxy.display();


    }
}
