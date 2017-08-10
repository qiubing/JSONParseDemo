/**
 * Created by bing on 2017-08-10.
 */
public class Person {
    private int id;
    private String name;
    private int age;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Person(int id,String name,int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public Person(){

    }

    @Override
    public String toString() {
        return "id : " + id + " name : " + name + " age : " + age;
    }
}