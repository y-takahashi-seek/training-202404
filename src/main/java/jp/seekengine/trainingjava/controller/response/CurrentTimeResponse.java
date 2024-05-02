package jp.seekengine.trainingjava.controller.response;

import java.io.Serializable;

/* task1 */
public record CurrentTimeResponse(
        String currentTime
) implements Serializable {}
