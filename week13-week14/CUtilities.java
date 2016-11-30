// ----------------------------------------------------------------------
// Name: CUtilities
// Abstract: a collection of useful procedures
// Version: #1 for Homework 8
// ----------------------------------------------------------------------


// ----------------------------------------------------------------------
// Imports
// ----------------------------------------------------------------------
import java.text.*;			// DateFormat, SimpleDateFormat
import java.util.*;			// Date
import java.io.*;			// BufferedReader

import java.awt.*;			// Basic windows functionality
import java.awt.event.*;	// Event processing
import javax.swing.*;		// Supplemental windows functionality


// ----------------------------------------------------------------------
// Name: CUtilities
// Abstract: Some general purpose utilities
// ----------------------------------------------------------------------
public class CUtilities
{
	
	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------
	// Constants
	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------
	private static final String m_strLOG_FILE_EXTENSION = ".log";
	
	// days * hours * minutes * seconds * milliseconds
	private static final long lng10_DAYS = 10 * 24 * 60 * 60 * 1000; 


	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------
	// Properties( never make public )
	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------
	private static String m_strOldLogFileAndPath = "";
	private static BufferedWriter m_buwLogFile = null;
	

	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------
	// Methods
	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------


	// ----------------------------------------------------------------------
	// Name: CenterScreen
	// Abstract: Center the dialog in the screen
	// ----------------------------------------------------------------------
	public static void CenterScreen( JDialog dlgTarget )
	{
		try
		{
			Point pntCenter;
			int intTop = 0;
			int intLeft = 0;

			// Get center of screen
			pntCenter = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
			
			// Top/Left Coordinates
			intTop = (int) pntCenter.y - ( dlgTarget.getHeight( ) / 2 );
			intLeft = (int) pntCenter.x - ( dlgTarget.getWidth( ) / 2 );

			// Center Target
			dlgTarget.setLocation( intLeft, intTop );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}



	// ----------------------------------------------------------------------
	// Name: CenterScreen
	// Abstract: Center the frame in the screen
	// ----------------------------------------------------------------------
	public static void CenterScreen( JFrame fraTarget )
	{
		try
		{
			Point pntCenter;
			int intTop = 0;
			int intLeft = 0;

			// Get center of screen
			pntCenter = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
			
			// Top/Left Coordinates
			intTop = (int) pntCenter.y - ( fraTarget.getHeight( ) / 2 );
			intLeft = (int) pntCenter.x - ( fraTarget.getWidth( ) / 2 );

			// Center Target
			fraTarget.setLocation( intLeft, intTop );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}


	// ----------------------------------------------------------------------
	// Name: CenterOwner
	// Abstract: Center the dialog over the owner.
	// ----------------------------------------------------------------------
	public static void CenterOwner( JDialog dlgTarget )
	{
		try
		{
			int intTop = 0;
			int intLeft = 0;

			// Get owner
			Window winOwner = dlgTarget.getOwner( );
			
			// Get owner location
			Rectangle recOwner = winOwner.getBounds( );
			
			// Center child
			intTop = (int) recOwner.getCenterY( ) - ( dlgTarget.getHeight( ) / 2 );
			intLeft = (int) recOwner.getCenterX( ) - ( dlgTarget.getWidth( ) / 2 );

			// Center child
			dlgTarget.setLocation( intLeft, intTop );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}


	// ----------------------------------------------------------------------
	// Name: CenterOwner
	// Abstract: Center the frame over the owner.
	// ----------------------------------------------------------------------
	public static void CenterOwner( JFrame fraTarget )
	{
		try
		{
			int intTop = 0;
			int intLeft = 0;

			// Get owner
			Window winOwner = fraTarget.getOwner( );
			
			// Get owner location
			Rectangle recOwner = winOwner.getBounds( );

			intTop = (int) recOwner.getCenterY( ) - ( fraTarget.getHeight( ) / 2 );
			intLeft = (int) recOwner.getCenterX( ) - ( fraTarget.getWidth( ) / 2 );

			// Center child
			fraTarget.setLocation( intLeft, intTop );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}



	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------
	// WriteLog
	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------
	/*
	 * What is WriteLog?  It's a procedure that will write an exception or
	 * string to a disk file.  The file is named with the current date using
	 * yyyymmdd format (so it sorts correctly).  The file is created in a Log
	 * directory off of the current working director (usually where the executable
	 * was launched from).
	 * 
	 * Why use WriteLog?  Because when, not if, the user gets an error you 
	 * (the programmer) are going to need the error information to be able
	 * to find and fix the bug in a reasonable period of time.  The exception
	 * will tell you where the error happened and, if you're lucky, why it
	 * happened.
	 * 
	 * How to use?  Wrap procedure code in a try/catch block and put
	 * a call to WriteLog in the catch block.  You really can't do much else
	 * at that point because you don't know why the error happened.  If you
	 * expect an error you should code for it.  So this is only for errors
	 * you don't expect and don't know about.
	 * 
	 * When to use?  When, not if, the technical support phone rings, what 
	 * percentage of the time do you want the exception information to help
	 * you find and fix the problem?  I want it 100%.  That means I have
	 * to use try/catch block with WriteLog in 100% of my procedures.
	 * 
	 * Guidelines for try/catch:
	 * 1) Use in all procedures
	 * 2) ALL code goes in the try block with two exceptions.  If it's a function
	 *    the return variable, and only the return variable, is declared 
	 *    immediately before the try block and the return is immediately
	 *    after the catch block.
	 * 3) Do as little as possible in the catch block so that you don't
	 *    cause another exception.
	 * 4) Use only one try/catch block per procedure.  If you expect
	 *    an error then code for it.  Don't use an empty catch block as
	 *    a crutch to ignore the error.
	 */

	// ----------------------------------------------------------------------
	// Name: WriteLog
	// Abstract: Write to the log file and display a warning to the user.
	// ----------------------------------------------------------------------
	public static void WriteLog( Exception excError )
	{
		try
		{
			boolean blnDisplay = true;
			
			WriteLog( excError, blnDisplay );
		}
		catch( Exception expWriteLogError )
		{
			// Display Error Message
			expWriteLogError.printStackTrace( );
		}
	}
		

	// ----------------------------------------------------------------------
	// Name: WriteLog
	// Abstract: Write to the log file and display a warning to the user.
	// ----------------------------------------------------------------------
	public static void WriteLog( String strMessage )
	{
		try
		{
			boolean blnDisplay = true;
			
			WriteLog( strMessage, blnDisplay );
		}
		catch( Exception excError )
		{
			// Display Error Message
			excError.printStackTrace( );
		}
	}
	

	// ----------------------------------------------------------------------
	// Name: WriteLog
	// Abstract: Write to the log file and optionally display a warning 
	//			to the user.
	// ----------------------------------------------------------------------
	public static void WriteLog( Exception excError, boolean blnDisplay )
	{
		try
		{
			String strMessage = "";
			int intIndex = 0;

			// Get the stack trace messages from the exception class
			StackTraceElement asteStackTrace[] = excError.getStackTrace( );
			
			// Loop through all the procedure calls
			for( intIndex = asteStackTrace.length - 1; intIndex >= 0; intIndex-- )
			{ 
				// Is there a line number?
				if( asteStackTrace[ intIndex ].toString( ).contains( ":" ) == true )
				{
					// Yes, so that means it's one of our classes so add it to the message
					strMessage += asteStackTrace[ intIndex ].toString( ) + "\n\t";
				}
			}
			
			// Remove trailing tab
			strMessage = strMessage.substring( 0, strMessage.length( ) - 1 );
			
			// Add the message
			strMessage += excError.getMessage();
			
			WriteLog( strMessage, blnDisplay );
		}
		catch( Exception expWriteLogError )
		{
			// Display Error Message
			expWriteLogError.printStackTrace( );
		}
	}

	

	// ----------------------------------------------------------------------
	// Name: WriteLog
	// Abstract: Write to the log file and optionally display a warning 
	//			to the user.
	// ----------------------------------------------------------------------
	public static void WriteLog( String strMessage, boolean blnDisplay )
	{
		try
		{
			BufferedWriter buwLogFile = null;
			String astrMessageLines[] = null;
			int intIndex = 0;
			
			// yyyy/mm/dd
			SimpleDateFormat sdfYearMonthDayTime = new SimpleDateFormat( "yyyy/MM/dd hh:mm:ss" );
			
			String strNow = sdfYearMonthDayTime.format( new Date( ) );
			
			// Display the error message?
			if( blnDisplay == true )
			{
				// No, warn the user
				JOptionPane.showMessageDialog( null, strMessage, "WriteLog", JOptionPane.OK_OPTION );
			}
			
			// Append a date/time stamp
			strMessage = strNow + " - " + strMessage + "\n";
			
			// Get a log file
			buwLogFile = GetLogFile( );
			
	    	// Is the file OK?	
			if( buwLogFile != null )
			{
				// Yes, so log message( use newline function to ensure cross-platform compatibility )
				astrMessageLines = strMessage.split( "\n" );
				for( intIndex = 0; intIndex < astrMessageLines.length; intIndex++ )
				{
					buwLogFile.write( astrMessageLines[ intIndex ] );
					buwLogFile.newLine( );
				}
				// Flush buffer
				buwLogFile.flush( );
			}
		}
		catch( Exception excError )
		{
			// Display Error Message
			excError.printStackTrace( );
		}
	}


	// ----------------------------------------------------------------------
	// Name: GetLogFile
	// Abstract: Open the log file for writing.  Use today's date as part of
	//           the file name.  Each day a new log file will be created.
	//           Makes debug easier.
	// ----------------------------------------------------------------------
	private static BufferedWriter GetLogFile( )
	{
		try
		{
			// yyyy/mm/dd
			SimpleDateFormat sdfYearMonthDay = new SimpleDateFormat( "yyyyMMdd" );
			String strToday = sdfYearMonthDay.format( new Date( ) );
			String strLogFileDirectory = "";
			String strLogFileAndPath = "";
			File filLogDirectory = null; 
	
		    // Log everything in a log directory off of the current application directory
		    strLogFileDirectory = System.getProperty( "user.dir" ) + "\\Log\\";
		    strLogFileAndPath = strLogFileDirectory + strToday + m_strLOG_FILE_EXTENSION;
		    
		    // Is this a new day/log file?
		    if( m_strOldLogFileAndPath != strLogFileAndPath )
		    {
		        // Create the log directory if it doesn't exist
			    filLogDirectory = new File( strLogFileDirectory );
		        if( filLogDirectory.exists( ) == false ) filLogDirectory.mkdir( );
		        	
		        // Save the log file name
		        m_strOldLogFileAndPath = strLogFileAndPath;
		            
		        // Close file if it exists( not first time )
		        if( m_buwLogFile != null ) m_buwLogFile.close( );
	
		        // Open file and append
				m_buwLogFile = new BufferedWriter( new FileWriter( strLogFileAndPath, true ) );
		        
		        // Delete old log files
		        DeleteOldLogFiles( );
			}
		}
		catch( Exception excError )
		{
			// Display Error Message
			excError.printStackTrace( );
		}
		
		// Return result
		return m_buwLogFile;
	}


	// ----------------------------------------------------------------------
	// Name: DeleteOldLogFiles
	// Abstract:  Delete any log files old than 10 days.
	// ----------------------------------------------------------------------
	private static void DeleteOldLogFiles( )
	{
		try
		{
			String strLogFileDirectory = "";
			File filLogDirectory = null;
			File afilLogFiles[] = null;
			int intIndex = 0;
			File filLogFile = null;
			long lngMilliSecondsOld = 0;
			Date dtmLastModified = null;
					
			// Log file directory
		    strLogFileDirectory = System.getProperty( "user.dir" ) + "\\Log\\";
			filLogDirectory = new File( strLogFileDirectory );	    
			
		    // Look for any log files
		    afilLogFiles = filLogDirectory.listFiles( );
		    
			// Check the date of each file
			for( intIndex = 0; intIndex < afilLogFiles.length; intIndex++ )
			{
				// Next log file
				filLogFile = afilLogFiles[ intIndex ];
	
				// Is this a log file?
				if( ( filLogFile.getName( ) ).endsWith( m_strLOG_FILE_EXTENSION ) == true )
				{
					// When was the file last modified?
					lngMilliSecondsOld = filLogFile.lastModified( );
					
					// Add 10 days and make a date
					lngMilliSecondsOld += lng10_DAYS;
					dtmLastModified = new Date( lngMilliSecondsOld );
					
					// Is the file older than 10 days?
					if( dtmLastModified.before( new Date( ) ) == true )
					{
						// Yes.  Delete it
						filLogFile.delete( );
					}
				}
			}
		}
		catch( Exception excError )
		{
			// Display Error Message
			excError.printStackTrace( );
		}
	}

}

