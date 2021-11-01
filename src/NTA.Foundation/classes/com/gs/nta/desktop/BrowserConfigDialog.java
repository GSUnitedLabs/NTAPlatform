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
 *  Class      :   BrowserConfigDialog.java
 *  Author     :   Sean Carrick
 *  Created    :   Oct 31, 2021 @ 4:04:47 PM
 *  Modified   :   Oct 31, 2021
 * 
 *  Purpose:     See class JavaDoc comment.
 * 
 *  Revision History:
 * 
 *  WHEN          BY                   REASON
 *  ------------  -------------------  -----------------------------------------
 *  Oct 31, 2021  Sean Carrick         Initial creation.
 * *****************************************************************************
 */
package com.gs.nta.desktop;

import com.gs.api.GSLogRecord;
import com.gs.api.GSLogger;
import com.gs.nta.NTApp;
import com.gs.utils.MessageBox;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.ServiceLoader;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileFilter;
import org.jdesktop.application.Action;
import org.jdesktop.application.Application;

/**
 *
 * @author Sean Carrick
 */
public class BrowserConfigDialog extends javax.swing.JDialog 
        implements DocumentListener, ListDataListener, ListSelectionListener {
    
    private final NTApp app;
    private final GSLogger logger;
    private final GSLogRecord record;
    private boolean isLoading;

    /**
     * Creates new form BrowserConfigDialog
     */
    public BrowserConfigDialog(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        
        app = (NTApp) Application.getInstance();
        
        ServiceLoader<GSLogger> logLoader = ServiceLoader.load(GSLogger.class);
        logger = logLoader.iterator().next();
        logger.setClassName(getClass().getCanonicalName());
        logger.updateLogName();
        ServiceLoader<GSLogRecord> loader = ServiceLoader.load(GSLogRecord.class);
        record = loader.iterator().next();
        record.setSourceClassName(logger.getClassName());
        
        initComponents();
        
        hintsField.setText("{URL} = URL of the page to be loaded by the web "
                + "browser");
        hintsField.select(0, 0);
        
        isLoading = true;
        loadList();
        isLoading = false;
    }
    
    private void loadList() {
        DefaultListModel<String> model = new DefaultListModel();
        model.addListDataListener(this);
        webBrowsersList.addListSelectionListener(this);
        
        String configPath = app.getContext().getLocalStorage().getDirectory().getAbsolutePath();
        if (!configPath.endsWith(File.separator)) {
            configPath += File.separator;
        }
        configPath += "etc" + File.separator + "installed.brwsrs";
        File installedBrowsers = new File(configPath);
        
        String defaultBrowser = null;
        
        if (!installedBrowsers.exists()) {
            // Add the option for the system default browser.
            model.add(model.getSize(), "<System Default Browser>");

            // Add Firefox, Chrome, and Mozilla (standard web browsers on most systems.
            model.add(model.getSize(), "Firefox");
            model.add(model.getSize(), "Chrome");
            model.add(model.getSize(), "Mozilla");

            // If running on windows, add Internet Explorer and Microsoft Edge.
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                model.add(model.getSize(), "Internet Explorer");
                model.add(model.getSize(), "Microsoft Edge");
            }

            // If running on Mac OS X, add Opera.
            if (System.getProperty("os.name").toLowerCase().contains("mac os x")) {
                model.add(model.getSize(), "Opera");
            }
        } else {
            model.add(model.getSize(), "<System Default Browser>");
            try (BufferedReader in = new BufferedReader(new FileReader(installedBrowsers))) {
                String line;
                while ((line = in.readLine()) != null) {
                    model.add(model.getSize(), line);
                }
                
                defaultBrowser = (app.getProperties().getPropertyAsString(
                    "default.browser") == null) ? null :
                    app.getProperties().getPropertyAsString("default.browser");
            } catch (IOException ex) {
                record.setInstant(Instant.now());
                record.setMessage("Attempting to read in installed browsers file.");
                record.setParameters(null);
                record.setSourceMethodName("loadBrowserList");
                record.setThread(Thread.currentThread());
                record.setThrown(ex);
                logger.error(record);
                MessageBox.showError(ex, "I/O Error");
            }
        }
        
        webBrowsersList.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        browsersPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        webBrowsersList = new javax.swing.JList<>();
        removeButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        argumentsLabel = new javax.swing.JLabel();
        executableLabel = new javax.swing.JLabel();
        executableField = new javax.swing.JTextField();
        argumentsField = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        argumentsHintPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        hintsField = new javax.swing.JTextArea();
        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        helpButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(BrowserConfigDialog.class);
        setTitle(resourceMap.getString("title")); // NOI18N
        setResizable(false);

        browsersPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("browsersPanel.border.title"))); // NOI18N
        browsersPanel.setName("browsersPanel"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        webBrowsersList.setName("webBrowsersList"); // NOI18N
        jScrollPane1.setViewportView(webBrowsersList);

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance().getContext().getActionMap(BrowserConfigDialog.class, this);
        removeButton.setAction(actionMap.get("remove")); // NOI18N
        removeButton.setName("removeButton"); // NOI18N

        addButton.setAction(actionMap.get("addBrowser")); // NOI18N
        addButton.setName("addButton"); // NOI18N

        javax.swing.GroupLayout browsersPanelLayout = new javax.swing.GroupLayout(browsersPanel);
        browsersPanel.setLayout(browsersPanelLayout);
        browsersPanelLayout.setHorizontalGroup(
            browsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(browsersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(browsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, browsersPanelLayout.createSequentialGroup()
                        .addGap(0, 15, Short.MAX_VALUE)
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeButton)))
                .addContainerGap())
        );
        browsersPanelLayout.setVerticalGroup(
            browsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(browsersPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(browsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeButton)
                    .addComponent(addButton))
                .addContainerGap())
        );

        nameLabel.setText(resourceMap.getString("nameLabel.text")); // NOI18N
        nameLabel.setName("nameLabel"); // NOI18N

        nameField.setEditable(false);
        nameField.setName("nameField"); // NOI18N

        argumentsLabel.setText(resourceMap.getString("argumentsLabel.text")); // NOI18N
        argumentsLabel.setName("argumentsLabel"); // NOI18N

        executableLabel.setText(resourceMap.getString("executableLabel.text")); // NOI18N
        executableLabel.setName("executableLabel"); // NOI18N

        executableField.setName("executableField"); // NOI18N
        executableField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldFocused(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textFieldUnfocused(evt);
            }
        });

        argumentsField.setName("argumentsField"); // NOI18N
        argumentsField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldFocused(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textFieldUnfocused(evt);
            }
        });

        browseButton.setAction(actionMap.get("browse")); // NOI18N
        browseButton.setName("browseButton"); // NOI18N

        argumentsHintPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("argumentsHintPanel.border.title"))); // NOI18N
        argumentsHintPanel.setName("argumentsHintPanel"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        hintsField.setEditable(false);
        hintsField.setColumns(20);
        hintsField.setLineWrap(true);
        hintsField.setRows(5);
        hintsField.setWrapStyleWord(true);
        hintsField.setName("hintsField"); // NOI18N
        jScrollPane2.setViewportView(hintsField);

        javax.swing.GroupLayout argumentsHintPanelLayout = new javax.swing.GroupLayout(argumentsHintPanel);
        argumentsHintPanel.setLayout(argumentsHintPanelLayout);
        argumentsHintPanelLayout.setHorizontalGroup(
            argumentsHintPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(argumentsHintPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addContainerGap())
        );
        argumentsHintPanelLayout.setVerticalGroup(
            argumentsHintPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        cancelButton.setAction(actionMap.get("cancel")); // NOI18N
        cancelButton.setName("cancelButton"); // NOI18N

        okButton.setAction(actionMap.get("saveChanges")); // NOI18N
        okButton.setName("okButton"); // NOI18N

        helpButton.setAction(actionMap.get("showHelp")); // NOI18N
        helpButton.setName("helpButton"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(browsersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(argumentsLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(executableLabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(executableField)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(browseButton))
                            .addComponent(argumentsField)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameField))
                    .addComponent(argumentsHintPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(helpButton)
                        .addGap(18, 18, 18)
                        .addComponent(okButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(browsersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameLabel)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(browseButton)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(executableLabel)
                                .addComponent(executableField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(argumentsLabel)
                            .addComponent(argumentsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(argumentsHintPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelButton)
                            .addComponent(okButton)
                            .addComponent(helpButton))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldFocused(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldFocused
        if (evt.getSource() instanceof javax.swing.JTextField) {
            ((javax.swing.JTextField) evt.getSource()).selectAll();
        }
    }//GEN-LAST:event_textFieldFocused

    private void textFieldUnfocused(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldUnfocused
        if (evt.getSource() instanceof javax.swing.JTextField) {
            ((javax.swing.JTextField) evt.getSource()).select(0, 0);
        }
    }//GEN-LAST:event_textFieldUnfocused

    @Action(enabledProperty = "selectionAvailable")
    public void remove() {
        DefaultListModel<String> model = (DefaultListModel) webBrowsersList.getModel();
        String selectedItem = webBrowsersList.getSelectedValue();
        model.removeElement(selectedItem);
        webBrowsersList.setModel(model);
    }

    private boolean selectionAvailable = false;
    public boolean isSelectionAvailable() {
        return selectionAvailable;
    }

    public void setSelectionAvailable(boolean b) {
        boolean old = isSelectionAvailable();
        this.selectionAvailable = b;
        firePropertyChange("selectionAvailable", old, isSelectionAvailable());
    }

    @Action
    public void addBrowser() {
        String newBrowser = MessageBox.getInput("Enter new browser name:",
                "Add Web Browser");
        ((DefaultListModel) webBrowsersList.getModel()).add(
                ((DefaultListModel) webBrowsersList.getModel()).size(),
                newBrowser);
    }

    @Action
    public void browse() {
        /* We are going to show a JFileChooser to allow the user to locate the
         * browser executable file. JFileChooser, as far as I know, does not 
         * provide a manner by which the file bits can be determined. So the
         * only operating system on which we can set the file filter for 
         * executable files only is on Windows. Linux and Mac OS X user bits to
         * set a file as executable, so we will have to allow all files on those
         * two operating systems. Hence the if...else block in this method.
         */
        FileFilter winExe = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname != null) {
                    if (!pathname.isDirectory()) {
                        if (pathname.getName().endsWith("exe")) {
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        return true;
                    }
                } else {
                    return false;
                }
            }

            @Override
            public String getDescription() {
                return "Executable files (*.exe)";
            }
        };
        
        JFileChooser chooser = new JFileChooser();
        
        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            chooser.setFileFilter(winExe);
            chooser.setCurrentDirectory(new File("C:\\Program Files\\"));
        } else if (System.getProperty("os.name").toLowerCase().contains("mac os x")) {
            chooser.setCurrentDirectory(new File("/Applications/"));
        } else {
            chooser.setCurrentDirectory(new File("/usr/bin/"));
        }
        
        int selectedFile = chooser.showOpenDialog(this);
        
        if (selectedFile == JFileChooser.APPROVE_OPTION) {
            executableField.setText(chooser.getSelectedFile().getAbsolutePath());
            argumentsField.requestFocusInWindow();
        }
    }

    @Action
    public void showHelp() {
    }

    @Action(enabledProperty = "saveNeeded")
    public void saveChanges() {
        String dataFilePath = app.getContext().getLocalStorage().getDirectory().getAbsolutePath();
        if (!dataFilePath.endsWith(File.separator)) {
            dataFilePath += File.separator;
        }
        String browserName = nameField.getText();
        if ("<System Default Browser>".equals(browserName)) {
            browserName = "default";
        }
        dataFilePath += "etc" + File.separator + browserName + ".brwsrd";
        File dataFile = new File(dataFilePath);
        
        try (BufferedWriter out = new BufferedWriter(new FileWriter(dataFile))) {
                out.write(executableField.getText() + "\n");
                out.write(argumentsField.getText());
                out.flush();
        } catch (IOException ex) {
                record.setInstant(Instant.now());
                record.setMessage("Attempting to write out installed browsers file.");
                record.setParameters(null);
                record.setSourceMethodName("saveSettings");
                record.setThread(Thread.currentThread());
                record.setThrown(ex);
                logger.error(record);
                MessageBox.showError(ex, "I/O Error");
        } finally {
            setSaveNeeded(false);
            executableField.requestFocusInWindow();
        }
    }

    private boolean saveNeeded = false;
    public boolean isSaveNeeded() {
        return saveNeeded;
    }

    public void setSaveNeeded(boolean b) {
        if (!isLoading) {
            boolean old = isSaveNeeded();
            this.saveNeeded = b;
            firePropertyChange("saveNeeded", old, isSaveNeeded());
        }
    }

    @Action
    public void cancel() {
        if (!isSaveNeeded()) {
            dispose();
        } else {
            String msg = "Changes have been made and not saved.\n\nDo you wish "
                    + "to cancel anyway?";
            int answer = MessageBox.askQuestion(msg, "Unsaved Changes", false);
            
            if (answer == MessageBox.YES_OPTION) {
                dispose();
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextField argumentsField;
    private javax.swing.JPanel argumentsHintPanel;
    private javax.swing.JLabel argumentsLabel;
    private javax.swing.JButton browseButton;
    private javax.swing.JPanel browsersPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField executableField;
    private javax.swing.JLabel executableLabel;
    private javax.swing.JButton helpButton;
    private javax.swing.JTextArea hintsField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton okButton;
    private javax.swing.JButton removeButton;
    private javax.swing.JList<String> webBrowsersList;
    // End of variables declaration//GEN-END:variables

    @Override
    public void insertUpdate(DocumentEvent e) {
        setSaveNeeded(true);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        setSaveNeeded(true);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        setSaveNeeded(true);
    }

    @Override
    public void intervalAdded(ListDataEvent e) {
        setSaveNeeded(true);
    }

    @Override
    public void intervalRemoved(ListDataEvent e) {
        setSaveNeeded(true);
        setSelectionAvailable(false);
    }

    @Override
    public void contentsChanged(ListDataEvent e) {
        setSaveNeeded(true);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getFirstIndex() == -1) {
            setSelectionAvailable(false);
        } else {
            setSelectionAvailable(true);
            String selectedItem = 
                    ((DefaultListModel) webBrowsersList.getModel())
                            .get(e.getFirstIndex()).toString();
            nameField.setText(selectedItem);
            
            if ("<System Default Browser>".equals(selectedItem)) {
                selectedItem = "default";
                nameField.setText("<System Default Browser>");
            }
            loadBrowserData(selectedItem);
        }
        
        if (!isSelectionAvailable()) {
            nameField.setText("");
        }
    }
    
    private void loadBrowserData(String item) {
        String dataFilePath = app.getContext().getLocalStorage().getDirectory().getAbsolutePath();
        if (!dataFilePath.endsWith(File.separator)) {
            dataFilePath += File.separator;
        }
        dataFilePath += "etc" + File.separator + item + ".brwsrd";
        File dataFile = new File(dataFilePath);
        
        isLoading = true;
        
        if (dataFile.exists()) {
            String[] data = new String[2];

            try (BufferedReader in = new BufferedReader(new FileReader(dataFile))) {
                if (in != null) {
                    for (int x = 0; x < 2; x++) {
                        data[x] = in.readLine();
                    }

                    if (data[0] == null || data[1].isBlank() || data[1].isEmpty()) {
                        executableField.setText("");
                    } else {
                        executableField.setText(data[0]);
                    }
                    if (data[1] == null || data[1].isBlank() || data[1].isEmpty()) {
                        if (executableField.getText().isBlank() 
                                || executableField.getText().isEmpty()) {
                            argumentsField.setText("");
                        } else {
                            executableField.setText("{URL}");
                        }
                    } else {
                        argumentsField.setText(data[1]);
                    }
                }
            } catch (IOException ex) {
                    record.setInstant(Instant.now());
                    record.setMessage("Attempting to read in browser config file.");
                    record.setParameters(null);
                    record.setSourceMethodName("saveSettings");
                    record.setThread(Thread.currentThread());
                    record.setThrown(ex);
                    logger.error(record);
            }
        } else {
            executableField.setText("");
            argumentsField.setText("");
        }
        isLoading = false;
    }

}
