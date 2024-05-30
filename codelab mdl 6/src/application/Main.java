package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Main extends Application {
    @Override
    public void start(Stage primaryWindow) {
        try {
            GridPane signInGrid = new GridPane();
            signInGrid.setAlignment(Pos.CENTER);
            signInGrid.setPadding(new Insets(10, 10, 10, 10));
            signInGrid.setVgap(10);
            signInGrid.setHgap(10);

            Text headerText = new Text("Login Screen");
            headerText.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));
            GridPane.setConstraints(headerText, 0, 0, 2, 1);

            Label nameLabel = new Label("User ID:");
            GridPane.setConstraints(nameLabel, 0, 1);
            TextField nameField = new TextField();
            nameField.setPromptText("Enter your ID");
            GridPane.setConstraints(nameField, 1, 1);

            Label passLabel = new Label("Secret Key:");
            GridPane.setConstraints(passLabel, 0, 2);
            PasswordField passField = new PasswordField();
            GridPane.setConstraints(passField, 1, 2);

            Button enterButton = new Button("Login");
            HBox enterBox = new HBox(10);
            enterBox.setAlignment(Pos.BOTTOM_RIGHT);
            enterBox.getChildren().add(enterButton);
            GridPane.setConstraints(enterBox, 1, 3);

            Text alertText = new Text();
            alertText.setFill(Color.RED);
            GridPane.setConstraints(alertText, 1, 4);

            GridPane welcomeGrid = new GridPane();
            welcomeGrid.setAlignment(Pos.CENTER);
            welcomeGrid.setPadding(new Insets(10, 10, 10, 10));
            welcomeGrid.setVgap(10);
            welcomeGrid.setHgap(10);

            Text welcomeMsg = new Text();
            welcomeMsg.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));
            GridPane.setConstraints(welcomeMsg, 0, 0);

            Button exitButton = new Button("Exit");
            HBox exitBox = new HBox(10);
            exitBox.setAlignment(Pos.BOTTOM_RIGHT);
            exitBox.getChildren().add(exitButton);
            GridPane.setConstraints(exitBox, 0, 1);

            Scene signInScene = new Scene(signInGrid, 400, 400);
            Scene welcomeScene = new Scene(welcomeGrid, 400, 400);

            signInGrid.getChildren().addAll(headerText, nameLabel, nameField, passLabel, passField, enterBox, alertText);
            welcomeGrid.getChildren().addAll(welcomeMsg, exitBox);

            enterButton.setOnAction(event -> {
                String userId = nameField.getText();
                String userKey = passField.getText();

                if ("admin".equals(userId) && "1234".equals(userKey)) {
                    welcomeMsg.setText("Welcome " + nameField.getText());
                    primaryWindow.setScene(welcomeScene);
                } else {
                    alertText.setText("password atau user salah");
                }
            });

            exitButton.setOnAction(event -> {
                passField.clear();
                primaryWindow.setScene(signInScene);
            });

            signInScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryWindow.setScene(signInScene);
            primaryWindow.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
