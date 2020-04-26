package supportingClasses;

import businessObjects.Container;
import dataBase.DataBase;

public class UpdateHistory {
	public static void updateHistoryDataBase(Container container) {
		DataBase.saveToHistory(container);
	}
}
