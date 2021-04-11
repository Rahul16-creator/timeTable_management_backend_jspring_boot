package com.time_table_management_system.time_table_management_system.service.serviceImpl;

import com.time_table_management_system.time_table_management_system.RequestModel.TimeTableCreation;
import com.time_table_management_system.time_table_management_system.entity.*;
import com.time_table_management_system.time_table_management_system.repository.ClassTimeTableRepository;
import com.time_table_management_system.time_table_management_system.repository.CourseRepository;
import com.time_table_management_system.time_table_management_system.repository.FacultyRepository;
import com.time_table_management_system.time_table_management_system.repository.FacultyTimeTableRepository;
import com.time_table_management_system.time_table_management_system.service.TimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.security.auth.Subject;

@Service
public class TimeTableServiceImpl implements TimeTableService {

    @Autowired
    private FacultyTimeTableRepository facultyTimeTableRepository;

    @Autowired
    private ClassTimeTableRepository classTimeTableRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public void createTimeTable(TimeTableCreation data) throws Exception {

        boolean timeTableRes = generateClassTimeTable(data);

        if (!timeTableRes) {
            throw new Exception("Error in creating Class time table");
        }

        int subCount = data.getNoOfSub();
        int eachSubCount = (int) (54 / subCount);

        String emails[] = new String[6];
        emails[0] = data.getFaculty1Email();
        emails[1] = data.getFaculty2Email();
        emails[2] = data.getFaculty3Email();
        emails[3] = data.getFaculty4Email();
        emails[4] = data.getFaculty5Email();
        emails[5] = data.getFaculty6Email();

        String subjects[] = new String[6];
        subjects[0] = data.getSubject1Code();
        subjects[1] = data.getSubject2Code();
        subjects[2] = data.getSubject3Code();
        subjects[3] = data.getSubject4Code();
        subjects[4] = data.getSubject5Code();
        subjects[5] = data.getSubject6Code();

        Set<String> s1 = new HashSet<>();

        for (int i = 0; i < subCount; i++) {

            for (int j = 0; j < eachSubCount; j++) {
                int randomDay = pickRandomDay();
                int randomSlot = pickRandomSlot();
                int max = randomDay * 9;
                int min = max - 8;
                int slot = randomSlot + min;

                String slotNum = "s" + Integer.toString(slot);

                if (!s1.contains(slotNum)) {
                    boolean check = checkingFacultySlotAvailability(randomDay, randomSlot, emails[i]);
                    if (!check) {
                        j--;
                    } else {
                        createFacultyTimeTable(randomDay, randomSlot, emails[i], data.getClassName(), subjects[i]);
                        s1.add(slotNum);
                    }
                } else {
                   
                }
            }
        }

        List<String> l1 = checkingFullClassAvail(data.getClassName());

        System.out.println(l1);

        if (l1.size() > 0) {
            fillRemainSpace(l1, data, emails,subjects);
        }
    }

    @Override
    public ClassTimeTable getTimeTable(String code) throws Exception {
        ClassTimeTable res = classTimeTableRepository.findByCode(code);
        if (res == null) {
            throw new Exception("Time table for this class is not generated");
        }

        return res;
    }

    public int pickRandomDay() {
        Random rn = new Random();
        int day = rn.nextInt(6 - 1) + 1;
        return day;
    }

    public int pickRandomSlot() {
        Random rn = new Random();
        int slot = rn.nextInt(9 - 1) + 1;
        return slot;
    }



