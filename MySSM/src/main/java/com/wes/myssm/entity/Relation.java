package com.wes.myssm.entity;

public class Relation {
	private String noId;
	private String rtype;
	/**
	 * @return the noId
	 */
	public String getNoId() {
		return noId;
	}
	/**
	 * @param noId the noId to set
	 */
	public void setNoId(String noId) {
		this.noId = noId;
	}
	/**
	 * @return the rtype
	 */
	public String getRtype() {
		return rtype;
	}
	/**
	 * @param rtype the rtype to set
	 */
	public void setRtype(String rtype) {
		this.rtype = rtype;
	}
	@Override
	public String toString() {
		return "Relation [noId=" + noId + ", rtype=" + rtype + "]";
	}
	
}
