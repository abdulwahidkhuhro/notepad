import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
class Notepad implements ActionListener{
	private JFrame window = new JFrame();
	private JTextArea textArea = new JTextArea();
	private JScrollPane tAScrollPane = new JScrollPane(textArea);
	private JMenuBar notePadMenuBar = new JMenuBar();
	private JMenu file = new JMenu("File");
	private JMenu edit = new JMenu("Edit");
	private JMenu format = new JMenu("Format");
	private JMenu view = new JMenu("View");
	private JMenu help = new JMenu("Help");
	private Font menuBarFont = new Font("Arial",Font.PLAIN,12);
	private String fileName = "";
	private String directoryPath = "";
	private String path = "";
	private int zoomValue = 15;
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
	private JMenu zoom = new JMenu("Zoom");
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
		window.setTitle("New File");
		textArea.setFont(new Font("Arial",Font.PLAIN,15));
		
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
			fileMenuItems[i].addActionListener(this);
			
		}
		
		for(int i = 0; i < editMenuItems.length; i++){
			editMenuItems[i] = new JMenuItem(editMenuItemsName[i]);
			editMenuItems[i].setFont(menuBarFont);
			if( i == 1 || i == 5 || i == 11)
				edit.addSeparator();
			edit.add(editMenuItems[i]);
			editMenuItems[i].addActionListener(this);
		}
		
		format.add(wordWrap);
		format.add(font);
		
		zoomIn.setFont(menuBarFont);
		zoomOut.setFont(menuBarFont);
		restorDefaultZoom.setFont(menuBarFont);
		zoom.add(zoomIn);
		zoom.add(zoomOut);
		zoom.add(restorDefaultZoom);
		zoomIn.addActionListener(this);
		zoomOut.addActionListener(this);
		restorDefaultZoom.addActionListener(this);
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
		window.add(tAScrollPane);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e){
		/*
		"New",
		"New Window",
		"Open...",
		"Save",
		"Save As...",
		"Page Setup...",
		"Print...",
		"Exit"
		*/
		if(fileMenuItems[0] == e.getSource()){
			newFile();
		}else if(fileMenuItems[1] == e.getSource()){
			newWindowFile();
		}else if(fileMenuItems[2] == e.getSource()){
			openFile();
		}else if(fileMenuItems[3] == e.getSource()){
			saveFile();
		}else if(fileMenuItems[4] == e.getSource()){
			saveAsFile();
		}else if(fileMenuItems[5] == e.getSource()){
			
		}else if(fileMenuItems[6] == e.getSource()){
			
		}else if(fileMenuItems[7] == e.getSource()){
			fileExit();
		}
		
		/*
		
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
		
		
		*/
		
		if(editMenuItems[0] == e.getSource()){
			JOptionPane.showMessageDialog(window,"Undo is pressed");
		}else if(editMenuItems[1] == e.getSource()){
			JOptionPane.showMessageDialog(window,"Cut is pressed");
		}else if(editMenuItems[2] == e.getSource()){
			JOptionPane.showMessageDialog(window,"Copy is pressed");
			String str = textArea.getSelected();
		}else if(editMenuItems[3] == e.getSource()){
			paste();
		}else if(editMenuItems[4] == e.getSource()){
			JOptionPane.showMessageDialog(window,"Delete is pressed is pressed");
		}else if(editMenuItems[5] == e.getSource()){
			JOptionPane.showMessageDialog(window,"Search with Bing is pressed");
		}else if(editMenuItems[6] == e.getSource()){
			JOptionPane.showMessageDialog(window,"Find is pressed");
			
		}else if(editMenuItems[7] == e.getSource()){
			JOptionPane.showMessageDialog(window,"Find Next is pressed");
		}else if(editMenuItems[8] == e.getSource()){
			JOptionPane.showMessageDialog(window,"Find previous is pressed");
		}else if(editMenuItems[9] == e.getSource()){
			JOptionPane.showMessageDialog(window,"Replace is pressed");
		}else if(editMenuItems[10] == e.getSource()){
			JOptionPane.showMessageDialog(window,"Go to is pressed");
		}else if(editMenuItems[11] == e.getSource()){
			textArea.selectAll();
		}else if(editMenuItems[12] == e.getSource()){
			JOptionPane.showMessageDialog(window,"Time/Date is pressed");
		}
		
		if(zoomIn == e.getSource()){
			if(zoomValue >= 15){
				zoomValue += 5;
			}
			textArea.setFont(new Font("Arial",Font.PLAIN,zoomValue));
		}else if(zoomOut == e.getSource()){
			if(zoomValue > 15){
				zoomValue -= 5;
			}
			textArea.setFont(new Font("Arial",Font.PLAIN,zoomValue));
		}else if(restorDefaultZoom == e.getSource()){
			zoomValue = 15;
			textArea.setFont(new Font("Arial",Font.PLAIN,zoomValue));
		}
	}
	
	// File menu Methods
	private void newFile(){
		setFileName("");
		setDirectory("");
		setPath("");
		setWindowTitle("New File");
		textArea.setText("");
	}
	
	public void newWindowFile(){
		window.dispose();
		new Notepad();
	}
	
	private void openFile(){
		FileDialog openDialog = new FileDialog(window,"Open",FileDialog.LOAD);
		openDialog.show();
		
		String directoryPath = openDialog.getDirectory();
		String fileName = openDialog.getFile();
		String filePath = directoryPath+fileName;
		setDirectory(directoryPath);
		setFileName(fileName);
		setPath(filePath);
		setWindowTitle(fileName);
		try{
			FileInputStream fin = new FileInputStream(filePath);
			int size = fin.available();
			byte[] data = new byte[size];
			fin.read(data,0,size);
			String str = new String(data,0,size);
			textArea.setText(str);
			
			fin.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	private void saveFile(){
		FileDialog saveDialog = new FileDialog(window,"Save",FileDialog.SAVE);
		saveDialog.show();
		
		String dir = saveDialog.getDirectory();
		String fileName = saveDialog.getFile();
		String filePath = dir+fileName;
		setDirectory(dir);
		setFileName(fileName);
		setPath(filePath);
		setWindowTitle(fileName);
		try{
			FileOutputStream fout = new FileOutputStream(filePath);
			String str = textArea.getText();
			fout.write(str.getBytes(),0,str.length());
			fout.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	private void saveAsFile(){
		String fileName = getFileName();
		String path = getPath();
		if(!fileName.isEmpty()){
			File[] fileList = new File(getDirectory()).listFiles();
			for(int i = 0; i < fileList.length; i++){
				if(fileList[i].getName().equals(fileName)){
					try{
						FileOutputStream fout = new FileOutputStream(path);
						String text = textArea.getText();
						fout.write(text.getBytes(),0,text.length());
						fout.close();
					}catch(Exception e){
						e.printStackTrace();
					}
					return;
				}
			}
		}else{
			saveFile();
		}
	}
	
	private void fileExit(){
		window.dispose();
	}
	
	// Edit menu items
	
	private void paste(){
		textArea.paste();
	}
	
	private void setDirectory(String directoryPath){
		this.directoryPath = directoryPath;
	}
	
	public String getDirectory(){
		return directoryPath;
	}
	
	private void setFileName(String fileName){
		this.fileName = fileName;
	}
	
	public String getFileName(){
		return fileName;
	}
	
	private void setPath(String path){
		this.path = path;
	}
	
	public String getPath(){
		return path;
	}
	private void setWindowTitle(String title){
		window.setTitle(title);
	}
	public static void main(String[] args){
		new Notepad();
	}
	
}