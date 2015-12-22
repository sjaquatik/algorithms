import java.util.Comparator;
import java.util.Collection;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
public class NearestPoint implements PointsOnAPlane {
	private List<Point> listOfPoint;
	public NearestPoint(){
		listOfPoint = new LinkedList<Point>();
	}
	public static void main(String[] args){
		NearestPoint s = new NearestPoint();
		s.addPoint( new Point(0,1));
		s.addPoint( new Point(0,2));
		s.addPoint( new Point(0,3));
		s.addPoint( new Point(0,4));
		s.addPoint( new Point(0,5));
		s.addPoint( new Point(0,6));
		s.addPoint( new Point(0,7));
		s.addPoint( new Point(0,8));
		s.addPoint( new Point(0,9));
		System.out.println(s.findNearest(new Point(0,1),4));
		System.out.println(s.findNearest(new Point(0,8),4));
	}
	public void addPoint(Point point){
		listOfPoint.add(point);
	}

	public Collection<Point> findNearest(Point center, int size){
		int limit = size + 1;
		Comparator<Point> comparator = getComparator(center);
		Queue<Point> priorityQueue = new PriorityQueue<Point>(limit, comparator);
		for( Point p: listOfPoint){
			priorityQueue.offer(p);
			if( priorityQueue.size() == limit){
				priorityQueue.poll();
			}
		}

		return priorityQueue;
	
	}	

	Comparator<Point> getComparator(final Point center){
		
		return new Comparator<Point>(){
			@Override
			public int compare(Point a, Point b){
				Integer distCenterToA = getDistance(center, a);
				Integer distCenterToB = getDistance(center, b);
				return distCenterToA.compareTo(distCenterToB);
			}
		};
	}

	int getDistance(Point a, Point b){
		int dx = a.x - b.x;
		int dy = a.y - b.y;
		return dx*dx + dy*dy;
	}

}

interface PointsOnAPlane{
	void addPoint(Point point);
	Collection<Point> findNearest(Point center, int p);

	static class Point{
		final int x;
		final int y;
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
