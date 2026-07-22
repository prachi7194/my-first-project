package com.example.demo.designpatterns.proxy;

interface IDocumentReader{
    void unlockPdf(String filePath, String password);
}

class RealDocumentUser implements IDocumentReader{

    @Override
    public void unlockPdf(String filePath, String password) {
        System.out.println("[RealDocumentReader] Unlocking PDF at: " + filePath);
        System.out.println("[RealDocumentReader] PDF unlocked successfully with password: " + password);
        System.out.println("[RealDocumentReader] Displaying PDF content...");
    }
}

class User{
    public String name;
    public boolean premiumMembership;
    public User(String name, boolean premiumMembership){
        this.name = name;
        this.premiumMembership = premiumMembership;

    }
}

class DocumentProxy implements IDocumentReader{
    private User user;
    private RealDocumentUser realDocumentUser;
    DocumentProxy(User user){
        this.user = user;
        this.realDocumentUser = new RealDocumentUser();
    }

    @Override
    public void unlockPdf(String filePath, String password) {
        if(!user.premiumMembership){
            System.out.println("[DocumentProxy] Access denied. Only premium members can unlock PDFs.");
            return;
        }
        realDocumentUser.unlockPdf(filePath, password);

    }
}
public class ProtectionProxy {

    public static void main(String[] args) {
        User user1 = new User("Rohan", false);
        User user2 = new User("Rashmi", true);
        IDocumentReader documentReader = new DocumentProxy(user1);
        documentReader.unlockPdf("protected_document.pdf", "secret123");
        IDocumentReader documentReader1 = new DocumentProxy(user2);
        documentReader1.unlockPdf("protected_document.pdf", "secret123");



    }
}
