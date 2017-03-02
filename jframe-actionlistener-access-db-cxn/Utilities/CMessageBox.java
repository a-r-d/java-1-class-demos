// ----------------------------------------------------------------------
// Name: CMessageBox
// Class: A wrapper for the JOptionPane stuff to emulate the wonderful
//		MessageBox functionality of VB.Net.
//
// Version		Changed By	Notes
// 2014/06/22	P.C.		v1.0 Initial Release
// 2014/06/24	P.C.		v1.1 - Changed enums to static
// 2014/07/11	P.C.		v1.2 - Minor fix to Show.  Was using null instead of conParent.
//
//
// How to use/call:
//
// 1) Plain message, no icon with OK button
//
//		CMessageBox.Show( this, "Message", "Caption" );
//
// 2) Message with ? icon with OK button
//
//		CMessageBox.Show( this, "Message", "Caption", enuIconType.Question );
//
// 3) Message with ? icon with Yes/No buttons
//
//		intResult = CMessageBox.Show( this, "Message", "Caption", 
//									  enuIconType.Question, enuButtonType.YES_NO );
//
//		if( intResult = CMessageBox.intRESULT_YES ) 
//		{ 
//			<Your code here> 
//		}
//
// 4) Confirmation dialog dialog with ? icon with Yes/No buttons
//
//		intResult = CMessageBox.Confirm( this, "Message", "Caption" );
//
// ----------------------------------------------------------------------


// ----------------------------------------------------------------------
// Package
// ----------------------------------------------------------------------
package Utilities;


// ----------------------------------------------------------------------
// Imports
// ----------------------------------------------------------------------
import javax.swing.*;			// JOptionPane
import java.awt.Component;


// ----------------------------------------------------------------------
// Name: CMessageBox
// Abstract: VB.Net Message Box emulator
// ----------------------------------------------------------------------
public class CMessageBox
{
	
	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------
	// Constants
	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------
	public static final int intRESULT_OK		= JOptionPane.OK_OPTION;
	public static final int intRESULT_CANCEL	= JOptionPane.CANCEL_OPTION;
	public static final int intRESULT_YES		= JOptionPane.YES_OPTION;
	public static final int intRESULT_NO		= JOptionPane.NO_OPTION;


	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------
	// Properties( never make public )
	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------
	

	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------
	// Methods
	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------


	// -------------------------------------------------------------------------
	// Name: Show
	// Abstract: Show a plain (no icon) message box with message and caption
	// -------------------------------------------------------------------------
	public static void Show( String strMessage, String strCaption )
	{
		try
		{
			Show( null, strMessage, strCaption, enuIconType.Plain );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}


	// -------------------------------------------------------------------------
	// Name: Show
	// Abstract: Show a plain (no icon) message box with message and caption
	// -------------------------------------------------------------------------
	public static void Show( Component comParent, String strMessage, String strCaption )
	{
		try
		{
			Show( comParent, strMessage, strCaption, enuIconType.Plain );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}


	// -------------------------------------------------------------------------
	// Name: enuIconType
	// Abstract: Put a wrapper around the icon types for JOptionPane so we
	//		don't have to sort through a longer list trying to figure out
	//		what icons are available for use.
	// -------------------------------------------------------------------------
	public static enum enuIconType
	{
		Plain(JOptionPane.PLAIN_MESSAGE),				// Nothing	
		Information(JOptionPane.INFORMATION_MESSAGE),	// |
		Question(JOptionPane.QUESTION_MESSAGE),			// ?
		Warning(JOptionPane.WARNING_MESSAGE),			// !
		Error(JOptionPane.ERROR_MESSAGE);				// X

		private int m_intIconType;
		
		private enuIconType(int intIconType)
		{
			m_intIconType = intIconType;
		}		
		public int GetCode( )
		{
			return m_intIconType;
		}		
	}


	// -------------------------------------------------------------------------
	// Name: Show
	// Abstract: Show a message box with message and caption and a decorative icon
	// -------------------------------------------------------------------------
	public static void Show( Component comParent, String strMessage, 
							 String strCaption, enuIconType enuIcon )
	{
		try
		{
			// Message Types (decorative icon):
			//		    PLAIN_MESSAGE 					// Nothing
			//		    INFORMATION_MESSAGE				// |
			//		    QUESTION_MESSAGE				// ?
			//		    WARNING_MESSAGE					// !
			//		    ERROR_MESSAGE					// X
			
			// Message type determines what type of icon (e.g. ? or !) is displayed to the
			// left of the message.  

			Show( comParent, strMessage, strCaption, enuIcon, enuButtonType.OK );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}

	
	// -------------------------------------------------------------------------
	// Name: enuButtonType
	// Abstract: Put a wrapper around the button types for JOptionPane so we
	//		don't have to sort through a longer list trying to figure out
	//		what buttons are available for use.
	// -------------------------------------------------------------------------
	public static enum enuButtonType
	{
		OK(JOptionPane.DEFAULT_OPTION),
		OK_CANCEL(JOptionPane.OK_CANCEL_OPTION),
		YES_NO(JOptionPane.YES_NO_OPTION),
		YES_NO_CANCEL(JOptionPane.YES_NO_CANCEL_OPTION);

		private int m_intButtonType;
		
		private enuButtonType(int intButtonType)
		{
			m_intButtonType = intButtonType;
		}		
		public int GetCode( )
		{
			return m_intButtonType;
		}		
	}


	// -------------------------------------------------------------------------
	// Name: Show
	// Abstract: Show a message box with message and caption and a decorative icon
	// -------------------------------------------------------------------------
	public static int Show( Component comParent, String strMessage, String strCaption, 
				            enuIconType enuIcon, enuButtonType enuButtons )
	{
		int intResult = 0;
		
		try
		{
			
			// Option Type, Message Type, Icon
			// Option Types:
			//		    YES_OPTION
			//		    YES_NO_OPTION
			//		    YES_NO_CANCEL_OPTION
			//		    OK_CANCEL_OPTION 
			
			// Parent Container, Message, Title/Caption, Option Type, Message Type (decorative icon)
			intResult = JOptionPane.showConfirmDialog( comParent, strMessage, strCaption, 
										   			   enuButtons.GetCode( ), enuIcon.GetCode( ) );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return intResult;
	}
	

	// -------------------------------------------------------------------------
	// Name: Confirm
	// Abstract: Default to Yes/No buttons and question icon.
	// -------------------------------------------------------------------------
	public static int Confirm( Component comParent, String strMessage, String strCaption )
	{
		int intResult = 0;
		
		try
		{
			intResult = Confirm( comParent, strMessage, strCaption, enuButtonType.YES_NO );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return intResult;
	}
	

	// -------------------------------------------------------------------------
	// Name: Confirm
	// Abstract: Default to Yes/No buttons and question icon.
	// -------------------------------------------------------------------------
	public static int Confirm( Component comParent, String strMessage, String strCaption,
							   enuButtonType enuButtons )
	{
		int intResult = 0;
		
		try
		{
			intResult = Show( comParent, strMessage, strCaption, 
							  enuIconType.Question, enuButtons );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return intResult;
	}
	
}

