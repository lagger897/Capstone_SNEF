/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.dataform;

/**
 *
 * @author Phuc Nguyen -VN
 */
public class Message {
    private boolean result;
    private String msg;

    public Message() {
    }

    public Message(boolean result, String msg) {
        this.result = result;
        this.msg = msg;
    }

    
    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
}
