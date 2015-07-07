package model;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@ManagedBean(name = "userData", eager = true)
@ApplicationScoped
public class UserData implements Serializable {

    private static final long serialVersionUID = 1L;

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    private String display="display:none";

    public List<Tisr_non_market> getTisr_non_markets() {
        return tisr_non_markets;
    }

    private List<Tisr_non_market> tisr_non_markets;

    @PostConstruct
    public void init() {
        System.out.println("init=");
        this.tisr_non_markets = new ArrayList<Tisr_non_market>();
    }

    public void upd(Date dt1,Date dt2) {
        System.out.println("dt1="+dt1);
        System.out.println("dt2="+dt2);
        this.tisr_non_markets = getView(dt1,dt2);
        System.out.println("this.tisr_non_markets.size()="+this.tisr_non_markets.size());
        if (this.tisr_non_markets.size()!=0
        ){this.display="";}
        else {this.display="display:none";};
    }

    public static String getFrmtNumb(Integer nmber){
        DecimalFormatSymbols symbols  = new DecimalFormatSymbols(Locale.getDefault());
        //decimalFormat.setGroupingSize(3);
        symbols.setGroupingSeparator(' ');
        String pattern = "#,###.###";
        DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
        System.out.println("nmber="+nmber);
        String number = decimalFormat.format(nmber);
        System.out.println("number="+number);
        return number;
    }

    public static String getFrmtDcml(BigDecimal nmber){
        DecimalFormatSymbols symbols  = new DecimalFormatSymbols(Locale.getDefault());
        //decimalFormat.setGroupingSize(3);
        symbols.setGroupingSeparator(' ');
        String pattern = "###,###.00";
        DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
        System.out.println("Dcml nmber="+nmber);
        if (nmber==null){
            return null;}
        String number = decimalFormat.format(nmber);

        System.out.println("Dcml number="+number);
        return number;
    }


    private static ArrayList<Tisr_non_market> getView(Date dt1,Date dt2){

        ArrayList<Tisr_non_market> listTisr_non_market = new ArrayList<Tisr_non_market>();

        String dt1Str;String dt2Str;
        if (dt1==null){dt1Str="01/01/1000";}
        SimpleDateFormat dtF = new SimpleDateFormat("MM/dd/yyyy");
        dt1Str = dtF.format(dt1);

        if (dt2==null){dt2Str="01/01/3000";}
        dt2Str = dtF.format(dt2);

        String SqlView="select \n" +
                "RN,ORDER_DATE,order_n,\n" +
                "p3_emitent_name_str,p3_nsin,PROD_CODE,POKUP_CODE,\n" +
                "P3_VOLUME,P3_DEAL_COST,P3_PRICE,client_id,s18_name\n" +
                "\n" +
                " from TISR_NON_MARKET" +
                " where order_date between to_date('"+dt1Str+"','MM/dd/yyyy') and to_date('"+dt2Str+"','MM/dd/yyyy')";

        Driver myDriver = new oracle.jdbc.driver.OracleDriver();
        try {
            DriverManager.registerDriver(myDriver);

            String URL = "jdbc:oracle:thin:@ala-srv-db-tst1.tisr.kz:1521:Test01";
            String USER = "ercb";
            String PASS = "ercb";
            Connection conn = DriverManager.getConnection(URL, USER, PASS);

            PreparedStatement pS=conn.prepareStatement(SqlView);
            //pS.executeUpdate();
            ResultSet rs = pS.executeQuery(SqlView);
            System.out.println("   User SqlView.executeQ().......");
            conn.commit();
            int k=0;
            while (rs.next()) {

                Tisr_non_market tisr_non_market=new Tisr_non_market();

                tisr_non_market.setClient_id(rs.getString(11));
                tisr_non_market.setOrder_date(rs.getDate(2));
                tisr_non_market.setOrder_n(rs.getString(3));

                BigDecimal dcml=rs.getBigDecimal(9);
                tisr_non_market.setP3_deal_cost(UserData.getFrmtDcml(dcml));

                tisr_non_market.setP3_emitent_name_str(rs.getString(4));
                tisr_non_market.setP3_nsin(rs.getString(5));

                Integer nmb;
                nmb=rs.getInt(10);
                tisr_non_market.setP3_price(UserData.getFrmtNumb(nmb));

                nmb=rs.getInt(8);
                tisr_non_market.setP3_volume(UserData.getFrmtNumb(nmb));


                tisr_non_market.setPokup_code(rs.getString(7));
                tisr_non_market.setProd_code(rs.getString(6));
                tisr_non_market.setS18_name(rs.getString(12));
                k++;
                tisr_non_market.setRn(String.valueOf(k));

                listTisr_non_market.add(tisr_non_market);

            };
            System.out.println("k="+k);

            if (pS != null) {
                pS.close();
            }

            if (conn != null) {
                conn.close();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


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