    public boolean checkingFacultySlotAvailability(int day, int slot, String email) throws Exception {
        int max = day * 9;
        int min = max - 8;
        slot = slot + min;

        String slotNum = "s" + Integer.toString(slot);
        FacultyTimeTable res = facultyTimeTableRepository.findByEmail(email);

        if (res == null) {
            throw new Exception("CheckingSlotAvailability null" + email);
        }
        // 1-10
        if (slotNum.equals("s1") && res.getS1() != null) {
            return false;
        } else if (slotNum.equals("s2") && res.getS2() != null) {
            return false;
        } else if (slotNum.equals("s3") && res.getS3() != null) {
            return false;
        } else if (slotNum.equals("s4") && res.getS4() != null) {
            return false;
        } else if (slotNum.equals("s5") && res.getS5() != null) {
            return false;
        } else if (slotNum.equals("s6") && res.getS6() != null) {
            return false;
        } else if (slotNum.equals("s7") && res.getS7() != null) {
            return false;
        } else if (slotNum.equals("s8") && res.getS8() != null) {
            return false;
        } else if (slotNum.equals("s9") && res.getS9() != null) {
            return false;
        } else if (slotNum.equals("s10") && res.getS10() != null) {
            return false;
        }

        // 11-20

        if (slotNum.equals("s11") && res.getS11() != null) {
            return false;
        } else if (slotNum.equals("s12") && res.getS12() != null) {
            return false;
        } else if (slotNum.equals("s13") && res.getS13() != null) {
            return false;
        } else if (slotNum.equals("s14") && res.getS14() != null) {
            return false;
        } else if (slotNum.equals("s15") && res.getS15() != null) {
            return false;
        } else if (slotNum.equals("s16") && res.getS16() != null) {
            return false;
        } else if (slotNum.equals("s17") && res.getS17() != null) {
            return false;
        } else if (slotNum.equals("s18") && res.getS18() != null) {
            return false;
        } else if (slotNum.equals("s19") && res.getS19() != null) {
            return false;
        } else if (slotNum.equals("s20") && res.getS20() != null) {
            return false;
        }

        // 21-30

        if (slotNum.equals("s21") && res.getS21() != null) {
            return false;
        } else if (slotNum.equals("s22") && res.getS22() != null) {
            return false;
        } else if (slotNum.equals("s23") && res.getS23() != null) {
            return false;
        } else if (slotNum.equals("s24") && res.getS24() != null) {
            return false;
        } else if (slotNum.equals("s25") && res.getS25() != null) {
            return false;
        } else if (slotNum.equals("s26") && res.getS26() != null) {
            return false;
        } else if (slotNum.equals("s27") && res.getS27() != null) {
            return false;
        } else if (slotNum.equals("s28") && res.getS28() != null) {
            return false;
        } else if (slotNum.equals("s29") && res.getS29() != null) {
            return false;
        } else if (slotNum.equals("s30") && res.getS30() != null) {
            return false;
        }

        // 31-40

        if (slotNum.equals("s31") && res.getS31() != null) {
            return false;
        } else if (slotNum.equals("s32") && res.getS32() != null) {
            return false;
        } else if (slotNum.equals("s33") && res.getS33() != null) {
            return false;
        } else if (slotNum.equals("s34") && res.getS34() != null) {
            return false;
        } else if (slotNum.equals("s35") && res.getS35() != null) {
            return false;
        } else if (slotNum.equals("s36") && res.getS36() != null) {
            return false;
        } else if (slotNum.equals("s37") && res.getS37() != null) {
            return false;
        } else if (slotNum.equals("s38") && res.getS38() != null) {
            return false;
        } else if (slotNum.equals("s39") && res.getS39() != null) {
            return false;
        } else if (slotNum.equals("s40") && res.getS40() != null) {
            return false;
        }
        // 41-50

        if (slotNum.equals("s41") && res.getS41() != null) {
            return false;
        } else if (slotNum.equals("s42") && res.getS42() != null) {
            return false;
        } else if (slotNum.equals("s43") && res.getS43() != null) {
            return false;
        } else if (slotNum.equals("s44") && res.getS44() != null) {
            return false;
        } else if (slotNum.equals("s45") && res.getS45() != null) {
            return false;
        } else if (slotNum.equals("s46") && res.getS46() != null) {
            return false;
        } else if (slotNum.equals("s47") && res.getS47() != null) {
            return false;
        } else if (slotNum.equals("s48") && res.getS48() != null) {
            return false;
        } else if (slotNum.equals("s49") && res.getS49() != null) {
            return false;
        } else if (slotNum.equals("s50") && res.getS50() != null) {
            return false;
        }
        // 51-54

        else if (slotNum.equals("s51") && res.getS51() != null) {
            return false;
        } else if (slotNum.equals("s53") && res.getS52() != null) {
            return false;
        } else if (slotNum.equals("s53") && res.getS53() != null) {
            return false;
        } else if (slotNum.equals("s54") && res.getS54() != null) {
            return false;
        }
        return true;
    }



