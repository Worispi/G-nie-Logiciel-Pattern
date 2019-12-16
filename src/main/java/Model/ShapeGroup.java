/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import View.ShapeVisitor ;


/**
 *
 * @author raguiri
 */
public class ShapeGroup extends Shape {

    public List<Shape> group = new ArrayList<Shape>();

   
    @Override
    public void translateBy(int dx, int dy) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (group != null) {
            for (Shape s : group) {
                s.translateBy(dx, dy);
            }
        }

    }

    @Override
    public boolean isPickedBy(Point p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setSelected(boolean selected) {
        if (group != null) {
            for (Shape s : group) {
                if(s.isSelected() != selected){
                s.setSelected(selected);
                }
            }
        }
    }

    public void addShape(Shape s) {
        if (!group.contains(s)) {
            group.add(s);
        }
    }
    
    public void accept(ShapeVisitor v, Graphics2D g){
        v.visit(this, g);
    }

    @Override
    public void draw(Graphics2D g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
