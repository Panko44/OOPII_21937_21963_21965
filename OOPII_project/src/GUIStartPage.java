import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import exception.WikipediaNoArcticleException;
import exception.WikipediaNoCityException;

public class GUIStartPage {

	public void startGUI(ArrayList<Traveller> travellerList, HashMap<String, City> cityHashMap) throws SQLException, JsonParseException, JsonMappingException, IOException, WikipediaNoCityException {
		// start JFrame
		JFrame startFrame = new JFrame();
		startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startFrame.setTitle("Travel App");
		startFrame.setLayout(new BorderLayout());
		startFrame.getContentPane().setBackground(new Color(34, 139, 220));
		startFrame.setVisible(true);

		// JMenuBar
		JMenuBar menuBar = new JMenuBar();


		JMenu freeTicket = new JMenu("Free Ticket");
		menuBar.add(freeTicket);

//		JFrame ticketFrame = new JFrame();
//		ticketFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		ticketFrame.setTitle("Free ticket winner");

		
		freeTicket.addMenuListener(new MenuListener() {
//		  public void actionPerformed(ActionEvent ae) {
//			  
//		  }

		@Override
		public void menuSelected(MenuEvent e) {
			  Ticket ticket = new Ticket();
			  Traveller winner = ticket.freeTicket(cityHashMap.get("Moscow"), travellerList);
			  
			  JFrame ticketFrame = new JFrame();
			  ticketFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			  ticketFrame.setTitle("Free ticket winner");
			  ticketFrame.setSize(500, 200);
			  
			  
			  ticketFrame.setVisible(true);
			  JLabel statusLabel = new JLabel();
			  statusLabel.setText("Free ticket winner to traveller in Moscow is: " + winner);
			  ticketFrame.add(statusLabel);
			
		}

		@Override
		public void menuDeselected(MenuEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void menuCanceled(MenuEvent e) {
			// TODO Auto-generated method stub
			
		}
		});
		
		JMenu printTrav = new JMenu("Show Travellers");
		menuBar.add(printTrav);

		startFrame.setJMenuBar(menuBar);

		// start Frame Image
		ImageIcon image = new ImageIcon("plane.png");
		JLabel imageLabel = new JLabel();
		imageLabel.setIcon(image);
		startFrame.add(imageLabel, BorderLayout.NORTH);

		// start Frame Text
		JPanel startMessagePanel = new JPanel();
		startMessagePanel.setBackground(new Color(34, 139, 220));
		JLabel startMessageLabel = new JLabel();
		startMessageLabel.setText("<HTML><br/><br/>Find your next travel destination!</HTML>");
		startMessageLabel.setFont(new Font("HelveticaNeue", Font.BOLD, 17));
		startMessageLabel.setForeground(Color.white);
		startMessageLabel.setHorizontalTextPosition(JLabel.CENTER);
		startMessageLabel.setVerticalTextPosition(JLabel.CENTER);
		startMessagePanel.add(startMessageLabel);
		startFrame.add(startMessagePanel, BorderLayout.CENTER);

		// start Frame Button
		JPanel getStartedButtonPanel = new JPanel();
		getStartedButtonPanel.setBackground(new Color(34, 139, 220));
		JButton getStartedButton = new JButton();
		getStartedButton.setText("Find out");
		getStartedButton.setPreferredSize(new Dimension(100, 30));
		getStartedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUICityPicker cityPickerFrame = new GUICityPicker();
				try {
					cityPickerFrame.cityPickerWindow(travellerList, cityHashMap);
				} catch (SQLException | IOException | WikipediaNoCityException e1) {
					e1.printStackTrace();
				}
			}
		});
		getStartedButtonPanel.add(getStartedButton);
		startFrame.add(getStartedButtonPanel, BorderLayout.SOUTH);

		startFrame.setResizable(false);
		startFrame.pack();
	}

}
