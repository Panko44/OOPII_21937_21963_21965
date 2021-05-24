import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class GUIStartPage {

	public void startGUI() {
		// start JFrame
		JFrame startFrame = new JFrame();
		startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startFrame.setTitle("Travel App");
		startFrame.setLayout(new BorderLayout());
		startFrame.getContentPane().setBackground(new Color(34, 139, 220));
		startFrame.setVisible(true);

		// JMenuBar
		JMenuBar menuBar = new JMenuBar();

		JMenu save = new JMenu("Save");
		menuBar.add(save);
		// TODO listener

		JMenu load = new JMenu("Load");
		menuBar.add(load);
		// TODO listener

		JMenu freeTicket = new JMenu("Free Ticket");
		menuBar.add(freeTicket);
		// TODO listener

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
				cityPickerFrame.cityPickerWindow();
			}
		});
		getStartedButtonPanel.add(getStartedButton);
		startFrame.add(getStartedButtonPanel, BorderLayout.SOUTH);

		startFrame.setResizable(false);
		startFrame.pack();
	}

}
