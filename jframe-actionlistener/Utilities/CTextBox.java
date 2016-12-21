// ----------------------------------------------------------------------
// Name: Pat Callahan
// Class: CTextBox
// ----------------------------------------------------------------------


// ----------------------------------------------------------------------
// Package
// ----------------------------------------------------------------------
package Utilities;


// ----------------------------------------------------------------------
// Imports
// ----------------------------------------------------------------------
import java.awt.event.*;			// FocusListener
import javax.swing.*;				// JEverything
import javax.swing.text.*;			// PlainDocument

// ----------------------------------------------------------------------
// Name: CTextBox
// Abstract: TextField with a maximum length
// ----------------------------------------------------------------------
@SuppressWarnings("serial")
public class CTextBox extends JTextField implements FocusListener
{
	
	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------
	// Constants
	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------
	
	
	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------
	// Properties( never make public )
	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------
	private CMaximumLengthDocument m_clsDocument = null;
	

	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------
	// Methods
	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------


	// ----------------------------------------------------------------------
	// Name: CTextBox
	// Abstract: Constructor
	// ----------------------------------------------------------------------
	public CTextBox( )
	{
		this( "", 0 );

		try
		{

		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}


	// ----------------------------------------------------------------------
	// Name: CTextBox
	// Abstract: Constructor
	// ----------------------------------------------------------------------
	public CTextBox( String strText )
	{
		this( strText, 0 );

		try
		{

		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}


	// ----------------------------------------------------------------------
	// Name: CTextBox
	// Abstract: Constructor
	// ----------------------------------------------------------------------
	public CTextBox( int intMaximumLength )
	{
		this( "", intMaximumLength );

		try
		{
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}


	// ----------------------------------------------------------------------
	// Name: CTextBox
	// Abstract: Constructor
	// ----------------------------------------------------------------------
	public CTextBox( String strText, int intMaximumLength )
	{
		// Call parent constructor		
		super( );
		try
		{
			// Document to limit text( from keyboard and paste )
			m_clsDocument = new CMaximumLengthDocument( );
			this.setDocument( m_clsDocument );
			
			// Set the maximum length
			m_clsDocument.SetMaximumLength( intMaximumLength );
			
			// Set the default text
			setText( strText );
			
			// Select all text when we get the focus
			addFocusListener( this );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}


	// ----------------------------------------------------------------------
	// Name: GetMaximumLength
	// Abstract: Get the maximum length
	// ----------------------------------------------------------------------
	public int GetMaximumLength( )
	{
		try
		{

		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}

		return m_clsDocument.GetMaximumLength( );
	}


	// ----------------------------------------------------------------------
	// Name: SetMaximumLength
	// Abstract: Set the maximum length
	// ----------------------------------------------------------------------
	public void SetMaximumLength( int intMaximumLength )
	{
		try
		{
			m_clsDocument.SetMaximumLength( intMaximumLength );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}





	// ----------------------------------------------------------------------
	// Name: CMaximumLengthDocument
	// Abstract: Extend the PlainDocument class to limit text.
	// ----------------------------------------------------------------------
	public class CMaximumLengthDocument extends PlainDocument
	{
		
		// ----------------------------------------------------------------------
		// ----------------------------------------------------------------------
		// Constants
		// ----------------------------------------------------------------------
		// ----------------------------------------------------------------------
		private static final long serialVersionUID = 1L;

		
		// ----------------------------------------------------------------------
		// ----------------------------------------------------------------------
		// Properties( never make public )
		// ----------------------------------------------------------------------
		// ----------------------------------------------------------------------
		private int m_intMaximumLength = 0;
		
	
		// ----------------------------------------------------------------------
		// ----------------------------------------------------------------------
		// Methods
		// ----------------------------------------------------------------------
		// ----------------------------------------------------------------------
	
	
		// ----------------------------------------------------------------------
		// Name: insertString
		// Abstract: Insert a string into the document.
		// ----------------------------------------------------------------------
		public void insertString( int intOffset, String strInput, AttributeSet asInput )
		{
			try
			{
				String strOldString = "";
				String strNewString = "";
				
				// Anything being input?
				if( strInput != null ) 
				{          
			        // Get the old string
			        strOldString = this.getText( 0, getLength( ) );
			        
					// Build a complete string with the old and the new
					strNewString = strOldString.substring( 0, intOffset ) + 
									strInput + 
									strOldString.substring( intOffset );
							
					// Is the new string OK?			
					if( IsValidString( strNewString ) == true ) 
					{        
						// Yes, so let the parent class handle it  
						super.insertString( intOffset, strInput, asInput );
					}
				}
			}
			catch( Exception excError )
			{
				// Display Error Message
				CUtilities.WriteLog( excError );
			}
		}
		
		// ----------------------------------------------------------------------
		// Name: IsValidString
		// Abstract: Is the input string valid?
		// ----------------------------------------------------------------------
		public boolean IsValidString( String strNewString ) 
		{
			boolean blnIsValidString = false;
		
			try
			{
				// Is the new string short enough?  
				if( m_intMaximumLength == 0 || 
					m_intMaximumLength >= strNewString.length( ) ) blnIsValidString = true;
			}
			catch( Exception excError )
			{
				// Display Error Message
				CUtilities.WriteLog( excError );
			}
			
			// Return result
			return blnIsValidString;
		}


		// ----------------------------------------------------------------------
		// Name: GetMaximumLength
		// Abstract: Get the maximum length
		// ----------------------------------------------------------------------
		public int GetMaximumLength( )
		{
			try
			{

			}
			catch( Exception excError )
			{
				// Display Error Message
				CUtilities.WriteLog( excError );
			}

			return m_intMaximumLength;
		}

		// ----------------------------------------------------------------------
		// Name: SetMaximumLength
		// Abstract: Set the maximum length
		// ----------------------------------------------------------------------
		public void SetMaximumLength( int intMaximumLength )
		{
			try
			{
				// Range check
				if( intMaximumLength < 0 ) intMaximumLength = 0;
				if( intMaximumLength > 32767 ) intMaximumLength = 32767;
				
				m_intMaximumLength = intMaximumLength;
			}
			catch( Exception excError )
			{
				// Display Error Message
				CUtilities.WriteLog( excError );
			}
		}
	
	}
	
	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------
	// FocusListener
	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------

	// ----------------------------------------------------------------------
	// Name: focusGained
	// Abstract: Select all the text
	// ----------------------------------------------------------------------
	public void focusGained( FocusEvent feSource )
	{
		try
		{
			// Select all the text
			this.setSelectionStart( 0 );
			this.setSelectionEnd( getText( ).length( ) );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}
	// Don't care
    public void focusLost( FocusEvent feSource ) { }
 }


