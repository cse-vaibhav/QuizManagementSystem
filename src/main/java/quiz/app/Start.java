/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

package quiz.app;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.concurrent.ExecutionException;
import javax.swing.*;

/**
 *
 * @author user
 */
public class Start extends javax.swing.JPanel {

        private JButton createQuizButton;
        private JButton joinQuizButton;

        private JTextField quiz_code_field;
        private JTextField nameField;
        private JTextField emailField;
        private JTextField organisationField;

	/**
	 * Creates new form Start
	 */
	public Start() throws ClassNotFoundException, Exception {
		initComponents();

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                Utils.url,
                Utils.user,
                Utils.password
        );
        connection.setAutoCommit(false);

        createQuizButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String code = Utils.genCode(6);
                String[] name = nameField.getText().split(" ", 2);
                String email = emailField.getText();
                String organisation = organisationField.getText();
                if (name.length == 0 || email.length() == 0 || organisation.length() == 0) {
                    Utils.PopUp("Invalid Data Entered.");
                    return;
                }

                String fname = name[0];
                String lname = (name.length > 1) ? name[1] : "";
                try {
                    Statement st = connection.createStatement();
                    String query;

                    // check if user exists
                    query = String.format("SELECT COUNT(ID) " +
                            "FROM QuizManagementSystem.Users " +
                            "WHERE EMAIL='%s'", email);

                    ResultSet rs = st.executeQuery(query);
                    rs.next();
                    int cnt = rs.getInt(1);

                    // add if not exists
                    if (cnt == 0) {
                        query = String.format("INSERT INTO QuizManagementSystem.Users " +
                                "(Organisation, isActive, Email, FName, LName) VALUES " +
                                "('%s', true, '%s', '%s', '%s')", organisation, email, fname, lname);
                        st.execute(query);
                    }

                    // get id of this user
                    query = String.format("SELECT ID FROM QuizManagementSystem.Users WHERE Email='%s'", email);
                    rs = st.executeQuery(query);
                    rs.next();
                    int id = rs.getInt(1);

                    // add quiz code
                    query = String.format("INSERT INTO QuizManagementSystem.Codes (ID, Code, createdBy) " +
                            "VALUES(NULL, '%s', %d)", code, id);
                    st.execute(query);
                    connection.commit();
                    st.close();

                    System.out.println("Code: " + code);
                    Utils.PopUp(String.format("Your code is %s", code));
                    Utils.changePane(new AddQuestion(code));

                } catch (Exception e) {
                    System.out.println(e);
                    try {
                        connection.rollback();
                    } catch(Exception e1) {
                        System.out.println(e1);
                    }
                }

            }
        });

        joinQuizButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String code = quiz_code_field.getText();
                try {
                    Statement st = connection.createStatement();
                    ResultSet rs = st.executeQuery(String.format("SELECT COUNT(Code) FROM QuizManagementSystem.Codes WHERE Code = '%s'", code));
                    rs.next();
                    int n = rs.getInt(1);
                    System.out.println(n);
                    if (n == 0) throw new Exception();

                    Utils.changePane(new JoinQuiz());

                } catch(Exception e) {
                    Utils.PopUp("Invalid Quiz Code");
                    System.out.println("Invalid Quiz Code");
                }

            }
        });
	}

	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

            this.nameField = new JTextField();
            this.emailField = new JTextField();
            this.quiz_code_field = new JTextField();
            this.organisationField = new JTextField();
            this.joinQuizButton = new javax.swing.JButton();
            this.createQuizButton = new javax.swing.JButton();

                javax.swing.JPanel start = new javax.swing.JPanel();
                java.awt.Label main_title = new java.awt.Label();
                javax.swing.JPanel main_panel = new javax.swing.JPanel();
                javax.swing.JPanel create_quiz_panel = new javax.swing.JPanel();
                javax.swing.JLabel Email_label = new javax.swing.JLabel();
                javax.swing.JLabel Name_label2 = new javax.swing.JLabel();
                javax.swing.JLabel organisation_label = new javax.swing.JLabel();
                java.awt.Label or = new java.awt.Label();
                javax.swing.JPanel join_quiz_panel = new javax.swing.JPanel();
                javax.swing.JLabel quiz_code_label = new javax.swing.JLabel();

                setLayout(new java.awt.CardLayout(1, 1));

                start.setBackground(new java.awt.Color(255, 255, 255));
                start.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
                start.setName("home"); // NOI18N

                main_title.setAlignment(java.awt.Label.CENTER);
                main_title.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
                main_title.setName("main_title"); // NOI18N
                main_title.setText("Quiz");

                main_panel.setBackground(new java.awt.Color(255, 255, 255));
                main_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
                main_panel.setPreferredSize(new java.awt.Dimension(828, 510));

                create_quiz_panel.setBackground(new java.awt.Color(255, 255, 255));

                nameField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
                nameField.setName("Name"); // NOI18N

                emailField.setName("emailField"); // NOI18N

                organisationField.setName("organisationField"); // NOI18N

                Email_label.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                Email_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                Email_label.setText("Email");

                Name_label2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                Name_label2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                Name_label2.setText("Name");

                organisation_label.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                organisation_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                organisation_label.setText("Organisation");

                createQuizButton.setBackground(new java.awt.Color(102, 102, 102));
                createQuizButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
                createQuizButton.setForeground(new java.awt.Color(255, 255, 255));
                createQuizButton.setText("Create Quiz");

                javax.swing.GroupLayout create_quiz_panelLayout = new javax.swing.GroupLayout(create_quiz_panel);
                create_quiz_panel.setLayout(create_quiz_panelLayout);
                create_quiz_panelLayout.setHorizontalGroup(
                        create_quiz_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, create_quiz_panelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(create_quiz_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(Name_label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(organisation_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Email_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(27, 27, 27)
                                .addGroup(create_quiz_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(emailField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                        .addComponent(nameField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(organisationField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                        .addGroup(create_quiz_panelLayout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(createQuizButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(103, Short.MAX_VALUE))
                );
                create_quiz_panelLayout.setVerticalGroup(
                        create_quiz_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(create_quiz_panelLayout.createSequentialGroup()
                                .addGroup(create_quiz_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(create_quiz_panelLayout.createSequentialGroup()
                                                .addGap(58, 58, 58)
                                                .addComponent(Name_label2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                                        .addGroup(create_quiz_panelLayout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(create_quiz_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(Email_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(emailField, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(create_quiz_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(organisation_label, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                        .addComponent(organisationField, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                                .addGap(50, 50, 50)
                                .addComponent(createQuizButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48))
                );

                or.setAlignment(java.awt.Label.CENTER);
                or.setEnabled(false);
                or.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
                or.setName("or"); // NOI18N
                or.setText("OR");

                join_quiz_panel.setBackground(new java.awt.Color(255, 255, 255));
                join_quiz_panel.setName("join_quiz_panel"); // NOI18N

                quiz_code_field.setName("Quiz_code_field"); // NOI18N

                joinQuizButton.setBackground(new java.awt.Color(102, 102, 102));
                joinQuizButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
                joinQuizButton.setForeground(new java.awt.Color(255, 255, 255));
                joinQuizButton.setText("Join Quiz");

                quiz_code_label.setBackground(new java.awt.Color(255, 255, 255));
                quiz_code_label.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                quiz_code_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                quiz_code_label.setText("Quiz Code");

                javax.swing.GroupLayout join_quiz_panelLayout = new javax.swing.GroupLayout(join_quiz_panel);
                join_quiz_panel.setLayout(join_quiz_panelLayout);
                join_quiz_panelLayout.setHorizontalGroup(
                        join_quiz_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(join_quiz_panelLayout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(quiz_code_label, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, join_quiz_panelLayout.createSequentialGroup()
                                .addContainerGap(38, Short.MAX_VALUE)
                                .addGroup(join_quiz_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, join_quiz_panelLayout.createSequentialGroup()
                                                .addComponent(joinQuizButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(81, 81, 81))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, join_quiz_panelLayout.createSequentialGroup()
                                                .addComponent(quiz_code_field, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(37, 37, 37))))
                );
                join_quiz_panelLayout.setVerticalGroup(
                        join_quiz_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(join_quiz_panelLayout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(quiz_code_label, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(quiz_code_field, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                                .addComponent(joinQuizButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48))
                );

                javax.swing.GroupLayout main_panelLayout = new javax.swing.GroupLayout(main_panel);
                main_panel.setLayout(main_panelLayout);
                main_panelLayout.setHorizontalGroup(
                        main_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(main_panelLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(create_quiz_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(or, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(join_quiz_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(29, Short.MAX_VALUE))
                );
                main_panelLayout.setVerticalGroup(
                        main_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(main_panelLayout.createSequentialGroup()
                                .addGap(203, 203, 203)
                                .addComponent(or, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, main_panelLayout.createSequentialGroup()
                                .addGap(0, 103, Short.MAX_VALUE)
                                .addGroup(main_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(join_quiz_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(create_quiz_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(77, 77, 77))
                );

                javax.swing.GroupLayout startLayout = new javax.swing.GroupLayout(start);
                start.setLayout(startLayout);
                startLayout.setHorizontalGroup(
                        startLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, startLayout.createSequentialGroup()
                                .addContainerGap(209, Short.MAX_VALUE)
                                .addComponent(main_title, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(203, 203, 203))
                        .addGroup(startLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, startLayout.createSequentialGroup()
                                        .addContainerGap(34, Short.MAX_VALUE)
                                        .addComponent(main_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(35, Short.MAX_VALUE)))
                );
                startLayout.setVerticalGroup(
                        startLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(startLayout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(main_title, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(445, Short.MAX_VALUE))
                        .addGroup(startLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, startLayout.createSequentialGroup()
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(main_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                );

                add(start, "card2");
        }// </editor-fold>//GEN-END:initComponents

        // Variables declaration - do not modify//GEN-BEGIN:variables
        // End of variables declaration//GEN-END:variables
}
