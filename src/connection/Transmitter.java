package connection;

import autoriz.Admin;
import autoriz.User;
import data.*;
import dataBase.Conection;

import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;
public class Transmitter extends JFrame implements Runnable {
    static int countclients = 0;//счетчик подключившихся клиентов
    static private ServerSocket connection;
    static private DataOutputStream output;
    static private DataInputStream input;
    private static int autoris_id;
    private static int flag_prov_del_admin =0;
    public static boolean prov_ad(Vector<Admin> ad, int key, String login, String password) {
        for (int i = 0; i < ad.size(); i++) {
            if (ad.get(i).getKey() == key && ad.get(i).getLogin().equals(login) && ad.get(i).getPassword().equals(password)) {
                autoris_id = ad.get(i).getKey();
                return true;
            }
        }
        return false;
    }
    public static boolean prov_user(Vector<User> st, int key, String login, String password) {
        for (int i = 0; i < st.size(); i++) {
            if (st.get(i).getId_student() == key && st.get(i).getLogin().equals(login) && st.get(i).getPassword().equals(password)) {
                autoris_id = st.get(i).getId_student();
                return true;
            }
        }
        return false;
    }

    public static void readerStudent(DataOutputStream output, DataInputStream input, Vector<Student> students,
                              Vector<Group> groups, Vector<Applications> applications, Vector<Report> reports) throws IOException {
        output.writeInt(students.size());
        for (int i = 0; i < students.size(); i++) {
            output.writeInt(students.get(i).getId_student());
            output.writeInt(students.get(i).getSurname().length());
            for (int j = 0; j < students.get(i).getSurname().length(); j++) {
                output.writeChar(students.get(i).getSurname().charAt(j));
            }
            output.writeInt(students.get(i).getName().length());
            for (int j = 0; j < students.get(i).getName().length(); j++) {
                output.writeChar(students.get(i).getName().charAt(j));
            }
            output.writeInt(students.get(i).getPatronymic().length());
            for (int j = 0; j < students.get(i).getPatronymic().length(); j++) {
                output.writeChar(students.get(i).getPatronymic().charAt(j));
            }
            output.writeInt(students.get(i).getId_group());
            output.writeInt(reports.get(i).getCol_passes());
            output.writeFloat(reports.get(i).getRating());
            output.writeInt(students.get(i).getDay());
            output.writeInt(students.get(i).getMonthe());
            output.writeInt(students.get(i).getYear());
        }

    }
    public static void readerStudent(DataOutputStream output, DataInputStream input, Vector<Student> students,
                                     Vector<Group> groups, Vector<Report> reports) throws IOException {
        output.writeInt(students.size());
        for (int i = 0; i < students.size(); i++) {
            output.writeInt(students.get(i).getId_student());
            output.writeInt(students.get(i).getSurname().length());
            for (int j = 0; j < students.get(i).getSurname().length(); j++) {
                output.writeChar(students.get(i).getSurname().charAt(j));
            }
            output.writeInt(students.get(i).getName().length());
            for (int j = 0; j < students.get(i).getName().length(); j++) {
                output.writeChar(students.get(i).getName().charAt(j));
            }
            output.writeInt(students.get(i).getPatronymic().length());
            for (int j = 0; j < students.get(i).getPatronymic().length(); j++) {
                output.writeChar(students.get(i).getPatronymic().charAt(j));
            }
            output.writeInt(students.get(i).getId_group());
            output.writeFloat(reports.get(i).getCoefficent());
            output.writeInt(reports.get(i).getCol_passes());
            output.writeFloat(reports.get(i).getRating());
            output.writeFloat(reports.get(i).getPerconal_schjlarsip());
        }

    }

