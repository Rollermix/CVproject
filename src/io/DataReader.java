package io;

import model.Person;
import model.Student;

import java.time.Period;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataReader {
    private Scanner scanner = new Scanner(System.in);

    public Student readAndCreateStudent()
    {
        System.out.println("Podaj imie");
        String firstName = scanner.nextLine();
        System.out.println("Podaj nazwisko");
        String lastName = scanner.nextLine();
        String pesel;
        boolean checkPesel=false;
        do
        {
            System.out.println("Podaj Pesel. Musi się składać z 11 cyfr");
            pesel= scanner.nextLine();
            if(checkPeselLength(pesel))
            {
                checkPesel=true;
            }
            else
            {
                System.out.println("Podałeś za krótki pesel");
            }
        }
        while (!checkPesel);
        System.out.println("Podaj miejscowość w którym mieszkasz");
        String city = scanner.nextLine().toUpperCase();
        System.out.println("Podaj ulicę na której mieszkasz, jeśli nie ma ulicy, wpisz ponownie nazwę miejscowości");
        String stret = scanner.nextLine();
        System.out.println("Podaj nr budynku w którym mieszkasz");
        String house = scanner.nextLine();
        System.out.println("Podaj nr mieszkania w którym mieszkasz, pozostaw puste, jeśli mieszkasz w domu jednorodzinnym");
        String flat = scanner.nextLine();
        String flatNo=checkFlat(flat);
        System.out.println("Podaj adres email");
        String email;
        boolean emailFlag = false;
        do {
            System.out.println("Podaj adres email w formule abc@def.gh");
            email = scanner.nextLine();
            emailFlag=checkEmail(email);
        }
        while (!emailFlag);
        System.out.println("Podaj nr telefonu");
        int number = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj kod pocztowy w formie 12345");
        int postal = scanner.nextInt();
        scanner.nextLine();
        return new Student(firstName,lastName,pesel,city,stret,house,flatNo,email,number,postal);
    }

    private String checkFlat(String flat) {
        if(flat.length()==0)
            return flat="Brak";
        else return flat;
    }

    private boolean checkPeselLength(String pesel)
    {
        if(pesel.length()!=11)
        {
            return false;
        }
        else return true;
    }
    private boolean isNotUsed(String pesel, Person [] persons)
    {
        boolean flag=true;
        for (Person student : persons) {
            if(student != null)
            {
                if (pesel.equals(student.getPesel())) {
                    flag = false;
                    break;
                }
            }

        }
        return flag;
    }
    private boolean checkEmail(String email)
    {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public int readInt()
    {
        int number;
        number=scanner.nextInt();
        scanner.nextLine();
        return number;
    }
}
