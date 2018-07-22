package cache;

import org.infinispan.Cache;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.manager.DefaultCacheManager;

public class InfinispanRunner {
	static {
        System.setProperty("log4j.configurationFile", "resources/configuration.xml");
    }

	public static void main(String[] args) {

		DefaultCacheManager cacheManager = new DefaultCacheManager();
	    cacheManager.defineConfiguration("local", new ConfigurationBuilder().persistence()
	    	    .addSingleFileStore()
	    	    .location("lib\\infinispan\\myDataStore")
	    	    .maxEntries(5000).build());
	    Cache<String, String> cache = cacheManager.getCache("local");
	    
    	for(int i=0; i<5; i++) {
    		System.out.println("Inserting " + i);
	    	cache.put("key" + i, "value" + i);
	    	System.out.println("Retrieving at key " + i + " = " + cache.get("key" + i));
    	}
	    cacheManager.stop();
	    
	}

}
