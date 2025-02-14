package bta.aether.item;

import bta.aether.block.AetherBlocks;
import bta.aether.entity.projectiles.EntityGoldenDart;
import bta.aether.entity.projectiles.EntityPoisonDart;
import bta.aether.entity.projectiles.EntityProjectileModular;
import bta.aether.entity.projectiles.EntityEnchantedDart;
import bta.aether.item.Accessories.ItemAccessoryGoldenFeather;
import bta.aether.item.Accessories.ItemAccessoryInvisibilityCloak;
import bta.aether.item.Accessories.ItemAccessoryIronBubble;
import bta.aether.item.Accessories.ItemAccessoryRegenStone;
import bta.aether.item.Accessories.base.*;
import bta.aether.item.tool.ItemToolAxeZanite;
import bta.aether.item.tool.ItemToolPickaxeZanite;
import bta.aether.item.tool.ItemToolShovelZanite;
import bta.aether.item.tool.base.ItemToolAetherAxe;
import bta.aether.item.tool.base.ItemToolAetherPickaxe;
import bta.aether.item.tool.base.ItemToolAetherShovel;
import bta.aether.world.AetherDimension;
import net.minecraft.core.data.tag.Tag;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.*;
import net.minecraft.core.item.material.ArmorMaterial;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.item.tag.ItemTags;
import net.minecraft.core.item.tool.ItemToolSword;
import net.minecraft.core.util.helper.DamageType;
import net.minecraft.core.world.Dimension;
import net.minecraft.core.world.World;
import turniplabs.halplibe.helper.ArmorHelper;
import turniplabs.halplibe.helper.ItemHelper;

import static net.minecraft.core.block.Block.fluidWaterFlowing;
import static bta.aether.Aether.MOD_ID;

public class AetherItems {
    private static int itemID = 17000;

    // tags
    public static Tag<Item> aetherTool = Tag.of("aether_tool");
    public static Tag<Item> aetherdungeonKey = Tag.of("aether_key");
    public static Tag<Item> aetheregg = Tag.of("aether_egg");

    public static final Item victoryMedal = ItemHelper.createItem(MOD_ID, new Item("victorymedal", itemID++), "VictoryMedal.png").setMaxStackSize(10);

    // See BlockChestLocked.java before using any of these.
    public static final Item keyBronze = ItemHelper.createItem(MOD_ID, new Item("key.bronze", itemID++), "BronzeKey.png").withTags(aetherdungeonKey).setMaxStackSize(1);
    public static final Item keySilver = ItemHelper.createItem(MOD_ID, new Item("key.silver", itemID++), "SilverKey.png").withTags(aetherdungeonKey).setMaxStackSize(1);
    public static final Item keyGold = ItemHelper.createItem(MOD_ID, new Item("key.gold", itemID++), "GoldKey.png").withTags(aetherdungeonKey).setMaxStackSize(1);

    public static final Item bookLoreOverworld = ItemHelper.createItem(MOD_ID, new ItemLoreBook("book.lore.overworld", itemID++, Dimension.overworld.languageKey),  "OverworldBook.png");
    public static final Item bookLoreNether = ItemHelper.createItem(MOD_ID, new ItemLoreBook("book.lore.nether", itemID++, Dimension.nether.languageKey),  "NetherBook.png");
    public static final Item bookLoreAether = ItemHelper.createItem(MOD_ID, new ItemLoreBook("book.lore.aether", itemID++, AetherDimension.dimensionAether.languageKey),  "AetherBook.png");
    public static final Item bookLoreParadise = ItemHelper.createItem(MOD_ID, new ItemLoreBook("book.lore.paradise", itemID++, Dimension.paradise.languageKey),  "paradise_book.png");

    public static final Item eggMoaBlue = ItemHelper.createItem(MOD_ID, new Item("egg.moa.blue", itemID++), "BlueMoaEgg.png").withTags(aetheregg);
    public static final Item eggMoaBlack = ItemHelper.createItem(MOD_ID, new Item("egg.moa.black", itemID++), "BlackMoaEgg.png").withTags(aetheregg);
    public static final Item eggMoaWhite = ItemHelper.createItem(MOD_ID, new Item("egg.moa.white", itemID++), "WhiteMoaEgg.png").withTags(aetheregg);

