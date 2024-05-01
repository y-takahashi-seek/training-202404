package jp.seekengine.trainingjava.controller.response;

import java.io.Serializable;

/* task3 */
public record ConvertedTimes(
        String[] convertedTimes
) implements Serializable {}
