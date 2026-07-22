package com.example.demo.designpatterns.adapter;

interface IReports{
    String getString(String raw);
}

class IntegerXmlProvider{
    Integer getData(String data){
        return Integer.valueOf(data);

    }
}

class Adapter implements IReports{
    IntegerXmlProvider integerXmlProvider;
    public Adapter(IntegerXmlProvider integerXmlProvider){
        this.integerXmlProvider = integerXmlProvider;
    }


    @Override
    public String getString(String raw) {
        int x = integerXmlProvider.getData(raw);
        return String.valueOf(x);
    }
}

class Client{
    public void getReport(IReports iReports,String data){
        System.out.println("Processed JSON: "
                + iReports.getString(data));
    }
}


public class AdapterDesignPattern {
    public static void main(String[] args) {
        IntegerXmlProvider integerXmlProvider = new IntegerXmlProvider();
        IReports adapter = new Adapter(integerXmlProvider);
        String rawData = "1";
        Client client = new Client();

        client.getReport(adapter, rawData);


    }

}
