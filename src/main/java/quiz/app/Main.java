package quiz.app;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import quiz.app.*;


public class Main extends JFrame{

//    public JPanel contentPane; mainPanel
    public Main() throws ClassNotFoundException, Exception {
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
            throw ex;
        }

        Utils.frame = this;

        Utils.changePane(new Start());


		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quiz Application");
        setName("MainFrame"); // NOI18N
        setMinimumSize(new Dimension(901, 601));
        setSize(new Dimension(901, 601));
        setPreferredSize(new Dimension(901, 601));
        setResizable(true);
        setLocation(new Point(200, 200));

        // Click Event Listeners

        pack();
        setVisible(true);
    }
    public static void main(String[] args) throws Exception {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Utils.connection = DriverManager.getConnection(
                    Utils.url,
                    Utils.user,
                    Utils.password
            );
            Utils.connection.setAutoCommit(false);
            JFrame f = new Main();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    // Event Listeners
//     jcomp4.addActionListener(new ActionListener() {
//		public void actionPerformed(ActionEvent e) {
//			CardLayout layout = (CardLayout) panel.getLayout();
//			layout.next(panel);
//		}
//	});





}