    public static final Item recordBlue = ItemHelper.createItem(MOD_ID, new ItemRecordAccessor("record.blue", 18400, "AetherTune", "Noisestorm"), "BlueMusicDisk.png").setMaxStackSize(1);
    public static final Item recordSilver = ItemHelper.createItem(MOD_ID, new ItemRecordAccessor("record.silver", 18401, "AMorningWish", "Emile van Krieken"), "silver_music_disk.png").setMaxStackSize(1);
    public static final Item recordPink = ItemHelper.createItem(MOD_ID, new ItemRecordAccessor("record.pink", 18402, "AscendingDawn", "Emile van Krieken"), "pink_music_disk.png").setMaxStackSize(1);

    public static final Item amberGolden = ItemHelper.createItem(MOD_ID, new Item("goldenamber", itemID++), "GoldenAmber.png");
    public static final Item petalAechor = ItemHelper.createItem(MOD_ID, new Item("aechorpetal", itemID++), "AechorPetal.png");
    public static final Item stickSkyroot = ItemHelper.createItem(MOD_ID, new Item("stick.skyroot", itemID++), "Stick.png");

    public static final Item dartGolden = ItemHelper.createItem(MOD_ID, new Item("ammo.dart.gold", itemID++),"DartGolden.png");
    public static final Item dartPoison = ItemHelper.createItem(MOD_ID, new Item("ammo.dart.poison", itemID++), "DartPoison.png");
    public static final Item dartEnchanted = ItemHelper.createItem(MOD_ID, new Item("ammo.dart.enchanted",  itemID++), "DartEnchanted.png");

    public static final Item dartShooter = ItemHelper.createItem(MOD_ID, new ItemShooter("tool.dart.shooter", itemID++, AetherItems.dartGolden.id){
        @Override
        public EntityProjectileModular getArrow(World world, EntityPlayer entityPlayer, Boolean belongToPlayer) {
            return new EntityGoldenDart(world, entityPlayer, true);
        }
    }, "DartShooter.png");
    public static final Item dartShooterPoison = ItemHelper.createItem(MOD_ID, new ItemShooter("tool.dart.shooter.poison", itemID++, AetherItems.dartPoison.id){
        @Override
        public EntityProjectileModular getArrow(World world, EntityPlayer entityPlayer, Boolean belongToPlayer) {
            return new EntityPoisonDart(world, entityPlayer, true);
        }
    }, "DartShooterPoison.png");
    public static final Item dartShooterEnchanted = ItemHelper.createItem(MOD_ID, new ItemShooter("tool.dart.shooter.enchanted", itemID++, AetherItems.dartEnchanted.id){
            @Override
            public EntityProjectileModular getArrow(World world, EntityPlayer entityPlayer, Boolean belongToPlayer) {
                return new EntityEnchantedDart(world, entityPlayer, true);
            }
        }, "DartShooterEnchanted.png");

    public static final Item ambrosium = ItemHelper.createItem(MOD_ID, new ItemFoodStackable("ambrosium", itemID++, 1, false, 64), "AmbrosiumShard.png");
    public static final Item gemZanite = ItemHelper.createItem(MOD_ID, new Item("zanite", itemID++), "Zanite.png");

