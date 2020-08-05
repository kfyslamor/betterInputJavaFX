package sample.Boxes;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static javafx.stage.Modality.APPLICATION_MODAL;

public class ConfirmBox {
    static boolean answer;
    public static boolean display(String title,String question){
        //Declarations:
        int count=0;
        Stage stagePopup = new Stage();
        stagePopup.setTitle(title);
        Button yesB = new Button("Yes");
        Button noB = new Button("No");
        Label labelQuestion = new Label(question);

        //setOnActionMethod:
        yesB.setOnAction(e -> {
            answer = true;
            stagePopup.close();
        });
        noB.setOnAction(e -> {
            answer = false;
            stagePopup.close();
        });



        //GUI Components:
        VBox vbox1 = new VBox(100);
        vbox1.getChildren().addAll(labelQuestion,yesB,noB);
        Scene scene1 = new Scene(vbox1);
        stagePopup.setScene(scene1);
        stagePopup.setMinWidth(500);
        stagePopup.setMinHeight(600);
        stagePopup.initModality(APPLICATION_MODAL);
        stagePopup.showAndWait();
        return answer;
    }
}
