package xmlParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;

class XMLIO implements IO{
	private XMLEventReader reader;
	private XMLEventWriter writer;
	private FileInputStream streamIn;
	private FileOutputStream streamOut;
	private File fileIn;
	private File fileOut;
	
	public XMLIO(String fileInPath) {
		this.fileIn = new File(fileInPath);
		fileOut = new File(fileInPath.substring(0, fileInPath.length() - 4) + "Temp.xml");
	}
	
	public void initializeIO() {
		try {
			fileOut.createNewFile();
			streamIn = new FileInputStream(fileIn);
			streamOut = new FileOutputStream(fileOut);
			reader = XMLInputFactory.newInstance().createXMLEventReader(streamIn);
			writer = XMLOutputFactory.newInstance().createXMLEventWriter(streamOut);
		} catch (XMLStreamException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public void finishReadIO() {
		fileOut.delete();
		closeIO();
	}
	
	public void closeIO(){
		try {
			writer.close();
			reader.close();
			streamIn.close();
			streamOut.close();
		} catch (IOException | XMLStreamException e) {
			e.printStackTrace();
		}
	}
	
	public void finishWriteIO() {
		try {
			writer.flush();
			closeIO();
			Files.move(fileOut.toPath(),fileIn.toPath(), StandardCopyOption.REPLACE_EXISTING);
			fileOut.delete();
		} catch (IOException | XMLStreamException e) {
			e.printStackTrace();
		}
	}
	
	public void insertDataPoint(DataPointParser dataPoint) {
		try {
		for(EventParser event : dataPoint.getDataPoint()) {
				writer.add(event.getEvent());
			} 
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}
	
	public EventParser readEvent() {
		try {
			return new EventParser(reader.nextEvent());
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		throw new Error();
	}
	
	public void writeEvent(EventParser event) {
		try {
			writer.add(event.getEvent());
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}
	
	public boolean hasNext() {
		return reader.hasNext();
	}
	
	public void transferNext() {
		try {
			writer.add(reader.nextEvent());
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}
}
