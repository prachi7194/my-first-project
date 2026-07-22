package com.example.demo.designpatterns.proxy;

interface IDataService{
    public String fetchData();
}

class RealDataService implements IDataService{

    public RealDataService() {
        // Imagine this connects to a remote server or loads heavy resources.
        System.out.println("[RealDataService] Initialized (simulating remote setup)");
    }

    @Override
    public String fetchData() {
        return "[RealDataService] Data from server";


    }
}

class DataServiceProxy implements IDataService{
    private RealDataService realDataService;
    DataServiceProxy(){
        realDataService = new RealDataService();
    }

    @Override
    public String fetchData() {
        return realDataService.fetchData();
    }
}
public class RemoteProxy {
    public static void main(String[] args) {
        DataServiceProxy dataServiceProxy = new DataServiceProxy();
        System.out.println(dataServiceProxy.fetchData());

    }
}
