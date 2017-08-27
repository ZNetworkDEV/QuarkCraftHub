/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package net.quarkcraft.hub.enums;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.quarkcraft.api.enums.Rangos;
import net.quarkcraft.hub.enums.MascotasTip;
import net.quarkcraft.hub.utils.Utilidades;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;

public class Mascotas {
	private String name;
	private String displayName;
	private List<String> lore;
	private Material getMaterial;
	private Rangos rango;
	private MascotasTip tipo;
	private EntityType mascotatipo;
	private String url;
	private boolean evolucion;
	private String evolucionurl;
	private boolean cofre;
	private String permiso;
	private static final List<Mascotas> VALUES = new ArrayList();
	public static final Mascotas Vaca;
	public static final Mascotas Pollo;
	public static final Mascotas Perro;
	public static final Mascotas Cerdo;
	public static final Mascotas SilverFish;
	public static final Mascotas Zombie;
	public static final Mascotas Gato;
	public static final Mascotas Oveja;
	public static final Mascotas Caballo;
	public static final Mascotas Aldeano;
	public static final Mascotas Murcielago;
	public static final Mascotas Arana;
	public static final Mascotas EsqueletoWhiter;
	public static final Mascotas Esqueleto;
	public static final Mascotas Creeper;
	public static final Mascotas Slime;
	public static final Mascotas MagmaSlime;
	public static final Mascotas Bruja;
	public static final Mascotas Blaze;
	public static final Mascotas Snowman;
	public static final Mascotas Enderman;
	public static final Mascotas Golem;
	public static final Mascotas Calamar;
	public static final Mascotas Magikarp;
	public static final Mascotas Eevee;
	public static final Mascotas Caterpie;
	public static final Mascotas Pidgey;
	public static final Mascotas JigglyPuff;
	public static final Mascotas Growhlite;
	public static final Mascotas Koffing;
	public static final Mascotas Voltorb;
	public static final Mascotas Pickachu;
	public static final Mascotas Charmander;
	public static final Mascotas Stitch;
	public static final Mascotas R2D2;
	public static final Mascotas Sonic;

