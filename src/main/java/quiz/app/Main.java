package quiz.app;

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
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        Utils.frame = this;

        Utils.changePane(new Start());


		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quiz Application");
        setName("MainFrame"); // NOI18N
        setMinimumSize(new Dimension(901, 601));
        setSize(new Dimension(901, 601));
        setPreferredSize(new Dimension(901, 601));
        setResizable(false);
        setLocation(new Point(200, 200));

        // Click Event Listeners

        pack();
        setVisible(true);
    }
    public static void main(String[] args) {

        try {
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
