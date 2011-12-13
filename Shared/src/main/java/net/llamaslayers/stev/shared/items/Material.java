package net.llamaslayers.stev.shared.items;

public class Material extends Item {
	private static final long serialVersionUID = 1L;

	public static enum Type {
		PAPYRUS,
		INK,
		ELEMENT,
		METAL,
		LEATHER,
		WOOD,
		CLOTH
	}
	public final Type type;

	public Material(String name, int tier, Type type) {
		super(name, tier);
		this.type = type;
	}
}
