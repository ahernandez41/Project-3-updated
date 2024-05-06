public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private String gradeLevel;
    private double gpa;

    
    public Student(String firstName, String lastName, String email,String gradeLevel, double gpa) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gradeLevel = gradeLevel;
        this.gpa = gpa;
    }

  
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   

    public String getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    
    @Override
    public String toString() {
        return String.format("Name: %s, Email: %s, Gender: %s, Grade Level: %s, GPA: %.2f",
                firstName, lastName, email, gradeLevel, gpa);
    }
}