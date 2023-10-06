public class Person {
    private int age;
    private String name;

    // Constructor with both age and name
    public Person(int age, String name) throws InvalidAgeException {
        if (age < 0 || age > 120) {
            throw new InvalidAgeException("Invalid age. Age must be between 0 and 120.");
        }
        this.age = age;
        this.name = name;
    }

    // Constructor with only name
    public Person(String name) {
        this.name = name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age
    public void setAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 120) {
            throw new InvalidAgeException("Invalid age. Age must be between 0 and 120.");
        }
        this.age = age;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }
}
