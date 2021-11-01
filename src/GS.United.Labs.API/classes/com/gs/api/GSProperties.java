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
 *  Class      :   GSProperties.java
 *  Author     :   Sean Carrick
 *  Created    :   Oct 31, 2021 @ 2:28:42 PM
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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;

/**
 * The `Properties` class maintains all application properties.
 * <p>
 * Anytime a property is sought, the `Properties` class searches through the
 * list of system properties first. If the property is not found in that list,
 * the runtime properties are searched next. When using the overloaded
 * `getProperty(String propertyName, String defaultValue)` method, if the
 * property that is sought does not exist in either properties list, the
 * supplied `defaultValue` is returned. When using the method
 * `getProperty(String propertyName)`, if the property sought does not exist,
 * `null` is returned.</p>
 * <p>
 * The system properties list is stored to disk whenever requested. However, the
 * runtime properties list is never stored to disk. This is because the runtime
 * properties list can change from run to run, as they are typically set via
 * command-line switches and parameters.</p>
 *
 * @see #getProperty(java.lang.String)
 * @see #getProperty(java.lang.String, java.lang.String)
 * @see #setSystemProperty(java.lang.String, java.lang.String)
 * @see #setRuntimeProperty(java.lang.String, java.lang.String)
 *
 * @author Sean Carrick &lt;sean at gs-unitedlabs dot com&gt;
 *
 * @version 1.1
 * @since 1.0
 */
public interface GSProperties {

    /**
     * Retrieves the value of the property named `propertyName`. If the
     * `propertyName` does not exist in the system properties list, then the
     * runtime properties list is checked. If the property does not exist in
     * either properties list, then `null` is returned.
     *
     * @param propertyName the name of the property whose value should be
     * retrieved
     * @return the value of the property `propertyName` or `null`
     */
    public Object getProperty(String propertyName);

    /**
     * Retrieves the value of the property named `propertyName`. If the
     * `propertyName` does not exist in the system properties list, then the
     * runtime properties list is checked. if the property does not exist in
     * either properties list, the supplied `defaultValue` is returned.
     *
     * @param propertyName the name of the property whose value should be
     * retrieved
     * @param defaultValue the default value if the property does not exist or
     * is not setSystemProperty
     * @return the value of the property `propertyName` or the `defaultValue`
     */
    public Object getProperty(String propertyName, String defaultValue);

    /**
     * Sets the runtime property named `propertyName` to the `value` provided.
     * <p>
     * <strong><em>Note</em></strong>: Runtime properties are for only those
     * properties that are set by command-line parameters. If the property needs
     * to be persisted between `Application` runs, it should be stored to the
     * system properties.</p>
     *
     * @param propertyName the name of the property to set
     * @param value the value to which the property is to be set
     *
     * @see #setSystemProperty(java.lang.String, java.lang.String)
     */
    public void setRuntimeProperty(String propertyName, Object value);

    /**
     * Sets the system property named `propertyName` to the `value` provided.
     * <p>
     * <strong><em>Note</em></strong>: System properties are for only those
     * properties that need to be persisted between `Application` runs. If the
     * property is set by a command-line parameter, then it should be stored to
     * the runtime properties.</p>
     *
     * @param propertyName the name of the property to set
     * @param value the value to which the property is to be set
     *
     * @see #setRuntimeProperty(java.lang.String, java.lang.String)
     * @see #storeProperties()
     */
    public void setSystemProperty(String propertyName, Object value);

    /**
     * Stores the system properties to the `Application`'s configuration file.
     * <p>
     * <strong><em>Note</em></strong>: The system properties list is written to
     * disk when `storeProperties` is called. However, the runtime properties
     * list is not persisted to disk, as these are throw-away properties that
     * only affect the current run of the `Application`. Always make sure to set
     * properties to the appropriate properties list.</p>
     *
     * @see #setRuntimeProperty(java.lang.String, java.lang.String)
     * @see #setSystemProperty(java.lang.String, java.lang.String)
     */
    public void storeProperties();

}
