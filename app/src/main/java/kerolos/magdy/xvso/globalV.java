package kerolos.magdy.xvso;

import android.app.Application;

public class globalV extends Application {
    private String brain = "Brain";

    public String getBrain() {
        return brain;
    }

    public void setBrain(String brain) {
        this.brain = brain;
    }
}
