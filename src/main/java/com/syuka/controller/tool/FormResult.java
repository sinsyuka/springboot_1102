package com.syuka.controller.tool;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * -格式规范
 */
@JsonInclude(value=Include.NON_NULL)//设置显示不为空
public class FormResult {

	private boolean status;
	private String error;
	private Object data;
	private Map<String,String> fieldErrors;
	private String token;
	private Set<String> accessUrls;
	private String code;
	private String state;

	public FormResult(boolean status, String token, Object data) {
		this.status = status;
		this.token = token;
		this.data = data;
	}

    public FormResult(boolean status, String code, String state) {
        this.status = status;
        this.code = code;
        this.state = state;
    }

    public FormResult(boolean status, Object data) {//返回正确数据
		this.status = status;
		this.data = data;
	}
	public FormResult(String error, String filed) {
		this.error = error;
		addFiledError(filed,error);
	}
	private void addFiledError(String filed, String error) {
		if(fieldErrors==null){//如果为空创建一个对象
			fieldErrors=new HashMap<>();
		}
		fieldErrors.put(filed, error);//将消息添加进去
	}
	public FormResult(String error) {//用于显示错误消息
		this.error = error;
	}
	public FormResult(boolean status) {
		this.status = status;
	}
	public FormResult(List<FieldError> fieldErrors2) {
		for(FieldError fe : fieldErrors2){//遍历这个返回错误
			addFiledError(fe.getField(), fe.getDefaultMessage());
		}
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getError() {
		return error==null&&fieldErrors!=null&&!fieldErrors.isEmpty()
				?fieldErrors.values().iterator().next()
				:error;
	}
	public void setError(String error) {
		this.error = error;
	}

	public Map<String, String> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(Map<String, String> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}

	public Object getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Set<String> getAccessUrls() {
		return accessUrls;
	}

	public void setAccessUrls(Set<String> accessUrls) {
		this.accessUrls = accessUrls;
	}
}
