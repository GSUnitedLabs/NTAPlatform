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
 *  Class      :   ProxyOptionsPanel.java
 *  Author     :   Sean Carrick
 *  Created    :   Oct 28, 2021 @ 4:55:18 PM
 *  Modified   :   Oct 28, 2021
 * 
 *  Purpose:     See class JavaDoc comment.
 * 
 *  Revision History:
 * 
 *  WHEN          BY                   REASON
 *  ------------  -------------------  -----------------------------------------
 *  Oct 28, 2021  Sean Carrick         Initial creation.
 * *****************************************************************************
 */
package com.gs.nta.desktop.panels;

import com.gs.api.GSLogRecord;
import com.gs.api.GSLogger;
import com.gs.api.GSProperties;
import com.gs.nta.NTApp;
import com.gs.api.OptionsCategories;
import com.gs.api.OptionsPanelProvider;
import com.gs.nta.desktop.BrowserConfigDialog;
import com.gs.nta.properties.Properties;
import com.gs.utils.MessageBox;
import com.gs.utils.ScreenUtils;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.ServiceLoader;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.jdesktop.application.Action;
import org.jdesktop.application.Application;

/**
 *
 * @author Sean Carrick
 */
public class ProxyOptionsPanel extends javax.swing.JPanel 
        implements OptionsPanelProvider, DocumentListener {
    
    private static ProxyOptionsPanel panel;
    private static NTApp app;
    private static PropertyChangeSupport pcs;
    private GSLogRecord record;
    private GSLogger logger;

    /**
     * Creates new form ProxyOptionsPanel
     */
    public ProxyOptionsPanel() {
        ServiceLoader<GSLogger> logLoader = ServiceLoader.load(GSLogger.class);
        logger = logLoader.iterator().next();
        ServiceLoader<GSLogRecord> loader = ServiceLoader.load(GSLogRecord.class);
        record = loader.iterator().next();
        logger.setClassName(getClass().getCanonicalName());
        record.setSourceClassName(logger.getClassName());
        
        initComponents();
        
        app = (NTApp) Application.getInstance();
        pcs = new PropertyChangeSupport(this);
        
        systemProxyRadioButton.setSelected(Boolean.parseBoolean(
                System.getProperty("java.net.useSystemProxies")));
        
        proxyServerField.getDocument().addDocumentListener(this);
        
        loadSettings(app.getProperties());
    }
    
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }
    
    @Override
    public void addPropertyChangeListener(String propertyName, 
            PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(propertyName, listener);
    }
    
    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }
    
    @Override
    public void removePropertyChangeListener(String propertyName, 
            PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(propertyName, listener);
    }
    
    @Override
    public void firePropertyChange(String propertyName, Object oldValue, 
            Object newValue) {
        if (propertyName != null && oldValue != null && newValue != null) {
            pcs.firePropertyChange(propertyName, oldValue, newValue);
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

        proxyGroup = new javax.swing.ButtonGroup();
        statsInfoLabel = new javax.swing.JLabel();
        allowStatisticsCheckBox = new javax.swing.JCheckBox();
        usageStatsLabel = new javax.swing.JLabel();
        testConnectionButton = new javax.swing.JButton();
        moreProxyOptionsButton = new javax.swing.JButton();
        proxyPortField = new javax.swing.JTextField();
        proxyPortLabel = new javax.swing.JLabel();
        proxyServerField = new javax.swing.JTextField();
        httpProxyLabel = new javax.swing.JLabel();
        manuProxyRadioButton = new javax.swing.JRadioButton();
        systemProxyRadioButton = new javax.swing.JRadioButton();
        reloadButton = new javax.swing.JButton();
        noProxyRadioButton = new javax.swing.JRadioButton();
        proxySettingsLabel = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        webBrowserLabel = new javax.swing.JLabel();
        webBrowsersList = new javax.swing.JComboBox<>();
        editBrowserListButton = new javax.swing.JButton();

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(ProxyOptionsPanel.class);
        statsInfoLabel.setText(resourceMap.getString("statsInfoLabel.text")); // NOI18N
        statsInfoLabel.setName("statsInfoLabel"); // NOI18N

        allowStatisticsCheckBox.setText(resourceMap.getString("allowStatisticsCheckBox.text")); // NOI18N
        allowStatisticsCheckBox.setName("allowStatisticsCheckBox"); // NOI18N
        allowStatisticsCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                allowStatisticsCheckBoxItemStateChanged(evt);
            }
        });

        usageStatsLabel.setText(resourceMap.getString("usageStatsLabel.text")); // NOI18N
        usageStatsLabel.setName("usageStatsLabel"); // NOI18N

        testConnectionButton.setText(resourceMap.getString("testConnectionButton.text")); // NOI18N
        testConnectionButton.setName("testConnectionButton"); // NOI18N

        moreProxyOptionsButton.setText(resourceMap.getString("moreProxyOptionsButton.text")); // NOI18N
        moreProxyOptionsButton.setEnabled(false);
        moreProxyOptionsButton.setName("moreProxyOptionsButton"); // NOI18N

        proxyPortField.setEnabled(false);
        proxyPortField.setName("proxyPortField"); // NOI18N
        proxyPortField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldFocused(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textFieldUnfocused(evt);
            }
        });

        proxyPortLabel.setText(resourceMap.getString("proxyPortLabel.text")); // NOI18N
        proxyPortLabel.setEnabled(false);
        proxyPortLabel.setName("proxyPortLabel"); // NOI18N

        proxyServerField.setEnabled(false);
        proxyServerField.setName("proxyServerField"); // NOI18N
        proxyServerField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldFocused(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textFieldUnfocused(evt);
            }
        });

        httpProxyLabel.setText(resourceMap.getString("httpProxyLabel.text")); // NOI18N
        httpProxyLabel.setEnabled(false);
        httpProxyLabel.setName("httpProxyLabel"); // NOI18N

        proxyGroup.add(manuProxyRadioButton);
        manuProxyRadioButton.setText(resourceMap.getString("manuProxyRadioButton.text")); // NOI18N
        manuProxyRadioButton.setName("manuProxyRadioButton"); // NOI18N
        manuProxyRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                manuProxyRadioButtonItemStateChanged(evt);
            }
        });

        proxyGroup.add(systemProxyRadioButton);
        systemProxyRadioButton.setText(resourceMap.getString("systemProxyRadioButton.text")); // NOI18N
        systemProxyRadioButton.setName("systemProxyRadioButton"); // NOI18N
        systemProxyRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                systemProxyRadioButtonItemStateChanged(evt);
            }
        });

        reloadButton.setIcon(resourceMap.getIcon("reloadButton.icon")); // NOI18N
        reloadButton.setText(resourceMap.getString("reloadButton.text")); // NOI18N
        reloadButton.setName("reloadButton"); // NOI18N

        proxyGroup.add(noProxyRadioButton);
        noProxyRadioButton.setSelected(true);
        noProxyRadioButton.setText(resourceMap.getString("noProxyRadioButton.text")); // NOI18N
        noProxyRadioButton.setName("noProxyRadioButton"); // NOI18N
        noProxyRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                noProxyRadioButtonItemStateChanged(evt);
            }
        });

        proxySettingsLabel.setText(resourceMap.getString("proxySettingsLabel.text")); // NOI18N
        proxySettingsLabel.setName("proxySettingsLabel"); // NOI18N

        jSeparator3.setName("jSeparator3"); // NOI18N

        jSeparator2.setName("jSeparator2"); // NOI18N

        webBrowserLabel.setText(resourceMap.getString("webBrowserLabel.text")); // NOI18N
        webBrowserLabel.setName("webBrowserLabel"); // NOI18N

        webBrowsersList.setName("webBrowsersList"); // NOI18N
        webBrowsersList.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                webBrowsersListItemStateChanged(evt);
            }
        });

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance().getContext().getActionMap(ProxyOptionsPanel.class, this);
        editBrowserListButton.setAction(actionMap.get("showManager")); // NOI18N
        editBrowserListButton.setIcon(resourceMap.getIcon("editBrowserListButton.icon")); // NOI18N
        editBrowserListButton.setMnemonic('E');
        editBrowserListButton.setText(resourceMap.getString("editBrowserListButton.text")); // NOI18N
        editBrowserListButton.setName("editBrowserListButton"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(proxySettingsLabel)
                            .addComponent(webBrowserLabel)
                            .addComponent(usageStatsLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(webBrowsersList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editBrowserListButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(manuProxyRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(httpProxyLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(proxyServerField)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(proxyPortLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(proxyPortField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(moreProxyOptionsButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(testConnectionButton)
                                    .addComponent(noProxyRadioButton)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(systemProxyRadioButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(reloadButton))
                                    .addComponent(allowStatisticsCheckBox)
                                    .addComponent(statsInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(webBrowserLabel)
                    .addComponent(webBrowsersList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editBrowserListButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proxySettingsLabel)
                    .addComponent(noProxyRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(systemProxyRadioButton)
                    .addComponent(reloadButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(manuProxyRadioButton)
                    .addComponent(httpProxyLabel)
                    .addComponent(proxyServerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(moreProxyOptionsButton)
                    .addComponent(proxyPortField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(proxyPortLabel))
                .addGap(18, 18, 18)
                .addComponent(testConnectionButton)
                .addGap(7, 7, 7)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usageStatsLabel)
                    .addComponent(allowStatisticsCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statsInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void manuProxyRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_manuProxyRadioButtonItemStateChanged
        pcs.firePropertyChange("itemStateChanged",
                !manuProxyRadioButton.isSelected(), 
                manuProxyRadioButton.isSelected());

        httpProxyLabel.setEnabled(manuProxyRadioButton.isSelected());
        proxyServerField.setEnabled(manuProxyRadioButton.isSelected());
        proxyPortLabel.setEnabled(manuProxyRadioButton.isSelected());
        proxyPortField.setEnabled(manuProxyRadioButton.isSelected());
        moreProxyOptionsButton.setEnabled(manuProxyRadioButton.isSelected());
    }//GEN-LAST:event_manuProxyRadioButtonItemStateChanged

    private void systemProxyRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_systemProxyRadioButtonItemStateChanged
        pcs.firePropertyChange("itemStateChanged",
                !systemProxyRadioButton.isSelected(), 
                systemProxyRadioButton.isSelected());
        reloadButton.setEnabled(systemProxyRadioButton.isSelected());
        proxyPortField.setText("[Sys]");
        proxyServerField.setText("[use system proxy]");
    }//GEN-LAST:event_systemProxyRadioButtonItemStateChanged

    private void noProxyRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_noProxyRadioButtonItemStateChanged
        pcs.firePropertyChange("itemStateChaned", !noProxyRadioButton.isSelected(),
                noProxyRadioButton.isSelected());
    }//GEN-LAST:event_noProxyRadioButtonItemStateChanged

    private void webBrowsersListItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_webBrowsersListItemStateChanged
        pcs.firePropertyChange("itemStateChanged", evt.getItem(), 
                evt.getStateChange());
    }//GEN-LAST:event_webBrowsersListItemStateChanged

    private void allowStatisticsCheckBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_allowStatisticsCheckBoxItemStateChanged
        pcs.firePropertyChange("itemStateChanged", 
                !allowStatisticsCheckBox.isSelected(),
                allowStatisticsCheckBox.isSelected());
    }//GEN-LAST:event_allowStatisticsCheckBoxItemStateChanged

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox allowStatisticsCheckBox;
    private javax.swing.JButton editBrowserListButton;
    private javax.swing.JLabel httpProxyLabel;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JRadioButton manuProxyRadioButton;
    private javax.swing.JButton moreProxyOptionsButton;
    private javax.swing.JRadioButton noProxyRadioButton;
    private javax.swing.ButtonGroup proxyGroup;
    private javax.swing.JTextField proxyPortField;
    private javax.swing.JLabel proxyPortLabel;
    private javax.swing.JTextField proxyServerField;
    private javax.swing.JLabel proxySettingsLabel;
    private javax.swing.JButton reloadButton;
    private javax.swing.JLabel statsInfoLabel;
    private javax.swing.JRadioButton systemProxyRadioButton;
    private javax.swing.JButton testConnectionButton;
    private javax.swing.JLabel usageStatsLabel;
    private javax.swing.JLabel webBrowserLabel;
    private javax.swing.JComboBox<String> webBrowsersList;
    // End of variables declaration//GEN-END:variables

    @Override
    public OptionsCategories getCategory() {
        return OptionsCategories.GENERAL;
    }

    @Override
    public JPanel getInstance() {
        if (panel == null) {
            panel = new ProxyOptionsPanel();
        }
        
        return panel;
    }

    @Override
    public String getTitle() {
        return "Internet Settings";
    }
    
    @Override
    public void loadSettings(GSProperties properties) {
        Properties props = (Properties) properties;
        
        try {
            boolean usingProxy = props.getPropertyAsBoolean("net.usingProxy");
            boolean usingSystemProxy = props.getPropertyAsBoolean("net.usingSystemProxy");

            noProxyRadioButton.setSelected(!usingProxy && !usingSystemProxy);
            systemProxyRadioButton.setSelected(usingProxy && usingSystemProxy);
            manuProxyRadioButton.setSelected(usingProxy && !usingSystemProxy);

            if (noProxyRadioButton.isSelected()) {
                proxyServerField.setText("");
                proxyPortField.setText("");
            } else {
                proxyServerField.setText(props.getPropertyAsString("net.proxy.server"));
                proxyPortField.setText(props.getPropertyAsString("net.proxy.port"));
            }

            allowStatisticsCheckBox.setSelected(props.getPropertyAsBoolean("allow.usageStatistics"));

            loadBrowserList();
        } catch (NullPointerException ex) {
            record.setInstant(Instant.now());
            record.setMessage("Attempting to load options panels.");
            record.setParameters(null);
            record.setSourceMethodName("loadSettings");
            record.setThread(Thread.currentThread());
            record.setThrown(ex);
            logger.error(record);
        }
    }
    
    private void loadBrowserList() {
        webBrowsersList.removeAllItems();   // Clear the list to start.
        
        String configPath = app.getContext().getLocalStorage().getDirectory().getAbsolutePath();
        if (!configPath.endsWith(File.separator)) {
            configPath += File.separator;
        }
        configPath += "etc" + File.separator + "installed.brwsrs";
        File installedBrowsers = new File(configPath);
        
        String defaultBrowser = null;
        
        if (!installedBrowsers.exists()) {
            // Add the option for the system default browser.
            webBrowsersList.addItem("<System Default Browser>");

            // Add Firefox, Chrome, and Mozilla (standard web browsers on most systems.
            webBrowsersList.addItem("Firefox");
            webBrowsersList.addItem("Chrome");
            webBrowsersList.addItem("Mozilla");

            // If running on windows, add Internet Explorer and Microsoft Edge.
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                webBrowsersList.addItem("Internet Explorer");
                webBrowsersList.addItem("Microsoft Edge");
            }

            // If running on Mac OS X, add Opera.
            if (System.getProperty("os.name").toLowerCase().contains("mac os x")) {
                webBrowsersList.addItem("Opera");
            }
        } else {
            try (BufferedReader in = new BufferedReader(new FileReader(installedBrowsers))) {
                String line;
                while ((line = in.readLine()) != null) {
                    webBrowsersList.addItem(line);
                }
                
                defaultBrowser = (app.getProperties().getPropertyAsString(
                    "default.browser") == null) ? null :
                    app.getProperties().getPropertyAsString("default.browser");
            } catch (NullPointerException | IOException ex) {
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
        
        if (webBrowsersList.getItemCount() > 0) {
            // Select the browser set as the system default.
            if (defaultBrowser != null && !defaultBrowser.isEmpty()) {
                webBrowsersList.setSelectedItem(defaultBrowser);
            } else {
                webBrowsersList.setSelectedItem("<System Default Browser>");
            }
        }
    }
    
    @Override
    public void saveSettings(GSProperties props) {
        props.setSystemProperty("net.usingProxy", !noProxyRadioButton.isSelected());
        if (noProxyRadioButton.isSelected()) {
            proxyServerField.setText("");
            proxyPortField.setText("");
            props.setSystemProperty("net.usingSystemProxy", Boolean.FALSE);
        }
        
        props.setSystemProperty("net.proxy.server", proxyPortField.getText());
        props.setSystemProperty("net.proxy.port", proxyServerField.getText());
        
        if (manuProxyRadioButton.isSelected()) {
            props.setSystemProperty("net.usingSystemProxy", Boolean.FALSE);
            props.setSystemProperty("net.usingProxy", Boolean.TRUE);
            props.setSystemProperty("net.proxy.server", proxyServerField.getText());
            props.setSystemProperty("net.proxy.port", proxyPortField.getText());
        }
        
        if (systemProxyRadioButton.isSelected()) {
            props.setSystemProperty("net.usingProxy", Boolean.TRUE);
            props.setSystemProperty("net.usingSystemProxy", Boolean.TRUE);
            props.setSystemProperty("net.proxy.server", "[using system proxy]");
            props.setSystemProperty("net.proxy.port", "[Sys]");
        }
        
        props.setSystemProperty("allow.usageStatistics", allowStatisticsCheckBox.isSelected());
        props.setSystemProperty("default.browser", webBrowsersList.getSelectedItem().toString());
        
        String[] browsers = new String[webBrowsersList.getItemCount()];
        for (int x = 0; x < webBrowsersList.getItemCount(); x++) {
            browsers[x] = webBrowsersList.getItemAt(x);
        }
        
        String browsersFilePath = app.getContext().getLocalStorage().getDirectory().getAbsolutePath();
        if (!browsersFilePath.endsWith(File.separator)) {
            browsersFilePath += File.separator;
        }
        browsersFilePath += "etc" + File.separator + "installed.brwsrs";
        File browsersFile = new File(browsersFilePath);
        
        try (BufferedWriter out = new BufferedWriter(new FileWriter(browsersFile))) {
            for (String browser : browsers) {
                if (!"<System Default Browser>".equals(browser)) {
                    out.write(browser + "\n");
                    out.flush();
                }
            }
        } catch (IOException ex) {
                record.setInstant(Instant.now());
                record.setMessage("Attempting to write out installed browsers file.");
                record.setParameters(null);
                record.setSourceMethodName("saveSettings");
                record.setThread(Thread.currentThread());
                record.setThrown(ex);
                logger.error(record);
                MessageBox.showError(ex, "I/O Error");
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        pcs.firePropertyChange("textChanged", null, null);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        pcs.firePropertyChange("textChanged", null, null);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        pcs.firePropertyChange("textChanged", null, null);
    }

    @Action
    public void showManager() {
        BrowserConfigDialog dlg = new BrowserConfigDialog(null, true);
        dlg.pack();
        app.show(dlg);
    }
}
