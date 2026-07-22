package com.example.demo.lld.elevator;

import java.util.HashSet;
import java.util.Set;

public class Elevator {
    private int currentFloor;
    private Direction direction;
    private Set<Request> requestSet;

    public Elevator(){
        this.currentFloor = 0;
        this.direction = Direction.IDLE;
        this.requestSet = new HashSet<>();
    }

    public boolean addRequest(Request request){
        if(request.getFloor() < 0 && request.getFloor() > 9){
            return false;
        }
        if(request.getFloor() == currentFloor){
            return true;
        }
        if(requestSet.contains(request.getFloor())){
            return false;
        }
        return requestSet.add(request);
    }

    public void step(){
        if(requestSet.isEmpty()){
            direction = Direction.IDLE;
            return;
        }
        if(direction == Direction.IDLE){
            Request nearest = null;
            int minDistance = Integer.MAX_VALUE;
            for(Request request: requestSet){
                int dist = Math.abs(request.getFloor() - currentFloor);
                if(dist < minDistance){
                    dist = minDistance;
                    nearest = request;
                }
            }
            direction = nearest.getFloor() > currentFloor ? Direction.UP : Direction.DOWN;
        }
        RequestType requestType = (direction == Direction.UP) ? RequestType.PICKUP_UP : RequestType.PICKUP_DOWN;
        Request pickUpRequest = new Request(currentFloor, requestType);
        Request destinationRequest = new Request(currentFloor,requestType);
        if(requestSet.contains(pickUpRequest) || requestSet.contains(destinationRequest)){
            requestSet.remove(pickUpRequest);
            requestSet.remove(destinationRequest);
            if(requestSet.isEmpty()){
                direction = Direction.IDLE;
            }
            return;
        }
        if(!hasRequestAhead(direction)){
            direction = direction == Direction.UP ? Direction.DOWN:Direction.UP;

        }
        if(direction == Direction.UP){
            currentFloor = currentFloor + 1;
        }
        if(direction == Direction.DOWN){
            currentFloor = currentFloor - 1;
        }


    }

    private boolean hasRequestAhead(Direction direction) {
        for(Request request : requestSet){
            if(direction == Direction.UP && request.getFloor() > currentFloor){
                return true;
            }
            if(direction == Direction.DOWN && request.getFloor() < currentFloor){
                return true;
            }
        }
        return false;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }


    public boolean hasRequestAtOrBeyond(int floor, Direction direction) {
        return false;
    }
}
