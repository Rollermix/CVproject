package model;


public class School {
    private static final int MAX_PEOPLE = 1000;
    private int peopleCounter;
    private Person[] persons = new Person[MAX_PEOPLE];
    public void addStudent(Student student)
    {
        if(peopleCounter<MAX_PEOPLE)
        {
            persons[peopleCounter]=student;
            peopleCounter++;
        }
        else
            System.out.println("Nie można dodać więcej osób do bazy");
    }
    public void printStudents()
    {
        int countStudents = 0;
        for (int i = 0; i <peopleCounter ; i++) {
            if(persons[i] instanceof Student)
            {
                System.out.println(persons[i]);
                countStudents++;
            }
        }
        if (countStudents==0)
        {
            System.out.println("Nie ma żadnego ucznia w bazie danych");
        }
    }
    
}
