package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sun.security.util.Password;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Declarations:

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8); // vertical gap.
        grid.setHgap(10);
        //name label
        Label nameLabel = new Label("Username:");
        GridPane.setConstraints(nameLabel,0,0);
        //Name input
        TextField nameInput = new TextField();
        nameInput.setPromptText("Enter name here");
        GridPane.setConstraints(nameInput,1,0);
        //pass label
        Label passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel,0,1);
        //pass input
        PasswordField passField = new PasswordField();
        passField.setPromptText("Enter pass here");
        GridPane.setConstraints(passField,1,1);
        Button loginButton = new Button("Log In");
        GridPane.setConstraints(loginButton,2,1);
        //setOnActionMethods:

        loginButton.setOnAction(e->{
            if (!nameInput.getText().equals("") && !passField.getText().equals("")){ // check if the input is empty
                final String name,password;
                name = nameInput.getText();
                password = passField.getText();
                char[] nameArr = name.toCharArray();
                if (name.length() < 3 || name.length() > 16){
                    System.out.println("Name error, length.");
                    return;
                }
                for (char c : nameArr) {
                    if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')
                            || (c >= '0' && c <= '9')) {
                        // only allow numbers and caps/small letters.
                        System.out.println("Name and password may only include numbers and letters.");
                        break;
                    }
                    else {
                        System.out.println("name = " + name);
                        System.out.println("password = " + password);
                    }
                }

            }
        });
        grid.getChildren().addAll(nameLabel,nameInput,passLabel,passField,loginButton);




        Scene scene1 = new Scene(grid,300,200);

        //GUI Components:
        primaryStage.setMinWidth(500);
        primaryStage.setMinHeight(500);
        primaryStage.setTitle("Beeg Yoshi");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
//TODO https://stackoverflow.com/questions/32038418/javafx-how-to-bind-the-enter-key-to-a-button-and-fire-off-an-event-when-it-is-c