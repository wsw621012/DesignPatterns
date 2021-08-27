package com.lucifer.dp.abstractfactory.traditional;

public class TraditionalAbsShapeFactory {

    public TraditionalFactory createFactory(String factoryName) {
        if (factoryName.equals("circular")) {
            return new TraditionalCircularShapeFactory();
        } else if (factoryName.equals("polygonal")) {
            return new TraditionalPolygonalShapeFactory();
        }
        return null;
    }
}
