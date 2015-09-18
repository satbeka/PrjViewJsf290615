package model;

import common.OracleDB;
import common.PropertiesBuilder;
import org.primefaces.context.RequestContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

@ManagedBean(name = "dfView")
@SessionScoped
public class DFView {


    private Client selectedClient;

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public Client getSelectedClient() {
        return selectedClient;
    }

    public void setSelectedClient(Client selectedClient) {
        this.selectedClient = selectedClient;
    }

    private String client_id;

    public String getNin() {
        return nin;
    }

    public void setNin(String nin) {
        this.nin = nin;
    }

    private String nin;

    public void viewClientsCustomized(String client_idn) {
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("modal", true);
        options.put("draggable", false);
        options.put("resizable", false);
        options.put("contentHeight", 320);
        //this.client_id=client_idn;
        //client_idn.replace("+","");
        //System.out.println("client_idn 1 substr="+client_idn.substring(1));

        String Sqlsel="select a1_cl_type,a1_status,a1_cl_lastname," +
                "a1_cl_firstname,a1_cl_middlename,a1_cl_fullname,a1_born,a1_cl_status," +
                "a1_rnn,a1_idn,a1_country,a1_j_address,a1_phone1,a1_addr_email,a1_open_date,a1_close_date,a1_resident" +
                ",a1_cl_doc_dat, a1_cl_doc_nom" +
                " from D_A1_CLIENTS t where t.a1_idn='"+client_idn.substring(1)+"'";

        System.out.println("Sqlsel Cl="+Sqlsel);

        Driver myDriver = new oracle.jdbc.driver.OracleDriver();
        String uRL = OracleDB.getSystemDb();
        String uSER = OracleDB.getDbUsername();
        String pASS = OracleDB.getDbPwd();


        try {
            DriverManager.registerDriver(myDriver);

        //String SYSTEM_DB = "jdbc:oracle:thin:@ala-srv-db-tst1.tisr.kz:1521:Test01";


        Connection conn = DriverManager.getConnection(uRL, uSER, pASS);

        PreparedStatement pS=conn.prepareStatement(Sqlsel);
            //pS.executeUpdate();
        ResultSet rs = pS.executeQuery(Sqlsel);
            //System.out.println("   pS.executeQ().......");
             conn.commit();
            while (rs.next()) {

            Client client=new Client();
            client.setClient_id(client_id);
            client.setA1_cl_type(rs.getString(1));
            client.setA1_status(rs.getString(2));
            client.setA1_cl_lastname(rs.getString(3));
            client.setA1_cl_firstname(rs.getString(4));
                  client.setA1_cl_middlename(rs.getString(5));
            client.setA1_cl_fullname(rs.getString(6));
                //System.out.println(client.getA1_cl_fullname());
                    client.setA1_born(rs.getDate(7));
            client.setA1_cl_status(rs.getString(8));
            client.setA1_rnn(rs.getString(9));
                    client.setA1_idn(rs.getString(10));
            client.setA1_country(rs.getString(11));
            client.setA1_j_address(rs.getString(12));
            client.setA1_phone1(rs.getString(13));
                    client.setA1_addr_email(rs.getString(14));
            client.setA1_open_date(rs.getDate(15));
            client.setA1_close_date(rs.getDate(16));
            client.setA1_resident(rs.getString(17));
                client.setA1_cl_doc_dat(rs.getDate(18));
                client.setA1_cl_doc_nom(rs.getString(19));
                this.selectedClient=client;


        };

            if (pS != null) {
                pS.close();
            }

            if (conn != null) {
                conn.close();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        //System.out.println(this.selectedClient);
        RequestContext.getCurrentInstance().openDialog("clientV", options, null);
    }

    public NIN getSelectedNIN() {
        return selectedNIN;
    }

    public void setSelectedNIN(NIN selectedNIN) {
        this.selectedNIN = selectedNIN;
    }

    private NIN selectedNIN;

    public void viewNINCustomized(String p3_nsin) {
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("modal", true);
        options.put("draggable", false);
        options.put("resizable", false);
        options.put("contentHeight", 320);
        this.nin=p3_nsin;
        //System.out.println("tisr_non_market.p3_nsin="+p3_nsin);

        String Sqlsel="select t.b1_date_reg_emission,\n" +
                "t.b1_num_emission,\n" +
                "report.volofplacedsecurities(t.b1_client, sysdate, '"+p3_nsin+"'),\n" +
                "report.volofdeclaredsecurities(t.b1_client, sysdate, '"+p3_nsin+"'),\n" +
                "t.b1_date_end_emission-t.b1_date_reg_emission,t.b1_as_type\n" +
                " from D_B1_ASSETS t where t.b1_nin='"+p3_nsin+"'";

        Driver myDriver = new oracle.jdbc.driver.OracleDriver();
        String uRL = OracleDB.getSystemDb();
        String uSER = OracleDB.getDbUsername();
        String pASS = OracleDB.getDbPwd();


        try {
            DriverManager.registerDriver(myDriver);

            Connection conn = DriverManager.getConnection(uRL, uSER, pASS);

            PreparedStatement pS=conn.prepareStatement(Sqlsel);
            //pS.executeUpdate();
            ResultSet rs = pS.executeQuery(Sqlsel);
            //System.out.println("  NIN pS.executeQ().......");
            conn.commit();
            while (rs.next()) {

                NIN nin=new NIN();
                nin.setB1_date_reg_emission(rs.getDate(1));
                nin.setB1_num_emission(rs.getString(2));
                Integer nmb;
                nmb=rs.getInt(3);
                nin.setVolofplacedsecurities(UserData.getFrmtNumb(nmb));
                nmb=rs.getInt(4);
                nin.setVolofdeclaredsecurities(UserData.getFrmtNumb(nmb));
                nin.setSrok(rs.getString(5));
                //System.out.println("rs.getString(6)="+rs.getString(6));
                if (!rs.getString(6).contains("03"))
                {nin.setSrok(null);};
                this.selectedNIN=nin;


            };

            if (pS != null) {
                pS.close();
            }

            if (conn != null) {
                conn.close();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        System.out.println(this.selectedNIN);
        RequestContext.getCurrentInstance().openDialog("ninV", options, null);
    }

}
