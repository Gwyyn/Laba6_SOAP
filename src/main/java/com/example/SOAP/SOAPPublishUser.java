package com.example.SOAP;

import com.example.Student;
import com.example.learning.LearningService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class SOAPPublishUser {
    public static void main(String[] args) throws IOException {

        URL wsdlURL = new URL("http://localhost:8085/LearningService?wsdl");
        QName qname = new QName("http://learning.example.com/", "LearningServiceImplService");
        Service service = Service.create(wsdlURL, qname);
        LearningService ps = service.getPort(LearningService.class);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;
        while (flag) {
            System.out.print("1 - find by last name" +
                    " \n 2 - find by average grade" +
                    " \n 3 - get all item" +
                    " \n 4 - exit\n");
            int choice = Integer.parseInt(reader.readLine());

            if (choice == 1) {
                System.out.println("Write student name");
                String name = reader.readLine();
                ArrayList<Student> temp = (ArrayList<Student>) ps.findStudentByLastName(name);

                if (temp.isEmpty()) {
                    System.out.println("Not found");
                } else {
                    System.out.println(temp);
                }
            } else if (choice == 2) {
                System.out.println("Write average grade");
                String grade = reader.readLine();
                ArrayList<Student> temp = (ArrayList<Student>) ps.findStudentsByAverageGrade(Double.parseDouble(grade));
                if (temp.isEmpty()) {
                    System.out.println("Not found");
                } else {
                    System.out.println(temp);
                }
            } else if (choice == 3) {
                System.out.println(ps.getAllStudent());
            } else if (choice == 4) {
                flag = false;
            }
        }
    }

}
