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
 *  Created    :   Oct 28, 2021 @ 12:10:02 AM
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

open module NTA.Accounting {
    requires java.base;
    requires java.desktop;
    requires appframework;
    requires swing.worker;
    requires GS.United.Labs.API;
    requires NTA.Foundation;
    requires NTA.Properties;
    requires NTA.Utils;
    
    uses com.gs.api.AboutPanelProvider;
    uses com.gs.api.ActionCommandProvider;
    uses com.gs.api.MenuProvider;
    uses com.gs.api.ModuleRegistrar;
    uses com.gs.api.OptionsPanelProvider;
    uses com.gs.api.SubMenuProvider;
    
    provides com.gs.api.AboutPanelProvider 
            with com.gs.nta.accounting.desktop.AccountingAboutPanelProvider;
    provides com.gs.api.MenuProvider 
            with com.gs.nta.accounting.menus.ManageMenuProvider;
    provides com.gs.api.OptionsPanelProvider 
            with com.gs.nta.accounting.options.AccountingOptionsPanel;
}