    public String createFacultyTimeTable(int day, int slot, String email, String className, String subjectCode)
            throws Exception {
        int max = day * 9;
        int min = max - 8;
        slot = slot + min;

        String slotNum = "s" + Integer.toString(slot);

        // Faculty table Model

        FacultyTimeTable res = facultyTimeTableRepository.findByEmail(email);
        Course cou_res = courseRepository.findByCode(subjectCode);
        FacultySlot dataModel = new FacultySlot();
        dataModel.setClassName(className);
        dataModel.setCourse(cou_res);

        // Class Table Model

        ClassTimeTable classTimeTable = classTimeTableRepository.findByCode(className);
        Faculty faculty = facultyRepository.findByEmail(email);
        ClassSlot classSlot = new ClassSlot();
        classSlot.setCourse(cou_res);
        classSlot.setFaculty(faculty);

        // 1-10
        if (slotNum.equals("s1")) {
            res.setS1(dataModel);
            classTimeTable.setS1(classSlot);

        } else if (slotNum.equals("s2")) {
            res.setS2(dataModel);
            classTimeTable.setS2(classSlot);
        } else if (slotNum.equals("s3")) {
            res.setS3(dataModel);
            classTimeTable.setS3(classSlot);

        } else if (slotNum.equals("s4")) {
            res.setS4(dataModel);
            classTimeTable.setS4(classSlot);

        } else if (slotNum.equals("s5")) {
            res.setS5(dataModel);

            classTimeTable.setS5(classSlot);

        } else if (slotNum.equals("s6")) {
            res.setS6(dataModel);
            classTimeTable.setS6(classSlot);

        } else if (slotNum.equals("s7")) {
            res.setS7(dataModel);
            classTimeTable.setS7(classSlot);

        } else if (slotNum.equals("s8")) {
            res.setS8(dataModel);

            classTimeTable.setS8(classSlot);

        } else if (slotNum.equals("s9")) {
            res.setS9(dataModel);
            classTimeTable.setS9(classSlot);

        } else if (slotNum.equals("s10")) {
            res.setS10(dataModel);
            classTimeTable.setS10(classSlot);

        }

        // 11-20

        if (slotNum.equals("s11")) {
            res.setS11(dataModel);

            classTimeTable.setS11(classSlot);

        } else if (slotNum.equals("s12")) {
            res.setS12(dataModel);

            classTimeTable.setS12(classSlot);

        } else if (slotNum.equals("s13")) {
            res.setS13(dataModel);
            classTimeTable.setS13(classSlot);

        } else if (slotNum.equals("s14")) {
            res.setS14(dataModel);

            classTimeTable.setS14(classSlot);

        } else if (slotNum.equals("s15")) {
            res.setS15(dataModel);
            classTimeTable.setS15(classSlot);

        } else if (slotNum.equals("s16")) {
            res.setS16(dataModel);

            classTimeTable.setS16(classSlot);

        } else if (slotNum.equals("s17")) {
            res.setS17(dataModel);

            classTimeTable.setS17(classSlot);

        } else if (slotNum.equals("s18")) {
            res.setS18(dataModel);
            classTimeTable.setS18(classSlot);

        } else if (slotNum.equals("s19")) {
            res.setS19(dataModel);

            classTimeTable.setS19(classSlot);

        } else if (slotNum.equals("s20")) {
            res.setS20(dataModel);
            classTimeTable.setS20(classSlot);

        }

        // 21-30

        if (slotNum.equals("s21")) {
            res.setS21(dataModel);

            classTimeTable.setS21(classSlot);

        } else if (slotNum.equals("s22")) {
            res.setS22(dataModel);

            classTimeTable.setS22(classSlot);

        } else if (slotNum.equals("s23")) {
            res.setS23(dataModel);

            classTimeTable.setS23(classSlot);

        } else if (slotNum.equals("s24")) {
            res.setS24(dataModel);

            classTimeTable.setS24(classSlot);

        } else if (slotNum.equals("s25")) {
            res.setS25(dataModel);

            classTimeTable.setS25(classSlot);

        } else if (slotNum.equals("s26")) {
            res.setS26(dataModel);

            classTimeTable.setS26(classSlot);

        } else if (slotNum.equals("s27")) {
            res.setS27(dataModel);
            classTimeTable.setS27(classSlot);

        } else if (slotNum.equals("s28")) {
            res.setS28(dataModel);

            classTimeTable.setS28(classSlot);

        } else if (slotNum.equals("s29")) {
            res.setS29(dataModel);

            classTimeTable.setS29(classSlot);

        } else if (slotNum.equals("s30")) {
            res.setS30(dataModel);
            classTimeTable.setS30(classSlot);

        }

        // 31-40

        if (slotNum.equals("s31")) {
            res.setS31(dataModel);

            classTimeTable.setS31(classSlot);

        } else if (slotNum.equals("s32")) {
            res.setS32(dataModel);

            classTimeTable.setS32(classSlot);

        } else if (slotNum.equals("s33")) {
            res.setS33(dataModel);

            classTimeTable.setS33(classSlot);

        } else if (slotNum.equals("s34")) {
            res.setS34(dataModel);

            classTimeTable.setS34(classSlot);

        } else if (slotNum.equals("s35")) {
            res.setS35(dataModel);

            classTimeTable.setS35(classSlot);

        } else if (slotNum.equals("s36")) {
            res.setS36(dataModel);

            classTimeTable.setS36(classSlot);

        } else if (slotNum.equals("s37")) {
            res.setS37(dataModel);

            classTimeTable.setS37(classSlot);

        } else if (slotNum.equals("s38")) {
            res.setS38(dataModel);

            classTimeTable.setS38(classSlot);

        } else if (slotNum.equals("s39")) {
            res.setS39(dataModel);

            classTimeTable.setS39(classSlot);

        } else if (slotNum.equals("s40")) {
            res.setS40(dataModel);

            classTimeTable.setS40(classSlot);

        }
        // 41-50

        if (slotNum.equals("s41")) {
            res.setS41(dataModel);

            classTimeTable.setS41(classSlot);

        } else if (slotNum.equals("s42")) {
            res.setS42(dataModel);
            classTimeTable.setS42(classSlot);

        } else if (slotNum.equals("s43")) {
            res.setS43(dataModel);

            classTimeTable.setS43(classSlot);

        } else if (slotNum.equals("s44")) {
            res.setS44(dataModel);

            classTimeTable.setS44(classSlot);

        } else if (slotNum.equals("s45")) {
            res.setS45(dataModel);

            classTimeTable.setS45(classSlot);

        } else if (slotNum.equals("s46")) {
            res.setS46(dataModel);

            classTimeTable.setS46(classSlot);

        } else if (slotNum.equals("s47")) {
            res.setS47(dataModel);

            classTimeTable.setS47(classSlot);

        } else if (slotNum.equals("s48")) {
            res.setS48(dataModel);

            classTimeTable.setS48(classSlot);

        } else if (slotNum.equals("s49")) {
            res.setS49(dataModel);

            classTimeTable.setS49(classSlot);

        } else if (slotNum.equals("s50")) {
            res.setS50(dataModel);

            classTimeTable.setS50(classSlot);

        }
        // 51-54

        else if (slotNum.equals("s51")) {
            res.setS51(dataModel);

            classTimeTable.setS51(classSlot);

        } else if (slotNum.equals("s53")) {
            res.setS52(dataModel);

            classTimeTable.setS52(classSlot);

        } else if (slotNum.equals("s53")) {
            res.setS53(dataModel);

            classTimeTable.setS53(classSlot);

        } else if (slotNum.equals("s54")) {
            res.setS54(dataModel);

            classTimeTable.setS54(classSlot);

        }

        facultyTimeTableRepository.save(res);
        classTimeTableRepository.save(classTimeTable);

        return slotNum;
    }



    public boolean generateClassTimeTable(TimeTableCreation data) {

        try {
            ClassTimeTable timeTable = new ClassTimeTable();
            timeTable.setCode(data.getClassName());
            timeTable.setClassName(data.getClassName());
            classTimeTableRepository.save(timeTable);
        } catch (Exception ex) {
            return false;
        }
        return true;

    }


