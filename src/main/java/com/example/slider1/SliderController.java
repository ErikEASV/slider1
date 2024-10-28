package com.example.slider1;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class SliderController {

    @FXML
    private Slider minSlider;

    @FXML
    private Label statusLabel;


    public void initialize() {
        // Sæt startværdi
        minSlider.setValue(50);
        statusLabel.setText("Value: " + (int)minSlider.getValue());

        // Sæt tal på thumb (smart). Det sker at klistre et tekstknude på sliderens thumb som er en stackpane
        Text text = new Text();
        text.setText((int)minSlider.getValue()+"");   // +"" tvinger integer til streng
        minSlider.skinProperty().addListener((obs,old,skin)->{
            if (skin!=null) {
                StackPane thumb = (StackPane)minSlider.lookup(".thumb");
                //thumb.setPadding(new Insets(10));
                thumb.getChildren().add(text);
            }
        });

        // Sæt lytter
        minSlider.valueProperty().addListener((observable, oldValue, newValue) ->
            {
                text.setText(newValue.intValue()+"");
                statusLabel.setText("Selected value: " + newValue.intValue());
                //statusLabel.setText("Selected value: " + Integer.toBinaryString(newValue.intValue()));
            }
        );
    }

    /* eller
        minSlider.valueProperty().addListener(new ChangeListener<Number>() {
         public void changed(ObservableValue<?extends Number> observable, Number oldValue, Number newValue){
            statusLabel.setText("Selected value: " + newValue);
         }
      });
    }*/
}
