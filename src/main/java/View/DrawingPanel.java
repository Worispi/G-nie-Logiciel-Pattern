package View;

import Controller.CircleTool;
import Controller.DrawingTool;
import Controller.GroupTool;
import Controller.LineTool;
import Controller.SelectionTool;
import Controller.UngroupTool;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;
import Model.Drawing;

/**
 * A Panel that displays a Drawing, and maintains a current DrawingTool<BR>
 * Uses the "State" design pattern
 * @author Rémi Bastide
 * @version 1.0
 * @see Model.Drawing
 * @see simpledraw.DrawingTool
 */

public class DrawingPanel
	extends JPanel implements DrawingView{
	DrawingTool myCurrentTool;
	Drawing myDrawing = new Drawing();

	public DrawingPanel() {
		super();
		setBackground(java.awt.Color.white);
		myCurrentTool = new SelectionTool(this);
		activate(myCurrentTool);
	}

	void activateSelectionTool() {
		terminate(myCurrentTool);
		myCurrentTool = new SelectionTool(this);
		activate(myCurrentTool);
                myDrawing.clearSelection();
		repaint();
	}

        void activateGroupTool() {
		terminate(myCurrentTool);
		myCurrentTool = new GroupTool(this);
		activate(myCurrentTool);
                myDrawing.clearSelection();
		repaint();
	}
        
        void activateUngroupTool() {
		terminate(myCurrentTool);
		myCurrentTool = new UngroupTool(this);
		activate(myCurrentTool);
                myDrawing.clearSelection();
		repaint();
	}
        
	void activateCircleTool() {
		terminate(myCurrentTool);
		myCurrentTool = new CircleTool(this);
		activate(myCurrentTool);
		myDrawing.clearSelection();
		repaint();
	}

	void activateLineTool() {
		terminate(myCurrentTool);
		myCurrentTool = new LineTool(this);
                activate(myCurrentTool);
		myDrawing.clearSelection();
		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		RenderingHints qualityHints = new
			RenderingHints(RenderingHints.KEY_ANTIALIASING,
				       RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHints(qualityHints);
		myDrawing.draw(g2);
		myCurrentTool.draw(g2);
	}
        
        private void terminate(DrawingTool t) {
            removeKeyListener(t);
            removeMouseListener(t);
            removeMouseMotionListener(t);
        }
        
       private void activate(DrawingTool t) {
            addKeyListener(t);
            addMouseListener(t);
            addMouseMotionListener(t);
        }
       
       public Drawing getMyDrawing(){
           return myDrawing;
       }

    @Override
    public void notify(Drawing model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 

}
