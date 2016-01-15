package model;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

import org.primefaces.model.SortOrder;
public class LazySorter implements Comparator<Tisr_non_market>  {

    private String sortField;

    private SortOrder sortOrder;

    public LazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }


    public static String getValue(String filterProperty,Tisr_non_market tisr_non_market){

        String fieldValue="";
        if (filterProperty.equals("s18_name")
                ) {

            fieldValue= String.valueOf(tisr_non_market.getS18_name());
        }
        if ( filterProperty.equals("prod_code")
                ) {

            fieldValue= String.valueOf(tisr_non_market.getProd_code());
        }
        if ( filterProperty.equals("pokup_code")
                ) {

            fieldValue= String.valueOf(tisr_non_market.getPokup_code());
        }
        if (filterProperty.equals("p3_emitent_name_str")
                ) {

            fieldValue= String.valueOf(tisr_non_market.getP3_emitent_name_str());
        }
        if ( filterProperty.equals("bin")
                ) {

            fieldValue= String.valueOf(tisr_non_market.getBin());
        }
        if ( filterProperty.equals("p3_nsin")
                ) {

            fieldValue= String.valueOf(tisr_non_market.getP3_nsin());
        }
        if ( filterProperty.equals("source_")
                ) {

            fieldValue= String.valueOf(tisr_non_market.getSource_());
        }
        if ( filterProperty.equals("p3_volume")
                ) {

            fieldValue= String.valueOf(tisr_non_market.getP3_volume());
        }
        if ( filterProperty.equals("p3_price")
                ) {

            fieldValue= String.valueOf(tisr_non_market.getP3_price());
        }
        if ( filterProperty.equals("order_date")
                ) {

            fieldValue= String.valueOf(tisr_non_market.getOrder_date());
        }
        if ( filterProperty.equals("p3_deal_cost")
                ) {

            fieldValue= String.valueOf(tisr_non_market.getP3_deal_cost());
        }


        return fieldValue;
    }


    public int compare(Tisr_non_market tisr_non_market1, Tisr_non_market tisr_non_market2) {
        try {
            String str=" ";

            Object value1 = LazySorter.getValue(this.sortField,tisr_non_market1);
            System.out.println(" value1.toString()="+value1.toString());
            Object value2 = LazySorter.getValue(this.sortField, tisr_non_market2);
            System.out.println(" value2.toString()="+value2.toString());

            /*
            Object value1 = Tisr_non_market.class.getField(this.sortField).get(tisr_non_market1);
            System.out.println(" value1.toString()="+value1.toString());
            Object value2 = Tisr_non_market.class.getField(this.sortField).get(tisr_non_market2);
            */

            int value = ((Comparable)value1).compareTo(value2);
            if (sortField.equals("order_date")) {

                SimpleDateFormat dtF = new SimpleDateFormat("dd.MM.yyyy");
                Date dtValue1=dtF.parse(value1.toString());
                Date dtValue2=dtF.parse(value2.toString());
                value=dtValue1.compareTo(dtValue2);
            }

            //p3_volume
            if (sortField.equals("p3_volume")
                    ||sortField.equals("p3_price")
                    ||sortField.equals("p3_deal_cost")
                    ) {

                DecimalFormat df = (DecimalFormat) NumberFormat.getInstance(Locale.ENGLISH);
                df.setParseBigDecimal(true);
                if (value1==null|value1.toString().equals("null")|value1.toString().equals("")){

                    value1=value1.toString().replaceAll("null","")+"0";}
                if (value2==null|value2.toString().equals("null")|value2.toString().equals("")){

                    value2=value2.toString().replaceAll("null","")+"0";}

                BigDecimal dblValue1 = (BigDecimal) df.parseObject(value1.toString().replaceAll(" ", ""));

                BigDecimal dblValue2 = (BigDecimal) df.parseObject(value2.toString().replaceAll(" ", ""));
                value=dblValue1.compareTo(dblValue2);

            }


            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch(Exception e) {
            throw new RuntimeException();
        }
    }
}
