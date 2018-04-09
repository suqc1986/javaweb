package file;

import com.google.common.collect.Maps;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ReadFile2Map {
    public static void main(String[] args) throws Exception{
        Map<String,String> matchOkMap = Maps.newHashMap();
        Map<String,String> matchFailMap = Maps.newHashMap();
        //解析英文对照文件
        Map<String,String> enResMap = File2Map("C:\\Users\\suqc\\Desktop\\机构知识库中英文翻译 20180404.txt","gbk");
        //解析中文对照文件
        Map<String,String> zhResMap = File2Map("C:\\Users\\suqc\\Desktop\\备份\\new 2.properties","utf8");
        System.out.println("英文资源数:"+enResMap.size());
        System.out.println("中文资源数:"+zhResMap.size());
        //
         for(Iterator<String> ite = zhResMap.keySet().iterator();ite.hasNext();){
             String resKey = ite.next();
             if(enResMap.keySet().contains(zhResMap.get(resKey))){
                 //匹配成功
                 matchOkMap.put(resKey,enResMap.remove(zhResMap.get(resKey)));
             }else{
                //未匹配成功
                 matchFailMap.put(resKey,zhResMap.get(resKey));
             }
         }

         printResult(matchOkMap);
         printResult(matchFailMap);
         printResult(enResMap);
    }

    /**
     * 打印结果
     * @param map
     */
    public static void printResult(Map<String,String> map){
        System.out.println("-------------------------------------打印统计----------------------------------->"+map.size()+"条");
        Set<Map.Entry<String,String>> entrySet = map.entrySet();
        for(Map.Entry<String,String> entry:entrySet){
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }
    /**
     * 读取文件转成Map
     * @param path
     * @param charsetName
     * @return
     * @throws Exception
     */
    public static Map<String,String> File2Map(String path,String charsetName) throws Exception{
        Map<String,String> map = Maps.newHashMap();
        FileInputStream fis = new FileInputStream(path);
        InputStreamReader bif = new InputStreamReader(fis,charsetName);
        BufferedReader br = new BufferedReader(bif);
        String str = null;
        while((str = br.readLine())!=null ){
            if(!str.startsWith("#")){
                String[] arr = str.split("=");
                if(arr.length==2){
                    map.put(arr[0].trim(),arr[1].trim());
                }
            }
        }
        br.close();
        bif.close();
        fis.close();
        return map;
    }
}
