package org.thoughts.on.java.model;

import java.util.Comparator;

import org.apache.log4j.Logger;

public class SortById implements Comparator<OrderItem> {

	Logger log = Logger.getLogger(SortById.class.getSimpleName());
	
	@Override
	public int compare(OrderItem o1, OrderItem o2) {
		log.info("SortById.compare");
		return o1.getId().compareTo(o2.getId());
	}

}
