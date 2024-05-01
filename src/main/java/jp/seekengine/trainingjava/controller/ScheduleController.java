package jp.seekengine.trainingjava.controller;

import jp.seekengine.trainingjava.controller.request.ArrayTimes;
import jp.seekengine.trainingjava.controller.request.YearMonthDateRequest;
import jp.seekengine.trainingjava.controller.response.ConvertedTimeResponse;
import jp.seekengine.trainingjava.controller.response.ConvertedTimes;
import jp.seekengine.trainingjava.controller.response.CurrentTimeResponse;
import jp.seekengine.trainingjava.domain.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.DateTimeFormatter;
import java.time.*;


@RestController
public class ScheduleController {

//    private final ScheduleService scheduleService;

//    @Autowired
//    public ScheduleController(ScheduleService scheduleService) {
//        this.scheduleService = scheduleService;
//    }

//    @GetMapping("/sample")
//    public SampleResponse sample(@RequestBody SampleRequest sampleRequest) {
//        String message = scheduleService.createSampleMessage(sampleRequest.sampleField1(), sampleRequest.sampleField2());
//        return new SampleResponse(message);
//    }

    /*
     * Task1 現在時刻を返却するAPIの作成
     */
    @GetMapping("/task1")
    public CurrentTimeResponse getTime(){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss");
        LocalDateTime ldt = LocalDateTime.now();
        String times = ldt.format(formatter)+ZoneOffset.ofHours(9);

        return new CurrentTimeResponse(times);
    }

    /*
     * Task 2 時刻を変換するAPIの作成
     */
    @GetMapping("/task2")
    public ConvertedTimeResponse convertedTime() {

        YearMonthDateRequest ymdr = new YearMonthDateRequest(2023,10,13,14,30,45);
        int year = ymdr.year();
        int month = ymdr.month();
        int date = ymdr.date();
        int hour = ymdr.hour();
        int minute = ymdr.minute();
        int second = ymdr.second();
        StringBuilder times = new StringBuilder();
        times.append(year);
        times.append("-");
        times.append(month);
        times.append("-");
        times.append(date);
        times.append("T");
        times.append(hour);
        times.append(":");
        times.append(minute);
        times.append(":");
        times.append(second);

        return new ConvertedTimeResponse(new String(times)+ZoneOffset.ofHours(9));
    }

    /*
     * Task3 時刻のリストを変換するAPIの作成
     */
    @GetMapping("/task3")
    public ConvertedTimes convertedArrayTime() {

        ArrayTimes at = new ArrayTimes(new int[]{2023,10,13,14,30,45});
        ArrayTimes bt = new ArrayTimes(new int[]{2023,11,20,10,15,5});

        String[][] ct = new String[2][];
        ct[0] = new String[6];
        ct[1] = new String[6];
        for(int j=0;j<bt.times().length;j++){
            for(int i=0;i < at.times().length;i++){
                if(j==0){
                    ct[j][i] = String.valueOf(at.times()[i]);
                }else if(j==1){
                    ct[j][i] = String.valueOf(bt.times()[i]);
                }else{
                    break;
                }
            }
        }
        String[] dt = new String[2];
        StringBuilder times = new StringBuilder();
        for(int l=0;l<ct.length;l++){
            if (l<2){
                for(int k=0;k<ct[0].length;k++){
                    times.append(ct[l][k]);
                    if (k<2){
                        times.append("-");
                    }else if (k==2){
                        times.append("T");
                    }else if (k<5){
                        times.append(":");
                    }else{
                        times.append(ZoneOffset.ofHours(9));
                    }
                }
            }else{
                break;
            }
            dt[l] = String.valueOf(times);
            times = new StringBuilder();
        }
        return new ConvertedTimes(dt);
    }

}