    public static final Item bucketSkyroot = ItemHelper.createItem(MOD_ID, new ItemSkyrootBucketEmpty("bucket.skyroot", itemID++), "Bucket.png");
    public static final Item bucketSkyrootWater = ItemHelper.createItem(MOD_ID, new ItemSkyrootBucket("bucket.skyroot.water", itemID++, fluidWaterFlowing, 0), "BucketWater.png").setContainerItem(bucketSkyroot);
    public static final Item bucketSkyrootMilk = ItemHelper.createItem(MOD_ID, new ItemSkyrootBucket("bucket.skyroot.milk", itemID++, null, 1), "BucketMilk.png").setContainerItem(bucketSkyroot);
    public static final Item bucketSkyrootPoison = ItemHelper.createItem(MOD_ID, new ItemSkyrootBucket("bucket.skyroot.poison", itemID++, null, 2), "BucketPoison.png").setContainerItem(bucketSkyroot);
    public static final Item bucketSkyrootRemedy = ItemHelper.createItem(MOD_ID, new ItemSkyrootBucket("bucket.skyroot.remedy", itemID++, null, 3), "BucketRemedy.png").setContainerItem(bucketSkyroot);
    public static final Item bucketSkyrootIcecream = ItemHelper.createItem(MOD_ID, new ItemSkyrootBucketIceCream("bucket.skyroot.icecream", itemID++, 10), "skyroot_icecream_bucket.png").setContainerItem(bucketSkyroot);

    public static final Item healingStone = ItemHelper.createItem(MOD_ID, new ItemFood("food.healingstone", itemID++, 4, false), "HealingStone.png");

    public static final ToolMaterial toolskyroot = new ToolMaterialAether()/*.setDropMultipier(2)*/.setDurability(64).setEfficiency(2.0F, 4.0f).setMiningLevel(0).setBlockHitDelay(0);
    public static final ToolMaterial toolholystone = new ToolMaterial().setDurability(128).setEfficiency(4.0F, 6.0F).setMiningLevel(1).setBlockHitDelay(0);
    public static final ToolMaterial toolzanite = new ToolMaterial().setDurability(256).setEfficiency(6.0F, 8.0F).setMiningLevel(2).setBlockHitDelay(0);
    public static final ToolMaterial toolgravitite = new ToolMaterial().setDurability(1536).setEfficiency(10.0F, 25.0F).setMiningLevel(3).setBlockHitDelay(2);
    public static final ToolMaterial toolvalkyrie = new ToolMaterial().setDurability(1536).setEfficiency(12.0f, 35.0f).setMiningLevel(3).setBlockHitDelay(3);
    public static final ToolMaterial swordSpecialMaterial = new ToolMaterial().setDurability(32).setEfficiency(2.0f, 4.0f).setMiningLevel(0);
    public static final ToolMaterial swordHolyMaterial = new ToolMaterial().setDurability(128).setEfficiency(2.0f, 4.0f).setMiningLevel(0);

    public static final Item toolPickaxeSkyroot = ItemHelper.createItem(MOD_ID, new ItemToolAetherPickaxe("tool.pickaxe.skyroot",itemID++, toolskyroot), "PickSkyroot.png").withTags(aetherTool);
    public static final Item toolShovelSkyroot = ItemHelper.createItem(MOD_ID, new ItemToolAetherShovel("tool.shovel.skyroot",itemID++, toolskyroot), "ShovelSkyroot.png").withTags(aetherTool);
    public static final Item toolAxeSkyroot = ItemHelper.createItem(MOD_ID, new ItemToolAetherAxe("tool.axe.skyroot", itemID++, toolskyroot), "AxeSkyroot.png").withTags(aetherTool);
    public static final Item toolSwordSkyroot = ItemHelper.createItem(MOD_ID, new ItemToolSword("tool.sword.skyroot", itemID++, toolskyroot), "SwordSkyroot.png").withTags(ItemTags.preventCreativeMining, aetherTool);;

    public static final Item toolPickaxeHolystone = ItemHelper.createItem(MOD_ID, new ItemToolAetherPickaxe("tool.pickaxe.holystone",itemID++, toolholystone), "PickHolystone.png").withTags(aetherTool);
    public static final Item toolShovelHolystone = ItemHelper.createItem(MOD_ID, new ItemToolAetherShovel("tool.shovel.holystone",itemID++, toolholystone), "ShovelHolystone.png").withTags(aetherTool);
    public static final Item toolAxeHolystone = ItemHelper.createItem(MOD_ID, new ItemToolAetherAxe("tool.axe.holystone",itemID++, toolholystone), "AxeHolystone.png").withTags(aetherTool);
    public static final Item toolSwordHolystone = ItemHelper.createItem(MOD_ID, new ItemToolSword("tool.sword.holystone", itemID++, toolholystone), "SwordHolystone.png").withTags(ItemTags.preventCreativeMining, aetherTool);;

