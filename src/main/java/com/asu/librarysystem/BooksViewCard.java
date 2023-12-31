package com.asu.librarysystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;

import static com.asu.librarysystem.Library.searchBookByTitle;
import static com.asu.librarysystem.Library.searchCustomerByUserName;

public class BooksViewCard {
    @FXML
    private ImageView bookImage;

    @FXML
    private Label bookName, authorName, bookRate;


    public String calculateScore(ArrayList<Integer> reviews){
        int total = 0;
        for (int i = 1; i <= 5; i++){
            total += reviews.get(i);
        }

        if (total == 0){
            return "0";
        }

        double allRatings = reviews.get(1) + reviews.get(2) * 2 + reviews.get(3) * 3 + reviews.get(4) * 4
                + reviews.get(5) * 5;

        double score = allRatings / (double) (total * 5);

        score = score * 5;


        return String.format("%.1f", score);
    }
//    public String calculateScore(ArrayList<Integer> reviews){
//        int total = 0;
//        for (int i = 1; i <= 5; i++){
//            total += reviews.get(i);
//        }
//        if (total == 0){
//            return "0";
//        }
//
//        int allRatings = reviews.get(1) * 1 + reviews.get(2) * 2 + reviews.get(3) * 3 + reviews.get(4) * 4
//                + reviews.get(5) * 5;
//
//        double score = allRatings
//                / (double) (total * 5);
//
//        score = score * 5;
//        DecimalFormat formatting = new DecimalFormat("0.##");
//
//        return formatting.format(score);
//    }


    public void setData(Book book){
        InputStream fileLocation;
        try {
            fileLocation = new FileInputStream(book.getCoverPath());
            Image cover = new Image(fileLocation);
            bookImage.setImage(cover);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        bookName.setText(book.getTitle());
        authorName.setText(book.getAuthor());
//        String score=calculateScore(Library.getReviewHandler().getBookRatings(book.getId()));
//        bookRate.setText(score);
    }

    public void showDetailsOfBook(ActionEvent event){
        Book book= searchBookByTitle(bookName.getText());

//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("book-view.fxml"));
//            Parent root = loader.load();
//
//            BookController sceneController = loader.getController();
//            sceneController.setScene(book);
//            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//            Scene scene= new Scene(root);
//            stage.setScene(scene);
//            stage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("book-view.fxml"));
//            Parent root = loader.load();
//
//            BookController bookc = loader.getController();
//            bookc.setScene(book);
//
//            Scene newScene = new Scene(root);
//            MainApplication.st.setScene(newScene);
//            MainApplication.st.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
