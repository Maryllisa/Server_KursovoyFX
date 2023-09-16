package dataBase;

import autoriz.Admin;
import autoriz.User;
import data.*;

import java.sql.*;
import java.util.Vector;

public class Conection {
    Connection dbCon;
    Statement stat = null;

    public Connection getDbCon()
            throws ClassNotFoundException, SQLException {
        Configs con = Configs.intConfig();
        String con_str = "jdbc:mysql://" + con.getDbHost() + ":"
                + con.getDbPort() + "/" + con.getDbName();
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbCon = DriverManager.getConnection(con_str, con.getDbUser(), con.getDbPass());
        return dbCon;
    }

    public void signUp(Vector<Admin> ad, int index) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.ADMIN_TABLE + " ("
                + Const.ADMIN_ID + "," + Const.ADMIN_LOGIN + "," + Const.ADMIN_PASSWORD + ") " +
                "VALUES(?,?,?)";
        System.out.println(insert);
        PreparedStatement prST = getDbCon().prepareStatement(insert);
        prST.setInt(1, ad.get(index).getKey());
        prST.setString(2, ad.get(index).getLogin());
        prST.setString(3, ad.get(index).getPassword());
        prST.execute();
    }

    public void writeInfo_Admin(Vector<Info_Admin> ad, int index) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.INFO_ADMIN_TABLE + " ("
                + Const.INFO_ADMIN_ID + "," + Const.INFO_ADMIN_SURNAME + "," + Const.INFO_ADMIN_NAME + "," +
                Const.INFO_ADMIN_PARTONYMIC + "," + Const.INFO_ADMIN_WORK + ") " +
                "VALUES(?,?,?,?,?)";
        System.out.println(insert);
        PreparedStatement prST = getDbCon().prepareStatement(insert);
        prST.setInt(1, ad.get(index).getKey());
        prST.setString(2, ad.get(index).getSurname());
        prST.setString(3, ad.get(index).getName());
        prST.setString(4, ad.get(index).getPatronymic());
        prST.setString(5, ad.get(index).getWork());
        prST.execute();
    }

    public void writeUser(Vector<User> users, int index) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.USER_TABLE + " ("
                + Const.USER_ID + "," + Const.USER_LOGIN + "," + Const.USER_PASSWORD + ") " +
                "VALUES(?,?,?)";
        System.out.println(insert);
        PreparedStatement prST = getDbCon().prepareStatement(insert);
        prST.setInt(1, users.get(index).getId_student());
        prST.setString(2, users.get(index).getLogin());
        prST.setString(3, users.get(index).getPassword());
        prST.execute();


    }

    public void writeApplication(Vector<Applications> app, int index) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.APPLICATION_TABLE + " ("
                + Const.APPLICATION_Name + "," + Const.APPLICATION_STATUS + "," + Const.APPLICATION_AMOUNT + ") " +
                "VALUES(?,?,?)";
        System.out.println(insert);
        PreparedStatement prST = getDbCon().prepareStatement(insert);
        prST.setString(1, app.get(index).getName_scholarsip());
        prST.setString(2, app.get(index).getStatus());
        prST.setFloat(3, app.get(index).getAmount());
        prST.execute();


    }

    public void writeGroup(Vector<Group> groups, int index) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.GROUP_TABLE + " ("
                + Const.GROUP_GROUP + "," + Const.GROUP_COURS + "," + Const.GROUP_FACULTY + ","
                + Const.GROUP_SPECIALITY + ") " + "VALUES(?,?,?,?)";
        System.out.println(insert);
        PreparedStatement prST = getDbCon().prepareStatement(insert);
        prST.setInt(1, groups.get(index).getNumber_group());
        prST.setInt(2, groups.get(index).getCours());
        prST.setString(3, groups.get(index).getFaculty());
        prST.setString(4, groups.get(index).getSpeciality());
        prST.execute();


    }
    public void writeRequest(Vector<Request> requests, int index) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.REQUEST_TABLE + " ("
                + Const.REQUEST_ID + "," +
                  Const.REQUEST_SCH + "," +
                  Const.REQUEST_F_SCH + "," +
                Const.REQUEST_STATUS + ") " +
                "VALUES(?,?,?,?)";
        System.out.println(insert);
        PreparedStatement prST = getDbCon().prepareStatement(insert);
        prST.setInt(1, requests.get(index).getId_student());
        prST.setFloat(2, requests.get(index).getScholarship());
        prST.setFloat(3, requests.get(index).getF_scholarship());
        prST.setString(4, requests.get(index).getStatus());
        prST.execute();


    }
    public void writeReport(Vector<Report> reports, int index) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.REPORT_TABLE + " ("
                + Const.REPORT_ID + ","
                + Const.REPORT_COL_PASSES + ","
                + Const.REPORT_RATING + ","
                + Const.REPORT_COEFFICENT + ","
                + Const.REPORT_PERS_SCHOLARSIP +
                ") " + "VALUES(?,?,?,?,?)";
        System.out.println(insert);
        if(reports.get(index).getRating()==0) {
            PreparedStatement prST = getDbCon().prepareStatement(insert);
            prST.setInt(1, reports.get(index).getId_report());
            prST.setInt(2, 0);
            prST.setFloat(3, 0);
            prST.setFloat(4, 0);
            prST.setFloat(5, 0);
            prST.execute();
        }
        else {
            PreparedStatement prST = getDbCon().prepareStatement(insert);
            prST.setInt(1, reports.get(index).getId_report());
            prST.setInt(2, reports.get(index).getCol_passes());
            prST.setFloat(3, reports.get(index).getRating());
            prST.setFloat(4, reports.get(index).getCoefficent());
            prST.setFloat(5, reports.get(index).getPerconal_schjlarsip());
            prST.execute();
        }



    }
    public void writeStudent(Vector<Student> students, int index) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.STUDENT_TABLE + " (" +
                Const.STUDENT_ID + "," +
                Const.STUDENT_SURNAME + "," +
                Const.STUDENT_NAME + "," +
                Const.STUDENT_PARTONYMIC + "," +
                Const.STUDENT_ID_GROUP + "," +
                Const.STUDENT_ID_APPLICATION + "," +
                Const.STUDENT_ID_REPORT + "," +
                Const.STUDENT_DAY + "," +
                Const.STUDENT_MONTHE + "," +
                Const.STUDENT_YEAR + ")" +
                " VALUES(?,?,?,?,?,?,?,?,?,?)";
        System.out.println(insert);
        PreparedStatement prST = getDbCon().prepareStatement(insert);
        prST.setInt(1, students.get(index).getId_student());
        prST.setString(2, students.get(index).getSurname());
        prST.setString(3, students.get(index).getName());
        prST.setString(4, students.get(index).getPatronymic());
        prST.setInt(5, students.get(index).getId_group());
        prST.setString(6, students.get(index).getId_applications());
        prST.setInt(7, students.get(index).getId_report());
        prST.setInt(8, students.get(index).getDay());
        prST.setInt(9, students.get(index).getMonthe());
        prST.setInt(10, students.get(index).getYear());
        prST.execute();


    }

    public void readAdmin(Vector<Admin> admin) {
        Statement stat = null;
        String select = "SELECT * FROM " + Const.ADMIN_TABLE;
        try {
            stat = dbCon.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            ResultSet res = stat.executeQuery(select);
            while (res.next()) {
                int id = res.getInt(1);
                String Login = res.getString(2);
                String Password = res.getString(3);
                Admin ad = new Admin();
                ad.setKey(id);
                ad.setLogin(Login);
                ad.setPassword(Password);
                admin.add(ad);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void readUser(Vector<User> users) {
        Statement stat = null;

        String select = "SELECT * FROM " + Const.USER_TABLE;
        try {
            stat = dbCon.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            ResultSet res = stat.executeQuery(select);
            while (res.next()) {
                int id = res.getInt(1);
                String Login = res.getString(2);
                String Password = res.getString(3);
                User us = new User();
                us.setId_student(id);
                us.setLogin(Login);
                us.setPassword(Password);
                users.add(us);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void readInfo_Admin(Vector<Info_Admin> info_admins) {
        Statement stat = null;

        String select = "SELECT * FROM " + Const.INFO_ADMIN_TABLE;
        try {
            stat = dbCon.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            ResultSet res = stat.executeQuery(select);
            while (res.next()) {
                int id = res.getInt(1);
                String Surname = res.getString(2);
                String Name = res.getString(3);
                String Patronymic = res.getString(4);
                String Work = res.getString(5);
                Info_Admin info_admin = new Info_Admin();
                info_admin.setKey(id);
                info_admin.setSurname(Surname);
                info_admin.setName(Name);
                info_admin.setPatronymic(Patronymic);
                info_admin.setWork(Work);
                info_admins.add(info_admin);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void readApplication(Vector<Applications> apl) {
        Statement stat = null;

        String select = "SELECT * FROM " + Const.APPLICATION_TABLE;
        try {
            stat = dbCon.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            ResultSet res = stat.executeQuery(select);
            while (res.next()) {
                String name_scholarsip = res.getString(1);
                ;
                String status = res.getString(2);
                float amount = res.getFloat(3);
                Applications applications = new Applications();
                applications.setName_scholarsip(name_scholarsip);
                applications.setStatus(status);
                applications.setAmount(amount);
                apl.add(applications);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void readGroup(Vector<Group> group) {
        Statement stat = null;

        String select = "SELECT * FROM " + Const.GROUP_TABLE;
        try {
            stat = dbCon.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            ResultSet res = stat.executeQuery(select);
            while (res.next()) {
                int number_group = res.getInt(1);
                int cours = res.getInt(2);
                String faculty = res.getString(3);
                String speciality = res.getString(4);
                Group gr = new Group();
                gr.setNumber_group(number_group);
                gr.setCours(cours);
                gr.setFaculty(faculty);
                gr.setSpeciality(speciality);
                group.add(gr);


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void readReport(Vector<Report> reports) {
        Statement stat = null;

        String select = "SELECT * FROM " + Const.REPORT_TABLE;
        try {
            stat = dbCon.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            ResultSet res = stat.executeQuery(select);
            while (res.next()) {
                int id_report = res.getInt(1);
                int col_passes = res.getInt(2);
                float rating = res.getFloat(3);
                float coefficent = res.getFloat(4);
                float perconal_schjlarsip = res.getFloat(5);
                Report rep = new Report();
                rep.setId_report(id_report);
                rep.setCol_passes(col_passes);
                rep.setRating(rating);
                rep.setCoefficent(coefficent);
                rep.setPerconal_schjlarsip(perconal_schjlarsip);
                reports.add(rep);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void readRequst(Vector<Request> requests) {
        Statement stat = null;

        String select = "SELECT * FROM " + Const.REQUEST_TABLE;
        try {
            stat = dbCon.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            ResultSet res = stat.executeQuery(select);
            while (res.next()) {
                int id_student = res.getInt(1);
                float scholarship = res.getFloat(2);
                float f_scholarship = res.getFloat(3);
                String status = res.getString(4);
                Request ress = new Request();
                ress.setId_student(id_student);
                ress.setScholarship(scholarship);
                ress.setF_scholarship(f_scholarship);
                ress.setStatus(status);
                requests.add(ress);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void readStudent(Vector<Student> students) {
        Statement stat = null;

        String select = "SELECT * FROM " + Const.STUDENT_TABLE;
        try {
            stat = dbCon.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            ResultSet res = stat.executeQuery(select);
            while (res.next()) {
                int id_student = res.getInt(1);
                String surname = res.getString(2);
                String name = res.getString(3);
                String patronymic = res.getString(4);
                int id_group = res.getInt(5);
                String id_applications = res.getString(6);
                int id_report = res.getInt(7);
                int day = res.getInt(8);
                int month = res.getInt(9);
                int year = res.getInt(10);
                Student st = new Student();
                st.setId_student(id_student);
                st.setSurname(surname);
                st.setName(name);
                st.setPatronymic(patronymic);
                st.setId_group(id_group);
                st.setId_applications(id_applications);
                st.setId_report(id_report);
                st.setDay(day);
                st.setMonthe(month);
                st.setYear(year);
                students.add(st);


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteStudent(int id, int report) {
        Statement stat = null;

        String delete = "DELETE FROM " + Const.STUDENT_TABLE + " WHERE " + Const.STUDENT_ID + "=?";
        try {
            stat = dbCon.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            PreparedStatement prST = getDbCon().prepareStatement(delete);
            prST.setInt(1, id);
            prST.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String delete2 = "DELETE FROM " + Const.USER_TABLE + " WHERE " + Const.USER_ID + "=?";

        try {
            PreparedStatement prST = getDbCon().prepareStatement(delete2);
            prST.setInt(1, id);
            prST.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String delete3 = "DELETE FROM " + Const.REPORT_TABLE + " WHERE " + Const.REPORT_ID + "=?";

        try {
            PreparedStatement prST = getDbCon().prepareStatement(delete3);
            prST.setInt(1, report);
            prST.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return true;
    }
    public void deleteAdmin(int id) {
        Statement stat = null;

        String delete = "DELETE FROM " + Const.INFO_ADMIN_TABLE + " WHERE " + Const.INFO_ADMIN_ID + "=?";
        try {
            stat = dbCon.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            PreparedStatement prST = getDbCon().prepareStatement(delete);
            prST.setInt(1, id);
            prST.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String delete2 = "DELETE FROM " + Const.ADMIN_TABLE + " WHERE " + Const.ADMIN_ID + "=?";

        try {
            PreparedStatement prST = getDbCon().prepareStatement(delete2);
            prST.setInt(1, id);
            prST.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
    public boolean deleteRequest(int id) {
        Statement stat = null;

        String delete = "DELETE FROM " + Const.REQUEST_TABLE + " WHERE " + Const.REQUEST_ID + "=?";
        try {
            stat = dbCon.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            PreparedStatement prST = getDbCon().prepareStatement(delete);
            prST.setInt(1, id);
            prST.execute();
            return true;
        } catch (SQLException e) {
            return false;
        } catch (ClassNotFoundException e) {
            return false;
        }

    }

    public boolean changeRequest(Request request) {
        Statement stat = null;

        String change = "UPDATE " + Const.REQUEST_TABLE + " SET " + Const.REQUEST_STATUS + "=? WHERE " + Const.REQUEST_ID + "=" + request.getId_student();
        try {
            stat = dbCon.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            PreparedStatement prST = getDbCon().prepareStatement(change);
            prST.setString(1, request.getStatus());
            prST.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public boolean changeLoginStudent(int id, String login) {
        Statement stat = null;

        String change = "UPDATE " + Const.USER_TABLE + " SET " + Const.USER_LOGIN + "=? WHERE " + Const.USER_ID + "=" + id;
        try {
            stat = dbCon.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            PreparedStatement prST = getDbCon().prepareStatement(change);
            prST.setString(1, login);
            prST.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
    public boolean changePasswordStudent(int id, String password) {
        Statement stat = null;

        String change = "UPDATE " + Const.USER_TABLE + " SET " + Const.USER_PASSWORD + "=? WHERE " + Const.USER_ID + "=" + id;
        try {
            stat = dbCon.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            PreparedStatement prST = getDbCon().prepareStatement(change);
            prST.setString(1, password);
            prST.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
    public void changeLiginAdmin(int id, String login) {
        Statement stat = null;

        String change = "UPDATE " + Const.ADMIN_TABLE + " SET " + Const.ADMIN_LOGIN + "=? WHERE " + Const.ADMIN_ID + "=" + id;
        try {
            stat = dbCon.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            PreparedStatement prST = getDbCon().prepareStatement(change);
            prST.setString(1, login);
            prST.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public void changePasswordAdmin(int id, String password) {
        Statement stat = null;

        String change = "UPDATE " + Const.ADMIN_TABLE + " SET " + Const.ADMIN_PASSWORD + "=? WHERE " + Const.ADMIN_ID + "=" + id;
        try {
            stat = dbCon.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            PreparedStatement prST = getDbCon().prepareStatement(change);
            prST.setString(1, password);
            prST.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public void changeFIOAdmin(int id, String surname, String name, String patronymic) {
        Statement stat = null;

        String change = "UPDATE " + Const.INFO_ADMIN_TABLE + " SET "
                + Const.INFO_ADMIN_SURNAME + "=?, "
                + Const.INFO_ADMIN_NAME + "=?, "
                + Const.INFO_ADMIN_PARTONYMIC + "=? "
                + "WHERE " + Const.INFO_ADMIN_ID + "=" + id;
        System.out.println(change);
        try {
            stat = dbCon.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            PreparedStatement prST = getDbCon().prepareStatement(change);
            prST.setString(1, surname);
            prST.setString(2, name);
            prST.setString(3, patronymic);
            prST.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public void changeWorkAdmin(int id, String work) {
        Statement stat = null;

        String change = "UPDATE " + Const.INFO_ADMIN_TABLE + " SET " + Const.INFO_ADMIN_WORK + "=? WHERE " + Const.INFO_ADMIN_ID + "=" + id;
        try {
            stat = dbCon.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            PreparedStatement prST = getDbCon().prepareStatement(change);
            prST.setString(1, work);
            prST.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public boolean changeApplicationStudent(int id, String application) {
        Statement stat = null;

        String change = "UPDATE " + Const.STUDENT_TABLE + " SET "
                + Const.STUDENT_ID_APPLICATION + "=? "
                + "WHERE " + Const.STUDENT_ID + "=" + id;
        try {
            stat = dbCon.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            PreparedStatement prST = getDbCon().prepareStatement(change);
            prST.setString(1, application);
            prST.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
    public void changeReport(Report report)
    {
        Statement stat = null;

        String change = "UPDATE " + Const.REPORT_TABLE + " SET "
                + Const.REPORT_COL_PASSES + "=?, "
                + Const.REPORT_RATING + "=?, "
                + Const.REPORT_COEFFICENT + "=?, "
                + Const.REPORT_PERS_SCHOLARSIP + "=? "
                + "WHERE " + Const.REPORT_ID + "=" + report.getId_report();
        try {
            stat = dbCon.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            PreparedStatement prST = getDbCon().prepareStatement(change);
            prST.setInt(1, report.getCol_passes());
            prST.setFloat(2, report.getRating());
            prST.setFloat(3, report.getCoefficent());
            prST.setFloat(4, report.getPerconal_schjlarsip());
            prST.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean changeFIOStudent(int id, String surname, String name, String patronymic) {
        Statement stat = null;

        String change = "UPDATE " + Const.STUDENT_TABLE + " SET "
                + Const.STUDENT_SURNAME + "=?, "
                + Const.STUDENT_NAME + "=?, "
                + Const.STUDENT_PARTONYMIC + "=? "
                + "WHERE " + Const.STUDENT_ID + "=" + id;
        System.out.println(change);
        try {
            stat = dbCon.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            PreparedStatement prST = getDbCon().prepareStatement(change);
            prST.setString(1, surname);
            prST.setString(2, name);
            prST.setString(3, patronymic);
            prST.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
    public boolean changeAgeStudent(int id, int day, int monthe, int year) {
        Statement stat = null;

        String change = "UPDATE " + Const.STUDENT_TABLE + " SET "
                + Const.STUDENT_DAY+ "=?, "
                + Const.STUDENT_MONTHE + "=?, "
                + Const.STUDENT_YEAR + "=? "
                + "WHERE " + Const.STUDENT_ID + "=" + id;
        try {
            stat = dbCon.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            PreparedStatement prST = getDbCon().prepareStatement(change);
            prST.setInt(1, day);
            prST.setInt(2, monthe);
            prST.setInt(3, year);
            prST.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}

