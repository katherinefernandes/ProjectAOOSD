package xmlParser;

public interface IO {
	
	public void initializeIO();
	
	public void finishReadIO();
	
	public void closeIO();
	
	public void finishWriteIO();
	
	public void insertDataPoint(DataPointParser dataPoint);
	
	public EventParser readEvent();
	
	public void writeEvent(EventParser event);
	
	public boolean hasNext();
	
	public void transferNext();
}