    public boolean checkingClassSlotAvailability(String className, String slotNum) throws Exception {
        ClassTimeTable res = classTimeTableRepository.findByCode(className);
        if (res == null) {
            throw new Exception("CheckingSlotAvailability null" + className);
        }
        // 1-10
        if (slotNum.equals("s1") && res.getS1() != null) {
            return false;
        } else if (slotNum.equals("s2") && res.getS2() != null) {
            return false;
        } else if (slotNum.equals("s3") && res.getS3() != null) {
            return false;
        } else if (slotNum.equals("s4") && res.getS4() != null) {
            return false;
        } else if (slotNum.equals("s5") && res.getS5() != null) {
            return false;
        } else if (slotNum.equals("s6") && res.getS6() != null) {
            return false;
        } else if (slotNum.equals("s7") && res.getS7() != null) {
            return false;
        } else if (slotNum.equals("s8") && res.getS8() != null) {
            return false;
        } else if (slotNum.equals("s9") && res.getS9() != null) {
            return false;
        } else if (slotNum.equals("s10") && res.getS10() != null) {
            return false;
        }

        // 11-20

        if (slotNum.equals("s11") && res.getS11() != null) {
            return false;
        } else if (slotNum.equals("s12") && res.getS12() != null) {
            return false;
        } else if (slotNum.equals("s13") && res.getS13() != null) {
            return false;
        } else if (slotNum.equals("s14") && res.getS14() != null) {
            return false;
        } else if (slotNum.equals("s15") && res.getS15() != null) {
            return false;
        } else if (slotNum.equals("s16") && res.getS16() != null) {
            return false;
        } else if (slotNum.equals("s17") && res.getS17() != null) {
            return false;
        } else if (slotNum.equals("s18") && res.getS18() != null) {
            return false;
        } else if (slotNum.equals("s19") && res.getS19() != null) {
            return false;
        } else if (slotNum.equals("s20") && res.getS20() != null) {
            return false;
        }

        // 21-30

        if (slotNum.equals("s21") && res.getS21() != null) {
            return false;
        } else if (slotNum.equals("s22") && res.getS22() != null) {
            return false;
        } else if (slotNum.equals("s23") && res.getS23() != null) {
            return false;
        } else if (slotNum.equals("s24") && res.getS24() != null) {
            return false;
        } else if (slotNum.equals("s25") && res.getS25() != null) {
            return false;
        } else if (slotNum.equals("s26") && res.getS26() != null) {
            return false;
        } else if (slotNum.equals("s27") && res.getS27() != null) {
            return false;
        } else if (slotNum.equals("s28") && res.getS28() != null) {
            return false;
        } else if (slotNum.equals("s29") && res.getS29() != null) {
            return false;
        } else if (slotNum.equals("s30") && res.getS30() != null) {
            return false;
        }

        // 31-40

        if (slotNum.equals("s31") && res.getS31() != null) {
            return false;
        } else if (slotNum.equals("s32") && res.getS32() != null) {
            return false;
        } else if (slotNum.equals("s33") && res.getS33() != null) {
            return false;
        } else if (slotNum.equals("s34") && res.getS34() != null) {
            return false;
        } else if (slotNum.equals("s35") && res.getS35() != null) {
            return false;
        } else if (slotNum.equals("s36") && res.getS36() != null) {
            return false;
        } else if (slotNum.equals("s37") && res.getS37() != null) {
            return false;
        } else if (slotNum.equals("s38") && res.getS38() != null) {
            return false;
        } else if (slotNum.equals("s39") && res.getS39() != null) {
            return false;
        } else if (slotNum.equals("s40") && res.getS40() != null) {
            return false;
        }
        // 41-50

        if (slotNum.equals("s41") && res.getS41() != null) {
            return false;
        } else if (slotNum.equals("s42") && res.getS42() != null) {
            return false;
        } else if (slotNum.equals("s43") && res.getS43() != null) {
            return false;
        } else if (slotNum.equals("s44") && res.getS44() != null) {
            return false;
        } else if (slotNum.equals("s45") && res.getS45() != null) {
            return false;
        } else if (slotNum.equals("s46") && res.getS46() != null) {
            return false;
        } else if (slotNum.equals("s47") && res.getS47() != null) {
            return false;
        } else if (slotNum.equals("s48") && res.getS48() != null) {
            return false;
        } else if (slotNum.equals("s49") && res.getS49() != null) {
            return false;
        } else if (slotNum.equals("s50") && res.getS50() != null) {
            return false;
        }
        // 51-54

        else if (slotNum.equals("s51") && res.getS51() != null) {
            return false;
        } else if (slotNum.equals("s53") && res.getS52() != null) {
            return false;
        } else if (slotNum.equals("s53") && res.getS53() != null) {
            return false;
        } else if (slotNum.equals("s54") && res.getS54() != null) {
            return false;
        }
        return true;
    }



