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
 *  Class      :   module-info.java
 *  Author     :   Sean Carrick
 *  Created    :   Aug 14, 2021 @ 10:45:38 PM
 *  Modified   :   Aug 14, 2021
 * 
 *  Purpose:     See class JavaDoc comment.
 * 
 *  Revision History:
 * 
 *  WHEN          BY                   REASON
 *  ------------  -------------------  -----------------------------------------
 *  Aug 14, 2021  Sean Carrick         Initial creation.
 * *****************************************************************************
 */

open module NTA.Foundation {
    // JDK Requirements
    requires java.base;
    requires java.desktop;
    requires GS.United.Labs.API;
    requires NTA.Properties;
    requires NTA.Utils;
    
    // Project Requirements
    requires appframework;
    requires swing.worker;
    requires java.logging;
    
    // Uses Statements
    uses com.gs.api.GSBugReporter;
    uses com.gs.api.GSLogRecord;
    uses com.gs.api.GSLogger;
    uses com.gs.api.AboutPanelProvider;
    uses com.gs.api.ActionCommandProvider;
    uses com.gs.api.MenuProvider;
    uses com.gs.api.ModuleRegistrar;
    uses com.gs.api.OptionsPanelProvider;
    uses com.gs.api.SubMenuProvider;
    uses com.gs.api.ToolbarButtonProvider;
    
    // Exports Packages
    exports com.gs.nta;
    
    // Provides Packages
    provides com.gs.api.ActionCommandProvider with com.gs.nta.menus.ExitActionCommand,
            com.gs.nta.menus.OptionsActionCommand, com.gs.nta.menus.AboutActionCommand;
    provides com.gs.api.MenuProvider with com.gs.nta.menus.FileMenuProvider,
            com.gs.nta.menus.EditMenuProvider, com.gs.nta.menus.HelpMenuProvider,
            com.gs.nta.menus.ToolsMenuProvider, com.gs.nta.menus.ViewMenuProvider;
    provides com.gs.api.OptionsPanelProvider with com.gs.nta.desktop.panels.ProxyOptionsPanel;
    provides com.gs.api.SubMenuProvider with com.gs.nta.menus.NewMenuProvider;
}
