package model;

import common.OracleDB;
import server.ApplicationThread;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

@ManagedBean(name = "userData", eager = true)
@SessionScoped
public class UserData implements Serializable {

    private static final long serialVersionUID = 1L;

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    private String display = "display:none";

    public String getDisplay_inf_not() {
        return display_inf_not;
    }

    public void setDisplay_inf_not(String display_inf_not) {
        this.display_inf_not = display_inf_not;
    }

    private String display_inf_not = "display:none";

    public String getDisplay_inf_not2() {
        return display_inf_not2;
    }

    public void setDisplay_inf_not2(String display_inf_not2) {
        this.display_inf_not2 = display_inf_not2;
    }

    private String display_inf_not2 = "";

    public String getDisplay_inf_cnt() {
        return display_inf_cnt;
    }

    public void setDisplay_inf_cnt(String display_inf_cnt) {
        this.display_inf_cnt = display_inf_cnt;
    }

    private String display_inf_cnt = "display:none";

    public List<Tisr_non_market> getTisr_non_markets() {
        return tisr_non_markets;
    }

    private List<Tisr_non_market> tisr_non_markets;

    public String getDisplay_inf_od() {
        return display_inf_od;
    }

    public void setDisplay_inf_od(String display_inf_od) {
        this.display_inf_od = display_inf_od;
    }

    private String display_inf_od = " на последний Операционный день ";

    public String getDisplay_inf_last_od() {
        return display_inf_last_od;
    }

    public void setDisplay_inf_last_od(String display_inf_last_od) {
        this.display_inf_last_od = display_inf_last_od;
    }

    private String display_inf_last_od = " на последний Операционный день ";

    public String getDisplay_inf_period() {
        return display_inf_period;
    }

    public void setDisplay_inf_period(String display_inf_period) {
        this.display_inf_period = display_inf_period;
    }

    private String display_inf_period = "-";

    @PostConstruct
    public void init() {
        System.out.println("init=");
        //this.tisr_non_markets = new ArrayList<Tisr_non_market>();
        LastInfOD lastInfOD = getLastInfOD();

        this.tisr_non_markets = getView(lastInfOD.getOd());
        //System.out.println(" init dt1 this.tisr_non_markets.size()=" + this.tisr_non_markets.size());
        if (this.tisr_non_markets.size() != 0
                ) {
            this.display = "";
            this.display_inf_not = "display:none";
            this.display_inf_cnt = "";
        } else {
            this.display = "display:none";
            this.display_inf_not = "";
            this.display_inf_cnt = "display:none";
        }
        ;

        //System.out.println(" dt1 this.display=" + this.display);
        //System.out.println(" dt1 this.display_inf_not=" + this.display_inf_not);
        //System.out.println(" dt1 this.display_inf_cnt=" + this.display_inf_cnt);

        this.display_inf_od = " на последний незавершенный Операционный день ";
        if (lastInfOD.getStatus() == 3) {
            this.display_inf_od = " на последний завершенный Операционный день ";
        }


        this.display_inf_last_od = this.display_inf_od + " " + lastInfOD.getOd().toString() + " ";
        this.display_inf_last_od = " По состоянию " + this.display_inf_last_od + " в СВР";

        this.display_inf_od = " на ";

        //System.out.println("init  dt1 this.display_inf_od=" + this.display_inf_od);

        //ApplicationThread.init();


    }

    public void upd(Date dt1, Date dt2) {
        //System.out.println("dt1="+dt1);
        this.tisr_non_markets = getView(dt1, dt2);
        System.out.println("dt1 dt2 this.tisr_non_markets.size()=" + this.tisr_non_markets.size());
        if (this.tisr_non_markets.size() != 0
                ) {
            this.display = "";
            this.display_inf_not = "display:none";
            this.display_inf_cnt = "";
        } else {
            this.display = "display:none";
            this.display_inf_not = "";
            this.display_inf_cnt = "display:none";
        }
        ;

        //this.display_inf_not2="display:none";
        this.display_inf_last_od = "     ";

        //System.out.println(" dt1 2 this.display=" + this.display);
        //System.out.println(" dt1 2 this.display_inf_not=" + this.display_inf_not);
        //System.out.println(" dt1 2 this.display_inf_cnt=" + this.display_inf_cnt);

        this.display_inf_od = "  за период с ";

        //System.out.println("dt1 this.display_inf_od=" + this.display_inf_od);

        display_inf_period = display_inf_od;
        SimpleDateFormat dtF = new SimpleDateFormat("dd.MM.yyyy");
        display_inf_period = display_inf_od + "  " + dtF.format(dt1);
        //System.out.println(" display_inf_period1 ==" + display_inf_period);

        display_inf_period = display_inf_period + " по " + dtF.format(dt2);
        //System.out.println(" display_inf_period2 ==" + display_inf_period);
        //dt1Str = dtF.format(dt1);

    }

