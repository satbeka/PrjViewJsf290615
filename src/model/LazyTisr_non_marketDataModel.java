package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
public class LazyTisr_non_marketDataModel  extends LazyDataModel<Tisr_non_market> {

    private List<Tisr_non_market> datasource;

    public LazyTisr_non_marketDataModel(List<Tisr_non_market> datasource) {
        this.datasource = datasource;
    }

    @Override
    public Tisr_non_market getRowData(String rowKey) {
        for (Tisr_non_market tisr_non_market : datasource) {
            if (tisr_non_market.getRn().equals(rowKey))
                return tisr_non_market;
        }

        return null;
    }

    @Override
    public Object getRowKey(Tisr_non_market tisr_non_market) {
        return tisr_non_market.getRn();
    }

    @Override
    public List<Tisr_non_market> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        List<Tisr_non_market> data = new ArrayList<Tisr_non_market>();

        //filter
        for (Tisr_non_market tisr_non_market : datasource) {
            boolean match = true;

            if (filters != null) {
                for (Iterator<String> it = filters.keySet().iterator(); it.hasNext(); ) {
                    try {
                        String filterProperty = it.next();
                        System.out.println("filterProperty=" + filterProperty);
                        Object filterValue = filters.get(filterProperty);

                        /*
                        System.out.println(filterProperty.substring(0,1).toUpperCase());
                        System.out.println(filterProperty.substring(1));

                        String filterPropertyUpper=filterProperty.substring(0,1).toUpperCase()+filterProperty.substring(1);
                        String fieldValue = String.valueOf(tisr_non_market.getClass().getField(filterPropertyUpper).get(tisr_non_market));
                        */

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


                        System.out.println("fieldValue=" + fieldValue);
                        System.out.println("filterValue.toString()=" + filterValue.toString());

                        if (filterProperty.equals("s18_name") || filterProperty.equals("prod_code")
                                || filterProperty.equals("pokup_code")
                                ) {
                            if (filterValue == null || fieldValue.startsWith(filterValue.toString())) {
                                System.out.println("match = true;");
                                match = true;
                            } else {
                                match = false;
                                break;
                            }
                        }


                        //filterMatchMode="contains"
                        if (filterProperty.equals("p3_emitent_name_str") || filterProperty.equals("bin")
                                || filterProperty.equals("p3_nsin")|| filterProperty.equals("source_")
                                ) {
                            if (filterValue == null || fieldValue.contains(filterValue.toString())) {
                                System.out.println("match = true;");
                                match = true;
                            } else {
                                match = false;
                                break;
                            }
                        }


                    }catch(Exception e){
                            match = false;

                    }
                }
            }

            if (match) {
                data.add(tisr_non_market);
            }
        }

        //sort
    System.out.println("sortField="+sortField);
    System.out.println("sortOrder="+sortOrder);

        if (sortField != null) {
            Collections.sort(data, new LazySorter(sortField, sortOrder));
        }

        //rowCount
        int dataSize = data.size();
        this.setRowCount(dataSize);

        //paginate
        if (dataSize > pageSize) {
            try {
                return data.subList(first, first + pageSize);
            } catch (IndexOutOfBoundsException e) {
                return data.subList(first, first + (dataSize % pageSize));
            }
        } else {
            return data;
        }
    }
}
