package quiz.app;

import javax.swing.*;

public class Utils {

    public static JFrame frame;
    public static String quizCode;

    public static java.sql.Connection connection;
    public static String user = "vaibhavj";
    public static String databaseName = "QuizManagementSystem";
    public static String url = String.format("jdbc:mysql://localhost:3306/%s", databaseName);
    public static String password = "rockatale";

    public static String genCode(int size) {
            String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456788" + "abcdefghijklmnopqrstuvxyz";

            StringBuilder sb = new StringBuilder(size);
            for (Integer i=0; i<size; i++) {
                Integer ind = (int) (AlphaNumericString.length()*Math.random());
                sb.append(AlphaNumericString.charAt(ind));
            }
            quizCode = sb.toString();
            return quizCode;
    }

    public static void PopUp(String message) {
        try {
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, message);
            f.setBackground(new java.awt.Color(255, 255, 255));
            javax.swing.UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
    }

    public static void changePane(JPanel pane) {
        frame.setContentPane(pane);
        frame.revalidate();
    }



}