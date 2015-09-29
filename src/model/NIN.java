package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NIN {
    public String getB1_date_reg_emission() {
        return b1_date_reg_emission;
    }

    public String getB1_date_end_emission() {
        return b1_date_end_emission;
    }

    public String getB1_date_reg_emissionO() {
        return b1_date_reg_emissionO;
    }

    private String b1_date_reg_emissionO;
    private String b1_date_reg_emission;
    private String b1_num_emission;
    private String volofplacedsecurities;
    private String volofdeclaredsecurities;
    private String b1_date_end_emission;

    public String getA1_cl_fullname() {
        return a1_cl_fullname;
    }

    public void setA1_cl_fullname(String a1_cl_fullname) {
        this.a1_cl_fullname = a1_cl_fullname;
    }

    private String a1_cl_fullname;

    public void setB1_date_reg_emissionO(Date b1_date_reg_emissionO) {

        if (b1_date_reg_emissionO == null) {
            this.b1_date_reg_emissionO = null;
            return;
        }
        SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM-yyyy");
        this.b1_date_reg_emissionO = dt1.format(b1_date_reg_emissionO)+" г.";

        return ;
    }

    public void setB1_date_end_emission(Date b1_date_end_emission) {

        if (b1_date_end_emission == null) {
            this.b1_date_end_emission = null;
            return;
        }
        SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM-yyyy");
        this.b1_date_end_emission = dt1.format(b1_date_end_emission)+" г.";

        return ;
    }

    public void setB1_date_reg_emission(Date b1_date_reg_emission) {

        if (b1_date_reg_emission == null) {
            this.b1_date_reg_emission = null;
            return;
        }
        SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM-yyyy");
        this.b1_date_reg_emission = dt1.format(b1_date_reg_emission)+" г.";

    }

    public String getB1_num_emission() {
        return b1_num_emission;
    }

    public void setB1_num_emission(String b1_num_emission) {
        this.b1_num_emission = b1_num_emission;
    }

    public String getVolofplacedsecurities() {
        return volofplacedsecurities;
    }

    public void setVolofplacedsecurities(String volofplacedsecurities) {
        this.volofplacedsecurities = volofplacedsecurities;
    }

    public String getVolofdeclaredsecurities() {
        return volofdeclaredsecurities;
    }

    public void setVolofdeclaredsecurities(String volofdeclaredsecurities) {
        this.volofdeclaredsecurities = volofdeclaredsecurities;
    }

    public String getSrok() {
        return srok;
    }

    public void setSrok(String srok) {
        this.srok = srok;
    }

    private String srok;


}
