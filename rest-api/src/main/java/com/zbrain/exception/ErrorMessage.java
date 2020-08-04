package com.zbrain.exception;

public class ErrorMessage {
    private boolean duplicate;

    public ErrorMessage(boolean duplicate) {
        this.duplicate = duplicate;
    }

    public boolean isDuplicate() {
        return duplicate;
    }

    public void setDuplicate(boolean duplicate) {
        this.duplicate = duplicate;
    }
}
