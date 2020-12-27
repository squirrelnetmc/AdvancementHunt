package de.teddy.advancementhunt.permissions;

import de.teddy.advancementhunt.AdvancementHunt;

public enum Permission {

	SET(AdvancementHunt.getInstance().getConfigManager().getMessage("Game.Permissions.SetLocation")),
	START(AdvancementHunt.getInstance().getConfigManager().getMessage("Game.Permissions.StartGame"));
	
	private String permission;
	
	private Permission(String permission) {
		this.permission = permission;
	}
	
	public String getPermission() { return permission; }
	
}