    public void upd(Date dt1) {
        //System.out.println("dt1="+dt1);
        this.tisr_non_markets = getView(dt1);
        System.out.println("dt1 this.tisr_non_markets.size()=" + this.tisr_non_markets.size());
        if (this.tisr_non_markets.size() != 0
                ) {
            this.display = "";
            this.display_inf_not = "display:none";
            this.display_inf_cnt = "";
        } else {
            this.display = "display:none";
            this.display_inf_not = "";
            this.display_inf_cnt = "display:none";
        }
        ;

        //this.display_inf_not2="display:none";
        this.display_inf_last_od = "                                ";

        //System.out.println(" dt1 this.display=" + this.display);
        //System.out.println(" dt1 this.display_inf_not=" + this.display_inf_not);
        //System.out.println(" dt1 this.display_inf_cnt=" + this.display_inf_cnt);

        this.display_inf_od = " на незавершенный Операционный день ";
        if (getinfOD(dt1) == 3) {
            this.display_inf_od = " на завершенный Операционный день ";
        }

        //System.out.println("dt1 this.display_inf_od=" + this.display_inf_od);

        display_inf_period = display_inf_od;
        SimpleDateFormat dtF = new SimpleDateFormat("dd.MM.yyyy");
        display_inf_period = display_inf_od + "  " + dtF.format(dt1);
        //System.out.println(" display_inf_period==" + display_inf_period);
        //dt1Str = dtF.format(dt1);


    }

