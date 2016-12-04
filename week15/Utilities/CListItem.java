// ----------------------------------------------------------------------
// Name: Pat Callahan
// Class: CListItem
// ----------------------------------------------------------------------


// ----------------------------------------------------------------------
// Package
// ----------------------------------------------------------------------
package Utilities;


// ----------------------------------------------------------------------
// Imports
// ----------------------------------------------------------------------

// ----------------------------------------------------------------------
// Name: CListItem
// Abstract: Hold a name and a value
// ----------------------------------------------------------------------
public class CListItem
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
	private int m_intValue = 0;
	private String m_strName = "";
	

	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------
	// Methods
	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------


	// ----------------------------------------------------------------------
	// Name: CListItem
	// Abstract: Constructor
	// ----------------------------------------------------------------------
	public CListItem( )
	{
		this( 0, "" );

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
	// Name: CListItem
	// Abstract: Constructor
	// ----------------------------------------------------------------------
	public CListItem( int intValue, String strName )
	{
		try
		{	
			Initialize( intValue, strName );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}
	

	// ----------------------------------------------------------------------
	// Name: Initialize
	// Abstract: Initialize all the class level properties
	// ----------------------------------------------------------------------
	public void Initialize( int intValue, String strName )
	{
		try
		{	
			SetValue( intValue );
			SetName( strName );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}
	

	// ----------------------------------------------------------------------
	// Name: SetName
	// Abstract: Set the Name
	// ----------------------------------------------------------------------
	public void SetName( String strName )
	{
		try
		{	
			m_strName = strName;
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}

	// ----------------------------------------------------------------------
	// Name: GetName
	// Abstract: Get the Name
	// ----------------------------------------------------------------------
	public String GetName( )
	{
		try
		{	

		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return m_strName;
	}

	// ----------------------------------------------------------------------
	// Name: SetValue
	// Abstract: Set the value
	// ----------------------------------------------------------------------
	public void SetValue( int intValue )
	{
		try
		{	
			m_intValue = intValue;
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}

	// ----------------------------------------------------------------------
	// Name: GetValue
	// Abstract: Get the value
	// ----------------------------------------------------------------------
	public int GetValue( )
	{
		try
		{	

		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}

		return m_intValue;
	}

	// ----------------------------------------------------------------------
	// Name: toString
	// Abstract: Get the Name
	// ----------------------------------------------------------------------
	public String toString( )
	{
		try
		{	

		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}

		return m_strName;
	}

}

