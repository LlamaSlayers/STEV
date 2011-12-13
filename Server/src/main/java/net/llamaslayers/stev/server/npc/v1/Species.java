package net.llamaslayers.stev.server.npc.v1;

public enum Species {
	SLIME("slime", new String[] { "Slime", "Jelly", "Living Blood", "Living Tear", "Blood Elemental" }, NameGroup.NAMEGROUP_RED, NameGroup.NAMEGROUP_GREEN, NameGroup.NAMEGROUP_YELLOW);

	public final String modelName;
	public final String[] baseNames;
	public final NameGroup[] nameGroups;

	private Species(String modelName, String[] baseNames, NameGroup... nameGroups) {
		this.modelName = modelName;
		this.baseNames = baseNames;
		this.nameGroups = nameGroups;
	}
}
