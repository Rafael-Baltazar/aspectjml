// @(#)$Id: JMLExceptionalPostconditionError.java,v 1.4 2006/06/07 02:11:02 f_rioux Exp $
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
 * A JML error class to notify exceptional postcondition violations.
 *
 * @author Henrique Rebelo
 * @version $Revision: 1.1 $
 */
public class JMLExceptionalPostconditionError extends JMLPostconditionError 
{
	
	protected Throwable racCause;
    
	/**
	 * Constructs a new instance.
	 */
	public JMLExceptionalPostconditionError(String message)
	{
		super(message);
	}

	/**
	 * Creates a new instance.
	 */
	public JMLExceptionalPostconditionError(String message, String methodName, Throwable cause)
	{
		super(message, methodName);
		this.racCause = cause;
	}

	public JMLExceptionalPostconditionError(Throwable cause) {
		super(cause);
		this.racCause = cause;
	}
	
	public Throwable getRacCause(){
		return this.racCause;
	}
}