    public static final Item toolPickaxeZanite = ItemHelper.createItem(MOD_ID, new ItemToolPickaxeZanite("tool.pickaxe.zanite", itemID++, toolzanite), "PickZanite.png").withTags(aetherTool);
    public static final Item toolShovelZanite = ItemHelper.createItem(MOD_ID, new ItemToolShovelZanite("tool.shovel.zanite", itemID++, toolzanite), "ShovelZanite.png").withTags(aetherTool);
    public static final Item toolAxeZanite = ItemHelper.createItem(MOD_ID, new ItemToolAxeZanite("tool.axe.zanite", itemID++, toolzanite), "AxeZanite.png").withTags(aetherTool);
    public static final Item toolSwordZanite = ItemHelper.createItem(MOD_ID, new ItemToolSword("tool.sword.zanite", itemID++, toolzanite), "SwordZanite.png").withTags(ItemTags.preventCreativeMining, aetherTool);;

    public static final Item toolPickaxeGravitite = ItemHelper.createItem(MOD_ID, new ItemToolAetherPickaxe("tool.pickaxe.gravitite", itemID++, toolgravitite), "PickGravitite.png").withTags(aetherTool);
    public static final Item toolShovelGravitite = ItemHelper.createItem(MOD_ID, new ItemToolAetherShovel("tool.shovel.gravitite", itemID++, toolgravitite), "ShovelGravitite.png").withTags(aetherTool);
    public static final Item toolAxeGravitite = ItemHelper.createItem(MOD_ID, new ItemToolAetherAxe("tool.axe.gravitite", itemID++, toolgravitite), "AxeGravitite.png").withTags(aetherTool);
    public static final Item toolSwordGravitite = ItemHelper.createItem(MOD_ID, new ItemToolSword("tool.sword.gravitite", itemID++, toolgravitite), "SwordGravitite.png").withTags(ItemTags.preventCreativeMining, aetherTool);;

    public static final Item toolPickaxeValkyrie = ItemHelper.createItem(MOD_ID, new ItemToolAetherPickaxe("tool.pickaxe.valkyrie", itemID++, toolvalkyrie), "ValkyriePickaxe.png").withTags(aetherTool);
    public static final Item toolShovelValkyrie = ItemHelper.createItem(MOD_ID, new ItemToolAetherShovel("tool.shovel.valkyrie", itemID++, toolvalkyrie), "ValkyrieShovel.png").withTags(aetherTool);
    public static final Item toolAxeValkyrie = ItemHelper.createItem(MOD_ID, new ItemToolAetherAxe("tool.axe.valkyrie", itemID++, toolvalkyrie), "ValkyrieAxe.png").withTags(aetherTool);
    public static final Item toolSwordValkyrie = ItemHelper.createItem(MOD_ID, new ItemToolSword("tool.sword.valkyrie", itemID++, toolvalkyrie), "Lance.png").withTags(ItemTags.preventCreativeMining, aetherTool);;

