package com.example.demo.lld.googledocs.gooddesign;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DocumentEditorClient {
    public static void main(String[] args) {
        Document document = new Document();
        Persistence persistence = new FileStorage();

        DocumentEditor editor = new DocumentEditor(document, persistence);

        // Simulate a client using the editor with common text formatting features.
        editor.addText("Hello, world!");
        editor.addNewLine();
        editor.addText("This is a real-world document editor example.");
        editor.addNewLine();
        editor.addTabSpace();
        editor.addText("Indented text after a tab space.");
        editor.addNewLine();
        editor.addImage("picture.jpg");

        // Render and display the final document.
        System.out.println(editor.render());

        editor.save();

    }

}

interface DocumentElement {
    public String render();
}
    class TextElement implements DocumentElement{
        private String text;
        public TextElement(String text){
            this.text = text;
        }
        @Override
        public String render(){
            return text;
        }
    }

    class ImageElement implements DocumentElement{
        private String imagePath;
        public ImageElement(String imagePath){
            this.imagePath = imagePath;
        }
        @Override
        public String render(){
            return  "[Image: " + imagePath + "]";
        }
    }

    class NewLineElement implements DocumentElement{

        @Override
        public String render() {
            return "\n";
        }
    }

    class TableSpaceElement implements DocumentElement{

        @Override
        public String render() {
            return "\t";
        }
    }

    class Document{
        private List<DocumentElement> documentElements = new ArrayList<>();
        public void addElement(DocumentElement element){
            documentElements.add(element);
        }
        public String render(){
            StringBuilder result = new StringBuilder();
            for (DocumentElement element : documentElements) {
                result.append(element.render());
            }
            return result.toString();
        }
    }

    interface Persistence{
        void save(String data);
    }

    class FileStorage implements Persistence{

        @Override
        public void save(String data) {
            try {
                FileWriter fileWriter = new FileWriter("document.txt");
                fileWriter.write(data);
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

// Placeholder DBStorage implementation
class DBStorage implements Persistence {
    @Override
    public void save(String data) {
        // Save to DB
    }
}

class DocumentEditor{
    private Document document;
    private Persistence persistence;
    private String renderedDoc = "";

    public DocumentEditor(Document document, Persistence persistence){
        this.document = document;
        this.persistence = persistence;
    }

    public void addText(String text){
        document.addElement(new TextElement(text));
    }

    public void addImage(String imagePath){
        document.addElement(new ImageElement(imagePath));
    }
    public void addNewLine(){
        document.addElement(new NewLineElement());
    }

    public void addTabSpace(){
        document.addElement(new TableSpaceElement());
    }

    public String render(){
        if(renderedDoc.isEmpty()){
            renderedDoc = document.render();
        }
        return renderedDoc;
    }

    public void save(){
        persistence.save(renderedDoc);
    }
}



