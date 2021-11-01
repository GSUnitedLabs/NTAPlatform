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
 *  Class      :   GSLogger.java
 *  Author     :   Sean Carrick
 *  Created    :   Oct 31, 2021 @ 9:40:07 AM
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
 * The `Logger` class is an `Application`-aware logging facility. This `Logger`
 * works almost identically to {@link java.util.logging.Logger} with minor
 * modifications. The manner of logging messages is slightly different, though
 * most of the methods have been replicated, though they may have different
 * names than those found in the `java.util.logging.Logger` class.
 * <p>
 * `Logger` provides its own levels, as described below:</p>
 * | Level | Verbosity | | :---: | :-------- | | `Logger.OFF` | No log messages
 * will be written to the terminal nor the log file. | | `Logger.TRACE` | The
 * most verbose level. All messages will be written to the log file. When this
 * level is set, all messages will also be written to the terminal. This is the
 * best level for use when developing an application project. | | `Logger.DEBUG`
 * | Less verbose than trace level. All messages will be written to the log
 * file, but no debugging messages will be written to the terminal. | |
 * `Logger.CONFIG` | Less verbose level than debugging. All configuration,
 * informational, warning, error, and critical messages will be written to the
 * log file. Configuration messages are not written to the terminal. | |
 * `Logger.INFO` | Less verbose level than configuration. All informational,
 * warning, error, and critical messages will be written to the log file.
 * Informational messages are not written to the terminal. | | `Logger.WARN` |
 * Less verbose level than informational. All messages will be written to both
 * the log file and the terminal. | | `Logger.ERROR` | Less verbose level than
 * warning. All messages will be written to both the log file and the terminal.
 * This level message is for recoverable errors. | | `Logger.CRITICAL` | Least
 * verbose level. All messages will be written to both the log file and the
 * terminal's error stream. This level message is for unrecoverable errors to be
 * logged just before application termination. |
 * <p>
 * The methods for sending logging messages to the log file and/or terminal have
 * names similar to the `Logger` levels to make things easier on the developer.
 * The methods are: `debug`, `config`, `info`, `warn`, `error`, and `critical`.
 * There are also methods that can be called to log entry into and exit from
 * methods: `enter` and `exit`. All of the methods of `Logger` have a single way
 * of receiving the message to be logged and that is via a `GSLogRecord`
 * object.</p>
 * <p>
 * One other related class is the `GSLogRecord` class. This class can have its
 * properties set and then send the whole record to any of the logging methods.
 * The properties available for the `GSLogRecord` class are:</p>
 * | Property | Use | | :------: | :-- | | Instant | Identifies the instant that
 * the logged event occurred | | Level | The logging message level | |
 * LoggerName | The name of the source `Logger` | | Message | The "raw" log
 * message before internationalization or formatting | | Parameters | The
 * parameters of the log message | | ResourceBundle | The localization
 * `ResourceBundle` | | ResourceBundleName | The name of the localization
 * `ResourceBundle` | | SequenceNumber | The sequence number | | SourceClassName
 * | name of the class that (allegedly) issued the logging request | |
 * SourceMethodName | name of the method that (allegedly) issued the logging
 * request | | ThreadID | The identifier for the thread where the message
 * originated | | Thrown | A `Throwable` associated with the log event |
 * <p>
 * The logging levels are only part of the story, however. The most important
 * part is making sure that high-quality messages are written to the `Logger` at
 * the appropriate logging level. Once the message quality improves, the log
 * files will become more useful in tracking down bugs and logic flaws, as well
 * as for getting them fixed.</p>
 *
 * @see GSLogRecord
 *
 * @author Sean Carrick &lt;sean at gs-unitedlabs dot com&gt;
 *
 * @version 3.7
 * @since 1.0
 */
public interface GSLogger {

    /**
     * No logging takes place.
     */
    public static final int OFF = -1;

    /**
     * Tracing: the most verbose logging level. Usually used to log diagnostic
     * messages. This level is typically used to track down hard-to-find bugs.
     */
    public static final int TRACE = 0;

