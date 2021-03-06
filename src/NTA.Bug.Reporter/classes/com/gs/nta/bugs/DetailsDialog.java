/*
 * Copyright (C) 2021 GS United Labs
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * *****************************************************************************
 *  Project    :   NTA-Basic
 *  Class      :   DetailsDialog.java
 *  Author     :   Sean Carrick
 *  Created    :   Oct 30, 2021 @ 9:26:26 PM
 *  Modified   :   Oct 30, 2021
 * 
 *  Purpose:     See class JavaDoc comment.
 * 
 *  Revision History:
 * 
 *  WHEN          BY                   REASON
 *  ------------  -------------------  -----------------------------------------
 *  Oct 30, 2021  Sean Carrick         Initial creation.
 * *****************************************************************************
 */
package com.gs.nta.bugs;

import com.gs.utils.MessageBox;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.jdesktop.application.Action;

/**
 *
 * @author Sean Carrick
 */
public class DetailsDialog extends javax.swing.JDialog 
        implements PropertyChangeListener {

    
    /**
     * Creates new form DetailsDialog
     */
    public DetailsDialog(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        detailsField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                removeUpdate(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                submitReportButton.setEnabled(detailsField.getText().length() > 10);
            }
            
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        instructionsLabel = new javax.swing.JLabel();
        detailsPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        detailsField = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();
        submitReportButton = new javax.swing.JButton();
        helpButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(DetailsDialog.class);
        instructionsLabel.setBackground(resourceMap.getColor("instructionsLabel.background")); // NOI18N
        instructionsLabel.setText(resourceMap.getString("instructionsLabel.text")); // NOI18N
        instructionsLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        instructionsLabel.setName("instructionsLabel"); // NOI18N
        instructionsLabel.setOpaque(true);

        detailsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("detailsPanel.border.title"))); // NOI18N
        detailsPanel.setName("detailsPanel"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        detailsField.setColumns(20);
        detailsField.setRows(5);
        detailsField.setName("detailsField"); // NOI18N
        jScrollPane1.setViewportView(detailsField);

        javax.swing.GroupLayout detailsPanelLayout = new javax.swing.GroupLayout(detailsPanel);
        detailsPanel.setLayout(detailsPanelLayout);
        detailsPanelLayout.setHorizontalGroup(
            detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                .addContainerGap())
        );
        detailsPanelLayout.setVerticalGroup(
            detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setName("jPanel2"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance().getContext().getActionMap(DetailsDialog.class, this);
        cancelButton.setAction(actionMap.get("cancelReport")); // NOI18N
        cancelButton.setName("cancelButton"); // NOI18N

        submitReportButton.setAction(actionMap.get("submitCompleteReport")); // NOI18N
        submitReportButton.setName("submitReportButton"); // NOI18N

        helpButton.setAction(actionMap.get("showDetailsDialogHelp")); // NOI18N
        helpButton.setName("helpButton"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(helpButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 314, Short.MAX_VALUE)
                .addComponent(submitReportButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(submitReportButton)
                    .addComponent(helpButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(instructionsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(detailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(instructionsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Action
    public void showDetailsDialogHelp() {
    }

    @Action(enabledProperty = "detailsProvided")
    public void submitCompleteReport() {
    }

    private boolean detailsProvided = false;
    public boolean isDetailsProvided() {
        return detailsProvided;
    }

    public void setDetailsProvided(boolean b) {
        boolean old = isDetailsProvided();
        this.detailsProvided = b;
        firePropertyChange("detailsProvided", old, isDetailsProvided());
    }

    @Action
    public void cancelReport() {
        if (submitReportButton.isEnabled()) {
            String msg = "You have provided details and a lot of\n"
                    + "information has been gathered to\nreport this bug.\n\n"
                    + "Are you sure you do not want to send it?";
            int answer = MessageBox.askQuestion(msg, "Cancel Bug Report", false);
            if (answer == MessageBox.YES_OPTION) {
                dispose();
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextArea detailsField;
    private javax.swing.JPanel detailsPanel;
    private javax.swing.JButton helpButton;
    private javax.swing.JLabel instructionsLabel;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton submitReportButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }
}
