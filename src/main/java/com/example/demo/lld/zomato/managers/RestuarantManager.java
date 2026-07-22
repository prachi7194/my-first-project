package com.example.demo.lld.zomato.managers;

import com.example.demo.lld.zomato.model.Restuarant;

import java.util.ArrayList;
import java.util.List;

public class RestuarantManager {
    List<Restuarant> restuarants = new ArrayList<>();
    private static RestuarantManager instance = null;



    public static RestuarantManager getInstance(){
        if(instance == null){
           instance = new RestuarantManager();
        }
        return instance;
    }

    public void addRestuarant(Restuarant r){
        restuarants.add(r);
    }

    public List<Restuarant> searchByLocation(String loc){
        List<Restuarant> result = new ArrayList<>();
        loc = loc.toLowerCase();
        for(Restuarant r : restuarants){
            String r1 = r.getLocation().toLowerCase();
            System.out.println("r1");
            System.out.println(loc);
            if(loc.equals(r1)){
                result.add(r);
            }
        }
        return result;
    }
}
