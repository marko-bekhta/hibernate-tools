package org.hibernate.tool.orm.jbt.api.wrp;

import org.hibernate.tool.orm.jbt.wrp.Wrapper;

public interface Cfg2HbmToolWrapper extends Wrapper {

	String getTag(PersistentClassWrapper pcw);
	String getTag(PropertyWrapper pw);

}