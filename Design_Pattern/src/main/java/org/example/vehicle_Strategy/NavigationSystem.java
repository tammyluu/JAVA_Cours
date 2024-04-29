package org.example.vehicle_Strategy;

import lombok.Builder;
import lombok.Data;

@Data

public class NavigationSystem {
    private  String navigation;
    private INavigationStrategy navigationStrategy;

    public  void proccess(INavigationStrategy navigationStrategy){
        if(navigationStrategy.applyNavigate(navigation)){
            System.out.println("---Navigation known---- ");
        }else {
            System.out.println("----Navigation unknown---- ");
        }
    }
    public NavigationSystem(INavigationStrategy navigationStrategy) {
        this.navigationStrategy = navigationStrategy;
    }

    public void setNavigationStrategy(INavigationStrategy navigationStrategy) {
        this.navigationStrategy = navigationStrategy;
    }

    public void navigate(String destination) {
        navigationStrategy.applyNavigate(destination);
    }


}
