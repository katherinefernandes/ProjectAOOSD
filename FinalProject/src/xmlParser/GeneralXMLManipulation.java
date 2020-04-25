package xmlParser;

import objectsData.ObjectDataInterface;

public abstract class GeneralXMLManipulation<T extends ObjectDataInterface> {
	protected String dataPointTagName;
	protected String collectionTagName;
	protected IO io;
	
	protected GeneralXMLManipulation(String filePath, String elementsName, String collectionsName) {
		this.io = new XMLIO(filePath);
		this.dataPointTagName = elementsName;
		this.collectionTagName = collectionsName;
		Thread shutDownFlush = new Thread(() -> flushActiveData());
		Runtime.getRuntime().addShutdownHook(shutDownFlush);
	}
	
	protected abstract void flushActiveData();
	
	protected abstract void wipeActiveData();
	
	protected abstract T objectFromDataPoint(DataPointParser dataPoint);
	
	protected DataPointParser dataPointFromObject(T object){
		DataPointParser dataPoint = new DataPointParser(object.getTagname());
		dataPoint.createDataPoint(object.getXML());
		return dataPoint;
	}
	
	
	@Override
	public void finalize() {
		flushActiveData();
	}
	
	public void wipe() {
		wipeActiveData();
		io.initializeIO();
		io.transferNext();
		io.transferNext();
		io.writeEvent(EventParser.generateEnd(collectionTagName));
		io.writeEvent(EventParser.generateEndDoc());
		io.finishWriteIO();
	}
}
