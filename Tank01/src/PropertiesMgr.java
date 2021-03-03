import java.io.IOException;
import java.util.Properties;

/**
 * @author liangshan
 * @ClassName PropertiMgr
 * @description 配置文件读取
 * @date 2021/3/3 21:10
 **/
public class PropertiesMgr {
    static Properties properties = new Properties();
    static {
        try {
            properties.load(PropertiesMgr.class.getResourceAsStream("Configure"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key){
        if (properties == null) return null;
        return properties.getProperty(key);
    }
}
