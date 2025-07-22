public class UserInfo {
    // Fields
    private String name;
    private int age;
    private String email;
    private boolean isActive;

    public UserInfo(String name, int age, String email, boolean isActive) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.isActive = isActive;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getEmail() { return email; }
    public boolean isActive() { return isActive; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setEmail(String email) { this.email = email; }
    public void setActive(boolean isActive) { this.isActive = isActive; }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("Active: " + (isActive ? "Yes" : "No"));
        System.out.println("--------------------------");
    }

    public static void main(String[] args) {
        UserInfo user1 = new UserInfo("Asil", 21, "asil@example.com", true);
        UserInfo user2 = new UserInfo("Amina", 22, "amina@example.com", false);
        UserInfo user3 = new UserInfo("Hassan", 23, "hassan@example.com", true);

        user1.displayInfo();
        user2.displayInfo();
        user3.displayInfo();

        user1.setEmail("asil.new@example.com");
        user1.setActive(false);
        System.out.println("Updated Info for User 1:");
        user1.displayInfo();
    }
}
