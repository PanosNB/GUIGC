public class GCStats{
	public final long T;
	public final String NAME;
	public final long COUNT;
	public final long TIME;
	
	public GCStats(long t, String name, long count, long time){
		this.T = t;
		this.NAME = name;
		this.COUNT = count;
		this.TIME = time;
	}
}
