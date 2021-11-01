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
 *  Class      :   BugReporter.java
 *  Author     :   Sean Carrick
 *  Created    :   Oct 30, 2021 @ 7:20:37 PM
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

import com.gs.api.GSBugReporter;
import com.gs.api.GSLogRecord;
import com.gs.nta.NTApp;
import java.io.File;
import org.jdesktop.application.Application;

/**
 *
 * @author Sean Carrick &lt;sean at gs-unitedlabs dot com&gt;
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class BugReporter implements GSBugReporter {
    
    private static BugReporter reporter;
    
    private final NTApp app = (NTApp) Application.getInstance();
    private final String logsDir;
    private final String errDir;
    private String logFileName;
    private String errFileName;
    private Thread thread;
    private GSLogRecord logRecord;

    public BugReporter () {
        String tmp = app.getContext().getLocalStorage().getDirectory().getAbsolutePath();
        if (!tmp.endsWith(File.separator)) {
            tmp += File.separator;
        }
        logsDir = tmp + "var" + File.separator + "log" + File.separator;
        errDir = tmp + "var" + File.separator + "err" + File.separator;
    }
    
    public static BugReporter getInstance() {
        if (reporter == null) {
            reporter = new BugReporter();
        }
        return reporter;
    }

    @Override
    public String getErrFileName() {
        return errFileName;
    }

    @Override
    public void setErrFileName(String errFileName) {
        this.errFileName = errFileName;
    }
    
    @Override
    public String getLogFileName() {
        return logFileName;
    }
    
    @Override
    public void setLogFileName(String logFileName) {
        this.logFileName = logFileName;
    }

    @Override
    public GSLogRecord getLogRecord() {
        return logRecord;
    }

    @Override
    public void setLogRecord(GSLogRecord logRecord) {
        this.logRecord = logRecord;
    }
    
    @Override
    public void showReport() {
        BugReportDialog dlg = new BugReportDialog(this);
    }

}