    /**
     * Debugging: less verbose than the tracing level. Usually used to log debug
     * information traces.
     */
    public static final int DEBUG = 1;

    /**
     * Configuration: less verbose than the debugging level. Usually used to log
     * configuration information, such as initial variable settings.
     */
    public static final int CONFIG = 2;

    /**
     * Informational: less verbose than the configuration level. Usually used to
     * log message of interest to someone reading the log file.
     */
    public static final int INFO = 3;

    /**
     * Warning: less verbose than the informational level. Usually used to log
     * warning messages for events that do not cause an actual error.
     */
    public static final int WARN = 4;

    /**
     * Errors: less verbose than the warning level. Usually used to log messages
     * regarding recoverable errors.
     */
    public static final int ERROR = 5;

    /**
     * Critical Errors: least verbose logging level. Usually used to log
     * messages about system critical errors immediately before the application
     * exits.
     */
    public static final int CRITICAL = 6;

    /**
     * Provide a `GSLogRecord` to create a configuration message in the log file.
     * <p>
     * The `GSLogRecord` needs to contain the source class name, which is set at
     * the time the log is initialized. Also, the `GSLogRecord` needs to contain
     * the source method name, which is set at the time an entry is made when
     * entering the method. The parameters list of the `GSLogRecord` can contain
     * parameters to a format string, if a format string is used for the
     * message. However, if not using a format string for the message, then the
     * parameters list needs to be set to `null`. The instant and sequence
     * number for the `GSLogRecord` is optional, as is the thread ID.</p>
     *
     * @param record the `GSLogRecord` of the message and message details.
     */
    public void config(GSLogRecord record);

    /**
     * Provides a method to safely close the log file. This method should be
     * called just prior to the `Application` exiting, possibly during the
     * `shutdown` method. This method only has an effect if logging is not at
     * level `Logger.OFF`.
     */
    public void close();

    /**
     * Logs a system critical error to the log file, and creates a separate,
     * detailed error log file that contains details about the application, the
     * user, the operating system, and the Java environment.
     * <p>
     * The `GSLogRecord` for a system critical error needs to have all properties
     * supplied, except the sequence number (which is optional). The more of the
     * properties that are set, the better detail can be provided in the error
     * log file.</p>
     * <p>
     * When an `Exception` occurs that places the application into an unstable
     * or untenable state, the `catch` block should populate as many of the
     * properties of the `GSLogRecord` as is feasible:</p>
     *
     * ```java public class MyClass {
     *
     * private final Logger logger = Logger.getLogger(application, Logger.INFO);
     * private final GSLogRecord record = new
     * GSLogRecord(MyClass.getClass().getSimpleName);
     *
     * public int myMethod(int a, int b, int c) {
     * record.setInstant(Instant.now()); record.setSourceMethodName("myMethod");
     * record.setParameters(new Object[] {a, b, c});
     * record.setThreadID(Thread.currentThread().getId()); logger.enter(record);
     *
     * try { // ... the body of the method that could cause an error ... } catch
     * (Exception e) { // Populate as many GSLogRecord properties as possible.
     * Since //+ most of the properties were populated for the Logger.enter //+
     * method call, we simply need to update the Instant and add //+ the
     * exception to the GSLogRecord: record.setInstant(Instant.now());
     * record.setThrown(e);
     *
     *             // The message of the GSLogRecord can be used to provide more //+
     * information about was taking place when the exception was //+ thrown.
     * Remember, the more information provided, the more //+ useful the error
     * log will be. record.setMessage("Details about what the method was doing "
     * + "when the Exception was thrown.");
     *
     *             // Now, all that is left is to log the critical error message:
     * logger.critical(record); } } } ```
     * <p>
     * When your `GSLogRecord` is set up as in this example, the details of the
     * critical error log file should aid you in tracking down the source of the
     * error so that it can be properly fixed.</p>
     * <p>
     * <strong><em>Note</em></strong>: The `critical` method will always be
     * executed, regardless of logging level, except for the level
     * `Logger.OFF`.</p>
     *
     * @param record the `GSLogRecord` of the message and message details.
     */
    public void critical(GSLogRecord record);

