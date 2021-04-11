package com.time_table_management_system.time_table_management_system.entity;

import javax.persistence.*;
import javax.transaction.Transactional;

@Transactional
@Entity
public class FacultyTimeTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;

    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s1;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s2;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s3;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s4;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s5;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s6;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s7;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s8;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s9;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s10;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s11;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s12;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s13;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s14;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s15;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s16;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s17;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s18;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s19;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s20;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s21;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s22;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s23;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s24;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s25;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s26;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s27;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s28;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s29;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s30;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s31;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s32;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s33;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s34;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s35;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s36;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s37;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s38;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s39;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s40;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s41;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s42;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s43;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s44;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s45;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s46;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s47;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s48;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s49;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s50;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s51;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s52;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s53;
    @OneToOne(targetEntity = FacultySlot.class, cascade = CascadeType.ALL)
    private FacultySlot s54;

    public FacultyTimeTable() {
    }

    public FacultyTimeTable(String name, String email, FacultySlot s1, FacultySlot s2, FacultySlot s3, FacultySlot s4, FacultySlot s5, FacultySlot s6, FacultySlot s7, FacultySlot s8, FacultySlot s9, FacultySlot s10, FacultySlot s11, FacultySlot s12, FacultySlot s13, FacultySlot s14, FacultySlot s15, FacultySlot s16, FacultySlot s17, FacultySlot s18, FacultySlot s19, FacultySlot s20, FacultySlot s21, FacultySlot s22, FacultySlot s23, FacultySlot s24, FacultySlot s25, FacultySlot s26, FacultySlot s27, FacultySlot s28, FacultySlot s29, FacultySlot s30, FacultySlot s31, FacultySlot s32, FacultySlot s33, FacultySlot s34, FacultySlot s35, FacultySlot s36, FacultySlot s37, FacultySlot s38, FacultySlot s39, FacultySlot s40, FacultySlot s41, FacultySlot s42, FacultySlot s43, FacultySlot s44, FacultySlot s45, FacultySlot s46, FacultySlot s47, FacultySlot s48, FacultySlot s49, FacultySlot s50, FacultySlot s51, FacultySlot s52, FacultySlot s53, FacultySlot s54) {
        this.name = name;
        this.email = email;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public FacultySlot getS1() {
        return s1;
    }

    public void setS1(FacultySlot s1) {
        this.s1 = s1;
    }

    public FacultySlot getS2() {
        return s2;
    }

    public void setS2(FacultySlot s2) {
        this.s2 = s2;
    }

    public FacultySlot getS3() {
        return s3;
    }

    public void setS3(FacultySlot s3) {
        this.s3 = s3;
    }

    public FacultySlot getS4() {
        return s4;
    }

    public void setS4(FacultySlot s4) {
        this.s4 = s4;
    }

    public FacultySlot getS5() {
        return s5;
    }

    public void setS5(FacultySlot s5) {
        this.s5 = s5;
    }

    public FacultySlot getS6() {
        return s6;
    }

    public void setS6(FacultySlot s6) {
        this.s6 = s6;
    }

    public FacultySlot getS7() {
        return s7;
    }

    public void setS7(FacultySlot s7) {
        this.s7 = s7;
    }

    public FacultySlot getS8() {
        return s8;
    }

    public void setS8(FacultySlot s8) {
        this.s8 = s8;
    }

    public FacultySlot getS9() {
        return s9;
    }

    public void setS9(FacultySlot s9) {
        this.s9 = s9;
    }

    public FacultySlot getS10() {
        return s10;
    }

    public void setS10(FacultySlot s10) {
        this.s10 = s10;
    }

    public FacultySlot getS11() {
        return s11;
    }

    public void setS11(FacultySlot s11) {
        this.s11 = s11;
    }

    public FacultySlot getS12() {
        return s12;
    }

    public void setS12(FacultySlot s12) {
        this.s12 = s12;
    }

    public FacultySlot getS13() {
        return s13;
    }

    public void setS13(FacultySlot s13) {
        this.s13 = s13;
    }

    public FacultySlot getS14() {
        return s14;
    }

    public void setS14(FacultySlot s14) {
        this.s14 = s14;
    }

    public FacultySlot getS15() {
        return s15;
    }

    public void setS15(FacultySlot s15) {
        this.s15 = s15;
    }

    public FacultySlot getS16() {
        return s16;
    }

    public void setS16(FacultySlot s16) {
        this.s16 = s16;
    }

    public FacultySlot getS17() {
        return s17;
    }

    public void setS17(FacultySlot s17) {
        this.s17 = s17;
    }

    public FacultySlot getS18() {
        return s18;
    }

    public void setS18(FacultySlot s18) {
        this.s18 = s18;
    }

    public FacultySlot getS19() {
        return s19;
    }

    public void setS19(FacultySlot s19) {
        this.s19 = s19;
    }

    public FacultySlot getS20() {
        return s20;
    }

    public void setS20(FacultySlot s20) {
        this.s20 = s20;
    }

    public FacultySlot getS21() {
        return s21;
    }

    public void setS21(FacultySlot s21) {
        this.s21 = s21;
    }

    public FacultySlot getS22() {
        return s22;
    }

    public void setS22(FacultySlot s22) {
        this.s22 = s22;
    }

    public FacultySlot getS23() {
        return s23;
    }

    public void setS23(FacultySlot s23) {
        this.s23 = s23;
    }

    public FacultySlot getS24() {
        return s24;
    }

    public void setS24(FacultySlot s24) {
        this.s24 = s24;
    }

    public FacultySlot getS25() {
        return s25;
    }

    public void setS25(FacultySlot s25) {
        this.s25 = s25;
    }

    public FacultySlot getS26() {
        return s26;
    }

    public void setS26(FacultySlot s26) {
        this.s26 = s26;
    }

    public FacultySlot getS27() {
        return s27;
    }

    public void setS27(FacultySlot s27) {
        this.s27 = s27;
    }

    public FacultySlot getS28() {
        return s28;
    }

    public void setS28(FacultySlot s28) {
        this.s28 = s28;
    }

    public FacultySlot getS29() {
        return s29;
    }

    public void setS29(FacultySlot s29) {
        this.s29 = s29;
    }

    public FacultySlot getS30() {
        return s30;
    }

    public void setS30(FacultySlot s30) {
        this.s30 = s30;
    }

    public FacultySlot getS31() {
        return s31;
    }

    public void setS31(FacultySlot s31) {
        this.s31 = s31;
    }

    public FacultySlot getS32() {
        return s32;
    }

    public void setS32(FacultySlot s32) {
        this.s32 = s32;
    }

    public FacultySlot getS33() {
        return s33;
    }

    public void setS33(FacultySlot s33) {
        this.s33 = s33;
    }

    public FacultySlot getS34() {
        return s34;
    }

    public void setS34(FacultySlot s34) {
        this.s34 = s34;
    }

    public FacultySlot getS35() {
        return s35;
    }

    public void setS35(FacultySlot s35) {
        this.s35 = s35;
    }

    public FacultySlot getS36() {
        return s36;
    }

    public void setS36(FacultySlot s36) {
        this.s36 = s36;
    }

    public FacultySlot getS37() {
        return s37;
    }

    public void setS37(FacultySlot s37) {
        this.s37 = s37;
    }

    public FacultySlot getS38() {
        return s38;
    }

    public void setS38(FacultySlot s38) {
        this.s38 = s38;
    }

    public FacultySlot getS39() {
        return s39;
    }

    public void setS39(FacultySlot s39) {
        this.s39 = s39;
    }

    public FacultySlot getS40() {
        return s40;
    }

    public void setS40(FacultySlot s40) {
        this.s40 = s40;
    }

    public FacultySlot getS41() {
        return s41;
    }

    public void setS41(FacultySlot s41) {
        this.s41 = s41;
    }

    public FacultySlot getS42() {
        return s42;
    }

    public void setS42(FacultySlot s42) {
        this.s42 = s42;
    }

    public FacultySlot getS43() {
        return s43;
    }

    public void setS43(FacultySlot s43) {
        this.s43 = s43;
    }

    public FacultySlot getS44() {
        return s44;
    }

    public void setS44(FacultySlot s44) {
        this.s44 = s44;
    }

    public FacultySlot getS45() {
        return s45;
    }

    public void setS45(FacultySlot s45) {
        this.s45 = s45;
    }

    public FacultySlot getS46() {
        return s46;
    }

    public void setS46(FacultySlot s46) {
        this.s46 = s46;
    }

    public FacultySlot getS47() {
        return s47;
    }

    public void setS47(FacultySlot s47) {
        this.s47 = s47;
    }

    public FacultySlot getS48() {
        return s48;
    }

    public void setS48(FacultySlot s48) {
        this.s48 = s48;
    }

    public FacultySlot getS49() {
        return s49;
    }

    public void setS49(FacultySlot s49) {
        this.s49 = s49;
    }

    public FacultySlot getS50() {
        return s50;
    }

    public void setS50(FacultySlot s50) {
        this.s50 = s50;
    }

    public FacultySlot getS51() {
        return s51;
    }

    public void setS51(FacultySlot s51) {
        this.s51 = s51;
    }

    public FacultySlot getS52() {
        return s52;
    }

    public void setS52(FacultySlot s52) {
        this.s52 = s52;
    }

    public FacultySlot getS53() {
        return s53;
    }

    public void setS53(FacultySlot s53) {
        this.s53 = s53;
    }

    public FacultySlot getS54() {
        return s54;
    }

    public void setS54(FacultySlot s54) {
        this.s54 = s54;
    }


    @Override
    public String toString() {
        return "FacultyTimeTable{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
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

