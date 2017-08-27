/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package net.quarkcraft.hub.utils;

import java.util.ArrayList;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;

public class BannersItems {
	public static ItemStack pokeballBanner() {
		ItemStack i = new ItemStack(Material.BANNER, 1);
		BannerMeta m = (BannerMeta) i.getItemMeta();
		m.setBaseColor(DyeColor.WHITE);
		ArrayList patterns = new ArrayList();
		patterns.add(new Pattern(DyeColor.RED, PatternType.HALF_HORIZONTAL));
		patterns.add(new Pattern(DyeColor.BLACK, PatternType.RHOMBUS_MIDDLE));
		patterns.add(new Pattern(DyeColor.RED, PatternType.STRIPE_TOP));
		patterns.add(new Pattern(DyeColor.WHITE, PatternType.STRIPE_BOTTOM));
		patterns.add(new Pattern(DyeColor.BLACK, PatternType.STRIPE_MIDDLE));
		patterns.add(new Pattern(DyeColor.WHITE, PatternType.CIRCLE_MIDDLE));
		m.setPatterns(patterns);
		m.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
		m.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_POTION_EFFECTS});
		m.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_DESTROYS});
		i.setItemMeta(m);
		return i;
	}
}