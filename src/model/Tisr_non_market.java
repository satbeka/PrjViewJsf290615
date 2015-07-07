package model;


import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Tisr_non_market {

    public Tisr_non_market() {

    }

    public String getRn() {
        return rn;
    }

    public void setRn(String rn) {
        this.rn = rn;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }
    public void setOrder_date(Date order_date) {
        if (order_date==null){this.order_date=null;return;}
        SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM-yyyy");
        this.order_date = dt1.format(order_date);
            }

    public String getOrder_n() {
        return order_n;
    }

    public void setOrder_n(String order_n) {
        this.order_n = order_n;
    }

    public String getP3_emitent_name_str() {
        return p3_emitent_name_str;
    }

    public void setP3_emitent_name_str(String p3_emitent_name_str) {
        this.p3_emitent_name_str = p3_emitent_name_str;
    }

    public String getP3_nsin() {
        return p3_nsin;
    }

    public void setP3_nsin(String p3_nsin) {
        this.p3_nsin = p3_nsin;
    }

    public String getProd_code() {
        return prod_code;
    }

    public void setProd_code(String prod_code) {
        this.prod_code = prod_code;
    }

    public String getPokup_code() {
        return pokup_code;
    }

    public void setPokup_code(String pokup_code) {
        this.pokup_code = pokup_code;
    }

    public String getP3_volume() {
        return p3_volume;
    }

    public void setP3_volume(String p3_volume) {

        this.p3_volume = p3_volume;
    }

    public String getP3_deal_cost() {
        return p3_deal_cost;
    }

    public void setP3_deal_cost(String p3_deal_cost) {
        this.p3_deal_cost = p3_deal_cost;
    }

    public String getP3_price() {
        return p3_price;
    }

    public void setP3_price(String p3_price) {
        this.p3_price = p3_price;
    }

    String rn;
    String order_date;
    String order_n;
    String p3_emitent_name_str;
    String p3_nsin;
    String prod_code;
    String pokup_code;
    String p3_volume;
    String p3_deal_cost;
    String p3_price;

    public String getS18_name() {
        return s18_name;
    }

    public void setS18_name(String s18_name) {
        this.s18_name = s18_name;
    }

    String s18_name;

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    String client_id;

    public Tisr_non_market(String rn,
                           String order_date,
                           String order_n,
                           String p3_emitent_name_str,
                           String p3_nsin,
                           String prod_code,
                           String pokup_code,
                           String p3_volume,
                           String p3_deal_cost,
                           String p3_price,
                           String client_id,
    String s18_name) {

        this.rn=rn;
                this.order_date =order_date;
                this.order_n =order_n;
                this.p3_emitent_name_str =p3_emitent_name_str;
                this.p3_nsin =p3_nsin;
                this.prod_code =prod_code;
                this.pokup_code =pokup_code;
                this.p3_volume =p3_volume;
                this.p3_deal_cost =p3_deal_cost;
                this.p3_price =p3_price;
        this.client_id =client_id;
        this.s18_name=s18_name;

    }


    /*
        rownum RN,
        to_date( t.P3_ORDER_DATE ,'dd.mm.rrrr' ) ORDER_DATE,t.order_n,

                (SELECT a1_cl_fullname || nvl2(d25.a1_idn,  ' - ' ||d25.a1_idn,'')
        FROM d_a1_clients d25
        WHERE t.p3_emitent_name = d25.a1_id) AS p3_emitent_name_str

        ,t.p3_nsin ,
                decode(t.P3_OWN_TYPE,'J', 'JURRZ','F',  'FIZRZ') PROD_CODE,
                decode(t.P3_CA_TYPE,'J', 'JURRZ','F',  'FIZRZ') POKUP_CODE,
                t.P3_VOLUME,t.P3_DEAL_COST , t.P3_PRICE

        from V_D_P3_ORDER_STOCK t where 1=1
        and t.P3_STATUS=0
        and ( t.P3_TYPE_DEAL_STR='Купля/Продажа' and t.P3_ORDER_TYPE_STR='Приказ на списание ценных бумаг / права требования')
        ;
*/


}
