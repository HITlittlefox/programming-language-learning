package Coffeine;

public class Coffee {
    public void boilWater() {
        System.out.println("Boiling water!");

    }

    public void brewCoffeeGrinds() {
    }

    public void pourInCup() {
    }

    public void addSugarAndMilk() {
    }


    public void prepareRecipe() {  //流程
        boilWater();
        brewCoffeeGrinds();
        pourInCup();
        addSugarAndMilk();
    }

}
