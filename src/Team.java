enum Color{
    BLACK,
    WHITE
}
public class Team {

    private final String teamName ;
    private final Color color ;

    public Team(String teamName,Color color) {
        this.teamName = teamName ;
        this.color = color ;
    }

    public Color getColor() {
        return color;
    }

    public String getTeamName() {
        return teamName;
    }
}
