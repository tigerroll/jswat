/*********************************************************************
 *
 *      Copyright (C) 1999-2005 Nathan Fiedler
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 *
 * $Id: AmbiguousMethodException.java 1814 2005-07-17 05:56:32Z nfiedler $
 *
 ********************************************************************/

package com.bluemarsh.jswat.breakpoint;

/**
 * AmbiguousMethodException is thrown when the user gives a method name
 * that has more than one match.
 *
 * @author  Nathan Fiedler
 */
public class AmbiguousMethodException extends Exception {
    /** silence the compiler warnings */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a AmbiguousMethodException with no message.
     */
    public AmbiguousMethodException() {
        super();
    } // AmbiguousMethodException

    /**
     * Constructs a AmbiguousMethodException with the given message.
     *
     * @param  s  Message.
     */
    public AmbiguousMethodException(String s) {
        super(s);
    } // AmbiguousMethodException
} // AmbiguousMethodException
