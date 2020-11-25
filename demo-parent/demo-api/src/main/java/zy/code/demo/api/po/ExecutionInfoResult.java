package zy.code.demo.api.po;

import java.util.Date;

public class ExecutionInfoResult {
    private Long id;

    private Long instId;

    private Long toolId;

    private Long instToolInputId;

    private String toolName;

    private String param;

    private String cmd;

    private String executor;

    private String api;

    private String result;

    private Date time;

    public ExecutionInfoResult(Long id, Long instId, Long toolId, Long instToolInputId, String toolName, String param, String cmd, String executor, String api, String result, Date time) {
        this.id = id;
        this.instId = instId;
        this.toolId = toolId;
        this.instToolInputId = instToolInputId;
        this.toolName = toolName;
        this.param = param;
        this.cmd = cmd;
        this.executor = executor;
        this.api = api;
        this.result = result;
        this.time = time;
    }

    public ExecutionInfoResult() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInstId() {
        return instId;
    }

    public void setInstId(Long instId) {
        this.instId = instId;
    }

    public Long getToolId() {
        return toolId;
    }

    public void setToolId(Long toolId) {
        this.toolId = toolId;
    }

    public Long getInstToolInputId() {
        return instToolInputId;
    }

    public void setInstToolInputId(Long instToolInputId) {
        this.instToolInputId = instToolInputId;
    }

    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName == null ? null : toolName.trim();
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param == null ? null : param.trim();
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd == null ? null : cmd.trim();
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor == null ? null : executor.trim();
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api == null ? null : api.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}