package map;

public interface IRecord {
    public void move();
    public Coordinates getVerHor();
    @Deprecated
    public void setVerHor(int[] newVerHor);
    public void setVerHor(Coordinates currentVerHor);
    public void infectNeighbours(Map map);
    public void progressIllness();
    public void performRecovery();
}