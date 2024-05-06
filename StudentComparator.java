import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
    
        int gradeLevelComparison = compareGradeLevels(s1.getGradeLevel(), s2.getGradeLevel());
        if (gradeLevelComparison != 0) {
            return gradeLevelComparison;
        } 
     
        return Double.compare(s1.getGpa(), s2.getGpa());
    }

    private int compareGradeLevels(String gradeLevel1, String gradeLevel2) {
    
        String[] priorityOrder = {"High School Student", "Current Sac State Student", "Enrolled in another University" };
        
        
        int index1 = getIndex(gradeLevel1, priorityOrder);
        int index2 = getIndex(gradeLevel2, priorityOrder);

      
        return Integer.compare(index1, index2);
    }

    private int getIndex(String gradeLevel, String[] priorityOrder) {
        for (int i = 0; i < priorityOrder.length; i++) {
            if (gradeLevel.equals(priorityOrder[i])) {
                return i;
            }
        }
        return priorityOrder.length; 
    }
}