package map;

public interface IMapable {
    public void move();
    public Coordinates getVerHor();
    public void setVerHor(int[] newVerHor);
	public void setVerHor(Coordinates currentVerHor);
}