package jp.seekengine.trainingjava.controller.request;

import java.io.Serializable;

public record ArrayTimes(
        int[] times
)implements Serializable {}
