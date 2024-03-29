package Controller;

import View.DrawingPanel;
import Controller.DrawingTool;
import Model.Line;
import View.ToolVisitor;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;

/**
 * The tool to create Lines
 * @author Rémi Bastide
 * @version 1.0
 * @see simpledraw.Line
 */

public class LineTool
	extends DrawingTool {
	public boolean iAmActive = false;
	public Point myInitialPoint;
	public Point myFinalPoint;

	public LineTool(DrawingPanel panel) {
		super(panel);
	}

        @Override
	public void mousePressed(MouseEvent e) {
		if (!iAmActive) {
			// First point
			iAmActive = true;
			myInitialPoint = e.getPoint();
			myFinalPoint = myInitialPoint;
			myPanel.setCursor(Cursor.getPredefinedCursor(Cursor.
				MOVE_CURSOR));
                        System.out.println("Ligne ajoutée");
			myPanel.repaint();
		} else {
			// Second point
			iAmActive = false;
			myDrawing.addShape(
				new Line(myInitialPoint, myFinalPoint)
				);
			myPanel.setCursor(Cursor.getDefaultCursor());
			myPanel.repaint();
		}
	}

        @Override
	public void mouseDragged(MouseEvent e) {
		if (iAmActive) {
			myFinalPoint = e.getPoint();
			myPanel.repaint();
		}
	}

        @Override
	public void mouseMoved(MouseEvent e) {
            mouseDragged(e);
        }
        
        @Override
	public void draw(Graphics2D g) {
		if (iAmActive) {
			g.setColor(Color.red);
			g.drawLine(
				myInitialPoint.x,
				myInitialPoint.y,
				myFinalPoint.x,
				myFinalPoint.y
				);
		}
                
	}
        public void accept(ToolVisitor v, Graphics2D g){
            v.visit(this, g);
        }
}