	static {
      Vaca = new Mascotas("Vaca", Utilidades.Color("&bMascota Vaca"), (List)null, Material.MILK_BUCKET, Rangos.USUARIO, (String)null, (String)null, MascotasTip.Mascota, EntityType.COW, false, true, "MascotaVaca");
      Pollo = new Mascotas("Pollo", Utilidades.Color("&bMascota Pollo"), (List)null, Material.EGG, Rangos.USUARIO, (String)null, (String)null, MascotasTip.Mascota, EntityType.CHICKEN, false, true, "MascotaPollo");
      Perro = new Mascotas("Perro", Utilidades.Color("&bMascota Perro"), (List)null, Material.BONE, Rangos.USUARIO, (String)null, (String)null, MascotasTip.Mascota, EntityType.WOLF, false, true, "MascotaPerro");
      Cerdo = new Mascotas("Cerdo", Utilidades.Color("&bMascota Cerdo"), (List)null, Material.PORK, Rangos.USUARIO, (String)null, (String)null, MascotasTip.Mascota, EntityType.PIG, false, true, "MascotaCerdo");
      SilverFish = new Mascotas("Silverfish", Utilidades.Color("&bMascota Silverfish"), (List)null, Material.STONE, Rangos.USUARIO, (String)null, (String)null, MascotasTip.Mascota, EntityType.SILVERFISH, false, false, "MascotaSilverfish");
      Zombie = new Mascotas("Zombie", Utilidades.Color("&bMascota Zombie"), (List)null, Material.ROTTEN_FLESH, Rangos.USUARIO, (String)null, (String)null, MascotasTip.Mascota, EntityType.ZOMBIE, false, false, "MascotaZombie");
      Gato = new Mascotas("Gato", Utilidades.Color("&bMascota Gato"), (List)null, Material.RAW_FISH, Rangos.USUARIO, (String)null, (String)null, MascotasTip.Mascota, EntityType.OCELOT, false, false, "MascotaGato");
      Oveja = new Mascotas("Oveja", Utilidades.Color("&bMascota Oveja"), (List)null, Material.WOOL, Rangos.USUARIO, (String)null, (String)null, MascotasTip.Mascota, EntityType.SHEEP, false, false, "MascotaOveja");
      Caballo = new Mascotas("Caballo", Utilidades.Color("&bMascota Caballo"), (List)null, Material.SADDLE, Rangos.USUARIO, (String)null, (String)null, MascotasTip.Mascota, EntityType.HORSE, false, false, "MascotaCaballo");
      Aldeano = new Mascotas("Aldeano", Utilidades.Color("&bMascota Aldeano"), (List)null, Material.EMERALD, Rangos.USUARIO, (String)null, (String)null, MascotasTip.Mascota, EntityType.VILLAGER, false, false, "MascotaVillano");
      Murcielago = new Mascotas("Murcielago", Utilidades.Color("&bMascota Murcielago"), (List)null, Material.COAL, Rangos.USUARIO, (String)null, (String)null, MascotasTip.Mascota, EntityType.BAT, false, false, "MascotaMurcielago");
      Arana = new Mascotas("Araña", Utilidades.Color("&bMascota Araña"), (List)null, Material.WEB, Rangos.USUARIO, (String)null, (String)null, MascotasTip.Mascota, EntityType.SPIDER, false, false, "MascotaAraña");
      EsqueletoWhiter = new Mascotas("EsqueletoWhiter", Utilidades.Color("&bMascota Esqueleto Whiter"), (List)null, Material.COAL_BLOCK, Rangos.USUARIO, (String)null, (String)null, MascotasTip.Mascota, EntityType.SKELETON, false, false, "MascotaEsqueletoWither");
      Esqueleto = new Mascotas("Esqueleto", Utilidades.Color("&bMascota Esqueleto"), (List)null, Material.BONE, Rangos.USUARIO, (String)null, (String)null, MascotasTip.Mascota, EntityType.SKELETON, false, false, "MascotaEsqueleto");
      Creeper = new Mascotas("Creeper", Utilidades.Color("&bMascota Creeper"), (List)null, Material.SULPHUR, Rangos.USUARIO, (String)null, (String)null, MascotasTip.Mascota, EntityType.CREEPER, false, false, "MascotaCreeper");
      Slime = new Mascotas("Slime", Utilidades.Color("&bMascota Slime"), (List)null, Material.SLIME_BALL, Rangos.USUARIO, (String)null, (String)null, MascotasTip.Mascota, EntityType.SLIME, false, false, "MascotaSlime");
      MagmaSlime = new Mascotas("MagmaSlime", Utilidades.Color("&bMascota Cubo de Magma"), (List)null, Material.MAGMA_CREAM, Rangos.USUARIO, (String)null, (String)null, MascotasTip.Mascota, EntityType.MAGMA_CUBE, false, false, "MascotaCuboDeMagma");
      Bruja = new Mascotas("Bruja", Utilidades.Color("&bMascota Bruja"), (List)null, Material.POTION, Rangos.USUARIO, (String)null, (String)null, MascotasTip.Mascota, EntityType.WITCH, false, false, "MascotaBruja");
      Blaze = new Mascotas("Blaze", Utilidades.Color("&bMascota Blaze"), (List)null, Material.BLAZE_ROD, Rangos.USUARIO, (String)null, (String)null, MascotasTip.Mascota, EntityType.BLAZE, false, false, "MascotaBlaze");
      Snowman = new Mascotas("Snowman", Utilidades.Color("&bMascota Snowman"), (List)null, Material.SNOW_BALL, Rangos.USUARIO, (String)null, (String)null, MascotasTip.Mascota, EntityType.SNOWMAN, false, false, "MascotaSnowman");
      Enderman = new Mascotas("Enderman", Utilidades.Color("&bMascota Enderman"), (List)null, Material.EYE_OF_ENDER, Rangos.USUARIO, (String)null, (String)null, MascotasTip.Mascota, EntityType.ENDERMAN, false, false, "MascotaEnderman");
      Golem = new Mascotas("Golem", Utilidades.Color("&bMascota Golem"), (List)null, Material.IRON_INGOT, Rangos.USUARIO, (String)null, (String)null, MascotasTip.Mascota, EntityType.IRON_GOLEM, false, false, "MascotaGolem");
      Calamar = new Mascotas("Calamar", Utilidades.Color("&bMascota Calamar"), (List)null, Material.INK_SACK, Rangos.USUARIO, (String)null, (String)null, MascotasTip.Mascota, EntityType.SQUID, false, false, "MascotaCalamar");
      Magikarp = new Mascotas("Magikarp", Utilidades.Color("&bCompañero Magikarp"), (List)null, (Material)null, Rangos.USUARIO, "2f58fb7cbf9f8dcfc3bc9d61c7cb5b229bf49db1101336ffdc2d087c0b94162", "1ab93af668cb83e379e9edbcdc4532f1294f90cb13de6a582efab87696c36dd", MascotasTip.Compa�ero, EntityType.WOLF, true, false, "CompañeroMagikarp");
      Eevee = new Mascotas("Eevee", Utilidades.Color("&bCompañero Eevee"), (List)null, (Material)null, Rangos.USUARIO, "a044e9d19bef47933aff42bce4b458f431315090d613f54b6e795da59db9d0de", "25a8f67722bef093c67cce14587d67b375e27a82fa777a88218ba11af9c13b", MascotasTip.Compa�ero, EntityType.WOLF, true, false, "CompañeroEevee");
      Caterpie = new Mascotas("Caterpie", Utilidades.Color("&bCompañero Caterpie"), (List)null, (Material)null, Rangos.USUARIO, "8aa253fadd897a6a19aad3959c44fb4ceac5a8ca588f10e52ec8cfbb4144c6d", "a1eee2ace8b4a89572bd1a57d47fc1927b89abd60cc79cb8c77faa7458144e", MascotasTip.Compa�ero, EntityType.WOLF, true, false, "CompañeroCaterpie");
      Pidgey = new Mascotas("Pidgey", Utilidades.Color("&bCompañero Pidgey"), (List)null, (Material)null, Rangos.USUARIO, "016f595e8f6791bc154659a8976f6a8ffd9847cf75a2bf63992e3a655e0", "26c96aef6558f29b247bc8e38d93206143f1314475c5fcd11e2efcc5db55e85", MascotasTip.Compa�ero, EntityType.WOLF, true, false, "CompañeroPidgey");
      JigglyPuff = new Mascotas("JigglyPuff", Utilidades.Color("&bCompañero JigglyPuff"), (List)null, (Material)null, Rangos.USUARIO, "ba6f12621e5363595bc6d68fa185cedfceaada3d82b60c13fdc4a03269", "", MascotasTip.Compa�ero, EntityType.WOLF, false, false, "CompañeroJigglyPuff");
      Growhlite = new Mascotas("Growhlite", Utilidades.Color("&bCompañero Growhlite"), (List)null, (Material)null, Rangos.USUARIO, "815213d385268ad3bd179e613f1fac99fa8392831fc9f6f10db599cf59ceffb", "c430bda19c47bc791be11f5c74bcbd83effc606d291bb4d36988b766f6c6", MascotasTip.Compa�ero, EntityType.WOLF, true, false, "CompañeroGrowhlite");
      Koffing = new Mascotas("Koffing", Utilidades.Color("&bCompañero Koffing"), (List)null, (Material)null, Rangos.USUARIO, "f176dec49a931096a09b22add0402ab2c7f48987711091d018e02b4bb1e57", "", MascotasTip.Compa�ero, EntityType.WOLF, false, false, "CompañeroKoffing");
      Voltorb = new Mascotas("Voltorb", Utilidades.Color("&bCompañero Voltorb"), (List)null, (Material)null, Rangos.USUARIO, "e2f3f9cca77c725217e45ad4eeeeffa0565f82b866ac67999b43c3a97311628c", "5eefe1191579957c83250a8ce8fefd55f4d76c50d81094c9209895f4bd600", MascotasTip.Compa�ero, EntityType.WOLF, true, false, "CompañeroVoltorb");
      Pickachu = new Mascotas("Pickachu", Utilidades.Color("&bCompañero Pickachu"), (List)null, (Material)null, Rangos.USUARIO, "dfa695b59618b3616b6aaa910c5a10146195edd6367d25e9399a74ceef966", "abf523f2bd90b3ff1944515b6a324338aad47ea1f2ce93f82d5564c4c9ade71", MascotasTip.Compa�ero, EntityType.WOLF, true, false, "CompañeroPickachu");
      Charmander = new Mascotas("Charmander", Utilidades.Color("&bCompañero Charmander"), (List)null, (Material)null, Rangos.USUARIO, "538992fa71d5d98789d5061ddd68e2b7af9efc253b39e1b346343d7789f8dc", "d31711f33665b3e1e99ed8f5f50a63e3f6dec721af2391e34f83e15ce27af", MascotasTip.Compa�ero, EntityType.WOLF, true, false, "CompañeroCharmander");
      Stitch = new Mascotas("Stitch", Utilidades.Color("&bCompañero Stitch"), (List)null, (Material)null, Rangos.USUARIO, "16a8cbe9b5b656345ae034befead26b93677febc88725490416ce7babbd59f3d", "", MascotasTip.Compa�ero, EntityType.WOLF, false, false, "CompañeroStitch");
      R2D2 = new Mascotas("R2D2", Utilidades.Color("&bCompañero R2D2"), (List)null, (Material)null, Rangos.USUARIO, "7cebc97798c2e360551cab3dd5db6d53497fe63040941c9ac491a59cbf383a7a", "", MascotasTip.Compa�ero, EntityType.WOLF, false, false, "CompañeroR2D2");
      Sonic = new Mascotas("Sonic", Utilidades.Color("&bCompañero Sonic"), (List)null, (Material)null, Rangos.USUARIO, "c5f5c9ff94c0dd5cbb1e271a817e6e9c552e3928b159519dd226efabdd", "", MascotasTip.Compa�ero, EntityType.WOLF, false, false, "CompañeroSonic");
   }

