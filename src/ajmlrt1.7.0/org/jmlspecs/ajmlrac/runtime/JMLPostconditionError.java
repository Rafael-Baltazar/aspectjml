// @(#)$Id: JMLPostconditionError.java,v 1.5 2006/06/07 02:11:03 f_rioux Exp $
//
// Copyright (C) 2005 Iowa State University
//
// This file is part of the runtime library of the Java Modeling Language.
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public License
// as published by the Free Software Foundation; either version 2.1,
// of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with JML; see the file LesserGPL.txt.  If not, write to the Free
// Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
// 02110-1301  USA.

package org.jmlspecs.ajmlrac.runtime;


/**
 * A JML error class to notify postcondition violations.
 *
 * @author Henrique Rebelo
 * @version $Revision: 1.2 $
 */
public abstract class JMLPostconditionError extends JMLAssertionError {

	/**
	 * Creates a new instance from the given assertion message error. 
	 */
	protected JMLPostconditionError(String message) {
		super(message);
	}
	
	/**
	 * Creates a new instance from the given assertion message error. 
	 */
	protected JMLPostconditionError(String message, String methodName) {
		super(message);
		this.methodName = methodName;
	}
	
	protected JMLPostconditionError(Throwable cause) {
		super(cause);
	}
}