    /**
     * Provide a `GSLogRecord` to create a debugging message in the log file.
     * <p>
     * The `GSLogRecord` needs to contain the source class name, which is set at
     * the time the log is initialized. Also, the `GSLogRecord` needs to contain
     * the source method name, which is set at the time an entry is made when
     * entering the method. The parameters list of the `GSLogRecord` can contain
     * parameters to a format string, if a format string is used for the
     * message. However, if not using a format string for the message, then the
     * parameters list needs to be set to `null`. The instant and sequence
     * number for the `GSLogRecord` is optional, as is the thread ID.</p>
     *
     * @param record the `GSLogRecord` of the message and message details.
     */
    public void debug(GSLogRecord record);

    /**
     * Provide a `GSLogRecord` to create a method entry message in the log file.
     * <p>
     * The `GSLogRecord` needs to contain the source class name, which is set at
     * the time the log is initialized. Also, the `GSLogRecord` needs to contain
     * the source method name, which is set at the time an entry is made when
     * entering the method. The parameters list of the `GSLogRecord` should
     * contain the method parameters as an array of `Object`s, if the method
     * takes parameters. However, if the message takes no parameters, then the
     * parameters list needs to be set to `null`. The instant and sequence
     * number for the `GSLogRecord` is optional, as is the thread ID.</p>
     * <p>
     * <strong><em>Note</em></strong>: The `enter` method will only be executed
     * if the logging level is set to `Logger.TRACE`.</p>
     *
     * @param record the `GSLogRecord` of the message and message details
     *
     * @see #exit(com.gs.platform.utils.GSLogRecord)
     */
    public void enter(GSLogRecord record);

    /**
     * Provide a `GSLogRecord` to create a log message for exiting a method. The
     * `GSLogRecord` needs to contain the source class name, source method name,
     * message text. If the message returns a value, that value should be added
     * to the parameters list as an `Object` array of a single element,
     * otherwise the parameters list should be set to `null. For example:
     * ```java public class MyClass {
     *
     * private final GSLogRecord record = new
     * GSLogRecord(MyClass.class.getSimpleName()); private final Logger logger =
     * Logger.getLogger(application, Logger.DEBUG);
     *
     * public void method(int one, int two) { record.setInstant(Instant.now());
     * record.setSourceMethodName("method"); record.setParameters(new Object[]
     * {one, two}); record.setMessage("Entering the method.")
     * logger.enter(record);
     *
     *         // the body of the method.
     *
     *         // Get the instant of this next message and nullify the //+ parameters
     * list since there is no return value. record.setInstant(Instant.now());
     * record.setParameters(null); record.setMessage("the method has completed
     * successfully."); logger.exit(record); }
     *
     * public int add(int one, int two) { record.setInstant(Instant.now());
     * record.setSourceMethodName("add"); record.setParameters(new Object[]
     * {one, two}); record.setMessage("Adding two numbers.");
     * logger.enter(record);
     *
     * int sum = one + two;
     *
     *         // Get the instant of this next message and set the parameters // list
     * to an Object array of one element containing the sum.
     * record.setInstant(Instant.now()); record.setParameters(new Object[]
     * {sum}); record.setMessage("The sum of " + one " + " + two " is " + sum);
     * logger.exit(record); }
     *
     * }
     * ```
     * <p>
     * The current thread ID and a sequence number are optional. Typically, the
     * `Instant.now()` will be set at the time the method is entered. If the
     * `Instant` is not set, the `Instant.now()` that this method is entered
     * will be recorded.</p>
     * <p>
     * <strong><em>Note</em></strong>: The `exit` method will only be executed
     * if the logging level is set to `Logger.TRACE`.</p>
     *
     * @param record the `GSLogRecord` of the message and message details
     *
     * @see #enter(com.gs.platform.utils.GSLogRecord)
     */
    public void exit(GSLogRecord record);

