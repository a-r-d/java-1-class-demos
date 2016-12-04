// ----------------------------------------------------------------------
// Name: Pat Callahan
// Class: CListBox
//			v2.1 - 2013/12/17 Selected item is blue - Douglas Heller
// ----------------------------------------------------------------------


// ----------------------------------------------------------------------
// Package
// ----------------------------------------------------------------------
package Utilities;


// ----------------------------------------------------------------------
// Imports
// ----------------------------------------------------------------------
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


// ----------------------------------------------------------------------
// Name: CListBox
// Abstract: Make a listbox class that combines the list, list model
//			and scrollbars all into one.  Add event firing too.
// ----------------------------------------------------------------------
@SuppressWarnings("serial")
public class CListBox extends javax.swing.JComponent implements MouseListener
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
	private DefaultListModel<CListItem> m_dlmListItems = null;
	private JList<CListItem> m_lstList = null;
	private JScrollPane m_scpList = null;
	
	private boolean m_blnSorted = true;				// Sort the list by default
	private boolean m_blnQuiet = false;				// fire/don't fire events
		

	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------
	// Methods
	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------


	// ----------------------------------------------------------------------
	// Name: CListBox
	// Abstract: Constructor
	// ----------------------------------------------------------------------
	public CListBox( )
	{
		super( );
		
		try
		{	
	
			Initialize( );		
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}



	// ----------------------------------------------------------------------
	// Name: Initialize
	// Abstract: Center, set the title, etc
	// ----------------------------------------------------------------------
	private void Initialize( )
	{
		try
		{	
			// Layout
			BorderLayout blDialog = new BorderLayout( );
			this.setLayout( blDialog );		

			// List model
			m_dlmListItems = new DefaultListModel<CListItem>( );
			
			// List
			m_lstList = new JList<CListItem>( m_dlmListItems );
			m_lstList.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
			m_lstList.addMouseListener( this );
			
			// Scroll Pane
			m_scpList = new JScrollPane( m_lstList );
			
			// ListItemRenderer - From Douglas Heller 2013/12/17
			m_lstList.setCellRenderer( new CListItemRenderer( ) );

			// Add to component			
			this.add( m_scpList );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}



	// ----------------------------------------------------------------------
	// Name: SetSelectionMode
	// Abstract: Single, Single Interval or Multiple Intervale.
	// ----------------------------------------------------------------------
	public void SetSelectionMode( int intNewSelectionMode )
	{
		try
		{		
			m_lstList.setSelectionMode( intNewSelectionMode );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}
	

	// ----------------------------------------------------------------------
	// Name: GetSelectionMode
	// Abstract: Single, Single Interval or Multiple Intervale.
	// ----------------------------------------------------------------------
	public int GetSelectionMode( )
	{
		int intSelectionMode = 0;
		
		try
		{		
			intSelectionMode = m_lstList.getSelectionMode( );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		// Return result
		return intSelectionMode;
	}
	

	// ----------------------------------------------------------------------
	// Name: AddItem
	// Abstract: Add an item to list and select.
	// ----------------------------------------------------------------------
	public int AddItemToList( int intValue, String strName )
	{
		int intNewItemIndex = 0;
		
		try
		{		
			CListItem clsNewItem = new CListItem( intValue, strName );

			intNewItemIndex = AddItemToList( clsNewItem, true );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		// Return result		
		return intNewItemIndex;
	}
	

	// ----------------------------------------------------------------------
	// Name: AddItem
	// Abstract: Add an item to list
	// ----------------------------------------------------------------------
	public int AddItemToList( int intValue, String strName, boolean blnSelect )
	{
		int intNewItemIndex = 0;
		
		try
		{	
			CListItem clsNewItem = new CListItem( intValue, strName );

			intNewItemIndex = AddItemToList( clsNewItem, blnSelect );			
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		// Return result		
		return intNewItemIndex;
	}


	// ----------------------------------------------------------------------
	// Name: AddItem
	// Abstract: Add an item to list and select.
	// ----------------------------------------------------------------------
	public int AddItemToList( CListItem clsNewItem )
	{
		int intNewItemIndex = 0;
		
		try
		{		
			intNewItemIndex = AddItemToList( clsNewItem, true );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		// Return result		
		return intNewItemIndex;
	}
	

	// ----------------------------------------------------------------------
	// Name: AddItem
	// Abstract: Add an item to list
	// ----------------------------------------------------------------------
	public int AddItemToList( CListItem clsNewItem, boolean blnSelect )
	{
		int intNewItemIndex = 0;
		
		try
		{	
			// Sorted?
			if( m_blnSorted == true )
			{
				// Yes, find out where it should go
				intNewItemIndex = FindSortedIndex( m_dlmListItems, clsNewItem.GetName( ) );
			}
			else
			{
				// No, add it to the end
				intNewItemIndex = m_dlmListItems.getSize( );	
			}
			
			// Insert at the specified location
			m_dlmListItems.insertElementAt( clsNewItem, intNewItemIndex );
			
			// Select?
			if( blnSelect == true ) SetSelectedIndex( intNewItemIndex );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		// Return result		
		return intNewItemIndex;
	}


	// ----------------------------------------------------------------------
	// Name: FindSortedIndex
	// Abstract: Given a name find its sorted location in the list.
	//			Use bisection method.
	// ----------------------------------------------------------------------
	private int FindSortedIndex( DefaultListModel<CListItem> dlmListItems, String strNewName )
	{
		int intNewItemIndex = 0;
		
		try
		{		
			int intStartIndex = 0;
			int intStopIndex = dlmListItems.getSize( ) - 1;	// 0 based
			int intMiddleIndex = 0;
			String strCurrentName = "";
			
			// Empty list?
			if( dlmListItems.isEmpty( ) == false )
			{
				// Bisect the list
				while( intStartIndex < intStopIndex )
				{
					// Find the middle
					intMiddleIndex = ( intStopIndex + intStartIndex ) / 2;
	
					// Get the middle text
					strCurrentName = dlmListItems.getElementAt( intMiddleIndex ).toString( );
	
					// Less than middle?
					if( strNewName.compareToIgnoreCase( strCurrentName ) < 0 ) 
					{
						// Yes, move the Stop index up
						intStopIndex = intMiddleIndex;
					}
					else
					{
						// No, move the Start index down
						intStartIndex = intMiddleIndex + 1;
					}
				}
				
				// Set new item index
				intNewItemIndex = intStartIndex;
	
				// 1 last compare.  Goes before or after current spot?
				strCurrentName = dlmListItems.getElementAt( intNewItemIndex ).toString( );
	
				// Insert after?
				if( strNewName.compareToIgnoreCase( strCurrentName ) >= 0 ) intNewItemIndex++;
			}
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		// Return result		
		return intNewItemIndex;
	}


	// ----------------------------------------------------------------------
	// Name: HighlightNextInList
	// Abstract: Highlight next closest item in the list
	// ----------------------------------------------------------------------
	public void HighlightNextInList( int intIndex )
	{
		try
		{
			int intListItemsCount = m_dlmListItems.getSize( );
			
	   		// Are there any items in the list( might have deleted the last one )?
			if( intListItemsCount > 0 )
			{
				// Yes, did we delete the last item?
				if( intIndex >= intListItemsCount )
				{
		            // Yes, move the index to the new last item
					intIndex = intListItemsCount - 1;
				}
	
		        // Select next closest item
				m_lstList.setSelectedIndex( intIndex );
				m_lstList.ensureIndexIsVisible( intIndex );
			}
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}
	
	
	// ----------------------------------------------------------------------
	// Name: RemoveAt
	// Abstract: Remove the item at the specified index.
	// ----------------------------------------------------------------------
	public void RemoveAt( int intIndex )
	{
		try
		{	
			// Boundary check
			if( intIndex >= 0 && intIndex < m_dlmListItems.getSize( ) )
			{
				// Remove it
				m_dlmListItems.removeElementAt( intIndex );
				
				// Select next item
				HighlightNextInList( intIndex );
			}
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}
	

	// ----------------------------------------------------------------------
	// Name: Clear
	// Abstract: Clear the list
	// ----------------------------------------------------------------------
	public void Clear( )
	{
		try
		{		
			m_dlmListItems.clear( );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}
	

	// ----------------------------------------------------------------------
	// Name: GetSorted
	// Abstract: To sort or not to sort.  That is the question.
	// ----------------------------------------------------------------------
	public boolean GetSorted( )
	{
		try
		{		

		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}

		return m_blnSorted;
	}


	// ----------------------------------------------------------------------
	// Name: SetSorted
	// Abstract: To sort or not to sort.  That is the question.
	// ----------------------------------------------------------------------
	public void SetSorted( boolean blnSorted )
	{
		try
		{
			// Start sorting?
			if( m_blnSorted == false && blnSorted == true )
			{
				// Reload the list because it maybe unsorted
				ReloadList( );
			}
			
			m_blnSorted = blnSorted;
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}


	// ----------------------------------------------------------------------
	// Name: GetQuiet
	// Abstract: Are we firing mouse click events?
	// ----------------------------------------------------------------------
	public boolean GetQuiet( )
	{
		try
		{		

		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}

		return m_blnQuiet;
	}


	// ----------------------------------------------------------------------
	// Name: SetQuiet
	// Abstract: Fire/Don't fire events.
	// ----------------------------------------------------------------------
	public void SetQuiet( boolean blnQuiet )
	{
		try
		{		
			m_blnQuiet = blnQuiet;
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}


	// ----------------------------------------------------------------------
	// Name: ReloadList
	// Abstract: Reload the list in sorted order.
	// ----------------------------------------------------------------------
	private void ReloadList( )
	{
		try
		{
			DefaultListModel<CListItem> dlmSortedListItems = new DefaultListModel<CListItem>( );
			int intIndex = 0;
			CListItem clsItem = null;
			String strName = "";
			int intNewItemIndex = 0;
			
			// Create a new list and add all items to it 1 at a time in order
			for( intIndex = 0; intIndex < m_dlmListItems.getSize( ); intIndex++ )
			{
				// Next item
				clsItem = ( CListItem )m_dlmListItems.getElementAt( intIndex );
				
				// Name
				strName = clsItem.GetName( );

				// Find out where it should go
				intNewItemIndex = FindSortedIndex( dlmSortedListItems, strName );
				
				// Insert at the specified location
				dlmSortedListItems.insertElementAt( clsItem, intNewItemIndex );
			}
			
			// Clear old list and set to null
			m_dlmListItems.clear( );
			m_dlmListItems = null;
			
			// Set old list to new sorted list
			m_dlmListItems = dlmSortedListItems;
			m_lstList.setModel( m_dlmListItems );
			
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}


	// ----------------------------------------------------------------------
	// Name: Length
	// Abstract: how big is the list?
	// ----------------------------------------------------------------------
	public int Length( )
	{
		int intLength = 0;
		
		try
		{		
			intLength = m_dlmListItems.size( );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return intLength;
	}


	// ----------------------------------------------------------------------
	// Name: GetSelectedIndex
	// Abstract: Index of the first selected item.
	// ----------------------------------------------------------------------
	public int GetSelectedIndex( )
	{
		int intSelectedIndex = 0;
		
		try
		{		
			intSelectedIndex = m_lstList.getSelectedIndex( );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return intSelectedIndex;
	}


	// ----------------------------------------------------------------------
	// Name: SetSelectedIndex
	// Abstract: Select the specified item
	// ----------------------------------------------------------------------
	public void SetSelectedIndex( int intSelectedIndex )
	{
		try
		{	
			// Boundary check
			if( intSelectedIndex >= -1 && intSelectedIndex < m_dlmListItems.getSize( ) )
			{
				// Select it
				m_lstList.setSelectedIndex( intSelectedIndex );
				m_lstList.ensureIndexIsVisible( intSelectedIndex );
			}
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}



	// ----------------------------------------------------------------------
	// Name: SetSelectedIndexByValue
	// Abstract: Select the specified item by the value
	// ----------------------------------------------------------------------
	public void SetSelectedIndexByValue( int intValueToSelect )
	{
		try
		{	
			int intIndex = 0;
			
			// Loop through all the items in the list
			for( intIndex = 0; intIndex < this.Length( ); intIndex += 1 )
			{
				// Do the IDs match?
				if( GetItemValue( intIndex ) == intValueToSelect )
				{
					// Yes, select it
					SetSelectedIndex( intIndex );
					
					// Stop searching
					break;
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
	// Name: GetSelectedIndices
	// Abstract: Indexes of all selected items.
	// ----------------------------------------------------------------------
	public int[] GetSelectedIndices( )
	{
		int aintSelectedIndices[] = new int[ 0 ];
		
		try
		{		
			aintSelectedIndices = m_lstList.getSelectedIndices( );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return aintSelectedIndices;
	}


	// ----------------------------------------------------------------------
	// Name: SetSelectedIndices
	// Abstract: Select the specified items
	// ----------------------------------------------------------------------
	public void SetSelectedIndices( int aintIndicesToSelect[ ] )
	{
		try
		{	
			// Select all
			m_lstList.setSelectedIndices( aintIndicesToSelect );
			
			// Make sure first item is visible
			m_lstList.ensureIndexIsVisible( aintIndicesToSelect[ 0 ] );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}


	// ----------------------------------------------------------------------
	// Name: getEnabled
	// Abstract: getEnabled
	// ----------------------------------------------------------------------
	public boolean getEnabled( )
	{
		boolean blnEnabled = false;
		
		try
		{	
			blnEnabled = m_lstList.isEnabled( );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return blnEnabled;
	}


    // ----------------------------------------------------------------------
    // Name: setEnabled
    // Abstract: Enable/Disable the listbox
	//           Inspired by Elizabeth Hess 2012/04/04
    // 			 Hide JComponent setEnabled because this is a wrapper class
	//			 which is why the method name is camelcase
    // ----------------------------------------------------------------------
    public void setEnabled( boolean blnEnabled )
    {
        try
        {   
            m_lstList.setEnabled( blnEnabled );
        }
        catch( Exception excError )
        {
            // Display Error Message
            CUtilities.WriteLog( excError );
        }
    }
     

	// ----------------------------------------------------------------------
	// Name: IsItemSelected
	// Abstract: is the specified item selected?
	// ----------------------------------------------------------------------
	public boolean IsItemSelected( int intIndex )
	{
		boolean blnIsItemSelected = false;
		
        try
        {   
        	blnIsItemSelected = m_lstList.isSelectedIndex( intIndex );
        }
        catch( Exception excError )
        {
            // Display Error Message
            CUtilities.WriteLog( excError );
        }
        
		return blnIsItemSelected;
	}


	// ----------------------------------------------------------------------
	// Name: GetItem
	// Abstract: Get the name value pair instance of the specified item
	// ----------------------------------------------------------------------
	public CListItem GetItem( int intIndex )
	{
		CListItem clsItem = null;
		try
		{	
			// Boundary check
			if( intIndex >= 0 && intIndex < m_dlmListItems.getSize( ) )
			{
				// Get the selected item
				clsItem = ( CListItem ) m_dlmListItems.getElementAt( intIndex );
			}
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		// Return result
		return clsItem;
	}



	// ----------------------------------------------------------------------
	// Name: GetItemName
	// Abstract: Get the name of the specified item
	// ----------------------------------------------------------------------
	public String GetItemName( int intIndex )
	{
		String strItemName = "";
		try
		{	
			CListItem clsItem = null;
			
			// Boundary check
			if( intIndex >= 0 && intIndex < m_dlmListItems.getSize( ) )
			{
				// Get the selected item
				clsItem = ( CListItem ) m_dlmListItems.getElementAt( intIndex );
				
				// Get the name
				strItemName = clsItem.GetName( );
			}
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		// Return result
		return strItemName;
	}



	// ----------------------------------------------------------------------
	// Name: GetItemValue
	// Abstract: Get the value of the specified item
	// ----------------------------------------------------------------------
	public int GetItemValue( int intIndex )
	{
		int intItemValue = 0;
		try
		{	
			CListItem clsItem = null;
			
			// Boundary check
			if( intIndex >= 0 && intIndex < m_dlmListItems.getSize( ) )
			{
				// Get the selected item
				clsItem = ( CListItem ) m_dlmListItems.getElementAt( intIndex );
				
				// Get the Value
				intItemValue = clsItem.GetValue( );
			}
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		// Return result
		return intItemValue;
	}


	// ----------------------------------------------------------------------
	// Name: GetSelectedItem
	// Abstract: Get the name value pair instance of the selected item
	// ----------------------------------------------------------------------
	public CListItem GetSelectedItem( )
	{
		CListItem clsSelectedItem = null;
		
		try
		{	
			int intSelectedIndex = m_lstList.getSelectedIndex( );
			clsSelectedItem = GetItem( intSelectedIndex );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		// Return result
		return clsSelectedItem;
	}



	// ----------------------------------------------------------------------
	// Name: GetSelectedItemName
	// Abstract: Get the name of the selected item
	// ----------------------------------------------------------------------
	public String GetSelectedItemName( )
	{
		String strSelectedItemName = "";
		
		try
		{	
			int intSelectedIndex = m_lstList.getSelectedIndex( );
			strSelectedItemName = GetItemName( intSelectedIndex );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		// Return result
		return strSelectedItemName;
	}



	// ----------------------------------------------------------------------
	// Value: GetSelectedItemValue
	// Abstract: Get the Value of the selected item
	// ----------------------------------------------------------------------
	public int GetSelectedItemValue( )
	{
		int intSelectedItemValue = 0;
		
		try
		{	
			int intSelectedIndex = m_lstList.getSelectedIndex( );
			intSelectedItemValue = GetItemValue( intSelectedIndex );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		// Return result
		return intSelectedItemValue;
	}

	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------
	// MouseListener
	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------

	// ----------------------------------------------------------------------
	// Name: mouseClicked
	// Abstract: Handle mouseListener events
	// ----------------------------------------------------------------------
	public void mouseClicked( MouseEvent meSource )
	{
		try
		{	
			MouseListener amlListBox[] = this.getMouseListeners( );
			int intIndex = 0;
			
			// Was it the JList?
			if( meSource.getSource( ) == m_lstList )
			{
				// Yes
				
				// Change the source to the ListBox
				meSource.setSource( this );

				// Kick the event up to all listeners of the ListBox
				for( intIndex = 0; intIndex < amlListBox.length; intIndex++ )
				{
					amlListBox[ intIndex ].mouseClicked( meSource );
				}
			}
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}
	// Don't care
	public void mousePressed( MouseEvent meSource ) { }
	public void mouseReleased( MouseEvent meSource ) { }
	public void mouseEntered( MouseEvent meSource ) { }
	public void mouseExited( MouseEvent meSource ) { }

	// -----------------------------------------------------------------------------
	// Name:	 CListItemRenderer     
	// Abstract: Lets us change the color of selected items in the list.
	//			Original by Douglas Heller 2013/12/17
	//			Adapted as an internal private class.			
	// -----------------------------------------------------------------------------
	private class CListItemRenderer extends DefaultListCellRenderer
	{
		// -----------------------------------------------------------------------------
		// -----------------------------------------------------------------------------
		// Properties( never make public )
		// -----------------------------------------------------------------------------
		// ----------------------------------------------------------------------------- 
		
		
		// -----------------------------------------------------------------------------
		// -----------------------------------------------------------------------------
		// Methods
		// -----------------------------------------------------------------------------
		// -----------------------------------------------------------------------------
		
		
		// -----------------------------------------------------------------------------
		// Name:	 CListItemRenderer     
		// Abstract: Constructor 
		// -----------------------------------------------------------------------------
		public CListItemRenderer( )
		{
			try
			{
			
			}
			catch( Exception excError )
			{
				// Log Error
				CUtilities.WriteLog( excError );
			}
		
		}
		
		
		// -----------------------------------------------------------------------------
		// Name:	 getListCellRendererComponent     
		// Abstract: Get the list component in the combo box to be rendered  
		// -----------------------------------------------------------------------------
		@SuppressWarnings("rawtypes")
		@Override
		public Component getListCellRendererComponent( JList lstTarget, 
													   Object objListItem,
													   int intIndex,
													   boolean blnIsCellSelected,
													   boolean blnCellHasFocus )
		{
			try
			{
				super.getListCellRendererComponent( lstTarget, objListItem, intIndex, blnIsCellSelected, blnCellHasFocus );
				
				// Set the text color to blue if the list item is selected
				if ( blnIsCellSelected == true ) 
				{
					setForeground( Color.BLUE );
				}
			}
			catch( Exception excError )
			{
				// Log Error 
				CUtilities.WriteLog( excError );
			}
			
			return this;
		}
	}
	
}

