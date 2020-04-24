package xmlParser;

import java.util.List;

public interface IO {
	
	public void initializeIO();
	
	public void finishReadIO();
	
	public void closeIO();
	
	public void finishWriteIO();
	
	public void insertDataPoint(List<EventParser> dataPoint);
	
	public EventParser readEvent();
	
	public void writeEvent(EventParser event);
	
	public boolean hasNext();
	
	public void transferNext();
}
