package com.example.demo.lld.notificationsystem;

import java.util.ArrayList;
import java.util.List;

interface INotification{
    String getContent();
}
class SimpleNotification implements INotification{
    String text;
    SimpleNotification(String text){
        this.text = text;
    }


    @Override
    public String getContent() {
        return text;
    }


}

abstract class INotificationDecorator implements INotification{
    INotification iNotification;
    public INotificationDecorator(INotification iNotification){
        this.iNotification = iNotification;
    }
}

class TimeStampDecorator extends INotificationDecorator{
    TimeStampDecorator(INotification iNotification){
        super(iNotification);
    }

    @Override
    public String getContent() {
        return "[2025-04-13 14:22:00] " + iNotification.getContent();
    }
}

class SignatureDecorator extends INotificationDecorator{
    private String signature;
    SignatureDecorator(INotification iNotification, String signature){
        super(iNotification);
        this.signature = signature;
    }

    @Override
    public String getContent() {
        return iNotification.getContent() + "\n-- " + signature + "\n\n";
    }
}

interface IObserver{
    public void update();
}

interface IObservable{
    void addObservers(IObserver observer);
    void removeObservers(IObserver observer);
    void notifyObservers();
}

class NotificationObservable implements IObservable{
    private List<IObserver> observerList = new ArrayList<>();
    private INotification currentNotification;

    @Override
    public void addObservers(IObserver observer) {
        observerList.add(observer);

    }

    @Override
    public void removeObservers(IObserver observer) {
        observerList.remove(observer);

    }

    @Override
    public void notifyObservers() {
        for(IObserver observer : observerList){
            observer.update();
        }

    }
    public void setNotification(INotification notification){
        this.currentNotification = notification;
        notifyObservers();
    }

    public String getNotificationContent(){
        return currentNotification.getContent();
    }
}

class Logger implements IObserver{
    NotificationObservable notificationObservable;
    Logger(NotificationObservable notificationObservable){
        this.notificationObservable = notificationObservable;
    }

    @Override
    public void update() {
        System.out.println("Logging New Notification : \n" + notificationObservable.getNotificationContent());
    }
}

interface INotificationStrategy{
    void sendNotification(String content);
}

class SMSNotificationStrategy implements INotificationStrategy{
    String sms;
    public SMSNotificationStrategy(String sms){
        this.sms = sms;
    }

    @Override
    public void sendNotification(String content) {
        System.out.println("Sending SMS Notification to: " +sms + "\n" + content);

    }
}

class EmailNotificationStrategy implements INotificationStrategy{
    String emailId;
    public EmailNotificationStrategy(String emailId){
        this.emailId = emailId;
    }

    @Override
    public void sendNotification(String content) {
        System.out.println("Sending email Notification to: " + emailId + "\n" + content);
    }
}

class PopUpStrategy implements INotificationStrategy {
    public void sendNotification(String content) {
        System.out.println("Sending Popup Notification: \n" + content);
    }
}

class NotificationEngine implements IObserver{
    NotificationObservable notificationObservable;
    private List<INotificationStrategy> notificationStrategies = new ArrayList<>();
    NotificationEngine(NotificationObservable notificationObservable){
        this.notificationObservable = notificationObservable;
    }

    public void addNotificationStrategy(INotificationStrategy notificationStrategy){
        this.notificationStrategies.add(notificationStrategy);
    }




    @Override
    public void update() {
        String content = notificationObservable.getNotificationContent();
        for(INotificationStrategy strategy: notificationStrategies){
            strategy.sendNotification(content);
        }

    }
}

class NotificationService{
    NotificationObservable notificationObservable;
    private static NotificationService instance = null;
    private List<INotification> notificationList = new ArrayList<>();

    private NotificationService(){
        notificationObservable = new NotificationObservable();
    }

    public static NotificationService getInstance(){
        if(instance == null){
            instance = new NotificationService();
        }
        return instance;
    }

    public NotificationObservable getObservable(){
        return notificationObservable;
    }
    public void sendNotification(INotification iNotification){
        notificationList.add(iNotification);
        notificationObservable.setNotification(iNotification);
    }
}
public class NotificationSystem {
    public static void main(String[] args) {
        NotificationService notificationService = NotificationService.getInstance();
        NotificationObservable notificationObservable = notificationService.getObservable();
        Logger logger = new Logger(notificationObservable);
        NotificationEngine notificationEngine = new NotificationEngine(notificationObservable);
        notificationEngine.addNotificationStrategy(new EmailNotificationStrategy("prachiag7@gmail.com"));
        notificationEngine.addNotificationStrategy(new SMSNotificationStrategy("9639153003"));
        notificationEngine.addNotificationStrategy(new PopUpStrategy());
        notificationObservable.addObservers(logger);
        notificationObservable.addObservers(notificationEngine);
        INotification notification = new SimpleNotification("Your order has been shipped");
        notification = new TimeStampDecorator(notification);
        notification = new SignatureDecorator(notification, "customer care");
        notificationService.sendNotification(notification);
    }
}
