package com.vmb.enterprise.langpack.java17;

public class ShapeProcessor {


    public static void main(String[] args) {
        Shape shape = new Shape.Circle(5.0);
        processShape(shape);
    }

    public static void processShape(Shape shape) {

        String result = "no matching";
            if(shape instanceof Shape.Circle c){
                result =  "Circle with radius: " + c.radius();
            } else if(shape instanceof Shape.Rectangle r){
                result =  "Rectangle with width: " + r.width() + " and height: " + r.height();
            }else if(shape instanceof Shape.Square s){
                result =  "Square with side: " + s.side();
            }
        System.out.println(result);
    }
}




