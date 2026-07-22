package com.example.demo.lld.elevator;

import java.util.Objects;

public class Request {
    private int floor;
    private RequestType requestType;

    public Request(int floor, RequestType requestType) {
        this.floor = floor;
        this.requestType = requestType;
    }

    public int getFloor() {
        return floor;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(!(o instanceof Request)){
            return false;
        }
        Request req = (Request) o;
        return floor == req.floor && requestType == req.requestType;
    }

    public int hash(){
        return Objects.hash(floor, requestType);
    }
}
