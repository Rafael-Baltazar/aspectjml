/*
 * Copyright (C) 2000-2001 Iowa State University
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
 * $Id: JmlTypeOfExpression.java,v 1.8 2002/12/14 03:06:19 cheon Exp $
 */

package org.jmlspecs.checker;

import org.multijava.mjc.*;
import org.multijava.util.compiler.PositionedError;
import org.multijava.util.compiler.TokenReference;

/**
 * JmlTypeOfExpression.java
 *
 * @author Curtis Clifton
 * @version $Revision: 1.8 $
 */

public class JmlTypeOfExpression extends JmlSpecExpressionWrapper {

    //---------------------------------------------------------------------
    // CONSTRUCTORS 
    //---------------------------------------------------------------------
    public JmlTypeOfExpression( TokenReference where, 
				JmlSpecExpression specExpression ) {
	super( where, specExpression );
    }
    
    //---------------------------------------------------------------------
    // ACCESSORS
    //---------------------------------------------------------------------

    public CType getType() {
	return JmlStdType.TYPE;
    }

    /** Return a type suitable for declaring a variable that can hold
     * the result of evaluating this expression at runtime. This
     * method is used by the runtime assertion checker to declare
     * temporary variables. 
     *
     * <pre><jml>
     * also
     * ensures \result == CStdType.Class;
     * </jml></pre>
     **/
    public CType getApparentType() {
        return CStdType.Class;
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

    /**
     * Typechecks the expression and mutates the context to record
     * information gathered during typechecking.
     *
     * @param context the context in which this expression appears
     * @return a desugared Java expression
     * @exception PositionedError if the check fails */
    public JExpression typecheck( CExpressionContextType context ) 
	throws PositionedError 
    {
	//@ assert specExpression != null;
	specExpression = 
	    (JmlSpecExpression) specExpression.typecheck( context );

        // The following check should come after the typechecking of
        // specExpression as it is during the typechecking that
        // instances of JNameExpression are resolved into
        // JTypeNameExpression.
        check(context, 
              !(specExpression.expression() instanceof JTypeNameExpression),
              JmlMessages.TYPE_NAME_IN_TYPE_OF_EXPRESSION);
	return this;
    }

    //---------------------------------------------------------------------
    // CODE GENERATION
    //---------------------------------------------------------------------

    /**
     * Accepts the specified visitor.
     * @param p	the visitor
     */
    public void accept( MjcVisitor p ) {
	if (p instanceof JmlVisitor)
	    ((JmlVisitor)p).visitJmlTypeOfExpression(this);
	else
	    throw new UnsupportedOperationException(JmlNode.MJCVISIT_MESSAGE);
    }

    //---------------------------------------------------------------------
    // PRIVILEGED DATA
    //---------------------------------------------------------------------

}
