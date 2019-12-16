/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Circle;
import Model.Line;
import Model.PolyLine;
import Model.Shape;
import Model.ShapeGroup;
import java.awt.Graphics2D;
import javax.swing.GroupLayout.Group;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author raguiri
 */
public class NbShapes extends JPanel implements ShapeVisitor {

    static int nbCercle = 0;
    static int nbLine = 0;
    private static JLabel label = new JLabel("");
    DrawingPanel panel;
    
    public NbShapes( DrawingPanel p){
        super();
        panel = p;
        panel.setBackground(java.awt.Color.WHITE);
        message();
        
    }
    
    public void message(){
        label.setText("il y a "+nbLine+" ligne(s) et "+nbCercle+" cercle(s)");
        panel.add(label);
    }
    
    public void visit(Circle circle) {
        nbCercle = circle.getnbCercle();
        message();
                      System.out.println(nbCercle);
    }
    
    public void visit(Group group) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void visit(Line line) {
     nbLine=line.getnbLine();
     message();
           System.out.println(nbLine);
    }

    public void visit(PolyLine polyline) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void visit(Shape shape) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(ShapeGroup group, Graphics2D g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(Line line, Graphics2D g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(Circle circle, Graphics2D g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}
