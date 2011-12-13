package net.llamaslayers.stev.shared.items;

import java.io.Serializable;

public abstract class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	public final String name;
	public final int tier;

	public Item(String name, int tier) {
		this.name = name;
		this.tier = tier;
	}
}