    //Armor
    public static final ArmorMaterial armorZanite = ArmorHelper.createArmorMaterial("Zanite", 200, 0f, 0f, 0f, 0f); // all zeros are intended, uses custom protection values
    public static final ArmorMaterial armorGravitite = ArmorHelper.createArmorMaterial("Gravitite", 800, 66f, 66f, 66f, 150f);
    public static final ArmorMaterial armorPhoenix = ArmorHelper.createArmorMaterial("Phoenix", 800, 150f, 0f, 150f, 0f);
    public static final ArmorMaterial armorObsidian = ArmorHelper.createArmorMaterial("Obsidian", 1200, 0f, 150f, 150f, 0f);
    public static final ArmorMaterial armorNeptune = ArmorHelper.createArmorMaterial("Neptune", 800, 150f, 150f, 0f, 0f).withProtectionPercentage(DamageType.DROWN, 50f);

//    public static final ArmorMaterial LEATHER = ArmorMaterial.register(new ArmorMaterial("cloth", 0, 180).COMBAT, 20.0f).BLAST, 20.0f).FIRE, 20.0f).FALL, 120.0f));
//    public static final ArmorMaterial CHAINMAIL = ArmorMaterial.register(new ArmorMaterial("chain", 1, 240).COMBAT, 120.0f).BLAST, 35.0f).FIRE, 35.0f).FALL, 35.0f));
//    public static final ArmorMaterial IRON = ArmorMaterial.register(new ArmorMaterial("iron", 2, 200).COMBAT, 45.0f).BLAST, 45.0f).FIRE, 45.0f).FALL, 45.0f));
//    public static final ArmorMaterial GOLD = ArmorMaterial.register(new ArmorMaterial("gold", 4, 120).COMBAT, 70.0f).BLAST, 70.0f).FIRE, 70.0f).FALL, 70.0f));
//    public static final ArmorMaterial DIAMOND = ArmorMaterial.register(new ArmorMaterial("diamond", 3, 800).COMBAT, 66.0f).BLAST, 66.0f).FIRE, 124.0f).FALL, 66.0f));
//    public static final ArmorMaterial STEEL = ArmorMaterial.register(new ArmorMaterial("steel", 5, 1200).COMBAT, 55.0f).BLAST, 150.0f).FIRE, 55.0f).FALL, 55.0f));


    public static final Item armorHelmetZanite = ItemHelper.createItem(MOD_ID, new ItemArmor("armor.helmet.zanite", itemID++, armorZanite, 0), "ZaniteHelmet.png");
    public static final Item armorChestplateZanite = ItemHelper.createItem(MOD_ID, new ItemArmor("armor.chestplate.zanite", itemID++, armorZanite, 1), "ZaniteChestplate.png");
    public static final Item armorLeggingsZanite = ItemHelper.createItem(MOD_ID, new ItemArmor("armor.leggings.zanite", itemID++, armorZanite, 2), "ZaniteLeggings.png");
    public static final Item armorBootsZanite = ItemHelper.createItem(MOD_ID, new ItemArmor("armor.boots.zanite", itemID++, armorZanite, 3), "ZaniteBoots.png");
    public static final Item armorHelmetGravitite = ItemHelper.createItem(MOD_ID, new ItemArmor("armor.helmet.gravitite", itemID++, armorGravitite, 0), "GravititeHelmet.png");
    public static final Item armorChestplateGravitite = ItemHelper.createItem(MOD_ID, new ItemArmor("armor.chestplate.gravitite", itemID++, armorGravitite, 1), "GravititeChestplate.png");
    public static final Item armorLeggingsGravitite = ItemHelper.createItem(MOD_ID, new ItemArmor("armor.leggings.gravitite", itemID++, armorGravitite, 2), "GravititeLeggings.png");
    public static final Item armorBootsGravitite = ItemHelper.createItem(MOD_ID, new ItemArmor("armor.boots.gravitite", itemID++, armorGravitite, 3), "GravititeBoots.png");

    public static final Item armorHelmetPhoenix = ItemHelper.createItem(MOD_ID, new ItemArmor("armor.helmet.phoenix", itemID++, armorPhoenix, 0), "PhoenixHelmet.png");
    public static final Item armorChestplatePhoenix = ItemHelper.createItem(MOD_ID, new ItemArmor("armor.chestplate.phoenix", itemID++, armorPhoenix, 1), "PhoenixChestplate.png");
    public static final Item armorLeggingsPhoenix = ItemHelper.createItem(MOD_ID, new ItemArmor("armor.leggings.phoenix", itemID++, armorPhoenix, 2), "PhoenixLeggings.png");
    public static final Item armorBootsPhoenix = ItemHelper.createItem(MOD_ID, new ItemArmor("armor.boots.phoenix", itemID++, armorPhoenix, 3), "PhoenixBoots.png");

