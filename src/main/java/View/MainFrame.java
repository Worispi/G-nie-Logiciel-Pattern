package View;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 * Main Frame of SimpleDraw
 * @author Rémi Bastide
 * @version 1.0
 */

public class MainFrame
	extends JFrame {
	JToggleButton mySelectButton = new JToggleButton("Select");
	JToggleButton myLineButton = new JToggleButton("Line");
	JToggleButton myCircleButton = new JToggleButton("Circle");
        JToggleButton myGroupButton = new JToggleButton("Group");
        JToggleButton myUngroupButton = new JToggleButton("Ungroup");
	DrawingPanel myDrawingPanel = new DrawingPanel();

	/**Construct the frame*/
	public MainFrame() {
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		try {
			jbInit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**Component initialization*/
	private void jbInit() throws Exception {
		getContentPane().setLayout(new BorderLayout());
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());

		mySelectButton.setSelected(true);
		mySelectButton.setToolTipText("Select and move shapes");
		myCircleButton.setToolTipText("Draw a Circle");
                myGroupButton.setToolTipText("Select and move multiple shapes");
                myUngroupButton.setToolTipText("Deselect grouped shapes");
		myLineButton.setToolTipText("Draw a Line");

		getContentPane().add(buttonPanel, BorderLayout.NORTH);
		buttonPanel.add(mySelectButton, null);
		buttonPanel.add(myLineButton, null);
		buttonPanel.add(myCircleButton, null);
                buttonPanel.add(myGroupButton, null);
                buttonPanel.add(myUngroupButton, null);
                
		getContentPane().add(myDrawingPanel, BorderLayout.CENTER);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(mySelectButton);
		buttonGroup.add(myLineButton);
		buttonGroup.add(myCircleButton);
                buttonGroup.add(myGroupButton);
                buttonGroup.add(myUngroupButton);

		setSize(new Dimension(400, 300));
		setTitle("Simple Draw");

		mySelectButton.addActionListener(
			new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myDrawingPanel.activateSelectionTool();
			}
		}
		);

                myGroupButton.addActionListener(
			new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myDrawingPanel.activateGroupTool();
			}
		}
		);
                
                 myUngroupButton.addActionListener(
			new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myDrawingPanel.activateUngroupTool();
			}
		}
		);
                
		myLineButton.addActionListener(
			new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myDrawingPanel.activateLineTool();
			}
		}
		);

		myCircleButton.addActionListener(
			new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myDrawingPanel.activateCircleTool();
			}
		}
		);
	}

	/**Overridden so we can exit when window is closed*/
	protected void processWindowEvent(WindowEvent e) {
		super.processWindowEvent(e);
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			System.exit(0);
		}
	}
}