    /**
     * Provide a `GSLogRecord` to create a non-critical error message in the log
     * file.
     * <p>
     * The `GSLogRecord` needs to contain the source class name, which is set at
     * the time the log is initialized. Also, the `GSLogRecord` needs to contain
     * the source method name, which is set at the time an entry is made when
     * entering the method. One other requirement for the `error` method is that
     * the `Thrown` entry be made. The parameters list of the `GSLogRecord` can
     * contain parameters to a format string, if a format string is used for the
     * message. However, if not using a format string for the message, then the
     * parameters list needs to be set to `null`. The instant and sequence
     * number for the `GSLogRecord` is optional, as is the thread ID.</p>
     *
     * @param record the `GSLogRecord` of the message and message details.
     */
    public void error(GSLogRecord record);

    /**
     * Provides a way to retrieve the current logging level for this `Logger`.
     *
     * @return the current logging level
     */
    public int getLevel();
    
    /**
     * Provides a way to change the current logging level.
     * 
     * @param level the new logging level
     */
    public void setLevel(int level);
    
    /**
     * Retrieves the name of the class for which this logger was created.
     * 
     * @return the name of the class using this logger
     */
    public String getClassName();
    
    /**
     * Sets the name of the class for which this logger was created.
     * 
     * @param className the class name
     */
    public void setClassName(String className);
    
    /**
     * Determines whether the output to the log file should format the log
     * entries.
     * 
     * @return `true` if output is formatted
     */
    public boolean isFormattedOutput();
    
    /**
     * Provides a way to set whether or not the log entries should be formatted.
     * 
     * @param formattedOutput `true` to format log entries
     */
    public void setFormattedOutput(boolean formattedOutput);

    /**
     * Provide a `GSLogRecord` to create a informational message in the log file.
     * <p>
     * The `GSLogRecord` needs to contain the source class name, which is set at
     * the time the log is initialized. Also, the `GSLogRecord` needs to contain
     * the source method name, which is set at the time an entry is made when
     * entering the method. The parameters list of the `GSLogRecord` can contain
     * parameters to a format string, if a format string is used for the
     * message. However, if not using a format string for the message, then the
     * parameters list needs to be set to `null`. The instant and sequence
     * number for the `GSLogRecord` is optional, as is the thread ID.</p>
     *
     * @param record the `GSLogRecord` of the message and message details.
     */
    public void info(GSLogRecord record);

    /**
     * Provide a `GSLogRecord` to create a warning message in the log file.
     * <p>
     * The `GSLogRecord` needs to contain the source class name, which is set at
     * the time the log is initialized. Also, the `GSLogRecord` needs to contain
     * the source method name, which is set at the time an entry is made when
     * entering the method. The parameters list of the `GSLogRecord` can contain
     * parameters to a format string, if a format string is used for the
     * message. However, if not using a format string for the message, then the
     * parameters list needs to be set to `null`. The instant and sequence
     * number for the `GSLogRecord` is optional, as is the thread ID.</p>
     * <p>
     * For warning messages, a `Thrown` object can be present. Not all warnings
     * will involve an `Exception` having been thrown, but if one was, it can be
     * added to the `GSLogRecord` to provide more details for the log message.</p>
     *
     * @param record the `GSLogRecord` of the message and message details.
     */
    public void warn(GSLogRecord record);
    
    /**
     * Log files are typically named, "${Application.id} - ${className}.log". 
     * However, with the way that `GSLogger`s are initialized via `ServiceLoader`,
     * the `className` cannot be present during construction of the loader, so
     * log files end up being named "${Application.id} - null.log". Once the
     * `GSLogger` is constructed and the class name is set, then a call to 
     * `updateLogName()` will rename the log file to the appropriate name.
     */
    public void updateLogName();

}
