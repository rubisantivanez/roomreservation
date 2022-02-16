package com.supportmeeting.roomreservation.translate;

public interface Translate<I, O> {
    I translateTo(O input);
}
