package jp.seekengine.trainingjava.controller.response;

import java.io.Serializable;

/* task2 */
public record ConvertedTimeResponse(
        String convertedTimes
) implements Serializable {}
