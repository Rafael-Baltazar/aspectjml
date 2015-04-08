/*
 * Copyright (C) 2007 Iowa State University
 *
 * This file is part of mjc, the MultiJava Compiler, and the JML Project.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 *
 * $Id: JmlRefiningStatement.java,v 1.3 2007/04/23 16:45:30 smshaner Exp $
 */

package org.jmlspecs.checker;

import org.multijava.mjc.CFlowControlContextType;
import org.multijava.mjc.CodeSequence;
import org.multijava.mjc.JStatement;
import org.multijava.mjc.MjcVisitor;
import org.multijava.util.compiler.JavaStyleComment;
import org.multijava.util.compiler.PositionedError;
import org.multijava.util.compiler.TokenReference;

/**
 * JmlRefiningStatement.java
 *
 * @author Steve Shaner and Gary T. Leavens
 * @version $Revision: 1.3 $
 */

public class JmlRefiningStatement extends JStatementWrapper {

    //---------------------------------------------------------------------
    // CONSTRUCTORS 
    //---------------------------------------------------------------------
    public JmlRefiningStatement( TokenReference where, 
				 JmlSpecStatement specstmt,
                                 boolean wasGencase,
                                 JStatement body,
                                 JavaStyleComment[] comments ) 
    {
	super( where, comments );
	this.wasGencase = wasGencase;
	this.specstmt = specstmt;
	this.body = body;
    }
    
    //---------------------------------------------------------------------
    // ACCESSORS
    //---------------------------------------------------------------------

    /** Returns whether the syntax was desugared from a general spec case. */
    public /*@ pure @*/ boolean wasGencase() {
	return wasGencase;
    }

    /** Returns the spec statement of this refining statement. */
    public /*@ pure @*/ JmlSpecStatement specStatement() {
	return specstmt;
    }

    /** Returns the body of this refining statement. */
    public /*@ pure @*/ JStatement body() {
	return body;
    }

    /** 
     * Returns the Java source code generated by jmlrac to execute
     * this refining statement at runtime. */
    public /*@ pure @*/ JStatement assertionCode() {
	return assertionCode;
    }

    /** 
     * Returns <code>true</code> if this refining statement has the Java
     * source code generated by jmlrac to execute it at runtime. */
    public /*@ pure @*/ boolean hasAssertionCode() {
	return assertionCode != null;
    }

    /** 
     * Sets the Java source code generated by jmlrac to execute
     * this refining statement at runtime. */
    public void setAssertionCode(JStatement code) {
	assertionCode = code;
    }

    //---------------------------------------------------------------------
    // DERIVED ATTRIBUTES
    //---------------------------------------------------------------------

    //---------------------------------------------------------------------
    // INTERFACE CHECKING
    //---------------------------------------------------------------------

    //---------------------------------------------------------------------
    // TYPECHECKING
    //---------------------------------------------------------------------

    public void typecheck( CFlowControlContextType context ) 
	throws PositionedError 
    {
        try {
	    enterSpecScope();
	    
	    specstmt.typecheck(context);
	}
	finally {
	    exitSpecScope();
	}

        body.typecheck(context);
    }
    
    //---------------------------------------------------------------------
    // CODE GENERATION
    //---------------------------------------------------------------------

    public void genCode( CodeSequence code ) {
	//fail( "code generation not implemented for set-statement" );
    }

    /**
     * Accepts the specified visitor.
     * @param p	the visitor
     */
    public void accept( MjcVisitor p ) {
	if (p instanceof JmlVisitor)
	    ((JmlVisitor)p).visitJmlRefiningStatement(this);
	else
	    throw new UnsupportedOperationException(JmlNode.MJCVISIT_MESSAGE);
    }

    //---------------------------------------------------------------------
    // PRIVILEGED DATA
    //---------------------------------------------------------------------

    private boolean wasGencase;
    private JmlSpecStatement specstmt;
    private JStatement body;

    /** Java source code generated by jmlrac to execute this set
     * statement at runtime. */
    private JStatement assertionCode;
    //@                in super.assertionCode;
}
