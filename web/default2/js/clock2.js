var d=new Array();
for(i=0;10 > i;i++) {
    d[i]=new Image();
    d[i].src='default2/img/dgt'+i+'.gif';
}
var pm=new Image;
pm.src='default2/img/dgtp.gif';
var am=new Image;
am.src='default2/img/dgta.gif';
var dates,min,sec,hour;
var amPM='am';

function clock() {
    dates=new Date();
    hour=dates.getHours();
    min=dates.getMinutes();
    sec=dates.getSeconds();
    if(hour < 12) {
        amPM=am.src;
    }
    if(11 < hour) {
        amPM=pm.src;
        hour=hour-12;
    }
    if(hour == 0) {
        hour=12;
    }
    if(hour < 10) {
        document['tensHour'].src='default2/img/dgtbl.gif';
        document['Hour'].src=d[hour].src;
    }
    if(hour > 9) {
        document['tensHour'].src=d[1].src;
        document['Hour'].src=d[hour-10].src;
    }
    if(min < 10) {
        document['tensMin'].src=d[0].src;
    }
    if(min > 9) {
        document['tensMin'].src=d[parseInt(min/10,10)].src;
    }
    document['Min'].src=d[min%10].src;
    if(sec < 10) {
        document['tensSec'].src=d[0].src;
    }
    if(sec > 9) {
        document['tensSec'].src=d[parseInt(sec/10,10)].src;
    }
    document['Sec'].src=d[sec%10].src;
    document['amPM'].src=amPM;
    setTimeout('clock();',100);
}
