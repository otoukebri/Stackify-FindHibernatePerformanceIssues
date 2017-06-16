package org.thoughts.on.java.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.apache.log4j.Logger;

@Entity
public class OrderItem {

	@Transient
	private Logger log = Logger.getLogger(OrderItem.class.getSimpleName());

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Version
	private int version;

	private String name;

	@ManyToOne
	@JoinColumn(name = "fk_order")
	private Order order;

	public Long getId() {
		return this.id;
	}

	public int getVersion() {
		return this.version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof OrderItem)) {
			return false;
		}
		OrderItem other = (OrderItem) obj;
		if (id != null) {
			if (!id.equals(other.id)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		return 31;
	}

	@Override
	public String toString() {
		return "OrderItem [log=" + log + ", id=" + id + ", version=" + version
				+ ", title=" + name + ", order=" + order + "]";
	}
}