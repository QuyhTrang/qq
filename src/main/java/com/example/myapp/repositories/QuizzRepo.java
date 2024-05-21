package com.example.myapp.repositories;

import com.example.myapp.models.Quizz;
import com.example.myapp.models.Word;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuizzRepo {
    static String FILE_PATH = "src/main/resources/com/example/myapp/QuizQuestion.txt";

    public class QuizDataReader {
        public static List<Quizz> readQuizData() throws IOException {
            List<Quizz> quizzes = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH)); // Read from standard input (console)

            String line;
            while ((line = reader.readLine()) != null) {
                Quizz quiz = parseQuizzLine(line);
                if (quiz != null) {
                    quizzes.add(quiz);
                }
            }
            return quizzes;
        }


        private static <QuizData> QuizData parseQuizLine(String line) {
            try {
                String[] parts = line.split(" "); // Split the line by spaces
                if (parts.length < 4) {
                    System.err.println("Invalid quiz line format: " + line);
                    return null;
                }

                String question = parts[0] + " " + parts[1] + " " + parts[2] + "..."; // Combine question parts
                int answerIndex = Integer.parseInt(parts[parts.length - 1]); // Parse answer index

                List<String> options = new ArrayList<>();
                for (int i = 3; i < parts.length - 1; i++) {
                    options.add(parts[i]);
                }

                return (QuizData) new Quizz(question, options, answerIndex);
            } catch (NumberFormatException e) {
                System.err.println("Invalid answer index format: " + line);
                return null;
            }
        }

        public static void main(String[] args) throws IOException {
            List<Quizz> quizzes = readQuizData();
            for (Quizz quiz : quizzes) {
                System.out.println(quiz.getQuestion());
                for (int i = 0; i < quiz.getOptions().size(); i++) {
                    System.out.println((i + 1) + ". " + quiz.getOptions().get(i));
                }
                System.out.println(); // Print a newline after each quiz
            }
        }
    }

    private static Quizz parseQuizzLine(String line) {
        return null;
    }
}

