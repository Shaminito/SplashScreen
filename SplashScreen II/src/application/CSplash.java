package application;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class CSplash{

	@FXML
	Label logo;
	
	@FXML
	Label bienvenido;
	
	@FXML
	AnchorPane background;
	
	@FXML
	Pane spinner;

	public void initialize() {
		
		background.setVisible(false);
		
		TranslateTransition logoTransition = new TranslateTransition(
				Duration.seconds(0.1), logo);
		logoTransition.setByY(700);
		logoTransition.play();
		
		TranslateTransition bienvenidoTransition = new TranslateTransition(
				Duration.seconds(0.1), bienvenido);
		bienvenidoTransition.setByY(700);
		bienvenidoTransition.play();
		
		bienvenidoTransition.setOnFinished(event1 ->{
			
			spinner.setVisible(true);

			FadeTransition spinnerTransition = new FadeTransition(
					Duration.seconds(2), spinner);
			spinnerTransition.setFromValue(0);
			spinnerTransition.setToValue(1);
			spinnerTransition.play();
			
			background.setVisible(true);

            FadeTransition backgroundTransition =new FadeTransition(Duration.seconds(2),background);
            backgroundTransition.setFromValue(0);
            backgroundTransition.setToValue(0.6);
            backgroundTransition.play();

			backgroundTransition.setOnFinished(event->{
				

				FadeTransition backgroundTransition1 =new FadeTransition(Duration.seconds(2),background);
	            backgroundTransition1.setFromValue(0.6);
	            backgroundTransition1.setToValue(0);
	            backgroundTransition1.play();
				
				backgroundTransition1.setOnFinished(event2 ->{
					spinner.setVisible(false);
					background.setVisible(false);
					TranslateTransition logoTransition1 = new TranslateTransition(
							Duration.seconds(1), logo);
					logoTransition1.setByY(-700);
					
					logoTransition1.play();
					
					logoTransition1.setOnFinished(event3->{
						TranslateTransition bienvenidoTransition1 = new TranslateTransition(
								Duration.seconds(1), bienvenido);
						bienvenidoTransition1.setByY(-700);
						
						bienvenidoTransition1.play();
					});
				});
			});
		});
	}
}