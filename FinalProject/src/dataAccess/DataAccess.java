package dataAccess;
import java.io.*;
import java.util.*;
import javax.xml.stream.*;
import javax.xml.stream.events.*;

public abstract class DataAccess {
	File dataBase;
	public abstract ObjectData newEntry();
	
	public abstract ObjectData editEntry();
	
	public ObjectData getEntry(ID entryID);
}