    public static final Item armorHelmetObsidian = ItemHelper.createItem(MOD_ID, new ItemArmor("armor.helmet.obsidian", itemID++, armorObsidian, 0), "ObsidianHelmet.png");
    public static final Item armorChestplateObsidian = ItemHelper.createItem(MOD_ID, new ItemArmor("armor.chestplate.obsidian", itemID++, armorObsidian, 1), "ObsidianChestplate.png");
    public static final Item armorLeggingsObsidian = ItemHelper.createItem(MOD_ID, new ItemArmor("armor.leggings.obsidian", itemID++, armorObsidian, 2), "ObsidianLeggings.png");
    public static final Item armorBootsObsidian = ItemHelper.createItem(MOD_ID, new ItemArmor("armor.boots.obsidian", itemID++, armorObsidian, 3), "ObsidianBoots.png");

    public static final Item armorHelmetNeptune = ItemHelper.createItem(MOD_ID, new ItemArmor("armor.helmet.neptune", itemID++, armorNeptune, 0), "NeptuneHelmet.png");
    public static final Item armorChestplateNeptune = ItemHelper.createItem(MOD_ID, new ItemArmor("armor.chestplate.neptune", itemID++, armorNeptune, 1), "NeptuneChestplate.png");
    public static final Item armorLeggingsNeptune = ItemHelper.createItem(MOD_ID, new ItemArmor("armor.leggings.neptune", itemID++, armorNeptune, 2), "NeptuneLeggings.png");
    public static final Item armorBootsNeptune = ItemHelper.createItem(MOD_ID, new ItemArmor("armor.boots.neptune", itemID++, armorNeptune, 3), "NeptuneBoots.png");


    public static final Item toolSwordPig = ItemHelper.createItem(MOD_ID, new ItemPigSlayer("tool.sword.pig", itemID++), "PigSlayer.png").withTags(ItemTags.preventCreativeMining);
    public static final Item toolSwordVampire = ItemHelper.createItem(MOD_ID, new ItemVampireSword("tool.sword.vampire", itemID++, ToolMaterial.diamond), "VampireBlade.png").withTags(ItemTags.preventCreativeMining);

    public static final Item toolSwordFlaming = ItemHelper.createItem(MOD_ID, new ItemSwordFlaming("tool.sword.flaming", itemID++, swordSpecialMaterial), "FlameSword.png").withTags(ItemTags.preventCreativeMining);;
    public static final Item toolSwordHoly = ItemHelper.createItem(MOD_ID, new ItemSwordHoly("tool.sword.holy", itemID++, swordHolyMaterial), "HolySword.png").withTags(ItemTags.preventCreativeMining);;
    public static final Item toolSwordLightning = ItemHelper.createItem(MOD_ID, new ItemSwordLightning("tool.sword.lightning", itemID++, swordSpecialMaterial), "LightningSword.png").withTags(ItemTags.preventCreativeMining);;

    public static final Item toolStaffNature = ItemHelper.createItem(MOD_ID, new Item("tool.staff.nature", itemID++), "NatureStaff.png");
    public static final Item toolStaffCloud = ItemHelper.createItem(MOD_ID, new Item("tool.staff.cloud", itemID++), "CloudStaff.png");

    public static final Item toolKnifeLightning = ItemHelper.createItem(MOD_ID, new ItemLightningKnife("tool.knife.lightning", itemID++), "LightningKnife.png").withTags(ItemTags.preventCreativeMining);;
    public static final Item toolHammerNotch = ItemHelper.createItem(MOD_ID, new ItemHammerNotch("tool.hammer.notch", itemID++, ToolMaterial.diamond), "HammerNotch.png").withTags(ItemTags.preventCreativeMining);;
    public static final Item toolBowPhoenix = ItemHelper.createItem(MOD_ID, new ItemPhoenixBow("tool.bow.phoenix", itemID++), "PhoenixBow.png");

