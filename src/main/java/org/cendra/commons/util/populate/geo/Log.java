package org.cendra.commons.util.populate.geo;

import java.util.ArrayList;
import java.util.List;

public class Log {

	public static String TYPE_ERROR = "ERROR";
	public static String TYPE_WARNING = "WARNING";
	public static String TYPE_INFO = "INFO";

	private String id;
	private String className;
	private List<String> atts = new ArrayList<String>();
	private String type;
	private String subject;
	private String msg;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<String> getAtts() {
		return atts;
	}

	public void setAtts(List<String> atts) {
		this.atts = atts;
	}

	public void addAtt(String att) {
		this.atts.add(att);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Log [id=" + id + ", className=" + className + ", atts=" + atts + ", type=" + type + ", subject="
				+ subject + ", msg=" + msg + "]";
	}

}
