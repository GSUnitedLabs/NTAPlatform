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
 *  Class      :   HTMLEncoder.java
 *  Author     :   Sean Carrick
 *  Created    :   Oct 31, 2021 @ 8:01:48 AM
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
package com.gs.nta.bugs;

/**
 *
 * @author Sean Carrick &lt;sean at gs-unitedlabs dot com&gt;
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class HTMLEncoder {

    private HTMLEncoder () {
        // not used
    }
    
    public static String encodeToHTML(String source) {
        char[] chars = source.toCharArray();
        String encoded = "";
        
        for (char c : chars) {
            switch (c) {
                case ' ':
                    encoded += "%20";
                    break;
                case '!':
                    encoded += "%21";
                    break;
                case '"':
                    encoded += "%22";
                    break;
                case '#':
                    encoded += "%23";
                    break;
                case '$':
                    encoded += "%24";
                    break;
                case '%':
                    encoded += "%25";
                    break;
                case '&':
                    encoded += "%26";
                    break;
                case '\'':
                    encoded += "%27";
                    break;
                case '(':
                    encoded += "%28";
                    break;
                case ')':
                    encoded += "%29";
                    break;
                case '*':
                    encoded += "%2A";
                    break;
                case '+':
                    encoded += "%2B";
                    break;
                case '-':
                    encoded += "%2D";
                    break;
                case '.':
                    encoded += "%2E";
                    break;
                case '/':
                    encoded += "%2F";
                    break;
                case ':':
                    encoded += "%3A";
                    break;
                case ';':
                    encoded += "%3B";
                    break;
                case '<':
                    encoded += "%3C";
                case '=':
                    encoded += "%3D";
                    break;
                case '>':
                    encoded += "%3E";
                    break;
                case '?':
                    encoded += "%3F";
                    break;
                case '@':
                    encoded += "%40";
                    break;
                case '[':
                    encoded += "%5B";
                    break;
                case '\\':
                    encoded += "%5C";
                    break;
                case ']':
                    encoded += "%5D";
                    break;
                case '^':
                    encoded += "%5E";
                    break;
                case '_':
                    encoded += "%5F";
                    break;
                case '`':
                    encoded += "%60";
                    break;
                case '~':
                    encoded += "%7E";
                    break;
                case ',':
                    encoded += "%82";
                    break;
                case '\n':
                    encoded += "%0D";
                    break;
                case '\t':
                    encoded += "%09";
                    break;
                default:
                    encoded += String.valueOf(c);
                    break;
            }
        }
        
        return encoded;
    }

}
