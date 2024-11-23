package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    ArrayList<Candidate> candidates = new ArrayList<>();
    @Override
    public void start(Stage stage) throws IOException {
        GridPane gridPane = new GridPane();
        Scene scene = new Scene(gridPane, 700, 650);
        Image image = new Image(getClass().getResource("/image/green.jpg").toExternalForm());

        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(150);
        imageView.setFitWidth(900);
        gridPane.add(imageView, 0, 0);


        TextField nametext = new TextField();
        Label namelabel = new Label("Name");
        HBox namehbox = new HBox();
        namehbox.getChildren().addAll(namelabel, nametext);
        gridPane.add(namehbox, 0, 1, 1, 1);
        namehbox.setPadding(new Insets(10));
        namehbox.setSpacing(10);
        namehbox.setBorder(new Border(
                new BorderStroke(
                        Color.WHITE,
                        BorderStrokeStyle.SOLID,
                        CornerRadii.EMPTY,
                        new BorderWidths(2, 4, 6, 8)
                )
        ));

        TextField fathernametext = new TextField();
        Label fathernamelabel = new Label("FatherName");
        HBox fathernamehbox = new HBox();
        fathernamehbox.getChildren().addAll(fathernamelabel, fathernametext);
        gridPane.add(fathernamehbox, 0, 2, 1, 1);
        fathernamehbox.setPadding(new Insets(10));
        fathernamehbox.setSpacing(10);
        fathernamehbox.setBorder(new Border(
                new BorderStroke(
                        Color.WHITE,
                        BorderStrokeStyle.SOLID,
                        CornerRadii.EMPTY,
                        new BorderWidths(2, 4, 6, 8)
                )
        ));

        ComboBox<String> citycombo = new ComboBox<String>();
        citycombo.getItems().addAll("Lahore", "Bahwalpur", "Islamabad");
        // TextField citytextfield = new TextField();
        Label citylabel = new Label("City");
        HBox cityhbox = new HBox();
        cityhbox.getChildren().addAll(citylabel, citycombo);
        gridPane.add(cityhbox, 0, 3, 1, 1);
        cityhbox.setPadding(new Insets(10));
        cityhbox.setSpacing(10);

        Image footerimage = new Image(getClass().getResource("/image/web_development.png").toExternalForm());
        ImageView imageView1 = new ImageView(footerimage);

        imageView1.setFitHeight(250);
        imageView1.setFitWidth(150);
        imageView1.setPreserveRatio(true);

        gridPane.add(imageView1, 0, 4);

        GridPane.setHalignment(imageView1, HPos.CENTER);

        TextArea textArea = new TextArea();
        Label addresslaabel = new Label("Address");
        HBox addresshbox = new HBox();
        textArea.setPrefRowCount(2); // Allows for multi-line input
        textArea.setPrefColumnCount(20);
        addresshbox.getChildren().addAll(addresslaabel, textArea);
        gridPane.add(addresshbox, 0, 4, 1, 1);
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        addresshbox.setPadding(new Insets(10));
        addresshbox.setSpacing(10);


        TextField emailtextfield = new TextField();
        Label emaillabel = new Label("E-mail");
        HBox emailhbox = new HBox();
        emailhbox.getChildren().addAll(emaillabel, emailtextfield);
        gridPane.add(emailhbox, 0, 5, 1, 1);
        emailhbox.setPadding(new Insets(10));
        emailhbox.setSpacing(10);
        emailhbox.setBorder(new Border(
                new BorderStroke(
                        Color.WHITE,
                        BorderStrokeStyle.SOLID,
                        CornerRadii.EMPTY,
                        new BorderWidths(2, 4, 6, 8)
                )
        ));

        Label genderlabel = new Label("Gender: ");
        RadioButton male = new RadioButton("male");
        RadioButton female = new RadioButton("female");
        HBox genderhbox = new HBox();
        genderhbox.getChildren().addAll(genderlabel, male, female);
        gridPane.add(genderhbox, 0, 6, 1, 1);
        ToggleGroup gendertoggle = new ToggleGroup();
        male.setToggleGroup(gendertoggle);
        female.setToggleGroup(gendertoggle);
        genderhbox.setPadding(new Insets(10));
        genderhbox.setSpacing(10);
        genderhbox.setBorder(new Border(
                new BorderStroke(
                        Color.WHITE,
                        BorderStrokeStyle.SOLID,
                        CornerRadii.EMPTY,
                        new BorderWidths(2, 4, 6, 8)
                )
        ));


        Button submitbutton = new Button("Submit");
        Label buttonlabel = new Label();
        HBox buttonh = new HBox();
        buttonh.getChildren().addAll(submitbutton,buttonlabel);
        gridPane.add(buttonh, 0, 7, 1, 1);
        Text message = new Text();
        message.setFont(Font.font("Arial", 16));
        gridPane.add(message, 0, 9);
        gridPane.setVgap(10);
        submitbutton.setOnAction(event -> {
            buttonlabel.setText("Form Submitted!");
        });
        buttonh.setAlignment(Pos.CENTER);

            submitbutton.setOnAction(event -> {
                        String name = nametext.getText();
                        String fatherName = fathernametext.getText();
                        String city = citycombo.getValue();
                        String address = addresslaabel.getText();
                        String email = emaillabel.getText();
                        String gender = male.isSelected() ? "Male" : (female.isSelected() ? "Female" : "");

                        if(name.isEmpty()|| fatherName.isEmpty()||city==null||address.isEmpty()||email.isEmpty()) {
                            message.setText("fill in the fields");
                            message.setFill(Color.RED);
                            return;
                        }
                        candidates.add(new Candidate(name,fatherName,city,address,email,gender));
                System.out.println("submitted candidates: " +candidates);

                        nametext.clear();
                        fathernametext.clear();
                        citycombo.setValue(null);
                        textArea.clear();
                        emailtextfield.clear();
                        gendertoggle.selectToggle(null);

                        message.setText("Message submitted");
                        message.setFill(Color.GREEN);

VBox vBox = new VBox();
vBox.setPadding(new Insets(10));
vBox.setSpacing(10);
for(Candidate candidate:candidates){
Text displaytext = new Text("Candidates Information" + "\n"+
             "Name: "+ candidates.getLast().getName() + "\n"+
                "Father name: " + candidates.getLast().getFatherName() + "\n"+
                "City: " + candidates.getLast().getCity()+"\n"+
                 "Address: "+candidates.getLast().getAddress()+ "\n"+
                 "Email: " + candidates.getLast().getEmail()+"\n"+
                 "Gender: "+candidates.getLast().getGender());
 vBox.getChildren().addAll(displaytext);


}
                Scene newScene = new Scene( vBox,400,400);
                        stage.setScene(newScene);

                    });
            stage.setTitle("Candidate form");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();

    }
}
