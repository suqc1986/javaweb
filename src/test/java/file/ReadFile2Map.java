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
        Map<String,String> resultMap = Maps.newHashMap();
        Map<String,String> enMap = File2Map("C:\\Users\\suqc\\Desktop\\机构知识库中英文翻译 20180404.txt","gbk");
        System.out.println(enMap);
        Map<String,String> resMap = File2Map("C:\\Users\\suqc\\Desktop\\备份\\new 2.properties","utf8");
        System.out.println(resMap);
        System.out.println(enMap.size());
        System.out.println(resMap.size());
         for(Iterator<String> ite = resMap.keySet().iterator();ite.hasNext();){
             String key = ite.next();
//             System.out.println(key+":"+resMap.get(key)+":");
             if(enMap.keySet().contains(resMap.get(key))){
                 resultMap.put(key,enMap.get(resMap.get(key)));
             }

         }
         Set<Map.Entry<String,String>> entrySet = resultMap.entrySet();
        System.out.println(entrySet.size());
        for(Map.Entry<String,String> entry:entrySet){
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }
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