    public static String getFrmtNumb(Integer nmber) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        //decimalFormat.setGroupingSize(3);
        symbols.setGroupingSeparator(' ');
        String pattern = "#,###.###";
        DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
        //System.out.println("nmber="+nmber);
        String number = decimalFormat.format(nmber);
        //System.out.println("getfmtnumb number="+number);
        return number;
    }

    public static String getFrmtLong(Long nmber) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        //decimalFormat.setGroupingSize(3);
        symbols.setGroupingSeparator(' ');
        String pattern = "#,###.###";
        DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
        //System.out.println("nmber="+nmber);
        String number = decimalFormat.format(nmber);
        //System.out.println("getfmtnumb number="+number);
        return number;
    }

    public static String getFrmtDcml(BigDecimal nmber) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        //decimalFormat.setGroupingSize(3);
        symbols.setGroupingSeparator(' ');
        String pattern = "###,###.00";
        DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
        //System.out.println("getfmt dec  Dcml nmber="+nmber);
        if (nmber == null) {
            return null;
        }
        String number = decimalFormat.format(nmber);

        //System.out.println("Dcml number="+number);
        return number;
    }


    public static String getRusCod(String engCod) {
        //System.out.println("engCod="+engCod);
        if (engCod.contains("JURRZ")) {
            //System.out.println(" ur lico   ");
            return "Юр.лицо    " + "\n" + " (резидент РК)";
        }
        if (engCod.contains("FIZRZ")) {
            return "Физ.лицо (резидент РК)";
        }
        if (engCod.contains("JURNN")) {
            return "Юр.лицо       \"+\"\\n\"+\" (нерезидент)";
        }
        if (engCod.contains("FIZNN")) {
            return "Физ.лицо (нерезидент)";
        }

        if (engCod.contains("STBNK")) {
            return "Банк второго уровня РК";
        }
        if (engCod.contains("INSOR")) {
            return "Страховая организация РК";
        }


        return engCod;
    }


    private static ArrayList<Tisr_non_market> getView(Date dt1, Date dt2) { //OOLLDD

        ArrayList<Tisr_non_market> listTisr_non_market = new ArrayList<Tisr_non_market>();

        String dt1Str;
        String dt2Str;
        //if (dt1==null){dt1Str="01/01/1000";}
        System.out.println(dt1);
        SimpleDateFormat dtF = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        dt1Str = dtF.format(dt1);

        System.out.println("222 dt1Str=" + dt1Str);
        //Date dt2 = new Date();
        //dt2.setTime(dt1.getTime() + 1 * 24 * 60 * 60 * 1000);
        dt2Str = dtF.format(dt2);

        System.out.println("dt2str=" + dt2Str);

        /*
        String SqlView="select \n" +
                "RN,ORDER_DATE,order_n,\n" +
                "p3_emitent_name_str,p3_nsin,PROD_CODE,POKUP_CODE,\n" +
                "P3_VOLUME,P3_DEAL_COST,P3_PRICE,client_id,s18_name,substr(bin1,3)\n" +
                "\n" +
                " from TISR_NON_MARKET" +
                " where order_date >= trunc(to_date('"+dt1Str+"','MM/dd/yyyy')) and order_date<trunc(to_date('"+dt2Str+"','MM/dd/yyyy'))" +
                " order by ORDER_DATE";
*/

        String SqlView = "select \n" +
                "RN,ORDER_DATE,order_n,\n" +
                "p3_emitent_name_str,p3_nsin,PROD_CODE,POKUP_CODE,\n" +
                "P3_VOLUME,P3_DEAL_COST,P3_PRICE,client_id,s18_name,substr(bin1,3),Source_\n" +
                "\n" +
                " from TISR_NON_MARKET" +
                " where order_date >= to_date('" + dt1Str + "','dd/MM/yyyy HH24:mi') " +
                " and order_date<=to_date('" + dt2Str + "','dd/MM/yyyy HH24:mi')" +
                " order by ORDER_DATE DESC ";


        System.out.println("SqlView=" + SqlView);

        Driver myDriver = new oracle.jdbc.driver.OracleDriver();
        String uRL = OracleDB.getSystemDb();
        String uSER = OracleDB.getDbUsername();
        String pASS = OracleDB.getDbPwd();

        try {
            DriverManager.registerDriver(myDriver);


            Connection conn = DriverManager.getConnection(uRL, uSER, pASS);

            PreparedStatement pS = conn.prepareStatement(SqlView);
            //pS.executeUpdate();
            ResultSet rs = pS.executeQuery(SqlView);
            System.out.println("   User SqlView.executeQ().......");
            conn.commit();
            int k = 0;

            while (rs.next()) {

                Tisr_non_market tisr_non_market = new Tisr_non_market();

                tisr_non_market.setClient_id(rs.getString(11));


                java.sql.Timestamp tmp = rs.getTimestamp(2);
                tisr_non_market.setOrder_date(tmp);
                tisr_non_market.setOrder_n(rs.getString(3));

/*
                Date dtOrder=rs.getDate(2);
                tisr_non_market.setOrder_date(dtOrder);
                tisr_non_market.setOrder_n(rs.getString(3));
*/

                BigDecimal dcml = rs.getBigDecimal(9);
                tisr_non_market.setP3_deal_cost(UserData.getFrmtDcml(dcml));

                tisr_non_market.setP3_emitent_name_str(rs.getString(4));

                tisr_non_market.setBin(rs.getString(13));

                tisr_non_market.setP3_nsin(rs.getString(5));

                /*
                Integer nmb;
                nmb=rs.getInt(10);
                tisr_non_market.setP3_price(UserData.getFrmtNumb(nmb));
                */
                dcml = rs.getBigDecimal(10);
                //System.out.println(" select dcml=" + dcml);
                tisr_non_market.setP3_price(UserData.getFrmtDcml(dcml));

                Long nmb;

                nmb = rs.getLong(8);
                tisr_non_market.setP3_volume(UserData.getFrmtLong(nmb));


                tisr_non_market.setPokup_code(getRusCod(rs.getString(7)));
                tisr_non_market.setProd_code(getRusCod(rs.getString(6)));
                tisr_non_market.setS18_name(rs.getString(12));

                if (rs.getString(14).contains("ЕРЦБ")) {
                    tisr_non_market.setSource_("учетная система ЕРЦБ");
                } else {
                    tisr_non_market.setSource_("учетная система ЦДЦБ");
                }
                k++;
                tisr_non_market.setRn(UserData.getFrmtNumb(k));

                listTisr_non_market.add(tisr_non_market);

            }
            ;
            //System.out.println("k="+k);

            if (pS != null) {
                pS.close();
            }

            if (conn != null) {
                conn.close();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("-----------");
        //System.out.println(listTisr_non_market);

        return listTisr_non_market;

    }


    private static LastInfOD getLastInfOD() {

        LastInfOD lastInfOD = new LastInfOD();
        //Integer rez=0;

        /*
        String dt1Str;
        System.out.println(dt1);
        SimpleDateFormat dtF = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        dt1Str = dtF.format(dt1);

        System.out.println("dt1Str OD=" + dt1Str);
        */

        String SqlView = "" +
                "select t.operdate,t.status from ADM_OPERDATE t \n" +
                "--where t.operdate=to_date('17/09/2015 00:00','dd/MM/yyyy HH24:mi')\n" +
                "where t.operdate in\n" +
                "\n" +
                "(select max(t2.operdate) from ADM_OPERDATE t2 where t2.status!=1)\n ";

        System.out.println("SqlView getLastInfOD=" + SqlView);

        Driver myDriver = new oracle.jdbc.driver.OracleDriver();
        String uRL = OracleDB.getSystemDb();
        String uSER = OracleDB.getDbUsername();
        String pASS = OracleDB.getDbPwd();

        try {
            DriverManager.registerDriver(myDriver);

            Connection conn = DriverManager.getConnection(uRL, uSER, pASS);

            PreparedStatement pS = conn.prepareStatement(SqlView);
            //pS.executeUpdate();
            ResultSet rs = pS.executeQuery(SqlView);
            //System.out.println("   User SqlView.executeQ().......");
            conn.commit();

            while (rs.next()) {
                lastInfOD.setOd(rs.getDate(1));
                lastInfOD.setStatus(rs.getInt(2));

            }
            ;
            //System.out.println("k="+k);

            if (pS != null) {
                pS.close();
            }

            if (conn != null) {
                conn.close();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return lastInfOD;

    }


    private static Integer getinfOD(Date dt1) {


        Integer rez = 0;

        String dt1Str;
        //if (dt1==null){dt1Str="01/01/1000";}
        //System.out.println(dt1);
        SimpleDateFormat dtF = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        dt1Str = dtF.format(dt1);

        //System.out.println("dt1Str OD=" + dt1Str);

        String SqlView = "select status from ADM_OPERDATE t " +
                " where operdate = to_date('" + dt1Str + "','dd/MM/yyyy HH24:mi') ";

        //System.out.println("SqlView OD=" + SqlView);

        Driver myDriver = new oracle.jdbc.driver.OracleDriver();
        String uRL = OracleDB.getSystemDb();
        String uSER = OracleDB.getDbUsername();
        String pASS = OracleDB.getDbPwd();

        try {
            DriverManager.registerDriver(myDriver);

            Connection conn = DriverManager.getConnection(uRL, uSER, pASS);

            PreparedStatement pS = conn.prepareStatement(SqlView);
            //pS.executeUpdate();
            ResultSet rs = pS.executeQuery(SqlView);
            //System.out.println("  OD User SqlView.executeQ().......");
            conn.commit();
            //System.out.println("-----------");
            while (rs.next()) {

                rez = rs.getInt(1);

            }
            ;
            //System.out.println("k="+k);

            if (pS != null) {
                pS.close();
            }

            if (conn != null) {
                conn.close();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        //System.out.println(" OD rez= " + rez);

        return rez;

    }


    private static ArrayList<Tisr_non_market> getView(Date dt1) {

        ArrayList<Tisr_non_market> listTisr_non_market = new ArrayList<Tisr_non_market>();

        String dt1Str;
        String dt2Str;
        //if (dt1==null){dt1Str="01/01/1000";}
        //System.out.println(dt1);
        SimpleDateFormat dtF = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        dt1Str = dtF.format(dt1);

        //System.out.println("dt1Str=" + dt1Str);
        Date dt2 = new Date();
        dt2.setTime(dt1.getTime() + 1 * 24 * 60 * 60 * 1000);
        dt2Str = dtF.format(dt2);

        //System.out.println("dt2str=" + dt2Str);

        /*
        String SqlView="select \n" +
                "RN,ORDER_DATE,order_n,\n" +
                "p3_emitent_name_str,p3_nsin,PROD_CODE,POKUP_CODE,\n" +
                "P3_VOLUME,P3_DEAL_COST,P3_PRICE,client_id,s18_name,substr(bin1,3)\n" +
                "\n" +
                " from TISR_NON_MARKET" +
                " where order_date >= trunc(to_date('"+dt1Str+"','MM/dd/yyyy')) and order_date<trunc(to_date('"+dt2Str+"','MM/dd/yyyy'))" +
                " order by ORDER_DATE";
*/

        String SqlView = "select \n" +
                "RN,ORDER_DATE,order_n,\n" +
                "p3_emitent_name_str,p3_nsin,PROD_CODE,POKUP_CODE,\n" +
                "P3_VOLUME,P3_DEAL_COST,P3_PRICE,client_id,s18_name,substr(bin1,3),source_\n" +
                "\n" +
                " from TISR_NON_MARKET" +
                " where order_date >= to_date('" + dt1Str + "','dd/MM/yyyy HH24:mi') " +
                " and order_date<=to_date('" + dt2Str + "','dd/MM/yyyy HH24:mi')" +
                " order by ORDER_DATE DESC ";


        System.out.println("SqlView=" + SqlView);

        Driver myDriver = new oracle.jdbc.driver.OracleDriver();
        String uRL = OracleDB.getSystemDb();
        String uSER = OracleDB.getDbUsername();
        String pASS = OracleDB.getDbPwd();

        try {
            DriverManager.registerDriver(myDriver);


            Connection conn = DriverManager.getConnection(uRL, uSER, pASS);

            PreparedStatement pS = conn.prepareStatement(SqlView);
            //pS.executeUpdate();
            ResultSet rs = pS.executeQuery(SqlView);
            System.out.println("   User SqlView.executeQ().......");
            conn.commit();
            int k = 0;

            while (rs.next()) {

                Tisr_non_market tisr_non_market = new Tisr_non_market();

                tisr_non_market.setClient_id(rs.getString(11));


                java.sql.Timestamp tmp = rs.getTimestamp(2);
                tisr_non_market.setOrder_date(tmp);
                tisr_non_market.setOrder_n(rs.getString(3));

/*
                Date dtOrder=rs.getDate(2);
                tisr_non_market.setOrder_date(dtOrder);
                tisr_non_market.setOrder_n(rs.getString(3));
*/

                BigDecimal dcml = rs.getBigDecimal(9);
                tisr_non_market.setP3_deal_cost(UserData.getFrmtDcml(dcml));

                tisr_non_market.setP3_emitent_name_str(rs.getString(4));

                tisr_non_market.setBin(rs.getString(13));

                tisr_non_market.setP3_nsin(rs.getString(5));

                /*
                Integer nmb;
                nmb=rs.getInt(10);
                tisr_non_market.setP3_price(UserData.getFrmtNumb(nmb));
                */
                dcml = rs.getBigDecimal(10);
                System.out.println(" select dcml=" + dcml);
                tisr_non_market.setP3_price(UserData.getFrmtDcml(dcml));

                Integer nmb;

                nmb = rs.getInt(8);
                tisr_non_market.setP3_volume(UserData.getFrmtNumb(nmb));


                tisr_non_market.setPokup_code(getRusCod(rs.getString(7)));
                tisr_non_market.setProd_code(getRusCod(rs.getString(6)));
                tisr_non_market.setS18_name(rs.getString(12));
                if (rs.getString(14).contains("ЕРЦБ")) {
                    tisr_non_market.setSource_("учетная система ЕРЦБ");
                } else {
                    tisr_non_market.setSource_("учетная система ЦДЦБ");
                }
                k++;
                tisr_non_market.setRn(UserData.getFrmtNumb(k));

                listTisr_non_market.add(tisr_non_market);

            }
            ;
            //System.out.println("k="+k);

            if (pS != null) {
                pS.close();
            }

            if (conn != null) {
                conn.close();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("-----------");
        //System.out.println(listTisr_non_market);

        return listTisr_non_market;

    }



/*
    private DataModel<Tisr_non_market> tisr_non_marketDataModel
            = new ArrayDataModel<Tisr_non_market>(tisr_non_markets);

    public DataModel<Tisr_non_market> getTisr_non_markets() {
        return tisr_non_marketDataModel;
    }
    */


    public void setDate(String date) {
        this.date = date;
    }

    private String date;

    public String getDate() {
        SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM-yyyy");
        return dt1.format(new Date());
    }

}
