package org.acumen.training.codes.itemc;

public class PointGeneration {
	
	public Point publicMethod() {
		return new Point(11, 11);
	}

	public Point callPrivateMethod(int distance) {
		return privateMethod(new Point(1, 1), distance);
	}

	private Point privateMethod(Point point, int dist) {
		LocatorService locatorService = new LocatorService();
		Point newPoint = locatorService.generatePointWithinDistance(new Point(point.getX() + 1, point.getY() + 1),
				dist);
		return newPoint;
	}
}
