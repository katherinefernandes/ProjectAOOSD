package worldMap;

import java.util.ArrayList;
import java.util.List;

import dataBase.DataBase;
import objects.Container;
import objects.Port;

public class IconGenerator {
	List<Port> ports;
	public List<Icon> getPortIcons() {
		List<Icon> icons = new ArrayList<>();
		if(ports == null) {
			ports = DataBase.searchPorts("");
		}
		for(Port port : ports) {
			PortIcon portIcon = new PortIcon();
			portIcon.setPositionToCoordinates(port.getPosition());
			icons.add(portIcon);
		}
		return icons;
	}

	public List<Icon> getContainerIcons() {
		List<Icon> icons = new ArrayList<>();
		List<Container> Containers = DataBase.searchContainers("");
		for(Container container : Containers) {
			if(container.getJourneyID() != 0L) {
				BoatIcon boatIcon = new BoatIcon();
				boatIcon.setPositionToCoordinates(container.getCurrentPosition());
				icons.add(boatIcon);
			}
		}
		return icons;
	}
	
}
