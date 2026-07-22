package com.example.demo.lld.elevator;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController {
    private List<Elevator> elevatorsList;

    public ElevatorController(){
        this.elevatorsList = new ArrayList<>();
        elevatorsList.add(new Elevator());
        elevatorsList.add(new Elevator());
        elevatorsList.add(new Elevator());
    }

    public void step(){
        for(Elevator elevator : elevatorsList){
            elevator.step();
        }
    }

    public boolean requestElevator(int floor, RequestType requestType){
       if(floor < 0 || floor > 9){
           return false;
       }
       if(requestType == RequestType.DESTINATION){
           return false;
       }
       Request request = new Request(floor, requestType);
       Elevator best = selectBestElevator(request);
       if(best == null){
           return false;
       }
       return best.addRequest(request);
    }

    private Elevator selectBestElevator(Request request) {
        Elevator best = findMovingToward(request);
        if(best != null){
            return best;
        }
        best = findNearestIdle(request.getFloor());
        if(best != null){
            return best;
        }
        return findNearest(request.getFloor());
    }

    private Elevator findNearest(int floor) {
        Elevator nearest = null;
        int minDistance = Integer.MAX_VALUE;
        for(Elevator elevator : elevatorsList){
            int distance = Math.abs(elevator.getCurrentFloor() - floor);
            if(minDistance > distance){
                nearest = elevator;
                minDistance = distance;
            }

        }
        return nearest;
    }

    private Elevator findNearestIdle(int floor) {
        Elevator nearest = null;
        int minDistance = Integer.MAX_VALUE;
        for(Elevator elevator : elevatorsList){
            if(elevator.getDirection() != Direction.IDLE){
                continue;
            }
            int distance = Math.abs(elevator.getCurrentFloor() - floor);
            if(minDistance > distance){
                nearest = elevator;
                minDistance = distance;
            }

        }
        return nearest;
        
    }

    private Elevator findMovingToward(Request request) {
        int floor = request.getFloor();
        Direction direction = (request.getRequestType() ==RequestType.PICKUP_DOWN) ? Direction.DOWN:Direction.UP;
        Elevator nearest = null;
        int minDistance = Integer.MAX_VALUE;
        for(Elevator elevator : elevatorsList){
            if(elevator.getDirection() != direction){
                continue;
            }
            if(elevator.getCurrentFloor() > floor && direction == Direction.UP){
                continue;
            }
            if(elevator.getCurrentFloor() < floor && direction == Direction.DOWN){
                continue;
            }
            if(!elevator.hasRequestAtOrBeyond(floor, direction)){
                continue;
            }
            int distance = Math.abs(elevator.getCurrentFloor() - floor);
            if(minDistance > distance){
                nearest = elevator;
                minDistance = distance;
            }

        }
        return nearest;

    }

}
