/*********************************************************************
 *
 *	Copyright (C) 2001 Nathan Fiedler
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
 * PROJECT:	JSwat
 * MODULE:	JSwat Actions
 * FILE:	ActionTable.java
 *
 * AUTHOR:      Nathan Fiedler
 *
 * REVISION HISTORY:
 *	Name	Date		Description
 *	----	----		-----------
 *	nf	08/14/01	Initial version
 *
 * DESCRIPTION:
 *	This file defines the class that holds Actions.
 *
 * $Id: ActionTable.java 629 2002-10-26 23:03:26Z nfiedler $
 *
 ********************************************************************/

package com.bluemarsh.jswat.action;

import java.util.Hashtable;
import javax.swing.Action;

/**
 * This class holds the application actions and provides access to them.
 *
 * @author  Nathan Fiedler
 */
public class ActionTable {
    /** Suffix added to command string to retrieve action classes. */
    protected static final String ACTION_SUFFIX = "Action";
    /** Table of available actions in our program. Other classes
     * can look up actions by their action string using the
     * <code>getAction()</code> method. */
    protected static Hashtable actionTable = new Hashtable();

    /**
     * Retrieves the action corresponding to the given command string.
     * This will first look in the list of actions registered with
     * ActionTable. If the action is not there, it will try to
     * instantiate the action. If successful, it adds the action
     * to the list of registered actions and returns a reference
     * to the action. Else it does nothing and returns null.
     *
     * @param  cmd  command string to find action for.
     * @return  action matching command string or null if not found.
     */
    public static Action getAction(String cmd) {
        Action a = (Action) actionTable.get(cmd);
        if (a == null) {
            // All the actions are specified in the ui package's Bundle.
            String actionName = com.bluemarsh.jswat.ui.Bundle.getString
                (cmd + ACTION_SUFFIX);
            if (actionName != null) {
                try {
                    Class actionClass = Class.forName
                        ("com.bluemarsh.jswat.action." + actionName);
                    a = (Action) actionClass.newInstance();
                    actionTable.put(a.getValue(Action.NAME), a);
                } catch (Exception e) {
                    System.err.print("ERROR: Couldn't instantiate action: ");
                    System.err.print(actionName);
                    System.err.print(": ");
                    System.err.println(e);
                }
            }
        }
        return a;
    } // getAction
} // ActionTable
