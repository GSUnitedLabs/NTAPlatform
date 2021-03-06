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
 *  Created    :   Oct 31, 2021 @ 11:01:42 AM
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

open module NTA.Logging {
    requires java.base;
    requires appframework;
    requires GS.United.Labs.API;
    requires NTA.Foundation;
    requires NTA.Utils;
    
    exports com.gs.nta.logging;
    
    provides com.gs.api.GSLogRecord with com.gs.nta.logging.LogRecord;
    provides com.gs.api.GSLogger with com.gs.nta.logging.Logger;
}