	private Mascotas(String name, String displayName, List<String> lore, Material headTexture, Rangos rango, String url,
			String evolucionurl, MascotasTip test, EntityType tipo, boolean evolucion, boolean cofre, String permiso) {
		this.name = name;
		this.displayName = displayName;
		this.lore = lore;
		this.getMaterial = headTexture;
		this.rango = rango;
		this.tipo = test;
		this.mascotatipo = tipo;
		this.url = url;
		this.evolucionurl = evolucionurl;
		this.evolucion = evolucion;
		this.cofre = cofre;
		this.permiso = permiso;
		if (!VALUES.contains(this)) {
			VALUES.add(this);
		}

	}

	public String ObtenerPermiso() {
		return this.permiso;
	}

	public String getName() {
		return this.name;
	}

	public String getUrl() {
		return this.url;
	}

	public String getEvolucionUrl() {
		return this.evolucionurl;
	}

	public Boolean EvolucionarSePuede() {
		return Boolean.valueOf(this.evolucion);
	}

	public MascotasTip getTipo() {
		return this.tipo;
	}

	public EntityType getTipoEntity() {
		return this.mascotatipo;
	}

	public String getDisplayName() {
		return this.displayName;
	}

	public List<String> getLore() {
		return this.lore;
	}

	public Material getMaterial() {
		return this.getMaterial;
	}

	public Rangos getRango() {
		return this.rango;
	}

	public static List<Mascotas> values() {
		return VALUES;
	}

	public boolean SePuedeObtener() {
		return this.cofre;
	}

	public String ObtenerCofreDelTesoro() {
		return this.cofre ? "Si" : "No";
	}

	public static Mascotas valueOf(String name) throws NullPointerException {
		Iterator arg1 = values().iterator();

		while (arg1.hasNext()) {
			Mascotas type = (Mascotas) arg1.next();
			if (type.getName().equalsIgnoreCase(name)) {
				return type;
			}
		}

		return null;
	}
}