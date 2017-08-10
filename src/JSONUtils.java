import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bing on 2017-08-10.
 */
public class JSONUtils {
    // 传统JSON解析
    public static String createJsonString(String key,Object value){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(key,value);
        return jsonObject.toString();
    }

    public static List<Person> getListPerson(String key,String jsonString){
        List<Person> list = new ArrayList<Person>();

        try {
            JSONObject jsonObject = JSONObject.fromObject(jsonString);
            JSONArray jsonArray = jsonObject.getJSONArray(key);
            for (int i = 0; i < jsonArray.size(); i++){
                JSONObject personObject = jsonArray.getJSONObject(i);
                Person person = new Person();
                int id = personObject.getInt("id");
                String name = personObject.getString("name");
                int age = personObject.getInt("age");
                person.setId(id);
                person.setName(name);
                person.setAge(age);
                list.add(person);
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        return list;
    }

    public static String createPersonJsonString(){
        List<Person> listPerson = getListPerson();
        String str = JSONUtils.createJsonString("persons",listPerson);
        System.out.println("str = " + str);
        return str;
    }

    public static List<Person> getListPerson(){
        List<Person> list = new ArrayList<Person>();
        Person person1 = new Person(1,"zhangsan",18);
        Person person2 = new Person(2,"lisi",20);
        Person person3 = new Person(3,"wangwu",28);
        list.add(person1);
        list.add(person2);
        list.add(person3);
        return list;
    }


    // GSON解析
    public static String createJsonStringByGSON(Object obj){
        Gson gson = new Gson();
        String str = gson.toJson(obj);
        return str;
    }

    public static <T> T parseJsonWithGson(String jsonData,Class<T> type){
        Gson gson = new Gson();
        T result = gson.fromJson(jsonData,type);
        return result;
    }

    public static <T> List<T> parseJsonArrayWithGson(String jsonData,Class<T> clazz){
       Type type = new TypeToken<ArrayList<JSONObject>>(){}.getType();
        ArrayList<JSONObject> jsonObjects = new Gson().fromJson(jsonData,type);
        ArrayList<T> arrayList = new ArrayList<T>();

        for (JSONObject jsonObject : jsonObjects){
            arrayList.add(new Gson().fromJson(jsonObject.toString(),clazz));
        }
        return arrayList;
    }

    // FastJSON解析
    public static String createJSONStringByFastJSON(Object obj){
        return JSON.toJSONString(obj);
    }

    public static <T> T parseJsonWithFastJSON(String jsonData,Class<T> clazz){
        T result = JSON.parseObject(jsonData,clazz);
        return result;
    }

    public static <T> List<T> parseJsonArrayWithFastJSON(String jsonData,Class<T> clazz){
        List<T> list = new ArrayList<T>();
        list = JSON.parseArray(jsonData,clazz);
        return list;
    }
}
