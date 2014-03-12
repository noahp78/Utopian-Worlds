package noahp78.survive.plugin.loader;

import java.io.File;
import java.util.Collection;

import net.xeoh.plugins.base.Plugin;
import net.xeoh.plugins.base.PluginManager;
import net.xeoh.plugins.base.impl.PluginManagerFactory;
import net.xeoh.plugins.base.util.PluginManagerUtil;

public class pluginLoader {
	public static void load(){
		PluginManager pm = PluginManagerFactory.createPluginManager();
		pm.addPluginsFrom(new File("plugins/").toURI());
		BasicPlugin plugin = pm.getPlugin(BasicPlugin.class);
		plugin.GetVersion();
		
	}
}
