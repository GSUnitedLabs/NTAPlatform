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
 *  Class      :   BugReportDialog.java
 *  Author     :   Sean Carrick
 *  Created    :   Oct 30, 2021 @ 7:24:49 PM
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

import com.gs.utils.ScreenUtils;
import org.jdesktop.application.Action;
import org.jdesktop.application.Application;

/**
 *
 * @author Sean Carrick
 */
public class BugReportDialog extends javax.swing.JDialog {


    /**
     * Creates new form BugReportDialog
     * 
     * @param reporter
     */
    public BugReportDialog(BugReporter reporter) {
        initComponents();
        
        loadFields(reporter);
    }
    
    private void loadFields(BugReporter reporter) {
        setModal(true);
        
        exceptionField.setText(reporter.getLogRecord().getThrown().getClass().getCanonicalName());
        messageField.setText(reporter.getLogRecord().getThrown().getLocalizedMessage());
        instantField.setText(reporter.getLogRecord().getInstant().toString());
        threadIdField.setText(String.valueOf(reporter.getLogRecord().getThread().getId()));
        threadNameField.setText(reporter.getLogRecord().getThread().getName());
        threadPriorityField.setText(String.valueOf(reporter.getLogRecord().getThread().getPriority()));
        threadStateField.setText(reporter.getLogRecord().getThread().getState().toString());
        classNameField.setText(reporter.getLogRecord().getSourceClassName());
        methodNameField.setText(reporter.getLogRecord().getSourceMethodName());
        sequenceField.setText(String.valueOf(reporter.getLogRecord().getSequenceNumber()));
        if (reporter.getLogRecord().getParameters() != null) {
            for (Object o : reporter.getLogRecord().getParameters()) {
                parametersField.append(o.toString() + "\n");
            }
        }
        logNameField.setText(reporter.getLogFileName());
        errLogNameField.setText(reporter.getErrFileName());
        
        for (StackTraceElement e : reporter.getLogRecord().getThrown().getStackTrace()) {
            stackTraceField.append(e.toString() + "\n");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exceptionLabel = new javax.swing.JLabel();
        exceptionField = new javax.swing.JTextField();
        messageLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        messageField = new javax.swing.JTextArea();
        instantLabel = new javax.swing.JLabel();
        instantField = new javax.swing.JTextField();
        threadIdLabel = new javax.swing.JLabel();
        threadIdField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        parametersField = new javax.swing.JTextArea();
        parametersLabel = new javax.swing.JLabel();
        classNameLabel = new javax.swing.JLabel();
        classNameField = new javax.swing.JTextField();
        methodNameLabel = new javax.swing.JLabel();
        methodNameField = new javax.swing.JTextField();
        sequenceLabel = new javax.swing.JLabel();
        sequenceField = new javax.swing.JTextField();
        logNameLabel = new javax.swing.JLabel();
        logNameField = new javax.swing.JTextField();
        errLogNameLabel = new javax.swing.JLabel();
        errLogNameField = new javax.swing.JTextField();
        commandPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        submitButton = new javax.swing.JButton();
        stackTracePanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        stackTraceField = new javax.swing.JTextArea();
        authorizeSystemInfoCheckbox = new javax.swing.JCheckBox();
        threadNameLabel = new javax.swing.JLabel();
        threadNameField = new javax.swing.JTextField();
        threadPriorityLabel = new javax.swing.JLabel();
        threadPriorityField = new javax.swing.JTextField();
        threadStateLabel = new javax.swing.JLabel();
        threadStateField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(BugReportDialog.class);
        exceptionLabel.setText(resourceMap.getString("exceptionLabel.text")); // NOI18N
        exceptionLabel.setName("exceptionLabel"); // NOI18N

        exceptionField.setEditable(false);
        exceptionField.setName("exceptionField"); // NOI18N

        messageLabel.setText(resourceMap.getString("messageLabel.text")); // NOI18N
        messageLabel.setName("messageLabel"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        messageField.setEditable(false);
        messageField.setColumns(20);
        messageField.setLineWrap(true);
        messageField.setRows(3);
        messageField.setWrapStyleWord(true);
        messageField.setName("messageField"); // NOI18N
        jScrollPane1.setViewportView(messageField);

        instantLabel.setText(resourceMap.getString("instantLabel.text")); // NOI18N
        instantLabel.setName("instantLabel"); // NOI18N

        instantField.setEditable(false);
        instantField.setName("instantField"); // NOI18N

        threadIdLabel.setText(resourceMap.getString("threadIdLabel.text")); // NOI18N
        threadIdLabel.setName("threadIdLabel"); // NOI18N

        threadIdField.setEditable(false);
        threadIdField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        threadIdField.setName("threadIdField"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        parametersField.setEditable(false);
        parametersField.setColumns(20);
        parametersField.setRows(5);
        parametersField.setName("parametersField"); // NOI18N
        jScrollPane2.setViewportView(parametersField);

        parametersLabel.setText(resourceMap.getString("parametersLabel.text")); // NOI18N
        parametersLabel.setName("parametersLabel"); // NOI18N

        classNameLabel.setText(resourceMap.getString("classNameLabel.text")); // NOI18N
        classNameLabel.setName("classNameLabel"); // NOI18N

        classNameField.setEditable(false);
        classNameField.setName("classNameField"); // NOI18N

        methodNameLabel.setText(resourceMap.getString("methodNameLabel.text")); // NOI18N
        methodNameLabel.setName("methodNameLabel"); // NOI18N

        methodNameField.setEditable(false);
        methodNameField.setName("methodNameField"); // NOI18N

        sequenceLabel.setText("Sequence #:"); // NOI18N
        sequenceLabel.setName("sequenceLabel"); // NOI18N

        sequenceField.setEditable(false);
        sequenceField.setName("sequenceField"); // NOI18N

        logNameLabel.setText(resourceMap.getString("logNameLabel.text")); // NOI18N
        logNameLabel.setName("logNameLabel"); // NOI18N

        logNameField.setEditable(false);
        logNameField.setName("logNameField"); // NOI18N

        errLogNameLabel.setText(resourceMap.getString("errLogNameLabel.text")); // NOI18N
        errLogNameLabel.setName("errLogNameLabel"); // NOI18N

        errLogNameField.setEditable(false);
        errLogNameField.setName("errLogNameField"); // NOI18N

        commandPanel.setName("commandPanel"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance().getContext().getActionMap(BugReportDialog.class, this);
        jButton1.setAction(actionMap.get("showHelp")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        cancelButton.setAction(actionMap.get("cancel")); // NOI18N
        cancelButton.setMnemonic('C');
        cancelButton.setName("cancelButton"); // NOI18N

        submitButton.setAction(actionMap.get("submitBugReport")); // NOI18N
        submitButton.setName("submitButton"); // NOI18N

        javax.swing.GroupLayout commandPanelLayout = new javax.swing.GroupLayout(commandPanel);
        commandPanel.setLayout(commandPanelLayout);
        commandPanelLayout.setHorizontalGroup(
            commandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(commandPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(submitButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton)
                .addContainerGap())
        );
        commandPanelLayout.setVerticalGroup(
            commandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, commandPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(commandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(cancelButton)
                    .addComponent(submitButton))
                .addContainerGap())
        );

        stackTracePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("stackTracePanel.border.title"))); // NOI18N
        stackTracePanel.setName("stackTracePanel"); // NOI18N

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        stackTraceField.setEditable(false);
        stackTraceField.setColumns(20);
        stackTraceField.setRows(5);
        stackTraceField.setName("stackTraceField"); // NOI18N
        jScrollPane3.setViewportView(stackTraceField);

        javax.swing.GroupLayout stackTracePanelLayout = new javax.swing.GroupLayout(stackTracePanel);
        stackTracePanel.setLayout(stackTracePanelLayout);
        stackTracePanelLayout.setHorizontalGroup(
            stackTracePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
        );
        stackTracePanelLayout.setVerticalGroup(
            stackTracePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
        );

        authorizeSystemInfoCheckbox.setSelected(true);
        authorizeSystemInfoCheckbox.setText(resourceMap.getString("authorizeSystemInfoCheckbox.text")); // NOI18N
        authorizeSystemInfoCheckbox.setName("authorizeSystemInfoCheckbox"); // NOI18N

        threadNameLabel.setText(resourceMap.getString("threadNameLabel.text")); // NOI18N
        threadNameLabel.setName("threadNameLabel"); // NOI18N

        threadNameField.setEditable(false);
        threadNameField.setName("threadNameField"); // NOI18N

        threadPriorityLabel.setText(resourceMap.getString("threadPriorityLabel.text")); // NOI18N
        threadPriorityLabel.setName("threadPriorityLabel"); // NOI18N

        threadPriorityField.setEditable(false);
        threadPriorityField.setName("threadPriorityField"); // NOI18N

        threadStateLabel.setText(resourceMap.getString("threadStateLabel.text")); // NOI18N
        threadStateLabel.setName("threadStateLabel"); // NOI18N

        threadStateField.setEditable(false);
        threadStateField.setName("threadStateField"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(commandPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(stackTracePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(authorizeSystemInfoCheckbox)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(11, 11, 11)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(logNameLabel)
                                .addComponent(parametersLabel)
                                .addComponent(errLogNameLabel))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2)
                                .addComponent(logNameField)
                                .addComponent(errLogNameField)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(methodNameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(methodNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sequenceLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sequenceField, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(instantLabel)
                                        .addComponent(messageLabel)
                                        .addComponent(exceptionLabel)
                                        .addComponent(threadNameLabel)
                                        .addComponent(threadStateLabel))
                                    .addComponent(classNameLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(threadStateField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(exceptionField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(instantField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(threadIdLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(threadIdField, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(threadNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(threadPriorityLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(threadPriorityField))
                                    .addComponent(classNameField))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exceptionLabel)
                    .addComponent(exceptionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(messageLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(instantLabel)
                    .addComponent(instantField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(threadIdLabel)
                    .addComponent(threadIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(threadNameLabel)
                    .addComponent(threadNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(threadPriorityLabel)
                    .addComponent(threadPriorityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(threadStateLabel)
                    .addComponent(threadStateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classNameLabel)
                    .addComponent(classNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(methodNameLabel)
                    .addComponent(methodNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sequenceLabel)
                    .addComponent(sequenceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(parametersLabel))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logNameLabel)
                    .addComponent(logNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(errLogNameLabel)
                    .addComponent(errLogNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(stackTracePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(authorizeSystemInfoCheckbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(commandPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Action
    public void cancel() {
        dispose();
    }

    @Action
    public void submitBugReport() {
        DetailsDialog dlg = new DetailsDialog(this, true);
        dlg.pack();
        dlg.setLocation(ScreenUtils.getCenterPoint(null, getSize()));
        dlg.setVisible(true);
    }

    @Action
    public void showHelp() {
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox authorizeSystemInfoCheckbox;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField classNameField;
    private javax.swing.JLabel classNameLabel;
    private javax.swing.JPanel commandPanel;
    private javax.swing.JTextField errLogNameField;
    private javax.swing.JLabel errLogNameLabel;
    private javax.swing.JTextField exceptionField;
    private javax.swing.JLabel exceptionLabel;
    private javax.swing.JTextField instantField;
    private javax.swing.JLabel instantLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField logNameField;
    private javax.swing.JLabel logNameLabel;
    private javax.swing.JTextArea messageField;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JTextField methodNameField;
    private javax.swing.JLabel methodNameLabel;
    private javax.swing.JTextArea parametersField;
    private javax.swing.JLabel parametersLabel;
    private javax.swing.JTextField sequenceField;
    private javax.swing.JLabel sequenceLabel;
    private javax.swing.JTextArea stackTraceField;
    private javax.swing.JPanel stackTracePanel;
    private javax.swing.JButton submitButton;
    private javax.swing.JTextField threadIdField;
    private javax.swing.JLabel threadIdLabel;
    private javax.swing.JTextField threadNameField;
    private javax.swing.JLabel threadNameLabel;
    private javax.swing.JTextField threadPriorityField;
    private javax.swing.JLabel threadPriorityLabel;
    private javax.swing.JTextField threadStateField;
    private javax.swing.JLabel threadStateLabel;
    // End of variables declaration//GEN-END:variables
}