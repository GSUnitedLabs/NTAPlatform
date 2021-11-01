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
 *  Class      :   GSBugReporter.java
 *  Author     :   Sean Carrick
 *  Created    :   Oct 31, 2021 @ 10:23:13 AM
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
package com.gs.api;

/**
 *
 * @author Sean Carrick &lt;sean at gs-unitedlabs dot com&gt;
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public interface GSBugReporter {
    
    /**
     * Retrieves the name of the error log for the bug report.
     * 
     * @return the name of the bug report error log
     */
    public String getErrFileName();

    /**
     * Sets the name of the error log for the bug report.
     * 
     * @param errFileName the name of the error log
     */
    public void setErrFileName(String errFileName);
    
    /**
     * Retrieves the name of the log file for the bug report.
     * 
     * @return the name of the bug report log file
     */
    public String getLogFileName();
    
    /**
     * Sets the name of the log for the bug report.
     * 
     * @param logFileName the name of the log
     */
    public void setLogFileName(String logFileName);

    /**
     * Retrieves the `GSLogRecord` instance assigned to the bug report.
     * 
     * @return the assigned `GSLogRecord` instance
     */
    public GSLogRecord getLogRecord();

    /**
     * Assigns an instance of the `GSLogRecord` to the bug report.
     * 
     * @param logRecord the `GSLogRecord` instance to assign
     */
    public void setLogRecord(GSLogRecord logRecord);
    
    /**
     * Shows the final bug report.
     */
    public void showReport();

}