    public static final Item armorGlovesLeather = ItemHelper.createItem(MOD_ID, new ItemAccessoryGloves("armor.gloves.leather", itemID++, "/assets/aether/armor/leather_pendant_and_gloves.png"), "LeatherGloves.png");
    public static final Item armorGlovesChain = ItemHelper.createItem(MOD_ID, new ItemAccessoryGloves("armor.gloves.chain", itemID++, "/assets/aether/armor/chain_pendant_and_gloves.png"), "GloveChain.png");
    public static final Item armorGlovesIron = ItemHelper.createItem(MOD_ID, new ItemAccessoryGloves("armor.gloves.iron", itemID++, "/assets/aether/armor/Accessories.png"), "IronGloves.png");
    public static final Item armorGlovesGold = ItemHelper.createItem(MOD_ID, new ItemAccessoryGloves("armor.gloves.gold", itemID++, "/assets/aether/armor/gold_pendant_and_gloves.png"), "GoldGloves.png");
    public static final Item armorGlovesDiamond = ItemHelper.createItem(MOD_ID, new ItemAccessoryGloves("armor.gloves.diamond", itemID++, "/assets/aether/armor/diamond_pendant_and_gloves.png"), "DiamondGloves.png");
    public static final Item armorGlovesSteel = ItemHelper.createItem(MOD_ID, new ItemAccessoryGloves("armor.gloves.steel", itemID++, "/assets/aether/armor/steel_pendant_and_gloves.png"), "steel_gloves.png");
    public static final Item armorGlovesZanite = ItemHelper.createItem(MOD_ID, new ItemAccessoryGloves("armor.gloves.zanite", itemID++, "/assets/aether/armor/zanite_pendant_and_gloves.png"), "ZaniteGloves.png");
    public static final Item armorGlovesGravitite = ItemHelper.createItem(MOD_ID, new ItemAccessoryGloves("armor.gloves.gravitite", itemID++, "/assets/aether/armor/gravitite_pendant_and_gloves.png"), "GravititeGloves.png");
    public static final Item armorGlovesPhoenix = ItemHelper.createItem(MOD_ID, new ItemAccessoryGloves("armor.gloves.phoenix", itemID++, "/assets/aether/armor/Phoenix.png"), "PhoenixGloves.png");
    public static final Item armorGlovesObsidian = ItemHelper.createItem(MOD_ID, new ItemAccessoryGloves("armor.gloves.obsidian", itemID++, "/assets/aether/armor/obsidian_pendant_and_gloves.png"), "ObsidianGloves.png");
    public static final Item armorGlovesNeptune = ItemHelper.createItem(MOD_ID, new ItemAccessoryGloves("armor.gloves.neptune", itemID++, "/assets/aether/armor/neptune_pendant_and_gloves.png"), "NeptuneGloves.png");

    public static final Item armorRingIron = ItemHelper.createItem(MOD_ID, new ItemAccessoryRing("armor.ring.iron", itemID++), "IronRing.png");
    public static final Item armorRingGold = ItemHelper.createItem(MOD_ID, new ItemAccessoryRing("armor.ring.gold", itemID++), "GoldRing.png");
    public static final Item armorRingZanite = ItemHelper.createItem(MOD_ID, new ItemAccessoryRing("armor.ring.zanite", itemID++), "ZaniteRing.png");
    public static final Item armorRingIce = ItemHelper.createItem(MOD_ID, new ItemRingIce("armor.ring.ice", itemID++), "IceRing.png");

    public static final Item armorPendantIron = ItemHelper.createItem(MOD_ID, new ItemAccessoryPendant("armor.pendant.iron", itemID++, "/assets/aether/armor/Accessories.png"), "IronPendant.png");
    public static final Item armorPendantGold = ItemHelper.createItem(MOD_ID, new ItemAccessoryPendant("armor.pendant.gold", itemID++, "/assets/aether/armor/gold_pendant_and_gloves.png"), "GoldPendant.png");
    public static final Item armorPendantZanite = ItemHelper.createItem(MOD_ID, new ItemAccessoryPendant("armor.pendant.zanite", itemID++, "/assets/aether/armor/zanite_pendant_and_gloves.png"), "ZanitePendant.png");
    public static final Item armorPendantIce = ItemHelper.createItem(MOD_ID, new ItemPendantIce("armor.pendant.ice", itemID++, "/assets/aether/armor/ice_pendant_and_gloves.png"), "IcePendant.png");

