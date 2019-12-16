/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Circle;
import Model.Line;
import Model.ShapeGroup;
import java.awt.Graphics2D;

/**
 *
 * @author raguiri
 */
public class ShapePrint implements ShapeVisitor{

    @Override
    public void visit(Line line, Graphics2D g) {
        System.out.println("ligne ajoutée ");
    }

    @Override
    public void visit(Circle circle, Graphics2D g) {
        System.out.println("cercle ajouté ");
    }

    @Override
    public void visit(ShapeGroup group, Graphics2D g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
