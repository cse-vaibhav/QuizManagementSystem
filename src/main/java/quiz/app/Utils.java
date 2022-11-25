package quiz.app;

import javax.swing.*;

public class Utils {

    public static JFrame frame;

    public static String genCode(int size) {
            String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456788" + "abcdefghijklmnopqrstuvxyz";

            StringBuilder sb = new StringBuilder(size);
            for (Integer i=0; i<size; i++) {
                Integer ind = (int) (AlphaNumericString.length()*Math.random());
                sb.append(AlphaNumericString.charAt(ind));
            }
            return sb.toString();
    }

    public static void PopUp(String message) {
        JFrame f = new JFrame();
        JOptionPane.showMessageDialog(f, message);
    }

    public static void changePane(JPanel pane) {
        frame.setContentPane(pane);
        frame.revalidate();
    }
}