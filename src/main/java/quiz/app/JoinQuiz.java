/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

package quiz.app;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 *
 * @author user
 */
public class JoinQuiz extends javax.swing.JPanel {

	/**
	 * Creates new form AddQuestion
	 */
	public JoinQuiz() {
		initComponents();
		
	}

	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                javax.swing.JPanel main_panel = new javax.swing.JPanel();
                javax.swing.JPanel organisation_panel = new javax.swing.JPanel();
                javax.swing.JLabel organisation_label = new javax.swing.JLabel();
                javax.swing.JLabel title_label = new javax.swing.JLabel();
                javax.swing.JLabel email_label = new javax.swing.JLabel();
                javax.swing.JTextField name_field = new javax.swing.JTextField();
                javax.swing.JLabel name_label1 = new javax.swing.JLabel();
                javax.swing.JTextField email_field = new javax.swing.JTextField();
                javax.swing.JButton join_button = new javax.swing.JButton();

                setLayout(new java.awt.CardLayout());
                setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));

                main_panel.setBackground(new java.awt.Color(255, 255, 255));
                main_panel.setPreferredSize(new Dimension(901, 601));
                main_panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
//                main_panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

                organisation_panel.setBackground(new java.awt.Color(255, 255, 255));
                organisation_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
                organisation_panel.setPreferredSize(new Dimension(801, 201));

                organisation_label.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
                organisation_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                organisation_label.setText("Organisation Name");

                title_label.setBackground(new java.awt.Color(255, 255, 255));
                title_label.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
                title_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                title_label.setText("Title");

                javax.swing.GroupLayout organisation_panelLayout = new javax.swing.GroupLayout(organisation_panel);
                organisation_panel.setLayout(organisation_panelLayout);
                organisation_panelLayout.setHorizontalGroup(
                        organisation_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, organisation_panelLayout.createSequentialGroup()
                                .addContainerGap(24, Short.MAX_VALUE)
                                .addGroup(organisation_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(title_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(organisation_label, javax.swing.GroupLayout.DEFAULT_SIZE, 839, Short.MAX_VALUE))
                                .addGap(39, 39, 39))
                );
                organisation_panelLayout.setVerticalGroup(
                        organisation_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(organisation_panelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(organisation_label, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(title_label, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14))
                );

                email_label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
                email_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                email_label.setText("E-Mail");

                name_label1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
                name_label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                name_label1.setText("Name");

                join_button.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
                join_button.setText("Join Quiz");

                javax.swing.GroupLayout main_panelLayout = new javax.swing.GroupLayout(main_panel);
                main_panel.setLayout(main_panelLayout);
                main_panelLayout.setHorizontalGroup(
                        main_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(main_panelLayout.createSequentialGroup()
                                .addGap(233, 233, 233)
                                .addGroup(main_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(main_panelLayout.createSequentialGroup()
                                                .addComponent(email_label, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(email_field))
                                        .addGroup(main_panelLayout.createSequentialGroup()
                                                .addComponent(name_label1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(name_field, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(137, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, main_panelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(join_button, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(378, 378, 378))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, main_panelLayout.createSequentialGroup()
                                .addContainerGap(21, Short.MAX_VALUE)
                                .addComponent(organisation_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21))
                );
                main_panelLayout.setVerticalGroup(
                        main_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(main_panelLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(organisation_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85)
                                .addGroup(main_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(name_label1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(name_field, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 17, Short.MAX_VALUE)
                                .addGroup(main_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(email_label, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(email_field, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(89, 89, 89)
                                .addComponent(join_button, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54))
                );

                add(main_panel, "card2");
        }// </editor-fold>//GEN-END:initComponents


        // Variables declaration - do not modify//GEN-BEGIN:variables
        // End of variables declaration//GEN-END:variables
}
