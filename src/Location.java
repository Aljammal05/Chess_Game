public class Location {
    private final int xAxis ;
    private final int yAxis ;

    Location(int xAxis,int yAxis){
        this.xAxis = xAxis ;
        this.yAxis = yAxis ;
    }

    Location(String location){
        this(56-location.charAt(1) , location.charAt(0)-65 );
    }

    public int getY() {
        return yAxis;
    }

    public int getX() {
        return xAxis;
    }
}
