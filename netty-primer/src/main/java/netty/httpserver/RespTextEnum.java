package netty.httpserver;

/**
 * <p>
 *
 * @author liyazhou1
 * @date 2019/2/23
 */
public enum RespTextEnum {

    HTTP_200("{\"code\":200, \"success\": true, \"message\":\"request success\"}"),
    HTTP_201("{\"code\":201, \"success\": false, \"message\":\"parameter invalid\"}"),
    HTTP_202("{\"code\":202, \"success\": false, \"message\":\"token invalid\"}"),
    HTTP_203("{\"code\":203, \"success\": false, \"message\":\"expired request\"}"),
    HTTP_500("{\"code\":500, \"success\": false, \"message\":\"request failed\"}");

    private String respText;

    RespTextEnum(String respText) {
        this.respText = respText;
    }

    public String getRespText() {
        return respText;
    }

    public byte[] getRespBytes() {
        return respText.getBytes();
    }

}
