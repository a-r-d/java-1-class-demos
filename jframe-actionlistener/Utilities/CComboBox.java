// ----------------------------------------------------------------------
// Name: Pat Callahan
// Class: CComboBox 
//			v2.0 - 2013/12/02 InsertAt
//			v2.1 - 2013/12/02 Ignore deselected item change event
//			v2.2 - 2013/12/17 Selected item is blue - Douglas Heller
// ----------------------------------------------------------------------


// ----------------------------------------------------------------------
// Package
// ----------------------------------------------------------------------
package Utilities;


// ----------------------------------------------------------------------
// Imports
// ----------------------------------------------------------------------
import java.util.*;				// Arraylist
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


// ----------------------------------------------------------------------
// Name: CComboBox
// Abstract: Make a ComboBox class that combines the list, list model
//			and scrollbars all into one.  Add event firing too.
// ----------------------------------------------------------------------
@SuppressWarnings("serial")
public class CComboBox extends javax.swing.JComponent implements ItemListener
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
	private DefaultComboBoxModel<CListItem> m_dcmListItems = null;
	private JComboBox<CListItem> m_cmbList = null;
	private ArrayList<ItemListener> m_alItemListeners = new ArrayList<ItemListener>( );
	
	private boolean m_blnSorted = true;				// Sort the list by default
	private boolean m_blnQuiet = false;				// fire/don't fire events
		

	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------
	// Methods
	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------


	// ----------------------------------------------------------------------
	// Name: CComboBox
	// Abstract: Constructor
	// ----------------------------------------------------------------------
	public CComboBox( )
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
			m_dcmListItems = new DefaultComboBoxModel<CListItem>( );
			
			// Combo Box
			m_cmbList = new JComboBox<CListItem>( m_dcmListItems );
			m_cmbList.addItemListener( this );
			m_cmbList.setBackground( Color.white );
			
			// ListItemRenderer - From Douglas Heller 2013/12/17
			m_cmbList.setRenderer( new CListItemRenderer( ) );
			
			// Add to component			
			this.add( m_cmbList );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
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
				intNewItemIndex = FindSortedIndex( m_dcmListItems, clsNewItem.GetName( ) );
			}
			else
			{
				// No, add it to the end
				intNewItemIndex = m_dcmListItems.getSize( );	
			}
			
			// Insert at the specified location
			m_dcmListItems.insertElementAt( clsNewItem, intNewItemIndex );
			
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
	private int FindSortedIndex( DefaultComboBoxModel<CListItem> dcmListItems, String strNewName )
	{
		int intNewItemIndex = 0;
		try
		{		
			int intStartIndex = 0;
			int intStopIndex = dcmListItems.getSize( ) - 1;	// 0 based
			int intMiddleIndex = 0;
			String strCurrentName = "";
			
			// Empty list?
			if( dcmListItems.getSize( ) > 0 )
			{
				// Bisect the list
				while( intStartIndex < intStopIndex )
				{
					// Find the middle
					intMiddleIndex = ( intStopIndex + intStartIndex ) / 2;
	
					// Get the middle text
					strCurrentName = dcmListItems.getElementAt( intMiddleIndex ).toString( );
	
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
				strCurrentName = dcmListItems.getElementAt( intNewItemIndex ).toString( );
	
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
	// Name: InsertItemInList
	// Abstract: Insert an item into list
	// ----------------------------------------------------------------------
	public int InsertItemInList( int intValue, String strName, int intInsertIndex )
	{

		try
		{		
			CListItem clsNewItem = new CListItem( intValue, strName );

			intInsertIndex = InsertItemInList( clsNewItem, true, intInsertIndex );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		// Return result		
		return intInsertIndex;
	}
	

	// ----------------------------------------------------------------------
	// Name: InsertItemInList
	// Abstract: Insert an item into list
	// ----------------------------------------------------------------------
	public int InsertItemInList( int intValue, String strName, boolean blnSelect, int intInsertIndex )
	{

		try
		{	
			CListItem clsNewItem = new CListItem( intValue, strName );

			intInsertIndex = InsertItemInList( clsNewItem, blnSelect, intInsertIndex );			
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		// Return result		
		return intInsertIndex;
	}


	// ----------------------------------------------------------------------
	// Name: InsertItemInList
	// Abstract: Insert an item into list
	// ----------------------------------------------------------------------
	public int InsertItemInList( CListItem clsNewItem, int intInsertIndex )
	{

		try
		{		
			intInsertIndex = InsertItemInList( clsNewItem, true, intInsertIndex );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		// Return result		
		return intInsertIndex;
	}

	
	// ----------------------------------------------------------------------
	// Name: InsertItemInList
	// Abstract: Insert an item into list
	// ----------------------------------------------------------------------
	public int InsertItemInList( CListItem clsNewItem, boolean blnSelect, int intInsertIndex )
	{
		try
		{	
			// Boundary check
			if( intInsertIndex <                        0 )  intInsertIndex = 0;
			if( intInsertIndex > m_dcmListItems.getSize( ) ) intInsertIndex = m_dcmListItems.getSize( );
			
			// Insert at the specified location
			m_dcmListItems.insertElementAt( clsNewItem, intInsertIndex );
			
			// Select?
			if( blnSelect == true ) SetSelectedIndex( intInsertIndex );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		// Return result		
		return intInsertIndex;
	}


	// ----------------------------------------------------------------------
	// Name: HighlightNextInList
	// Abstract: Highlight next closest item in the list
	// ----------------------------------------------------------------------
	private void HighlightNextInList( int intIndex )
	{
		try
		{
			int intListItemsCount = m_dcmListItems.getSize( );
			
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
				m_cmbList.setSelectedIndex( intIndex );
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
			if( intIndex >= 0 && intIndex < m_dcmListItems.getSize( ) )
			{
				// Remove it
				m_dcmListItems.removeElementAt( intIndex );
				
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
			m_dcmListItems.removeAllElements( );
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
			DefaultComboBoxModel<CListItem> dlmSortedListItems = new DefaultComboBoxModel<CListItem>( );
			int intIndex = 0;
			CListItem clsItem = null;
			String strName = "";
			int intNewItemIndex = 0;
			
			// Create a new list and add all items to it 1 at a time in order
			for( intIndex = 0; intIndex < m_dcmListItems.getSize( ); intIndex++ )
			{
				// Next item
				clsItem = ( CListItem )m_dcmListItems.getElementAt( intIndex );
				
				// Name
				strName = clsItem.GetName( );

				// Find out where it should go
				intNewItemIndex = FindSortedIndex( dlmSortedListItems, strName );
				
				// Insert at the specified location
				dlmSortedListItems.insertElementAt( clsItem, intNewItemIndex );
			}
			
			// Clear old list and set to null
			m_dcmListItems.removeAllElements( );
			m_dcmListItems = null;
			
			// Set old list to new sorted list
			m_dcmListItems = dlmSortedListItems;
			m_cmbList.setModel( m_dcmListItems );
			
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
		try
		{	
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		return m_dcmListItems.getSize( );
	}


	// ----------------------------------------------------------------------
	// Name: GetSelectedIndex
	// Abstract: Which item is selected?
	// ----------------------------------------------------------------------
	public int GetSelectedIndex( )
	{
		try
		{	
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		return m_cmbList.getSelectedIndex( );
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
			if( intSelectedIndex >= -1 && intSelectedIndex < m_dcmListItems.getSize( ) )
			{
				// Select it
				m_cmbList.setSelectedIndex( intSelectedIndex );
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
	// Name: getEnabled
	// Abstract: getEnabled
	// ----------------------------------------------------------------------
	public boolean getEnabled( )
	{
		boolean blnEnabled = false;
		
		try
		{	
			blnEnabled = m_cmbList.isEnabled( );
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
    // Abstract: Enable/Disable the combobox
	//           Inspired by Elizabeth Hess 2012/04/04
    // 			 Hide JComponent setEnabled because this is a wrapper class
	//			 which is why the method name is camelcase
    // ----------------------------------------------------------------------
    public void setEnabled( boolean blnEnabled )
    {
        try
        {   
            m_cmbList.setEnabled( blnEnabled );
        }
        catch( Exception excError )
        {
            // Display Error Message
            CUtilities.WriteLog( excError );
        }
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
			if( intIndex >= 0 && intIndex < m_dcmListItems.getSize( ) )
			{
				// Get the selected item
				clsItem = ( CListItem ) m_dcmListItems.getElementAt( intIndex );
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
			if( intIndex >= 0 && intIndex < m_dcmListItems.getSize( ) )
			{
				// Get the selected item
				clsItem = ( CListItem ) m_dcmListItems.getElementAt( intIndex );
				
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
			if( intIndex >= 0 && intIndex < m_dcmListItems.getSize( ) )
			{
				// Get the selected item
				clsItem = ( CListItem ) m_dcmListItems.getElementAt( intIndex );
				
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
			int intSelectedIndex = m_cmbList.getSelectedIndex( );
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
			int intSelectedIndex = m_cmbList.getSelectedIndex( );
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
			int intSelectedIndex = m_cmbList.getSelectedIndex( );
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
	// Name: addItemListener
	// Abstract: Add an item listener 
	// ----------------------------------------------------------------------
	public void addItemListener( ItemListener ilEventReceiver )
	{
		try
		{	
			// Not null?
			if( ilEventReceiver != null )
			{
				m_alItemListeners.add( ilEventReceiver );	
			}
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}
	

	// ----------------------------------------------------------------------
	// Name: getItemListeners
	// Abstract: get a list of all the item listeners
	// ----------------------------------------------------------------------
	public ItemListener[] getItemListeners( )
	{
		// Default to empty array( so length is set )
		ItemListener ailEventReceivers[ ] = null;
		
		try
		{	
			int intIndex = 0;
			
			// Make an item listeners array
			ailEventReceivers = new ItemListener[ m_alItemListeners.size( ) ];

			// Build the array			
			for( intIndex = 0; intIndex < m_alItemListeners.size( ); intIndex++ )
			{
				ailEventReceivers[ intIndex ]  = ( ItemListener ) m_alItemListeners.get( intIndex );
			}
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		// Return result		
		return ailEventReceivers;
	}
	

	// ----------------------------------------------------------------------
	// Name: removeItemListener
	// Abstract: remove an item listener 
	// ----------------------------------------------------------------------
	public void removeItemListener( ItemListener ilEventReceiver )
	{
		try
		{	
			// Not null?
			if( ilEventReceiver != null )
			{
				m_alItemListeners.remove( ilEventReceiver );	
			}
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}
	

	// ----------------------------------------------------------------------
	// Name: itemStateChanged
	// Abstract: Selected item index in combo box changed.
	//			 Fire an action event because that's all we really are about.
	//			 If we are quiet the don't fire the event.
	// ----------------------------------------------------------------------
	public void itemStateChanged( ItemEvent ieSource )
	{
		try
		{		
			int intIndex = 0;
			ItemListener ailComboBox[] = null;
			Object objOriginalSource = ieSource.getSource( );
			
			// Be quiet?
			if( m_blnQuiet == false )
			{
				// No
				
				// Was it the JList?
				if( ieSource.getSource( ) == m_cmbList )
				{
					// Yes
					
				    // Was it for selected (ignored deselected)?
				    if( ieSource.getStateChange( ) == ItemEvent.SELECTED )
				    {
				        // Yes, Change the source to the ComboBox
    					ieSource.setSource( this );
    	
    					// Get all the listeners for the combo box
    					ailComboBox = getItemListeners( );
    	
    					// Kick the event up to all listeners of the ListBox
    					for( intIndex = 0; intIndex < ailComboBox.length; intIndex++ )
    					{
    						// Knock, knock
    						ailComboBox[ intIndex ].itemStateChanged( ieSource );
    					}
    	
    					// Put the original source back
    					ieSource.setSource( objOriginalSource );
				    }
				}
			}
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}
	
	
	
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

