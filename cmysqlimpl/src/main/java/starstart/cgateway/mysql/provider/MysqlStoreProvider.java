package starstart.cgateway.mysql.provider;

import onight.osgi.annotation.iPojoBean;
import onight.tfw.ojpa.api.StoreServiceProvider;
import onight.tfw.ojpa.ordb.ORDBProvider;

import org.apache.felix.ipojo.annotations.Invalidate;
import org.apache.felix.ipojo.annotations.Provides;
import org.apache.felix.ipojo.annotations.Validate;
import org.osgi.framework.BundleContext;

@iPojoBean
@Provides(specifications = StoreServiceProvider.class, strategy = "SINGLETON")
public class MysqlStoreProvider extends ORDBProvider {

	public MysqlStoreProvider(BundleContext bundleContext) {
		super(bundleContext);
	}

	@Override
	public String[] getContextConfigs() {
		return new String[]{"/SpringContext-daoConfig-tfg.xml","/SpringContext-daoConfig-cgw-ext.xml"};
	}
	
	@Validate
	public void startup(){
		super.startup();
		
	}
	
	@Invalidate
	public void shutdown(){
		super.shutdown();
	}
	
	@Override
	public String getProviderid() {
		return "cmysql";
	}

}
