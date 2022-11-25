
package quiz.app;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Test
{
    private JPanel contentPane;
    private MyPanel panel1;
    private MyPanel2 panel2;

    private void displayGUI()
    {
        JFrame frame = new JFrame("Card Layout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(
            BorderFactory.createEmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new CardLayout());
        panel1 = new MyPanel(contentPane);
        panel2 = new MyPanel2(contentPane);
        contentPane.add(panel1, "Panel 1"); 
        contentPane.add(panel2, "Panel 2");
        frame.setContentPane(contentPane);
        frame.pack();   
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new Test().displayGUI();
            }
        });
    }
}

class MyPanel extends JPanel {

    private JTextField How;
    private JLabel jcomp2;
    private JLabel jcomp3;
    private JButton jcomp4;
    private JPanel contentPane;

    public MyPanel(JPanel panel) {

        contentPane = panel;
        //construct components
        How = new JTextField (1);
        jcomp2 = new JLabel ("How long were you parked?");
        jcomp3 = new JLabel ("Minutes");
        jcomp4 = new JButton ("openNewWindow");

        //adjust size and set layout
        setPreferredSize (new Dimension (315, 85));
        setLayout (null);

        //set component bounds (only needed by Absolute Positioning)
        How.setBounds (245, 50, 60, 25);
        jcomp2.setBounds (35, 30, 185, 50);
        jcomp3.setBounds (250, 30, 60, 20);
        jcomp4.setLocation(0, 0);
        jcomp4.setSize(315, 25);
        jcomp4.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.next(contentPane);
            }
        });

        //add components
        add (How);
        add (jcomp2);
        add (jcomp3);
        add (jcomp4);               
    }
}

class MyPanel2 extends JPanel {
    private JButton jcomp1;
    private JButton jcomp2;
    private JButton jcomp3;
    private JTextField jcomp4;
    private JPanel panel;

    public MyPanel2(JPanel panel) {
        //construct components
	this.panel = panel;
        jcomp1 = new JButton ("test1");
        jcomp2 = new JButton ("test2");
        jcomp3 = new JButton ("test3");
        jcomp4 = new JTextField (5);

        //adjust size and set layout
        setPreferredSize (new Dimension (395, 156));
        setLayout (null);

        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds (20, 45, 100, 25);
        jcomp2.setBounds (135, 60, 100, 25);
        jcomp3.setBounds (260, 35, 100, 25);
        jcomp4.setBounds (105, 115, 100, 25);

	jcomp4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			CardLayout layout = (CardLayout) panel.getLayout();
			layout.next(panel);
		}
	});

        //add components
        add (jcomp1);
        add (jcomp2);
        add (jcomp3);
        add (jcomp4);       
    }
}