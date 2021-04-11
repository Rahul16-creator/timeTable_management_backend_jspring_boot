package com.time_table_management_system.time_table_management_system.entity;

import javax.persistence.*;

@Entity
public class ClassTimeTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String className;
    private String code;

    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s1;

    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s2;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s3;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s4;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s5;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s6;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s7;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s8;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s9;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s10;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s11;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s12;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s13;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s14;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s15;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s16;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s17;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s18;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s19;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s20;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s21;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s22;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s23;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s24;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s25;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s26;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s27;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s28;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s29;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s30;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s31;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s32;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s33;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s34;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s35;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s36;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s37;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s38;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s39;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s40;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s41;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s42;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s43;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s44;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s45;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s46;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s47;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s48;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s49;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s50;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s51;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s52;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s53;
    @OneToOne(targetEntity = ClassSlot.class, cascade = CascadeType.ALL)
    private ClassSlot s54;

    public ClassTimeTable() {
    }

    public ClassTimeTable(String className, String code, ClassSlot s1, ClassSlot s2, ClassSlot s3, ClassSlot s4, ClassSlot s5, ClassSlot s6, ClassSlot s7, ClassSlot s8, ClassSlot s9, ClassSlot s10, ClassSlot s11, ClassSlot s12, ClassSlot s13, ClassSlot s14, ClassSlot s15, ClassSlot s16, ClassSlot s17, ClassSlot s18, ClassSlot s19, ClassSlot s20, ClassSlot s21, ClassSlot s22, ClassSlot s23, ClassSlot s24, ClassSlot s25, ClassSlot s26, ClassSlot s27, ClassSlot s28, ClassSlot s29, ClassSlot s30, ClassSlot s31, ClassSlot s32, ClassSlot s33, ClassSlot s34, ClassSlot s35, ClassSlot s36, ClassSlot s37, ClassSlot s38, ClassSlot s39, ClassSlot s40, ClassSlot s41, ClassSlot s42, ClassSlot s43, ClassSlot s44, ClassSlot s45, ClassSlot s46, ClassSlot s47, ClassSlot s48, ClassSlot s49, ClassSlot s50, ClassSlot s51, ClassSlot s52, ClassSlot s53, ClassSlot s54) {
        this.className = className;
        this.code = code;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.s4 = s4;
        this.s5 = s5;
        this.s6 = s6;
        this.s7 = s7;
        this.s8 = s8;
        this.s9 = s9;
        this.s10 = s10;
        this.s11 = s11;
        this.s12 = s12;
        this.s13 = s13;
        this.s14 = s14;
        this.s15 = s15;
        this.s16 = s16;
        this.s17 = s17;
        this.s18 = s18;
        this.s19 = s19;
        this.s20 = s20;
        this.s21 = s21;
        this.s22 = s22;
        this.s23 = s23;
        this.s24 = s24;
        this.s25 = s25;
        this.s26 = s26;
        this.s27 = s27;
        this.s28 = s28;
        this.s29 = s29;
        this.s30 = s30;
        this.s31 = s31;
        this.s32 = s32;
        this.s33 = s33;
        this.s34 = s34;
        this.s35 = s35;
        this.s36 = s36;
        this.s37 = s37;
        this.s38 = s38;
        this.s39 = s39;
        this.s40 = s40;
        this.s41 = s41;
        this.s42 = s42;
        this.s43 = s43;
        this.s44 = s44;
        this.s45 = s45;
        this.s46 = s46;
        this.s47 = s47;
        this.s48 = s48;
        this.s49 = s49;
        this.s50 = s50;
        this.s51 = s51;
        this.s52 = s52;
        this.s53 = s53;
        this.s54 = s54;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ClassSlot getS1() {
        return s1;
    }

    public void setS1(ClassSlot s1) {
        this.s1 = s1;
    }

    public ClassSlot getS2() {
        return s2;
    }

    public void setS2(ClassSlot s2) {
        this.s2 = s2;
    }

    public ClassSlot getS3() {
        return s3;
    }

    public void setS3(ClassSlot s3) {
        this.s3 = s3;
    }

    public ClassSlot getS4() {
        return s4;
    }

    public void setS4(ClassSlot s4) {
        this.s4 = s4;
    }

    public ClassSlot getS5() {
        return s5;
    }

    public void setS5(ClassSlot s5) {
        this.s5 = s5;
    }

    public ClassSlot getS6() {
        return s6;
    }

    public void setS6(ClassSlot s6) {
        this.s6 = s6;
    }

    public ClassSlot getS7() {
        return s7;
    }

    public void setS7(ClassSlot s7) {
        this.s7 = s7;
    }

    public ClassSlot getS8() {
        return s8;
    }

    public void setS8(ClassSlot s8) {
        this.s8 = s8;
    }

    public ClassSlot getS9() {
        return s9;
    }

    public void setS9(ClassSlot s9) {
        this.s9 = s9;
    }

    public ClassSlot getS10() {
        return s10;
    }

    public void setS10(ClassSlot s10) {
        this.s10 = s10;
    }

    public ClassSlot getS11() {
        return s11;
    }

    public void setS11(ClassSlot s11) {
        this.s11 = s11;
    }

    public ClassSlot getS12() {
        return s12;
    }

    public void setS12(ClassSlot s12) {
        this.s12 = s12;
    }

    public ClassSlot getS13() {
        return s13;
    }

    public void setS13(ClassSlot s13) {
        this.s13 = s13;
    }

    public ClassSlot getS14() {
        return s14;
    }

    public void setS14(ClassSlot s14) {
        this.s14 = s14;
    }

    public ClassSlot getS15() {
        return s15;
    }

    public void setS15(ClassSlot s15) {
        this.s15 = s15;
    }

    public ClassSlot getS16() {
        return s16;
    }

    public void setS16(ClassSlot s16) {
        this.s16 = s16;
    }

    public ClassSlot getS17() {
        return s17;
    }

    public void setS17(ClassSlot s17) {
        this.s17 = s17;
    }

    public ClassSlot getS18() {
        return s18;
    }

    public void setS18(ClassSlot s18) {
        this.s18 = s18;
    }

    public ClassSlot getS19() {
        return s19;
    }

    public void setS19(ClassSlot s19) {
        this.s19 = s19;
    }

    public ClassSlot getS20() {
        return s20;
    }

    public void setS20(ClassSlot s20) {
        this.s20 = s20;
    }

    public ClassSlot getS21() {
        return s21;
    }

    public void setS21(ClassSlot s21) {
        this.s21 = s21;
    }

    public ClassSlot getS22() {
        return s22;
    }

    public void setS22(ClassSlot s22) {
        this.s22 = s22;
    }

    public ClassSlot getS23() {
        return s23;
    }

    public void setS23(ClassSlot s23) {
        this.s23 = s23;
    }

    public ClassSlot getS24() {
        return s24;
    }

    public void setS24(ClassSlot s24) {
        this.s24 = s24;
    }

    public ClassSlot getS25() {
        return s25;
    }

    public void setS25(ClassSlot s25) {
        this.s25 = s25;
    }

    public ClassSlot getS26() {
        return s26;
    }

    public void setS26(ClassSlot s26) {
        this.s26 = s26;
    }

    public ClassSlot getS27() {
        return s27;
    }

    public void setS27(ClassSlot s27) {
        this.s27 = s27;
    }

    public ClassSlot getS28() {
        return s28;
    }

    public void setS28(ClassSlot s28) {
        this.s28 = s28;
    }

    public ClassSlot getS29() {
        return s29;
    }

    public void setS29(ClassSlot s29) {
        this.s29 = s29;
    }

    public ClassSlot getS30() {
        return s30;
    }

    public void setS30(ClassSlot s30) {
        this.s30 = s30;
    }

    public ClassSlot getS31() {
        return s31;
    }

    public void setS31(ClassSlot s31) {
        this.s31 = s31;
    }

    public ClassSlot getS32() {
        return s32;
    }

    public void setS32(ClassSlot s32) {
        this.s32 = s32;
    }

    public ClassSlot getS33() {
        return s33;
    }

    public void setS33(ClassSlot s33) {
        this.s33 = s33;
    }

    public ClassSlot getS34() {
        return s34;
    }

    public void setS34(ClassSlot s34) {
        this.s34 = s34;
    }

    public ClassSlot getS35() {
        return s35;
    }

    public void setS35(ClassSlot s35) {
        this.s35 = s35;
    }

    public ClassSlot getS36() {
        return s36;
    }

    public void setS36(ClassSlot s36) {
        this.s36 = s36;
    }

    public ClassSlot getS37() {
        return s37;
    }

    public void setS37(ClassSlot s37) {
        this.s37 = s37;
    }

    public ClassSlot getS38() {
        return s38;
    }

    public void setS38(ClassSlot s38) {
        this.s38 = s38;
    }

    public ClassSlot getS39() {
        return s39;
    }

    public void setS39(ClassSlot s39) {
        this.s39 = s39;
    }

    public ClassSlot getS40() {
        return s40;
    }

    public void setS40(ClassSlot s40) {
        this.s40 = s40;
    }

    public ClassSlot getS41() {
        return s41;
    }

    public void setS41(ClassSlot s41) {
        this.s41 = s41;
    }

    public ClassSlot getS42() {
        return s42;
    }

    public void setS42(ClassSlot s42) {
        this.s42 = s42;
    }

    public ClassSlot getS43() {
        return s43;
    }

    public void setS43(ClassSlot s43) {
        this.s43 = s43;
    }

    public ClassSlot getS44() {
        return s44;
    }

    public void setS44(ClassSlot s44) {
        this.s44 = s44;
    }

    public ClassSlot getS45() {
        return s45;
    }

    public void setS45(ClassSlot s45) {
        this.s45 = s45;
    }

    public ClassSlot getS46() {
        return s46;
    }

    public void setS46(ClassSlot s46) {
        this.s46 = s46;
    }

    public ClassSlot getS47() {
        return s47;
    }

    public void setS47(ClassSlot s47) {
        this.s47 = s47;
    }

    public ClassSlot getS48() {
        return s48;
    }

    public void setS48(ClassSlot s48) {
        this.s48 = s48;
    }

    public ClassSlot getS49() {
        return s49;
    }

    public void setS49(ClassSlot s49) {
        this.s49 = s49;
    }

    public ClassSlot getS50() {
        return s50;
    }

    public void setS50(ClassSlot s50) {
        this.s50 = s50;
    }

    public ClassSlot getS51() {
        return s51;
    }

    public void setS51(ClassSlot s51) {
        this.s51 = s51;
    }

    public ClassSlot getS52() {
        return s52;
    }

    public void setS52(ClassSlot s52) {
        this.s52 = s52;
    }

    public ClassSlot getS53() {
        return s53;
    }

    public void setS53(ClassSlot s53) {
        this.s53 = s53;
    }

    public ClassSlot getS54() {
        return s54;
    }

    public void setS54(ClassSlot s54) {
        this.s54 = s54;
    }

    @Override
    public String toString() {
        return "ClassTimeTable{" +
                "id=" + id +
                ", className='" + className + '\'' +
                ", classCode='" + code + '\'' +
                ", s1=" + s1 +
                ", s2=" + s2 +
                ", s3=" + s3 +
                ", s4=" + s4 +
                ", s5=" + s5 +
                ", s6=" + s6 +
                ", s7=" + s7 +
                ", s8=" + s8 +
                ", s9=" + s9 +
                ", s10=" + s10 +
                ", s11=" + s11 +
                ", s12=" + s12 +
                ", s13=" + s13 +
                ", s14=" + s14 +
                ", s15=" + s15 +
                ", s16=" + s16 +
                ", s17=" + s17 +
                ", s18=" + s18 +
                ", s19=" + s19 +
                ", s20=" + s20 +
                ", s21=" + s21 +
                ", s22=" + s22 +
                ", s23=" + s23 +
                ", s24=" + s24 +
                ", s25=" + s25 +
                ", s26=" + s26 +
                ", s27=" + s27 +
                ", s28=" + s28 +
                ", s29=" + s29 +
                ", s30=" + s30 +
                ", s31=" + s31 +
                ", s32=" + s32 +
                ", s33=" + s33 +
                ", s34=" + s34 +
                ", s35=" + s35 +
                ", s36=" + s36 +
                ", s37=" + s37 +
                ", s38=" + s38 +
                ", s39=" + s39 +
                ", s40=" + s40 +
                ", s41=" + s41 +
                ", s42=" + s42 +
                ", s43=" + s43 +
                ", s44=" + s44 +
                ", s45=" + s45 +
                ", s46=" + s46 +
                ", s47=" + s47 +
                ", s48=" + s48 +
                ", s49=" + s49 +
                ", s50=" + s50 +
                ", s51=" + s51 +
                ", s52=" + s52 +
                ", s53=" + s53 +
                ", s54=" + s54 +
                '}';
    }
}