    public List<String> checkingFullClassAvail(String className) throws Exception {

        List<String> l1 = new ArrayList<>();

        for (int i = 0; i < 54; i++) {

            String slotNum = "s" + Integer.toString(i + 1);
            ClassTimeTable res = classTimeTableRepository.findByCode(className);

           

            if (slotNum.equals("s1") && res.getS1() != null) {
                l1.add("s1");
            } else if (slotNum.equals("s2") && res.getS2() != null) {
                l1.add("s2");

            } else if (slotNum.equals("s3") && res.getS3() != null) {
                l1.add("s3");

            } else if (slotNum.equals("s4") && res.getS4() != null) {
                l1.add("s4");

            } else if (slotNum.equals("s5") && res.getS5() != null) {
                l1.add("s5");

            } else if (slotNum.equals("s6") && res.getS6() != null) {
                l1.add("s6");

            } else if (slotNum.equals("s7") && res.getS7() != null) {
                l1.add("s7");

            } else if (slotNum.equals("s8") && res.getS8() != null) {
                l1.add("s8");

            } else if (slotNum.equals("s9") && res.getS9() != null) {
                l1.add("s9");

            } else if (slotNum.equals("s10") && res.getS10() != null) {
                l1.add("s10");

            }

            // 11-20

            if (slotNum.equals("s11") && res.getS11() != null) {
                l1.add("s11");

            } else if (slotNum.equals("s12") && res.getS12() != null) {
                l1.add("s12");

            } else if (slotNum.equals("s13") && res.getS13() != null) {
                l1.add("s13");

            } else if (slotNum.equals("s14") && res.getS14() != null) {
                l1.add("s14");

            } else if (slotNum.equals("s15") && res.getS15() != null) {
                l1.add("s15");

            } else if (slotNum.equals("s16") && res.getS16() != null) {
                l1.add("s16");

            } else if (slotNum.equals("s17") && res.getS17() != null) {
                l1.add("s17");

            } else if (slotNum.equals("s18") && res.getS18() != null) {
                l1.add("s18");

            } else if (slotNum.equals("s19") && res.getS19() != null) {
                l1.add("s19");

            } else if (slotNum.equals("s20") && res.getS20() != null) {
                l1.add("s20");

            }

            // 21-30

            if (slotNum.equals("s21") && res.getS21() != null) {
                l1.add("s21");

            } else if (slotNum.equals("s22") && res.getS22() != null) {
                l1.add("s22");

            } else if (slotNum.equals("s23") && res.getS23() != null) {
                l1.add("s23");

            } else if (slotNum.equals("s24") && res.getS24() != null) {
                l1.add("s24");

            } else if (slotNum.equals("s25") && res.getS25() != null) {
                l1.add("s25");

            } else if (slotNum.equals("s26") && res.getS26() != null) {
                l1.add("s26");

            } else if (slotNum.equals("s27") && res.getS27() != null) {
                l1.add("s27");

            } else if (slotNum.equals("s28") && res.getS28() != null) {
                l1.add("s28");

            } else if (slotNum.equals("s29") && res.getS29() != null) {
                l1.add("s29");

            } else if (slotNum.equals("s30") && res.getS30() != null) {
                l1.add("s30");

            }

            // 31-40

            if (slotNum.equals("s31") && res.getS31() != null) {
                l1.add("s31");

            } else if (slotNum.equals("s32") && res.getS32() != null) {
                l1.add("s32");

            } else if (slotNum.equals("s33") && res.getS33() != null) {
                l1.add("s33");

            } else if (slotNum.equals("s34") && res.getS34() != null) {
                l1.add("s34");

            } else if (slotNum.equals("s35") && res.getS35() != null) {
                l1.add("s35");

            } else if (slotNum.equals("s36") && res.getS36() != null) {
                l1.add("s36");

            } else if (slotNum.equals("s37") && res.getS37() != null) {
                l1.add("s37");

            } else if (slotNum.equals("s38") && res.getS38() != null) {
                l1.add("s38");

            } else if (slotNum.equals("s39") && res.getS39() != null) {
                l1.add("s39");

            } else if (slotNum.equals("s40") && res.getS40() != null) {
                l1.add("s40");

            }
            // 41-50

            if (slotNum.equals("s41") && res.getS41() != null) {
                l1.add("s41");

            } else if (slotNum.equals("s42") && res.getS42() != null) {
                l1.add("s42");

            } else if (slotNum.equals("s43") && res.getS43() != null) {
                l1.add("s43");

            } else if (slotNum.equals("s44") && res.getS44() != null) {
                l1.add("s44");

            } else if (slotNum.equals("s45") && res.getS45() != null) {
                l1.add("s45");

            } else if (slotNum.equals("s46") && res.getS46() != null) {
                l1.add("s46");

            } else if (slotNum.equals("s47") && res.getS47() != null) {
                l1.add("s47");

            } else if (slotNum.equals("s48") && res.getS48() != null) {
                l1.add("s48");

            } else if (slotNum.equals("s49") && res.getS49() != null) {
                l1.add("s49");

            } else if (slotNum.equals("s50") && res.getS50() != null) {
                l1.add("s50");

            }
            // 51-54

            else if (slotNum.equals("s51") && res.getS51() != null) {
                l1.add("s51");

            } else if (slotNum.equals("s53") && res.getS52() != null) {
                l1.add("s52");

            } else if (slotNum.equals("s53") && res.getS53() != null) {
                l1.add("s53");

            } else if (slotNum.equals("s54") && res.getS54() != null) {
                l1.add("s54");

            }
        }
        return l1;
    }

    public int FacultyCountInClass(String email, String className) {
        FacultyTimeTable res = facultyTimeTableRepository.findByEmail(email);

        int count = 0;

        if (res.getS1() != null && res.getS1().getClassName().equals(className)) {
            count++;

        }
        if (res.getS2() != null && res.getS2().getClassName().equals(className)) {
            count++;
        }
        if (res.getS3() != null && res.getS3().getClassName().equals(className)) {
            count++;
        }
        if (res.getS4() != null && res.getS4().getClassName().equals(className)) {
            count++;
        }
        if (res.getS5() != null && res.getS5().getClassName().equals(className)) {
            count++;
        }
        if (res.getS6() != null && res.getS6().getClassName().equals(className)) {
            count++;
        }
        if (res.getS7() != null && res.getS7().getClassName().equals(className)) {
            count++;
        }
        if (res.getS8() != null && res.getS8().getClassName().equals(className)) {
            count++;
        }
        if (res.getS9() != null && res.getS9().getClassName().equals(className)) {
            count++;
        }
        if (res.getS10() != null && res.getS10().getClassName().equals(className)) {
            count++;
        }

        // 11-20

        if (res.getS11() != null && res.getS11().getClassName().equals(className)) {
            count++;
        }
        if (res.getS12() != null && res.getS12().getClassName().equals(className)) {
            count++;
        }
        if (res.getS13() != null && res.getS13().getClassName().equals(className)) {
            count++;
        }
        if (res.getS14() != null && res.getS14().getClassName().equals(className)) {
            count++;
        }
        if (res.getS15() != null && res.getS15().getClassName().equals(className)) {
            count++;
        }
        if (res.getS16() != null && res.getS16().getClassName().equals(className)) {
            count++;
        }
        if (res.getS17() != null && res.getS17().getClassName().equals(className)) {
            count++;
        }
        if (res.getS18() != null && res.getS18().getClassName().equals(className)) {
            count++;
        }
        if (res.getS19() != null && res.getS19().getClassName().equals(className)) {
            count++;
        }
        if (res.getS20() != null && res.getS20().getClassName().equals(className)) {
            count++;
        }

        // 21-30

        if (res.getS21() != null && res.getS21().getClassName().equals(className)) {
            count++;
        }
        if (res.getS22() != null && res.getS22().getClassName().equals(className)) {
            count++;
        }
        if (res.getS23() != null && res.getS23().getClassName().equals(className)) {
            count++;
        }
        if (res.getS24() != null && res.getS24().getClassName().equals(className)) {
            count++;
        }
        if (res.getS25() != null && res.getS25().getClassName().equals(className)) {
            count++;
        }
        if (res.getS26() != null && res.getS26().getClassName().equals(className)) {
            count++;
        }
        if (res.getS27() != null && res.getS27().getClassName().equals(className)) {
            count++;
        }
        if (res.getS28() != null && res.getS28().getClassName().equals(className)) {
            count++;
        }
        if (res.getS29() != null && res.getS29().getClassName().equals(className)) {
            count++;
        }
        if (res.getS30() != null && res.getS30().getClassName().equals(className)) {
            count++;
        }

        // 31-40

        if (res.getS31() != null && res.getS31().getClassName().equals(className)) {
            count++;
        }
        if (res.getS32() != null && res.getS32().getClassName().equals(className)) {
            count++;
        }
        if (res.getS33() != null && res.getS33().getClassName().equals(className)) {
            count++;
        }
        if (res.getS34() != null && res.getS34().getClassName().equals(className)) {
            count++;
        }
        if (res.getS35() != null && res.getS35().getClassName().equals(className)) {
            count++;
        }
        if (res.getS36() != null && res.getS36().getClassName().equals(className)) {
            count++;
        }
        if (res.getS37() != null && res.getS37().getClassName().equals(className)) {
            count++;
        }
        if (res.getS38() != null && res.getS38().getClassName().equals(className)) {
            count++;
        }
        if (res.getS39() != null && res.getS39().getClassName().equals(className)) {
            count++;
        }
        if (res.getS40() != null && res.getS40().getClassName().equals(className)) {
            count++;
        }
        // 41-50

        if (res.getS41() != null && res.getS41().getClassName().equals(className)) {
            count++;
        }
        if (res.getS42() != null && res.getS42().getClassName().equals(className)) {
            count++;
        }
        if (res.getS43() != null && res.getS43().getClassName().equals(className)) {
            count++;
        }
        if (res.getS44() != null && res.getS44().getClassName().equals(className)) {
            count++;
        }
        if (res.getS45() != null && res.getS45().getClassName().equals(className)) {
            count++;
        }
        if (res.getS46() != null && res.getS46().getClassName().equals(className)) {
            count++;
        }
        if (res.getS47() != null && res.getS47().getClassName().equals(className)) {
            count++;
        }
        if (res.getS48() != null && res.getS48().getClassName().equals(className)) {
            count++;
        }
        if (res.getS49() != null && res.getS49().getClassName().equals(className)) {
            count++;
        }
        if (res.getS50() != null && res.getS50().getClassName().equals(className)) {
            count++;
        }
        // 51-54

        if (res.getS51() != null && res.getS51().getClassName().equals(className)) {
            count++;
        }
        if (res.getS52() != null && res.getS52().getClassName().equals(className)) {
            count++;
        }
        if (res.getS53() != null && res.getS53().getClassName().equals(className)) {
            count++;
        }
        if (res.getS54() != null && res.getS54().getClassName().equals(className)) {
            count++;
        }
        return count;

    }

    // working
    public void fillRemainSpace(List<String> l1, TimeTableCreation data, String[] emails,String[] subjects) throws Exception {

        for (int i = 0; i < l1.size(); i++) {

            for (int k = 0; k < data.getNoOfSub(); k++) {
              
                    if(extraFacultySlotAvailability(l1.get(i), emails[k])){
                        extracreateFacultyTimeTable(l1.get(i), emails[k], data.getClassName(), subjects[k]);
                        break;
                    }
                    break;
                
            }
            break;

        }
    }


    



    //check
    public boolean extraFacultySlotAvailability(String slotNum, String email) throws Exception {
        
        FacultyTimeTable res = facultyTimeTableRepository.findByEmail(email);

       
        // 1-10
        if (slotNum.equals("s1") && res.getS1() != null) {
            return false;
        } else if (slotNum.equals("s2") && res.getS2() != null) {
            return false;
        } else if (slotNum.equals("s3") && res.getS3() != null) {
            return false;
        } else if (slotNum.equals("s4") && res.getS4() != null) {
            return false;
        } else if (slotNum.equals("s5") && res.getS5() != null) {
            return false;
        } else if (slotNum.equals("s6") && res.getS6() != null) {
            return false;
        } else if (slotNum.equals("s7") && res.getS7() != null) {
            return false;
        } else if (slotNum.equals("s8") && res.getS8() != null) {
            return false;
        } else if (slotNum.equals("s9") && res.getS9() != null) {
            return false;
        } else if (slotNum.equals("s10") && res.getS10() != null) {
            return false;
        }

        // 11-20

        if (slotNum.equals("s11") && res.getS11() != null) {
            return false;
        } else if (slotNum.equals("s12") && res.getS12() != null) {
            return false;
        } else if (slotNum.equals("s13") && res.getS13() != null) {
            return false;
        } else if (slotNum.equals("s14") && res.getS14() != null) {
            return false;
        } else if (slotNum.equals("s15") && res.getS15() != null) {
            return false;
        } else if (slotNum.equals("s16") && res.getS16() != null) {
            return false;
        } else if (slotNum.equals("s17") && res.getS17() != null) {
            return false;
        } else if (slotNum.equals("s18") && res.getS18() != null) {
            return false;
        } else if (slotNum.equals("s19") && res.getS19() != null) {
            return false;
        } else if (slotNum.equals("s20") && res.getS20() != null) {
            return false;
        }

        // 21-30

        if (slotNum.equals("s21") && res.getS21() != null) {
            return false;
        } else if (slotNum.equals("s22") && res.getS22() != null) {
            return false;
        } else if (slotNum.equals("s23") && res.getS23() != null) {
            return false;
        } else if (slotNum.equals("s24") && res.getS24() != null) {
            return false;
        } else if (slotNum.equals("s25") && res.getS25() != null) {
            return false;
        } else if (slotNum.equals("s26") && res.getS26() != null) {
            return false;
        } else if (slotNum.equals("s27") && res.getS27() != null) {
            return false;
        } else if (slotNum.equals("s28") && res.getS28() != null) {
            return false;
        } else if (slotNum.equals("s29") && res.getS29() != null) {
            return false;
        } else if (slotNum.equals("s30") && res.getS30() != null) {
            return false;
        }

        // 31-40

        if (slotNum.equals("s31") && res.getS31() != null) {
            return false;
        } else if (slotNum.equals("s32") && res.getS32() != null) {
            return false;
        } else if (slotNum.equals("s33") && res.getS33() != null) {
            return false;
        } else if (slotNum.equals("s34") && res.getS34() != null) {
            return false;
        } else if (slotNum.equals("s35") && res.getS35() != null) {
            return false;
        } else if (slotNum.equals("s36") && res.getS36() != null) {
            return false;
        } else if (slotNum.equals("s37") && res.getS37() != null) {
            return false;
        } else if (slotNum.equals("s38") && res.getS38() != null) {
            return false;
        } else if (slotNum.equals("s39") && res.getS39() != null) {
            return false;
        } else if (slotNum.equals("s40") && res.getS40() != null) {
            return false;
        }
        // 41-50

        if (slotNum.equals("s41") && res.getS41() != null) {
            return false;
        } else if (slotNum.equals("s42") && res.getS42() != null) {
            return false;
        } else if (slotNum.equals("s43") && res.getS43() != null) {
            return false;
        } else if (slotNum.equals("s44") && res.getS44() != null) {
            return false;
        } else if (slotNum.equals("s45") && res.getS45() != null) {
            return false;
        } else if (slotNum.equals("s46") && res.getS46() != null) {
            return false;
        } else if (slotNum.equals("s47") && res.getS47() != null) {
            return false;
        } else if (slotNum.equals("s48") && res.getS48() != null) {
            return false;
        } else if (slotNum.equals("s49") && res.getS49() != null) {
            return false;
        } else if (slotNum.equals("s50") && res.getS50() != null) {
            return false;
        }
        // 51-54

        else if (slotNum.equals("s51") && res.getS51() != null) {
            return false;
        } else if (slotNum.equals("s53") && res.getS52() != null) {
            return false;
        } else if (slotNum.equals("s53") && res.getS53() != null) {
            return false;
        } else if (slotNum.equals("s54") && res.getS54() != null) {
            return false;
        }
        return true;
    }





    public String extracreateFacultyTimeTable(String slotNum, String email, String className, String subjectCode)
            throws Exception {
      

        // Faculty table Model

        FacultyTimeTable res = facultyTimeTableRepository.findByEmail(email);
        Course cou_res = courseRepository.findByCode(subjectCode);
        FacultySlot dataModel = new FacultySlot();
        dataModel.setClassName(className);
        dataModel.setCourse(cou_res);

        // Class Table Model

        ClassTimeTable classTimeTable = classTimeTableRepository.findByCode(className);
        Faculty faculty = facultyRepository.findByEmail(email);
        ClassSlot classSlot = new ClassSlot();
        classSlot.setCourse(cou_res);
        classSlot.setFaculty(faculty);

        // 1-10
        if (slotNum.equals("s1")) {
            res.setS1(dataModel);
            classTimeTable.setS1(classSlot);

        } else if (slotNum.equals("s2")) {
            res.setS2(dataModel);
            classTimeTable.setS2(classSlot);
        } else if (slotNum.equals("s3")) {
            res.setS3(dataModel);
            classTimeTable.setS3(classSlot);

        } else if (slotNum.equals("s4")) {
            res.setS4(dataModel);
            classTimeTable.setS4(classSlot);

        } else if (slotNum.equals("s5")) {
            res.setS5(dataModel);

            classTimeTable.setS5(classSlot);

        } else if (slotNum.equals("s6")) {
            res.setS6(dataModel);
            classTimeTable.setS6(classSlot);

        } else if (slotNum.equals("s7")) {
            res.setS7(dataModel);
            classTimeTable.setS7(classSlot);

        } else if (slotNum.equals("s8")) {
            res.setS8(dataModel);

            classTimeTable.setS8(classSlot);

        } else if (slotNum.equals("s9")) {
            res.setS9(dataModel);
            classTimeTable.setS9(classSlot);

        } else if (slotNum.equals("s10")) {
            res.setS10(dataModel);
            classTimeTable.setS10(classSlot);

        }

        // 11-20

        if (slotNum.equals("s11")) {
            res.setS11(dataModel);

            classTimeTable.setS11(classSlot);

        } else if (slotNum.equals("s12")) {
            res.setS12(dataModel);

            classTimeTable.setS12(classSlot);

        } else if (slotNum.equals("s13")) {
            res.setS13(dataModel);
            classTimeTable.setS13(classSlot);

        } else if (slotNum.equals("s14")) {
            res.setS14(dataModel);

            classTimeTable.setS14(classSlot);

        } else if (slotNum.equals("s15")) {
            res.setS15(dataModel);
            classTimeTable.setS15(classSlot);

        } else if (slotNum.equals("s16")) {
            res.setS16(dataModel);

            classTimeTable.setS16(classSlot);

        } else if (slotNum.equals("s17")) {
            res.setS17(dataModel);

            classTimeTable.setS17(classSlot);

        } else if (slotNum.equals("s18")) {
            res.setS18(dataModel);
            classTimeTable.setS18(classSlot);

        } else if (slotNum.equals("s19")) {
            res.setS19(dataModel);

            classTimeTable.setS19(classSlot);

        } else if (slotNum.equals("s20")) {
            res.setS20(dataModel);
            classTimeTable.setS20(classSlot);

        }

        // 21-30

        if (slotNum.equals("s21")) {
            res.setS21(dataModel);

            classTimeTable.setS21(classSlot);

        } else if (slotNum.equals("s22")) {
            res.setS22(dataModel);

            classTimeTable.setS22(classSlot);

        } else if (slotNum.equals("s23")) {
            res.setS23(dataModel);

            classTimeTable.setS23(classSlot);

        } else if (slotNum.equals("s24")) {
            res.setS24(dataModel);

            classTimeTable.setS24(classSlot);

        } else if (slotNum.equals("s25")) {
            res.setS25(dataModel);

            classTimeTable.setS25(classSlot);

        } else if (slotNum.equals("s26")) {
            res.setS26(dataModel);

            classTimeTable.setS26(classSlot);

        } else if (slotNum.equals("s27")) {
            res.setS27(dataModel);
            classTimeTable.setS27(classSlot);

        } else if (slotNum.equals("s28")) {
            res.setS28(dataModel);

            classTimeTable.setS28(classSlot);

        } else if (slotNum.equals("s29")) {
            res.setS29(dataModel);

            classTimeTable.setS29(classSlot);

        } else if (slotNum.equals("s30")) {
            res.setS30(dataModel);
            classTimeTable.setS30(classSlot);

        }

        // 31-40

        if (slotNum.equals("s31")) {
            res.setS31(dataModel);

            classTimeTable.setS31(classSlot);

        } else if (slotNum.equals("s32")) {
            res.setS32(dataModel);

            classTimeTable.setS32(classSlot);

        } else if (slotNum.equals("s33")) {
            res.setS33(dataModel);

            classTimeTable.setS33(classSlot);

        } else if (slotNum.equals("s34")) {
            res.setS34(dataModel);

            classTimeTable.setS34(classSlot);

        } else if (slotNum.equals("s35")) {
            res.setS35(dataModel);

            classTimeTable.setS35(classSlot);

        } else if (slotNum.equals("s36")) {
            res.setS36(dataModel);

            classTimeTable.setS36(classSlot);

        } else if (slotNum.equals("s37")) {
            res.setS37(dataModel);

            classTimeTable.setS37(classSlot);

        } else if (slotNum.equals("s38")) {
            res.setS38(dataModel);

            classTimeTable.setS38(classSlot);

        } else if (slotNum.equals("s39")) {
            res.setS39(dataModel);

            classTimeTable.setS39(classSlot);

        } else if (slotNum.equals("s40")) {
            res.setS40(dataModel);

            classTimeTable.setS40(classSlot);

        }
        // 41-50

        if (slotNum.equals("s41")) {
            res.setS41(dataModel);

            classTimeTable.setS41(classSlot);

        } else if (slotNum.equals("s42")) {
            res.setS42(dataModel);
            classTimeTable.setS42(classSlot);

        } else if (slotNum.equals("s43")) {
            res.setS43(dataModel);

            classTimeTable.setS43(classSlot);

        } else if (slotNum.equals("s44")) {
            res.setS44(dataModel);

            classTimeTable.setS44(classSlot);

        } else if (slotNum.equals("s45")) {
            res.setS45(dataModel);

            classTimeTable.setS45(classSlot);

        } else if (slotNum.equals("s46")) {
            res.setS46(dataModel);

            classTimeTable.setS46(classSlot);

        } else if (slotNum.equals("s47")) {
            res.setS47(dataModel);

            classTimeTable.setS47(classSlot);

        } else if (slotNum.equals("s48")) {
            res.setS48(dataModel);

            classTimeTable.setS48(classSlot);

        } else if (slotNum.equals("s49")) {
            res.setS49(dataModel);

            classTimeTable.setS49(classSlot);

        } else if (slotNum.equals("s50")) {
            res.setS50(dataModel);

            classTimeTable.setS50(classSlot);

        }
        // 51-54

        else if (slotNum.equals("s51")) {
            res.setS51(dataModel);

            classTimeTable.setS51(classSlot);

        } else if (slotNum.equals("s53")) {
            res.setS52(dataModel);

            classTimeTable.setS52(classSlot);

        } else if (slotNum.equals("s53")) {
            res.setS53(dataModel);

            classTimeTable.setS53(classSlot);

        } else if (slotNum.equals("s54")) {
            res.setS54(dataModel);

            classTimeTable.setS54(classSlot);

        }

        facultyTimeTableRepository.save(res);
        classTimeTableRepository.save(classTimeTable);

        return slotNum;
    }








}







