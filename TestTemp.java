

import javafx.application.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.Slider;

public class TestTemp extends Application {

    Stage window;
    Scene scene1, scene2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        //Button 1
        Label label1 = new Label("SLIDER TEST");
       
 
        Slider slider = new Slider(0, 100, 10);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(10f);
        slider.setBlockIncrement(2.5f);
        slider.setOnDragOver(e -> System.out.println(slider.getOrientation()));
        
         slider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                    //System.out.println(new_val.doubleValue());
                    System.out.println(String.format("%.2f", new_val));
            }
        });
         
         
         
         Slider balanceKnob = new Slider(0,100,10);
        balanceKnob.setBlockIncrement(10);
        balanceKnob.setId("balance");
        balanceKnob.getStyleClass().add("knobStyle");
        balanceKnob.valueProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number newValue) {
                slider.setValue(newValue.doubleValue());
            }
        })
        ;
        
        
        //Layout 1 - children laid out in vertical column
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, slider, balanceKnob);
        scene1 = new Scene(layout1, 500, 500);


        //Display scene 1 at first
        window.setScene(scene1);
        window.setTitle("Title Here");
        window.show();
    }

}
}
