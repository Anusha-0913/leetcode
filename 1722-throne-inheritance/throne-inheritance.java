import java.util.*;

class ThroneInheritance {

    class Person {
        String name;
        List<Person> children;

        Person(String name) {
            this.name = name;
            this.children = new ArrayList<Person>();
        }
    }

    Map<String, Person> map;
    Set<String> dead;
    Person king;

    public ThroneInheritance(String kingName) {
        map = new HashMap<String, Person>();
        dead = new HashSet<String>();

        king = new Person(kingName);
        map.put(kingName, king);
    }

    public void birth(String parentName, String childName) {
        Person parent = map.get(parentName);
        Person child = new Person(childName);

        parent.children.add(child);
        map.put(childName, child);
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> result = new ArrayList<String>();
        dfs(king, result);
        return result;
    }

    private void dfs(Person person, List<String> result) {
        if (!dead.contains(person.name)) {
            result.add(person.name);
        }

        for (Person child : person.children) {
            dfs(child, result);
        }
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */