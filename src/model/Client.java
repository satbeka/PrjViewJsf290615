package model;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {


    public String getA1_cl_type() {
        return a1_cl_type;
    }

    public void setA1_cl_type(String a1_cl_type) {
        this.a1_cl_type = a1_cl_type;
    }

    public String getA1_status() {
        return a1_status;
    }

    public void setA1_status(String a1_status) {
        this.a1_status = a1_status;
    }

    public String getA1_cl_lastname() {
        return a1_cl_lastname;
    }

    public void setA1_cl_lastname(String a1_cl_lastname) {
        this.a1_cl_lastname = a1_cl_lastname;
    }

    public String getA1_cl_firstname() {
        return a1_cl_firstname;
    }

    public void setA1_cl_firstname(String a1_cl_firstname) {
        this.a1_cl_firstname = a1_cl_firstname;
    }

    public String getA1_cl_middlename() {
        return a1_cl_middlename;
    }

    public void setA1_cl_middlename(String a1_cl_middlename) {
        this.a1_cl_middlename = a1_cl_middlename;
    }

    public String getA1_cl_fullname() {
        return a1_cl_fullname;
    }

    public void setA1_cl_fullname(String a1_cl_fullname) {
        this.a1_cl_fullname = a1_cl_fullname;
    }

    public String getA1_born() {
        return a1_born;
    }

    public void setA1_born(String a1_born) {
        this.a1_born = a1_born;
    }
    public void setA1_born(Date a1_born) {
        if (a1_born==null){this.a1_born=null;return;}
        SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM-yyyy");
        this.a1_born = dt1.format(a1_born);
    }
    public String getA1_cl_status() {
        return a1_cl_status;
    }

    public void setA1_cl_status(String a1_cl_status) {
        this.a1_cl_status = a1_cl_status;
    }

    public String getA1_rnn() {
        return a1_rnn;
    }

    public void setA1_rnn(String a1_rnn) {
        this.a1_rnn = a1_rnn;
    }

    public String getA1_idn() {
        return a1_idn;
    }

    public void setA1_idn(String a1_idn) {
        this.a1_idn = a1_idn;
    }

    public String getA1_country() {
        return a1_country;
    }

    public void setA1_country(String a1_country) {
        this.a1_country = a1_country;
    }

    public String getA1_j_address() {
        return a1_j_address;
    }

    public void setA1_j_address(String a1_j_address) {
        this.a1_j_address = a1_j_address;
    }

    public String getA1_phone1() {
        return a1_phone1;
    }

    public void setA1_phone1(String a1_phone1) {
        this.a1_phone1 = a1_phone1;
    }

    public String getA1_addr_email() {
        return a1_addr_email;
    }

    public void setA1_addr_email(String a1_addr_email) {
        this.a1_addr_email = a1_addr_email;
    }

    public String getA1_open_date() {
        return a1_open_date;
    }

    public void setA1_open_date(Date a1_open_date) {
        if (a1_open_date==null){this.a1_open_date=null;return;}
            SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM-yyyy");
            this.a1_open_date = dt1.format(a1_open_date);

    }

    public String getA1_close_date() {
        return a1_close_date;
    }

    public void setA1_close_date(Date a1_close_date) {
        if (a1_close_date==null){this.a1_close_date=null;return;}
        SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM-yyyy");
        this.a1_close_date = dt1.format(a1_close_date);

    }


    public String getA1_resident() {
        return a1_resident;
    }

    public void setA1_resident(String a1_resident) {
        this.a1_resident = a1_resident;
    }

    private String a1_cl_type;
    //is 'Тип клиента';
    private String a1_status;
    //is 'Статус счета';
    private String a1_cl_lastname;
    //is 'Фамилия';
    private String a1_cl_firstname;
    //is 'Имя';
    private String a1_cl_middlename;
    //is 'Отчество/главный бухгалтер';
    private String a1_cl_fullname;

    public String getA1_cl_doc_nom() {
        return a1_cl_doc_nom;
    }

    public void setA1_cl_doc_nom(String a1_cl_doc_nom) {
        this.a1_cl_doc_nom = a1_cl_doc_nom;
    }

    public String getA1_cl_doc_dat() {
        return a1_cl_doc_dat;
    }

    public void setA1_cl_doc_dat(String a1_cl_doc_dat) {
        this.a1_cl_doc_dat = a1_cl_doc_dat;
    }

    public void setA1_cl_doc_dat(Date a1_cl_doc_dat) {

        if (a1_cl_doc_dat==null){this.a1_cl_doc_dat=null;return;}
        SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM-yyyy");
        this.a1_cl_doc_dat = dt1.format(a1_cl_doc_dat);

    }

    public void setA1_open_date(String a1_open_date) {
        this.a1_open_date = a1_open_date;
    }

    public void setA1_close_date(String a1_close_date) {
        this.a1_close_date = a1_close_date;
    }

    //is 'Полное наименование';
    /*comment on column D_A1_CLIENTS.a1_accountant
    is 'Главный бухгалтер';
    comment on column D_A1_CLIENTS.a1_chief
    is 'Руководитель';
    comment on column D_A1_CLIENTS.a1_cl_doc_typ
    is 'Тип документа';
    comment on column D_A1_CLIENTS.a1_cl_doc_ser
    is 'Серия документа';
    comment on column D_A1_CLIENTS.a1_cl_doc_nom
    is 'Номер документа';
    comment on column D_A1_CLIENTS.a1_cl_doc_dat
    is 'Дата выдачи документа';
    comment on column D_A1_CLIENTS.a1_cl_doc_reg
    is 'Орган регистрации документа';
    */
    private String a1_cl_doc_nom;
    //is 'Номер документа';
    private String a1_cl_doc_dat;
    //is 'Дата выдачи документа';
    private String a1_born;
    //is 'Дата рождения';
    private String a1_cl_status;
    //is 'Орг форма';
    private String a1_rnn;
    //is 'РНН ';
    private String a1_idn;
    //is 'ИИН/БИН';
    /*
    comment on column D_A1_CLIENTS.a1_okpo
    is 'Код ОКПО';
    comment on column D_A1_CLIENTS.a1_prof_type
    is 'Тип деятельности (лицензии) профучастника';
    comment on column D_A1_CLIENTS.a1_prof_code
    is 'Код деятельности профучастника';
    */
    private String a1_country;
    //is 'Код страны';
    /*
    comment on column D_A1_CLIENTS.a1_p_country
    is 'Код страны (для почтового адреса) ';
    comment on column D_A1_CLIENTS.a1_p_index
    is 'Индекс (для почтового адреса)';
    comment on column D_A1_CLIENTS.a1_p_region
    is 'Код региона  (для почтового адреса)';
    comment on column D_A1_CLIENTS.a1_p_address
    is 'Почтовый адрес';
    comment on column D_A1_CLIENTS.a1_j_country
    is 'Код страны (для юридического адреса)  ';
    comment on column D_A1_CLIENTS.a1_j_index
    is 'Индекс (для юридического адреса)';
    comment on column D_A1_CLIENTS.a1_j_region
    is 'Код региона (для юридического адреса)';
    */
    private String a1_j_address;
    //is 'Юридический адрес';
    private String a1_phone1;
    //is 'Номер телефона';
    /*
    comment on column D_A1_CLIENTS.a1_phone2
    is 'Номер телефона';
    comment on column D_A1_CLIENTS.a1_fax
    is 'Номер факса';
    */
    private String a1_addr_email;
    //is 'Адрес электронной почты';
    /*
    comment on column D_A1_CLIENTS.a1_bank_name
    is 'Банк';
    comment on column D_A1_CLIENTS.a1_bank_mfo
    is 'БИН';
    comment on column D_A1_CLIENTS.a1_bank_code
    is 'Код банка';
    comment on column D_A1_CLIENTS.a1_b_account
    is 'Номер счета в банке';
    comment on column D_A1_CLIENTS.a1_bank_info
    is 'Дополнительная банковская информация';
    comment on column D_A1_CLIENTS.a1_tmemo
    is 'Дополнительная информация ';
    comment on column D_A1_CLIENTS.a1_state_rep_pr
    is 'Признак представителя государства';
    comment on column D_A1_CLIENTS.a1_uc_accountsys
    is 'Номер счета управляющей компании ';
    comment on column D_A1_CLIENTS.a1_uc_name1
    is 'Наименование управляющей компании ';
    comment on column D_A1_CLIENTS.a1_uc_doc_typ
    is 'Тип документа управляющей компании';

    comment on column D_A1_CLIENTS.a1_cs_accountsys
    is 'Номер счета кастодиана ';
    comment on column D_A1_CLIENTS.a1_cs_name1
    is 'Кастодиан';
    comment on column D_A1_CLIENTS.a1_cs_doc_typ
    is 'Тип документа кастодиана';
    comment on column D_A1_CLIENTS.a1_cs_doc_nom
    is 'Номер документа кастодиана';
    comment on column D_A1_CLIENTS.a1_er_doc_typ
    is 'Тип ошибочного документа';
    comment on column D_A1_CLIENTS.a1_er_doc_ser
    is 'Серия ошибочного документа';
    comment on column D_A1_CLIENTS.a1_er_doc_nom
    is 'Номер ошибочного документа';
    comment on column D_A1_CLIENTS.a1_er_doc_dat
    is 'Дата выдачи ошибочного документа';
    comment on column D_A1_CLIENTS.a1_er_doc_reg
    is 'Орган регистрации ошибочного документа';
    comment on column D_A1_CLIENTS.a1_er_okpo
    is 'Код ошибочного ОКПО';
    */
    private String a1_open_date;
    //is 'Дата открытия';
    private  String a1_close_date;
    //is 'Дата закрытия';
    /*
    comment on column D_A1_CLIENTS.a1_last_order
    is 'Приказ на последние изменения';
    comment on column D_A1_CLIENTS.a1_uc_id
    is 'ID управляющей компании';
    comment on column D_A1_CLIENTS.a1_cs_id
    is 'ID кастоди';
    comment on column D_A1_CLIENTS.a1_cl_doc_end
    is 'Дата действия документа';
    comment on column D_A1_CLIENTS.a1_rec_fullname
    is 'Полное наименование получателя';
    comment on column D_A1_CLIENTS.a1_rec_idn
    is 'ИИН/БИН получателя';
    comment on column D_A1_CLIENTS.a1_privilege_detail
    is 'Сведения о налоговых льготах';
    comment on column D_A1_CLIENTS.a1_privilege_code
    is 'Льготная категория';
    */
    private String a1_resident;

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    /** 'Резидент';
    /*
    comment on column D_A1_CLIENTS.a1_website
    is 'Веб сайт клиента';
    comment on column D_A1_CLIENTS.a1_uc_doc_dat
    is 'Дата государственной регистрации управляющей компании';
    comment on column D_A1_CLIENTS.a1_oked
    is 'ОКЕД';
    comment on column D_A1_CLIENTS.a1_oked_lic
    is 'Наличие лицензии по ОКЕД';
    comment on column D_A1_CLIENTS.a1_cl_doc_dat_first
    is 'Дата первичной регистрации';
    comment on column D_A1_CLIENTS.a1_qual_investor
    is 'квалифицированный инвестор';
    comment on column D_A1_CLIENTS.a1_invest_fund_risk
    is 'Сведение о том, что он является инвестиционным фондом рискового инвестирования';
    comment on column D_A1_CLIENTS.a1_incapacitated
    is 'Недееспособность физического лица';
    comment on column D_A1_CLIENTS.a1_subsoil
    is 'Клиенты, обладающие правами на недропользование';
    comment on column D_A1_CLIENTS.a1_is_monopoly
    is 'Товарищесто, занимающее доминирующее или монопольное положение';
    comment on column D_A1_CLIENTS.a1_is_strategic
    is 'Товарищеста, являющийся стратегическими объектами, переданных в уставный капитал и (или) находящихся в собственности национальных холдингов и (или) национальных компаний...';
    comment on column D_A1_CLIENTS.s29_id
    is 'ID Офшорной зоны';
    comment on column D_A1_CLIENTS.a1_ao_id
    is 'ID аудиторской организации';
    comment on column D_A1_CLIENTS.a1_ao_name1
    is 'Наименование аудиторской организации';
    comment on column D_A1_CLIENTS.a1_ao_accountsys
    is 'Номер счета аудиторской организации';
    comment on column D_A1_CLIENTS.a1_ao_doc_typ
    is 'Тип документа аудиторской организации';
    comment on column D_A1_CLIENTS.a1_ao_doc_nom
    is 'Номер документа аудиторской организации';
    */
private String client_id;

}
