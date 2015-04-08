// Generated from JmlVersionOptions.opt
package org.jmlspecs.checker;

import gnu.getopt.Getopt;
import gnu.getopt.LongOpt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashSet;

/** This class is automatically generated from JmlVersionOptions.opt
 *  and contains member fields corresponding to command-line options.
 */
public class JmlVersionOptions extends org.multijava.mjc.MjcCommonOptions {

  public JmlVersionOptions(String name) {
    super(name);
  }

  public JmlVersionOptions() {
    this("JmlVersion");
  }

  public boolean processOption(int code, Getopt g) {
    switch (code) {
    default:
      return super.processOption(code, g);
    }
  }

  public boolean setOption(String name, Object newValue) {
    {
      return super.setOption(name, newValue);
    }
  }

  public HashMap getOptions() {
    HashMap result = super.getOptions();
    
    return result;
  }


  public LinkedHashSet getLongname() {
    LinkedHashSet longname = super.getLongname();

    return longname;
  }

  public Hashtable getType() {
    Hashtable type = super.getType();

    return type;
  }


  public Hashtable getDefaultValue() {
    Hashtable defaultValue = super.getDefaultValue();

    return defaultValue;
  }


  public Hashtable getCurrentValue() {
    Hashtable currentValue = super.getCurrentValue();

    return currentValue;
  }


  public Hashtable getTableHeader() {
    Hashtable tableHeader = super.getTableHeader();

    return tableHeader;
  }


  public Hashtable getSelectionList() {
    Hashtable selectionHash = super.getSelectionList();
    ArrayList selectionChoices;

    return selectionHash;
  }


  public Hashtable getHelpString() {
    Hashtable helpString = super.getHelpString();

    return helpString;
  }


  public Hashtable getGuiType() {
    Hashtable guiType = super.getGuiType();

    return guiType;
  }


  public String getShortOptions() {
    return "" + super.getShortOptions();
  }


  public String version() {
    return "Version: Common AspectJML release 1.7.0 (December 12, 2014)";
  }


  public void usage() {
    System.err.println("");
    printVersion();  }


  public void help() {
    System.err.println("");
    printOptions();
    System.err.println();
    System.err.println("This program includes some code from the Kopi project: http://www.dms.at/kopi");
    System.err.println("Some code for this program was generated with ANTLR: http://www.antlr.org");
    printVersion();
  }

  public LongOpt[] getLongOptions() {
    LongOpt[]      parent = super.getLongOptions();
    LongOpt[]      total = new LongOpt[parent.length + LONGOPTS.length];
    
    System.arraycopy(parent, 0, total, 0, parent.length);
    System.arraycopy(LONGOPTS, 0, total, parent.length, LONGOPTS.length);
    
    return total;
  }

  private static final LongOpt[] LONGOPTS = {

  };
}
