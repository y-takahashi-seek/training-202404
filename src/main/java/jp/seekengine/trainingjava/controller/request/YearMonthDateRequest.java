package jp.seekengine.trainingjava.controller.request;

import java.io.Serializable;

public record YearMonthDateRequest(
        int year,
        int month,
        int date,
        int hour,
        int minute,
        int second
) implements Serializable {}