    public static final Item armorTalismanIronBubble = ItemHelper.createItem(MOD_ID, new ItemAccessoryIronBubble("armor.talisman.ironbubble", itemID++), "IronBubble.png");
    public static final Item armorTalismanGoldenFeather = ItemHelper.createItem(MOD_ID, new ItemAccessoryGoldenFeather("armor.talisman.goldenfeather", itemID++), "GoldenFeather.png");
    public static final Item armorTalismanRegenStone = ItemHelper.createItem(MOD_ID, new ItemAccessoryRegenStone("armor.talisman.regenstone", itemID++), "RegenerationStone.png");

    public static final Item armorShieldRepulsion = ItemHelper.createItem(MOD_ID, new ItemAccessoryShield("armor.shield.repulsion", itemID++), "RepulsionShield.png");

    public static final Item armorCapeSwet = ItemHelper.createItem(MOD_ID, new ItemAccessoryCape("armor.cape.swet", itemID++, "/assets/aether/other/AetherCape.png"), "AetherCape.png");
    public static final Item armorCloakInvisibility = ItemHelper.createItem(MOD_ID, new ItemAccessoryInvisibilityCloak("armor.cape.invisibility", itemID++, "/assets/aether/other/InvisCape.png"), "InvisibilityCloak.png");
    public static final Item armorCapeAgility = ItemHelper.createItem(MOD_ID, new ItemAccessoryCape("armor.cape.agility", itemID++, "/assets/aether/other/AgilityCape.png"), "AgilityCape.png");

    public static final Item armorCapeWhite = ItemHelper.createItem(MOD_ID, new ItemAccessoryCape("armor.cape.white", itemID++, "/assets/aether/other/WhiteCape.png"), "Cape.png");
    public static final Item armorCapeRed = ItemHelper.createItem(MOD_ID, new ItemAccessoryCape("armor.cape.red", itemID++, "/assets/aether/other/RedCape.png"), "RedCape.png");
    public static final Item armorCapeYellow = ItemHelper.createItem(MOD_ID, new ItemAccessoryCape("armor.cape.yellow", itemID++, "/assets/aether/other/YellowCape.png"), "YellowCape.png");
    public static final Item armorCapeBlue = ItemHelper.createItem(MOD_ID, new ItemAccessoryCape("armor.cape.blue", itemID++, "/assets/aether/other/BlueCape.png"), "BlueCape.png");

    public static final Item foodGummyBlue = ItemHelper.createItem(MOD_ID, new ItemFoodStackable("food.gummy.blue", itemID++, 20, false, 64), "BlueGummy.png");
    public static final Item foodGummyGold = ItemHelper.createItem(MOD_ID, new ItemFoodStackable("food.gummy.gold", itemID++, 40, false, 64), "GoldGummy.png");

    public static final Item cloudParachute = ItemHelper.createItem(MOD_ID, new Item("cloud.parachute", itemID++), "CloudParachute.png").setMaxStackSize(1);
    public static final Item cloudParachuteGold = ItemHelper.createItem(MOD_ID, new Item("cloud.parachute.gold", itemID++), "GoldenParachute.png").setMaxStackSize(1);

    public static final Item lifeshard = ItemHelper.createItem(MOD_ID, new ItemLifeShard("food.lifeshard", itemID++), "LifeShard.png");
    public static final Item lanternAether = ItemHelper.createItem(MOD_ID, new ItemPlaceable("lantern.firefly.silver", itemID++, AetherBlocks.lanternAetherBlock), "silver_lantern.png");

    public static final Item devStick = ItemHelper.createItem(MOD_ID, new ItemDevStick("dev.stick", itemID++), "Stick.png").setMaxStackSize(1);


    public void initializeItems(){}
}