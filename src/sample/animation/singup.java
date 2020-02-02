package sample.animation;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

import javax.swing.*;

public class singup {
    private TranslateTransition a;
    public singup(Node node)
    {
        a= new TranslateTransition(Duration.millis(70),node);
        a.setFromX(0f);
        a.setByX(20f);
        a.setCycleCount(3);
        a.setAutoReverse(true);
    }
    public void playAnim()
    {
        a.playFromStart();
    }
}

