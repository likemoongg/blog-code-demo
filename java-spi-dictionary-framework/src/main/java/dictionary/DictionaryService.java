package dictionary;

import dictionary.spi.Dictionary;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

public class DictionaryService {

    private static DictionaryService service;
    private ServiceLoader<Dictionary> loader;

    private DictionaryService() {
        // 这里的 ServiceLoader 就是 java 原生 spi 的重要入口类
        // 其入参是一个接口，返回的 ServiceLoader<Dictionary> loader 可以加载出其实现类的实例
        loader = ServiceLoader.load(Dictionary.class);
    }

    // 内置一个单例实例
    public static synchronized DictionaryService getInstance() {
        if (service == null) {
            service = new DictionaryService();
        }
        return service;
    }


    // 扫描 目录META-INF/services/dictionary.spi.Dictionary下描述的所有的 Dictionary 的实现类，依次查找入参的 word
    // 其中目录层级META-INF/services是 java spi 默认约定的目录
    public String getDefinition(String word) {
        String definition = null;

        try {
            // 利用 ServiceLoader<Dictionary> loader 的迭代器遍历每一个实现类，寻找 word
            Iterator<Dictionary> dictionaries = loader.iterator();
            while (definition == null && dictionaries.hasNext()) {
                Dictionary d = dictionaries.next();
                definition = d.getDefinition(word);
            }
        } catch (ServiceConfigurationError serviceError) {
            definition = null;
            serviceError.printStackTrace();
        }
        return definition;
    }
}