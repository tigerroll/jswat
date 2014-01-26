/*********************************************************************
 *
 *      Copyright (C) 2001 Nathan Fiedler
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
 * PROJECT:     JSwat
 * MODULE:      JSwat UI
 * FILE:        UIAdapter.java
 *
 * AUTHOR:      Nathan Fiedler
 *
 * REVISION HISTORY:
 *      Name    Date            Description
 *      ----    ----            -----------
 *      nf      08/07/01        Initial version
 *
 * DESCRIPTION:
 *      The user interface adapter interface.
 *
 * $Id: UIAdapter.java 629 2002-10-26 23:03:26Z nfiedler $
 *
 ********************************************************************/

package com.bluemarsh.jswat.ui;

import com.bluemarsh.jswat.Session;
import com.bluemarsh.jswat.SourceSource;
import com.bluemarsh.jswat.view.JSwatView;

/**
 * Interface UIAdapter connects the Session with the user interface
 * of JSwat. It builds out the major interface components, connects
 * them to the Session and managers, and handles most user input.
 *
 * @author  Nathan Fiedler
 */
public interface UIAdapter {

    /**
     * Construct the appropriate user interface and connect all
     * the pieces together. The result should be a fully
     * functional interface that is ready to be used.
     */
    public void buildInterface();

    /**
     * Indicate if this interface adapter has the ability to find
     * a string in the currently selected source view.
     *
     * @return  true if the ability exists, false otherwise.
     */
    public boolean canFindString();

    /**
     * Indicate if this interface adapter has the ability to show
     * source files in a manner appropriate for the user to read.
     *
     * @return  true if the ability exists, false otherwise.
     */
    public boolean canShowFile();

    /**
     * Indicate if this interface adapter has the ability to show
     * the status in a manner appropriate for the user to view.
     *
     * @return  true if the ability exists, false otherwise.
     */
    public boolean canShowStatus();

    /**
     * Deconstruct the user interface such that all components
     * are made invisible and prepared for non-use.
     */
    public void destroyInterface();

    /**
     * This is called when there are no more open Sessions. The
     * adapter should take the appropriate action at this time.
     * In most cases that will be to exit the JVM.
     */
    public void exit();

    /**
     * Search for the given string in the currently selected source view.
     * The search should continue from the last successful match, and
     * wrap around to the beginning when the end is reached.
     *
     * @param  query       string to look for.
     * @param  ignoreCase  true to ignore case.
     * @return  true if string was found.
     * @exception  NoOpenViewException
     *             Thrown if there is no view to be searched.
     */
    public boolean findString(String query, boolean ignoreCase)
        throws NoOpenViewException;

    /**
     * Searches for the property with the specified key in the property
     * list. The method returns null if the property is not found.
     *
     * @param  key  the property key.
     * @return  the value in the property list with the specified key value.
     */
    public Object getProperty(String key);

    /**
     * Retrieves the currently active view in JSwat.
     *
     * @return  selected view, or null if none selected.
     */
    public JSwatView getSelectedView();

    /**
     * Called when the Session initialization has completed.
     */
    public void initComplete();

    /**
     * Refresh the display to reflect changes in the program.
     * Generally this means refreshing the panels.
     */
    public void refreshDisplay();

    /**
     * Save any settings to the appropriate places, the program
     * is about the terminate.
     */
    public void saveSettings();

    /**
     * Stores the given value in the properties list with the given
     * key as a reference. If the value is null, then the key and
     * value will be removed from the properties.
     *
     * @param  key    the key to be placed into this property list.
     * @param  value  the value corresponding to key, or null to remove
     *                the key and value from the properties.
     * @return  previous value stored using this key.
     */
    public Object setProperty(String key, Object value);

    /**
     * Show the given file in the appropriate view and make the
     * given line visible in that view.
     *
     * @param  src    source to be displayed.
     * @param  line   one-based line to be made visible, or zero for
     *                a reasonable default.
     * @param  count  number of lines to display, or zero for a
     *                reasonable default. Some adapters will ignore
     *                this value if, for instance, they utilize a
     *                scrollable view.
     * @return  true if successful, false if error.
     */
    public boolean showFile(SourceSource src, int line, int count);

    /**
     * Show a status message in a reasonable location.
     *
     * @param  status  message to be shown to the user.
     */
    public void showStatus(String status);
} // UIAdapter
