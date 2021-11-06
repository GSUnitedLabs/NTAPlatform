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
 *  Class      :   OptionsDialog.java
 *  Author     :   Sean Carrick
 *  Created    :   Oct 28, 2021 @ 3:21:13 PM
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
package com.gs.nta.desktop;
 
import com.gs.api.GSLogRecord;
import com.gs.api.GSLogger;
import com.gs.nta.NTApp;
import com.gs.api.OptionsPanelProvider;
import java.awt.CardLayout;
import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.Instant;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import javax.swing.JTabbedPane;
import org.jdesktop.application.Action;
import org.jdesktop.application.Application;

/**
 *
 * @author Sean Carrick
 */
public class OptionsDialog extends javax.swing.JDialog 
        implements PropertyChangeListener {

    private final GSLogger logger;
    private final GSLogRecord record;
    private final CardLayout cards;
    private final NTApp app;
    
    /**
     * Creates new form OptionsDialog
     */
    public OptionsDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        ServiceLoader<GSLogger> logLoader = ServiceLoader.load(GSLogger.class);
        logger = logLoader.iterator().next();
        logger.setClassName(getClass().getCanonicalName());
        logger.updateLogName();
        ServiceLoader<GSLogRecord> loader = ServiceLoader.load(GSLogRecord.class);
        record = loader.iterator().next();
        record.setSourceClassName(logger.getClassName());
        
        app = (NTApp) Application.getInstance();
        
        
        initComponents();
        
        cards = (CardLayout) optionsPanel.getLayout();
        cards.show(optionsPanel, "general");
        
        loadOptionsPanels();
    }
    
    private void loadOptionsPanels() {
        try {
            ServiceLoader<OptionsPanelProvider> providers = ServiceLoader.load(OptionsPanelProvider.class);

            Iterator<OptionsPanelProvider> it = providers.iterator();

            while(it.hasNext()) {
    //        for (OptionsPanelProvider p : providers) {
                OptionsPanelProvider p = it.next();

                switch (p.getCategory()) {
                    case ACCOUNTING:
                        accountingPanel.add(p.getInstance());
                        accountingPanel.setTitleAt(accountingPanel.getTabCount() - 1, p.getTitle());
                        break;
                    case GENERAL:
                        generalPanel.add(p.getInstance());
                        generalPanel.setTitleAt(generalPanel.getTabCount() - 1, p.getTitle());
                        break;
                    case INTERFACE:
                        interfacePanel.add(p.getInstance());
                        interfacePanel.setTitleAt(interfacePanel.getTabCount() - 1, p.getTitle());
                        break;
                    case MISCELLANEOUS:
                        miscOptionsPanel.add(p.getInstance());
                        miscOptionsPanel.setTitleAt(miscOptionsPanel.getTabCount() - 1, p.getTitle());
                        break;
                    case REPORTS:
                        reportsPanel.add(p.getInstance());
                        reportsPanel.setTitleAt(reportsPanel.getTabCount() - 1, p.getTitle());
                        break;
                    case SCHEDULING:
                        schedulingPanel.add(p.getInstance());
                        schedulingPanel.setTitleAt(schedulingPanel.getTabCount() - 1, p.getTitle());
                        break;
                    default:
                        throw new IllegalArgumentException("invalid category supplied");
                }
                p.getInstance().addPropertyChangeListener("textChanged", this);
                p.getInstance().addPropertyChangeListener("itemStateChanged", this);
            }
        } catch (ServiceConfigurationError svc) {
            record.setInstant(Instant.now());
            record.setMessage("Attempting to load options panels.");
            record.setParameters(null);
            record.setSourceMethodName("loadOptionsPanels");
            record.setThread(Thread.currentThread());
            record.setThrown(svc);
            logger.error(record);
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

        categoriesButtonGroup = new javax.swing.ButtonGroup();
        categoriesToolbar = new javax.swing.JToolBar();
        generalButton = new javax.swing.JToggleButton();
        accountingButton = new javax.swing.JToggleButton();
        calendarsTasksButton = new javax.swing.JToggleButton();
        reportsButton = new javax.swing.JToggleButton();
        interfaceButton = new javax.swing.JToggleButton();
        miscellaneousButton = new javax.swing.JToggleButton();
        optionsPanel = new javax.swing.JPanel();
        generalPanel = new javax.swing.JTabbedPane();
        accountingPanel = new javax.swing.JTabbedPane();
        interfacePanel = new javax.swing.JTabbedPane();
        miscOptionsPanel = new javax.swing.JTabbedPane();
        schedulingPanel = new javax.swing.JTabbedPane();
        reportsPanel = new javax.swing.JTabbedPane();
        commandPanel = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();
        applyButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        helpButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(OptionsDialog.class);
        categoriesToolbar.setBackground(resourceMap.getColor("categoriesToolbar.background")); // NOI18N
        categoriesToolbar.setFloatable(false);
        categoriesToolbar.setRollover(true);
        categoriesToolbar.setName("categoriesToolbar"); // NOI18N

        generalButton.setBackground(resourceMap.getColor("generalButton.background")); // NOI18N
        categoriesButtonGroup.add(generalButton);
        generalButton.setIcon(resourceMap.getIcon("generalButton.icon")); // NOI18N
        generalButton.setSelected(true);
        generalButton.setText(resourceMap.getString("generalButton.text")); // NOI18N
        generalButton.setFocusable(false);
        generalButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        generalButton.setName("generalButton"); // NOI18N
        generalButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        generalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generalButtonActionPerformed(evt);
            }
        });
        categoriesToolbar.add(generalButton);

        accountingButton.setBackground(resourceMap.getColor("accountingButton.background")); // NOI18N
        categoriesButtonGroup.add(accountingButton);
        accountingButton.setIcon(resourceMap.getIcon("accountingButton.icon")); // NOI18N
        accountingButton.setText(resourceMap.getString("accountingButton.text")); // NOI18N
        accountingButton.setFocusable(false);
        accountingButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        accountingButton.setName("accountingButton"); // NOI18N
        accountingButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        accountingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountingButtonActionPerformed(evt);
            }
        });
        categoriesToolbar.add(accountingButton);

        calendarsTasksButton.setBackground(new java.awt.Color(51, 51, 51));
        categoriesButtonGroup.add(calendarsTasksButton);
        calendarsTasksButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gs/nta/desktop/resources/icons/OptionsToolbar/preferences-calendar-and-tasks.png"))); // NOI18N
        calendarsTasksButton.setFocusable(false);
        calendarsTasksButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        calendarsTasksButton.setLabel("Calendar");
        calendarsTasksButton.setName("calendarsTasksButton"); // NOI18N
        calendarsTasksButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        calendarsTasksButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calendarsTasksButtonActionPerformed(evt);
            }
        });
        categoriesToolbar.add(calendarsTasksButton);

        reportsButton.setBackground(new java.awt.Color(51, 51, 51));
        categoriesButtonGroup.add(reportsButton);
        reportsButton.setIcon(resourceMap.getIcon("reportsButton.icon")); // NOI18N
        reportsButton.setText(resourceMap.getString("reportsButton.text")); // NOI18N
        reportsButton.setFocusable(false);
        reportsButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        reportsButton.setName("reportsButton"); // NOI18N
        reportsButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        reportsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportsButtonActionPerformed(evt);
            }
        });
        categoriesToolbar.add(reportsButton);

        interfaceButton.setBackground(resourceMap.getColor("interfaceButton.background")); // NOI18N
        categoriesButtonGroup.add(interfaceButton);
        interfaceButton.setIcon(resourceMap.getIcon("interfaceButton.icon")); // NOI18N
        interfaceButton.setText(resourceMap.getString("interfaceButton.text")); // NOI18N
        interfaceButton.setFocusable(false);
        interfaceButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        interfaceButton.setName("interfaceButton"); // NOI18N
        interfaceButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        interfaceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interfaceButtonActionPerformed(evt);
            }
        });
        categoriesToolbar.add(interfaceButton);

        miscellaneousButton.setBackground(resourceMap.getColor("miscellaneousButton.background")); // NOI18N
        categoriesButtonGroup.add(miscellaneousButton);
        miscellaneousButton.setIcon(resourceMap.getIcon("miscellaneousButton.icon")); // NOI18N
        miscellaneousButton.setText(resourceMap.getString("miscellaneousButton.text")); // NOI18N
        miscellaneousButton.setFocusable(false);
        miscellaneousButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        miscellaneousButton.setName("miscellaneousButton"); // NOI18N
        miscellaneousButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        miscellaneousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miscellaneousButtonActionPerformed(evt);
            }
        });
        categoriesToolbar.add(miscellaneousButton);

        optionsPanel.setName("optionsPanel"); // NOI18N
        optionsPanel.setLayout(new java.awt.CardLayout());

        generalPanel.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        generalPanel.setName("generalPanel"); // NOI18N
        optionsPanel.add(generalPanel, "general");

        accountingPanel.setName("accountingPanel"); // NOI18N
        optionsPanel.add(accountingPanel, "accounting");

        interfacePanel.setName("interfacePanel"); // NOI18N
        optionsPanel.add(interfacePanel, "interface");

        miscOptionsPanel.setName("miscOptionsPanel"); // NOI18N
        optionsPanel.add(miscOptionsPanel, "miscellaneous");

        schedulingPanel.setName("schedulingPanel"); // NOI18N
        optionsPanel.add(schedulingPanel, "scheduling");

        reportsPanel.setName("reportsPanel"); // NOI18N
        optionsPanel.add(reportsPanel, "reports");

        commandPanel.setName("commandPanel"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance().getContext().getActionMap(OptionsDialog.class, this);
        cancelButton.setAction(actionMap.get("cancel")); // NOI18N
        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gs/nta/desktop/resources/icons/small/stock_close.png"))); // NOI18N
        cancelButton.setText(resourceMap.getString("cancelButton.text")); // NOI18N
        cancelButton.setName("cancelButton"); // NOI18N

        applyButton.setAction(actionMap.get("applyChanges")); // NOI18N
        applyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gs/nta/desktop/resources/icons/small/answer-correct.png"))); // NOI18N
        applyButton.setText(resourceMap.getString("applyButton.text")); // NOI18N
        applyButton.setName("applyButton"); // NOI18N

        okButton.setAction(actionMap.get("applyAndClose")); // NOI18N
        okButton.setText(resourceMap.getString("okButton.text")); // NOI18N
        okButton.setName("okButton"); // NOI18N

        helpButton.setAction(actionMap.get("showOptionsHelp")); // NOI18N
        helpButton.setIcon(resourceMap.getIcon("helpButton.icon")); // NOI18N
        helpButton.setText(resourceMap.getString("helpButton.text")); // NOI18N
        helpButton.setName("helpButton"); // NOI18N

        javax.swing.GroupLayout commandPanelLayout = new javax.swing.GroupLayout(commandPanel);
        commandPanel.setLayout(commandPanelLayout);
        commandPanelLayout.setHorizontalGroup(
            commandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, commandPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(helpButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(okButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(applyButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton)
                .addContainerGap())
        );
        commandPanelLayout.setVerticalGroup(
            commandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, commandPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(commandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(applyButton)
                    .addComponent(okButton)
                    .addComponent(helpButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(categoriesToolbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(optionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(commandPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(categoriesToolbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(optionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(commandPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miscellaneousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miscellaneousButtonActionPerformed
        if (miscellaneousButton.isSelected()) {
            cards.show(optionsPanel, "miscellaneous");
        }
    }//GEN-LAST:event_miscellaneousButtonActionPerformed

    private void interfaceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interfaceButtonActionPerformed
        if (interfaceButton.isSelected()) {
            cards.show(optionsPanel, "interface");
        }
    }//GEN-LAST:event_interfaceButtonActionPerformed

    private void reportsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportsButtonActionPerformed
        if (reportsButton.isSelected()) {
            cards.show(optionsPanel, "reports");
        }
    }//GEN-LAST:event_reportsButtonActionPerformed

    private void calendarsTasksButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calendarsTasksButtonActionPerformed
        if (calendarsTasksButton.isSelected()) {
            cards.show(optionsPanel, "scheduling");
        }
    }//GEN-LAST:event_calendarsTasksButtonActionPerformed

    private void accountingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountingButtonActionPerformed
        if (accountingButton.isSelected()) {
            cards.show(optionsPanel, "accounting");
        }
    }//GEN-LAST:event_accountingButtonActionPerformed

    private void generalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generalButtonActionPerformed
        if (generalButton.isSelected()) {
            cards.show(optionsPanel, "general");
        }
    }//GEN-LAST:event_generalButtonActionPerformed

    @Action(enabledProperty = "saveneeded")
    public void applyChanges() {
        applyButton.setEnabled(false);
        for (int options = 0; options < optionsPanel.getComponentCount(); options++) {
            Component c = optionsPanel.getComponent(options);
            if (c instanceof JTabbedPane) {
                JTabbedPane category = (JTabbedPane) c;
                
                for (int tabs = 0; tabs < category.getTabCount(); tabs++) {
                    Component t = category.getComponentAt(tabs);
                    
                    if (t instanceof OptionsPanelProvider) {
                        ((OptionsPanelProvider) t).saveSettings(app.getProperties());
                    }
                }
            }
        }
    }

    private boolean saveneeded = false;
    public boolean isSaveneeded() {
        return saveneeded;
    }

    public void setSaveneeded(boolean b) {
        boolean old = isSaveneeded();
        this.saveneeded = b;
        firePropertyChange("saveneeded", old, isSaveneeded());
    }

    @Action
    public void cancel() {
        dispose();
    }

    @Action
    public void applyAndClose() {
        applyChanges();
        cancel();
    }

    @Action
    public void showOptionsHelp() {
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton accountingButton;
    private javax.swing.JTabbedPane accountingPanel;
    private javax.swing.JButton applyButton;
    private javax.swing.JToggleButton calendarsTasksButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.ButtonGroup categoriesButtonGroup;
    private javax.swing.JToolBar categoriesToolbar;
    private javax.swing.JPanel commandPanel;
    private javax.swing.JToggleButton generalButton;
    private javax.swing.JTabbedPane generalPanel;
    private javax.swing.JButton helpButton;
    private javax.swing.JToggleButton interfaceButton;
    private javax.swing.JTabbedPane interfacePanel;
    private javax.swing.JTabbedPane miscOptionsPanel;
    private javax.swing.JToggleButton miscellaneousButton;
    private javax.swing.JButton okButton;
    private javax.swing.JPanel optionsPanel;
    private javax.swing.JToggleButton reportsButton;
    private javax.swing.JTabbedPane reportsPanel;
    private javax.swing.JTabbedPane schedulingPanel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("textChanged".equals(evt.getPropertyName())
                || "itemStateChanged".equals(evt.getPropertyName())) {
            applyButton.setEnabled(true);
        }
    }
}
