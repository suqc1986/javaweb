package language;

import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.net.URL;

public class CheckResourceFile {
    public static void main(String[] args){

    }

    private static File getFile(String fileName) {
        ClassLoader classLoader = CheckResourceFile.class.getClassLoader();
        /**
         getResource()方法会去classpath下找这个文件，获取到url resource, 得到这个资源后，调用url.getFile获取到 文件 的绝对路径
         */
        URL url = classLoader.getResource(fileName);
        /**
         * url.getFile() 得到这个文件的绝对路径
         */
        File file = new File(url.getFile());
        return file;
    }
}
