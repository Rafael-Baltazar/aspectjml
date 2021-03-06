//Copyright (C) 2007 Universidade De Pernambuco (UPE)

//This file is part of the runtime library of the Java Modeling Language With AspectJ.


package org.jmlspecs.ajmlrac.runtime;

/**
 * A JML error class to notify internal normal postcondition violations.
 *
 * @author Henrique Rebelo
 * @version $Revision: 1.1$
 */
public class JMLInternalPrivateExceptionalPostconditionError extends JMLInternalExceptionalPostconditionError {

	/**
	 * Creates a new instance from the given assertion message error. 
	 */
	public JMLInternalPrivateExceptionalPostconditionError(String message) {
		super(message);
	}
	
	/**
	 * Creates a new instance.
	 */
	public JMLInternalPrivateExceptionalPostconditionError(String message, String methodName, Throwable cause)
	{
		super(message, methodName, cause);
	}
	
	public JMLInternalPrivateExceptionalPostconditionError(Throwable cause) {
		super(cause);
	}
}
