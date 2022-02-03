import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Notepad{
	private JFrame window = new JFrame();
	private JTextArea textArea = new JTextArea();
	private JMenuBar notePadMenuBar = new JMenuBar();
	private JMenu file = new JMenu("File");
	private JMenu edit = new JMenu("Edit");
	private JMenu format = new JMenu("Format");
	private JMenu view = new JMenu("View");
	private JMenu help = new JMenu("Help");
	private Font menuBarFont = new Font("Arial",Font.PLAIN,12);
	private String[] fileMenuItemsNames = new String[]{
		"New",
		"New Window",
		"Open...",
		"Save",
		"Save As...",
		"Page Setup...",
		"Print...",
		"Exit"
	};
	
	private String[] editMenuItemsName = new String[]{
		"Undo",
		"Cut",
		"Copy",
		"Paste",
		"Delete",
		"Search with Bing...",
		"Find...",
		"Find Next",
		"Find Previous",
		"Replace...",
		"Go To...",
		"Select All",
		"Time/Date"
		
	};
	
	
	private JMenuItem[] fileMenuItems = new JMenuItem[8];
	private JMenuItem[] editMenuItems = new JMenuItem[13];
	// format menuitems
	private JMenuItem wordWrap = new JMenuItem("Word Wrap");
	private JMenuItem font = new JMenuItem("Font...");
	
	// view menuitems
	private JMenuItem zoom = new JMenuItem("Zoom");
	private JMenuItem zoomIn = new JMenuItem("Zoom In");
	private JMenuItem zoomOut = new JMenuItem("Zoom Out");
	private JMenuItem restorDefaultZoom = new JMenuItem("Restor Default Zoom");
	private JMenuItem statusBar = new JMenuItem("Status Bar");
	
	//help
	private JMenuItem viewHelp = new JMenuItem("View Help");
	private JMenuItem sendFeedback = new JMenuItem("Send Feedback");
	private JMenuItem aboutNotepad = new JMenuItem("About Notepad");
	public Notepad(){
		window.setBounds(300,100,800,600);
		window.setLayout(new BorderLayout(5,5));
		
		file.setFont(menuBarFont);
		notePadMenuBar.add(file);
		edit.setFont(menuBarFont);
		notePadMenuBar.add(edit);
		format.setFont(menuBarFont);
		notePadMenuBar.add(format);
		view.setFont(menuBarFont);
		notePadMenuBar.add(view);
		help.setFont(menuBarFont);
		notePadMenuBar.add(help);
		
		for(int i = 0; i < fileMenuItems.length; i++){
			fileMenuItems[i] = new JMenuItem(fileMenuItemsNames[i]);
			fileMenuItems[i].setFont(menuBarFont);
			if( i == 5 || i == 7)
				file.addSeparator();
			file.add(fileMenuItems[i]);
			
		}
		
		for(int i = 0; i < editMenuItems.length; i++){
			editMenuItems[i] = new JMenuItem(editMenuItemsName[i]);
			editMenuItems[i].setFont(menuBarFont);
			if( i == 1 || i == 5 || i == 11)
				edit.addSeparator();
			edit.add(editMenuItems[i]);
		}
		
		format.add(wordWrap);
		format.add(font);
		
		zoomIn.setFont(menuBarFont);
		zoomOut.setFont(menuBarFont);
		restorDefaultZoom.setFont(menuBarFont);
		zoom.add(zoomIn);
		zoom.add(zoomOut);
		zoom.add(restorDefaultZoom);
		view.add(zoom);
		
		view.add(statusBar);
		
		help.add(viewHelp);
		help.add(sendFeedback);
		help.addSeparator();
		help.add(aboutNotepad);
		
		wordWrap.setFont(menuBarFont);
		font.setFont(menuBarFont);
		
		zoom.setFont(menuBarFont);
		statusBar.setFont(menuBarFont);
		
		viewHelp.setFont(menuBarFont);
		sendFeedback.setFont(menuBarFont);
		aboutNotepad.setFont(menuBarFont);
		window.setJMenuBar(notePadMenuBar);
		window.add(textArea);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args){
		new Notepad();
	}
}