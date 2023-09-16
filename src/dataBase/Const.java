package dataBase;

public class Const {

    //Admin
    public static final String ADMIN_TABLE = "`admin`";
    public static final String ADMIN_ID="`Key`";
    public static final String ADMIN_LOGIN = "`Login`";
    public static final String ADMIN_PASSWORD ="`Password`";

    //User
    public static final String USER_TABLE = "`user`";
    public static final String USER_ID="`ID_client`";
    public static final String USER_LOGIN = "`Login`";
    public static final String USER_PASSWORD ="`Password`";

    //Application
    public static final String APPLICATION_TABLE = "`applications`";
    public static final String APPLICATION_Name="`Name_scholarsip`";
    public static final String APPLICATION_STATUS="`Status`";
    public static final String APPLICATION_AMOUNT = "`Amount`";

    //Group
    public static final String GROUP_TABLE = "`group`";
    public static final String GROUP_GROUP="`Number_group`";
    public static final String GROUP_COURS = "`Cours`";
    public static final String GROUP_FACULTY ="`Faculty`";
    public static final String GROUP_SPECIALITY ="`Speciality`";

    //report
    public static final String REPORT_TABLE = "`report`";
    public static final String REPORT_ID="`ID_report`";
    public static final String REPORT_COL_PASSES= "`col_passes`";
    public static final String REPORT_RATING ="`rating`";
    public static final String REPORT_COEFFICENT = "`coefficent`";
    public static final String REPORT_PERS_SCHOLARSIP ="`personal_scholarsip`";

    //request
    public static final String REQUEST_TABLE = "`request`";
    public static final String REQUEST_ID="`ID_client`";
    public static final String REQUEST_SCH= "`scholarship`";
    public static final String REQUEST_F_SCH ="`f_scholorship`";
    public static final String REQUEST_STATUS ="`Status`";

    //student
    public static final String STUDENT_TABLE = "`student`";
    public static final String STUDENT_ID="`idStudent`";
    public static final String STUDENT_SURNAME= "`Surname`";
    public static final String STUDENT_NAME ="`Name`";
    public static final String STUDENT_PARTONYMIC ="`Patronymic`";
    public static final String STUDENT_ID_GROUP= "`ID_group`";
    public static final String STUDENT_ID_APPLICATION ="`ID_applications`";
    public static final String STUDENT_ID_REPORT ="`ID_report`";
    public static final String STUDENT_DAY ="`day`";
    public static final String STUDENT_MONTHE ="`month`";
    public static final String STUDENT_YEAR ="`year`";
    //student
    public static final String INFO_ADMIN_TABLE = "`info_admin`";
    public static final String INFO_ADMIN_ID="`idStudent`";
    public static final String INFO_ADMIN_SURNAME= "`surname`";
    public static final String INFO_ADMIN_NAME ="`name`";
    public static final String INFO_ADMIN_PARTONYMIC ="`paronymic`";
    public static final String INFO_ADMIN_WORK="`workk`";


}
