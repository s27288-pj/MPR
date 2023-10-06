import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws InvalidAgeException {
        try {
            // Create three Person objects
            Person person1 = new Person(25, "John");
            Person person2 = new Person(30, "Alice");
            Person person3 = new Person(35, "Bob");

            // Create a List to store the objects
            List<Person> personList = new ArrayList<>();
            personList.add(person1);
            personList.add(person2);
            personList.add(person3);

            // Create a Set to store the objects
            Set<Person> personSet = new HashSet<>();
            personSet.add(person1);
            personSet.add(person2);
            personSet.add(person3);

            // Create a Map to store the objects with names as keys
            Map<String, Person> personMap = new HashMap<>();
            personMap.put(person1.getName(), person1);
            personMap.put(person2.getName(), person2);
            personMap.put(person3.getName(), person3);

            // Print the collections
            System.out.println("List of Persons:");
            for (Person person : personList) {
                System.out.println(person.getName());
            }

            System.out.println("\nSet of Persons:");
            for (Person person : personSet) {
                System.out.println(person.getName());
            }

            System.out.println("\nMap of Persons:");
            for (Map.Entry<String, Person> entry : personMap.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            // 4.1. Reduce operation - Calculate the average age
            OptionalDouble averageAge = personList.stream()
                    .mapToInt(Person::getAge)
                    .average();

            if (averageAge.isPresent()) {
                System.out.println("\nAverage Age: " + averageAge.getAsDouble());
            } else {
                System.out.println("No data for calculating average age.");
            }

            // 4.2. Map Operation - Create a new list with names
            List<String> namesList = personList.stream()
                    .map(Person::getName) // Extract names
                    .toList();

            System.out.println("\nList of Names: " + namesList);

            // 4.3. Filter operation - Create a list of people over 25 years old
            List<String> over25List = personList.stream()
                    .filter(person -> person.getAge() > 25)
                    .map(Person::getName)
                    .toList();

            System.out.println("\nPeople Over 25: " + over25List);

            // 4.4. Sort operation - Sort the list alphabetically by first name
            List<String> sortedByName = personList.stream()
                    .sorted(Comparator.comparing(Person::getName))
                    .map(Person::getName)
                    .toList();

            System.out.println("\nSorted by Name: " + sortedByName);

            // 4.5. forEach operation - Print names and ages
            System.out.println("\nNames and Ages:");
            personList.forEach(person ->
                    System.out.println(person.getName() + " - " + person.getAge()));

            // 4.6. Min/max operation - Find the person with the lowest/greatest age
            Optional<Person> youngestPerson = personList.stream()
                    .min(Comparator.comparingInt(Person::getAge));

            youngestPerson.ifPresentOrElse(
                    person -> System.out.println("\nYoungest Person: " + person.getName() + " - " + person.getAge()),
                    () -> System.out.println("No youngest person found."));

            Optional<Person> oldestPerson = personList.stream()
                    .max(Comparator.comparingInt(Person::getAge));

            oldestPerson.ifPresentOrElse(
                    person -> System.out.println("Oldest Person: " + person.getName() + " - " + person.getAge()),
                    () -> System.out.println("No oldest person found."));

        } catch (InvalidAgeException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
