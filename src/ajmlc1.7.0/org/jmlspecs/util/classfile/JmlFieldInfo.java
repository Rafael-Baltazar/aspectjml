/*
 * Copyright (C) 2003 Iowa State University
 *
 * This file is part of JML
 *
 * JML is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 *
 * JML is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with JML; see the file COPYING.  If not, write to
 * the Free Software Foundation, 675 Mass Ave, Cambridge, MA 02139, USA.
 *
 * $Id: JmlFieldInfo.java,v 1.2 2004/04/12 22:04:18 tongjie Exp $
 */

package org.jmlspecs.util.classfile;

import java.io.*;
import org.multijava.util.classfile.*;

/**
 * A class to represent JML fields to be stored into an external JML
 * symbol file. This class support JML-specific field attributes such
 * as JML modifiers.
 *
 * @author Yoonsik Cheon
 */
public class JmlFieldInfo extends FieldInfo {

    // --------------------------------------------------------------------
    // CONSTRUCTORS
    // --------------------------------------------------------------------

    /**
     * Constructs a new instance.
     */
    public JmlFieldInfo(int modifiers,
                        String name,
                        String type,
                        Object value,
                        boolean deprecated,
                        boolean synthetic) {

        super((short) modifiers, name, type, type, value, deprecated, synthetic);
        addJmlModifiers(modifiers);
    }

    /**
     * Constructs an instance by reading bytecode from the given
     * stream <code>in</code> and referring to the constant pool
     * <code>cp</code>.
     */
    public JmlFieldInfo(/*@ non_null @*/ DataInput in, 
                     /*@ non_null @*/ ConstantPool cp)
        throws IOException, ClassFileFormatException {
        super(in, cp);
    }

    // --------------------------------------------------------------------
    // PUBLIC METHODS
    // --------------------------------------------------------------------

    /**
     * Returns the JML modifiers.
     */
    public short getJmlModifiers() {
        if (modifiers != -1) {
            return modifiers;
        }

        Attribute attr = attributes.get(Constants.ATT_JML_MODIFIERS);
        modifiers = 
            attr == null ? 0 : ((JmlModifiersAttribute)attr).jmlModifiers();
        return modifiers;
    }

    // --------------------------------------------------------------------
    // HELPERS
    // --------------------------------------------------------------------

    /**
     * Adds the JML part of the given modifiers, <code>modifiers</code>,
     * to the attribute list of this field info.
     */
    private void addJmlModifiers(int modifiers) {
        this.modifiers = (short) (modifiers >>> 16);
        if (this.modifiers != 0) {
            addAttribute(new JmlModifiersAttribute(this.modifiers));
        }
    }

    // --------------------------------------------------------------------
    // DATA MEMBERS
    // --------------------------------------------------------------------

    /** 
     * Cached JML modifiers. If the value is -1, it means the value is
     * not initialized yet. 
     */
    private short modifiers = -1;
}