    public static void readerStudentName(DataOutputStream output, DataInputStream input, Vector<Student> students,
                                     Vector<Group> groups, Vector<Applications> applications, Vector<Report> reports, String name) throws IOException {

        int size =0;
        for(int i =0 ; i<students.size(); i++)
        {
            if(students.get(i).getName().equals(name))
            {
                size++;
            }
        }
        output.writeInt(size);
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getName().equals(name)) {
                output.writeInt(students.get(i).getId_student());
                output.writeInt(students.get(i).getSurname().length());
                for (int j = 0; j < students.get(i).getSurname().length(); j++) {
                    output.writeChar(students.get(i).getSurname().charAt(j));
                }
                output.writeInt(students.get(i).getName().length());
                for (int j = 0; j < students.get(i).getName().length(); j++) {
                    output.writeChar(students.get(i).getName().charAt(j));
                }
                output.writeInt(students.get(i).getPatronymic().length());
                for (int j = 0; j < students.get(i).getPatronymic().length(); j++) {
                    output.writeChar(students.get(i).getPatronymic().charAt(j));
                }
                output.writeInt(students.get(i).getId_group());
                output.writeInt(reports.get(i).getCol_passes());
                output.writeFloat(reports.get(i).getRating());
                output.writeInt(students.get(i).getDay());
                output.writeInt(students.get(i).getMonthe());
                output.writeInt(students.get(i).getYear());
            }
        }

    }
    public static void readerStudentSurname(DataOutputStream output, DataInputStream input, Vector<Student> students,
                                         Vector<Group> groups, Vector<Applications> applications, Vector<Report> reports, String surname) throws IOException {

        int size =0;
        for(int i =0 ; i<students.size(); i++)
        {
            if(students.get(i).getSurname().equals(surname))
            {
                size++;
            }
        }
        output.writeInt(size);
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getSurname().equals(surname)) {
                output.writeInt(students.get(i).getId_student());
                output.writeInt(students.get(i).getSurname().length());
                for (int j = 0; j < students.get(i).getSurname().length(); j++) {
                    output.writeChar(students.get(i).getSurname().charAt(j));
                }
                output.writeInt(students.get(i).getName().length());
                for (int j = 0; j < students.get(i).getName().length(); j++) {
                    output.writeChar(students.get(i).getName().charAt(j));
                }
                output.writeInt(students.get(i).getPatronymic().length());
                for (int j = 0; j < students.get(i).getPatronymic().length(); j++) {
                    output.writeChar(students.get(i).getPatronymic().charAt(j));
                }
                output.writeInt(students.get(i).getId_group());
                output.writeInt(reports.get(i).getCol_passes());
                output.writeFloat(reports.get(i).getRating());
                output.writeInt(students.get(i).getDay());
                output.writeInt(students.get(i).getMonthe());
                output.writeInt(students.get(i).getYear());
            }
        }

    }
    public static void readerStudentPatronymic(DataOutputStream output, DataInputStream input, Vector<Student> students,
                                         Vector<Group> groups, Vector<Applications> applications, Vector<Report> reports, String patronymic) throws IOException {

        int size =0;
        for(int i =0 ; i<students.size(); i++)
        {
            if(students.get(i).getPatronymic().equals(patronymic))
            {
                size++;
            }
        }
        output.writeInt(size);
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getPatronymic().equals(patronymic)) {
                output.writeInt(students.get(i).getId_student());
                output.writeInt(students.get(i).getSurname().length());
                for (int j = 0; j < students.get(i).getSurname().length(); j++) {
                    output.writeChar(students.get(i).getSurname().charAt(j));
                }
                output.writeInt(students.get(i).getName().length());
                for (int j = 0; j < students.get(i).getName().length(); j++) {
                    output.writeChar(students.get(i).getName().charAt(j));
                }
                output.writeInt(students.get(i).getPatronymic().length());
                for (int j = 0; j < students.get(i).getPatronymic().length(); j++) {
                    output.writeChar(students.get(i).getPatronymic().charAt(j));
                }
                output.writeInt(students.get(i).getId_group());
                output.writeInt(reports.get(i).getCol_passes());
                output.writeFloat(reports.get(i).getRating());
                output.writeInt(students.get(i).getDay());
                output.writeInt(students.get(i).getMonthe());
                output.writeInt(students.get(i).getYear());
            }
        }

    }
    public static void readerStudentAge(DataOutputStream output, DataInputStream input, Vector<Student> students,
                                         Vector<Group> groups, Vector<Applications> applications, Vector<Report> reports, int day, int monthe, int year) throws IOException {

        int size =0;
        for(int i =0 ; i<students.size(); i++)
        {
            if(students.get(i).getDay()==day && students.get(i).getMonthe()==monthe && students.get(i).getYear() == year)
            {
                size++;
            }
        }
        output.writeInt(size);
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getDay()==day && students.get(i).getMonthe()==monthe && students.get(i).getYear() == year) {
                output.writeInt(students.get(i).getId_student());
                output.writeInt(students.get(i).getSurname().length());
                for (int j = 0; j < students.get(i).getSurname().length(); j++) {
                    output.writeChar(students.get(i).getSurname().charAt(j));
                }
                output.writeInt(students.get(i).getName().length());
                for (int j = 0; j < students.get(i).getName().length(); j++) {
                    output.writeChar(students.get(i).getName().charAt(j));
                }
                output.writeInt(students.get(i).getPatronymic().length());
                for (int j = 0; j < students.get(i).getPatronymic().length(); j++) {
                    output.writeChar(students.get(i).getPatronymic().charAt(j));
                }
                output.writeInt(students.get(i).getId_group());
                output.writeInt(reports.get(i).getCol_passes());
                output.writeFloat(reports.get(i).getRating());
                output.writeInt(students.get(i).getDay());
                output.writeInt(students.get(i).getMonthe());
                output.writeInt(students.get(i).getYear());
            }
        }

    }
    public static void readerStudentGroup(DataOutputStream output, DataInputStream input, Vector<Student> students,
                                               Vector<Group> groups, Vector<Applications> applications, Vector<Report> reports, int group) throws IOException {

        int size =0;
        for(int i =0 ; i<students.size(); i++)
        {
            if(students.get(i).getId_group() == group)
            {
                size++;
            }
        }
        output.writeInt(size);
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getId_group()==group) {
                output.writeInt(students.get(i).getId_student());
                output.writeInt(students.get(i).getSurname().length());
                for (int j = 0; j < students.get(i).getSurname().length(); j++) {
                    output.writeChar(students.get(i).getSurname().charAt(j));
                }
                output.writeInt(students.get(i).getName().length());
                for (int j = 0; j < students.get(i).getName().length(); j++) {
                    output.writeChar(students.get(i).getName().charAt(j));
                }
                output.writeInt(students.get(i).getPatronymic().length());
                for (int j = 0; j < students.get(i).getPatronymic().length(); j++) {
                    output.writeChar(students.get(i).getPatronymic().charAt(j));
                }
                output.writeInt(students.get(i).getId_group());
                output.writeInt(reports.get(i).getCol_passes());
                output.writeFloat(reports.get(i).getRating());
                output.writeInt(students.get(i).getDay());
                output.writeInt(students.get(i).getMonthe());
                output.writeInt(students.get(i).getYear());
            }
        }

    }
    public static void readerStudentCours(DataOutputStream output, DataInputStream input, Vector<Student> students,
                                               Vector<Group> groups, Vector<Applications> applications, Vector<Report> reports, int cours) throws IOException {

        int size =0;
        for(int i =0 ; i<students.size(); i++)
        {
        for(int j =0 ; j <groups.size(); j++)
            {
                if (students.get(i).getId_group() == groups.get(j).getNumber_group() && groups.get(j).getCours() == cours) {
                    size++;
                }
            }
        }
        output.writeInt(size);
        for(int i =0 ; i<students.size(); i++) {
            for (int k = 0; k < groups.size(); k++) {
                if (students.get(i).getId_group() == groups.get(k).getNumber_group() && groups.get(k).getCours() == cours) {
                    output.writeInt(students.get(i).getId_student());
                    output.writeInt(students.get(i).getSurname().length());
                    for (int j = 0; j < students.get(i).getSurname().length(); j++) {
                        output.writeChar(students.get(i).getSurname().charAt(j));
                    }
                    output.writeInt(students.get(i).getName().length());
                    for (int j = 0; j < students.get(i).getName().length(); j++) {
                        output.writeChar(students.get(i).getName().charAt(j));
                    }
                    output.writeInt(students.get(i).getPatronymic().length());
                    for (int j = 0; j < students.get(i).getPatronymic().length(); j++) {
                        output.writeChar(students.get(i).getPatronymic().charAt(j));
                    }
                    output.writeInt(students.get(i).getId_group());
                    output.writeInt(reports.get(i).getCol_passes());
                    output.writeFloat(reports.get(i).getRating());
                    output.writeInt(students.get(i).getDay());
                    output.writeInt(students.get(i).getMonthe());
                    output.writeInt(students.get(i).getYear());
                }
            }
        }

    }
    public static void readerStudentSpec(DataOutputStream output, DataInputStream input, Vector<Student> students,
                                          Vector<Group> groups, Vector<Applications> applications, Vector<Report> reports, String spec) throws IOException {
        int size =0;
        for(int i =0 ; i<students.size(); i++) {
            for (int k = 0; k < groups.size(); k++) {
                if (students.get(i).getId_group() == groups.get(k).getNumber_group() && groups.get(k).getSpeciality().equals(spec)) {
                    size++;
                }
            }
        }
        output.writeInt(size);
        for (int i = 0; i < students.size(); i++) {
            for (int k = 0; k < groups.size(); k++) {
                if (students.get(i).getId_group() == groups.get(k).getNumber_group() && groups.get(k).getSpeciality().equals(spec)) {
                    output.writeInt(students.get(i).getId_student());
                    output.writeInt(students.get(i).getSurname().length());
                    for (int j = 0; j < students.get(i).getSurname().length(); j++) {
                        output.writeChar(students.get(i).getSurname().charAt(j));
                    }
                    output.writeInt(students.get(i).getName().length());
                    for (int j = 0; j < students.get(i).getName().length(); j++) {
                        output.writeChar(students.get(i).getName().charAt(j));
                    }
                    output.writeInt(students.get(i).getPatronymic().length());
                    for (int j = 0; j < students.get(i).getPatronymic().length(); j++) {
                        output.writeChar(students.get(i).getPatronymic().charAt(j));
                    }
                    output.writeInt(students.get(i).getId_group());
                    output.writeInt(reports.get(i).getCol_passes());
                    output.writeFloat(reports.get(i).getRating());
                    output.writeInt(students.get(i).getDay());
                    output.writeInt(students.get(i).getMonthe());
                    output.writeInt(students.get(i).getYear());
                }
            }
        }
    }

    public static void readerStudentFacult(DataOutputStream output, DataInputStream input, Vector<Student> students,
                                         Vector<Group> groups, Vector<Applications> applications, Vector<Report> reports, String facul) throws IOException {
        int size =0;
        for(int i =0 ; i<students.size(); i++) {
            for (int k = 0; k < groups.size(); k++) {
                if (students.get(i).getId_group() == groups.get(k).getNumber_group() && groups.get(k).getFaculty().equals(facul)) {
                    size++;
                }
            }
        }
        output.writeInt(size);
        for (int i = 0; i < students.size(); i++) {
            for (int k = 0; k < groups.size(); k++) {
                if (students.get(i).getId_group() == groups.get(k).getNumber_group() && groups.get(k).getFaculty().equals(facul)) {
                    output.writeInt(students.get(i).getId_student());
                    output.writeInt(students.get(i).getSurname().length());
                    for (int j = 0; j < students.get(i).getSurname().length(); j++) {
                        output.writeChar(students.get(i).getSurname().charAt(j));
                    }
                    output.writeInt(students.get(i).getName().length());
                    for (int j = 0; j < students.get(i).getName().length(); j++) {
                        output.writeChar(students.get(i).getName().charAt(j));
                    }
                    output.writeInt(students.get(i).getPatronymic().length());
                    for (int j = 0; j < students.get(i).getPatronymic().length(); j++) {
                        output.writeChar(students.get(i).getPatronymic().charAt(j));
                    }
                    output.writeInt(students.get(i).getId_group());
                    output.writeInt(reports.get(i).getCol_passes());
                    output.writeFloat(reports.get(i).getRating());
                    output.writeInt(students.get(i).getDay());
                    output.writeInt(students.get(i).getMonthe());
                    output.writeInt(students.get(i).getYear());
                }
            }
        }

    }
    public static void change(Socket socket, DataInputStream input, DataOutputStream output, Conection db, int p) throws IOException, SQLException, ClassNotFoundException {
        int choose =0;


            socket.close();
            input.close();
            output.close();
            Socket client = connection.accept();
            output = new DataOutputStream(client.getOutputStream());
            input = new DataInputStream(client.getInputStream());
            choose = input.readInt();
            int id = input.readInt();

            db.getDbCon();
            int flag =0;
             switch (choose)
             {
                 case 1:
                 {
                     Vector<Student> students = new Vector<Student>();
                     Vector<User> users = new Vector<User>();
                     Vector<Report> reports =new Vector<Report>();
                     db.getDbCon();
                     db.readStudent(students);
                     db.readUser(users);
                     db.readReport(reports);
                     for(int i =0; i < students.size(); i++) {
                         if(students.get(i).getId_student() == id)
                         {
                             flag=0;
                             if (db.deleteStudent(id, reports.get(i).getId_report())) {
                                 output.writeInt(1);
                             } else {
                                 output.writeInt(0);
                             }
                             break;
                         }
                         else
                         {
                            flag++;
                         }
                     }
                       if(flag>0)
                     {
                         output.writeInt(0);
                     }
                     break;
                 }
                 case 2:
                 {
                     Vector<Student> students = new Vector<Student>();
                     Vector<User> users = new Vector<User>();
                     Vector<Report> reports =new Vector<Report>();
                     db.getDbCon();
                     db.readStudent(students);
                     db.readUser(users);
                     db.readReport(reports);
                     int size = input.readInt();
                     String login = "";
                     for(int i =0; i <size; i ++)
                     {
                         login+=input.readChar();
                     }
                     for(int i =0; i < students.size(); i++) {
                         if(students.get(i).getId_student() == id)
                         {
                             flag=0;
                             if (db.changeLoginStudent(id, login)) {
                                 output.writeInt(1);
                             } else {
                                 output.writeInt(0);
                             }
                             break;
                         }
                         else
                         {
                             flag++;
                         }
                     }
                     if(flag>0)
                     {
                         output.writeInt(0);
                     }
                     break;

                 }
                 case 3:
                 {
                     Vector<Student> students = new Vector<Student>();
                     Vector<User> users = new Vector<User>();
                     Vector<Report> reports =new Vector<Report>();
                     db.getDbCon();
                     db.readStudent(students);
                     db.readUser(users);
                     db.readReport(reports);
                     int size = input.readInt();
                     String password = "";
                     for(int i =0; i <size; i ++)
                     {
                         password+=input.readChar();
                     }
                     for(int i =0; i < students.size(); i++) {
                         if(students.get(i).getId_student() == id)
                         {
                             flag=0;
                             if (db.changePasswordStudent(id, password)) {
                                 output.writeInt(1);
                             } else {
                                 output.writeInt(0);
                             }
                             break;
                         }
                         else
                         {
                             flag++;
                         }
                     }
                     if(flag>0)
                     {
                         output.writeInt(0);
                     }
                     break;
                 }
                 case 4:
                 {
                     Vector<Student> students = new Vector<Student>();
                     Vector<User> users = new Vector<User>();
                     Vector<Report> reports =new Vector<Report>();
                     db.getDbCon();
                     db.readStudent(students);
                     db.readUser(users);
                     db.readReport(reports);
                     int size = input.readInt();
                     String surname = "";
                     String name = "";
                     String patronimyc = "";
                     for(int i =0; i <size; i ++)
                     {
                         surname+=input.readChar();
                     }
                     size = input.readInt();
                     for(int i =0; i <size; i ++)
                     {
                         name+=input.readChar();
                     }
                     size = input.readInt();
                     for(int i =0; i <size; i ++)
                     {
                         patronimyc+=input.readChar();
                     }
                     for(int i =0; i < students.size(); i++) {
                         if(students.get(i).getId_student() == id)
                         {
                             flag=0;
                             if (db.changeFIOStudent(id, surname, name, patronimyc)) {
                                 output.writeInt(1);
                             } else {
                                 output.writeInt(0);
                             }
                             break;
                         }
                         else
                         {
                             flag++;
                         }
                     }
                     if(flag>0)
                     {
                         output.writeInt(0);
                     }
                     break;
                 }
                 case 5:
                 {

                     Vector<Student> students = new Vector<Student>();
                     Vector<User> users = new Vector<User>();
                     Vector<Report> reports =new Vector<Report>();
                     db.getDbCon();
                     db.readStudent(students);
                     db.readUser(users);
                     db.readReport(reports);
                     int day = input.readInt();
                     int monthe = input.readInt();
                     int year =input.readInt();
                     for(int i =0; i < students.size(); i++) {
                         if(students.get(i).getId_student() == id)
                         {
                             flag=0;
                             if (db.changeAgeStudent(id, day, monthe, year)) {
                                 output.writeInt(1);
                             } else {
                                 output.writeInt(0);
                             }
                             break;
                         }
                         else
                         {
                             flag++;
                         }
                     }
                     if(flag>0)
                     {
                         output.writeInt(0);
                     }
                     break;
                 }
                 case 6:
                 {
                 }
                 case 7:
                 {
                     Vector<Student> students = new Vector<Student>();
                     Vector<User> users = new Vector<User>();
                     Vector<Report> reports =new Vector<Report>();
                     db.getDbCon();
                     db.readStudent(students);
                     db.readUser(users);
                     db.readReport(reports);
                     int size = input.readInt();
                     String dop = "";
                     for(int i =0; i <size; i ++)
                     {
                         dop+=input.readChar();
                     }
                     for(int i =0; i < students.size(); i++) {
                         if(students.get(i).getId_student() == id)
                         {
                             flag=0;
                             if (db.changeApplicationStudent(id, dop)) {
                                 output.writeInt(1);
                             } else {
                                 output.writeInt(0);
                             }
                             break;
                         }
                         else
                         {
                             flag++;
                         }
                     }
                     if(flag>0)
                     {
                         output.writeInt(0);
                     }
                     break;
                 }
             }

    }
    public static void change(Socket socket, DataInputStream input, DataOutputStream output, Conection db) throws IOException, SQLException, ClassNotFoundException
    {
        int choose =0;
        choose = input.readInt();
        socket.close();
        input.close();
        output.close();
        if(choose>1) {
            Socket client = connection.accept();
            output = new DataOutputStream(client.getOutputStream());
            input = new DataInputStream(client.getInputStream());
        }
        int id = autoris_id;
        db.getDbCon();
        int flag =0;
        switch (choose) {
            case 1:
            {
                db.getDbCon();
                db.deleteAdmin(id);
                flag_prov_del_admin++;
                break;
            }

            case 2:
            {

                Vector<Admin> admins = new Vector<Admin>();
                Vector<Info_Admin> info_admins = new Vector<Info_Admin>();
                db.getDbCon();
                db.readAdmin(admins);
                db.readInfo_Admin(info_admins);
                int size = input.readInt();
                String str = "";
                for(int i =0; i<size; i++)
                {
                    str += input.readChar();
                }
                db.changeLiginAdmin(id, str);
                output.writeInt(1);
                break;
            }
            case 3:
            {
                Vector<Admin> admins = new Vector<Admin>();
                Vector<Info_Admin> info_admins = new Vector<Info_Admin>();
                db.getDbCon();
                db.readAdmin(admins);
                db.readInfo_Admin(info_admins);
                int size = input.readInt();
                String str = "";
                for(int i =0; i<size; i++)
                {
                    str += input.readChar();
                }
                db.changePasswordAdmin(id, str);
                output.writeInt(1);
                break;
            }
            case 4:
            {

                Vector<Admin> admins = new Vector<Admin>();
                Vector<Info_Admin> info_admins = new Vector<Info_Admin>();
                db.getDbCon();
                db.readAdmin(admins);
                db.readInfo_Admin(info_admins);
                int size = input.readInt();
                String str = "";
                for(int i =0; i<size; i++)
                {
                    str += input.readChar();
                }
                String surname = str;
                size = input.readInt();
                str = "";
                for(int i =0; i<size; i++)
                {
                    str += input.readChar();
                }
                String name = str;
                size = input.readInt();
                str = "";
                for(int i =0; i<size; i++)
                {
                    str += input.readChar();
                }
                String patronymic = str;
                db.changeFIOAdmin(id, surname,name,patronymic);
                output.writeInt(1);
                break;
            }
            case 5:
            {
                Vector<Admin> admins = new Vector<Admin>();
                Vector<Info_Admin> info_admins = new Vector<Info_Admin>();
                db.getDbCon();
                db.readAdmin(admins);
                db.readInfo_Admin(info_admins);
                int size = input.readInt();
                String str = "";
                for(int i =0; i<size; i++)
                {
                    str += input.readChar();
                }
                db.changeWorkAdmin(id, str);
                output.writeInt(1);
                break;
            }
        }
    }
    public static void find_for_student(Socket socket, DataInputStream input, DataOutputStream output, Conection con) throws IOException {

        int choose;

            socket.close();
            input.close();
            output.close();
            Socket client = connection.accept();
            output = new DataOutputStream(client.getOutputStream());
            input = new DataInputStream(client.getInputStream());
            choose = input.readInt();
            switch (choose) {
                case 1: {
                    int size = input.readInt();
                    String name = "";
                    for (int i = 0; i < size; i++) {
                        name += input.readChar();
                    }
                    Vector<Student> students = new Vector<Student>();
                    Vector<Group> groups = new Vector<Group>();
                    Vector<Applications> applications = new Vector<Applications>();
                    Vector<Report> reports = new Vector<Report>();
                    con.readStudent(students);
                    con.readGroup(groups);
                    con.readApplication(applications);
                    con.readReport(reports);
                    readerStudentName(output, input, students, groups, applications, reports, name);
                    break;
                }
                case 2: {
                    int size = input.readInt();
                    String surname = "";
                    for (int i = 0; i < size; i++) {
                        surname += input.readChar();
                    }
                    Vector<Student> students = new Vector<Student>();
                    Vector<Group> groups = new Vector<Group>();
                    Vector<Applications> applications = new Vector<Applications>();
                    Vector<Report> reports = new Vector<Report>();
                    con.readStudent(students);
                    con.readGroup(groups);
                    con.readApplication(applications);
                    con.readReport(reports);
                    readerStudentSurname(output, input, students, groups, applications, reports, surname);

                    break;
                }
                case 3: {
                    int size = input.readInt();
                    String patronymic = "";
                    for (int i = 0; i < size; i++) {
                        patronymic += input.readChar();
                    }
                    Vector<Student> students = new Vector<Student>();
                    Vector<Group> groups = new Vector<Group>();
                    Vector<Applications> applications = new Vector<Applications>();
                    Vector<Report> reports = new Vector<Report>();
                    con.readStudent(students);
                    con.readGroup(groups);
                    con.readApplication(applications);
                    con.readReport(reports);
                    readerStudentPatronymic(output, input, students, groups, applications, reports, patronymic);

                    break;
                }
                case 4: {
                    int day = input.readInt();
                    int monthe = input.readInt();
                    int year = input.readInt();
                    Vector<Student> students = new Vector<Student>();
                    Vector<Group> groups = new Vector<Group>();
                    Vector<Applications> applications = new Vector<Applications>();
                    Vector<Report> reports = new Vector<Report>();
                    con.readStudent(students);
                    con.readGroup(groups);
                    con.readApplication(applications);
                    con.readReport(reports);
                    readerStudentAge(output, input, students, groups, applications, reports, day, monthe, year);

                    break;
                }
                case 5: {

                    int group = input.readInt();
                    Vector<Student> students = new Vector<Student>();
                    Vector<Group> groups = new Vector<Group>();
                    Vector<Applications> applications = new Vector<Applications>();
                    Vector<Report> reports = new Vector<Report>();
                    con.readStudent(students);
                    con.readGroup(groups);
                    con.readApplication(applications);
                    con.readReport(reports);
                    readerStudentGroup(output, input, students, groups, applications, reports, group);

                    break;
                }
                case 6: {
                    int cours = input.readInt();
                    Vector<Student> students = new Vector<Student>();
                    Vector<Group> groups = new Vector<Group>();
                    Vector<Applications> applications = new Vector<Applications>();
                    Vector<Report> reports = new Vector<Report>();
                    con.readStudent(students);
                    con.readGroup(groups);
                    con.readApplication(applications);
                    con.readReport(reports);
                    readerStudentCours(output, input, students, groups, applications, reports, cours);

                    break;
                }
                case 7: {
                    int size = input.readInt();
                    String spec = "";
                    for (int i = 0; i < size; i++) {
                        spec += input.readChar();
                    }
                    Vector<Student> students = new Vector<Student>();
                    Vector<Group> groups = new Vector<Group>();
                    Vector<Applications> applications = new Vector<Applications>();
                    Vector<Report> reports = new Vector<Report>();
                    con.readStudent(students);
                    con.readGroup(groups);
                    con.readApplication(applications);
                    con.readReport(reports);
                    readerStudentSpec(output, input, students, groups, applications, reports, spec);

                    break;
                }
                case 8: {
                    int size = input.readInt();
                    String facul = "";
                    for (int i = 0; i < size; i++) {
                        facul += input.readChar();
                    }
                    Vector<Student> students = new Vector<Student>();
                    Vector<Group> groups = new Vector<Group>();
                    Vector<Applications> applications = new Vector<Applications>();
                    Vector<Report> reports = new Vector<Report>();
                    con.readStudent(students);
                    con.readGroup(groups);
                    con.readApplication(applications);
                    con.readReport(reports);
                    readerStudentFacult(output, input, students, groups, applications, reports, facul);

                    break;
                }

            }
    }

    public static void readerStepId(DataOutputStream output, DataInputStream input, Vector<Student> students,
                                           Vector<Group> groups, Vector<Applications> applications, Vector<Report> reports, int ID) throws IOException {
        int size =0;
        for(int i =0 ; i<reports.size(); i++) {

            if (reports.get(i).getId_report() == ID) {
                    size++;
            }

        }
        output.writeInt(size);
        for (int i = 0; i < reports.size(); i++) {
            for (int j = 0; j < students.size(); j++) {
                if (reports.get(i).getId_report() == ID && students.get(j).getId_student() ==ID)
                {
                    output.writeInt(reports.get(i).getId_report());
                    output.writeInt(students.get(j).getSurname().length());
                    for(int k = 0; k <students.get(j).getSurname().length(); k++)
                    {
                        output.writeChar(students.get(j).getSurname().charAt(k));
                    }
                    output.writeInt(students.get(j).getName().length());
                    for(int k = 0; k <students.get(j).getName().length(); k++)
                    {
                        output.writeChar(students.get(j).getName().charAt(k));
                    }
                    output.writeInt(students.get(j).getPatronymic().length());
                    for(int k = 0; k <students.get(j).getPatronymic().length(); k++)
                    {
                        output.writeChar(students.get(j).getPatronymic().charAt(k));
                    }
                    output.writeInt(students.get(j).getId_group());
                    output.writeInt(reports.get(i).getCol_passes());
                    output.writeFloat(reports.get(i).getRating());
                    output.writeFloat(reports.get(i).getPerconal_schjlarsip());
                }
            }
        }

    }
    public static void readerStepRating(DataOutputStream output, DataInputStream input, Vector<Student> students,
                                    Vector<Group> groups, Vector<Applications> applications, Vector<Report> reports, float rating) throws IOException {
        int size =0;
        for(int i =0 ; i<reports.size(); i++) {

            if (reports.get(i).getRating() == rating) {
                size++;
            }

        }
        output.writeInt(size);
        for (int i = 0; i < reports.size(); i++) {
            for (int j = 0; j < students.size(); j++) {

                if (reports.get(i).getRating() == rating && students.get(j).getId_student() ==reports.get(i).getId_report()) {
                    output.writeInt(reports.get(i).getId_report());
                    output.writeInt(students.get(j).getSurname().length());
                    for(int k = 0; k <students.get(j).getSurname().length(); k++)
                    {
                        output.writeChar(students.get(j).getSurname().charAt(k));
                    }
                    output.writeInt(students.get(j).getName().length());
                    for(int k = 0; k <students.get(j).getName().length(); k++)
                    {
                        output.writeChar(students.get(j).getName().charAt(k));
                    }
                    output.writeInt(students.get(j).getPatronymic().length());
                    for(int k = 0; k <students.get(j).getPatronymic().length(); k++)
                    {
                        output.writeChar(students.get(j).getPatronymic().charAt(k));
                    }
                    output.writeInt(students.get(j).getId_group());
                    output.writeInt(reports.get(i).getCol_passes());
                    output.writeFloat(reports.get(i).getRating());
                    output.writeFloat(reports.get(i).getPerconal_schjlarsip());
                }
            }
        }

    }
    public static void readerStepSumma(DataOutputStream output, DataInputStream input, Vector<Student> students,
                                    Vector<Group> groups, Vector<Applications> applications, Vector<Report> reports, float summa) throws IOException {
        int size =0;
        for(int i =0 ; i<reports.size(); i++) {

            if (reports.get(i).getPerconal_schjlarsip() == summa) {
                size++;
            }

        }
        output.writeInt(size);
        for (int i = 0; i < reports.size(); i++) {
            for (int j = 0; j < students.size(); j++) {

                if (reports.get(i).getPerconal_schjlarsip() == summa && students.get(j).getId_student() ==reports.get(i).getId_report()) {
                    output.writeInt(reports.get(i).getId_report());
                    output.writeInt(students.get(j).getSurname().length());
                    for(int k = 0; k <students.get(j).getSurname().length(); k++)
                    {
                        output.writeChar(students.get(j).getSurname().charAt(k));
                    }
                    output.writeInt(students.get(j).getName().length());
                    for(int k = 0; k <students.get(j).getName().length(); k++)
                    {
                        output.writeChar(students.get(j).getName().charAt(k));
                    }
                    output.writeInt(students.get(j).getPatronymic().length());
                    for(int k = 0; k <students.get(j).getPatronymic().length(); k++)
                    {
                        output.writeChar(students.get(j).getPatronymic().charAt(k));
                    }
                    output.writeInt(students.get(j).getId_group());
                    output.writeInt(reports.get(i).getCol_passes());
                    output.writeFloat(reports.get(i).getRating());
                    output.writeFloat(reports.get(i).getPerconal_schjlarsip());
                }
            }
        }

    }
    public static void readerStepCoeff(DataOutputStream output, DataInputStream input, Vector<Student> students,
                                    Vector<Group> groups, Vector<Applications> applications, Vector<Report> reports, float coeff) throws IOException {
        int size =0;
        for(int i =0 ; i<reports.size(); i++) {

            if (reports.get(i).getCoefficent() == coeff) {
                size++;
            }

        }
        output.writeInt(size);
        for (int i = 0; i < reports.size(); i++) {
            for (int j = 0; j < students.size(); j++) {

                if (reports.get(i).getCoefficent() == coeff && students.get(j).getId_student() ==reports.get(i).getId_report()) {
                    output.writeInt(reports.get(i).getId_report());
                    output.writeInt(students.get(j).getSurname().length());
                    for(int k = 0; k <students.get(j).getSurname().length(); k++)
                    {
                        output.writeChar(students.get(j).getSurname().charAt(k));
                    }
                    output.writeInt(students.get(j).getName().length());
                    for(int k = 0; k <students.get(j).getName().length(); k++)
                    {
                        output.writeChar(students.get(j).getName().charAt(k));
                    }
                    output.writeInt(students.get(j).getPatronymic().length());
                    for(int k = 0; k <students.get(j).getPatronymic().length(); k++)
                    {
                        output.writeChar(students.get(j).getPatronymic().charAt(k));
                    }
                    output.writeInt(students.get(j).getId_group());
                    output.writeInt(reports.get(i).getCol_passes());
                    output.writeFloat(reports.get(i).getRating());
                    output.writeFloat(reports.get(i).getPerconal_schjlarsip());
                }
            }
        }

    }
    public static void find_for_step(Socket socket, DataInputStream input, DataOutputStream output, Conection con) throws IOException {

        int choose;
            socket.close();
            input.close();
            output.close();
            Socket client = connection.accept();
            output = new DataOutputStream(client.getOutputStream());
            input = new DataInputStream(client.getInputStream());
            choose = input.readInt();
            switch (choose) {
                case 1: {
                    int id = input.readInt();
                    Vector<Student> students = new Vector<Student>();
                    Vector<Group> groups = new Vector<Group>();
                    Vector<Applications> applications = new Vector<Applications>();
                    Vector<Report> reports = new Vector<Report>();
                    con.readStudent(students);
                    con.readGroup(groups);
                    con.readApplication(applications);
                    con.readReport(reports);
                    readerStepId(output, input, students, groups, applications, reports, id);
                    break;
                }
                case 2: {
                    float rating = input.readFloat();
                    Vector<Student> students = new Vector<Student>();
                    Vector<Group> groups = new Vector<Group>();
                    Vector<Applications> applications = new Vector<Applications>();
                    Vector<Report> reports = new Vector<Report>();
                    con.readStudent(students);
                    con.readGroup(groups);
                    con.readApplication(applications);
                    con.readReport(reports);
                    readerStepRating(output, input, students, groups, applications, reports, rating);

                    break;
                }
                case 3: {
                    float summa = input.readFloat();
                    Vector<Student> students = new Vector<Student>();
                    Vector<Group> groups = new Vector<Group>();
                    Vector<Applications> applications = new Vector<Applications>();
                    Vector<Report> reports = new Vector<Report>();
                    con.readStudent(students);
                    con.readGroup(groups);
                    con.readApplication(applications);
                    con.readReport(reports);
                    readerStepSumma(output, input, students, groups, applications, reports, summa);

                    break;
                }
                case 4: {
                    float coeff = input.readFloat();
                    Vector<Student> students = new Vector<Student>();
                    Vector<Group> groups = new Vector<Group>();
                    Vector<Applications> applications = new Vector<Applications>();
                    Vector<Report> reports = new Vector<Report>();
                    con.readStudent(students);
                    con.readGroup(groups);
                    con.readApplication(applications);
                    con.readReport(reports);
                    readerStepCoeff(output, input, students, groups, applications, reports, coeff);

                    break;
                }

            }
    }

    public static void sort(Socket socket, DataInputStream input, DataOutputStream output, Conection con) throws IOException {

        int choose;

            socket.close();
            input.close();
            output.close();
            Socket client = connection.accept();
            output = new DataOutputStream(client.getOutputStream());
            input = new DataInputStream(client.getInputStream());
            choose = input.readInt();
            switch (choose) {
                case 1: {
                    Vector<Student> students = new Vector<Student>();
                    Vector<Group> groups = new Vector<Group>();
                    Vector<Applications> applications = new Vector<Applications>();
                    Vector<Report> reports = new Vector<Report>();
                    con.readStudent(students);
                    con.readGroup(groups);
                    con.readApplication(applications);
                    con.readReport(reports);
                    for(int i = 0; i+1 <students.size(); ++i)
                    {
                        for(int j =0;j+1<students.size()-i;j++) {
                            if (students.get(j).getId_student() > students.get(j + 1).getId_student()) {
                                Collections.swap(students, j, j+1);
                                Collections.swap(reports, j, j+1);
                            }
                        }
                    }
                    readerStudent(output, input, students, groups,applications,reports);

                    break;
                }
                case 2: {
                    Vector<Student> students = new Vector<Student>();
                    Vector<Group> groups = new Vector<Group>();
                    Vector<Applications> applications = new Vector<Applications>();
                    Vector<Report> reports = new Vector<Report>();
                    con.readStudent(students);
                    con.readGroup(groups);
                    con.readApplication(applications);
                    con.readReport(reports);
                    String [] surname = new String[students.size()];
                    for(int i = 0; i <students.size(); i++)
                    {
                        surname[i] = new String();
                    }
                    for(int i = 0; i <students.size(); i++) {

                        surname[i] = students.get(i).getSurname();
                    }
                    Arrays.sort(surname);
                    Vector<Student> students_itog = new Vector<Student>();
                    Vector<Report> reports_itog = new Vector<Report>();
                    for(int i = 0; i<surname.length; i++)
                    {
                        for(int j =0; j <students.size(); j++)
                        {
                            if(surname[i].equals(students.get(j).getSurname()))
                            {
                                students_itog.add(students.get(j));
                                reports_itog.add(reports.get(j));
                            }
                        }
                    }
                    readerStudent(output, input, students_itog, groups,applications,reports_itog);
                    break;
                }
                case 3: {
                    Vector<Student> students = new Vector<Student>();
                    Vector<Group> groups = new Vector<Group>();
                    Vector<Applications> applications = new Vector<Applications>();
                    Vector<Report> reports = new Vector<Report>();
                    con.readStudent(students);
                    con.readGroup(groups);
                    con.readApplication(applications);
                    con.readReport(reports);
                    String [] name = new String[students.size()];
                    for(int i = 0; i <students.size(); i++)
                    {
                        name[i] = new String();
                    }
                    for(int i = 0; i <students.size(); i++) {

                        name[i] = students.get(i).getName();
                    }
                    Arrays.sort(name);
                    Vector<Student> students_itog = new Vector<Student>();
                    Vector<Report> reports_itog = new Vector<Report>();
                    for(int i = 0; i<name.length; i++)
                    {
                        for(int j =0; j <students.size(); j++)
                        {
                            if(name[i].equals(students.get(j).getName()))
                            {
                                students_itog.add(students.get(j));
                                reports_itog.add(reports.get(j));
                            }
                        }
                    }
                    readerStudent(output, input, students_itog, groups,applications,reports_itog);
                    break;
                }
                case 4: {
                    Vector<Student> students = new Vector<Student>();
                    Vector<Group> groups = new Vector<Group>();
                    Vector<Applications> applications = new Vector<Applications>();
                    Vector<Report> reports = new Vector<Report>();
                    con.readStudent(students);
                    con.readGroup(groups);
                    con.readApplication(applications);
                    con.readReport(reports);
                    String [] patronymic = new String[students.size()];
                    for(int i = 0; i <students.size(); i++)
                    {
                        patronymic[i] = new String();
                    }
                    for(int i = 0; i <students.size(); i++) {

                        patronymic[i] = students.get(i).getPatronymic();
                    }
                    Arrays.sort(patronymic);
                    Vector<Student> students_itog = new Vector<Student>();
                    Vector<Report> reports_itog = new Vector<Report>();
                    for(int i = 0; i<patronymic.length; i++)
                    {
                        for(int j =0; j <students.size(); j++)
                        {
                            if(patronymic[i].equals(students.get(j).getPatronymic()))
                            {
                                students_itog.add(students.get(j));
                                reports_itog.add(reports.get(j));
                            }
                        }
                    }
                    readerStudent(output, input, students_itog, groups,applications,reports_itog);
                    break;
                }
                case 5: {
                    Vector<Student> students = new Vector<Student>();
                    Vector<Group> groups = new Vector<Group>();
                    Vector<Applications> applications = new Vector<Applications>();
                    Vector<Report> reports = new Vector<Report>();
                    con.readStudent(students);
                    con.readGroup(groups);
                    con.readApplication(applications);
                    con.readReport(reports);
                    for(int i = 0; i+1 <students.size(); ++i)
                    {
                        for(int j =0;j+1<students.size()-i;j++) {
                            if (students.get(j).getId_group() > students.get(j + 1).getId_group()) {
                                Collections.swap(students, j, j+1);
                                Collections.swap(reports, j, j+1);
                            }
                        }
                    }
                    readerStudent(output, input, students, groups,applications,reports);

                    break;
                }
                case 6: {
                    Vector<Student> students = new Vector<Student>();
                    Vector<Group> groups = new Vector<Group>();
                    Vector<Applications> applications = new Vector<Applications>();
                    Vector<Report> reports = new Vector<Report>();
                    con.readStudent(students);
                    con.readGroup(groups);
                    con.readApplication(applications);
                    con.readReport(reports);
                    for(int i = 0; i+1 <reports.size(); ++i)
                    {
                        for(int j =0;j+1<reports.size()-i;j++) {
                            if (reports.get(j).getCol_passes() > reports.get(j + 1).getCol_passes()) {
                                Collections.swap(students, j, j+1);
                                Collections.swap(reports, j, j+1);
                            }
                        }
                    }
                    readerStudent(output, input, students, groups,applications,reports);

                    break;
                }
                case 7: {
                    Vector<Student> students = new Vector<Student>();
                    Vector<Group> groups = new Vector<Group>();
                    Vector<Applications> applications = new Vector<Applications>();
                    Vector<Report> reports = new Vector<Report>();
                    con.readStudent(students);
                    con.readGroup(groups);
                    con.readApplication(applications);
                    con.readReport(reports);
                    for(int i = 0; i+1 <reports.size(); ++i)
                    {
                        for(int j =0;j+1<reports.size()-i;j++) {
                            if (reports.get(j).getRating() > reports.get(j + 1).getRating()) {
                                Collections.swap(students, j, j+1);
                                Collections.swap(reports, j, j+1);
                            }
                        }
                    }
                    readerStudent(output, input, students, groups,applications,reports);

                    break;
                }
                case 8: {
                    int num = input.readInt();
                    Vector<Student> students = new Vector<Student>();
                    Vector<Group> groups = new Vector<Group>();
                    Vector<Applications> applications = new Vector<Applications>();
                    Vector<Report> reports = new Vector<Report>();
                    con.readStudent(students);
                    con.readGroup(groups);
                    con.readApplication(applications);
                    con.readReport(reports);
                    Vector<Student> student_itog = new Vector<Student>();
                    Vector<Report> reports_itog = new Vector<Report>();
                    for(int i = 0; i <students.size(); i++)
                    {
                            if(reports.get(i).getRating()>=num)
                            {
                                student_itog.add(students.get(i));
                                reports_itog.add(reports.get(i));
                            }
                    }
                    readerStudent(output, input, student_itog, groups,applications,reports_itog);
                    break;
                }
                case 9: {
                    int num = input.readInt();
                    Vector<Student> students = new Vector<Student>();
                    Vector<Group> groups = new Vector<Group>();
                    Vector<Applications> applications = new Vector<Applications>();
                    Vector<Report> reports = new Vector<Report>();
                    con.readStudent(students);
                    con.readGroup(groups);
                    con.readApplication(applications);
                    con.readReport(reports);
                    Vector<Student> student_itog = new Vector<Student>();
                    Vector<Report> reports_itog = new Vector<Report>();
                    for(int i = 0; i <students.size(); i++)
                    {
                        if(reports.get(i).getRating()<=num)
                        {
                            student_itog.add(students.get(i));
                            reports_itog.add(reports.get(i));
                        }
                    }
                    readerStudent(output, input, student_itog, groups,applications,reports_itog);
                    break;
                }
                case 10: {
                    int num = input.readInt();
                    Vector<Student> students = new Vector<Student>();
                    Vector<Group> groups = new Vector<Group>();
                    Vector<Applications> applications = new Vector<Applications>();
                    Vector<Report> reports = new Vector<Report>();
                    con.readStudent(students);
                    con.readGroup(groups);
                    con.readApplication(applications);
                    con.readReport(reports);
                    Vector<Student> student_itog = new Vector<Student>();
                    Vector<Report> reports_itog = new Vector<Report>();
                    for(int i = 0; i <students.size(); i++)
                    {
                        if(reports.get(i).getCol_passes()>=num)
                        {
                            student_itog.add(students.get(i));
                            reports_itog.add(reports.get(i));
                        }
                    }
                    readerStudent(output, input, student_itog, groups,applications,reports_itog);
                    break;
                }
                case 11: {
                    int num = input.readInt();
                    Vector<Student> students = new Vector<Student>();
                    Vector<Group> groups = new Vector<Group>();
                    Vector<Applications> applications = new Vector<Applications>();
                    Vector<Report> reports = new Vector<Report>();
                    con.readStudent(students);
                    con.readGroup(groups);
                    con.readApplication(applications);
                    con.readReport(reports);
                    Vector<Student> student_itog = new Vector<Student>();
                    Vector<Report> reports_itog = new Vector<Report>();
                    for(int i = 0; i <students.size(); i++)
                    {
                        if(reports.get(i).getCol_passes()<=num)
                        {
                            student_itog.add(students.get(i));
                            reports_itog.add(reports.get(i));
                        }
                    }
                    readerStudent(output, input, student_itog, groups,applications,reports_itog);
                    break;
                }


            }

    }
    public static void sort(Socket socket, DataInputStream input, DataOutputStream output, Conection con, int s) throws IOException {

        int choose;
            socket.close();
            input.close();
            output.close();
            Socket client = connection.accept();
            output = new DataOutputStream(client.getOutputStream());
            input = new DataInputStream(client.getInputStream());
            choose = input.readInt();
            switch (choose) {
                case 1: {
                    Vector<Student> students = new Vector<Student>();
                    Vector<Group> groups = new Vector<Group>();
                    Vector<Applications> applications = new Vector<Applications>();
                    Vector<Report> reports = new Vector<Report>();
                    con.readStudent(students);
                    con.readGroup(groups);
                    con.readApplication(applications);
                    con.readReport(reports);
                    for(int i = 0; i+1 <reports.size(); ++i)
                    {
                        for(int j =0;j+1<reports.size()-i;j++) {
                            if (reports.get(j).getPerconal_schjlarsip() > reports.get(j + 1).getPerconal_schjlarsip()) {
                                Collections.swap(students, j, j+1);
                                Collections.swap(reports, j, j+1);
                            }
                        }
                    }
                    readerStudent(output, input, students, groups,reports);

                    break;
                }
                case 2: {
                    Vector<Student> students = new Vector<Student>();
                    Vector<Group> groups = new Vector<Group>();
                    Vector<Applications> applications = new Vector<Applications>();
                    Vector<Report> reports = new Vector<Report>();
                    con.readStudent(students);
                    con.readGroup(groups);
                    con.readApplication(applications);
                    con.readReport(reports);
                    for(int i = 0; i+1 <reports.size(); ++i)
                    {
                        for(int j =0;j+1<reports.size()-i;j++) {
                            if (reports.get(j).getCoefficent() > reports.get(j + 1).getCoefficent()) {
                                Collections.swap(students, j, j+1);
                                Collections.swap(reports, j, j+1);
                            }
                        }
                    }
                    readerStudent(output, input, students, groups,reports);

                    break;
                }
                case 3: {
                    int num = input.readInt();
                    Vector<Student> students = new Vector<Student>();
                    Vector<Group> groups = new Vector<Group>();
                    Vector<Applications> applications = new Vector<Applications>();
                    Vector<Report> reports = new Vector<Report>();
                    con.readStudent(students);
                    con.readGroup(groups);
                    con.readApplication(applications);
                    con.readReport(reports);
                    Vector<Student> student_itog = new Vector<Student>();
                    Vector<Report> reports_itog = new Vector<Report>();
                    for(int i = 0; i <students.size(); i++)
                    {
                        if(reports.get(i).getCoefficent()>=num)
                        {
                            student_itog.add(students.get(i));
                            reports_itog.add(reports.get(i));
                        }
                    }
                    readerStudent(output, input, student_itog, groups,reports_itog);
                    break;
                }
                case 4: {
                    int num = input.readInt();
                    Vector<Student> students = new Vector<Student>();
                    Vector<Group> groups = new Vector<Group>();
                    Vector<Applications> applications = new Vector<Applications>();
                    Vector<Report> reports = new Vector<Report>();
                    con.readStudent(students);
                    con.readGroup(groups);
                    con.readApplication(applications);
                    con.readReport(reports);
                    Vector<Student> student_itog = new Vector<Student>();
                    Vector<Report> reports_itog = new Vector<Report>();
                    for(int i = 0; i <students.size(); i++)
                    {
                        if(reports.get(i).getCoefficent()<=num)
                        {
                            student_itog.add(students.get(i));
                            reports_itog.add(reports.get(i));
                        }
                    }
                    readerStudent(output, input, student_itog, groups,reports_itog);
                    break;
                }
                case 5: {
                    int num = input.readInt();
                    Vector<Student> students = new Vector<Student>();
                    Vector<Group> groups = new Vector<Group>();
                    Vector<Applications> applications = new Vector<Applications>();
                    Vector<Report> reports = new Vector<Report>();
                    con.readStudent(students);
                    con.readGroup(groups);
                    con.readApplication(applications);
                    con.readReport(reports);
                    Vector<Student> student_itog = new Vector<Student>();
                    Vector<Report> reports_itog = new Vector<Report>();
                    for(int i = 0; i <students.size(); i++)
                    {
                        if(reports.get(i).getPerconal_schjlarsip()>=num)
                        {
                            student_itog.add(students.get(i));
                            reports_itog.add(reports.get(i));
                        }
                    }
                    readerStudent(output, input, student_itog, groups,reports_itog);
                    break;
                }
                case 6: {
                    int num = input.readInt();
                    Vector<Student> students = new Vector<Student>();
                    Vector<Group> groups = new Vector<Group>();
                    Vector<Applications> applications = new Vector<Applications>();
                    Vector<Report> reports = new Vector<Report>();
                    con.readStudent(students);
                    con.readGroup(groups);
                    con.readApplication(applications);
                    con.readReport(reports);
                    Vector<Student> student_itog = new Vector<Student>();
                    Vector<Report> reports_itog = new Vector<Report>();
                    for(int i = 0; i <students.size(); i++)
                    {
                        if(reports.get(i).getPerconal_schjlarsip()<=num)
                        {
                            student_itog.add(students.get(i));
                            reports_itog.add(reports.get(i));
                        }
                    }
                    readerStudent(output, input, student_itog, groups,reports_itog);
                    break;
                }

                }

    }
    public static void work_with_report(Socket socket, DataInputStream input, DataOutputStream output, Conection con) throws IOException, SQLException, ClassNotFoundException {

        Socket client = connection.accept();
        output = new DataOutputStream(client.getOutputStream());
        input = new DataInputStream(client.getInputStream());
        output.writeInt(autoris_id);
        int choose = input.readInt();
        input.close();
        output.close();
        socket.close();
        con.getDbCon();
        switch (choose) {
            case 1: {
                int flag =0;
                Vector<Request> req = new Vector<Request>();
                con.readRequst(req);
                client = connection.accept();
                output = new DataOutputStream(client.getOutputStream());
                input = new DataInputStream(client.getInputStream());
                for (int i = 0; i < req.size(); i++)
                {
                    if(req.get(i).getId_student() == autoris_id)
                    {
                        flag++;
                    }
                }
                if(flag==0)
                {
                    output.writeInt(1);
                    float scholarship = input.readFloat();
                    float f_scholarship = input.readFloat();
                    String status = "В обработке";
                    Request request = new Request(autoris_id, scholarship, f_scholarship, status);
                    req.add(request);
                    con.writeRequest(req, req.size()-1);

                }
                else {
                    int flag2 = 0;
                    for (int i = 0; i < req.size(); i++) {
                        if (req.get(i).getId_student() == autoris_id && req.get(i).getStatus().equals("Обработан")) {
                            con.deleteRequest(autoris_id);
                            flag2++;
                        }
                    }
                    if (flag2 == 0) {
                        output.writeInt(0);
                    }
                    else {

                        output.writeInt(1);
                        float scholarship = input.readFloat();
                        float f_scholarship = input.readFloat();
                        String status = "В обработке";
                        Request request = new Request(autoris_id, scholarship, f_scholarship, status);
                        req.add(request);
                        con.writeRequest(req, req.size()-1);
                    }
                }
                break;
            }
            case 2:
            {
                client = connection.accept();
                output = new DataOutputStream(client.getOutputStream());
                input = new DataInputStream(client.getInputStream());
                int flag =0;
                Vector<Request> req = new Vector<Request>();
                con.readRequst(req);
                for (int i = 0; i < req.size(); i++)
                {
                    if(req.get(i).getId_student() == autoris_id)
                    {
                        flag++;
                    }
                }
                if(flag>0)
                {
                    output.writeInt(1);
                    output.writeInt(flag);
                    for(int i =0; i <req.size(); i++)
                    {
                        if(req.get(i).getId_student() == autoris_id)
                        {
                            output.writeInt(req.get(i).getId_student());
                            output.writeFloat(req.get(i).getScholarship());
                            output.writeFloat(req.get(i).getF_scholarship());
                            output.writeInt(req.get(i).getStatus().length());
                            for (int j=0;j <req.get(i).getStatus().length(); j++)
                            {
                                output.writeChar(req.get(i).getStatus().charAt(j));
                            }

                        }
                    }

                }
                else {
                    output.writeInt(0);
                }
                break;
            }
            case 3:
            {
                client = connection.accept();
                output = new DataOutputStream(client.getOutputStream());
                input = new DataInputStream(client.getInputStream());
                int flag =0;
                Vector<Request> req = new Vector<Request>();
                con.readRequst(req);
                for (int i = 0; i < req.size(); i++)
                {
                    if(req.get(i).getId_student() == autoris_id)
                    {
                        flag++;
                    }
                }
                if(flag>0)
                {
                    output.writeInt(1);
                    con.deleteRequest(autoris_id);

                }
                else {
                    output.writeInt(0);
                }
                break;
            }
            case 4:
            {

                break;
            }
        }
    }

    public static void work_with_request(Socket socket, DataInputStream input, DataOutputStream output, Conection db) throws IOException, SQLException, ClassNotFoundException
    {
        int choose =0;
        choose = input.readInt();
        socket.close();
        input.close();
        output.close();
        db.getDbCon();
        int flag =0;
        switch (choose) {
            case 1:
            {
                Vector<Request> requests = new Vector<Request>();
                db.readRequst(requests);
                Socket client = connection.accept();
                output = new DataOutputStream(client.getOutputStream());
                input = new DataInputStream(client.getInputStream());
                output.writeInt(requests.size());
                for(int i =0; i< requests.size(); i++)
                {
                    output.writeInt(requests.get(i).getId_student());
                    output.writeFloat(requests.get(i).getScholarship());
                    output.writeFloat(requests.get(i).getF_scholarship());
                    output.writeInt(requests.get(i).getStatus().length());
                    for(int j =0; j<requests.get(i).getStatus().length(); j++)
                    {
                        output.writeChar(requests.get(i).getStatus().charAt(j));
                    }
                }


                break;
            }

            case 2:
            {
                Vector<Request> requests = new Vector<Request>();
                db.readRequst(requests);
                Socket client = connection.accept();
                output = new DataOutputStream(client.getOutputStream());
                input = new DataInputStream(client.getInputStream());
                int id = input.readInt();
                if(db.deleteRequest(id))
                {
                    output.writeInt(1);
                }
                else
                {
                    output.writeInt(0);
                }

                break;
            }
            case 3:
            {
                db.getDbCon();
                Socket client = connection.accept();
                output = new DataOutputStream(client.getOutputStream());
                input = new DataInputStream(client.getInputStream());
                int id = input.readInt();
                int col_pas = input.readInt();
                float rat = input.readFloat();
                float coef = input.readFloat();
                float summa = getSumma(id, col_pas, rat, coef, db);
                Request request = new Request(id, "Обработан");
                Report report = new Report(id, col_pas, rat,coef, summa);
                db.changeReport(report);
                db.changeRequest(request);
                output.writeFloat(summa);
                break;
            }
            case 4:
            {


                break;
            }

        }
    }
    public static float getSumma(int id, int col_passes, float rating, float coef, Conection con) throws SQLException, ClassNotFoundException {
        con.getDbCon();
        Vector<Report> rep = new Vector<Report>();
        Vector<Student> students = new Vector<Student>();
        Vector<Applications> applications = new Vector<Applications>();
        con.readReport(rep);
        con.readApplication(applications);
        con.readStudent(students);
        float sum = (float) 112.58;
        coef = (coef*sum)/10;
        if(rating>6.9 && rating<8)
        {
            rating = (float) (((1.2)*sum)/10);
        }
        if(rating>7.9 && rating<9)
        {
            rating = (float) (((1.4)*sum)/10);
        }
        if(rating>8.9 && rating<10)
        {
            rating = (float) (((1.6)*sum)/10);
        }
        sum=sum+coef+rating;
        for(int i = 0; i <students.size(); i++)
        {
            if(students.get(i).getId_student()==id)
            {
                for(int j =0; j <applications.size(); j++)
                {
                    if(students.get(i).getId_applications().equals(applications.get(j).getName_scholarsip()))
                    {
                        sum=sum+applications.get(j).getAmount();
                    }
                }
            }
        }
        return sum;
    }
    public static void men_for_Admin(Conection con, DataOutputStream output, DataInputStream input) throws IOException, SQLException, ClassNotFoundException {

        int choose=0;
        do {
            Socket client = connection.accept();
            output = new DataOutputStream(client.getOutputStream());
            input = new DataInputStream(client.getInputStream());
            choose = input.readInt();
            switch (choose) {
                case 1: {
                    Vector<Student> students = new Vector<Student>();
                    Vector<Group> groups = new Vector<Group>();
                    Vector<Applications> applications = new Vector<Applications>();
                    Vector<Report> reports = new Vector<Report>();

                    con.readStudent(students);
                    con.readGroup(groups);
                    con.readApplication(applications);
                    con.readReport(reports);
                    readerStudent(output, input, students, groups, applications, reports);

                    client.close();
                    output.close();
                    input.close();

                    break;
                }
                case 2: {
                    int flag1=0, flag2=0;
                    Vector<Student> students = new Vector<Student>();
                    Vector<Group> groups = new Vector<Group>();
                    Vector<Applications> applications = new Vector<Applications>();
                    Vector<Report> reports = new Vector<Report>();
                    Vector<User> users = new Vector<User>();
                    User us = new User();
                    con.readStudent(students);
                    con.readApplication(applications);
                    con.readGroup(groups);
                    con.readReport(reports);
                    Student st = new Student();
                    Group gr = new Group();
                    Applications app = new Applications();
                    Report report = new Report();
                    int id = input.readInt();
                    int flag=1;
                    for (int i = 0; i<students.size(); i++)
                    {
                        if(id == students.get(i).getId_student())
                        {
                            flag++;
                        }
                    }
                    output.writeInt(flag);
                    if(flag==1) {

                        st.setId_student(input.readInt());
                        int length = input.readInt();
                        String str = "";
                        for (int i = 0; i < length; i++) {
                            str += input.readChar();
                        }
                        st.setSurname(str);
                        str = "";
                        length = input.readInt();
                        for (int i = 0; i < length; i++) {
                            str += input.readChar();
                        }
                        st.setName(str);
                        str = "";
                        length = input.readInt();
                        for (int i = 0; i < length; i++) {
                            str += input.readChar();
                        }
                        st.setPatronymic(str);
                        str = "";
                        st.setId_group(input.readInt());
                        for (int i = 0; i < groups.size(); i++) {
                            if (groups.get(i).getNumber_group() == st.getId_group()) {
                                flag1++;
                            }
                        }
                        gr.setNumber_group(st.getId_group());

                        length = input.readInt();
                        for (int i = 0; i < length; i++) {
                            str += input.readChar();
                        }
                        st.setId_applications(str);
                        app.setName_scholarsip(str);
                        str = "";
                        st.setId_report(0);
                        st.setDay(input.readInt());
                        st.setMonthe(input.readInt());
                        st.setYear(input.readInt());
                        length = input.readInt();
                        for (int i = 0; i < length; i++) {
                            str += input.readChar();
                        }
                        app.setName_scholarsip(str);
                        str = "";

                        gr.setCours(input.readInt());
                        length = input.readInt();
                        for (int i = 0; i < length; i++) {
                            str += input.readChar();
                        }
                        gr.setFaculty(str);
                        str = "";
                        length = input.readInt();
                        for (int i = 0; i < length; i++) {
                            str += input.readChar();
                        }
                        gr.setSpeciality(str);
                        str = "";
                        students.add(st);
                        groups.add(gr);
                        applications.add(app);

                        length = input.readInt();
                        for (int i = 0; i < length; i++) {
                            str += input.readChar();
                        }
                        us.setLogin(str);
                        str = "";
                        length = input.readInt();
                        for (int i = 0; i < length; i++) {
                            str += input.readChar();
                        }
                        us.setPassword(str);
                        us.setId_student(st.getId_student());
                        str = "";
                        report.setId_report(us.getId_student());
                        st.setId_report(report.getId_report());
                        reports.add(report);

                        users.add(us);
                        try {
                            if (flag1 == 0) {
                                con.writeGroup(groups, groups.size() - 1);
                            }
                            con.writeReport(reports, reports.size() - 1);
                            con.writeUser(users, users.size() - 1);
                            con.writeStudent(students, students.size() - 1);


                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        } catch (ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    client.close();
                    output.close();
                    input.close();
                    break;
                }
                case 3: {
                    Vector<Admin> admins = new Vector<Admin>();
                    Vector<Info_Admin> info_admins = new Vector<Info_Admin>();
                    Admin ad = new Admin();
                    Info_Admin inf = new Info_Admin();
                    con.getDbCon();
                    con.readAdmin(admins);
                    int flag=1;
                    do {
                        flag=1;
                        int id = input.readInt();
                        for (int i = 0; i < admins.size(); i++) {
                            if (id == admins.get(i).getKey()) {
                                flag++;
                            }
                        }
                        output.writeInt(flag);
                    }while (flag!=1);
                    if(flag==1) {
                        ad.setKey(input.readInt());
                        String ss = "";
                        int size = input.readInt();
                        for (int i = 0; i < size; i++) {
                            ss += input.readChar();
                        }
                        ad.setLogin(ss);
                        ss = "";
                        size = input.readInt();
                        for (int i = 0; i < size; i++) {
                            ss += input.readChar();
                        }
                        ad.setPassword(ss);

                        ss = "";
                        size = input.readInt();
                        for (int i = 0; i < size; i++) {
                            ss += input.readChar();
                        }
                        inf.setSurname(ss);
                        ss = "";
                        size = input.readInt();
                        for (int i = 0; i < size; i++) {
                            ss += input.readChar();
                        }
                        inf.setName(ss);
                        ss = "";
                        size = input.readInt();
                        for (int i = 0; i < size; i++) {
                            ss += input.readChar();
                        }
                        inf.setPatronymic(ss);
                        ss = "";
                        size = input.readInt();
                        for (int i = 0; i < size; i++) {
                            ss += input.readChar();
                        }
                        inf.setWork(ss);
                        inf.setKey(ad.getKey());

                        admins.add(ad);
                        info_admins.add(inf);
                        con.signUp(admins, admins.size() - 1);
                        con.writeInfo_Admin(info_admins, info_admins.size() - 1);
                        client.close();
                        output.close();
                        input.close();
                    }
                    break;
                }
                case 4: {

                    Vector<Admin> admins = new Vector<Admin>();
                    Vector<Info_Admin> info_admins = new Vector<Info_Admin>();
                    con.readAdmin(admins);
                    con.readInfo_Admin(info_admins);
                    output.writeInt(info_admins.size());
                    for (int i = 0; i < info_admins.size(); i++) {
                        output.writeInt(admins.get(i).getLogin().length());
                        for(int j =0; j< admins.get(i).getLogin().length(); j++)
                        {
                            output.writeChar(admins.get(i).getLogin().charAt(j));
                        }
                        output.writeInt(info_admins.get(i).getSurname().length());
                        for(int j =0; j <info_admins.get(i).getSurname().length(); j++)
                        {
                            output.writeChar(info_admins.get(i).getSurname().charAt(j));
                        }
                        output.writeInt(info_admins.get(i).getName().length());
                        for(int j =0; j <info_admins.get(i).getName().length(); j++)
                        {
                            output.writeChar(info_admins.get(i).getName().charAt(j));
                        }
                        output.writeInt(info_admins.get(i).getPatronymic().length());
                        for(int j =0; j <info_admins.get(i).getPatronymic().length(); j++)
                        {
                            output.writeChar(info_admins.get(i).getPatronymic().charAt(j));
                        }
                        output.writeInt(info_admins.get(i).getWork().length());
                        for(int j =0; j <info_admins.get(i).getWork().length(); j++)
                        {
                            output.writeChar(info_admins.get(i).getWork().charAt(j));
                        }

                    }
                    client.close();
                    output.close();
                    input.close();
                    break;
                }
                case 5: {

                    change(client,input, output, con, 1);
                    client.close();
                    output.close();
                    input.close();
                    break;
                }
                case 6: {

                    if(flag_prov_del_admin ==0) {
                        change(client, input, output, con);
                        if(flag_prov_del_admin >0) choose=15;
                    }
                    else
                    {
                        choose=15;
                    }
                    client.close();
                    output.close();
                    input.close();
                    break;
                }
                case 7: {

                    work_with_request(client, input, output, con);
                    client.close();
                    output.close();
                    input.close();
                    break;
                }
                case 8: {

                    con.getDbCon();
                    int id = input.readInt();
                    int col_pas = input.readInt();
                    float rat = input.readFloat();
                    float coef = input.readFloat();
                    float summa = getSumma(id, col_pas, rat, coef, con);
                    Report report = new Report(id, col_pas, rat,coef, summa);
                    con.changeReport(report);
                    output.writeFloat(summa);
                    client.close();
                    output.close();
                    input.close();

                    break;
                }
                case 9: {
                    find_for_student(client, input, output, con);
                    client.close();
                    output.close();
                    input.close();
                    break;
                }
                case 10: {

                    find_for_step(client, input, output, con);
                    client.close();
                    output.close();
                    input.close();
                    break;
                }
                case 11: {
                    sort(client, input, output, con);
                    client.close();
                    output.close();
                    input.close();
                    break;
                }
                case 12: {
                    sort(client, input, output, con,2);
                    client.close();
                    output.close();
                    input.close();
                    break;

                }
                case 13:
                {
                    report_men(con, output, input);
                    client.close();
                    output.close();
                    input.close();
                    break;
                }
                case 15: {
                    flag_prov_del_admin =0;
                    client.close();
                    output.close();
                    input.close();
                    break;
                }

            }
        } while (choose != 15);

    }

    public static void work_with_reg(Conection con, DataOutputStream output, DataInputStream input) throws IOException, SQLException, ClassNotFoundException {
        int choose=0;
        Socket client = connection.accept();
        output = new DataOutputStream(client.getOutputStream());
        input = new DataInputStream(client.getInputStream());

        choose = input.readInt();
        output.close();
        input.close();
        client.close();
        switch (choose) {
            case 1:
            {
               client = connection.accept();
               output = new DataOutputStream(client.getOutputStream());
               input = new DataInputStream(client.getInputStream());
               int id = autoris_id;
               String ss ="";
               int size = input.readInt();
               for(int i = 0; i <size; i++)
               {
                   ss+=input.readChar();
               }
                con.getDbCon();
                con.changeLoginStudent(id, ss);
                output.writeInt(1);
                output.close();
                input.close();
                client.close();
                break;
            }
            case 2:
            {
                 client = connection.accept();
                output = new DataOutputStream(client.getOutputStream());
                input = new DataInputStream(client.getInputStream());
                int id = autoris_id;
                String ss ="";
                int size = input.readInt();
                for(int i = 0; i <size; i++)
                {
                    ss+=input.readChar();
                }
                con.getDbCon();
                con.changePasswordStudent(id, ss);
                output.writeInt(1);
                output.close();
                input.close();
                client.close();
                break;
            }
            case 3:
            {
                client = connection.accept();
                output = new DataOutputStream(client.getOutputStream());
                input = new DataInputStream(client.getInputStream());
                int id = autoris_id;
                con.getDbCon();
                con.deleteStudent(id, id);
                output.writeInt(1);
                output.close();
                input.close();
                client.close();
                break;
            }
        }
    }
    public static void men_for_User(Conection con, DataOutputStream output, DataInputStream input) throws IOException,SQLException, ClassNotFoundException
    {
        int choose=0;
        do {
            Socket client = connection.accept();
            output = new DataOutputStream(client.getOutputStream());
            input = new DataInputStream(client.getInputStream());
            choose = input.readInt();
            switch (choose) {
                case 1:
                {
                    work_with_reg(con, output, input);
                    output.close();
                    input.close();
                    client.close();
                    break;
                }
                case 2:
                {
                    report_men(con, output);
                    client.close();
                    output.close();
                    input.close();
                    break;
                }
                case 3:
                {
                    sort(client, input, output, con);
                    output.close();
                    input.close();
                    client.close();
                    break;
                }
                case 4:
                {
                    sort(client, input, output, con,2);
                    output.close();
                    input.close();
                    client.close();
                    break;
                }
                case 5:
                {
                    work_with_report(client, input, output, con);
                    output.close();
                    input.close();
                    client.close();
                    break;
                }
                case 6:
                {
                    find_for_student(client,input,output, con);
                    output.close();
                    input.close();
                    client.close();
                    break;
                }
                case 7:
                {
                    find_for_step(client,input, output, con);
                    output.close();
                    input.close();
                    client.close();
                    break;
                }
                case 8:
                {
                    output.close();
                    input.close();
                    client.close();
                    break;
                }
                case 9:
                {
                    output.close();
                    input.close();
                    client.close();
                    break;
                }

            }
            }while(choose!=8);
    }
    public static void report_men(Conection con, DataOutputStream output, DataInputStream input) throws IOException, SQLException, ClassNotFoundException {
        Socket client = connection.accept();
        output = new DataOutputStream(client.getOutputStream());
        input = new DataInputStream(client.getInputStream());
        int choose = input.readInt();
        switch (choose)
        {
            case 2:
            {
                con.getDbCon();
                Vector<Report> reports = new Vector<Report>();
                Vector<Student> students = new Vector<Student>();
                con.readReport(reports);
                con.readStudent(students);
                int id = input.readInt();
                for(int i = 0; i <students.size();i++)
                {
                    if(id == students.get(i).getId_student() && id == reports.get(i).getId_report())
                    {
                        output.writeFloat(reports.get(i).getPerconal_schjlarsip());
                        output.writeInt(reports.get(i).getCol_passes());
                        output.writeInt(students.get(i).getDay());
                        output.writeInt(students.get(i).getMonthe());
                        output.writeInt(students.get(i).getYear());
                        output.writeFloat(reports.get(i).getRating());
                        output.writeInt(students.get(i).getSurname().length());
                        for(int j = 0; j < students.get(i).getSurname().length(); j++)
                        {
                            output.writeChar(students.get(i).getSurname().charAt(j));
                        }
                        output.writeInt(students.get(i).getName().length());
                        for(int j = 0; j < students.get(i).getName().length(); j++)
                        {
                            output.writeChar(students.get(i).getName().charAt(j));
                        }
                        output.writeInt(students.get(i).getPatronymic().length());
                        for(int j = 0; j < students.get(i).getPatronymic().length(); j++)
                        {
                            output.writeChar(students.get(i).getPatronymic().charAt(j));
                        }
                        output.writeInt(students.get(i).getId_student());
                        output.writeInt(students.get(i).getId_group());

                    }
                }
                break;
            }
            case 3:
            {
                con.getDbCon();
                Vector<Report> reports = new Vector<Report>();
                con.readReport(reports);
                output.writeInt(reports.size());
                for(int i = 0; i<reports.size(); i++)
                {
                    output.writeInt(reports.get(i).getId_report());
                    output.writeFloat(reports.get(i).getRating());
                }

                break;
            }
        }
    }
    public static void report_men(Conection con, DataOutputStream output) throws IOException, SQLException, ClassNotFoundException {
        Socket client = connection.accept();
        output = new DataOutputStream(client.getOutputStream());
        input = new DataInputStream(client.getInputStream());
        int choose = input.readInt();
        switch (choose)
        {
            case 2:
            {
                con.getDbCon();
                Vector<Report> reports = new Vector<Report>();
                Vector<Student> students = new Vector<Student>();
                con.readReport(reports);
                con.readStudent(students);
                int id = autoris_id;
                for(int i = 0; i <students.size();i++)
                {
                    if(id == students.get(i).getId_student() && id == reports.get(i).getId_report())
                    {
                        output.writeFloat(reports.get(i).getPerconal_schjlarsip());
                        output.writeInt(reports.get(i).getCol_passes());
                        output.writeInt(students.get(i).getDay());
                        output.writeInt(students.get(i).getMonthe());
                        output.writeInt(students.get(i).getYear());
                        output.writeFloat(reports.get(i).getRating());
                        output.writeInt(students.get(i).getSurname().length());
                        for(int j = 0; j < students.get(i).getSurname().length(); j++)
                        {
                            output.writeChar(students.get(i).getSurname().charAt(j));
                        }
                        output.writeInt(students.get(i).getName().length());
                        for(int j = 0; j < students.get(i).getName().length(); j++)
                        {
                            output.writeChar(students.get(i).getName().charAt(j));
                        }
                        output.writeInt(students.get(i).getPatronymic().length());
                        for(int j = 0; j < students.get(i).getPatronymic().length(); j++)
                        {
                            output.writeChar(students.get(i).getPatronymic().charAt(j));
                        }
                        output.writeInt(students.get(i).getId_student());
                        output.writeInt(students.get(i).getId_group());

                    }
                }
                break;
            }
            case 3:
            {
                con.getDbCon();
                Vector<Report> reports = new Vector<Report>();
                con.readReport(reports);
                output.writeInt(reports.size());
                for(int i = 0; i<reports.size(); i++)
                {
                    output.writeInt(reports.get(i).getId_report());
                    output.writeFloat(reports.get(i).getRating());
                }

                break;
            }
        }
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {

        Conection con = new Conection();
        con.getDbCon();
        connection = new ServerSocket(1024);
                int flag = 0;
                do {
                    Socket client = connection.accept();
                    countclients++;
                    flag_prov_del_admin =0;
                    autoris_id = 0;
                    System.out.println("=======================================");
                    System.out.println("Клиент " + countclients + " добавлен");
                    output = new DataOutputStream(client.getOutputStream());
                    input = new DataInputStream(client.getInputStream());
                    int choose_rol = input.readInt();
                    if (choose_rol == 1) {
                        int login_length = input.readInt();
                        System.out.println(login_length);
                        String login = "";
                        for (int i = 0; i < login_length; i++) {
                            login += input.readChar();
                        }
                        int password_length = input.readInt();
                        System.out.println(password_length);
                        String password = "";
                        for (int i = 0; i < password_length; i++) {
                            password += input.readChar();
                        }
                        int key = input.readInt();
                        Vector<Admin> admins = new Vector<Admin>();
                        con.readAdmin(admins);

                        if (prov_ad(admins, key, login, password)) {
                            System.out.println("Админ зашел");
                            flag = 1;
                            output.writeInt(flag);
                            autoris_id = key;
                            men_for_Admin(con, output, input);


                        } else {
                            System.out.println("Попытка входа");
                            output.writeInt(flag);

                        }

                    } else if (choose_rol == 2) {
                        int login_length = input.readInt();
                        System.out.println(login_length);
                        String login = "";
                        for (int i = 0; i < login_length; i++) {
                            login += input.readChar();
                        }
                        int password_length = input.readInt();
                        System.out.println(password_length);
                        String password = "";
                        for (int i = 0; i < password_length; i++) {
                            password += input.readChar();
                        }
                        int key = input.readInt();
                        Vector<User> users = new Vector<User>();
                        con.readUser(users);

                        if (prov_user(users, key, login, password)) {
                            System.out.println("Cтудент зашел");
                            flag = 1;
                            output.writeInt(flag);
                            autoris_id = key;
                            men_for_User(con, output, input);



                        } else {
                            System.out.println("Попытка входа");
                            flag = 0;
                            output.writeInt(flag);
                        }
                    } else {
                        System.out.println("Что-то пошло не так!");
                    }
                } while (true);
    }
    @Override
    public void run() {

    }
}