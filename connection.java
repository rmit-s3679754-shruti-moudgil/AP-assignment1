public class connection {
	public person p1;
	public person p2;
	public String typeOfConn ;

	
	public connection (person p11, person p22, String type)
	{
		this.p1 = p11;
		this.p2 = p22;
		p11.numOfConnections += 1;
		p22.numOfConnections += 1;
		this.typeOfConn = type;
	}
}
