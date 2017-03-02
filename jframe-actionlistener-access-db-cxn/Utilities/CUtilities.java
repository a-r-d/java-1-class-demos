// ----------------------------------------------------------------------
// Name: Pat Callahan
//		Email: Patrick.Callahan At CincinnatiState Dot edu
//		Phone: 513-569-1751
// Class: CUtilities.  May be freely used by any of my students.
//
// Version		Changed By	Notes
// 2008/08/31	P.C.		Updated to 1.1: Top, left, shortcut
// 2012/11/28	P.C.		Updated to 1.2
// 2014/06/21	P.C.		Updated to 1.3
// 2014/06/24	P.C.		Updated to 1.4: Minor tweaks to menu procedures
// ----------------------------------------------------------------------

// ----------------------------------------------------------------------
// Package
// ----------------------------------------------------------------------
package Utilities;


// ----------------------------------------------------------------------
// Imports
// ----------------------------------------------------------------------
import java.text.*;			// DateFormat, SimpleDateFormat
import java.util.*;			// Date
import java.io.*;			// BufferedReader
import java.awt.*;			// All kinds of stuff: container, window, etc
import java.awt.event.*;	// ActionListener
import javax.swing.*;		// JEverything
import javax.swing.event.*;	// DocumentListener



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
	// Name: DrawGridMarks
	// Abstract: Draw grid marks along the top and the left side to make
	//			 placing controls easier.  Add a paint method to your class
	//			 to override the default behavior and make a call to this
	//			 procedure.  For example:
	//
	//			public void paint( Graphics g )
	//			{
	//				super.paint( g );
	//				CUtilities.DrawGridMarks( this, g );
	//			}
	//
	// ----------------------------------------------------------------------
	public static void DrawGridMarks( JDialog dlgSource, Graphics graTarget )
	{
		try
		{
			int intColumn = 0;
			int intRow = 0;
			int intTopOffset = 0;
			int intLeftOffset = 0;

			// Make the font a little smaller
			graTarget.setFont( new Font( graTarget.getFont( ).getName( ), 
										 graTarget.getFont( ).getStyle( ), 
							     (int) ( graTarget.getFont( ).getSize( ) * 0.75f ) ) );
			
			// Don't count height of title bar
			intTopOffset = dlgSource.getInsets().top;
			intLeftOffset = dlgSource.getInsets().left;
			
			// Grid lines across the top
			for( intColumn = 20; intColumn < dlgSource.getWidth( ); intColumn += 20 )
			{
				// Little mark
				graTarget.drawLine( intLeftOffset + intColumn - 10, intTopOffset, 
									intLeftOffset + intColumn - 10, intTopOffset + 2 );
				// Big mark
				graTarget.drawLine( intLeftOffset + intColumn, intTopOffset, 
									intLeftOffset + intColumn, intTopOffset + 5 );
				// Big mark distances
				graTarget.drawString( "" + intColumn , intLeftOffset + intColumn - 5 , intTopOffset + 15 );
			}

			// Grid lines down the side
			for( intRow = 20; intRow < dlgSource.getHeight( ); intRow += 20 )
			{
				// Little mark
				graTarget.drawLine( intLeftOffset, intTopOffset + intRow - 10, 
									intLeftOffset + 2, intTopOffset + intRow - 10 );
				// Big mark
				graTarget.drawLine( intLeftOffset, intTopOffset + intRow, 
									intLeftOffset + 5, intTopOffset + intRow );
				// Big mark distance
				graTarget.drawString( "" + intRow , intLeftOffset + 5 , intTopOffset + intRow + 3 );
			}
			
			// Add a center mark on the bottom to help center buttons
			graTarget.drawLine( intLeftOffset + dlgSource.getWidth( ) / 2, dlgSource.getHeight( ) - 5, 
								intLeftOffset + dlgSource.getWidth( ) / 2, dlgSource.getHeight( ) );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}

	
	// ----------------------------------------------------------------------
	// Name: DrawGridMarks
	// Abstract: Draw grid marks along the top and the left side to make
	//			 placing controls easier.  Add a paint method to your class
	//			 to override the default behavior and add a call to this
	//			 procedure.  For example:
	//
	//			public void paint( Graphics g )
	//			{
	//				super.paint( g );
	//				CUtilities.DrawGridMarks( this, g );
	//			}
	//
	// ----------------------------------------------------------------------
	public static void DrawGridMarks( JFrame fraSource, Graphics graTarget )
	{
		try
		{
			int intColumn = 0;
			int intRow = 0;
			int intTitleBarHeight = 0;

			// Make the font a little smaller
			graTarget.setFont( new Font( graTarget.getFont( ).getName( ), 
										 graTarget.getFont( ).getStyle( ), 
							     (int) ( graTarget.getFont( ).getSize( ) * 0.75f ) ) );
			
			// Don't count height of title bar
			intTitleBarHeight = fraSource.getInsets().top;
			
			// Grid lines across the top
			for( intColumn = 20; intColumn < fraSource.getWidth( ); intColumn += 20 )
			{
				// Little mark
				graTarget.drawLine( intColumn - 10, intTitleBarHeight, intColumn - 10, intTitleBarHeight + 2 );
				// Big mark
				graTarget.drawLine( intColumn, intTitleBarHeight, intColumn, intTitleBarHeight + 5 );
				// Big mark distances
				graTarget.drawString( "" + intColumn , intColumn - 5 , intTitleBarHeight + 15 );
			}

			// Grid lines down the side
			for( intRow = 20; intRow < fraSource.getHeight( ); intRow += 20 )
			{
				// Little mark
				graTarget.drawLine( 0, intTitleBarHeight + intRow - 10, 4, intTitleBarHeight + intRow - 10 );
				// Big mark
				graTarget.drawLine( 0, intTitleBarHeight + intRow, 7, intTitleBarHeight + intRow );
				// Big mark distance
				graTarget.drawString( "" + intRow , 8, intTitleBarHeight + intRow + 3 );
			}
			
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}

	
	// -------------------------------------------------------------------------
	// Name: ClearLayoutManager
	// Abstract: Java Frames and Dialogs use a layout manager to automatically
	//			set the location and size of controls on a form.  In theory
	//			this sounds good but in practice it doesn't work very well.
	//			Clear the layout manager for the container by setting it 
	//			to null.  This allows us to manually set the location
	//			and size for each control.
	// -------------------------------------------------------------------------
	public static void ClearLayoutManager( Container conTarget )
	{
		try
		{
			// Clear?
			if( conTarget.getLayout( ) != null )
			{
				// No, but now it is
				conTarget.setLayout( null );
			}
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}
	
	
	// ----------------------------------------------------------------------
	// Name: AddButton
	// Abstract: Add a button parent container.
	// ----------------------------------------------------------------------
	public static JButton AddButton( Container conParent,
										String strTitle,  
										int intTop, int intLeft, 
										int intHeight, int intWidth )
	{
		JButton btnNewButton = null;
		
		try
		{
			// No action listener so pass in null
			btnNewButton = AddButton( conParent, null, strTitle, ' ',  
										intTop, intLeft, intHeight, intWidth );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return btnNewButton;
	}


	// ----------------------------------------------------------------------
	// Name: AddButton
	// Abstract: Add a button parent container.
	// ----------------------------------------------------------------------
	public static JButton AddButton( Container conParent, ActionListener alParent,
										String strTitle,  
										int intTop, int intLeft, 
										int intHeight, int intWidth )
	{
		JButton btnNewButton = null;
		
		try
		{
			// No shortcut so pass in a space
			btnNewButton = AddButton( conParent, alParent, strTitle, ' ',  
										intTop, intLeft, intHeight, intWidth );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return btnNewButton;
	}


	// ----------------------------------------------------------------------
	// Name: AddButton
	// Abstract: Add a button parent container.
	// ----------------------------------------------------------------------
	public static JButton AddButton( Container conParent, ActionListener alParent,
										String strTitle, char chrKeyboardShortcut, 
										int intTop, int intLeft, 
										int intHeight, int intWidth )
	{
		JButton btnNewButton = null;

		try
		{
			// New button
			btnNewButton = new JButton( strTitle );
			conParent.add( btnNewButton );
			
			// Set position and size
			btnNewButton.setBounds( intLeft, intTop, intWidth, intHeight );

			// Keyboard shortcut?
			if( chrKeyboardShortcut != ' ' ) btnNewButton.setMnemonic( chrKeyboardShortcut );
			
			// Click event listener?
			if( alParent != null ) btnNewButton.addActionListener( alParent );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return btnNewButton;
	}



	// ----------------------------------------------------------------------
	// Name: AddCheckBox
	// Abstract: Add a CheckBox
	// ----------------------------------------------------------------------
	public static JCheckBox AddCheckBox( Container conParent, 
										 String strTitle,
										 int intTop, int intLeft )
	{
		JCheckBox chkNewCheckBox = null;
		
		try
		{
			// No action listener so pass in null
			chkNewCheckBox = AddCheckBox( conParent, null, strTitle, 
										  intTop, intLeft );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return chkNewCheckBox;
	}



	// ----------------------------------------------------------------------
	// Name: AddCheckBox
	// Abstract: Add a CheckBox
	// ----------------------------------------------------------------------
	public static JCheckBox AddCheckBox( Container conParent, ActionListener alParent,
										 String strTitle,
										 int intTop, int intLeft )
	{
		JCheckBox chkNewCheckBox = null;
		
		try
		{
			// Default to not checked (false)
			chkNewCheckBox = AddCheckBox( conParent, alParent, strTitle, 
										  intTop, intLeft, false );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return chkNewCheckBox;
	}



	// ----------------------------------------------------------------------
	// Name: AddCheckBox
	// Abstract: Add a CheckBox
	// ----------------------------------------------------------------------
	public static JCheckBox AddCheckBox( Container conParent, ActionListener alParent,
										 String strTitle,
										 int intTop, int intLeft, boolean blnChecked )
	{
		JCheckBox chkNewCheckBox = null;
		
		try
		{
			// New CheckBox
			chkNewCheckBox = new JCheckBox( strTitle );
			conParent.add( chkNewCheckBox );

			// Set position (auto-size width and height to title/caption)
			chkNewCheckBox.setBounds( intLeft, intTop, 
									  chkNewCheckBox.getPreferredSize().width, 
									  chkNewCheckBox.getPreferredSize().height );

			// Click event listener?
			if( alParent != null ) chkNewCheckBox.addActionListener( alParent );
			
			// Checked?
			if( blnChecked == true ) chkNewCheckBox.setSelected( true );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return chkNewCheckBox;
	}



	// ----------------------------------------------------------------------
	// Name: AddComboBox
	// Abstract: Add a ComboBox parent container.
	// ----------------------------------------------------------------------
	public static CComboBox AddComboBox( Container conParent,
										 int intTop, int intLeft,
										 int intHeight, int intWidth )
	{
		CComboBox cmbNewComboBox = null;
		
		try
		{
			// No item listener so pass in null
			cmbNewComboBox = AddComboBox( conParent, null, 
										  intTop, intLeft, 
										  intHeight, intWidth );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return cmbNewComboBox;
	}


	// ----------------------------------------------------------------------
	// Name: AddComboBox
	// Abstract: Add a ComboBox parent container.
	// ----------------------------------------------------------------------
	public static CComboBox AddComboBox( Container conParent, ItemListener mlParent,
										 int intTop, int intLeft,
										 int intHeight, int intWidth)
	{
		CComboBox cmbNewComboBox = null;
		
		try
		{
			// New cmbNewComboBox
			cmbNewComboBox = new CComboBox( );
			conParent.add( cmbNewComboBox );

			// Set position and size
			cmbNewComboBox.setBounds( intLeft, intTop, intWidth, intHeight );
			
			// Selected Index Changed event listener?
			if( mlParent != null ) cmbNewComboBox.addItemListener( mlParent );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return cmbNewComboBox;
	}


	// ----------------------------------------------------------------------
	// Name: AddLabel
	// Abstract: Add a label
	// ----------------------------------------------------------------------
	public static JLabel AddLabel( Container conParent, String strTitle, 
									int intTop, int intLeft )
	{
		JLabel lblNewLabel = null;
		
		try
		{
			// New Label
			lblNewLabel = new JLabel( strTitle );
			conParent.add( lblNewLabel );

			// Set position and size
			lblNewLabel.setBounds( intLeft, intTop, 
								   lblNewLabel.getPreferredSize().width, 
								   lblNewLabel.getPreferredSize().height );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return lblNewLabel;
	}



	// ----------------------------------------------------------------------
	// Name: AddRequiredFieldLabel
	// Abstract: Add a label with "* = Required" in light gray (999999)
	//			and slightly smaller (90%) font.
	// ----------------------------------------------------------------------
	public static JLabel AddRequiredFieldLabel( Container conParent, int intTop, int intLeft )
	{
		JLabel lblRequiredField = null;
		
		try
		{
			lblRequiredField = AddColoredSizedLabel( conParent, intTop, intLeft,
													 "* = Required Field", "999999", 0.90f );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return lblRequiredField;
	}

	
	
	// ----------------------------------------------------------------------
	// Name: AddColoredSizedLabel
	// Abstract: Add a label with different color and font size (%)
	//			AddColoredSizedLabel( this, 10, 20, "Warning", "FF0000", 0.50f )
	//		    add a label with text "Warning" in red at 50% the form default font size
	// ----------------------------------------------------------------------
	public static JLabel AddColoredSizedLabel( Container conParent, int intTop, int intLeft,
											   String strTitle,
											   String strRRGGBB, float sngRelativeFontSize )
	{
		JLabel lblRequiredField = null;
		
		try
		{
			int intRed = 0;
			int intGreen = 0;
			int intBlue = 0;
			int intAlpha = 0;
			Color colForeground = null;
			
			lblRequiredField = AddLabel( conParent, strTitle, intTop, intLeft );
			
			// Text color (convert from hex string (base 16) to integer)
			intRed   = Integer.parseInt( strRRGGBB.substring( 0, 2 ), 16 ); // 0-255	
			intGreen = Integer.parseInt( strRRGGBB.substring( 2, 4 ), 16 ); // 0-255
			intBlue  = Integer.parseInt( strRRGGBB.substring( 4, 6 ), 16 ); // 0-255
			intAlpha = 255;
			colForeground = new Color( intRed, intBlue, intGreen, intAlpha );
			lblRequiredField.setForeground( colForeground );
			
			// 90% the size
			lblRequiredField.setFont( new Font( conParent.getFont( ).getName( ), 
											    conParent.getFont( ).getStyle( ), 
									    (int) ( conParent.getFont( ).getSize( ) * sngRelativeFontSize ) ) );

		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return lblRequiredField;
	}

	
	
	// ----------------------------------------------------------------------
	// Name: AddListBox
	// Abstract: Add a list parent container.
	// ----------------------------------------------------------------------
	public static CListBox AddListBox( Container conParent,
										int intTop, int intLeft,
										int intHeight, int intWidth )
	{
		CListBox lstNewList = null;
		
		try
		{
			// No mouse listener so pass in null
			lstNewList = AddListBox( conParent, null, 
									 intTop, intLeft, 
									 intHeight, intWidth );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return lstNewList;
	}


	// ----------------------------------------------------------------------
	// Name: AddListBox
	// Abstract: Add a list parent container.
	// ----------------------------------------------------------------------
	public static CListBox AddListBox( Container conParent, MouseListener mlParent,
										int intTop, int intLeft,
										int intHeight, int intWidth )
	{
		CListBox lstNewList = null;
		
		try
		{
			// New ListBox
			lstNewList = new CListBox( );
			conParent.add( lstNewList );

			// Set position and size
			lstNewList.setBounds( intLeft, intTop, intWidth, intHeight );

			// Selected Index Changed event listener?
			if( mlParent != null ) lstNewList.addMouseListener( mlParent );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return lstNewList;
	}


	// ----------------------------------------------------------------------
    // Name: AddMenuBar
    // Abstract: Add a menu bar to the frame
    // ----------------------------------------------------------------------
    public static JMenuBar AddMenuBar( JFrame fraParent )
    {
        
        JMenuBar mbMainMenu = null;
        
        try
        {
            mbMainMenu = new JMenuBar( );
            
            fraParent.setJMenuBar( mbMainMenu );
        }
        catch( Exception excError )
        {
            // Display Error Message
            CUtilities.WriteLog( excError );
        }

        return mbMainMenu;
    }

    // ----------------------------------------------------------------------
    // Name: AddMenuBar
    // Abstract: Add a menu bar to the frame
    // ----------------------------------------------------------------------
    public static JMenuBar AddMenuBar( JDialog dlgParent )
    {
        
        JMenuBar mbMainMenu = null;
        
        try
        {
            mbMainMenu = new JMenuBar( );
            
            dlgParent.setJMenuBar( mbMainMenu );
        }
        catch( Exception excError )
        {
            // Display Error Message
            CUtilities.WriteLog( excError );
        }
		
        return mbMainMenu;
    }


	// ----------------------------------------------------------------------
	// Name: AddMenu
	// Abstract: Add a menu to a menu bar
	// ----------------------------------------------------------------------
	public static JMenu AddMenu( JMenuBar mbParent, String strTitle )
	{
		JMenu mnuNewMenu = null;
		
		try
		{		
			mnuNewMenu = AddMenu( mbParent, strTitle, ' ' );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return mnuNewMenu;
	}


	// ----------------------------------------------------------------------
	// Name: AddMenu
	// Abstract: Add a menu to a menu bar
	// ----------------------------------------------------------------------
	public static JMenu AddMenu( JMenuBar mbParent, String strTitle, char chrAltKeyShortcut )
	{
		JMenu mnuNewMenu = null;
		
		try
		{		
			// Create instance
			mnuNewMenu = new JMenu( strTitle );
	
			// ALT+? for top level menu or just ? once menu is open.
			if( chrAltKeyShortcut != ' ' ) mnuNewMenu.setMnemonic( chrAltKeyShortcut );
	
			// Add to menu bar
			mbParent.add( mnuNewMenu );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return mnuNewMenu;
	}


	// ----------------------------------------------------------------------
	// Name: AddMenuItem
	// Abstract: Add a menu item to a menu
	// ----------------------------------------------------------------------
	public static JMenuItem AddMenuItem( JMenu mnuParent, 
										 ActionListener alTarget, 
										 String strTitle )
	{

		JMenuItem mniNewMenuItem = null;
		
		try
		{		
			mniNewMenuItem = AddMenuItem( mnuParent, alTarget, strTitle, ' ' );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return mniNewMenuItem;
	}


	// ----------------------------------------------------------------------
	// Name: AddMenuItem
	// Abstract: Add a menu item to a menu
	// ----------------------------------------------------------------------
	public static JMenuItem AddMenuItem( JMenu mnuParent, ActionListener alTarget,
										 String strTitle, char chrMenuKeyShortcut )
	{
		JMenuItem mniNewMenuItem = null;
		
		try
		{	
			
			mniNewMenuItem = AddMenuItem( mnuParent, alTarget, strTitle, chrMenuKeyShortcut, ' ' );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return mniNewMenuItem;
	}


	// ----------------------------------------------------------------------
	// Name: AddMenuItem
	// Abstract: Add a menu item to a menu.  The menu key shortcut works only
	//			once the menu is active/open.  The control key shortcut works
	//			any time.  They can both be the same letter (e.g. S, Control+S)
	// ----------------------------------------------------------------------
	public static JMenuItem AddMenuItem( JMenu mnuParent, ActionListener alTarget,
										 String strTitle, char chrMenuKeyShortcut,
										 char chrControlKeyShortcut )
	{
		JMenuItem mniNewMenuItem = null;
		
		try
		{	
			KeyStroke ksControlKeyShortcut = null;
			
			// Create instance
			mniNewMenuItem = new JMenuItem( strTitle );
	
			// Add menu key shortcut? 
			if( chrMenuKeyShortcut != ' ' )
			{
				// ALT+? for top level menu or just ? once menu is open.
				mniNewMenuItem.setMnemonic( chrMenuKeyShortcut );
			}
	
			// Add control key shortcut? 
			if( chrControlKeyShortcut != ' ' ) 
			{
				// Ctrl+? that works any time even if menu not active (e.g. Ctrl+S)
				ksControlKeyShortcut = KeyStroke.getKeyStroke( chrControlKeyShortcut, Event.CTRL_MASK );
				mniNewMenuItem.setAccelerator( ksControlKeyShortcut );
			}
			
			// Add to menu
			mnuParent.add( mniNewMenuItem );

			// Add click event
			mniNewMenuItem.addActionListener( alTarget );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return mniNewMenuItem;
	}


	// ----------------------------------------------------------------------
	// Name: AddPanel
	// Abstract: Add a panel/group box parent container. 
	// ----------------------------------------------------------------------
	public static JPanel AddPanel( Container conParent, 
									int intTop, int intLeft, 
									int intHeight, int intWidth, 
									String strTitle )
	{
		JPanel panNewPanel = null;
		
		try
		{
			// New Panel
			panNewPanel = new JPanel( );
			
			// Allows us to specify position and size for child controls
			ClearLayoutManager( panNewPanel );

			// Border
			panNewPanel.setBorder( BorderFactory.createTitledBorder( " " + strTitle + " " ) );
			
			// Add to parent container/form
			conParent.add( panNewPanel );

			// Position and Size
			panNewPanel.setBounds( intLeft, intTop, intWidth, intHeight );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return panNewPanel;
	}

	
	// ----------------------------------------------------------------------
	// Name: AddRadioButton
	// Abstract: Add a RadioButton
	// ----------------------------------------------------------------------
	public static JRadioButton AddRadioButton( Container conParent,
												 ButtonGroup bgpGroup, String strTitle,
												 int intTop, int intLeft )
	{
		JRadioButton optNewRadioButton = null;
		
		try
		{
			// No action listener so pass in null
			optNewRadioButton = AddRadioButton( conParent, null, bgpGroup, 
											    strTitle, intTop, intLeft );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return optNewRadioButton;
	}


	// ----------------------------------------------------------------------
	// Name: AddRadioButton
	// Abstract: Add a RadioButton
	// ----------------------------------------------------------------------
	public static JRadioButton AddRadioButton( Container conParent, ActionListener alParent,
												 ButtonGroup bgpGroup, String strTitle,
												 int intTop, int intLeft )
	{
		JRadioButton optNewRadioButton = null;
		
		try
		{
			// Default to not checked (false)
			optNewRadioButton = AddRadioButton( conParent, alParent, bgpGroup, 
											    strTitle, intTop, intLeft, false );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return optNewRadioButton;
	}


	// ----------------------------------------------------------------------
	// Name: AddRadioButton
	// Abstract: Add a RadioButton
	// ----------------------------------------------------------------------
	public static JRadioButton AddRadioButton( Container conParent, ActionListener alParent,
												 ButtonGroup bgpGroup, String strTitle,
												 int intTop, int intLeft, boolean blnChecked )
	{
		JRadioButton optNewRadioButton = null;
		
		try
		{
			// New RadioButton
			optNewRadioButton = new JRadioButton( strTitle );
			conParent.add( optNewRadioButton );
			
			// Set position (auto-size width and height to title/caption)
			optNewRadioButton.setBounds( intLeft, intTop, 
										 optNewRadioButton.getPreferredSize().width, 
										 optNewRadioButton.getPreferredSize().height );

			// Click event listener?
			if( alParent != null ) optNewRadioButton.addActionListener( alParent );
			
			// Add to the button group so only one can be selected at a time
			if( bgpGroup != null ) bgpGroup.add( optNewRadioButton );
			
			// Checked?
			if( blnChecked == true ) optNewRadioButton.setSelected( true );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return optNewRadioButton;
	}


	// ----------------------------------------------------------------------
	// Name: AddTextBox
	// Abstract: Add a text box with default value of empty string 
	// ----------------------------------------------------------------------
	public static CTextBox AddTextBox( Container conParent,
										int intTop, int intLeft,
										int intHeight, int intWidth,  
										int intMaximumLength )
	{
		CTextBox txtNewTextBox = null;

		try
		{
			// Default value is empty string
			txtNewTextBox = AddTextBox( conParent, "", 
										intTop, intLeft, 
										intHeight, intWidth, 
										intMaximumLength );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return txtNewTextBox;
	}


	// ----------------------------------------------------------------------
	// Name: AddTextBox
	// Abstract: Add a text box with no document listener
	// ----------------------------------------------------------------------
	public static CTextBox AddTextBox( Container conParent,
										String strDefaultValue, 
										int intTop, int intLeft,
										int intHeight, int intWidth,  
										int intMaximumLength )
	{
		CTextBox txtNewTextBox = null;

		try
		{
			// No document listener so pass in null
			txtNewTextBox = AddTextBox( conParent, null, strDefaultValue, 
										intTop, intLeft, 
										intHeight, intWidth, 
										intMaximumLength );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return txtNewTextBox;
	}


	// ----------------------------------------------------------------------
	// Name: AddTextBox
	// Abstract: Add a text box
	//			Top should be 3-ish higher than matching label
	//			Good height: 25
	//			Good width: 180-ish
	// ----------------------------------------------------------------------
	public static CTextBox AddTextBox( Container conParent, DocumentListener dlParent,
										String strDefaultValue, 
										int intTop, int intLeft,
										int intHeight, int intWidth,  
										int intMaximumLength )
	{
		CTextBox txtNewTextBox = null;

		try
		{
			// New Textbox
			txtNewTextBox = new CTextBox( strDefaultValue, intMaximumLength );
			conParent.add( txtNewTextBox );

			// Set position
			txtNewTextBox.setBounds( intLeft, intTop, intWidth, intHeight );
			
			// Text Changed event listener?
			if( dlParent != null ) txtNewTextBox.getDocument( ).addDocumentListener( dlParent );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return txtNewTextBox;
	}


	// -------------------------------------------------------------------------
	// Name: SetBusyCursor
	// Abstract: Lock the form during database/file operations.
	//			 Unlock when done.
	//		Needs work: http://www.javaspecialists.eu/archive/Issue075.html
	// -------------------------------------------------------------------------
	public static void SetBusyCursor( JFrame fraTarget, boolean blnBusy )
	{
		try
		{
			// Busy?
			if( blnBusy == true )
			{
				// Yes
				fraTarget.setCursor( Cursor.getPredefinedCursor( Cursor.WAIT_CURSOR ) );
				fraTarget.setEnabled( false );
		    }
			else
			{
				// No
				fraTarget.setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR ) );
				fraTarget.setEnabled( true );
			}
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}


	// -------------------------------------------------------------------------
	// Name: SetBusyCursor
	// Abstract: Lock the form during database/file operations.
	//			 Unlock when done.
	// -------------------------------------------------------------------------
	public static void SetBusyCursor( JDialog dlgTarget, boolean blnBusy )
	{
		try
		{
			// Busy?
			if( blnBusy == true )
			{
				// Yes
				dlgTarget.setCursor( Cursor.getPredefinedCursor( Cursor.WAIT_CURSOR ) );
				dlgTarget.setEnabled( false );
			}
			else
			{
				// No
				dlgTarget.setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR ) );
				dlgTarget.setEnabled( true );
			}
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}


	// ----------------------------------------------------------------------
	// Name: TrimAllFormTextBoxes
	// Abstract: Trim all the text boxes on the form
	// ----------------------------------------------------------------------
	public static void TrimAllFormTextBoxes( JFrame frmTarget )
	{
		try
		{
			TrimAllFormTextBoxes( frmTarget.getContentPane( ) );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}
	
	
	// ----------------------------------------------------------------------
	// Name: TrimAllFormTextBoxes
	// Abstract: Trim all the text boxes on the form
	// ----------------------------------------------------------------------
	public static void TrimAllFormTextBoxes( JDialog dlgTarget )
	{
		try
		{
			TrimAllFormTextBoxes( dlgTarget.getContentPane( ) );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}
	
	
	// ----------------------------------------------------------------------
	// Name: TrimAllFormTextBoxes
	// Abstract: Trim all the text boxes on the form
	// ----------------------------------------------------------------------
	public static void TrimAllFormTextBoxes( Container conTarget )
	{
		try
		{	
			int intIndex = 0;
			Component cpnCurrentControl = null;
			CTextBox txtCurrentTextBox = null;
			JTextField txtCurrentTextField = null;
			String strBuffer = "";
			
			// Loop through all the controls in the container
			for( intIndex = 0; intIndex < conTarget.getComponentCount( ); intIndex += 1 )
			{
				// Current control
				cpnCurrentControl = conTarget.getComponent( intIndex );
				
				// CTextBox?
				if( cpnCurrentControl instanceof CTextBox == true )
				{
					// Cast to CTextBox so we can access class specific methods 
					txtCurrentTextBox = (CTextBox) cpnCurrentControl;
					
					// Trim
					strBuffer = txtCurrentTextBox.getText( );
					strBuffer = strBuffer.trim( );
					txtCurrentTextBox.setText( strBuffer );
					
				}
				// JTextField?
				else if( cpnCurrentControl instanceof JTextField == true )
				{
					// Cast to CTextBox so we can access class specific methods 
					txtCurrentTextField = (JTextField) cpnCurrentControl;
					
					// Trim
					strBuffer = txtCurrentTextField.getText( );
					strBuffer = strBuffer.trim( );
					txtCurrentTextField.setText( strBuffer );
				}
				// Another container (e.g. a panel/groupbox with controls inside)?
				else if( cpnCurrentControl instanceof Container == true )
				{
					// Yes, recurse and get any textboxes inside
					TrimAllFormTextBoxes( (Container) cpnCurrentControl );
				}
			}
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}
	
	
	// -------------------------------------------------------------------------
	// Name: Wait
	// Abstract: Wait the specified number of milliseconds
	//		Needs work:  http://www.catalysoft.com/articles/busyCursor.html
	// -------------------------------------------------------------------------
	public static void Wait( int intMilliseconds )
	{
		try
		{
			long lngWaitUntil = 0;
			
			// Limit to 10 seconds maximum
			if( intMilliseconds > 10000 ) intMilliseconds = 10000;

			lngWaitUntil = System.currentTimeMillis() + intMilliseconds;
			
			// Wait
			while( System.currentTimeMillis() < lngWaitUntil )
			{
				// Bug: need the VB.Net equivalent of Application.DoEvents;
			}

		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}


	// -------------------------------------------------------------------------
	// Name: MoveListItems
	// Abstract: Move all selected list items from the source to the destination list
	// -------------------------------------------------------------------------
	public static void MoveListItems( CListBox lstSourceList,  
									  CListBox lstDestinationList )
	{
		try
		{
			int intIndex = 0;
			int intSelectedIndex = 0;
			int intNewIndex = 0;
			int aintSelectedIndices[] = lstSourceList.GetSelectedIndices( );
			int aintIndicesToSelect[] = new int[ aintSelectedIndices.length ];

			// Loop through all the list items and add to destination
			for( intIndex = 0; intIndex < aintSelectedIndices.length; intIndex++ )
			{
				// Selected index
				intSelectedIndex = aintSelectedIndices[ intIndex ];
			
				// Add to destination
				intNewIndex = lstDestinationList.AddItemToList( lstSourceList.GetItem( intSelectedIndex ) );
				
				// Save index so we can select all new items in destination at the end
				aintIndicesToSelect[ intIndex ] = intNewIndex;
			}
			
			// Select all new items in destination list
			lstDestinationList.SetSelectedIndices( aintIndicesToSelect );

			// Remove selected items from source( go from bottom up )
			for( intIndex = aintSelectedIndices.length - 1; intIndex >= 0; intIndex-- )
			{
				// Selected index
				intSelectedIndex = aintSelectedIndices[ intIndex ];

				// Remove from source					
				lstSourceList.RemoveAt( intSelectedIndex );
			}
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}


	// ----------------------------------------------------------------------
	// Name: ReadStringFromUser
	// Abstract: Read a string from the user
	// ----------------------------------------------------------------------
	public static String ReadStringFromUser( )
	{
		String strBuffer = "";
		
		try
		{		
			// Input stream
			BufferedReader burInput = new BufferedReader( new InputStreamReader( System.in ) ) ;
	
			// Read a line
			strBuffer = burInput.readLine( );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return strBuffer;
	}
	
	
	// ----------------------------------------------------------------------
	// Name: ConvertStringToUtilDate
	// Abstract: Convert a string in yyyy/mm/dd format to a java.util.Date
	// ----------------------------------------------------------------------
	public static java.util.Date ConvertStringToUtilDate( String strDateToConvert )
	{
		java.util.Date dtmConvertedDate = null;
		
		try
		{		
			dtmConvertedDate = ConvertStringToUtilDate( strDateToConvert, "yyyy/MM/dd" );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return dtmConvertedDate;
	}
		
	
	// ----------------------------------------------------------------------
	// Name: ConvertStringToUtilDate
	// Abstract: Convert a string in the specified format to a java.util.Date
	//			Month is M or MM.  Minutes is m or mm.
	// ----------------------------------------------------------------------
	public static java.util.Date ConvertStringToUtilDate( String strDateToConvert, String strDateFormat )
	{
		java.util.Date dtmConvertedDate = null;
		
		try
		{		
			SimpleDateFormat sdfYYYYMMDD = new SimpleDateFormat( strDateFormat );
			
			dtmConvertedDate = sdfYYYYMMDD.parse( strDateToConvert );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return dtmConvertedDate;
	}
		


	// ----------------------------------------------------------------------
	// Name: ConvertStringToSQLDate
	// Abstract: Convert a string in yyyy/mm/dd format to a java.sql.Date
	// ----------------------------------------------------------------------
	public static java.sql.Date ConvertStringToSQLDate( String strDateToConvert )
	{
		java.sql.Date sdtmConvertedDate = null;
		
		try
		{		
			// Must uses slashes (2012/12/12) instead of dashes or dots
			strDateToConvert = strDateToConvert.replace( '-', '/' );
			strDateToConvert = strDateToConvert.replace( '.', '/' );
			
			sdtmConvertedDate = ConvertStringToSQLDate( strDateToConvert, "yyyy/MM/dd" );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return sdtmConvertedDate;
	}
	
	

	// ----------------------------------------------------------------------
	// Name: ConvertStringToSQLDate
	// Abstract: Convert a string in the specified format to a java.sql.Date
	// ----------------------------------------------------------------------
	public static java.sql.Date ConvertStringToSQLDate( String strDateToConvert, String strDateFormat )
	{
		java.sql.Date sdtmConvertedDate = null;
		
		try
		{		
			java.util.Date dtmDateToConvert = null;
			
			dtmDateToConvert = ConvertStringToUtilDate( strDateToConvert, strDateFormat );
			
			sdtmConvertedDate = ConvertUtilDateToSQLDate( dtmDateToConvert );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return sdtmConvertedDate;
	}
		


	// ----------------------------------------------------------------------
	// Name: ConvertSQLDateToUtilDate
	// Abstract: Java dates are different than SQL/database dates so we have
	//			 to be able to convert.
	// ----------------------------------------------------------------------
	public static java.util.Date ConvertSQLDateToUtilDate( java.sql.Date sdtmDateToConvert )
	{
		java.util.Date dtmConvertedDate = null;
		
		try
		{		
			dtmConvertedDate = new java.util.Date( sdtmDateToConvert.getTime( ) );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return dtmConvertedDate;
	}


	// ----------------------------------------------------------------------
	// Name: ConvertUtilDateToSQLDate
	// Abstract: Java dates are different than SQL/database dates so we have
	//			 to be able to convert.
	// ----------------------------------------------------------------------
	public static java.sql.Date ConvertUtilDateToSQLDate( java.util.Date dtmDateToConvert )
	{
		java.sql.Date sdtmConvertedDate = null;
		
		try
		{		
			sdtmConvertedDate = new java.sql.Date( dtmDateToConvert.getTime( ) );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return sdtmConvertedDate;
	}

	
	
	// ----------------------------------------------------------------------
	// Name: ConvertSQLDateToString
	// Abstract: Convert and repent!  Default to yyyy/MM/dd format (e.g. 2001/12/31)
	// ----------------------------------------------------------------------
	public static String ConvertSQLDateToString( java.sql.Date sdtmDateToConvert )
	{
		String strDate = "";
		
		try
		{		
			strDate = ConvertSQLDateToString( sdtmDateToConvert, "yyyy/MM/dd" );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return strDate;
	}


	// ----------------------------------------------------------------------
	// Name: ConvertSQLDateToString
	// Abstract: Convert and repent!
	// ----------------------------------------------------------------------
	public static String ConvertSQLDateToString( java.sql.Date sdtmDateToConvert, String strFormat )
	{
		String strDate = "";
		
		try
		{	
			SimpleDateFormat sdfFormat = new SimpleDateFormat( strFormat );
			
			if( sdtmDateToConvert != null )
			{
				strDate = sdfFormat.format( sdtmDateToConvert );
			}
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return strDate;
	}


	// ----------------------------------------------------------------------
	// Name: ConvertUtilDateToString
	// Abstract: Convert and repent!
	// ----------------------------------------------------------------------
	public static String ConvertUtilDateToString( java.util.Date dtmDateToConvert )
	{
		String strDate = "";
		
		try
		{		
			if( dtmDateToConvert != null )
			{
				strDate = dtmDateToConvert.toString( );
			}
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return strDate;
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

