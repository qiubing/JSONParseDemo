import java.util.List;

/**
 * Created by bing on 2017-08-10.
 */
public class Server {

    public static void main(String[] args){
        // 传统解析
        String jsonString = JSONUtils.createPersonJsonString();
        List<Person> list = JSONUtils.getListPerson("persons",jsonString);
        printPersonList(list);
        System.out.println("------------------------------");


        //GSON解析
        Person person = new Person(1,"liming",19);
        String personStr = JSONUtils.createJsonStringByGSON(person);
        System.out.println("personStr : " + personStr);
        Person personGson = JSONUtils.parseJsonWithGson(personStr,Person.class);
        System.out.println("personGson = " + personGson);

        List<Person> personList = JSONUtils.getListPerson();
        String personListStr = JSONUtils.createJsonStringByGSON(personList);
        System.out.println("personListStr : " + personListStr);
        List<Person> personGsonList = JSONUtils.parseJsonArrayWithGson(personListStr,Person.class);
        printPersonList(personGsonList);
        System.out.println("------------------------------");

        //FastJSON解析
        Person person1 = new Person(2,"hanmeng",18);
        String personStr1 = JSONUtils.createJSONStringByFastJSON(person1);
        System.out.println("personStr1 : " + personStr1);
        Person personFastJSON = JSONUtils.parseJsonWithFastJSON(personStr1, Person.class);
        System.out.println(personFastJSON);

        List<Person> personList1 = JSONUtils.getListPerson();
        String personListStr1 = JSONUtils.createJSONStringByFastJSON(personList1);
        System.out.println("personListStr1 = " + personListStr1);
        List<Person> personFastJSONList = JSONUtils.parseJsonArrayWithFastJSON(personListStr1,Person.class);
        printPersonList(personFastJSONList);
    }

    private static void printPersonList(List<Person> list){
        for (Person person : list){
            System.out.println(person);
        }
    }
}
